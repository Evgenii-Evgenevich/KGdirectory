package directory.service;

import directory.dao.RegionDao;
import directory.model.Region;
import directory.service.RegionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RegionServiceImpl implements RegionService {
    private RegionDao regionDao;

    public RegionDao getRegionDao() {
        return regionDao;
    }

    public void setRegionDao(RegionDao regionDao) {
        this.regionDao = regionDao;
    }

    @Transactional
    public void addRegion(Region region) {
        this.regionDao.addRegion(region);
    }

    @Transactional
    public void updateRegion(Region region) {
        this.regionDao.updateRegion(region);
    }

    @Transactional
    public void removeRegion(int id) {
        this.regionDao.removeRegion(id);
    }

    @Transactional
    public Region getRegionById(int id) {
        return this.regionDao.getRegionById(id);
    }

    @Transactional
    public List<Region> listRegions() {
        return this.regionDao.listRegions();
    }

    @Transactional
    public List<Region> findByCountryId(int countryId) {
        return this.regionDao.findByCountryId(countryId);
    }
}
