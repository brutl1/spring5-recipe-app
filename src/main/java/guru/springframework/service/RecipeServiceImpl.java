package guru.springframework.service;

import guru.springframework.domain.RecipeDTO;
import guru.springframework.mapper.RecipeMapper;
import guru.springframework.repository.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeMapper recipeMapper;

    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeMapper recipeMapper) {
        this.recipeRepository = recipeRepository;
        this.recipeMapper = recipeMapper;
    }

    @Override
    public List<RecipeDTO> getAllRecipes() {
        log.debug("return all recipes");
        return recipeRepository.findAll()
                .stream()
                .map(recipeMapper::recipeToRecipeDTO)
                .collect(Collectors.toList());

    }
}
