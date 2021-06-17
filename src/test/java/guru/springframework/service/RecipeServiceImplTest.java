package guru.springframework.service;

import guru.springframework.domain.Recipe;
import guru.springframework.domain.RecipeDTO;
import guru.springframework.mapper.RecipeMapper;
import guru.springframework.repository.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;
    @Mock
    RecipeRepository recipeRepository;

    @Mock
    RecipeMapper recipeMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository, recipeMapper);

    }

    @Test
    void getAllRecipes() {
        Recipe recipe = new Recipe();
        RecipeDTO recipeDTO = new RecipeDTO();
        List<Recipe> recipesList = new ArrayList<>();
        recipesList.add(recipe);


        when(recipeMapper.recipeToRecipeDTO(recipe)).thenReturn(recipeDTO);
        when(recipeRepository.findAll()).thenReturn(recipesList);

        List<RecipeDTO> recipes = recipeService.getAllRecipes();



        assertEquals(recipesList.size(), recipes.size());
        verify(recipeRepository, times(1)).findAll();
    }
}