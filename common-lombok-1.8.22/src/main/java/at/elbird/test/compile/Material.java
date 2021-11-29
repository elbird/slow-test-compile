package at.elbird.test.compile;

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
public class Material extends BaseEntity<Material> implements IntIdEntity {

	@Id
	@ToString.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ToString.Include
	private String sampleNumber;

	@ManyToOne
	private Animal animal;

	@ManyToOne
	private MaterialType materialType;

	@ManyToMany
	private Set<Test> tests = new HashSet<>();

	private boolean received = false;
}
