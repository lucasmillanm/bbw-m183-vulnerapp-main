package ch.bbw.m183.vulnerapp.service;

import java.util.stream.Stream;

import ch.bbw.m183.vulnerapp.datamodel.Role;
import ch.bbw.m183.vulnerapp.datamodel.UserEntity;
import ch.bbw.m183.vulnerapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AdminService {

	private final PasswordEncoder passwordEncoder;
	private final UserRepository userRepository;

	@PreAuthorize("hasRole('ADMIN')")
	public UserEntity createUser(UserEntity newUser) {
		newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
		newUser.setRole(Role.USER);
		return userRepository.save(newUser);
	}


	@PreAuthorize("hasRole('ADMIN')")
	public Page<UserEntity> getUsers(Pageable pageable) {
			return userRepository.loadUserWithoutPassword(pageable);
	}

	@PreAuthorize("hasRole('ADMIN')")
	public void deleteUser(String username) {
		userRepository.deleteById(username);
	}

	@EventListener(ContextRefreshedEvent.class)
	public void loadTestUsers() {
			Stream.of(new UserEntity().setUsername("admin").setFullname("Super Admin").setPassword("super5ecret").setRole(Role.ADMIN),
						new UserEntity().setUsername("fuu").setFullname("Johanna Doe").setPassword("bar").setRole(Role.USER))
				.forEach(this::createUser);
	}
}
