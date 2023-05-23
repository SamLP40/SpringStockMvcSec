package fr.fms.web;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.fms.dao.ArticleRepository;
import fr.fms.entities.Article;

@Controller
public class ArticleController {
	@Autowired
	ArticleRepository articleRepository;
	
	//@RequestMapping(value="/index", method=RequestMethod.GET)
	@GetMapping("/index")
	public String index(Model model) { // Interaction avec la BDD (Model) grâce au contrôleur
		List<Article> articles= articleRepository.findAll(); // Récup de tous les articles en base
		model.addAttribute("listArticle", articles); // Accès au model (BDD) via listArticle
		
		return "articles"; // Renvoie au dispatcheur le fichier articles.html
	}
}

