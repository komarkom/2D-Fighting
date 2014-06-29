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

public abstract class Character extends Client{
    
    public int maxHp;
    public int currentHp;
    public int attack;
    public int defense;
    
    public abstract boolean[]  choiceDefense();
    public abstract boolean[]  choiceAttack();
}

