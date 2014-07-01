package gameForms;

import gameServer.Server;
import gameServer.Message;
import javax.swing.ImageIcon;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author komarov
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
        countAttack = 0;
        countDefense = 0;
        this.server = server;
        battleLog = new String();
        attackList = new ArrayList();
        defenseList = new ArrayList();
        attackLabelHpList = new ArrayList();
        defenseLabelHpList = new ArrayList();
        //<editor-fold defaultstate="collapsed" desc="List adding">
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
        //<editor-fold defaultstate="collapsed" desc="Label text setting">
        defenseMan.setImage(new ImageIcon(this.getClass().
                                               getResource("/pictures/man.jpg")).
                                               getImage());
        attackMan.setImage(new ImageIcon(this.getClass().
                                              getResource("/pictures/man.jpg")).
                                              getImage());
        
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
        //</editor-fold>   
    }
    
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
        botIcon = new javax.swing.JLabel();
        playerIcon = new javax.swing.JLabel();
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
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        logger.setColumns(40);
        logger.setRows(5);
        jScrollPane1.setViewportView(logger);

        botIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/bot.jpg"))); // NOI18N
        botIcon.setText("bot");

        playerIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/player.jpg"))); // NOI18N

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                        .addGroup(defenseManLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(defenseManLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(bodyDefense)
                                .addGap(18, 18, 18)
                                .addComponent(labelDefenseHpBody))
                            .addGroup(defenseManLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(headDefense)
                                .addComponent(labelDefenseHpHead)))
                        .addGap(65, 65, 65))))
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
                .addGap(17, 17, 17)
                .addComponent(headDefense)
                .addGap(5, 5, 5)
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

        jMenu1.setText("Файл");

        jMenuItem1.setText("Начать новую игру");
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Сохранить персонажа");
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Выход");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Справка");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(attackMan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(192, 192, 192)
                                .addComponent(playerIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(246, 246, 246)
                                .addComponent(battleLogLabel)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(playerName)
                            .addComponent(defenseMan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(524, 524, 524))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(attackLabel)
                .addGap(165, 165, 165)
                .addComponent(botHPLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(playerHPLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(184, 184, 184)
                .addComponent(defenseLabel)
                .addGap(123, 123, 123))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(playerName)
                    .addComponent(playerIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(attackLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(attackMan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(playerHPLabel)
                                    .addComponent(botHPLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(defenseLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addComponent(defenseMan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(battleLogLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        botIcon.getAccessibleContext().setAccessibleName(" ");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
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
        
        boolean[] attack = new boolean[6];
        boolean[] defense = new boolean[6];

        for (int i = 0; i < 6; ++i)
        {
            attack[i] = attackList.get(i).isSelected();
            defense[i] = defenseList.get(i).isSelected();
        }
        
        battleLog += server.translateMessage(new Message(attack,defense));
        //<editor-fold defaultstate="collapsed" desc="Label text setting">
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
        //</editor-fold>
        logger.setText(battleLog);
        
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel attackLabel;
    private gameForms.ImagePanel attackMan;
    private javax.swing.JLabel battleLogLabel;
    private javax.swing.JCheckBox bodyAttack;
    private javax.swing.JCheckBox bodyDefense;
    private javax.swing.JLabel botHPLabel;
    private javax.swing.JLabel botIcon;
    private javax.swing.JLabel botName;
    private javax.swing.JLabel defenseLabel;
    private gameForms.ImagePanel defenseMan;
    private javax.swing.JCheckBox headAttack;
    private javax.swing.JCheckBox headDefense;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
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
    private javax.swing.JTextArea logger;
    private javax.swing.JLabel playerHPLabel;
    private javax.swing.JLabel playerIcon;
    private javax.swing.JLabel playerName;
    private javax.swing.JCheckBox rightHandAttack;
    private javax.swing.JCheckBox rightHandDefense;
    private javax.swing.JCheckBox rightLegAttack;
    private javax.swing.JCheckBox rightLegDefense;
    // End of variables declaration//GEN-END:variables
}
