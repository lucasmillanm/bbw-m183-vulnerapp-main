package ch.bbw.m183.vulnerapp.controller;

import ch.bbw.m183.vulnerapp.datamodel.UserEntity;
import ch.bbw.m183.vulnerapp.service.AdminService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin123")
@RequiredArgsConstructor
public class AdminController {

	private final AdminService adminService;

	@PostMapping("/create")
	public UserEntity createUser(@Valid @RequestBody UserEntity newUser) {
		return adminService.createUser(newUser);
	}

	@GetMapping("/users")
	public Page<UserEntity> getUsers(Pageable pageable) {
		return adminService.getUsers(pageable);
	}

	@GetMapping("/delete/{username}")
	public void deleteUser(
			@PathVariable String username
	) {
		adminService.deleteUser(username);
	}
}
