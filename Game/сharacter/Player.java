package сharacter;
import java.util.Random;
import java.lang.Boolean;
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
        maxHp = 200;
        currentHp = maxHp;
        attack = 7;
        defense = 5;
        ImagePath = new String();
        currentExp = 0;
        expForLevel = 10;
        level = 1;
        maxHpParts = new int[6];
        currentHpParts = new int[6];
        
        for(int i = 2; i < 6; ++i)
        {
            maxHpParts[i] = 75;
            currentHpParts[i] = 75;
        }
        maxHpParts[0] = 150;
        maxHpParts[1] = 200;
        currentHpParts[0] = 150;
        currentHpParts[1] = 200;
        countDefensePoints = 2;
        countAttackPoints = 2;
        breakParts = new boolean[2][];
        breakParts[0] = new boolean[6];
        breakParts[1] = new boolean[6];
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
        String battle_log = "Ход бота:\n";
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
        if (def1 != -1 && def2 != -1 && def1 == at1 || def2 == at1)
            battle_log += "Игрок парировал удар противника.\n";
        else if(at1 != -1)
        {
            damage = rand.nextInt(enemyAttackPoints) - rand.nextInt(defense);
            switch(at1){
                case(0):
                    damage += rand.nextInt(5);
                    break;
                case(1):
                    damage += rand.nextInt(3);
                    break;
                case(2):
                    damage += rand.nextInt(2);
                    break;
            }
            if (damage < 0)
                damage = 0;
            
            currentHpParts[at1] -= damage;
            currentHp -= damage;
            battle_log += "Бот нанес игроку " + Integer.toString(damage) + " урона.\n";
            if (currentHpParts[at1] <= 0)
            {
                battle_log += "Бот сломал игроку" + deadParts(at1);
                breakParts[0][at1] = true;
                if (at1 > 1)
                {
                    if (rand.nextInt(2) == 0)
                        if (countAttackPoints != 0)
                            --countAttackPoints;
                        else 
                            --countDefensePoints;
                    else
                        if (countDefensePoints != 0)
                            --countDefensePoints;
                        else 
                            --countAttackPoints;
                }
            }    
        }
        if (def1 != -1 && def2 != -1 && def1 == at2 || def2 == at2)
            battle_log += "Игрок парировал удар противника.\n";
        else if (at2 != -1)
        {
            damage = rand.nextInt(enemyAttackPoints) - rand.nextInt(defense);
            switch(at2){
                case(0):
                    damage += rand.nextInt(5);
                    break;
                case(1):
                    damage += rand.nextInt(3);
                    break;
                case(2):
                    damage += rand.nextInt(2);
                    break;
            }
            if (damage < 0)
                damage = 0;
            
            currentHpParts[at2] -= damage;
            currentHp -= damage;
            battle_log += "Бот нанес игроку " + Integer.toString(damage) + " урона.\n";
            if (currentHpParts[at2] <= 0)
            {
                battle_log += "Бот сломал игроку" + deadParts(at2);
                breakParts[0][at2] = true;
                if (at2 > 1)
                {
                    if (rand.nextInt(2) == 0)
                        if (countAttackPoints != 0)
                            --countAttackPoints;
                        else 
                            --countDefensePoints;
                    else
                        if (countDefensePoints != 0)
                            --countDefensePoints;
                        else 
                            --countAttackPoints;
                }
            }
        }
        return battle_log;
    }
    
    public int getAttackPoints(){
        return countAttackPoints;
    }
    public int getDefensePoints(){
        return countDefensePoints;
    }
}
