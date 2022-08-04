package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        // create EntityManager
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // access transaction object
        EntityTransaction transaction = entityManager.getTransaction();

        Game game1 = new Game();
        Game game2 = new Game();

        game1.setTitle("Spider-Man Remastered");
        game1.setGenre("Single-Player Story");
        game1.setPlatform("PS5");
        game1.setPrice(55);
        game1.setCreated_at(LocalDateTime.now());

        game2.setTitle("God of War");
        game2.setGenre("Single-Player Story");
        game2.setPlatform("PS5 & PS4");
        game2.setPrice(70);
        game2.setCreated_at(LocalDateTime.now());

        Review review1 = new Review();
        Review review2 = new Review();
        Review review3 = new Review();

        review1.setGame(game1);
        review1.setScore(10);
        review1.setComment("INCREDIBLE GAME");
        review1.setCreated_at(LocalDateTime.now());
        review1.setUpdated_at(LocalDateTime.now());
        game1.setUpdated_at(LocalDateTime.now());

        review2.setGame(game1);
        review2.setScore(10);
        review2.setComment("INCREDIBLE GAME");
        review2.setCreated_at(LocalDateTime.now());
        review2.setUpdated_at(LocalDateTime.now());
        game1.setUpdated_at(LocalDateTime.now());

        review3.setGame(game2);
        review3.setScore(9);
        review3.setComment("Worth every second");
        review3.setCreated_at(LocalDateTime.now());
        review3.setUpdated_at(LocalDateTime.now());
        game2.setUpdated_at(LocalDateTime.now());

        transaction.begin();
        entityManager.persist(game1);
        entityManager.persist(game2);
        entityManager.persist(review1);
        entityManager.persist(review2);
        entityManager.persist(review3);

        transaction.commit();

        // close entity manager
        entityManager.close();
        entityManagerFactory.close();
    }
}