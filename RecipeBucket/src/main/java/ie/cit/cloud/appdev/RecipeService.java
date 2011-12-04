package ie.cit.cloud.appdev;

import java.util.Collection;

import ie.cit.cloud.appdev.model.Recipe;

public interface RecipeService {
	
	Collection<Recipe> getAllRecipes();
	
	void addNewRecipe(Recipe recipe);
	
	Recipe getRecipe(String name);

	void removeRecipe(Recipe recipe);

}
