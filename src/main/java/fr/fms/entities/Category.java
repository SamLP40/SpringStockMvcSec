package fr.fms.entities;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString(exclude="articles")//Décorateurs générant les getters/setters
public class Category implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	@OneToMany(mappedBy="category") // Clé étrangère liée à article
	private Collection<Article> articles;
	
}