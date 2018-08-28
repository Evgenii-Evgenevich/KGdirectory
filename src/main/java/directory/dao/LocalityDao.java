package directory.dao;

import directory.model.Locality;
import java.util.List;

public interface LocalityDao {
    public void addLocality(Locality country);

    public void updateLocality(Locality country);

    public void removeLocality(int id);

    public Locality getLocalityById(int id);

    public List<Locality> listLocalities();

    public List<Locality> findByTerritoryId(int territoryId);

}
