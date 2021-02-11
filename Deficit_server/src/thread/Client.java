/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import communication.ClientRequest;
import communication.ServerResponse;
import constant.Constant;
import controller.Controller;
import domain.User;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Djordje Janjic
 */
public class Client extends Thread{

    Socket socket;
    StartServer startServer;

    public Client(Socket socket) {
        this.socket = socket;
    }

    public Client(Socket socket, StartServer startServer) {
        this.socket = socket;
        this.startServer = startServer;
    }
    
    
    
    @Override
    public void run() {
        processOperation();
    }

    private void processOperation() {
        while(true){
            ClientRequest clientRequest = getRequest();
            ServerResponse serverResponse = new ServerResponse();
            
            switch(clientRequest.getOperation()){
                case Constant.GET_USER :
                    // Vrati korisnika
                    List<User> users = Controller.getInstance().getUser();
                    serverResponse.setData(users);
                    break;
                case Constant.GET_FOOD :
                    serverResponse.setData(this);
                    break;
                case Constant.GET_UNIT :
                    serverResponse.setData(this);
                    break;
                case Constant.START_SERVER :
                    //new StartServer().start();
                    break;
                case Constant.STOP_SERVER :
                    Controller.getInstance().stopServer(this, startServer);     
                    break;
                case Constant.SAVE :
                    serverResponse.setMessage("Success");
                    break;
            }
            // Send request
            sendRequest(serverResponse);
        }
    }

    private ClientRequest getRequest() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            return (ClientRequest) objectInputStream.readObject();
        } catch (IOException ex) {
            System.out.println("Greška prilikom uzimanja zahteva.");
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("Greška prilikom čitanja zahteva.");
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private void sendRequest(ServerResponse serverResponse) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(serverResponse);
        } catch (IOException ex) {
            System.out.println("Greška prilikom slanja zahteva.");
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    
    
}
