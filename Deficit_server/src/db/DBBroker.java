/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domain.Entry;
import domain.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Djordje Janjic
 */
public class DBBroker {
    private Connection connection;

    public DBBroker() {
    }
    
    public void openConnection(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/deficitdb", "root", "CrvenaZvezda91!");
            connection.setAutoCommit(false);
        } catch (SQLException ex) {
            System.out.println("Greška u konekciji sa bazom.");
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void closeConnection(){
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void commit(){
        try {
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void rollback(){
        try {
            connection.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM user";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        
        while(resultSet.next()){
            User user = new User(resultSet.getLong("idUser"), 
                    resultSet.getString("firstName"), resultSet.getString("lastName"), 
                    resultSet.getString("username"), resultSet.getString("password"), null);
            List<Entry> entries = getEntry(user);
            user.setEntry(entries);
            
            users.add(user);
        }
        return users;
    }

    private List<Entry> getEntry(User user) throws SQLException {
        List<Entry> entries = new ArrayList<>();
        String query = "SELECT * FROM entry WHERE idUser = "+user.getIdUser();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        
        while(resultSet.next()){
            Entry entry = new Entry(resultSet.getLong("idEntry"), resultSet.getDouble("kcalAmount"), resultSet.getDate("entryDate"));
            entries.add(entry);
        }
        return entries;
    }
    
}
