package org.example.services;

import fr.diginamic.entities.Emprunt;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EmpruntService {

    private EntityManagerFactory emf;

    public EmpruntService() {
        this.emf = Persistence.createEntityManagerFactory("bibliotheque-pu");
    }

    public Emprunt findEmpruntById(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            Emprunt emprunt = em.find(Emprunt.class, id);
            if (emprunt != null) {
                System.out.println("Emprunt trouvé avec l'id : " + emprunt.getId());
                System.out.println("Date de début : " + emprunt.getDateDebut());
                System.out.println("Délai max : " + emprunt.getDelaiMax());
                System.out.println("Date de fin : " + emprunt.getDateFin());
                System.out.println("Livres associés :");
                emprunt.getLivres().forEach(livre ->
                        System.out.println(" - Titre : " + livre.getTitre() + ", Auteur : " + livre.getAuteur())
                );
            } else {
                System.out.println("Emprunt non trouvé.");
            }
            return emprunt;
        } finally {
            em.close();
        }
    }

    public static void main(String[] args) {
        EmpruntService service = new EmpruntService();
        service.findEmpruntById(1L); // Remplacez 1L par l'ID que vous souhaitez tester
    }
}