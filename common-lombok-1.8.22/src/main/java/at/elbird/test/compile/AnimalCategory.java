package at.elbird.test.compile;

import at.elbird.test.compile.base.BaseEntity;
import at.elbird.test.compile.base.MasterData;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
public class AnimalCategory extends BaseEntity<AnimalCategory> implements MasterData {

	@Id
	@ToString.Include
	private String key;

	private String name;

	@ManyToOne
	private AnimalType animalType;
}
