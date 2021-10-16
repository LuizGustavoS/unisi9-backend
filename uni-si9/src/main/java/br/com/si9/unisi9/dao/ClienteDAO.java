package br.com.si9.unisi9.dao;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Transactional
@ApplicationScoped
public class ClienteDAO {

    @Inject
    EntityManager entityManager;

}
