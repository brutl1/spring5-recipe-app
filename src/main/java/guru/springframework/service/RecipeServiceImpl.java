package guru.springframework.service;

import guru.springframework.command.RecipeCommand;
import guru.springframework.converter.RecipeCommandToRecipe;
import guru.springframework.converter.RecipeToRecipeCommand;
import guru.springframework.domain.Recipe;
import guru.springframework.domain.RecipeDTO;
import guru.springframework.mapper.RecipeMapper;
import guru.springframework.repository.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeMapper recipeMapper;
    private final RecipeCommandToRecipe recipeCommandToRecipe;
    private final RecipeToRecipeCommand recipeToRecipeCommand;

    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeMapper recipeMapper, RecipeCommandToRecipe recipeCommandToRecipe, RecipeToRecipeCommand recipeToRecipeCommand) {
        this.recipeRepository = recipeRepository;
        this.recipeMapper = recipeMapper;
        this.recipeCommandToRecipe = recipeCommandToRecipe;
        this.recipeToRecipeCommand = recipeToRecipeCommand;
    }

    @Override
    public List<RecipeDTO> getAllRecipes() {
        log.debug("return all recipes");
        return recipeRepository.findAll()
                .stream()
                .map(recipeMapper::recipeToRecipeDTO)
                .collect(Collectors.toList());

    }

    @Override
    public Set<Recipe> getRecipes() {
        Set<Recipe> recipes = new HashSet<>();
        recipes.addAll(recipeRepository.findAll());
        return recipes;
    }


    @Override
    @Transactional
    public RecipeCommand saveRecipeCommand(RecipeCommand command) {
        Recipe detachedRecipe = recipeCommandToRecipe.convert(command);

        Recipe savedRecipe = recipeRepository.save(detachedRecipe);
        log.debug("Saved RecipeId:" + savedRecipe.getId());
        return recipeToRecipeCommand.convert(savedRecipe);
    }

    @Override
    @Transactional
    public Recipe findById(Long id) {
        return recipeRepository.findById(id).orElse(null);
    }
}
