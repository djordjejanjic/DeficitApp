/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communication;

import constant.Constant;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Djordje Janjic
 */
public class ServerCommunication {
    private static ServerCommunication instance;
    Socket socket;

    private ServerCommunication() {
        try {
            socket = new Socket("localhost", Constant.PORT);
        } catch (IOException ex) {
            System.out.println("Neuspešno uspostavljena komunikacija sa serverom.");
            Logger.getLogger(ServerCommunication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ServerCommunication getInstance() {
        if(instance == null){
            instance = new ServerCommunication();
        }
        return instance;
    }
    
    public ServerResponse getResponse() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            return (ServerResponse) objectInputStream.readObject();
        } catch (IOException ex) {
            System.out.println("Greška prilikom uzimanja zahteva.");
            Logger.getLogger(ServerCommunication.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("Greška prilikom čitanja zahteva.");
            Logger.getLogger(ServerCommunication.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void sendRequest(ClientRequest clientRequest) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(clientRequest);
        } catch (IOException ex) {
            System.out.println("Greška prilikom slanja zahteva.");
            Logger.getLogger(ServerCommunication.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
}
