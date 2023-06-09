package fr.fms.dao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.fms.entities.Article;
import fr.fms.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
//	Page<Category> findByIdContains(String name, Pageable pageable);	// Nommer les requêtes en fonction des attributs pour que spring sache où les chercher !

}