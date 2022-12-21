package se.lexicon.model;

import java.util.Objects;

public class city {
    private int id;
    private String name;
    private String countrycode;
    private String district;
    private int population;


    public city() {
    }

    public city(int id, String name, String countrycode, String district, int population) {
        setId(id);
        setName(name);
        setCountrycode(countrycode);
        setDistrict(district);
        setPopulation(population);

    }

    public city(String name, String countrycode, String district, int population) {

        setName(name);
        setCountrycode(countrycode);
        setDistrict(district);
        setPopulation(population);

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof city)) return false;
        city city = (city) o;
        return id == city.id && population == city.population && Objects.equals(name, city.name) && Objects.equals(countrycode, city.countrycode) && Objects.equals(district, city.district);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, countrycode, district, population);
    }

    @Override
    public String toString() {
        return "city{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", countrycode='" + countrycode + '\'' +
                ", district='" + district + '\'' +
                ", population=" + population +
                '}';
    }
}
