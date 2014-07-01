package gameServer;


import сharacter.Player;
import сharacter.Bot;
import gameForms.LevelUp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Класс "сервера", обрабатывающего игровую логику и события.
 * 
 * Класс, который получает сообщения о событиях от интерфейса и изменяет 
 * параметры в зависимости от этих событий. После этого, он возвращает ответ 
 * на интерфейс.
 * 
 * @author Климук Кирилл
 * @author Лихачев Андрей
 * @author Комаров Даниил
 */
public class Server 
{
    private Player player;
    private Bot bot;
    
    public Server(){
        player = new Player();
        bot = new Bot();
    }
    
    public void regPlayer(Player client){
        player = client;
    }
    public void regBot(Bot client){
        bot = client;
    }
    public final Bot getBot(){
        return bot;
    }
    public final Player getPlayer(){
        return player;
    }
    public String translateMessage(Message msg){
        if (msg == null)
            return "NullMessage";
        
        String newMessage = new String();
        
        if (msg.getType().equals("choice"))
                newMessage = choice(msg.getChoice());
        else if (msg.getType().equals("battleStep"))
                newMessage = battleStep(msg.getPlayerAttack(), msg.getPlayerDefense());
          
        return newMessage; 
    }
    
    private String battleStep(final boolean[] attack, final boolean[] defense){
        String battleLog = new String();
        
        battleLog += bot.battleStep(attack, bot.choiceDefense(), player.getAttack());
        battleLog += "\n";
        battleLog += player.battleStep(bot.choiceAttack(), defense, bot.getAttack());
        battleLog += "\n";
        
        if (player.getCurHP() <= 0 && bot.getCurHP() <= 0)
        {
            battleLog += "Ничья!\n";
            player.endBattle();
            bot.endBattle();
            bot = new Bot(player.getLevel());
        }
        else if (player.getCurHP() <= 0)
        {
            battleLog += "Игрок проиграл!\n";
            player.endBattle();
            bot.endBattle();
            bot = new Bot(player.getLevel());
        }
        else if (bot.getCurHP() <= 0)
        {
            battleLog += "Бот проиграл!\n";
            player.endBattle();
            bot.endBattle();
            player.giveExp();
            
            if (player.getCurExp() >= player.getExpForLevel())
            {
                player.levelUp();
                try {
                    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                } catch (ClassNotFoundException ex) {
                    java.util.logging.Logger.getLogger(LevelUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    java.util.logging.Logger.getLogger(LevelUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    java.util.logging.Logger.getLogger(LevelUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                    java.util.logging.Logger.getLogger(LevelUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
        
                final Server serv = this;
                /* Create and display the form */
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new LevelUp(serv).setVisible(true);
                    }
                });
            }
            
            bot = new Bot(player.getLevel());
        }
        return battleLog;
    }
    private String choice(final int choice){
        if (choice == 0)
            player.upMaxHP(10);
        else if(choice == 1)
            player.upAttack(1);
        else 
            player.upDefense(1);
        
        return null;
    }
    
}
