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

    public Bot(){
        maxHp = 100;
        currentHp = maxHp;
        attack = 5;
        defense = 3;
        ImagePath = new String();
    }
    
    public Bot(int level){
        maxHp = 100;
        attack = 5;
        defense = 3;
        if (level != 1)
        {
            Random rand = new Random();
            for (int i = 0; i < level; ++i)
            {
                int r = rand.nextInt(2);
                if (r == 0)
                    this.upMaxHP(10);
                else if (r == 1)
                    this.upAttack(1);
                else if (r == 2)
                    this.upDefense(1);
            }
        }
        currentHp = maxHp;
        ImagePath = new String();
    }
    
    
    public boolean[] choiceAttack() {
        
        boolean[] attack = new boolean[6];
        Random rand = new Random();
        int at1 = rand.nextInt(5);
        int at2 = rand.nextInt(5);
        
        while (at1 == at2)
        {
            at1 = rand.nextInt(5);
            at2 = rand.nextInt(5);
        }
        
        attack[at1] = true;
        attack[at2] = true;
        
        return attack;
    }
    public boolean[] choiceDefense() {
        boolean[] defense = new boolean[6];
        
        Random rand = new Random();
        int def1 = rand.nextInt(5);
        int def2 = rand.nextInt(5);
        
        while (def1 == def2)
        {
            def1 = rand.nextInt(5);
            def2 = rand.nextInt(5);
        }
        
        defense[def1] = true;
        defense[def2] = true;
        
        return defense;
    }
    
    @Override
    public String battleStep(boolean[] enemyAttack, boolean[] playerDefense, int enemyAttackPoints)
    {
        String battle_log = new String();
        Random rand = new Random();
        
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
            battle_log += "Бот парировал удар игрока.\n";
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
            
            battle_log += "Игрок нанес боту " + Integer.toString(damage) + " урона.\n";
            currentHp -= damage;
        }
        if (def1 == at2 || def2 == at2)
            battle_log += "Бот парировал удар игрока.\n";
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
            
            battle_log += "Игрок нанес боту " + Integer.toString(damage) + " урона.\n";
            currentHp -= damage;
        }
        return battle_log;
    }
}
