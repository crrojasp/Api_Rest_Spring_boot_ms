package crrojasp.apirest.cassandra.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import crrojasp.apirest.cassandra.model.Pet;
// import java.util.Arrays;
import crrojasp.apirest.cassandra.repository.PetRepository;
// import java.util.UUID;
import java.util.List;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(PetRepository repository) {
        return args -> {
            List<Pet> pets = repository.findAll();
            int size = pets.size();
            int limit = Math.min(size, 10); // Obtener el mínimo entre el tamaño de la lista y 10

            log.info("Preloading " + limit + " pets");

            for (int i = 0; i < limit; i++) {
                log.info("Pet " + (i + 1) + ": " + pets.get(i));
            }
        };
    }
}
