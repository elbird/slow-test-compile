package at.elbird.test.compile;

import at.elbird.test.compile.base.BaseEntity;
import at.elbird.test.compile.base.ObjectIdEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class Country extends BaseEntity<Country> implements ObjectIdEntity<String> {
	@Id
	@ToString.Include
	private String code;

	@Transient
	public String getId() {
		return code;
	}

	public void setId(String code) {
		this.code = code;
	}
}
