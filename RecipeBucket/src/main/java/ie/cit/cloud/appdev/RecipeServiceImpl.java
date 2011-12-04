package ie.cit.cloud.appdev;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ie.cit.cloud.appdev.model.Recipe;
import ie.cit.cloud.appdev.RecipeRepository;


@Service
@Transactional

public class RecipeServiceImpl implements RecipeService {
	
	private final RecipeRepository repository;
	public String name;
	
	@Autowired
    public RecipeServiceImpl(RecipeRepository recipeRepository) {
	this.repository = recipeRepository;
    }
	
	public Collection<Recipe> getAllRecipes(){
		return repository.findAll();
	}
	
	public void addNewRecipe(Recipe recipe){
	
		repository.create(recipe);
	}
	
	public Recipe getRecipe(String name){
		return repository.findByName(name);
	}
	

	public void removeRecipe(Recipe recipe) {
		repository.delete(recipe);
		
	}

	
	
	
}
