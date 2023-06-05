package fr.fms.web;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.fms.dao.ArticleRepository;
import fr.fms.dao.CategoryRepository;
import fr.fms.entities.Article;
import fr.fms.entities.Category;

@Controller
public class CategoryController {
	@Autowired
	CategoryRepository categoryRepository;
	
	@GetMapping("/categories")
	public String category(Model model) {
		// Iterable qui va faire le tour des articles en base, pour déterminer leur catégorie
		Iterable<Category> category = categoryRepository.findAll();
		model.addAttribute("category", category);
		return "category";
	}

	@GetMapping("/displayArticlesByCategory") // mapping qui utilise la clé étrangère articles comme route
	public String displayArticlesByCategory(@RequestParam(name="id") Long id, Model model) {
		System.out.println(id);
//		Optional<Category> categoryOptional = categoryRepository.findById(id);
//		if (categoryOptional.isPresent()) {
//			Category category = categoryOptional.get();
//			model.addAttribute("category", category);
			return "articles";
//		} else {
//			return "error";
//		}
//
	}
	@PostMapping("/add") 
	public String save(@RequestParam("name") String name) {
		Category category= new Category();
		category.setName(name);
		categoryRepository.save(category);
		return "redirect:/categories"; // Redirection vers la catégorie cliquée
	}
}