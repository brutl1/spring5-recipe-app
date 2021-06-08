package guru.springframework.controller;

import guru.springframework.domain.RecipeDTO;
import guru.springframework.domain.RecipeListDTO;
import guru.springframework.service.RecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/v1/recipes/")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }


    @GetMapping
    public ResponseEntity<RecipeListDTO> getAllRecipes() {
        return new ResponseEntity<>(
                new RecipeListDTO(recipeService.getAllRecipes()), HttpStatus.OK);
    }


}
