package com.solmazDeneme.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import javax.persistence.*;
import java.util.Collection;



@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name= "user" , uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    private String password;
    private boolean isActive = true;

    private String dayPlan;

//    @ElementCollection
//    @CollectionTable(name="dateListOfUsers")
//    private  ArrayList <Calendarr> datePlan = new ArrayList<Calendarr>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles_",
            joinColumns = @JoinColumn(
                    name = "user_id" , referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))


    private Collection<Role> roles ;

    public User(String firstName, String lastName, String email, String password, boolean isActive, String dayPlan, Collection<Role> roles) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.isActive = isActive;
        this.dayPlan = dayPlan;
        this.roles = roles;
    }

}
