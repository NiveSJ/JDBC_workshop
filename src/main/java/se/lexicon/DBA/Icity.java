package se.lexicon.DBA;

import se.lexicon.model.city;

import java.util.List;

public interface Icity {
    city findbyid(int id);
    List<city> findByCode(String code);
    List<city> findByName(String name);
    List<city> findAll();
    city add(city city);
    city update(city city);
    int delete(city city);

}
