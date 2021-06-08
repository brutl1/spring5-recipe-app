package guru.springframework.service;

import guru.springframework.domain.RecipeDTO;

import java.util.List;

public interface RecipeService {
    List<RecipeDTO> getAllRecipes();
}
