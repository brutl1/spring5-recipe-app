package guru.springframework.repository;

import guru.springframework.domain.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
