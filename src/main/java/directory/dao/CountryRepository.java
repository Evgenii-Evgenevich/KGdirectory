package directory.dao;

import directory.dao.CountryDao;
import directory.model.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

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

    public void addCountry(Country country) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(country);
    }

    public void updateCountry(Country country) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(country);
    }

    public void removeCountry(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Country country = session.load(Country.class, id);

        if(country != null){
            session.delete(country);
        }
    }

    public Country getCountryById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Country country = session.load(Country.class, id);

        return country;
    }

    public List<Country> listCountries() {
        CriteriaBuilder builder = this.sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Country> criteria = builder.createQuery(Country.class);

        Session session = this.sessionFactory.getCurrentSession();
        List<Country> countries = session.createQuery(criteria).list();

        return countries;
    }
}
