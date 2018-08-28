package directory.dao;

import directory.dao.TerritoryDao;
import directory.model.Territory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class TerritoryRepository implements TerritoryDao {
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addTerritory(Territory territory) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(territory);
    }

    public void updateTerritory(Territory territory) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(territory);
    }

    public void removeTerritory(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Territory territory = session.load(Territory.class, id);

        if(territory != null){
            session.delete(territory);
        }
    }

    public Territory getTerritoryById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Territory territory = session.load(Territory.class, id);

        return territory;
    }

    public List<Territory> listTerritories() {
        CriteriaBuilder builder = this.sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Territory> criteria = builder.createQuery(Territory.class);

        Session session = this.sessionFactory.getCurrentSession();
        List<Territory> territories = session.createQuery(criteria).list();

        return territories;
    }

    public List<Territory> findByDistrictId(int districtId) {
        CriteriaBuilder builder = this.sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Territory> criteria = builder.createQuery(Territory.class);
        Root<Territory> root = criteria.from(Territory.class);

        criteria.where(
                builder.equal(root.get("district_id"), districtId)
        );

        Session session = this.sessionFactory.getCurrentSession();
        List<Territory> territories = session.createQuery(criteria).list();

        return territories;
    }
}
