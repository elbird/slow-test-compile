package at.elbird.test.compile;

import at.elbird.test.compile.base.BaseEntity;
import at.elbird.test.compile.base.IntIdEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
public class Animal extends BaseEntity<Animal> implements IntIdEntity {

	@Id
	@ToString.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ToString.Include
	private String name;

	private LocalDate sampleDate;

	@OneToMany(mappedBy = "animal", cascade = CascadeType.ALL)
	private Set<Material> materials = new HashSet<>();

	public void addMaterial(Material material) {
		materials.add(material);
		material.setAnimal(this);
	}

	@ManyToOne
	private AnimalCategory animalCategory;

	@ManyToOne
	private SomeCategory ageCategory;

}
