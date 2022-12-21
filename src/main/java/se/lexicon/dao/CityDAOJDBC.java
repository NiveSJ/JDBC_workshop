package se.lexicon.dao;

import se.lexicon.exception.DBConnectionException;
import se.lexicon.model.City;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// todo: improve the class name
public class CityDAOJDBC implements CityDAO {
    @Override
    public City findbyid(int id) {
        String query = "select * from world.City where id=?";
        City City = new City();


        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {


                City = new City(resultSet.getInt("id"),
                        resultSet.getString("Name"),
                        resultSet.getString("CountryCode"),
                        resultSet.getString("District"), resultSet.getInt("Population"));
                System.out.println("-------------");
            }

        } catch (DBConnectionException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return City;
    }


    @Override
    public List<City> findByCode(String code) {
        String query = "select * from world.City where CountryCode=? ";
        City City = new City();
        List<City> filteredList = new ArrayList<>();


        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setString(1, code);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                filteredList.add(new City(resultSet.getInt("id"),
                        resultSet.getString("Name"),
                        resultSet.getString("CountryCode"),
                        resultSet.getString("District"), resultSet.getInt("Population")));

            }

        } catch (DBConnectionException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return filteredList;

    }

    @Override
    public List<City> findByName(String name) {
        String query = "select * from world.City where name = ? ";
        City City = new City();
        List<City> filteredList = new ArrayList<>();


        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                filteredList.add(new City(resultSet.getInt("id"),
                        resultSet.getString("Name"),
                        resultSet.getString("CountryCode"),
                        resultSet.getString("District"), resultSet.getInt("Population")));

            }

        } catch (DBConnectionException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return filteredList;


    }

    @Override
    public List<City> findAll() {
        String query = "select * from world.City";
        City City = new City();
        List<City> filteredList = new ArrayList<>();


        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                filteredList.add(new City(resultSet.getInt("id"),
                        resultSet.getString("Name"),
                        resultSet.getString("CountryCode"),
                        resultSet.getString("District"),
                        resultSet.getInt("Population")));

            }

        } catch (DBConnectionException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return filteredList;

    }

    @Override
    public City add(City City) {
        String query = "Insert into City(name,countryCode,district,population)" +
                " values (?,?,?,?); ";

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        ) {

            preparedStatement.setString(1, City.getName());
            preparedStatement.setString(2, City.getCountrycode());
            preparedStatement.setString(3, City.getDistrict());
            preparedStatement.setInt(4, City.getPopulation());

            int AffectedRows = preparedStatement.executeUpdate();

            try (ResultSet rs = preparedStatement.getGeneratedKeys();) {
                if (rs.next())
                    City.setId(rs.getInt(1));
            }


        } catch (DBConnectionException | SQLException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
        return City;
    }

    @Override
    public City update(City City) {
        String query = "update City set name= ?,CountryCode=?,District=?,population=? where id=? ";

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {


            preparedStatement.setString(1, City.getName());
            preparedStatement.setString(2, City.getCountrycode());
            preparedStatement.setString(3, City.getDistrict());
            preparedStatement.setInt(4, City.getPopulation());

            preparedStatement.setInt(5, City.getId());


            int AffectedRows = preparedStatement.executeUpdate();


        } catch (DBConnectionException | SQLException e) {
            System.err.println(e.getMessage());
        }
        return City;
    }

    @Override
    public int delete(City City) {

        String query = "delete from City where id = ? ";
        int AffectedRows = 0;

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {

            preparedStatement.setInt(1, City.getId());
            AffectedRows = preparedStatement.executeUpdate();


        } catch (DBConnectionException | SQLException e) {
            System.err.println(e.getMessage());
        }
        return AffectedRows;


    }
}
