/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkg2d_fighting;

/**
 *
 * @author Пользователь
 */
public class Server 
{
    private Player player;
    private Bot bot;
    
    Server()
    {
        player = new Player();
        bot = new Bot();
    }
    
    void RegPlayer(Player client)
    {
        player = client;
    }
    
    void RegBot(Bot client)
    {
        bot = client;
    }
    
    String translateMessage(Message msg)
    {
        if (msg == null)
            return "NullMessage";
        
       String battle_log = new String();
        
       battle_log += bot.readMessage(msg.getPlayerAttack(), msg.getEnemyDefense(), player.attack);
       battle_log += "\n";
       battle_log += player.readMessage(msg.getEnemyAttack(), msg.getPlayerDefense(), bot.attack);
       
       return battle_log; 
    }
    
}
