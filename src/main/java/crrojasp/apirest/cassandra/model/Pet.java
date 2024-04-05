package crrojasp.apirest.cassandra.model;

import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Table("pets")
public class Pet {

    @PrimaryKey
    @CassandraType(type = CassandraType.Name.UUID)
    @Column("id_pet")
    private UUID id_pet;

    @Column("age")
    private int age;

    @Column("description")
    private String description;

    @Column("especie")
    private String especie;

    @Column("gender")
    private boolean gender;

    @Column("id_foundation")
    private String id_foundation;

    @Column("images")
    private List<String> images;

    @Column("name")
    private String name;

    @Column("race")
    private String race;

    @Column("status")
    private String status;

    public Pet() {}

    public Pet(/*UUID  id_pet,*/ int age, String description, String especie, boolean gender, String id_foundation, List<String> images, String name, String race, String status) {
        // this.id_pet = id_pet; 
        this.age = age;
        this.description = description;
        this.especie = especie;
        this.gender = gender;
        this.id_foundation = id_foundation;
        this.images = images;
        this.name = name;
        this.race = race;
        this.status = status;
    }

    public UUID getid_pet() {
        return id_pet;
    }

    public void setid_pet(UUID id_pet) {
        this.id_pet = id_pet;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getid_foundation() {
        return id_foundation;
    }

    public void setid_foundation(String id_foundation) {
        this.id_foundation = id_foundation;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return age == pet.age && gender == pet.gender && Objects.equals(id_pet, pet.id_pet) && Objects.equals(description, pet.description) && Objects.equals(especie, pet.especie) && Objects.equals(id_foundation, pet.id_foundation) && Objects.equals(images, pet.images) && Objects.equals(name, pet.name) && Objects.equals(race, pet.race) && Objects.equals(status, pet.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_pet, age, description, especie, gender, id_foundation, images, name, race, status);
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id_pet=" + id_pet +
                ", age=" + age +
                ", description='" + description + '\'' +
                ", especie='" + especie + '\'' +
                ", gender=" + gender +
                ", id_foundation='" + id_foundation + '\'' +
                ", images=" + images +
                ", name='" + name + '\'' +
                ", race='" + race + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}