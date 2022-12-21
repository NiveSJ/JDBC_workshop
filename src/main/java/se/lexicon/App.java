package se.lexicon;

import se.lexicon.dao.CityDAO;
import se.lexicon.dao.CityDAOJDBC;
import se.lexicon.model.City;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        CityDAO city = new CityDAOJDBC();
        System.out.println(city.findbyid(4));

        System.out.println("Find All\n");
        System.out.println(city.findAll());

        System.out.println("\n find by code");

        city.findByCode("ARG").forEach(System.out::println);

        System.out.println("\n find by Name");
        city.findByName("Usalmpatti").forEach(System.out::println);

        System.out.println("\n Add new City");

       // city.add(new City("Usalmpatti", "IND", "Madurai", 12000));

        System.out.println("\n update City");
        city.update(new City(4082, "Usalmpatti", "IND", "Madurai", 13000));

        System.out.println("\n delete City");

        city.delete(new City(4085, "Usalmpatti", "IND", "Madurai", 13000));

    }
}
