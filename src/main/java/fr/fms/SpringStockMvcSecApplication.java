package fr.fms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.fms.dao.ArticleRepository;
import fr.fms.dao.CategoryRepository;
import fr.fms.entities.Article;
import fr.fms.entities.Category;

@SpringBootApplication
public class SpringStockMvcSecApplication implements CommandLineRunner {
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	ArticleRepository articleRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringStockMvcSecApplication.class, args);
	}
	@Override
	public void run(String...args) throws Exception {
//		Category phone = categoryRepository.save(new Category(null, "Phone", null)); // Le 1er null conrrespond à l'ID, le 2e null correspond à collection<Article> qui contient les articles.
//		Category iphone = categoryRepository.save(new Category(null, "Iphone", null));
//		Category hardware = categoryRepository.save(new Category(null, "Hardware", null));
//		Category other = categoryRepository.save(new Category(null, "Other", null));
//		categoryRepository.save(new Category(null, "Phone", null));
//		categoryRepository.save(new Category(null, "Iphone", null));
//		categoryRepository.save(new Category(null, "Hardware", null));
//		categoryRepository.save(new Category(null, "Other", null));		
//		articleRepository.save(new Article(null, "Samsung S8", 250.0, phone));
//		articleRepository.save(new Article(null, "Samsung S9", 300.0, phone));
//		articleRepository.save(new Article(null, "Iphone 10", 500.0, iphone));
//		articleRepository.save(new Article(null, "Iphone 11", 625.0, iphone));
//		articleRepository.save(new Article(null, "Iphone 14", 1250.0, iphone));
//		articleRepository.save(new Article(null, "Nokia 3310", 52.0, phone));
//		articleRepository.save(new Article(null, "Ordi portable", 150.0, hardware));
//		articleRepository.save(new Article(null, "Camera GoPro", 400.0, hardware));
//		articleRepository.save(new Article(null, "Bouteille de champagne", 69.0, other));		
//		articleRepository.save(new Article(null, "Intel Core I7", 349.0, hardware));
//		articleRepository.save(new Article(null, "Intel Core I9", 999.0, hardware));
		
		//articleRepository.findAll().forEach(a -> System.out.println(a));
	}
}
