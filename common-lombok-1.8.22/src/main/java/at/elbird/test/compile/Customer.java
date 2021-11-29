package at.elbird.test.compile;

import at.elbird.test.compile.base.BaseEntity;
import at.elbird.test.compile.base.ObjectIdEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
public class Customer extends BaseEntity<Customer> implements ObjectIdEntity<String> {
    
    @Id
    
    @ToString.Include
    private String id;
    

    
    private String title;

    @ToString.Include
    private String firstName;

    @ToString.Include
    private String lastName;

    @ToString.Include
    private String email;
    
    private String dialPrefix;
    
    private String phone;
    
    private String mobile;

    
    private String fax;

    
    private String street;

    
    private String streetNumber;

    
    private String city;
    
    private String postcode;

    @ManyToOne
    private Country country;
    
}
