package ie.cit.cloud.appdev;

import ie.cit.cloud.appdev.model.Recipe;
import ie.cit.cloud.appdev.RecipeRepository;
import ie.cit.cloud.appdev.RecipeServiceImpl;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class RecipeServiceImplTest {

    private RecipeServiceImpl tested;
    private RecipeRepository repository;
    private Recipe testRecipe = new Recipe("Simple Omelette", "A recipe for a simple Omelette", "3", "100g", "Rosanna", "30", "45", "Egg, Cheese, Tomato", "Beat eggs, add to pan, top with cheese and tomato");
    
    
    @Before
    public void setup() {
	repository = Mockito.mock(RecipeRepository.class);
	tested = new RecipeServiceImpl(repository);
    }

    //Test adding a new Recipe
    @Test
    public void testAddNewRecipe() {
    	tested.addNewRecipe(testRecipe);
    	Mockito.verify(repository).create(testRecipe);
    }
    
    //Test getting all recipes
    @Test
    public void testGetAllRecipes(){
    	tested.getAllRecipes();
    	Mockito.verify(repository).findAll();
    } 
   
    //Test get a recipe by name
   	@Test
   	public void testGetRecipe(){
	   tested.getRecipe("Simple Omelette");
	   Mockito.verify(repository).findByName("Simple Omelette");
   	}
   	
   	@Test
   	public void testRemoveRecipe(){
   		tested.removeRecipe(testRecipe);
   		Mockito.verify(repository).delete(testRecipe);
   		
   	}
   	
   	
  
   
}

