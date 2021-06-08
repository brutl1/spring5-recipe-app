package guru.springframework.mapper;

import guru.springframework.domain.Recipe;
import guru.springframework.domain.RecipeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RecipeMapper {
    RecipeMapper INSTANCE = Mappers.getMapper(RecipeMapper.class);


    RecipeDTO recipeToRecipeDTO(Recipe recipe);
}
