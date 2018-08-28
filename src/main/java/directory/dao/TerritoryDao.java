package directory.dao;

import directory.model.Territory;

import java.util.List;

public interface TerritoryDao {
    public void addTerritory(Territory country);

    public void updateTerritory(Territory country);

    public void removeTerritory(int id);

    public Territory getTerritoryById(int id);

    public List<Territory> listTerritories();

    public List<Territory> findByDistrictId(int districtId);
}
