package liga.medical.personservice.core.model;

import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.GrantedAuthority;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Set;

@Data
public class PersonDataEntity implements UserDetails {

    private Long id;

    private String lastName;

    private String firstName;

    private LocalDate birthDt;

    private int age;

    private char sex;

    private Long contactId;

    private Long medicalCardId;

    private Long parentId;

    private String email;

    private String password;

    private Set<Role> roles;

    public PersonDataEntity(Long id, String lastName, String firstName, LocalDate birthDt, String email, String password) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDt = birthDt;
        this.email = email;
        this.password = password;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

