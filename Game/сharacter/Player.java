package сharacter;
import java.util.Random;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Андрей Лихачев
 * @author Кирилл Климук
 * @author Даниил Комаров
 */
public class Player extends Character{
    
    private int currentExp;
    private int expForLevel;
    private int level;
    
    public Player(){
        maxHp = 100;
        currentHp = maxHp;
        attack = 5;
        defense = 3;
        ImagePath = new String();
        currentExp = 0;
        expForLevel = 10;
        level = 1;
    }
    
    public final int getLevel(){
        return level;
    }
    public final int getExpForLevel(){
        return expForLevel;
    }
    public final int getCurExp(){
        return currentExp;
    }
    
    public void giveExp(){
        currentExp += 15;   
    }
    public void levelUp(){
        expForLevel <<= 1;
        ++level;
    }
    
    @Override
    public String battleStep(boolean[] enemyAttack, 
                         boolean[] playerDefense,
                         int enemyAttackPoints) 
    {
        String battle_log = new String();
        Random rand = new Random();
        
        int at1 = -1, at2 = -1;
        int def1 = -1, def2 = -1;
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
                damage = rand.nextInt(enemyAttackPoints) - rand.nextInt(defense) + rand.nextInt(5);
            else if (at1 == 1)
                damage = rand.nextInt(enemyAttackPoints) - rand.nextInt(defense) + rand.nextInt(3);
            else
                damage = rand.nextInt(enemyAttackPoints) - rand.nextInt(defense) + rand.nextInt(2);

            if (damage < 0)
                damage = 0;
            
            battle_log += "Бот нанес игроку " + Integer.toString(damage) + " урона.\n";
            currentHp -= damage;
        }
        if (def1 == at2 || def2 == at2)
            battle_log += "Игрок парировал удар противника.\n";
        else 
        {
            if (at2 == 0)
                damage = rand.nextInt(enemyAttackPoints) - rand.nextInt(defense) + rand.nextInt(5);
            else if (at2 == 1)
                damage = rand.nextInt(enemyAttackPoints) - rand.nextInt(defense) + rand.nextInt(3);
            else
                damage = rand.nextInt(enemyAttackPoints) - rand.nextInt(defense) + rand.nextInt(2);
           
            
            
            if (damage <= 0)
                damage = 1;
            
            battle_log += "Бот нанес игроку " + Integer.toString(damage) + " урона.\n";
            currentHp -= damage;
        }
        return battle_log;
    }
}
