package fr.diginamic.services;

import fr.diginamic.entities.Emprunt;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EmpruntService {

    // Factory pour la création d'EntityManager pour interagir avec la base de données
    private EntityManagerFactory emf;

    public EmpruntService() {
        this.emf = Persistence.createEntityManagerFactory("bibliotheque-pu");
    }

    // Méthode pour trouver un emprunt par son identifiant (ID)
    public Emprunt findEmpruntById(Long id) {

        // Création d'un EntityManager pour exécuter les opérations de requêtes sur la base de données
        EntityManager em = emf.createEntityManager();
        try {

            // Recherche de l'emprunt par son ID dans la base de données
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

    // Méthode principale pour tester la fonction findEmpruntById avec un ID spécifique
    public static void main(String[] args) {

        EmpruntService service = new EmpruntService();
        // Appel de la méthode findEmpruntById avec l'ID de l'emprunt (example:1L par l'ID )
        service.findEmpruntById(1L);
    }
}