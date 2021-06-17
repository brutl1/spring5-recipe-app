package guru.springframework.controller;

import guru.springframework.domain.RecipeListDTO;
import guru.springframework.service.RecipeService;
import guru.springframework.service.RecipeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class RecipeControllerTest {

    @Mock
    RecipeService recipeService;
    RecipeController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        controller = new RecipeController(recipeService);

    }

    @Test
    void mockMvc() {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void getAllRecipes() {
        ResponseEntity<RecipeListDTO> responseEntity = new ResponseEntity<>(new RecipeListDTO(new ArrayList<>()), HttpStatus.OK);
        ResponseEntity<RecipeListDTO> response = controller.getAllRecipes();
        assertEquals(responseEntity, response);
        verify(recipeService, times(1)).getAllRecipes();
    }
}