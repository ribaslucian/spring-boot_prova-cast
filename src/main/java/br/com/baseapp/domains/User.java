package br.com.baseapp.domains;

import java.util.Arrays;
import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(
    name = "users"
    // uniqueConstraints = @UniqueConstraint(columnNames={"id", "name"})
)
// public class User implements UserDetails {
public class User  {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    
    @Column(unique = true)
    private String name;

    private String fullName;

    private String password;
    
    private String hierarchy;

    private String authorities;

    // @Override
    // public Collection<? extends GrantedAuthority> getAuthorities() {
    //     return Arrays.stream(authorities.split(","))
    //         .map(SimpleGrantedAuthority::new)
    //         .collect(Collectors.toList());
    // }

    // @Override
    // public String getUsername() {
    //     // TODO Auto-generated method stub
    //     return this.getName();
    // }

    // @Override
    // public boolean isAccountNonExpired() {
    //     return true;
    // }

    // @Override
    // public boolean isAccountNonLocked() {
    //     return true;
    // }

    // @Override
    // public boolean isCredentialsNonExpired() {
    //     return true;
    // }

    // @Override
    // public boolean isEnabled() {
    //     return true;
    // }
    
}
