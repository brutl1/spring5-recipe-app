package guru.springframework.bootstrap;

import guru.springframework.domain.*;
import guru.springframework.repository.CategoryRepository;
import guru.springframework.repository.RecipeRepository;
import guru.springframework.repository.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Collections;

@Component
@Slf4j
public class Bootstrap implements CommandLineRunner {

    private static final String AMERICAN = "American";
    private final RecipeRepository recipeRepository;
    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public Bootstrap(RecipeRepository recipeRepository, CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        log.debug("Add Spicy Grilled Chicken Tacos ");
        Category c1 = categoryRepository.findCategoryByDescription(AMERICAN).get();



        Recipe r1 = new Recipe();

        r1.setCategories(Collections.singleton(c1));
        r1.setDescription("Spicy grilled chicken tacos! Quick marinade, then grill. Ready in about 30 minutes. Great for a quick weeknight dinner, backyard cookouts, and tailgate parties.");
        r1.setCookTime(15);
        r1.setPrepTime(20);
        r1.setServings(4);
        r1.setSource("Spicy Grilled Chicken Tacos ");
        r1.setUrl("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");
        r1.setDirections("Just Do It!");
        r1.setDifficulty(Difficulty.EASY);
        //r1.setImage(); TODO store image

        Notes n1 = new Notes();
        n1.setRecipeNotes("\n" +
                "Prepare a gas or charcoal grill for medium-high, direct heat\n" +
                "Make the marinade and coat the chicken:\n" +
                "\n" +
                "In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
                "\n" +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n" +
                "Spicy Grilled Chicken Tacos\n" +
                "Grill the chicken:\n" +
                "\n" +
                "Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n" +
                "Warm the tortillas:\n" +
                "\n" +
                "Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
                "\n" +
                "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" +
                "Assemble the tacos:\n" +
                "\n" +
                "Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges. ");


        r1.setNotes(n1);

        UnitOfMeasure u1 = unitOfMeasureRepository.findByDescription("Teaspoon").get();


        Ingredient i1 = new Ingredient();
        i1.setDescription("dried oregano ");
        i1.setAmount(BigDecimal.ONE);

        i1.setUnitOfMeasure(u1);
        r1.setIngredients(Collections.singleton(i1));



        //r1.getIngredients().add(i1);

        recipeRepository.save(r1);

        log.debug("Saved Recipe One ");



    }
}
