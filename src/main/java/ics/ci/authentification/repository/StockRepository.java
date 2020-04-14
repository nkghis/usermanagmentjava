package ics.ci.authentification.repository;

import ics.ci.authentification.entity.Entrepot;
import ics.ci.authentification.entity.Produit;
import ics.ci.authentification.entity.Projet;
import ics.ci.authentification.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {

    //Stock findByProduitAndAndProjetAndEntrepot(Produit produit, Projet projet, Entrepot entrepot);
    Stock findByProjetAndEntrepot(Projet projet, Entrepot entrepot);
}
