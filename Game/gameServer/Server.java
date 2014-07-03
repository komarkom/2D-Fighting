package gameServer;


import сharacter.Player;
import сharacter.Bot;
import gameForms.LevelUp;
import gameForms.Battle;
import gameForms.Menu;
import java.io.*;
import javax.swing.JOptionPane;
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
    private Menu menuRoom;
    
    public Server(){
        player = new Player();
    }
    
    public final Bot getBot(){
        return bot;
    }
    public final Player getPlayer(){
        return player;
    }
    
    /**
     * Функция чтения сообщения и обработки событий
     * 
     * @param msg сообщение
     * @return ответ на сообщение
     * @throws java.io.IOException
     */
    public String translateMessage(Message msg) throws java.io.IOException{
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
                        createMenuRoom();
                    if(msg.getChoice() == 2)
                        createLevelUpRoom();
                    break;
            case("save"):
                    savePlayer();
                    break;
            case("load"):
                    loadPlayer();
                    break;
        }
        return newMessage; 
    }
    
    /**
     * Функция обработки боевого хода
     * 
     * @param attack выбор атаки
     * @param defense выбор защиты
     * @return лог боя
     */
    private String battleStep(final boolean[] attack, final boolean[] defense){
        String battleLog = new String();
        
        battleLog += bot.battleStep(attack, bot.choiceDefense(), 
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
                if(bot.getBreakParts()[0][i] && !bot.getBreakParts()[1][i])
                {
                    battleRoom.attackList.get(i).doClick();
                    battleRoom.attackList.get(i).setEnabled(false);
                    bot.setInvalidBreakPart(i);
                }
        }
        return battleLog;
    }
    /**
     * Обработка выбора улучшаемой характеристики
     * 
     * @param choice индекс характеристики
     * @return 
     */
    private String choice(final int choice){
        if (choice == 0)
            player.upMaxHP(60);
        else if(choice == 1)
            player.upAttack(2);
        else 
            player.upDefense(2);
        
        player.UpdateHp();
        return null;
    }
    /**
     * Создание боевой комнаты
     */
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
        bot.UpdateHp();
        player.UpdateHp();
        final Server server = this;
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                battleRoom = new Battle(server);
                battleRoom.setVisible(true);
            }
        });
        menuRoom = null;
        levelUpRoom = null;
    }
    /**
     * Создание главного меню
     */
    private void createMenuRoom(){
        /* Create and display the form */
        final Server server = this;
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                menuRoom = new Menu(server);
                menuRoom.setVisible(true);
            }
        });
        battleRoom = null;
        levelUpRoom = null;
    }
    /**
     * Создание комнаты повышения уровня
     */
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
        menuRoom = null;
    }
    
    private void savePlayer() throws java.io.IOException{
        String fileName = JOptionPane.showInputDialog(menuRoom, "Введите название файла.");
        PrintWriter out = new PrintWriter(new BufferedWriter
                                         (new FileWriter("characters/" + fileName + ".chr")));
        
        out.println(Integer.toString(player.getAttack()));
        out.println(Integer.toString(player.getCurExp()));
        out.println(Integer.toString(player.getDefense()));
        out.println(Integer.toString(player.getExpForLevel()));
        out.println(Integer.toString(player.getLevel()));
        out.println(Integer.toString(player.getMaxHP()));
        for (int i = 0; i < 6; ++i)
            out.println(Integer.toString(player.getMaxHpParts()[i]));
        out.flush();
    }
    private void loadPlayer() throws java.io.IOException{
         String fileName = JOptionPane.showInputDialog(menuRoom, "Введите название файла.");
         player = new Player("characters/" + fileName + ".chr");
    }
}
