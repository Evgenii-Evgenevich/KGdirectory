package directory.service;

import directory.model.District;

import java.util.List;

public interface DistrictService {
    public void addDistrict(District district);

    public void updateDistrict(District district);

    public void removeDistrict(int id);

    public District getDistrictById(int id);

    public List<District> listDistricts();

    public List<District> findByRegionId(int regionId);
}
