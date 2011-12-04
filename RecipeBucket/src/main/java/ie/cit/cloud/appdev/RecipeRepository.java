package ie.cit.cloud.appdev;

import ie.cit.cloud.appdev.model.Recipe;

import java.util.Collection;

//import org.springframework.dao.EmptyResultDataAccessException;

public interface RecipeRepository {

    /**
     * Returns existing recipe given by its ID
     * 
     * @param id
     *            recipe ID
     * @return Recipe for given id, {@link EmptyResultDataAccessException} if no
     *         recipe was found
     */
    Recipe get(String id);

    /**
     * Adds new Recipe into repository
     * 
     * @param recipe
     */
    void create(Recipe recipe);

    /**
     * Updates existing recipe. Recipe with the same ID as given recipe is updated
     * 
     * @param recipe
     *            new recipe values
     */
    void update(Recipe recipe);

    /**
     * Deletes Recipe item from repository.
     * 
     * @param recipe
     */
    void delete(Recipe recipe);

    // ================ various find-er methods ================
    /**
     * Returns list of all recipes
     * 
     * @return all recipes
     */
    Collection<Recipe> findAll();

    /**
     * Returns recipe items given by its ID
     * 
     * @param id
     *            recipe ID
     * @return Recipe for given id, null if recipe was not found
     */
    Recipe findByName(String name);

    Recipe findById(String id);
}
