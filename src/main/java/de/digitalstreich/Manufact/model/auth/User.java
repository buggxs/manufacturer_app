package de.digitalstreich.Manufact.model.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import de.digitalstreich.Manufact.model.Manufacturer;
import de.digitalstreich.Manufact.model.Retailer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.lang.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Transient
    @JsonIgnore
    private String passwordConfirm;

    private boolean isAccountNonExpired;

    private boolean isAccountNonLocked;

    private boolean isCredentialsNonExpired;

    private boolean isEnabled;

    @OneToOne(targetEntity = Role.class, cascade = CascadeType.MERGE)
    @JsonIgnore
    private Role role;

    @Nullable
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Manufacturer manufacturer;

    @Nullable
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Retailer retailer;

    @CreationTimestamp
    @Column(name = "created_at", columnDefinition = "DATETIME default CURRENT_TIMESTAMP")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", columnDefinition = "DATETIME default CURRENT_TIMESTAMP")
    private Date updatedAt;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRole().getGrantedAuthority();
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    public User(String email, String password, String passwordConfirm, boolean isAccountNonExpired, boolean isAccountNonLocked, boolean isCredentialsNonExpired, boolean isEnabled, Role role, @Nullable Manufacturer manufacturer, @Nullable Retailer retailer) {
        this.email = email;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
        this.isAccountNonExpired = isAccountNonExpired;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isCredentialsNonExpired = isCredentialsNonExpired;
        this.isEnabled = isEnabled;
        this.role = role;
        this.manufacturer = manufacturer;
        this.retailer = retailer;
    }

    public User(String email, String password, boolean isAccountNonExpired, boolean isAccountNonLocked, boolean isCredentialsNonExpired, boolean isEnabled, Role role) {
        this.email = email;
        this.password = password;
        this.isAccountNonExpired = isAccountNonExpired;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isCredentialsNonExpired = isCredentialsNonExpired;
        this.isEnabled = isEnabled;
        this.role = role;
    }

    public User(String email, String password, boolean isAccountNonExpired, boolean isAccountNonLocked, boolean isCredentialsNonExpired, boolean isEnabled) {
        this.email = email;
        this.password = password;
        this.isAccountNonExpired = isAccountNonExpired;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isCredentialsNonExpired = isCredentialsNonExpired;
        this.isEnabled = isEnabled;

    }

    public void setManufacturer(@Nullable Manufacturer manufacturer) {
        assert manufacturer != null;
        manufacturer.setId(this.id);
        this.manufacturer = manufacturer;
    }
}
