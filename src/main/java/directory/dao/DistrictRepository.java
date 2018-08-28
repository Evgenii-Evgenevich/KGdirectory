package directory.dao;

import directory.dao.DistrictDao;
import directory.model.District;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class DistrictRepository implements DistrictDao {
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addDistrict(District district) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(district);
    }

    public void updateDistrict(District district) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(district);
    }

    public void removeDistrict(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        District district = session.load(District.class, id);

        if(district != null){
            session.delete(district);
        }
    }

    public District getDistrictById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        District district = session.load(District.class, id);

        return district;
    }

    @SuppressWarnings("unchecked")
    public List<District> listDistricts() {
        CriteriaBuilder builder = this.sessionFactory.getCriteriaBuilder();
        CriteriaQuery<District> criteria = builder.createQuery(District.class);

        Session session = this.sessionFactory.getCurrentSession();
        List<District> districts = session.createQuery(criteria).list();

        return districts;
    }

    @SuppressWarnings("unchecked")
    public List<District> findByRegionId(int regionId) {
        CriteriaBuilder builder = this.sessionFactory.getCriteriaBuilder();
        CriteriaQuery<District> criteria = builder.createQuery(District.class);
        Root<District> root = criteria.from(District.class);

        criteria.where(
                builder.equal(root.get("region_id"), regionId)
        );

        Session session = this.sessionFactory.getCurrentSession();
        List<District> districts = session.createQuery(criteria).list();

        return districts;
    }
}
