package ch.bbw.m183.vulnerapp.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

import ch.bbw.m183.vulnerapp.datamodel.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
  Optional<UserEntity> findByUsername(String username);

  @Query("SELECT u.username, u.fullname, u.role FROM UserEntity u")
  Page<UserEntity> loadUserWithoutPassword(Pageable pageable);
}
