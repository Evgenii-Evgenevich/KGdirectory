package directory.dao;

import directory.dao.LocalityDao;
import directory.model.Locality;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class LocalityRepository implements LocalityDao {
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addLocality(Locality locality) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(locality);
    }

    public void updateLocality(Locality locality) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(locality);
    }

    public void removeLocality(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Locality locality = (Locality) session.load(Locality.class, id);

        if(locality != null){
            session.delete(locality);
        }
    }

    public Locality getLocalityById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Locality locality = session.load(Locality.class, id);

        return locality;
    }

    public List<Locality> listLocalities() {
        CriteriaBuilder builder = this.sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Locality> criteria = builder.createQuery(Locality.class);

        Session session = this.sessionFactory.getCurrentSession();
        List<Locality> localities = session.createQuery(criteria).list();

        return localities;
    }

    public List<Locality> findByTerritoryId(int territoryId) {
        CriteriaBuilder builder = this.sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Locality> criteria = builder.createQuery(Locality.class);
        Root<Locality> root = criteria.from(Locality.class);

        criteria.where(
                builder.equal(root.get("territory_id"), territoryId)
        );

        Session session = this.sessionFactory.getCurrentSession();
        List<Locality> localities = session.createQuery(criteria).list();

        return localities;
    }
}
