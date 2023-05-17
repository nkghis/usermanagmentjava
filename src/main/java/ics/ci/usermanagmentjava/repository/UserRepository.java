package ics.ci.usermanagmentjava.repository;

import ics.ci.usermanagmentjava.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUserName(String userName);

    //Boolean existsByUserName(String userName);

}
