package сharacter;

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

public abstract class Character{
    
    protected int maxHp;
    protected int currentHp;
    
    protected int attack;
    protected int defense;
    
    protected String ImagePath;
    
    public int getMaxHP(){
        return maxHp;
    }
    public int getCurHP(){
        return currentHp;
    }
    public int getAttack(){
        return attack;
    }
    public int getDefense(){
        return defense;
    }
    
    public void upMaxHP(final int value){
        maxHp += value;
    }
    public void upAttack(final int value){
        attack += value;
    }
    public void upDefense(final int value){
        defense += value;
    }
    
    public abstract String battleStep(boolean[] enemyАttack, 
                                  boolean[] playerDefense, 
                                  int enemyAttackPoints);
    
    public void endBattle()
    {
        currentHp = maxHp;
    }
}

