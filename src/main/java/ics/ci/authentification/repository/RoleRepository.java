package ics.ci.authentification.repository;

import ics.ci.authentification.entity.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoleRepository extends JpaRepository<AppRole, Long> {
   /* @Query("Select ur.appRole.roleName from " + UserRole.class.getName() + " ur " + " where ur.appUser.userId = :userId")
    List<String>getRoleNames(@Param("userId")Long userId);*/

   AppRole findByRoleId (Long id);
}
