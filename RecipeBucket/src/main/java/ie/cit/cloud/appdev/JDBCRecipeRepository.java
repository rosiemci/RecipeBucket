package ie.cit.cloud.appdev;

import ie.cit.cloud.appdev.model.Recipe;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

@Repository
public class JDBCRecipeRepository implements RecipeRepository {

	
    private JdbcTemplate tmpl;	

    @Autowired
    public JDBCRecipeRepository(DataSource dataSource) {
	tmpl = new JdbcTemplate(dataSource);
    }

    /*
     * Method to return a recipe by the name
     */
    public Recipe get(String name) {
	Recipe recipe = findByName(name);
	if (recipe == null)
	    throw new EmptyResultDataAccessException(1);
	return recipe;
    }

    public void create(Recipe recipe) {
	tmpl.update("insert into RECIPE (id, name, description , numServings, servingSize, postedBy, preparationTime, cookingTime, ingredients, method) values(?,?,?,?,?,?,?,?,?,?)",
		recipe.getId(), recipe.getName(), recipe.getDescription(), recipe.getNumServings(), recipe.getServingSize(), recipe.getPostedBy(), recipe.getPreparationTime(), recipe.getCookingTime(), recipe.getIngredients(), recipe.getMethod());
    }

    public void update(Recipe recipe) {
	tmpl.update("update RECIPE set id=?, name=?, description=?, numServings=?, servingSize=?, postedBy=?, preparationTime=?, cookingTime=?, ingredients=?, method=? where id=?",
		recipe.getId(), recipe.getName(), recipe.getDescription(), recipe.getNumServings(), recipe.getServingSize(), recipe.getPostedBy(), recipe.getPreparationTime(), recipe.getCookingTime(), recipe.getIngredients(), recipe.getMethod(), recipe.getName());
    }

    public void delete(Recipe recipe) {
	tmpl.update("delete from RECIPE where id=?", recipe.getId());
    }

    

    public Recipe findByName(String name) {
	return tmpl.queryForObject(
		"select id, name, description , numServings, servingSize, postedBy, preparationTime, cookingTime, ingredients, method from RECIPE where name=?",
		new RecipeRowMapper(), name);
		
    }
    
    public Recipe findById(String id) {
    	return tmpl.queryForObject(
    		"select id, name, description , numServings, servingSize, postedBy, preparationTime, cookingTime, ingredients, method from RECIPE where id=?",
    		new RecipeRowMapper(), id);
    		
        }

    /**
     * Mapper that converts ResultSet into {@link Recipe} object
     */
    public static class RecipeRowMapper implements RowMapper<Recipe> {
	public Recipe mapRow(ResultSet rs, int rowNum) throws SQLException {
	    return new Recipe(rs.getString("name"), rs.getString("description"),
		    rs.getString("numServings"),rs.getString("servingSize"), rs.getString("postedBy"), 
		    rs.getString("preparationTime"), rs.getString("cookingTime"), rs.getString("ingredients"), rs.getString("method"));
	}
    }
    
    
    /*
     * getCurrentUser - to get the Current logged in User 
     */
    private String getCurrentUser() {
    	return SecurityContextHolder.getContext().getAuthentication().getName();
        }
    
  
    /*
     * A method to findAll recipes for the current logged in user
     */
    public Collection<Recipe> findAll() {
    	
    	return tmpl.query("select id, name, description , numServings, servingSize, postedBy, preparationTime, cookingTime, ingredients, method from RECIPE where postedBy = ?",
    		new RecipeRowMapper(), getCurrentUser() );
        }
    
    
    

    
}