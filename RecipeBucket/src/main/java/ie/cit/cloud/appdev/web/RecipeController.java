package ie.cit.cloud.appdev.web;

import ie.cit.cloud.appdev.RecipeService;

import ie.cit.cloud.appdev.model.Recipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class RecipeController {
	
	@Autowired
	private RecipeService recipeService;

	@RequestMapping(value = {"index", ""}, method = GET)
	public String index(Model model) {
		model.addAttribute("recipes", recipeService.getAllRecipes());
		return "index";
	    }

	
	
	@RequestMapping(value = {"index", ""}, method = POST)
	public String index(@RequestParam(required=false) String name, String description, 
			String numServings, String servingSize, String username, String preparationTime, 
			String cookingTime, String ingredients, String method, Model model){
		
		Recipe recipe = new Recipe(name, description, numServings, servingSize, username, preparationTime, 
				cookingTime, ingredients, method);
		
		recipeService.addNewRecipe(recipe);
		
		if(name == null){
			//model.addAttribute("recipe", recipeService.getRecipeName());
		}
		else{
			model.addAttribute("recipe", name);
			model.addAttribute("description", description);
			model.addAttribute("numServings", numServings);
			model.addAttribute("servingSize", servingSize);
			model.addAttribute("username", username);
			model.addAttribute("preparationTime", preparationTime);
			model.addAttribute("cookingtime", cookingTime);
			model.addAttribute("ingredients", ingredients);
			model.addAttribute("method", method);
			model.addAttribute("recipes", recipeService.getAllRecipes());
		}
		return "viewrecipe";
	}
	

	
	
	
}
