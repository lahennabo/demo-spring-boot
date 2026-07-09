package com.example.demo;

import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepository; // Assurez-vous d'avoir ce repository
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        System.out.println(">>> demo-application fin de compilation >>>");
    }

    @Bean
    public CommandLineRunner dataLoader(CategoryRepository categoryRepository) {
        return args -> {
            // Création de la première catégorie
            Category cat1 = new Category();
            cat1.setName("Électronique");
            cat1.setDescription("Smartphones, ordinateurs et accessoires");
            categoryRepository.save(cat1);

            // Création de la deuxième catégorie
            Category cat2 = new Category();
            cat2.setName("Livres");
            cat2.setDescription("Romans, sciences et bandes dessinées");
            categoryRepository.save(cat2);

            System.out.println(">>> Données de test insérées avec succès ! >>>");
        };
    }
}

