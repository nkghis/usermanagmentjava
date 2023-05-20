package ics.ci.usermanagmentjava.service.impl;

import ics.ci.usermanagmentjava.dto.UserDTO;
import ics.ci.usermanagmentjava.entity.AppRole;
import ics.ci.usermanagmentjava.entity.AppUser;
import ics.ci.usermanagmentjava.mapper.UserMapper;
import ics.ci.usermanagmentjava.repository.UserRepository;
import ics.ci.usermanagmentjava.service.RoleService;
import ics.ci.usermanagmentjava.service.UserService;
import ics.ci.usermanagmentjava.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
@Slf4j
/*@RequiredArgsConstructor*/
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleService roleService;

    //for use you have to mvn clean and build project if property underline in red
    private final UserMapper userMapper ;



    public UserServiceImpl(UserRepository userRepository, RoleService roleService, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.userMapper = userMapper;
    }



    @Override
    public AppUser create(AppUser user) {
        log.info("User added : " +user.getUserName().toUpperCase());
        return userRepository.save(user);
    }

    @Override
    public List<AppUser> all() {
        return userRepository.findAll();
    }

    @Override
    public List<AppUser> allSortByRoleProperty(String roleProperty) {
        return userRepository.findAll(Sort.by(Sort.Direction.DESC,roleProperty));
    }

    @Override
    public List<AppUser> getUserListWithRoleInString(List<AppUser> Users) {
        //Init Collection
        Collection<AppRole> appRoles;
        for (AppUser u : Users){
            //Get roles for a user
            appRoles = u.getRoles();
            //ini array list
            ArrayList<String> arrayList = new ArrayList<>();

            for (AppRole a : appRoles){
                // Get User Role Name
                String s = a.getRoleName();

                //Add in list array
                arrayList.add(s);
            }

            // Convert Array to string without bracket
            String role = Arrays.toString(arrayList.toArray()).replace("[", "").replace("]", "");

            //Set String to mesroles;
            u.setMesroles(role);
        }

        return Users;
    }

    @Override
    public AppUser findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public Boolean existsByUserName(String userName) {
       return userRepository.existsByUserName(userName);
    }

    @Override
    public Boolean hasRole(AppUser user, String roleName) {
        List<AppRole> roles = roleService.getRolesByUser(user);
        List<String> stringRoles = new ArrayList<String>();
        for (AppRole r : roles){
            String rname = r.getRoleName();
            stringRoles.add(rname);
        }
        Boolean role = false;
        Boolean roleContain = stringRoles.contains(roleName);
        if (roleContain){
            role = true;
        }else {
            role = false;
        }

        return role;
    }

    @Override
    public UserDTO userToDto(AppUser user) {


        return userMapper.userToUserDTO(user);
        //return UserMapper.INSTANCE.userToUserDTO(user);
    }
}
