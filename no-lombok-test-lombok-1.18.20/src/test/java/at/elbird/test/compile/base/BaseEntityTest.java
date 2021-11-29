package at.elbird.test.compile.base;

import at.elbird.test.compile.*;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class BaseEntityTest {

    @Test
    void testEqualsMasterData() {
        final var animalType1 = buildAnimalType();
        assertThat(animalType1.equals(null)).isFalse();

        final var animalType2 = new AnimalType();
        animalType2.setAnimalGroup(animalType1.getAnimalGroup());
        animalType2.setAnimalCategories(animalType2.getAnimalCategories());
        animalType2.setSomeCategories(animalType1.getSomeCategories());
        animalType2.setTests(animalType1.getTests());

        assertThat(animalType1.getKey()).isNull();
        assertThat(animalType2.getKey()).isNull();
        assertThat(animalType1.equals(animalType2)).isFalse();

        animalType1.setKey("aninmalType");
        assertThat(animalType1.equals(animalType2)).isFalse();

        animalType1.setKey(null);
        animalType2.setKey("animalType");
        assertThat(animalType1.equals(animalType2)).isFalse();

        animalType1.setKey("animalType");
        assertThat(animalType1.equals(animalType2)).isTrue();

        MasterData otherMasterData = new SomeCategory();
        otherMasterData.setKey(animalType1.getKey());
        assertThat((animalType1).equals(otherMasterData)).isFalse();
    }

    @Test
    void testEqualsIntId() {
        final var material1 = buildMaterial();
        assertThat(material1.equals(null)).isFalse();

        final var material2 = new Material();
        material2.setMaterialType(material1.getMaterialType());
        material2.setAnimal(material1.getAnimal());
        material2.setSampleNumber(material1.getSampleNumber());

        assertThat(material1.getId()).isEqualTo(0);
        assertThat(material2.getId()).isEqualTo(0);
        assertThat(material1.equals(material2)).isFalse();

        material1.setId(5678);
        assertThat(material1.equals(material2)).isFalse();

        material2.setId(5678);
        material1.setId(0);
        assertThat(material1.equals(material2)).isFalse();

        material1.setId(5678);
        assertThat(material1.getId()).isEqualTo(material2.getId());
        assertThat(material1.equals(material2)).isTrue();

        IntIdEntity otherIntId = new Animal();
        otherIntId.setId(material1.getId());
        assertThat(material1.equals(otherIntId)).isFalse();
    }

    @Test
    void testEqualsObjectId() {
        final var customer1 = buildCustomer();
        assertThat(customer1.equals(null)).isFalse();

        final var customer2 = new Customer();
        customer2.setFirstName(customer1.getFirstName());
        customer2.setLastName(customer1.getLastName());
        customer2.setEmail(customer1.getEmail());

        assertThat(customer1.getId()).isNull();
        assertThat(customer2.getId()).isNull();
        assertThat(customer1.equals(customer2)).isFalse();

        customer1.setId("someId");
        assertThat(customer1.equals(customer2)).isFalse();

        customer2.setId("someId");
        customer1.setId(null);
        assertThat(customer1.equals(customer2)).isFalse();

        customer1.setId("someId");
        assertThat(customer1.getId()).isEqualTo(customer2.getId());
        assertThat(customer1.equals(customer2)).isTrue();

        ObjectIdEntity<String> otherObjectIdEntity = new Country();
        otherObjectIdEntity.setId(customer1.getId());
        assertThat(customer1.equals(otherObjectIdEntity)).isFalse();
    }


    @Test
    void testHashCodeMasterData() {
        assertThat(new AnimalType().hashCode()).isEqualTo(42);

        final var animalType = buildAnimalType();
        assertThat(animalType.getKey()).isNull();
        assertThat(animalType.hashCode()).isEqualTo(42);

        animalType.setKey("someKey");
        assertThat(animalType.hashCode()).isEqualTo("someKey".hashCode());
    }

    @Test
    void testHashCodeIntId() {
        assertThat(new Material().hashCode()).isEqualTo(42);

        final var material = buildMaterial();
        assertThat(material.getId()).isEqualTo(0);
        assertThat(material.hashCode()).isEqualTo(42);

        material.setId(5678);
        assertThat(material.hashCode()).isEqualTo(5678);
    }

    @Test
    void testHashCodeObjectId() {
        assertThat(new Customer().hashCode()).isEqualTo(42);

        final var customer = buildCustomer();
        assertThat(customer.getId()).isNull();
        assertThat(customer.hashCode()).isEqualTo(42);

        customer.setId("someCustomerId");
        assertThat(customer.hashCode()).isEqualTo("someCustomerId".hashCode());
    }

    AnimalType buildAnimalType() {
        final var animalType = new AnimalType();
        animalType.setAnimalGroup("animalGroup1");
        final var animalCategory = new AnimalCategory();
        animalCategory.setKey("animalCategory1");
        animalType.setAnimalCategories(Set.of(animalCategory));
        final var ageCategory = new SomeCategory();
        ageCategory.setKey("ageCategory1");
        animalType.setSomeCategories(Set.of(ageCategory));
        final var test = new at.elbird.test.compile.Test();
        test.setName("test1");
        animalType.setTests(Set.of(test));
        return animalType;
    }

    Material buildMaterial() {
        final var material = new Material();
        material.setSampleNumber("342354325");
        final var type = new MaterialType();
        type.setName("type");
        material.setMaterialType(type);
        final var animal = new Animal();
        animal.setId(1234);
        material.setAnimal(animal);
        return material;
    }

    Customer buildCustomer() {
        final var customer = new Customer();
        customer.setFirstName("Test");
        customer.setLastName("Testinger");
        customer.setEmail("test.testinger@test.com");
        return customer;
    }
}