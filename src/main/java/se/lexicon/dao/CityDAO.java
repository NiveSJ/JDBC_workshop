package se.lexicon.dao;

import se.lexicon.model.City;

import java.util.List;

// todo: improve the interface name
public interface CityDAO {
    City findbyid(int id);
    List<City> findByCode(String code);
    List<City> findByName(String name);
    List<City> findAll();
    City add(City City);
    City update(City City);
    int delete(City City);

}
