package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DatabaseAPIs {

    public DatabaseAPIs(){ }

    final private String dbUrl = "jdbc:ucanaccess://C://Users//lol23//OneDrive//Desktop//test.accdb";

    public void insertPerson(String Name, String Surname){
        try (Connection connection = DriverManager.getConnection(dbUrl)) {


            String sql = "INSERT INTO People (Name, Surname) VALUES (?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, Name);
            preparedStatement.setString(2, Surname);

            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public List<String> getIndex(int Index) {
        try (Connection connection = DriverManager.getConnection(dbUrl)) {

            String sql = "SELECT * FROM People";

            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                int id = result.getInt("ID");
                String name = result.getString("Name");
                String surname = result.getString("Surname");
                if(id==Index) return Arrays.asList(name,surname);
            }
            return null;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;

    }
    public void printAllPersons() {
        try (Connection connection = DriverManager.getConnection(dbUrl)) {

            String sql = "SELECT * FROM People";

            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                int id = result.getInt("ID");
                String name = result.getString("Name");
                String surname = result.getString("Surname");
                System.out.println(id+" "+name+" "+surname);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }



    }


}
