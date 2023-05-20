package ics.ci.usermanagmentjava.service;

import ics.ci.usermanagmentjava.dto.UserDTO;
import ics.ci.usermanagmentjava.entity.AppUser;

import java.util.List;

public interface UserService {

    AppUser create(AppUser user);

    List<AppUser> all();

    List<AppUser> allSortByRoleProperty(String roleProperty);

    List<AppUser> getUserListWithRoleInString(List<AppUser> Users);

    AppUser findByUserName(String userName);

    Boolean existsByUserName(String userName);

    Boolean hasRole(AppUser user, String roleName);

    UserDTO userToDto(AppUser user);
}
