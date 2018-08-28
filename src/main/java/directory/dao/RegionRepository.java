package directory.dao;

import directory.dao.RegionDao;
import directory.model.Region;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class RegionRepository implements RegionDao {
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addRegion(Region region) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(region);
    }

    public void updateRegion(Region region) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(region);
    }

    public void removeRegion(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Region region = session.load(Region.class, id);

        if(region != null){
            session.delete(region);
        }
    }

    public Region getRegionById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Region region = session.load(Region.class, id);

        return region;
    }

    public List<Region> listRegions() {
        CriteriaBuilder builder = this.sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Region> criteria = builder.createQuery(Region.class);

        Session session = this.sessionFactory.getCurrentSession();
        List<Region> regions = session.createQuery(criteria).list();

        return regions;
    }

    public List<Region> findByCountryId(int countryId) {
        CriteriaBuilder builder = this.sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Region> criteria = builder.createQuery(Region.class);
        Root<Region> root = criteria.from(Region.class);

        criteria.where(
                builder.equal(root.get("country_id"), countryId)
        );

        Session session = this.sessionFactory.getCurrentSession();
        List<Region> regions = session.createQuery(criteria).list();

        return regions;
    }
}
