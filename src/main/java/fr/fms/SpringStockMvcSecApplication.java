package fr.fms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.fms.dao.ArticleRepository;
import fr.fms.entities.Article;

@SpringBootApplication
public class SpringStockMvcSecApplication implements CommandLineRunner {
	@Autowired
	ArticleRepository articleRepository;
	public static void main(String[] args) {
		SpringApplication.run(SpringStockMvcSecApplication.class, args);
	}
	@Override
	public void run(String...args) throws Exception {
		articleRepository.save(new Article(null, "Samsung S8", 250));
		articleRepository.save(new Article(null, "Samsung S9", 300));
		articleRepository.save(new Article(null, "Iphone 10", 500));
		articleRepository.save(new Article(null, "Iphone 11", 625));
		articleRepository.save(new Article(null, "Iphone 14", 1250));
		articleRepository.save(new Article(null, "Nokia", 2));
		articleRepository.findAll().forEach(a -> System.out.println(a));
	}
}
