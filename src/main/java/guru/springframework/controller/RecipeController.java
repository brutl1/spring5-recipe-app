package guru.springframework.controller;

import guru.springframework.domain.RecipeListDTO;
import guru.springframework.service.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/api/v1/recipes/")
@Slf4j
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }


    @GetMapping
    public ResponseEntity<RecipeListDTO> getAllRecipes() {
        log.debug("Return all recipes");
        return new ResponseEntity<>(
                new RecipeListDTO(recipeService.getAllRecipes()), HttpStatus.OK);
    }


}
