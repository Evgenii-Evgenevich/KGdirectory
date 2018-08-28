package directory.dao;

import directory.model.District;
import java.util.List;

public interface DistrictDao {
    public void addDistrict(District country);

    public void updateDistrict(District country);

    public void removeDistrict(int id);

    public District getDistrictById(int id);

    public List<District> listDistricts();

    public List<District> findByRegionId(int regionId);
}

