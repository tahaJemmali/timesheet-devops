package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="T_EMPLOYEE")
public class Employee implements Serializable{

	private static final long serialVersionUID = 772299985077937753L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="prenom")
	private String prenom;
	private String nom;
	private String email;
	private boolean actif;
	private String password;
	@Enumerated(EnumType.STRING)
	private Role role;



	public Employee(){
		
	}

	public Employee(int id, String prenom, String nom, String email, String password, boolean isActif, Role role) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.password = password;
		this.actif = isActif;
		this.role = role;
	}
	public Employee( String prenom, String nom, String email, String password, boolean isActif, Role role) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.password = password;
		this.actif = isActif;
		this.role = role;
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isActif() {
		return actif;
	}
	public void setActif(boolean isActive) {
		this.actif = isActive;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", email=" + email + ", isActive="
				+ actif + ", password=" + password + ", role=" + role +"]";
	}


	}

