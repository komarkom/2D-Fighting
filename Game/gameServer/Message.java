/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gameServer;

/**
 * Класс сообщения, передаваемого от интерфейса к серверу.
 * 
 * Класс содержит необходимую информацию о действиях игрока.
 * 
 * @author Климук Кирилл
 * @author Лихачев Андрей
 * @author Комаров Даниил
 */
public class Message 
{
    private final String type;
    private final int choice;
    private final boolean[] playerAttack;
    private final boolean[] playerDefense;
    
    public final boolean[] getPlayerAttack(){
        return playerAttack;
    }
    public final boolean[] getPlayerDefense(){
        return playerDefense;
    }
    public final int getChoice(){
        return choice;
    }
    public final String getType(){
        return type;
    }
    
    public Message(final String type){
        this.type = type;
        choice = 0;
        
        this.playerAttack = null;
        this.playerDefense = null; 
    }
    public Message(final String type, final int choice){
        this.choice = choice;
        this.type = type;
        
        this.playerAttack = null;
        this.playerDefense = null;    
    }
    public Message(final boolean[] playerAttack, final boolean[] playerDefense)       {
        this.playerAttack = playerAttack;
        this.playerDefense = playerDefense;
        
        type = "battleStep";
        choice = 0;   
    }
}
