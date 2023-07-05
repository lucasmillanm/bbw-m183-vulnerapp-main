package ch.bbw.m183.vulnerapp;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

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
		newUser.setFullname("testName");
		newUser.setPassword("testPassword");
		newUser.setRole(Role.USER);

		webTestClient.post().uri("/api/admin123/create")
				.contentType(MediaType.APPLICATION_JSON)
				.bodyValue(newUser)
				.header("Authorization", this.generateBasicAuthHeader("admin","super5ecret"))
				.exchange()
				.expectStatus().isOk()
				.expectBody(UserEntity.class)
				.value(user -> {
					assertThat(user.getUsername()).isEqualTo(newUser.getUsername());
				});
	}

	@Test
	void getUsers_ReturnsListOfUsers() {
		webTestClient.get().uri("/api/admin123/users")
				.header("Authorization", this.generateBasicAuthHeader("admin","super5ecret"))
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
				.header("Authorization", this.generateBasicAuthHeader("admin","super5ecret"))
				.exchange()
				.expectStatus().isOk();
	}

	public String generateBasicAuthHeader(String username, String password) {
		String credentials = username + ":" + password;
		byte[] credentialsBytes = credentials.getBytes(StandardCharsets.UTF_8);
		String encodedCredentials = Base64.getEncoder().encodeToString(credentialsBytes);
		return "Basic " + encodedCredentials;
	}

}
