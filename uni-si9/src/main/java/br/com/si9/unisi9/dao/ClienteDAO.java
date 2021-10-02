package br.com.si9.unisi9.dao;

import br.com.si9.unisi9.orm.Cliente;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@ApplicationScoped
public class ClienteDAO {

    @Inject
    EntityManager entityManager;

    public Cliente gravarCliente(Cliente cliente){
        entityManager.persist(cliente);
        return cliente;
    }

    public Cliente editarCliente(Cliente cliente){
        entityManager.merge(cliente);
        return cliente;
    }

    public void deletarCliente(Integer idCliente){
        Cliente cliente = (Cliente) entityManager
                .createQuery("FROM Cliente WHERE idCliente = " + idCliente)
                .getSingleResult();
        entityManager.remove(cliente);
    }

    public List<Cliente> listarCliente(){
        return entityManager.createQuery("FROM Cliente c").getResultList();
    }

    public Cliente findByName(String dsNome){

        Query query = entityManager.createQuery("SELECT c FROM Cliente c WHERE c.dsNome = :nome")
                .setParameter("nome", dsNome);

        return (Cliente) query.getSingleResult();
    }

}
