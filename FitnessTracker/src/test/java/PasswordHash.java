import org.junit.jupiter.api.Test;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

class PasswordHash {

	@Test
	void test() {
		
		String password = "secret";
		Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();
		String hashedPassword = passwordEncoder.encodePassword(password, null);
		
		System.out.println(hashedPassword);
		//fail("Not yet implemented");
	}

}
