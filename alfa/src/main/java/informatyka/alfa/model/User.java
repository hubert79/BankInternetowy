package informatyka.alfa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "alfauser")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;

    @Column(name = "email")
    @Email(message = "*Proszę podać prawidłowy Email!")
    @NotEmpty(message = "*Proszę podać Email")
    private String email;

    @Column(name = "password")
    @Length(min = 5, message = "*Minimalna długoś hasła to 5 znaków!")
    @NotEmpty(message = "*Proszę podać hasło")
    private String password;

    @Column(name = "name")
    @NotEmpty(message = "*Proszę podać swoje imię!")
    private String name;

    @Column(name = "last_name")/*Person ID*/
    @NotEmpty(message = "*Proszę podać swoj numer pesel!")
    private String lastName;

    @Column(name = "active")
    private int active;

    @Column(name = "saldo")
    private Double saldo;

    @Column(name = "accountnumber")
    private long accountNumber;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
}
