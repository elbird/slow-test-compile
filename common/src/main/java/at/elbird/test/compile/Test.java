package at.elbird.test.compile;

import at.elbird.test.compile.base.Activatable;
import at.elbird.test.compile.base.BaseEntity;
import at.elbird.test.compile.base.IntIdEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
public class Test extends BaseEntity<Test> implements IntIdEntity, Activatable {

	@Id
	@ToString.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	
	private String name;

	
	private String description;

	
	private boolean active = true;

	@ManyToMany
	private Set<AnimalType> animalTypes = new HashSet<>();
}
