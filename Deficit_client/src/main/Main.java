/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/*import communication.ClientRequest;
import communication.ServerCommunication;
import constant.Constant;*/
import form.FrmLogin;

/**
 *
 * @author Djordje Janjic
 */
public class Main {
    
    //private static boolean isAlive = false;
    
    public static void main(String[] args) {
        /*if(isAlive == false){
            ClientRequest clientRequest = new ClientRequest();
            clientRequest.setOperation(Constant.START_SERVER);
            ServerCommunication.getInstance().sendRequest(clientRequest);
            isAlive = true;
        }   */    
        new FrmLogin().setVisible(true);
    }
}
