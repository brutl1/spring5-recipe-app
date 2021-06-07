package guru.springframework.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class UnitOfMeasure {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String uom;
    @OneToOne
    private Ingredient ingredient;
}
