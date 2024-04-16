package net.codejava;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class userRepositoryTests {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private UserRepository repo;
	
	@Test
	public void testCreateUser() {
		User User = new User();
		User.setEmail("ravikumar@gmail.com");
		User.setPassword("ravi2020");
		User.setFirstName("Ravi");
		User.setLastName("Kumar");
		
		User savedUser = repo.save(User);
		
		User existUser = entityManager.find(User.class, savedUser.getId());
		
		assertThat(User.getEmail()).isEqualTo(existUser.getEmail());
		
	}
	
	@Test
	public void testFindByEmail() {
		String email = "nam@codejava.net";
		User User = (net.codejava.User) repo.findByEmail(email);
		
		assertThat(User.getEmail()).isEqualTo(email);
	}
}
