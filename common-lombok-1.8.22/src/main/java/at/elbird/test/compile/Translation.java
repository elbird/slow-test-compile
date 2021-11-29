package at.elbird.test.compile;

import at.elbird.test.compile.base.BaseEntity;
import at.elbird.test.compile.base.ObjectIdEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Transient;

@Entity
@IdClass(TranslationId.class)
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
public class Translation extends BaseEntity<Translation> implements ObjectIdEntity<TranslationId> {

	@Id
	@ToString.Include
	private String key;

	@Id
	@ToString.Include
	private String language;

	@ToString.Include
	private String value;

	@Transient
	public TranslationId getId() {
		if (key == null || language == null) {
			return null;
		}
		return new TranslationId(key, language);
	}

	public void setId(TranslationId id) {
		this.key = id.getKey();
		this.language = id.getLanguage();
	}
}
