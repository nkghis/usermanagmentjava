package ics.ci.authentification.controller;

import ics.ci.authentification.entity.*;
import ics.ci.authentification.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class GacheController {

    @Autowired
    private TypegacheRepository typegacheRepository;

    @Autowired
    private VenlevementGacheRepository venlevementGacheRepository;

    @Autowired
    private EnlevementRepository enlevementRepository;

    @Autowired
    private GacheRepository gacheRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StockRepository stockRepository;

    //Affiche un formulaire de Gache.
    @RequestMapping(value = "/admin/gaches/{id}", method = RequestMethod.GET)
    public String newGache(@PathVariable Long id, Model model) {

        List<Typegache> typegaches = typegacheRepository.findAll();
        Enlevement enlevement = enlevementRepository.getOne(id);

        model.addAttribute("typegaches", typegaches);
        model.addAttribute("enlevement", enlevement);
        model.addAttribute("magache", new Gache());
        model.addAttribute("title", "  Gache - Attribution");

        return "gache/new";

    }

    //Attribuer Gache
    @RequestMapping(value = "/admin/gaches/save", method = RequestMethod.POST)
    public String attribuerGache(@Valid Gache gache, BindingResult bindingResult, Model model, Principal principal, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError());
            return "redirect:/admin/livraisons";
        }

        //Get id distribuer since form
        String d = request.getParameter("enlevement");

        //Parse String to Long
        Long livraisonId = Long.parseLong(d);

        //Get enlevement
        Enlevement enlevement = enlevementRepository.getOne(livraisonId);

        //Get Local date Time
        LocalDateTime date = LocalDateTime.now();

        //Get User AUth
        AppUser user = userRepository.findByUserName(principal.getName());

        //persistence de gache
        gache.setGacheDate(date);
        gache.setOperation(enlevement);
        gache.setUser(user);
        gacheRepository.save(gache);

        /*//Mise à jour de la table stock.

        Produit produit = enlevement.getProduit();
        Projet projet = enlevement.getProjet();
        Entrepot entrepot = enlevement.getEntreposage().getEntrepot();

        //Recherche dans la table stock en fonction de produit, projet, entrepot
        Stock stock = stockRepository.findByProduitAndAndProjetAndEntrepot(produit, projet, entrepot);

        //Get quantite restante stock
        int quantite = stock.getStockQuantite() - gache.getGacheQte();

        //Persistence de la table stock
        stock.setUser(user);
        stock.setStockDate(date);
        stock.setStockQuantite(quantite);
        stockRepository.save(stock);*/

        //Mise a jour du champs "est_gache" de la table "enlevement" qui hertite de la table "operation".

        enlevement.setEstGache(true);
        enlevementRepository.save(enlevement);

        //Notification et redirection
        redirectAttributes.addFlashAttribute("messagegache","Attribution de gache éffectée avec succès");
        return "redirect:/admin/receptions/new";
    }

    //Liste des stock livrer en Json
    @RequestMapping(value = "/admin/gaches")
    @ResponseBody
    public List<VenlevementGache> LivrerJson(Model model){

        return venlevementGacheRepository.findAll();
    }
}
