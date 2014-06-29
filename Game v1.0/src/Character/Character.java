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

public abstract class Character{
    
    public int maxHp;
    public int currentHp;
    public int attack;
    public int defense;
    
    public abstract String Update(boolean[] enemyАttack, boolean[] playerDefense, int enemyAttackPoints);
}

