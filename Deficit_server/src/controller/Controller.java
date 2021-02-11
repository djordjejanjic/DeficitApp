/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.DBBroker;
import domain.User;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import thread.Client;
import thread.StartServer;

/**
 *
 * @author Djordje Janjic
 */
public class Controller {
    private static Controller instance;
    private DBBroker db;
    
    private Controller() {
        db = new DBBroker();
    }

    public static Controller getInstance() {
        if(instance == null)
            instance = new Controller();
        return instance;
    }

    public List<User> getUser(){
        try {
            List<User> users;
            db.openConnection();
            users = db.getAllUsers();   
            return users;
        } catch (SQLException ex) {
            System.out.println("Greška pri vraćanju korisnika.");
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            db.closeConnection();
        }
        return null;
    }

    public void stopServer(Client client, StartServer startServer) {
        client.interrupt();
        System.out.println("Klijent gotov");
        startServer.interrupt();
        System.out.println("Server gotov");
        System.exit(0);
    }
    
    
}
