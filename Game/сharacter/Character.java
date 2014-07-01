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
    
    protected int maxHp; //
    protected int currentHp; 
    
    protected int[] maxHpParts; //
    protected int[] currentHpParts;
    
    protected int attack;  //
    protected int defense; //
    
    protected int countAttackPoints;
    protected int countDefensePoints;
    protected boolean[][] breakParts;
    
    protected String ImagePath; //
    
    public String getImagePath(){
        return ImagePath;
    }
    
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
    public int[] getMaxHpParts(){
        return maxHpParts;
    }
    public int[] getCurrentHpParts(){
        return currentHpParts;
    }
    public boolean[][] getBreakParts(){
        return breakParts;
    }
    public void setInvalidBreakPart(final int part){
        this.breakParts[1][part] = true;
    }
    public boolean isDead(){
       return breakParts[0][0] || breakParts[0][1] ||  
              (breakParts[0][2] && breakParts[0][3] &&
               breakParts[0][4] && breakParts[0][5]) ||
               currentHp <= 0;
    }
    public void upMaxHP(final int value){
        maxHp += value;
        maxHpParts[0] += value/12;
        for (int i = 2; i < 6; ++i)
            maxHpParts[i] += value/6;
        maxHpParts[1] += value*7/12;
    }
    public void upAttack(final int value){
        attack += value;
    }
    public void upDefense(final int value){
        defense += value;
    }
    public void UpdateHp()
    {
        currentHp = maxHp;
        for (int i = 0; i < 6; ++i)
            currentHpParts[i] = maxHpParts[i];
    }
    protected String deadParts(final int value){
        String str = new String();
        switch(value){
            case(0):
                str = " голову.\n";
                break;  
            case(2):
                str = " правую руку.\n";
                break;
            case(3):
                str = " левую руку.\n";
                break;
            case(4):
                str = " правую ногу.\n";
                break;
            case(5):
                str = " левую ногу.\n";
                break;            
        }
        return str;
    }
    public abstract String battleStep(boolean[] enemyАttack, 
                                      boolean[] playerDefense, 
                                      int enemyAttackPoints);
    
}

