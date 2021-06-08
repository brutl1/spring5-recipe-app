package guru.springframework.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class RecipeListDTO {
    private List<RecipeDTO> recipes;
}
