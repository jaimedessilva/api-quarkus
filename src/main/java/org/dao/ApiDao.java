package org.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.model.User;

import io.quarkus.panache.common.Sort;

/**
 * Projeto: api-quarkus
 * @author: jaime Dev
 * File: ApiDao.java
 * Data: 3 de nov de 2020 **/

@RequestScoped
public class ApiDao {
	
	@PersistenceContext
	EntityManager em;
	
	/*
	 * READ
	 */
	public List<User> read() {
		return User.listAll(Sort.by("id").ascending());
	}
	/*
	 * CREATE
	 */
	@Transactional
	public User create(@Valid User user) {
		if (user != null) {
			user.persistAndFlush();
		}
		return user;
	}
	/*
	 * UPDATE
	 */
	@Transactional
	public void update(@Valid User user, Long id) {
		String nomeSql = "UPDATE_USER";
		Query query = em.createNamedQuery(nomeSql);
		
		query.setParameter("nome",user.getNome());
		query.setParameter("email",user.getEmail());
		query.setParameter("telefone",user.getTelefone());
		query.setParameter("url_img",user.getUrl_img());
		query.setParameter("id",id);
		query.executeUpdate();	
	}
	/*
	 * DELETE
	 */
	@Transactional
	public void delete (Long id) {
		User user = em.find(User.class, id);
		em.remove(user);
	}
}
