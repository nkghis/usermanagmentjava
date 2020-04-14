package ics.ci.authentification.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Entity
@Table(name = "entrepots")
public class Entrepot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entrepot_id")
    private Long entrepotId;

    @Column(name = "entrepot_nom")
    @NotNull
    private String entrepotNom;


    @OneToMany(mappedBy = "entrepot", fetch = FetchType.LAZY)
    private Collection<Entreposage> entreposages;

    public Entrepot() {
        super();
    }

    public Entrepot(@NotNull String entrepotNom) {
        this.entrepotNom = entrepotNom;
    }

    public Entrepot(@NotNull String entrepotNom, Collection<Entreposage> entreposages) {
        this.entrepotNom = entrepotNom;
        this.entreposages = entreposages;
    }

    public Long getEntrepotId() {
        return entrepotId;
    }

    public void setEntrepotId(Long entrepotId) {
        this.entrepotId = entrepotId;
    }

    public String getEntrepotNom() {
        return entrepotNom;
    }

    public void setEntrepotNom(String entrepotNom) {
        this.entrepotNom = entrepotNom;
    }

    public Collection<Entreposage> getEntreposages() {
        return entreposages;
    }

    public void setEntreposages(Collection<Entreposage> entreposages) {
        this.entreposages = entreposages;
    }
}
