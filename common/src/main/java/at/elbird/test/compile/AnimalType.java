package at.elbird.test.compile;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import at.elbird.test.compile.base.Activatable;
import at.elbird.test.compile.base.BaseEntity;
import at.elbird.test.compile.base.MasterData;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
public class AnimalType extends BaseEntity<AnimalType> implements MasterData, Activatable {

	@Id
	@ToString.Include
	private String key;

	private String name;

	private boolean active = true;

	private String animalGroup;

	@OneToMany(mappedBy = "animalType", cascade = CascadeType.ALL)
	private Set<AnimalCategory> animalCategories = new HashSet<>();

	@OneToMany(mappedBy = "animalType", cascade = CascadeType.ALL)
	private Set<SomeCategory> someCategories = new HashSet<>();

	@ManyToMany(mappedBy = "animalTypes")
	private Set<Test> tests = new HashSet<>();
}
