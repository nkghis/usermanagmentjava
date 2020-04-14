package ics.ci.authentification.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("enl")
public class Enlevement extends Operation  {

    /*@Column(name = "reference", length = 36, nullable = true)*/
    //private Integer estlivre;
    @Column(name = "enlevement_disponibilite", nullable = true)
    private Integer enlevementDispo;

    @Column(name = "est_gache", nullable = true)
    private Boolean estGache;

    @Column(name = "est_retour", nullable = true)
    private Boolean estRetour;

    @Column(name = "gache", nullable = true)
    private Integer gache;

    @ManyToOne
    @JoinColumn(name = "ressource_id")
    private Ressource ressource;

    @ManyToOne
    @JoinColumn(name = "motif_id")
    private Motif motif;

    @ManyToOne
    @JoinColumn(name = "entreposage_id")
    private Entreposage entreposage;

    public Enlevement(){
        super();
    }

    public Enlevement(String operation_ref, int operation_qte, LocalDateTime operation_date, boolean dispo_operation, Projet projet, /*Produit produit,*/ AppUser user, Integer enlevementDispo, Boolean estGache, Boolean estRetour, Integer gache, Ressource ressource, Motif motif, Entreposage entreposage) {
        super(operation_ref, operation_qte, operation_date, dispo_operation, projet, /*produit,*/ user);
        this.enlevementDispo = enlevementDispo;
        this.estGache = estGache;
        this.estRetour = estRetour;
        this.gache = gache;
        this.ressource = ressource;
        this.motif = motif;
        this.entreposage = entreposage;
    }

    public void setEnlevementDispo(Integer enlevementDispo) {
        this.enlevementDispo = enlevementDispo;
    }

    public Boolean getEstGache() {
        return estGache;
    }

    public void setEstGache(Boolean estGache) {
        this.estGache = estGache;
    }

    public Integer getGache() {
        return gache;
    }

    public void setGache(Integer gache) {
        this.gache = gache;
    }

    public Ressource getRessource() {
        return ressource;
    }

    public int getEnlevementDispo() {
        return enlevementDispo;
    }

    public void setEnlevementDispo(int livraisonDispo) {
        enlevementDispo = livraisonDispo;
    }

    public void setRessource(Ressource ressource) {
        this.ressource = ressource;
    }

    public Motif getMotif() {
        return motif;
    }

    public void setMotif(Motif motif) {
        this.motif = motif;
    }

    public Entreposage getEntreposage() {
        return entreposage;
    }

    public void setEntreposage(Entreposage entreposage) {
        this.entreposage = entreposage;
    }

    public Boolean getEstRetour() {
        return estRetour;
    }

    public void setEstRetour(Boolean estRetour) {
        this.estRetour = estRetour;
    }
}
