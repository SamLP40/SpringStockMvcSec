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
public class ArticleController {
	@Autowired
	ArticleRepository articleRepository;
	@Autowired
	CategoryRepository categoryRepository;
	
	//@RequestMapping(value="/index", method=RequestMethod.GET)
	@GetMapping("/index")
	public String index(Model model, @RequestParam(name="page", defaultValue="0") int page,
									 @RequestParam(name="keyword", defaultValue="") String kw, 
									 @RequestParam(name="idCat", defaultValue="0") Long idCat) { // Paramétrage de la pagination (page initiale = 0, indicateur de page = page)
		Page<Article> articles = null;
		if(idCat > 0) {
			articles = articleRepository.findByCategoryId(idCat, PageRequest.of(page, 5));
		}
		else articles = articleRepository.findByDescriptionContains(kw, PageRequest.of(page, 5));

		model.addAttribute("listArticle", articles.getContent()); // Accès au contenu de chaque page en base
		
		model.addAttribute("pages", new int[articles.getTotalPages()]); // Méthode qui permet d'accéder au nb total de pages
		
		model.addAttribute("currentPage", page); // Permet d'atteindre la page en cours.
		
		model.addAttribute("keyword", kw); // Permet d'enregistrer un mot clé
		
		model.addAttribute("listCategory", categoryRepository.findAll()); // Affichage dynamique 
		
		return "articles"; // Renvoie au dispatcheur le fichier articles.html
	}
	
	@GetMapping("/delete") // Requête de suppression (que le programme recherche avec la clé primaire mappée)
	public String delete(Long id, int page, String keyword) {
		
		articleRepository.deleteById(id);
		System.out.println(id+" "+page+" "+keyword);
		return "redirect:/index?page="+page+"&keyword="+keyword;
	}
	
	@GetMapping("/article")
	public String article(Model model) { // Récup du modèle
		model.addAttribute("article", new Article()); // Ajout d'un article en base
		return "article";
	}
	
	@PostMapping("/save") 
	public String save(Model model, @Valid Article article, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) return "article";
		articleRepository.save(article);
		return "article";
		
	}
//	@GetMapping("/displayArticlesByCategory")
//	public String displayArticlesByCategory(Long id, Model model) {
//		Optional<Category> categoryOptional = categoryRepository.findById(id);
//		System.out.println("n° de la catégorie:"+id);
//		if (categoryOptional.isPresent()) {
//			Category category = categoryOptional.get();
//			model.addAttribute("category", category);
//			return "articles";
//		} else {
//			return "error";
//		}
//	}
}
	



