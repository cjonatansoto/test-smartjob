package cl.smartjob.ejercicio.domain.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CurrentTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

import static org.hibernate.generator.EventType.INSERT;
import static org.hibernate.generator.EventType.UPDATE;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@DynamicInsert
@Table(name = "users")
//borrado suave para el campo isActive
@SQLDelete(sql = "UPDATE users SET is_active = false WHERE id = ?")
//condicion
@Where(clause = "is_active = true")
public class User implements UserDetails, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotNull
    private String name;
    @Column(unique = true)
    @NotNull
    private String email;
    @NotNull
    private String password;
    @CurrentTimestamp(event = INSERT)
    private LocalDateTime created;
    @CurrentTimestamp(event = {INSERT, UPDATE})
    private LocalDateTime modified;
    private LocalDateTime lastLogin;
    @Column(name = "is_active", columnDefinition = "boolean default true")
    private Boolean isActive;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonManagedReference
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true,
            mappedBy = "user"
    )
    private Set<Phone> phones;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new HashSet<GrantedAuthority>();
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }
}
