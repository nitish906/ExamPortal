package com.exam.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String username;
	
	private String password;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String profile;
	
	private String phone;
	
	private boolean enabled=true;
	
	//User many roles (Note:-Define One to Many Relationship)
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "user")
	@JsonIgnore
	private Set<UserRole> userRoles=new HashSet<>();

}