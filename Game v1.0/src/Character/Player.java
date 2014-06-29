package Character;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author komarov
 */
public class Player extends Character{
    
    public Player()
    {
        maxHp = 100;
        currentHp = maxHp;
        attack = 7;
        defense = 3;
    }
    
    @Override
    public String Update(boolean[] enemyAttack, boolean[] playerDefense, int enemyAttackPoints)
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
