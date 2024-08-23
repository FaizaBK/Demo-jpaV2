package fr.diginamic.services;

import fr.diginamic.entities.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class LivreService {

    //Factory pour la création d'EntityManager, utilisé pour interagir avec la base de données
    private EntityManagerFactory emf;

    public LivreService() {
        this.emf = Persistence.createEntityManagerFactory("bibliotheque-pu");
    }

    // Méthode pour trouver un livre par son identifiant (ID)
    public Livre findLivreById(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Livre.class, id);
        } finally {
            em.close();
        }
    }

    // Méthode principale pour tester la fonction findLivreById avec un ID spécifique
    public static void main(String[] args) {
        LivreService service = new LivreService();

        // Appel de la méthode findLivreById avec l'ID du livre (1L dans cet exemple)
        Livre livre = service.findLivreById(1L);

        // Vérification si le livre a été trouvé et affichage des résultats
        if (livre != null) {
            System.out.println("Livre trouvé avec l'id : " + livre.getId());
        } else {
            System.out.println("Livre non trouvé.");
        }
    }
}