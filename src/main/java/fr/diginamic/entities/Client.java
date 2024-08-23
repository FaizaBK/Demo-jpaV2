package fr.diginamic.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CLIENT")
public class Client {

    @Id
    // Génération automatique de la valeur de l'identifiant (auto-incrémentée par la base de données)
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    // Mappage de l'attribut 'id' à la colonne 'ID' de la table correspondante
    @Column(name = "ID")
    private Long id;

    // Mappage de l'attribut 'nom' à la colonne 'NOM' de la table, avec une contrainte de non-nullité
    @Column(name = "NOM", nullable = false)
    private String nom;

    // Mappage de l'attribut 'prenom' à la colonne 'PRENOM' de la table, avec une contrainte de non-nullité
    @Column(name = "PRENOM", nullable = false)
    private String prenom;

    // Relation OneToMany avec l'entité 'Emprunt'.
    @OneToMany(mappedBy = "client")
    private Set<Emprunt> emprunts = new HashSet<>();

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Set<Emprunt> getEmprunts() {
        return emprunts;
    }

    public void setEmprunts(Set<Emprunt> emprunts) {
        this.emprunts = emprunts;
    }
}