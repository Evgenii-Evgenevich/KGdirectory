package directory.service;

import directory.dao.DistrictDao;
import directory.model.District;
import directory.service.DistrictService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService {
    private DistrictDao districtDao;

    public DistrictDao getDistrictDao() {
        return districtDao;
    }

    public void setDistrictDao(DistrictDao districtDao) {
        this.districtDao = districtDao;
    }

    @Transactional
    public void addDistrict(District district) {
        this.districtDao.addDistrict(district);
    }

    @Transactional
    public void updateDistrict(District district) {
        this.districtDao.updateDistrict(district);
    }

    @Transactional
    public void removeDistrict(int id) {
        this.districtDao.removeDistrict(id);
    }

    @Transactional
    public District getDistrictById(int id) {
        return this.districtDao.getDistrictById(id);
    }

    @Transactional
    public List<District> listDistricts() {
        return this.districtDao.listDistricts();
    }

    @Transactional
    public List<District> findByRegionId(int regionId) {
        return this.districtDao.findByRegionId(regionId);
    }
}
