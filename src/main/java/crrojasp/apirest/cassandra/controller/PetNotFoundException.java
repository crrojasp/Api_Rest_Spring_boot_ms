package crrojasp.apirest.cassandra.controller;

import java.util.UUID;

public class PetNotFoundException extends RuntimeException {

    public PetNotFoundException(UUID id) {
        super("Pet not found with id: " + id);
    }
}