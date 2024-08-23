package fr.diginamic.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "LIVRE")
public class Livre {

    // Identifiant unique du livre
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    // Titre du livre
    @Column(name = "TITRE")
    private String titre;

    // Auteur du livre
    @Column(name = "AUTEUR")
    private String auteur;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }
}