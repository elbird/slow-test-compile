package at.elbird.test.compile.base;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable<T extends BaseIdEntity> extends BaseEntity<T> {

    @CreatedBy
    @ManyToOne
    protected Object createdBy;

    @CreatedDate
    
    @ToString.Include
    protected LocalDateTime createdDate;

    @LastModifiedBy
    @ManyToOne
    protected Object lastModifiedBy;

    @LastModifiedDate
    
    @ToString.Include
    protected LocalDateTime lastModifiedDate;
}
