package gameForms;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import gameServer.Server;
import gameServer.Message;
/**
 *
 * @author Пользователь
 */
public class LevelUp extends javax.swing.JFrame {

    /**
     * Creates new form levelUp
     */
    Server server;
    
    public LevelUp(Server server) {
        initComponents();
        sorryForLevelUP.setText("Поздравляю. Вы поднялись до " + server.getPlayer().getLevel() + " уровня.");
        this.server = server;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        choiceUp = new javax.swing.ButtonGroup();
        ok = new javax.swing.JButton();
        sorryForLevelUP = new javax.swing.JLabel();
        attackPoint = new javax.swing.JRadioButton();
        defensePoint = new javax.swing.JRadioButton();
        hp = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ok.setText("Поднять уровень");
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });

        sorryForLevelUP.setText("sorryForLevelUp");

        choiceUp.add(attackPoint);
        attackPoint.setText("Увеличить атаку");

        choiceUp.add(defensePoint);
        defensePoint.setText("Увеличить защиту");

        choiceUp.add(hp);
        hp.setText("Увеличить макс. HP");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 92, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hp)
                    .addComponent(attackPoint)
                    .addComponent(defensePoint)
                    .addComponent(ok))
                .addGap(81, 81, 81))
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(sorryForLevelUP, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(sorryForLevelUP, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(hp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(attackPoint)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(defensePoint)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ok)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okActionPerformed
        // TODO add your handling code here:
        if (hp.isSelected())
            server.translateMessage(new Message(0));
        else if (attackPoint.isSelected())
            server.translateMessage(new Message(1));
        else if (defensePoint.isSelected())
            server.translateMessage(new Message(2));
        
        this.dispose();
    }//GEN-LAST:event_okActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton attackPoint;
    private javax.swing.ButtonGroup choiceUp;
    private javax.swing.JRadioButton defensePoint;
    private javax.swing.JRadioButton hp;
    private javax.swing.JButton ok;
    private javax.swing.JLabel sorryForLevelUP;
    // End of variables declaration//GEN-END:variables
}
