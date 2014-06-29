/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Server;

/**
 *
 * @author Пользователь
 */
public class Message 
{
    private boolean[] playerAttack;
    private boolean[] playerDefense;
    private boolean[] enemyAttack;
    private boolean[] enemyDefense;
    
    public boolean[] getPlayerAttack()
    {
        return playerAttack;
    }
    
    public boolean[] getPlayerDefense()
    {
        return playerDefense;
    }
    
    public boolean[] getEnemyAttack()
    {
        return enemyAttack;
    }
    
    public boolean[] getEnemyDefense()
    {
        return enemyDefense;
    }
    public Message(boolean[] playerAttack, boolean[] playerDefense, 
            boolean[] enemyAttack, boolean[] enemyDefense)    
    {
        this.playerAttack = playerAttack;
        this.playerDefense = playerDefense;
        this.enemyAttack = enemyAttack;
        this.enemyDefense = enemyDefense;
    }
    
}
