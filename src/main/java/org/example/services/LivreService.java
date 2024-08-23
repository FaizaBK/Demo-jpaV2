package org.example.services;

import fr.diginamic.entities.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class LivreService {

    private EntityManagerFactory emf;

    public LivreService() {
        this.emf = Persistence.createEntityManagerFactory("bibliotheque-pu");
    }

    public Livre findLivreById(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Livre.class, id);
        } finally {
            em.close();
        }
    }

    public static void main(String[] args) {
        LivreService service = new LivreService();
        Livre livre = service.findLivreById(1L);
        if (livre != null) {
            System.out.println("Livre trouvé avec l'id : " + livre.getId());
        } else {
            System.out.println("Livre non trouvé.");
        }
    }
}