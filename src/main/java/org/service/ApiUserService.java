package org.service;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.dao.ApiDao;
import org.model.User;

/**
 * Projeto: api-quarkus
 * @author: jaime Dev
 * File: ApiUserService.java
 * Data: 3 de nov de 2020 **/

@RequestScoped
public class ApiUserService {
	
	@Inject
	ApiDao dao;
	
	/*
	 * LISTAR
	 */
	public List<User> listar (){
		return dao.read();
	}
	/*
	 * INSERT
	 */
	@Transactional
	public void insert (User user) {
		dao.create(user);
	}
	/*
	 * ATUALIZAR
	 */
	@Transactional
	public void update (User user, Long id) {
		dao.update(user, id);
	}

	/*
	 * DELETE
	 */
	@Transactional
	public void delete (Long id) {
		dao.delete(id);
	}

}
