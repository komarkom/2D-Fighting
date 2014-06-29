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
public abstract class Client
{
    private Server server;
    
    void connectTo(Server server)
    {
        this.server = server;
    }
    
    void disconnect()
    {
        server = null;
    }
    
    abstract String readMessage(boolean[] enemyАttack, boolean[] playerDefense, int enemyAttackPoints);
}
