package сharacter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Random;
/**
 *
 * @author Андрей Лихачев
 * @author Кирилл Климук
 * @author Даниил Комаров
 */
public class Bot extends Character{

    public Bot(int level){
        maxHp = 200;
        attack = 10;
        defense = 5;
        maxHpParts = new int[6];
        currentHpParts = new int[6];
        
        for(int i = 2; i < 6; ++i)
        {
            maxHpParts[i] = 75;
            currentHpParts[i] = 75;
        }
        maxHpParts[0] = 150;
        maxHpParts[1] = 200;
        
        if (level != 1)
        {
            Random rand = new Random();
            for (int i = 0; i < level+2; ++i)
            {
                int r = rand.nextInt(2);
                if (r == 0)
                    this.upMaxHP(60);
                else if (r == 1)
                    this.upAttack(2);
                else if (r == 2)
                    this.upDefense(2);
            }
        }
        currentHp = maxHp;
        ImagePath = new String();
        countDefensePoints = 2;
        countAttackPoints = 2;
        currentHpParts[0] = maxHpParts[0];
        currentHpParts[1] = maxHpParts[1];
        breakParts = new boolean[2][];
        breakParts[0] = new boolean[6];
        breakParts[1] = new boolean[6];
    }
    
    public boolean[] choiceAttack(boolean[][] breakParts) {
        
        boolean[] attack = new boolean[6];
        Random rand = new Random();
        if (countAttackPoints != 0)
        {
            int[] at = new int[countAttackPoints];
            at[0] = rand.nextInt(6);
            while (breakParts[0][at[0]])
            {
                at[0] = rand.nextInt(6);
            }
            if (countAttackPoints == 2)
            {
                at[1] = rand.nextInt(6);
                while (at[0] == at[1] || breakParts[0][at[0]] || breakParts[0][at[1]])
                {
                    at[0] = rand.nextInt(6);
                    at[1] = rand.nextInt(6);
                }
                attack[at[1]] = true;
            }
            attack[at[0]] = true;
        }
        return attack;
    }
    public boolean[] choiceDefense(boolean[][] breakParts) {
        boolean[] defense = new boolean[6];
        
        Random rand = new Random();
        if (countDefensePoints != 0)
        {
            int[] def = new int[countDefensePoints];
            def[0] = rand.nextInt(6);
            while(breakParts[0][def[0]])
                def[0] = rand.nextInt(6);
            
            if (countDefensePoints == 2)
            {
                def[1] = rand.nextInt(6);
                while (def[0] == def[1] || breakParts[0][def[0]] 
                        || breakParts[0][def[1]])
                {
                    def[0] = rand.nextInt(6);
                    def[1] = rand.nextInt(6);
                }
                defense[def[1]] = true;
            }
            defense[def[0]] = true;
            
        }
        return defense;
    }
    
    @Override
    public String battleStep(boolean[] enemyAttack, boolean[] playerDefense,
                             int enemyAttackPoints)
    {
        String battle_log = "Ход игрока:\n";
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
            battle_log += "Бот парировал удар игрока.\n";
        else if(at1 != -1)
        {
            damage = rand.nextInt(enemyAttackPoints) - rand.nextInt(defense);
            switch(at1){
                case(0):
                    damage += rand.nextInt(5)-rand.nextInt(3);
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
            battle_log += "Игрок нанес боту " + Integer.toString(damage) + " урона.\n";
            if (currentHpParts[at1] <= 0)
            {
                battle_log += "Игрок сломал боту" + deadParts(at1);
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
            battle_log += "Бот парировал удар игрока.\n";
        else if(at2 != -1)
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
            
            battle_log += "Игрок нанес боту " + Integer.toString(damage) + " урона.\n";
            if (currentHpParts[at2] <= 0)
            {
                battle_log += "Игрок сломал боту" + deadParts(at2);
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
}
