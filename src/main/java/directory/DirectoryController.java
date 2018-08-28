package directory;

import directory.model.*;
import directory.service.*;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class DirectoryController {
    private CountryService countryService;
    private RegionService regionService;
    private DistrictService districtService;
    private TerritoryService territoryService;
    private LocalityService localityService;

    public CountryService getCountryService() {
        return countryService;
    }

    @Autowired(required = true)
    @Qualifier(value = "countryService")
    public void setCountryService(CountryService countryService) {
        this.countryService = countryService;
    }

    public RegionService getRegionService() {
        return regionService;
    }

    @Autowired(required = true)
    @Qualifier(value = "regionService")
    public void setRegionService(RegionService regionService) {
        this.regionService = regionService;
    }

    public DistrictService getDistrictService() {
        return districtService;
    }

    @Autowired(required = true)
    @Qualifier(value = "districtService")
    public void setDistrictService(DistrictService districtService) {
        this.districtService = districtService;
    }

    public TerritoryService getTerritoryService() {
        return territoryService;
    }

    @Autowired(required = true)
    @Qualifier(value = "territoryService")
    public void setTerritoryService(TerritoryService territoryService) {
        this.territoryService = territoryService;
    }

    public LocalityService getLocalityService() {
        return localityService;
    }

    @Autowired(required = true)
    @Qualifier(value = "localityService")
    public void setLocalityService(LocalityService localityService) {
        this.localityService = localityService;
    }

    @RequestMapping(value = "/",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String listCountries() {

        List<Country> countries = this.countryService.listCountries();

        return countries.toString();
    }

    @RequestMapping(value = "/{country_id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String listRegions(@PathVariable("country_id") int countryId) {

        List<Country> countries = this.countryService.listCountries();
        List<Region> regions = this.regionService.findByCountryId(countryId);

        return regions.toString();
    }

    @RequestMapping(value = "/{country_id}/{region_id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String listDistricts(@PathVariable("country_id") int countryId,
                              @PathVariable("region_id") int regionId) {

        List<Country> countries = this.countryService.listCountries();
        List<Region> regions = this.regionService.findByCountryId(countryId);
        List<District> districts = this.districtService.findByRegionId(regionId);

        return districts.toString();
    }

    @RequestMapping(value = "/{country_id}/{region_id}/{district_id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String listTerritories(@PathVariable("country_id") int countryId,
                                @PathVariable("region_id") int regionId,
                                @PathVariable("district_id") int districtId) {

        List<Country> countries = this.countryService.listCountries();
        List<Region> regions = this.regionService.findByCountryId(countryId);
        List<District> districts = this.districtService.findByRegionId(regionId);
        List<Territory> territories = this.territoryService.findByDistrictId(districtId);

        return territories.toString();
    }

    @RequestMapping(value = "/{country_id}/{region_id}/{district_id}/{territory_id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String listLocalities(@PathVariable("country_id") int countryId,
                               @PathVariable("region_id") int regionId,
                               @PathVariable("district_id") int districtId,
                               @PathVariable("territory_id") int territoryId) {

        List<Country> countries = this.countryService.listCountries();
        List<Region> regions = this.regionService.findByCountryId(countryId);
        List<District> districts = this.districtService.findByRegionId(regionId);
        List<Territory> territories = this.territoryService.findByDistrictId(districtId);
        List<Locality> localities = this.localityService.findByTerritoryId(territoryId);

        return localities.toString();
    }
}
