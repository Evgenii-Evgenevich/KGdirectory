package directory.dao;

import directory.model.Country;
import java.util.List;

public interface CountryDao {
    public void addCountry(Country country);

    public void updateCountry(Country country);

    public void removeCountry(int id);

    public Country getCountryById(int id);

    public List<Country> listCountries();
}
