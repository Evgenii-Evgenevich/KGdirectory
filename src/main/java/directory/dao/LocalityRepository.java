package directory.dao;

import directory.dao.LocalityDao;
import directory.model.Locality;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public void addLocality(Locality locality) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(locality);
    }

    @Transactional
    public void updateLocality(Locality locality) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(locality);
    }

    @Transactional
    public void removeLocality(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Locality locality = (Locality) session.load(Locality.class, id);

        if(locality != null){
            session.delete(locality);
        }
    }

    @Transactional
    public Locality getLocalityById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Locality locality = session.load(Locality.class, id);

        return locality;
    }

    @Transactional
    public List<Locality> listLocalities() {
        CriteriaBuilder builder = this.sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Locality> criteria = builder.createQuery(Locality.class);
        Root<Locality> root = criteria.from(Locality.class);

        criteria.select(root);

        Session session = this.sessionFactory.getCurrentSession();
        List<Locality> localities = session.createQuery(criteria).list();

        return localities;
    }

    @Transactional
    public List<Locality> findByTerritoryId(int territoryId) {
        CriteriaBuilder builder = this.sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Locality> criteria = builder.createQuery(Locality.class);
        Root<Locality> root = criteria.from(Locality.class);

        criteria.select(root).where(
                builder.equal(root.get("territoryId"), territoryId)
        );

        Session session = this.sessionFactory.getCurrentSession();
        List<Locality> localities = session.createQuery(criteria).list();

        return localities;
    }
}
