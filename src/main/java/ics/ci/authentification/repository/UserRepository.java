package ics.ci.authentification.repository;

import ics.ci.authentification.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUserName(String userName);
}
