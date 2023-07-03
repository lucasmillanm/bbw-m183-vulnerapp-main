package ch.bbw.m183.vulnerapp;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import ch.bbw.m183.vulnerapp.datamodel.Role;
import ch.bbw.m183.vulnerapp.datamodel.UserEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class VulnerApplicationTests implements WithAssertions {
	@Autowired
	WebTestClient webTestClient;
	@Test
	void blogsArePublic() {
		webTestClient.get().uri("/api/blog")
				.exchange()
				.expectStatus().isOk();
	}

	@Test
	void createUser_ReturnsCreatedUser() {
		UserEntity newUser = new UserEntity();
		newUser.setUsername("testUser");
		newUser.setPassword("testPassword");
		newUser.setRole(Role.USER);

		webTestClient.post().uri("/api/admin123/create")
				.contentType(MediaType.APPLICATION_JSON)
				.bodyValue(newUser)
				.exchange()
				.expectStatus().isOk()
				.expectBody(UserEntity.class)
				.value(user -> {
					// Assert the properties of the created user
					assertThat(user.getUsername()).isEqualTo("testUser");
					assertThat(user.getPassword()).isEqualTo("testPassword");
				});
	}

	@Test
	void getUsers_ReturnsListOfUsers() {
		webTestClient.get().uri("/api/admin123/users")
				.exchange()
				.expectStatus().isOk()
				.expectBodyList(UserEntity.class)
				.value(users -> {
					assertThat(users).isNotEmpty();
				});
	}

	@Test
	void deleteUser_DeletesUser() {
		String username = "testUser";

		webTestClient.delete().uri("/api/admin123/delete/{username}", username)
				.exchange()
				.expectStatus().isOk();
	}

}
