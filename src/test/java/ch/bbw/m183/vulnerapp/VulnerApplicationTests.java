package ch.bbw.m183.vulnerapp;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

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

}
