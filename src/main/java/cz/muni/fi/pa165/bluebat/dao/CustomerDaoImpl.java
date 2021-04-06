package cz.muni.fi.pa165.bluebat.dao;

import cz.muni.fi.pa165.bluebat.entity.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;


/**
 * @author rudolf
 */
@Repository
public class CustomerDaoImpl implements CustomerDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public void create(Customer customer) {

        em.persist(customer);
    }

    @Override
    public void delete(Customer customer) {
        em.remove(customer);

    }

    @Override
    public void update(Customer customer) {

        em.merge(customer);
    }

    @Override
    public Customer findById(Long id) {

        return em.find(Customer.class,id);
    }

    @Override
    public List<Customer> findAll() {
        return em.createQuery("select e from Customer e", Customer.class).getResultList();

    }

}
