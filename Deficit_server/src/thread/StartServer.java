/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import constant.Constant;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Djordje Janjic
 */
public class StartServer extends Thread{

    private ServerSocket serverSocket;
    
    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(Constant.PORT);
            System.out.println("Server je pokrenut...");
            
            acceptClients(serverSocket);
            
        } catch (IOException ex) {
            System.out.println("Greška u pokretanju servera.");
            Logger.getLogger(StartServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void acceptClients(ServerSocket serverSocket) {
        while(true){
            try {
                System.out.println("Cekanje klijenta");
                Socket socket = serverSocket.accept();
                System.out.println("Klijent prihvacen...");
                // Starting client thread
                Client client = new Client(socket, this);
                client.start();
                
            } catch (IOException ex) {
                System.out.println("Greška u prihvatanju klijenata.");
                Logger.getLogger(StartServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
