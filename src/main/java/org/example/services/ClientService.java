package org.example.services;

import fr.diginamic.entities.Emprunt;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class ClientService {

    private EntityManagerFactory emf;

    public ClientService() {
        this.emf = Persistence.createEntityManagerFactory("bibliotheque-pu");
    }

    public List<Emprunt> findEmpruntsByClientId(Long clientId) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Emprunt> query = em.createQuery(
                    "SELECT e FROM Emprunt e WHERE e.client.id = :clientId", Emprunt.class
            );
            query.setParameter("clientId", clientId);
            List<Emprunt> emprunts = query.getResultList();
            System.out.println("Emprunts pour le client avec l'id : " + clientId);
            emprunts.forEach(emprunt -> {
                System.out.println("Emprunt ID : " + emprunt.getId());
                System.out.println("Date de début : " + emprunt.getDateDebut());
                System.out.println("Délai max : " + emprunt.getDelaiMax());
                System.out.println("Date de fin : " + emprunt.getDateFin());
                emprunt.getLivres().forEach(livre ->
                        System.out.println(" - Titre : " + livre.getTitre() + ", Auteur : " + livre.getAuteur())
                );
            });
            return emprunts;
        } finally {
            em.close();
        }
    }

    public static void main(String[] args) {
        ClientService service = new ClientService();
        service.findEmpruntsByClientId(1L); // Remplacez 1L par l'ID du client que vous souhaitez tester
    }
}