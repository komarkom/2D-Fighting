/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author komarov
 */

package pkg2d_fighting;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Player extends Character{
    
    Player()
    {
        maxHp = 100;
        currentHp = maxHp;
        attack = 2;
        defense = 50;
    }
    
    @Override
    public boolean[] choiceAttack() 
    {
        boolean[] attack = new boolean[6];
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int at1 = 0;
        int at2 = 0;
        
        try
        {
            at1 = Integer.parseInt(reader.readLine());
            at2 = Integer.parseInt(reader.readLine());
        }
        catch(IOException e)
        {
            System.out.println("Печалька. Хнык :(");
        }
        
        attack[at1] = true;
        attack[at2] = true;
        
        return attack;
    }

    @Override
    public boolean[] choiceDefense() 
    {
        boolean[] defense = new boolean[6];
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int def1 = 0;
        int def2 = 0;       
        try
        {
            def1 = Integer.parseInt(reader.readLine());
            def2 = Integer.parseInt(reader.readLine());
        }
        catch(IOException e)
        {
            System.out.println("Печалька. Хнык :(");
        }
        
        defense[def1] = true;
        defense[def2] = true;
        
        return defense;
    }
    
    @Override
    String readMessage(boolean[] enemyAttack, boolean[] playerDefense, int enemyAttackPoints)
    {
        String battle_log = new String();
        
        int at1 = 0, at2 = 0;
        int def1 = 0, def2 = 0;
        boolean at = false, def = false;
        for (int i = 0; i < 6; ++i)
        {
            if (enemyAttack[i])
            {
                if (!at)
                {
                    at1 = i;
                    at = true;
                }
                else 
                    at2 = i;
            }
            
            if (playerDefense[i])
                if (!def)
                {
                    def1 = i;
                    def = true;
                }
                else
                    def2 = i;
        }
        
        int damage = 0;
        if (def1 == at1 || def2 == at1)
            battle_log += "Игрок парировал удар противника.\n";
        else
        {
            if (at1 == 0)
                damage = enemyAttackPoints - defense + 5;
            else if (at1 == 1)
                damage = enemyAttackPoints - defense + 2;
            else if (at1 == 2)
                damage = enemyAttackPoints - defense + 1;
            else if (at1 == 3)
                damage = enemyAttackPoints - defense + 1;
            else if (at1 == 4)
                damage = enemyAttackPoints - defense;
            else if (at1 == 5)
                damage = enemyAttackPoints - defense;
            
            battle_log += "Бот нанес игроку " + Integer.toString(damage) + " урона.\n";
            currentHp -= damage;
        }
        if (def1 == at2 || def2 == at2)
            battle_log += "Игрок парировал удар противника.\n";
        else 
        {
            if (at2 == 0)
                damage = enemyAttackPoints - defense + 5;
            else if (at2 == 1)
                damage = enemyAttackPoints - defense + 2;
            else if (at2 == 2)
                damage = enemyAttackPoints - defense + 1;
            else if (at2 == 3)
                damage = enemyAttackPoints - defense + 1;
            else if (at2 == 4)
                damage = enemyAttackPoints - defense;
            else if (at2 == 5)
                damage = enemyAttackPoints - defense;
            
            battle_log += "Бот нанес игроку " + Integer.toString(damage) + " урона.\n";
            currentHp -= damage;
        }
        return battle_log;
    }
}
