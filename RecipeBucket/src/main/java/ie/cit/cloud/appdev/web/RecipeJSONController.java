package ie.cit.cloud.appdev.web;

import java.util.Collection;

import ie.cit.cloud.appdev.RecipeService;
import ie.cit.cloud.appdev.model.Recipe;


	

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriTemplate;

@Controller
@RequestMapping("api")
public class RecipeJSONController {
    @Autowired
    private RecipeService recipeService;

    @RequestMapping("recipes")
    @ResponseBody
    public Collection<Recipe> index() {
    	return recipeService.getAllRecipes();
        }

    @RequestMapping(value = "/recipes/{index}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    Recipe getRecipeAt(@PathVariable("index") String name) {
	return recipeService.getRecipe(name);
    }

    @RequestMapping(value = "/recipes", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createRecipe(@RequestBody Recipe recipe, HttpServletRequest request,
	    HttpServletResponse response) {
	recipeService.addNewRecipe(recipe);
	response.addHeader("Location",
		getLocationForChildResource(request, recipeService.getRecipe(recipe.getName())));
    }


    @RequestMapping(value = "/recipes/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRecipeAt(@PathVariable("id") Recipe recipe) {
	recipeService.removeRecipe(recipe);
    }

    private String getLocationForChildResource(HttpServletRequest request, Object childIdentifier) {
	// get the current URL from the reguest
	final StringBuffer url = request.getRequestURL();
	// append the /xyz to the URL and make it a UriTemplate
	final UriTemplate template = new UriTemplate(url.append("/{childId}")
		.toString());
	return template.expand(childIdentifier).toASCIIString();
    }
}

