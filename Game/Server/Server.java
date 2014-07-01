package Server;


import Character.Player;
import Character.Bot;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Пользователь
 */
public class Server 
{
    private Player player;
    private Bot bot;
    
    public Server()
    {
        player = new Player();
        bot = new Bot();
    }
    
    public void regPlayer(Player client)
    {
        player = client;
    }
    
    public void regBot(Bot client)
    {
        bot = client;
    }
    
    public String translateMessage(Message msg)
    {
        if (msg == null)
            return "NullMessage";
        
       String battleLog = new String();
        
       battleLog += bot.Update(msg.getPlayerAttack(), msg.getEnemyDefense(), player.attack);
       battleLog += "\n";
       battleLog += player.Update(msg.getEnemyAttack(), msg.getPlayerDefense(), bot.attack);
       
       return battleLog; 
    }
    
}
