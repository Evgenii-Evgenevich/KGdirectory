package directory.service;

import directory.dao.LocalityDao;
import directory.model.Locality;
import directory.service.LocalityService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LocalityServiceImpl implements LocalityService {
    private LocalityDao localityDao;

    public LocalityDao getLocalityDao() {
        return localityDao;
    }

    public void setLocalityDao(LocalityDao localityDao) {
        this.localityDao = localityDao;
    }

    @Transactional
    public void addLocality(Locality locality) {
        this.localityDao.addLocality(locality);
    }

    @Transactional
    public void updateLocality(Locality locality) {
        this.localityDao.updateLocality(locality);
    }

    @Transactional
    public void removeLocality(int id) {
        this.localityDao.removeLocality(id);
    }

    @Transactional
    public Locality getLocalityById(int id) {
        return this.localityDao.getLocalityById(id);
    }

    @Transactional
    public List<Locality> listLocalities() {
        return this.localityDao.listLocalities();
    }

    @Transactional
    public List<Locality> findByTerritoryId(int territoryId) {
        return this.localityDao.findByTerritoryId(territoryId);
    }
}
