package se.lexicon.DBA;

import se.lexicon.exception.DBConnectionException;
import se.lexicon.model.city;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class cityImpl implements Icity {
    @Override
    public city findbyid(int id) {
        String query = "select * from world.city where id=?";
        city city = new city();


        try (
                Connection connection = SQLConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {


                city = new city(resultSet.getInt("id"),
                        resultSet.getString("Name"),
                        resultSet.getString("CountryCode"),
                        resultSet.getString("District"), resultSet.getInt("Population"));
                System.out.println("-------------");
            }

        } catch (DBConnectionException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return city;
    }


    @Override
    public List<city> findByCode(String code) {
        String query = "select * from world.city where CountryCode=? ";
        city city = new city();
        List<city> filteredList = new ArrayList<>();


        try (
                Connection connection = SQLConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setString(1, code);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                filteredList.add(new city(resultSet.getInt("id"),
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
    public List<city> findByName(String name) {
        String query = "select * from world.city where name = ? ";
        city city = new city();
        List<city> filteredList = new ArrayList<>();


        try (
                Connection connection = SQLConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                filteredList.add(new city(resultSet.getInt("id"),
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
    public List<city> findAll() {
        String query = "select * from world.city";
        city city = new city();
        List<city> filteredList = new ArrayList<>();


        try (
                Connection connection = SQLConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                filteredList.add(new city(resultSet.getInt("id"),
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
    public city add(city city) {
        String query = "Insert into city(name,countryCode,district,population)" +
                " values (?,?,?,?); ";

        try (
                Connection connection = SQLConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            connection.setAutoCommit(false);

            System.out.println(city);


            preparedStatement.setString(1, city.getName());
            preparedStatement.setString(2, city.getCountrycode());
            preparedStatement.setString(3, city.getDistrict());
            preparedStatement.setInt(4, city.getPopulation());

            int AffectedRows = preparedStatement.executeUpdate();


            connection.commit();

        } catch (DBConnectionException | SQLException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
        return city;
    }

    @Override
    public city update(city city) {
        String query = "update city set name= ? where id=? ";

        try (
                Connection connection = SQLConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            connection.setAutoCommit(false);

            preparedStatement.setString(1, city.getName());
            preparedStatement.setInt(2, city.getId());


            int AffectedRows = preparedStatement.executeUpdate();



            connection.commit();

        } catch (DBConnectionException | SQLException e) {
            System.err.println(e.getMessage());
        }
        return city;
    }

    @Override
    public int delete(city city) {

        String query = "delete from city where id = ? ";
        int AffectedRows = 0;

        try (
                Connection connection = SQLConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            connection.setAutoCommit(false);

            preparedStatement.setInt(1, city.getId());


             AffectedRows = preparedStatement.executeUpdate();



            connection.commit();

        } catch (DBConnectionException | SQLException e) {
            System.err.println(e.getMessage());
        }
        return AffectedRows;



    }
}
