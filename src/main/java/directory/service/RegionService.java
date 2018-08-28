package directory.service;

import directory.model.Region;

import java.util.List;

public interface RegionService {
    public void addRegion(Region region);

    public void updateRegion(Region region);

    public void removeRegion(int id);

    public Region getRegionById(int id);

    public List<Region> listRegions();

    public List<Region> findByCountryId(int countryId);
}
