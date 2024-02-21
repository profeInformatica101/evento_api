package com.example.evento_api.entidad;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.evento_api.entidad.enumerado.Role;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Usuario implements UserDetails {
	  private static final long serialVersionUID = 1L;
	  	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	  	
	  	@NotBlank(message = "El email no puede estar vacío.")
	    @Email(message = "Formato de email inválido.")
	    @Column(unique = true)
	    private String email;
	  	
	  	@NotBlank(message = "La contraseña no puede estar vacía.")
	    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres.")
	    private String password;

	    @ElementCollection(fetch = FetchType.EAGER, targetClass = Role.class)
	    @Enumerated(EnumType.STRING)
	    @CollectionTable(name="usuario_rol")
	    @Column(name ="RolesUsuario")
	    private Set<Role> roles = new HashSet<>();
	    
	    @ManyToMany(mappedBy = "usuariosInscritos")
	    private Set<Evento> eventosInscritos = new HashSet<>();

		@Override
	    public Collection<? extends GrantedAuthority> getAuthorities() {
	        // Cargar la colección de roles de manera temprana
	        roles.size(); // Esto carga la colección de roles

	        return roles.stream()
	                .map(role -> new SimpleGrantedAuthority(role.name()))
	                .collect(Collectors.toList());
	    }

		@Override
		public String getPassword() {
			// TODO Auto-generated method stub
			return password;
		}

		@Override
		public String getUsername() {
			
			return email;
		}

		@Override
		public boolean isAccountNonExpired() {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public boolean isAccountNonLocked() {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public boolean isEnabled() {
			// TODO Auto-generated method stub
			return true;
		}
}
