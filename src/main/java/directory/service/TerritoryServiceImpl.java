package directory.service;

import directory.dao.TerritoryDao;
import directory.model.Territory;
import directory.service.TerritoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TerritoryServiceImpl implements TerritoryService {
    private TerritoryDao territoryDao;

    public TerritoryDao getTerritoryDao() {
        return territoryDao;
    }

    public void setTerritoryDao(TerritoryDao territoryDao) {
        this.territoryDao = territoryDao;
    }

    @Transactional
    public void addTerritory(Territory territory) {
        this.territoryDao.addTerritory(territory);
    }

    @Transactional
    public void updateTerritory(Territory territory) {
        this.territoryDao.updateTerritory(territory);
    }

    @Transactional
    public void removeTerritory(int id) {
        this.territoryDao.removeTerritory(id);
    }

    @Transactional
    public Territory getTerritoryById(int id) {
        return this.territoryDao.getTerritoryById(id);
    }

    @Transactional
    public List<Territory> listTerritories() {
        return this.territoryDao.listTerritories();
    }

    @Transactional
    public List<Territory> findByDistrictId(int districtId) {
        return this.territoryDao.findByDistrictId(districtId);
    }
}
