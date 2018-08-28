package directory.service;

import directory.model.Locality;

import java.util.List;

public interface LocalityService {
    public void addLocality(Locality locality);

    public void updateLocality(Locality locality);

    public void removeLocality(int id);

    public Locality getLocalityById(int id);

    public List<Locality> listLocalities();

    public List<Locality> findByTerritoryId(int territoryId);
}
