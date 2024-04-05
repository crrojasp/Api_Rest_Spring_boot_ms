package crrojasp.apirest.cassandra.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
import crrojasp.apirest.cassandra.model.Pet;

@Repository
public interface PetRepository extends CassandraRepository<Pet, UUID> {

}
