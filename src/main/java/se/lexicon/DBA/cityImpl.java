package se.lexicon.DBA;

import se.lexicon.exception.DBConnectionException;
import se.lexicon.model.city;

import java.sql.*;
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


                city=new city(resultSet.getInt("id"),
                        resultSet.getString("Name"),
                        resultSet.getString("CountryCode"),
                        resultSet.getString("District"),resultSet.getInt("Population"));
                System.out.println("-------------");
            }

        } catch (DBConnectionException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return city;
    }


    @Override
    public List<city> findByCode(String code) {
        return null;
    }

    @Override
    public List<city> findByName(String name) {
        return null;
    }

    @Override
    public List<city> findAll() {
        return null;
    }

    @Override
    public city add(city city) {
        return null;
    }

    @Override
    public city update(city city) {
        return null;
    }

    @Override
    public int delete(city city) {
        return 0;
    }
}
