package directory.dao;

import directory.dao.CountryDao;
import directory.model.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class CountryRepository implements CountryDao {
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public void addCountry(Country country) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(country);
    }

    @Transactional
    public void updateCountry(Country country) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(country);
    }

    @Transactional
    public void removeCountry(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Country country = session.load(Country.class, id);

        if(country != null){
            session.delete(country);
        }
    }

    @Transactional
    public Country getCountryById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Country country = session.load(Country.class, id);

        return country;
    }

    @Transactional
    public List<Country> listCountries() {
        CriteriaBuilder builder = this.sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Country> criteria = builder.createQuery(Country.class);
        Root<Country> root = criteria.from(Country.class);
        criteria.select(root);

        Session session = this.sessionFactory.getCurrentSession();
        List<Country> countries = session.createQuery(criteria).list();

        return countries;
    }
}
