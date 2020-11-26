package org.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.sun.istack.NotNull;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

/**
 * Projeto: api-quarkus
 * @author: jaime Dev
 * File: User.java
 * Data: 3 de nov de 2020 **/

@Entity
@Table(name="t_user")
@NamedNativeQueries({
	@NamedNativeQuery(name="UPDATE_USER", 
			query="UPDATE T_USER SET "
					+ "nome = :nome, "
					+ "email = :email, "
					+ "telefone = :telefone, "
					+ "url_img = :url_img"
					+ " WHERE id = :id")
})
public class User extends PanacheEntityBase {
	
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull @NotBlank
	private String nome;
	@Pattern(regexp=".+@.+\\..+")
	private String email;
	@NotBlank @NotNull
	private String telefone;
	private String url_img;
	/* Getter */
	public Long getId() {
		return id;
	}
	/* Setter */
	public void setId(Long id) {
		this.id = id;
	}
	/* Getter */
	public String getNome() {
		return nome;
	}
	/* Setter */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/* Getter */
	public String getEmail() {
		return email;
	}
	/* Setter */
	public void setEmail(String email) {
		this.email = email;
	}
	/* Getter */
	public String getTelefone() {
		return telefone;
	}
	/* Setter */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	/* Getter */
	public String getUrl_img() {
		return url_img;
	}
	/* Setter */
	public void setUrl_img(String url_img) {
		this.url_img = url_img;
	}
	
}
