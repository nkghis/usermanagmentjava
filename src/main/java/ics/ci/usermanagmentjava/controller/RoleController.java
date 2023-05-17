package ics.ci.usermanagmentjava.controller;

import ics.ci.usermanagmentjava.entity.AppRole;
import ics.ci.usermanagmentjava.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @RequestMapping(value = "/admin/roles")
    public String indexRole(Model model){

        List<AppRole> roles = roleRepository.findAll(Sort.by(Sort.Direction.DESC,"roleId"));
        model.addAttribute("listroles",roles);
        model.addAttribute("title", "Rôle - Liste");
        return "role/index";
    }

    @RequestMapping(value = "/admin/roles/new", method = RequestMethod.GET)
    public String newRole(Model model){

        model.addAttribute("monrole",new AppRole());
        model.addAttribute("title", "Rôle - Nouveau");
        return "role/new";

    }

    @RequestMapping(value = "/admin/roles/save", method = RequestMethod.POST)
    public String saveRole(@Valid AppRole role, Errors errors, Model model, RedirectAttributes redirectAttributes){

        if (errors.hasErrors()){
            System.out.println("error YES");
            model.addAttribute("monrole", new AppRole());
            //model.addAttribute("errors", errors);
            return "role/new";
        }
        roleRepository.save(role);
        redirectAttributes.addFlashAttribute("messagesucces","Opération éffectée avec succès");
        return "redirect:/admin/roles";
    }

    @RequestMapping(value = "/admin/roles/edit/{id}", method = RequestMethod.GET)
    public String editRole(@PathVariable Long id, Model model){

        AppRole r = roleRepository.getOne(id);

        model.addAttribute("role", r);
        model.addAttribute("title", "Rôle - Edition");
        return "role/edit";
    }

    @RequestMapping(value = "/admin/roles/delete/{id}", method = RequestMethod.GET)
    public String deleteRole(@PathVariable Long id){

        roleRepository.deleteById(id);
        return "redirect:/admin/roles";
    }

}
