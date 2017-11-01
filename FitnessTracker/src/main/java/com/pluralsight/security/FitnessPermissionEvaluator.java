package com.pluralsight.security;

import java.io.Serializable;
import java.util.StringJoiner;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;

public class FitnessPermissionEvaluator implements PermissionEvaluator {
	
	private DataSource datasource;

	public DataSource getDatasource() {
		return datasource;
	}

	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;
	}

	@Override
	public boolean hasPermission(Authentication auth, Object targetDomain, Object permission) {
		
		JdbcTemplate template = new JdbcTemplate(datasource);
		
		Object[] args = {((User)auth.getPrincipal()).getUsername(),
				targetDomain.getClass().getName(),
				permission.toString()};
		
		StringJoiner sql = new StringJoiner(" ");
		sql.add("select count(*) from permissions p");
		sql.add("where p.username = ?");
		sql.add("and p.target = ?");
		sql.add("and p.permission = ?");
		
		int count = template.queryForObject(sql.toString(), args, Integer.class);
		
		return count == 1 ? true : false;
	}

	@Override
	public boolean hasPermission(Authentication auth, Serializable id, String type, Object permission) {
		// TODO Auto-generated method stub
		return false;
	}

}
