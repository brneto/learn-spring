package com.boot;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.util.StringJoiner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class ShipwreckControllerWebIntegrationTest {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int port;
	
	private StringJoiner jsonStringJoiner = new StringJoiner(",");
	
	@Test
	public void testListAll() throws IOException {
		String restUrl = String.format("http://localhost:%d/api/v1/shipwrecks", port);
		
		ResponseEntity<String> response = restTemplate.getForEntity(restUrl, String.class);
		
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
		
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode responseJson = objectMapper.readTree(response.getBody());
		
		assertThat(responseJson.isMissingNode(), equalTo(false));
		
		jsonStringJoiner
			.add("[{\"id\":1,\"name\":\"U869\",\"description\":\"A very deep German UBoat\"")
			.add("\"condition\":\"FAIR\",\"depth\":200,\"latitude\":44.12,\"longitude\":138.44,\"yearDiscovered\":1994}")
			.add("{\"id\":2,\"name\":\"Thistlegorm\",\"description\":\"British merchant boat in the Red Sea\"")
			.add("\"condition\":\"GOOD\",\"depth\":80,\"latitude\":44.12,\"longitude\":138.44,\"yearDiscovered\":1994}")
			.add("{\"id\":3,\"name\":\"S.S. Yongala\",\"description\":\"A luxury passenger ship wrecked on the great barrier reef\"")
			.add("\"condition\":\"FAIR\",\"depth\":50,\"latitude\":44.12,\"longitude\":138.44,\"yearDiscovered\":1994}]");
		assertThat(responseJson.toString(), equalTo(jsonStringJoiner.toString()));
	}

}
