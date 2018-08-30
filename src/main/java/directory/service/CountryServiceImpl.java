package directory.service;

import directory.dao.CountryDao;
import directory.model.Country;
import directory.service.CountryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    private CountryDao countryDao;

    public CountryDao getCountryDao() {
        return countryDao;
    }

    public void setCountryDao(CountryDao countryDao) {
        this.countryDao = countryDao;
    }

    @Transactional
    public void addCountry(Country country) {
        this.countryDao.addCountry(country);
    }

    @Transactional
    public void updateCountry(Country country) {
        this.countryDao.updateCountry(country);
    }

    @Transactional
    public void removeCountry(int id) {
        this.countryDao.removeCountry(id);
    }

    @Transactional
    public Country getCountryById(int id) {
        return this.countryDao.getCountryById(id);
    }

    @Transactional
    public List<Country> listCountries() {
        return this.countryDao.listCountries();
    }
}
