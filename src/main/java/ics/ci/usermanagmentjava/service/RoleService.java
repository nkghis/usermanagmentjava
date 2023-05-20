package ics.ci.usermanagmentjava.service;

import ics.ci.usermanagmentjava.dto.RoleDTO;
import ics.ci.usermanagmentjava.entity.AppUser;

import ics.ci.usermanagmentjava.entity.AppRole;

import java.util.List;

public interface RoleService {

    AppRole create (AppRole role);
    AppRole findByRoleName (String roleName);
    List<AppRole> all();
    List<AppRole> allSortByRoleProperty(String roleProperty);
    List<AppRole> findByRoleNameIsNot(String roleName);
    AppRole getById(Long id);
    Boolean deleteById (Long id);

    List<AppRole> getRolesByUser(AppUser user);
    List<String> getRoleNames (List<AppRole> roles);

    RoleDTO roleToDTO(AppRole role);
}
