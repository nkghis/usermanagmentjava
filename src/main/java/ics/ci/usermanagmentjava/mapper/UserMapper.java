package ics.ci.usermanagmentjava.mapper;

import ics.ci.usermanagmentjava.dto.UserDTO;
import ics.ci.usermanagmentjava.entity.AppUser;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO userToUserDTO(AppUser user);
}
