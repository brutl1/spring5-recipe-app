package guru.springframework.repository;

import guru.springframework.domain.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class UnitOfMeasureRepositoryTest {

    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;
    @BeforeEach
    void setUp() {
    }

    @Test
    // @DirtiesContext # if the context gets dirty lol
    void findByDescription() {
        Optional<UnitOfMeasure> uom = unitOfMeasureRepository.findByDescription("Tablespoon");
        assertEquals("Tablespoon", uom.get().getDescription());
    }

    @Test
    void findByDescriptionPinch() {
        Optional<UnitOfMeasure> uom = unitOfMeasureRepository.findByDescription("Pinch");
        assertEquals("Pinch", uom.get().getDescription());
    }
}