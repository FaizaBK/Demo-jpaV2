package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnexionJpa {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            // Créer une instance d'EntityManagerFactory
            entityManagerFactory = Persistence.createEntityManagerFactory("demo-jpa");

            // Créer une instance d'EntityManager
            entityManager = entityManagerFactory.createEntityManager();

            // Vérifier la connexion
            System.out.println("Connexion à la base de données réussie!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
    }
}