package dev.kishoremenda.runnerz.run;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InMemoryRunRepositoryTest {

    InMemoryRunRepository repository;

    @BeforeEach
    void setUp() {
        repository = new InMemoryRunRepository();
        repository.create(new Run(1, "Morning Run", LocalDateTime.now(), LocalDateTime.now().plusMinutes(30), 5, Location.INDOOR,0));
        repository.create(new Run(2, "Evening Run",LocalDateTime.now(), LocalDateTime.now().plusMinutes(60), 5, Location.OUTDOOR,0));
    }

    @Test
    void shouldFindAllRuns() {
        var runs = repository.findAll();
        assertEquals(2, runs.size(), "Should habe returned 2 runs");
    }

}
