package at.elbird.test.compile;

import at.elbird.test.compile.base.BaseEntity;
import at.elbird.test.compile.base.IntIdEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
public class MaterialType extends BaseEntity<MaterialType> implements IntIdEntity {

	@Id
	@ToString.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	
	private String name;

	
	private String description;
}
