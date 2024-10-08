package fr.diginamic.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "EMPRUNT")
public class Emprunt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "DATE_DEBUT", nullable = false)
    private LocalDate dateDebut;

    @Column(name = "DELAI_MAX", nullable = false)
    private Integer delaiMax;

    @Column(name = "DATE_FIN")
    private LocalDate dateFin;

    // Relation ManyToOne avec l'entité Client (un client peut avoir plusieurs emprunts)
    // La colonne 'ID_CLIENT' dans la table 'EMPRUNT' fait référence à l'identifiant du client
    @ManyToOne
    @JoinColumn(name = "ID_CLIENT")
    private Client client;

    // Relation ManyToMany avec l'entité Livre (un emprunt peut concerner plusieurs livres)
    // La table d'association 'COMPO' relie 'ID_EMPRUNT' (dans EMPRUNT) et 'ID_LIVRE' (dans LIVRE)
    @ManyToMany
    @JoinTable(
            name = "COMPO",
            joinColumns = @JoinColumn(name = "ID_EMPRUNT"),
            inverseJoinColumns = @JoinColumn(name = "ID_LIVRE")
    )
    private Set<Livre> livres = new HashSet<>();

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Integer getDelaiMax() {
        return delaiMax;
    }

    public void setDelaiMax(Integer delaiMax) {
        this.delaiMax = delaiMax;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Set<Livre> getLivres() {
        return livres;
    }

    public void setLivres(Set<Livre> livres) {
        this.livres = livres;
    }
}