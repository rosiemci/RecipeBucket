package ie.cit.cloud.appdev.model;

import java.util.UUID;


/**
 * 
 * A Simple Object representing a Recipe.
 * 
 * @author rmcinerney
 *
 */


public class Recipe {

	private String id;
    private String name;
    private String description;
    private String numServings;
    private String servingSize;
    private String postedBy;
    private String preparationTime;
    private String cookingTime;
    private String ingredients;
    private String method;


    public Recipe(String name, String description, String numServings, String servingSize, String postedBy, String preparationTime, String cookingTime, String ingredients, String method ) {
    	
    	setId();
    	this.name = name;
    	this.description = description;
    	this.numServings = numServings;
    	this.servingSize = servingSize;
    	this.ingredients = ingredients;
    	this.preparationTime = preparationTime;
    	this.cookingTime = cookingTime;
    	this.method = method;
    	this.postedBy = postedBy;
 	
    }

    public void create(){
    	
    }
    
    public String getName() {
    	return name;
    }

    public void setName(String name) {
    	this.name = name;
    }
    
    public void setDescription(String description){
    	this.description=description;
    
    }
    
    public String getDescription(){
    	return description;
    }
    
    
    public void setIngredients(String ingredients){
    	this.ingredients = ingredients;
    }
    
    public String getIngredients(){
    	return ingredients;
    }

    public void setMethod(String method){
    	this.method = method;
    }
    
    public String getMethod(){
    	return method;
    }

	public String getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}

	public String getCookingTime() {
		return cookingTime;
	}

	public void setCookingTime(String cookingTime) {
		this.cookingTime = cookingTime;
	}

	public String getNumServings() {
		return numServings;
	}

	public void setNumServings(String numServings) {
		this.numServings = numServings;
	}

	public String getServingSize() {
		return servingSize;
	}

	public void setServingSize(String servingSize) {
		this.servingSize = servingSize;
	}

	public String getPreparationTime() {
		return preparationTime;
	}

	public void setPreparationTime(String preparationTime) {
		this.preparationTime = preparationTime;
	}

	public String getId() {
		return id;
	}

	public void setId() {
		this.id = UUID.randomUUID().toString();
	}

    
}