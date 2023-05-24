package fr.fms.web;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.fms.dao.ArticleRepository;
import fr.fms.entities.Article;

@Controller
public class ArticleController {
	@Autowired
	ArticleRepository articleRepository;
	
	//@RequestMapping(value="/index", method=RequestMethod.GET)
	@GetMapping("/index")
	public String index(Model model, @RequestParam(name="page", defaultValue="0") int page,
									 @RequestParam(name="keyword", defaultValue="") String kw) { // Paramétrage de la pagination (page initiale = 0, indicateur de page = page)
		Page<Article> articles= articleRepository.findByDescriptionContains(kw, PageRequest.of(page, 5));
	//	Page<Article> articles1= articleRepository.findAll(PageRequest.of(page, 5)); // Récup de toutes les pages
		model.addAttribute("listArticle", articles.getContent()); // Accès au contenu de chaque page en base
		
		model.addAttribute("pages", new int[articles.getTotalPages()]); // Méthode qui permet d'accéder au nb total de pages
		
		model.addAttribute("currentPage", page); // Permet d'atteindre la page en cours.
		
		model.addAttribute("keyword", kw); // Permet d'enregistrer un mot clé
		
		return "articles"; // Renvoie au dispatcheur le fichier articles.html
	}
	
	@GetMapping("/delete") // Requête de suppression (que le programme recherche avec la clé primaire mappée)
	public String delete(Long id, int page, String keyword) {
		
		articleRepository.deleteById(id);
		
		return "redirect:/index?page="+page+"&keyword="+keyword;
	}
}

