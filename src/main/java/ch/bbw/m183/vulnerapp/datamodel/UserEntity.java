package ch.bbw.m183.vulnerapp.datamodel;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "users")
public class UserEntity implements UserDetails {

	@Id
	@NotBlank(message = "username cannot be blank")
	@Size(min = 2, max = 32)
	String username;

	@Column
	@NotBlank(message = "fullname cannot be blank")
	@Size(min = 1, max = 32)
	String fullname;

	@Column
	@NotBlank(message = "password cannot be blank")
	@Size(min = 2, max = 128)
	String password;

	@Enumerated(EnumType.STRING)
	private Role role;

	@Override
	public String getUsername(){
		return username;
	}

	@Override
	public String getPassword(){
		return password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(role.name()));
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
