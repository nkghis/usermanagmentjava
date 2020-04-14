package ics.ci.authentification.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Entreposages")
public class Entreposage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entreposage_id")
    private Long entreposageId;

    @Column(name = "entreposage_reference", length = 36, unique = true)
    private String entreposageReference;

    @Column(name = "entreposage_date")
    private LocalDateTime entreposageDate;

    @Column(name = "quantite_verse")
    private int qteVerse;

    @Column(name = "quantite_restante")
    private int qteRestante;

    @Column(name = "est_livrable")
    private Boolean estLivrable;

    @ManyToOne
    @JoinColumn(name = "operationId")
    private Reception reception;

    @ManyToOne
    @JoinColumn(name = "entrepotId")
    private Entrepot entrepot;

    @ManyToOne
    @JoinColumn(name = "appuserId")
    private AppUser user;

    public Entreposage() {
        super();
    }

    public Entreposage(String entreposageReference, LocalDateTime entreposageDate, int qteVerse, int qteRestante, Boolean estLivrable, Reception reception, Entrepot entrepot, AppUser user) {
        this.entreposageReference = entreposageReference;
        this.entreposageDate = entreposageDate;
        this.qteVerse = qteVerse;
        this.qteRestante = qteRestante;
        this.estLivrable = estLivrable;
        this.reception = reception;
        this.entrepot = entrepot;
        this.user = user;
    }

    public Long getEntreposageId() {
        return entreposageId;
    }

    public void setEntreposageId(Long entreposageId) {
        this.entreposageId = entreposageId;
    }

    public String getEntreposageReference() {
        return entreposageReference;
    }

    public void setEntreposageReference(String entreposageReference) {
        this.entreposageReference = entreposageReference;
    }

    public LocalDateTime getEntreposageDate() {
        return entreposageDate;
    }

    public void setEntreposageDate(LocalDateTime entreposageDate) {
        this.entreposageDate = entreposageDate;
    }

    public int getQteVerse() {
        return qteVerse;
    }

    public void setQteVerse(int qteVerse) {
        this.qteVerse = qteVerse;
    }

    public int getQteRestante() {
        return qteRestante;
    }

    public void setQteRestante(int qteRestante) {
        this.qteRestante = qteRestante;
    }

    public Boolean getEstLivrable() {
        return estLivrable;
    }

    public void setEstLivrable(Boolean estLivrable) {
        this.estLivrable = estLivrable;
    }

    public Reception getReception() {
        return reception;
    }

    public void setReception(Reception reception) {
        this.reception = reception;
    }

    public Entrepot getEntrepot() {
        return entrepot;
    }

    public void setEntrepot(Entrepot entrepot) {
        this.entrepot = entrepot;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }
}
