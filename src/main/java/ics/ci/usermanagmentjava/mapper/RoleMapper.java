package ics.ci.usermanagmentjava.mapper;

import ics.ci.usermanagmentjava.dto.RoleDTO;
import ics.ci.usermanagmentjava.entity.AppRole;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleDTO roleToRoleDTO(AppRole role);
}
