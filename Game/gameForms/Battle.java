package gameForms;

import gameServer.Server;
import gameServer.Message;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.ImageIcon;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Класс формы боевой комнаты.
 * 
 * @author Климук Кирилл
 * @author Лихачев Андрей
 * @author Комаров Даниил
 */
public class Battle extends javax.swing.JFrame {

    /**
     * Creates new form UI
     */
    private static int countAttack;
    private static int countDefense;
    private final Server server;
    
    public final ArrayList<javax.swing.JCheckBox> attackList;
    public final ArrayList<javax.swing.JCheckBox> defenseList;
    private final ArrayList<javax.swing.JLabel> attackLabelHpList;
    private final ArrayList<javax.swing.JLabel> defenseLabelHpList;
    
    private String battleLog;
         
    public Battle(Server server) {
        initComponents();
        //<editor-fold defaultstate="collapsed" desc="Инициализация">
        countAttack = 0;
        countDefense = 0;
        this.server = server;
        battleLog = new String();
        attackList = new ArrayList();
        defenseList = new ArrayList();
        attackLabelHpList = new ArrayList();
        defenseLabelHpList = new ArrayList();
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Добавления элементов в списки">
        attackList.add(headAttack);
        attackList.add(bodyAttack);
        attackList.add(rightHandAttack);
        attackList.add(leftHandAttack);
        attackList.add(rightLegAttack);
        attackList.add(leftLegAttack);
        
        defenseList.add(headDefense);
        defenseList.add(bodyDefense);
        defenseList.add(rightHandDefense);
        defenseList.add(leftHandDefense);
        defenseList.add(rightLegDefense);
        defenseList.add(leftLegDefense); 
        
        attackLabelHpList.add(labelAttackHpHead);
        attackLabelHpList.add(labelAttackHpBody);
        attackLabelHpList.add(labelAttackHpRightHand);
        attackLabelHpList.add(labelAttackHpLeftHand);
        attackLabelHpList.add(labelAttackHpRightLeg);
        attackLabelHpList.add(labelAttackHpLeftLeg);
        
        defenseLabelHpList.add(labelDefenseHpHead);
        defenseLabelHpList.add(labelDefenseHpBody);
        defenseLabelHpList.add(labelDefenseHpRightHand);
        defenseLabelHpList.add(labelDefenseHpLeftHand);
        defenseLabelHpList.add(labelDefenseHpRightLeg);
        defenseLabelHpList.add(labelDefenseHpLeftLeg);
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Установка изображений">
        defenseMan.setImage(new ImageIcon(this.getClass().
                                               getResource("/pictures/man.jpg")).
                                               getImage());
        attackMan.setImage(new ImageIcon(this.getClass().
                                              getResource("/pictures/man.jpg")).
                                              getImage());
        botImage.setImage(new ImageIcon(this.getClass().
                                              getResource("/pictures/bot.jpg")).
                                              getImage());
        playerImage.setImage(new ImageIcon(this.getClass().
                                              getResource("/pictures/player.jpg")).
                                              getImage());
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Настройка текстов в label">
        playerHPLabel.setText("HP: " +
                        Integer.toString(server.getPlayer().getCurHP()) + "/" +
                        Integer.toString(server.getPlayer().getMaxHP()));
        botHPLabel.setText("HP: " +
                        Integer.toString(server.getBot().getCurHP()) + "/" +
                        Integer.toString(server.getBot().getMaxHP()));
        jLabel1.setText(Integer.toString(server.getPlayer().getLevel() + 1));
        levelLabel.setText("-Уровень-" );
        jLabel2.setText(Integer.toString(server.getPlayer().getLevel()));
        jLabel3.setText(Integer.toString(server.getBot().getAttack()));
        attackPointLabel.setText("-Атака-");
        jLabel4.setText(Integer.toString(server.getPlayer().getAttack()));
        jLabel5.setText(Integer.toString(server.getBot().getDefense()));
        defensePointLabel.setText("-Защита-" );
        jLabel6.setText(Integer.toString(server.getPlayer().getDefense()));
        for (int i = 0; i < 6; ++i){
             attackLabelHpList.get(i).setText(Integer.toString(server.getBot().
                                              getCurrentHpParts()[i]) + "/" +
                                              Integer.toString(server.getBot().
                                              getMaxHpParts()[i]));
             defenseLabelHpList.get(i).setText(Integer.toString(server.
                                               getPlayer().
                                               getCurrentHpParts()[i]) + "/" +
                                               Integer.toString(server.
                                               getPlayer().getMaxHpParts()[i]));
        }
        //</editor-fold>   
    }
    
    /**
     * Функция блокировки атакующих CheckBox
     */
    public void blockAttackCheck() {
        if (countAttack != server.getPlayer().getAttackPoints())
        {
            for(int i = 0; i < 6; ++i)
            {
                if (!server.getBot().getBreakParts()[0][i])
                    attackList.get(i).setEnabled(true);
            }
        }
        else
        {
            for(int i = 0; i < 6; ++i)
            {
                if(!attackList.get(i).isSelected() ||
                   server.getBot().getBreakParts()[0][i])
                    attackList.get(i).setEnabled(false);
            }
        }
    }
    /**
     * Функция блокировки защищающих CheckBox
     */
    public void blockDefenseCheck() {
        if (countDefense != server.getPlayer().getDefensePoints())
        {
            for(int i = 0; i < 6; ++i)
            {
                if (!server.getPlayer().getBreakParts()[0][i])
                    defenseList.get(i).setEnabled(true);
            }
        }
        else
        {
            for(int i = 0; i < 6; ++i)
            {
                if(!defenseList.get(i).isSelected())
                    defenseList.get(i).setEnabled(false);
            }
        }
    }
    
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        logger = new javax.swing.JTextArea();
        battleLogLabel = new javax.swing.JLabel();
        playerHPLabel = new javax.swing.JLabel();
        botHPLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        attackLabel = new javax.swing.JLabel();
        defenseLabel = new javax.swing.JLabel();
        botName = new javax.swing.JLabel();
        playerName = new javax.swing.JLabel();
        attackMan = new gameForms.ImagePanel();
        headAttack = new javax.swing.JCheckBox();
        rightHandAttack = new javax.swing.JCheckBox();
        bodyAttack = new javax.swing.JCheckBox();
        leftHandAttack = new javax.swing.JCheckBox();
        leftLegAttack = new javax.swing.JCheckBox();
        rightLegAttack = new javax.swing.JCheckBox();
        labelAttackHpLeftHand = new javax.swing.JLabel();
        labelAttackHpHead = new javax.swing.JLabel();
        labelAttackHpRightHand = new javax.swing.JLabel();
        labelAttackHpBody = new javax.swing.JLabel();
        labelAttackHpRightLeg = new javax.swing.JLabel();
        labelAttackHpLeftLeg = new javax.swing.JLabel();
        defenseMan = new gameForms.ImagePanel();
        headDefense = new javax.swing.JCheckBox();
        rightHandDefense = new javax.swing.JCheckBox();
        leftHandDefense = new javax.swing.JCheckBox();
        bodyDefense = new javax.swing.JCheckBox();
        leftLegDefense = new javax.swing.JCheckBox();
        rightLegDefense = new javax.swing.JCheckBox();
        labelDefenseHpLeftHand = new javax.swing.JLabel();
        labelDefenseHpHead = new javax.swing.JLabel();
        labelDefenseHpRightHand = new javax.swing.JLabel();
        labelDefenseHpBody = new javax.swing.JLabel();
        labelDefenseHpRightLeg = new javax.swing.JLabel();
        labelDefenseHpLeftLeg = new javax.swing.JLabel();
        botImage = new gameForms.ImagePanel();
        playerImage = new gameForms.ImagePanel();
        levelLabel = new javax.swing.JLabel();
        attackPointLabel = new javax.swing.JLabel();
        defensePointLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        logger.setColumns(40);
        logger.setRows(5);
        jScrollPane1.setViewportView(logger);

        battleLogLabel.setText("Лог боя:");

        playerHPLabel.setText("HP:");

        botHPLabel.setText("HP:");

        jButton1.setText("Сделать ход");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        attackLabel.setText("Атака:");

        defenseLabel.setText("Защита:");

        botName.setText("Бот");

        playerName.setText("Игрок");

        attackMan.setPreferredSize(new java.awt.Dimension(280, 280));

        headAttack.setToolTipText("Атаковать голову");
        headAttack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                headAttackActionPerformed(evt);
            }
        });

        rightHandAttack.setToolTipText("Атаковать правую руку");
        rightHandAttack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightHandAttackActionPerformed(evt);
            }
        });

        bodyAttack.setToolTipText("Атаковать туловище");
        bodyAttack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bodyAttackActionPerformed(evt);
            }
        });

        leftHandAttack.setToolTipText("Атаковать левую руку");
        leftHandAttack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftHandAttackActionPerformed(evt);
            }
        });

        leftLegAttack.setToolTipText("Атаковать левую ногу");
        leftLegAttack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftLegAttackActionPerformed(evt);
            }
        });

        rightLegAttack.setToolTipText("Атаковать правую ногу");
        rightLegAttack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightLegAttackActionPerformed(evt);
            }
        });

        labelAttackHpLeftHand.setText("jLabel1");

        labelAttackHpHead.setText("jLabel2");

        labelAttackHpRightHand.setText("jLabel3");

        labelAttackHpBody.setText("jLabel4");

        labelAttackHpRightLeg.setText("jLabel5");

        labelAttackHpLeftLeg.setText("jLabel6");

        javax.swing.GroupLayout attackManLayout = new javax.swing.GroupLayout(attackMan);
        attackMan.setLayout(attackManLayout);
        attackManLayout.setHorizontalGroup(
            attackManLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(attackManLayout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(attackManLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelAttackHpLeftLeg)
                    .addComponent(leftLegAttack))
                .addGap(35, 35, 35)
                .addGroup(attackManLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rightLegAttack)
                    .addComponent(labelAttackHpRightLeg))
                .addContainerGap(83, Short.MAX_VALUE))
            .addGroup(attackManLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(attackManLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(attackManLayout.createSequentialGroup()
                        .addComponent(labelAttackHpLeftHand, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, attackManLayout.createSequentialGroup()
                        .addGroup(attackManLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(attackManLayout.createSequentialGroup()
                                .addComponent(leftHandAttack)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bodyAttack))
                            .addGroup(attackManLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(attackManLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelAttackHpHead)
                                    .addComponent(headAttack))))
                        .addGap(36, 36, 36)
                        .addComponent(labelAttackHpBody)
                        .addGap(51, 51, 51))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, attackManLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(attackManLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelAttackHpRightHand)
                            .addComponent(rightHandAttack))
                        .addGap(38, 38, 38))))
        );
        attackManLayout.setVerticalGroup(
            attackManLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, attackManLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelAttackHpHead)
                .addGap(21, 21, 21)
                .addGroup(attackManLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(attackManLayout.createSequentialGroup()
                        .addComponent(headAttack)
                        .addGap(6, 6, 6)
                        .addComponent(rightHandAttack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelAttackHpRightHand)
                        .addGap(46, 46, 46)
                        .addGroup(attackManLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bodyAttack)
                            .addComponent(leftHandAttack)))
                    .addComponent(labelAttackHpBody))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelAttackHpLeftHand)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(attackManLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(leftLegAttack, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rightLegAttack, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(0, 0, 0)
                .addGroup(attackManLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelAttackHpLeftLeg)
                    .addComponent(labelAttackHpRightLeg)))
        );

        headDefense.setToolTipText("Защитить голову");
        headDefense.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                headDefenseActionPerformed(evt);
            }
        });

        rightHandDefense.setToolTipText("Защитить правую руку");
        rightHandDefense.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightHandDefenseActionPerformed(evt);
            }
        });

        leftHandDefense.setToolTipText("Защитить левую руку");
        leftHandDefense.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftHandDefenseActionPerformed(evt);
            }
        });

        bodyDefense.setToolTipText("Защитить туловище");
        bodyDefense.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bodyDefenseActionPerformed(evt);
            }
        });

        leftLegDefense.setToolTipText("Защитить левую ногу");
        leftLegDefense.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftLegDefenseActionPerformed(evt);
            }
        });

        rightLegDefense.setToolTipText("Защитить правую ногу");
        rightLegDefense.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightLegDefenseActionPerformed(evt);
            }
        });

        labelDefenseHpLeftHand.setText("jLabel1");

        labelDefenseHpHead.setText("jLabel2");

        labelDefenseHpRightHand.setText("jLabel3");

        labelDefenseHpBody.setText("jLabel4");

        labelDefenseHpRightLeg.setText("jLabel5");

        labelDefenseHpLeftLeg.setText("jLabel6");

        javax.swing.GroupLayout defenseManLayout = new javax.swing.GroupLayout(defenseMan);
        defenseMan.setLayout(defenseManLayout);
        defenseManLayout.setHorizontalGroup(
            defenseManLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(defenseManLayout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(defenseManLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(leftLegDefense)
                    .addComponent(labelDefenseHpLeftLeg))
                .addGap(32, 32, 32)
                .addGroup(defenseManLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelDefenseHpRightLeg)
                    .addComponent(rightLegDefense))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(defenseManLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(defenseManLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(defenseManLayout.createSequentialGroup()
                        .addComponent(labelDefenseHpLeftHand)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(defenseManLayout.createSequentialGroup()
                        .addComponent(leftHandDefense)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                        .addGroup(defenseManLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(defenseManLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(bodyDefense)
                                .addGap(18, 18, 18)
                                .addComponent(labelDefenseHpBody))
                            .addGroup(defenseManLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(headDefense)
                                .addComponent(labelDefenseHpHead)))
                        .addContainerGap(65, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, defenseManLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(defenseManLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, defenseManLayout.createSequentialGroup()
                        .addComponent(rightHandDefense)
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, defenseManLayout.createSequentialGroup()
                        .addComponent(labelDefenseHpRightHand)
                        .addGap(24, 24, 24))))
        );
        defenseManLayout.setVerticalGroup(
            defenseManLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(defenseManLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelDefenseHpHead, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(headDefense)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 5, Short.MAX_VALUE)
                .addComponent(rightHandDefense)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelDefenseHpRightHand)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(defenseManLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(defenseManLayout.createSequentialGroup()
                        .addComponent(leftHandDefense)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelDefenseHpLeftHand)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(defenseManLayout.createSequentialGroup()
                        .addGroup(defenseManLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bodyDefense)
                            .addComponent(labelDefenseHpBody))
                        .addGap(68, 68, 68)
                        .addGroup(defenseManLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(leftLegDefense)
                            .addGroup(defenseManLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(rightLegDefense)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(defenseManLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelDefenseHpRightLeg)
                                    .addComponent(labelDefenseHpLeftLeg))))))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout botImageLayout = new javax.swing.GroupLayout(botImage);
        botImage.setLayout(botImageLayout);
        botImageLayout.setHorizontalGroup(
            botImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 169, Short.MAX_VALUE)
        );
        botImageLayout.setVerticalGroup(
            botImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout playerImageLayout = new javax.swing.GroupLayout(playerImage);
        playerImage.setLayout(playerImageLayout);
        playerImageLayout.setHorizontalGroup(
            playerImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 169, Short.MAX_VALUE)
        );
        playerImageLayout.setVerticalGroup(
            playerImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );

        levelLabel.setText("Уровень: ");

        attackPointLabel.setText("Атака:");

        defensePointLabel.setText("Защита:");

        jLabel1.setText("11");

        jLabel2.setText("11");

        jLabel3.setText("11");

        jLabel4.setText("11");

        jLabel5.setText("11");

        jLabel6.setText("11");

        jMenu2.setText("Помощь");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        jMenuItem1.setText("Правила");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(114, 114, 114)
                                .addComponent(attackLabel)
                                .addGap(185, 185, 185)
                                .addComponent(botHPLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(69, 69, 69)
                                        .addComponent(battleLogLabel))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(playerHPLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(attackMan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(botName, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(botImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(54, 54, 54)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel1)
                                                    .addComponent(jLabel3))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(levelLabel)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(2, 2, 2)
                                                        .addComponent(defensePointLabel))
                                                    .addComponent(attackPointLabel)))
                                            .addComponent(jLabel5))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel4))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(playerImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(playerName)
                                    .addComponent(defenseMan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(141, 141, 141)
                                .addComponent(defenseLabel)
                                .addGap(103, 103, 103))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(508, 508, 508)
                        .addComponent(jButton1)))
                .addContainerGap(4, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(playerName)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(levelLabel)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(attackPointLabel)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(defensePointLabel)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)))
                            .addComponent(botName)
                            .addComponent(playerImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(defenseLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(defenseMan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(attackLabel)
                                    .addComponent(botHPLabel)
                                    .addComponent(playerHPLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(attackMan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(battleLogLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Обработка события нажатия кнопки Сделать ход.
     * @param evt 
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //<editor-fold defaultstate="collapsed" desc="Проверка на использование всех очков">
        if (countAttack != server.getPlayer().getAttackPoints())
        {
             battleLog += "Использованы не все очки атаки.\n";
             logger.setText(battleLog);
             return;
        }
        if (countDefense != server.getPlayer().getDefensePoints())
        {
             battleLog += "Использованы не все очки защиты.\n";
             logger.setText(battleLog);
             return;
        }
        //</editor-fold>
        boolean[] attack = new boolean[6];
        boolean[] defense = new boolean[6];

        for (int i = 0; i < 6; ++i)
        {
            attack[i] = attackList.get(i).isSelected();
            defense[i] = defenseList.get(i).isSelected();
        }
        try{
             battleLog += server.translateMessage(new Message(attack,defense));
        //<editor-fold defaultstate="collapsed" desc="Настройка текстов в label">
        playerHPLabel.setText("HP: " +
                        Integer.toString(server.getPlayer().getCurHP()) + "/" +
                        Integer.toString(server.getPlayer().getMaxHP()));
        botHPLabel.setText("HP: " +
                        Integer.toString(server.getBot().getCurHP()) + "/" +
                        Integer.toString(server.getBot().getMaxHP()));
        for (int i = 0; i < 6; ++i){
             attackLabelHpList.get(i).setText(Integer.toString(server.getBot().
                                              getCurrentHpParts()[i]) + "/" +
                                              Integer.toString(server.getBot().
                                              getMaxHpParts()[i]));
             defenseLabelHpList.get(i).setText(Integer.toString(server.
                                               getPlayer().
                                               getCurrentHpParts()[i]) + "/" +
                                               Integer.toString(server.
                                               getPlayer().getMaxHpParts()[i]));
        }
        logger.setText(battleLog);
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Проверка на конец раунда">
        if (server.getPlayer().isDead())
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Игрок проиграл!", 
                        "Поражение", javax.swing.JOptionPane.WARNING_MESSAGE);
            server.translateMessage(new Message("create", 1));
            this.dispose();
        }
        else if (server.getBot().isDead())
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Игрок выиграл!", 
                        "Победа", javax.swing.JOptionPane.WARNING_MESSAGE);
            server.getPlayer().giveExp();
            
            if (server.getPlayer().getCurExp() >= server.getPlayer().getExpForLevel())
            {
                server.getPlayer().levelUp();
                server.translateMessage(new Message("create", 2));
                this.dispose();
                return;
            }
                server.translateMessage(new Message("create", 1));
                this.dispose();
        }
        //</editor-fold>
        }
        catch(java.io.IOException e){
            
        }
       
    }//GEN-LAST:event_jButton1ActionPerformed

    //Защита головы
    private void headDefenseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_headDefenseActionPerformed
        if (headDefense.isSelected())
            ++countDefense;
        else
            --countDefense;

        blockDefenseCheck();
    }//GEN-LAST:event_headDefenseActionPerformed

    //Защита туловища
    private void bodyDefenseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bodyDefenseActionPerformed
        if (bodyDefense.isSelected())
            ++countDefense;
        else
            --countDefense;

        blockDefenseCheck();
    }//GEN-LAST:event_bodyDefenseActionPerformed

    //Защита правой руки
    private void rightHandDefenseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightHandDefenseActionPerformed
        if (rightHandDefense.isSelected())
            ++countDefense;
        else
            --countDefense;

        blockDefenseCheck();
    }//GEN-LAST:event_rightHandDefenseActionPerformed

    //Защита левой руки
    private void leftHandDefenseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leftHandDefenseActionPerformed
        if (leftHandDefense.isSelected())
            ++countDefense;
        else
            --countDefense;

        blockDefenseCheck();
    }//GEN-LAST:event_leftHandDefenseActionPerformed

    //Защита правой ноги
    private void rightLegDefenseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightLegDefenseActionPerformed

        if (rightLegDefense.isSelected())
            ++countDefense;
        else
            --countDefense;

        blockDefenseCheck();
    }//GEN-LAST:event_rightLegDefenseActionPerformed

   //Защита левой ноги
    private void leftLegDefenseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leftLegDefenseActionPerformed
        if (leftLegDefense.isSelected())
            ++countDefense;
        else
            --countDefense;

        blockDefenseCheck();
    }//GEN-LAST:event_leftLegDefenseActionPerformed

    //Атака левой ноги
    private void leftLegAttackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leftLegAttackActionPerformed
        if (leftLegAttack.isSelected())
            ++countAttack;
        else
            --countAttack;

        blockAttackCheck();
    }//GEN-LAST:event_leftLegAttackActionPerformed

    //Атака правой ноги
    private void rightLegAttackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightLegAttackActionPerformed
        if (rightLegAttack.isSelected())
            ++countAttack;
        else
            --countAttack;

        blockAttackCheck();
    }//GEN-LAST:event_rightLegAttackActionPerformed

    //Атака правой руки
    private void rightHandAttackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightHandAttackActionPerformed

        if (rightHandAttack.isSelected())
            ++countAttack;
        else
            --countAttack;

        blockAttackCheck();
    }//GEN-LAST:event_rightHandAttackActionPerformed

    //Атака левой руки
    private void leftHandAttackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leftHandAttackActionPerformed
        if (leftHandAttack.isSelected())
            ++countAttack;
        else
            --countAttack;

        blockAttackCheck();
    }//GEN-LAST:event_leftHandAttackActionPerformed

    //Атака головы
    private void headAttackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_headAttackActionPerformed
        if (headAttack.isSelected())
            ++countAttack;
        else
            --countAttack;

        blockAttackCheck();
    }//GEN-LAST:event_headAttackActionPerformed

    //Атака туловища
    private void bodyAttackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bodyAttackActionPerformed
        if (bodyAttack.isSelected())
            ++countAttack;
        else
            --countAttack;

        blockAttackCheck();
    }//GEN-LAST:event_bodyAttackActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        String s;
        String buf = new String();
        try{
            BufferedReader in = new BufferedReader(new FileReader(new File("Help.hlp")
                                                            .getAbsoluteFile()));
            while ((s = in.readLine()) != null){
                buf += s + "\n";
            }
        }catch (java.io.IOException e){
            
        }
        javax.swing.JOptionPane.showMessageDialog(this, buf, "Помощь новичкам", 
                                  javax.swing.JOptionPane.INFORMATION_MESSAGE);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel attackLabel;
    private gameForms.ImagePanel attackMan;
    private javax.swing.JLabel attackPointLabel;
    private javax.swing.JLabel battleLogLabel;
    private javax.swing.JCheckBox bodyAttack;
    private javax.swing.JCheckBox bodyDefense;
    private javax.swing.JLabel botHPLabel;
    private gameForms.ImagePanel botImage;
    private javax.swing.JLabel botName;
    private javax.swing.JLabel defenseLabel;
    private gameForms.ImagePanel defenseMan;
    private javax.swing.JLabel defensePointLabel;
    private javax.swing.JCheckBox headAttack;
    private javax.swing.JCheckBox headDefense;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelAttackHpBody;
    private javax.swing.JLabel labelAttackHpHead;
    private javax.swing.JLabel labelAttackHpLeftHand;
    private javax.swing.JLabel labelAttackHpLeftLeg;
    private javax.swing.JLabel labelAttackHpRightHand;
    private javax.swing.JLabel labelAttackHpRightLeg;
    private javax.swing.JLabel labelDefenseHpBody;
    private javax.swing.JLabel labelDefenseHpHead;
    private javax.swing.JLabel labelDefenseHpLeftHand;
    private javax.swing.JLabel labelDefenseHpLeftLeg;
    private javax.swing.JLabel labelDefenseHpRightHand;
    private javax.swing.JLabel labelDefenseHpRightLeg;
    private javax.swing.JCheckBox leftHandAttack;
    private javax.swing.JCheckBox leftHandDefense;
    private javax.swing.JCheckBox leftLegAttack;
    private javax.swing.JCheckBox leftLegDefense;
    private javax.swing.JLabel levelLabel;
    private javax.swing.JTextArea logger;
    private javax.swing.JLabel playerHPLabel;
    private gameForms.ImagePanel playerImage;
    private javax.swing.JLabel playerName;
    private javax.swing.JCheckBox rightHandAttack;
    private javax.swing.JCheckBox rightHandDefense;
    private javax.swing.JCheckBox rightLegAttack;
    private javax.swing.JCheckBox rightLegDefense;
    // End of variables declaration//GEN-END:variables
}
