package ics.ci.authentification;


import ics.ci.authentification.entity.AppRole;
import ics.ci.authentification.entity.AppUser;
import ics.ci.authentification.entity.UserRole;
import ics.ci.authentification.repository.RoleRepository;
import ics.ci.authentification.repository.UserRepository;
import ics.ci.authentification.repository.UserRoleRepository;
import ics.ci.authentification.utils.EncrytedPasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.sql.DataSource;

@SpringBootApplication
public class AuthentificationApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(AuthentificationApplication.class, args);
		String p = "123";
		String password = EncrytedPasswordUtils.encrytePassword(p);

		System.out.println("===============DEBUT TRANSACTION=======================");
		UserRepository userRepository = context.getBean(UserRepository.class);
		AppUser user1 = userRepository.save(new AppUser("admin",password,true));
		AppUser user2 = userRepository.save(new AppUser("user",password,true));
		System.out.println("===============AJOUT CLIENT=======================");
		userRepository.findAll().forEach(u->System.out.println(u.getUserName()));
		System.out.println("Utilisateurs ajoutés avec succes");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("===============AJOUT ROLE=======================");
		RoleRepository roleRepository = context.getBean(RoleRepository.class);
		AppRole roleadmin = roleRepository.save(new AppRole("ROLE_ADMIN"));
		AppRole roleuser = roleRepository.save(new AppRole("ROLE_USER"));
		roleRepository.findAll().forEach(u->System.out.println(u.getRoleName()));
		System.out.println("Roles ajoutés avec succes");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");

		System.out.println("===============AFFECTATION ROLE PAR USER=======================");
		UserRoleRepository userRoleRepository = context.getBean(UserRoleRepository.class);
		userRoleRepository.save(new UserRole(user1,roleadmin));
		userRoleRepository.save(new UserRole(user1,roleuser));
		userRoleRepository.save(new UserRole(user2,roleuser));
		//userRoleRepository.findAll().forEach(u->System.out.println(u.getAppUser().getUserName()+" -> "+u.getAppRole().getRoleName()));
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&FIN DE LA TRANSACTION&&&&&&&&&&&&&&&&&&&");






	}


}
