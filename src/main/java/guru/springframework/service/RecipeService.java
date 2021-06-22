package guru.springframework.service;

import guru.springframework.command.RecipeCommand;
import guru.springframework.domain.Recipe;
import guru.springframework.domain.RecipeDTO;

import java.util.List;
import java.util.Set;

public interface RecipeService {
    List<RecipeDTO> getAllRecipes();
    Set<Recipe> getRecipes();
    RecipeCommand saveRecipeCommand(RecipeCommand command);

    Recipe findById(Long id);
}
