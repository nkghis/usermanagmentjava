package ics.ci.mutuelle.repository;

import ics.ci.mutuelle.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}
