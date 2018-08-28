package directory.service;

import directory.model.Territory;

import java.util.List;

public interface TerritoryService {
    public void addTerritory(Territory territory);

    public void updateTerritory(Territory territory);

    public void removeTerritory(int id);

    public Territory getTerritoryById(int id);

    public List<Territory> listTerritories();

    public List<Territory> findByDistrictId(int districtId);
}
