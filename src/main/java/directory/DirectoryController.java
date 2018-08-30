package directory;

import directory.model.*;
import directory.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping(
            value = "/",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Map<String, List>> listCountries() {
        Map<String, List> res = new HashMap<String, List>();

        List<Country> countries = this.countryService.listCountries();

        res.put("countries", countries);

        return new ResponseEntity(res, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{country_id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Map<String, List>> listRegions(
            @PathVariable("country_id") int countryId
    ) {
        Map<String, List> res = new HashMap<String, List>();

        List<Country> countries = this.countryService.listCountries();
        List<Region> regions = this.regionService.findByCountryId(countryId);

        res.put("countries", countries);
        res.put("regions", regions);

        return new ResponseEntity(res, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{country_id}/{region_id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Map<String, List>> listDistricts(
            @PathVariable("country_id") int countryId,
            @PathVariable("region_id") int regionId
    ) {
        Map<String, List> res = new HashMap<String, List>();

        List<Country> countries = this.countryService.listCountries();
        List<Region> regions = this.regionService.findByCountryId(countryId);
        List<District> districts = this.districtService.findByRegionId(regionId);

        res.put("countries", countries);
        res.put("districts", regions);
        res.put("regions", districts);

        return new ResponseEntity(res, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{country_id}/{region_id}/{district_id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Map<String, List>> listTerritories(
            @PathVariable("country_id") int countryId,
            @PathVariable("region_id") int regionId,
            @PathVariable("district_id") int districtId
    ) {
        Map<String, List> res = new HashMap<String, List>();

        List<Country> countries = this.countryService.listCountries();
        List<Region> regions = this.regionService.findByCountryId(countryId);
        List<District> districts = this.districtService.findByRegionId(regionId);
        List<Territory> territories = this.territoryService.findByDistrictId(districtId);

        res.put("countries", countries);
        res.put("regions", regions);
        res.put("districts", districts);
        res.put("territories", territories);

        return new ResponseEntity(res, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{country_id}/{region_id}/{district_id}/{territory_id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Map<String, List>> listLocalities(
            @PathVariable("country_id") int countryId,
            @PathVariable("region_id") int regionId,
            @PathVariable("district_id") int districtId,
            @PathVariable("territory_id") int territoryId
    ) {
        Map<String, List> res = new HashMap<String, List>();

        List<Country> countries = this.countryService.listCountries();
        List<Region> regions = this.regionService.findByCountryId(countryId);
        List<District> districts = this.districtService.findByRegionId(regionId);
        List<Territory> territories = this.territoryService.findByDistrictId(districtId);
        List<Locality> localities = this.localityService.findByTerritoryId(territoryId);

        res.put("countries", countries);
        res.put("regions", regions);
        res.put("districts", districts);
        res.put("territories", territories);
        res.put("localities", localities);

        return new ResponseEntity(res, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{country_id}/{region_id}/{district_id}/{territory_id}/{locality_id}/",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Map<String, List>> locality(
            @PathVariable("country_id") int countryId,
            @PathVariable("region_id") int regionId,
            @PathVariable("district_id") int districtId,
            @PathVariable("territory_id") int territoryId,
            @PathVariable("locality_id") int localityId
    ) {
        Map<String, List> res = new HashMap<String, List>();

        List<Country> countries = this.countryService.listCountries();
        List<Region> regions = this.regionService.findByCountryId(countryId);
        List<District> districts = this.districtService.findByRegionId(regionId);
        List<Territory> territories = this.territoryService.findByDistrictId(districtId);
        List<Locality> localities = this.localityService.findByTerritoryId(territoryId);
        Locality locality = this.localityService.getLocalityById(localityId);

        res.put("countries", countries);
        res.put("regions", regions);
        res.put("districts", districts);
        res.put("territories", territories);
        res.put("localities", localities);
        res.put("cur_locality", Collections.singletonList(locality));

        return new ResponseEntity(res,
                localities.contains(locality) ? HttpStatus.OK : HttpStatus.BAD_REQUEST
        );
    }
}
