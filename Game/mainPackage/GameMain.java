package mainPackage;


import gameServer.Server;
import gameServer.Message;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Пользователь
 */
public class GameMain {
    
    public static void main(String args[]) {
        final Server server = new Server();
        
        try{
            server.translateMessage(new Message("create", 1));
        }
            catch(java.io.IOException e){
                throw new RuntimeException();
        }
        }
}
