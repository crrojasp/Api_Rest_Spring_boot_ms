package crrojasp.apirest.cassandra.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import crrojasp.apirest.cassandra.repository.*;
import crrojasp.apirest.cassandra.model.*;
import java.util.UUID;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
class PetController {

    private final PetRepository repository;

    PetController(PetRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/pets")
    List<Pet> all() {
        return repository.findAll();
    }

    @PostMapping("/pets")
    Pet newPet(@RequestBody Pet newPet) {
        if (newPet.getid_pet() == null) {
            // Si no está presente, generar un UUID y asignarlo
            newPet.setid_pet(UUID.randomUUID());
        }
        return repository.save(newPet);
    }

    // Single item
    @GetMapping("/pets/{id}")
    Pet one(@PathVariable UUID id) {
        return repository.findById(id)
        .orElseThrow(() -> new PetNotFoundException(id));
    }

    @PutMapping("/pets/{id}")
    Pet replacePet(@RequestBody Pet newPet, @PathVariable UUID id) {
        return repository.findById(id)
        .map(pet -> {
            pet.setName(newPet.getName());
            pet.setAge(newPet.getAge());
            pet.setDescription(newPet.getDescription());
            pet.setEspecie(newPet.getEspecie());
            pet.setGender(newPet.isGender());
            pet.setid_foundation(newPet.getid_foundation());
            pet.setImages(newPet.getImages());
            pet.setRace(newPet.getRace());
            pet.setStatus(newPet.getStatus());
            return repository.save(pet);
        })
        .orElseGet(() -> {
            newPet.setid_pet(id);
            return repository.save(newPet);
        });
    }

    @DeleteMapping("/pets/{id}")
    void deletePet(@PathVariable UUID id) {
        repository.deleteById(id);
    }
}