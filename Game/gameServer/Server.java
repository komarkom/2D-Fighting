package gameServer;


import gameForms.Battle;
import gameForms.City;
import gameForms.LevelUp;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import сharacter.Bot;
import сharacter.Player;

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
    private Battle battleRoom;
    private LevelUp levelUpRoom;
    private City cityRoom;
    
    public Server(){
        player = new Player();
    }
    
    public final Bot getBot(){
        return bot;
    }
    public final Player getPlayer(){
        return player;
    }
    
    public String translateMessage(Message msg) throws FileNotFoundException, IOException{
        if (msg == null)
            return "NullMessage";
        
        String newMessage = new String();
        
        switch(msg.getType())
        {
            case("choice"):
                    newMessage = choice(msg.getChoice());
                    break;
            case("battleStep"):
                    newMessage = battleStep(msg.getPlayerAttack(), 
                                            msg.getPlayerDefense());
                    break;
            case("create"):
                    if(msg.getChoice() == 0)
                        createBattleRoom();
                    if(msg.getChoice() == 1)
                        createCityRoom();
                    if(msg.getChoice() == 2)
                        createLevelUpRoom();
                    break;
            case("Save"):
                    PrintWriter outputStream = new PrintWriter( new File("savePlayer.txt"));
                    outputStream.println(player.getMaxHP());

                    outputStream.println(player.getAttack());

                    outputStream.println(player.getDefense());

                    outputStream.println(player.getImagePath());

                    outputStream.println(player.getCurExp());

                    outputStream.println(player.getExpForLevel());

                    outputStream.println(player.getLevel()); 

                    
                    int[] maxHpP = new int[6];
                    maxHpP = player.getMaxHpParts();
                    
                    for (int i = 0; i < 6; i++){
                        outputStream.println(maxHpP[i]);

                    }
                  
                    outputStream.close();
                    break;
            case("Load"):
                    player = new Player("savePlayer.txt");
                    break;
                    
        }
        return newMessage; 
    }
    
    private String battleStep(final boolean[] attack, final boolean[] defense){
        String battleLog = new String();
        
        battleLog += bot.battleStep(attack, 
                                    bot.choiceDefense(player.getBreakParts()), 
                                    player.getAttack());
        battleLog += "\n";
        battleLog += player.battleStep(bot.choiceAttack(player.getBreakParts()),
                                       defense, 
                                       bot.getAttack());
        battleLog += "\n";
      
        for (int i = 0; i < 6; ++i)
        {
                if(player.getBreakParts()[0][i] && !player.getBreakParts()[1][i])
                {
                    for (int j = 0; j < 6; ++j)
                    {
                         if (battleRoom.attackList.get(j).isSelected()) battleRoom.attackList.get(j).doClick();
                         if (battleRoom.defenseList.get(j).isSelected()) battleRoom.defenseList.get(j).doClick();
                    }
                    player.setInvalidBreakPart(i);
                }
        }
        return battleLog;
    }
    private String choice(final int choice){
        if (choice == 0)
            player.upMaxHP(60);
        else if(choice == 1)
            player.upAttack(2);
        else 
            player.upDefense(2);
        
        return null;
    }
    private void createBattleRoom(){
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Battle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Battle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Battle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Battle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        bot = new Bot(player.getLevel());
        final Server server = this;
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                battleRoom = new Battle(server);
                battleRoom.setVisible(true);
            }
        });
        cityRoom = null;
        levelUpRoom = null;
    }
    private void createCityRoom(){
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(City.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(City.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(City.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(City.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        final Server server = this;
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                cityRoom = new City(server);
                cityRoom.setVisible(true);
            }
        });
        battleRoom = null;
        levelUpRoom = null;
    }
    private void createLevelUpRoom(){
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */  
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
         //</editor-fold>
         
        /* Create and display the form */
        final Server serv = this;
                /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                levelUpRoom = new LevelUp(serv);
                levelUpRoom.setVisible(true);
            }
        });    
        battleRoom = null;
        cityRoom = null;
    }
    
}
