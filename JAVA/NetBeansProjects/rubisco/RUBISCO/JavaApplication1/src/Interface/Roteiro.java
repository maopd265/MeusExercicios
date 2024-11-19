/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import classes.Atrativo;
import classes.Categoria;
import classes.Servico;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Anderson
 */
public class Roteiro extends javax.swing.JFrame {

    private float valorTotal;
    private ArrayList<Servico> listaRoteiro = new ArrayList();
    private ArrayList<Servico> listaServicos = new ArrayList();
    private ArrayList<Atrativo> listaAtrativos = new ArrayList();
    private ArrayList<Categoria> listaCategorias = new ArrayList();
    private javax.swing.JTextField orcamentolabel;
    private javax.swing.JTextField cidadelabel;
    private javax.swing.JCheckBox outrosCheckBox;
    private javax.swing.JCheckBox restCheckBox;
    private javax.swing.JCheckBox barCheckBox;
    private javax.swing.JCheckBox cafeCheckBox;
    private javax.swing.JCheckBox cultCheckBox;
    private javax.swing.JCheckBox evCheckBox;
    private javax.swing.JCheckBox hotCheckBox;

    /**
     * Creates new form Roteiro
     */
    public Roteiro(ArrayList<Servico> listaServicos, ArrayList<Atrativo> listaAtrativos, ArrayList<Categoria> listaCategorias, javax.swing.JTextField orcamentolabel, javax.swing.JTextField cidadelabel, javax.swing.JCheckBox restCheckBox, javax.swing.JCheckBox barCheckBox, javax.swing.JCheckBox hotCheckBox, javax.swing.JCheckBox cafeCheckBox, javax.swing.JCheckBox cultCheckBox, javax.swing.JCheckBox evCheckBox, javax.swing.JCheckBox outrosCheckBox) {

        this.listaServicos = listaServicos;
        this.listaAtrativos = listaAtrativos;
        this.listaCategorias = listaCategorias;
        this.orcamentolabel = orcamentolabel;
        this.cidadelabel = cidadelabel;
        this.restCheckBox = restCheckBox;
        this.barCheckBox = barCheckBox;
        this.hotCheckBox = hotCheckBox;
        this.cafeCheckBox = cafeCheckBox;
        this.cultCheckBox = cultCheckBox;
        this.evCheckBox = evCheckBox;
        this.outrosCheckBox = outrosCheckBox;
        this.valorTotal = 0;

        int contopcoes = 0;
        if (restCheckBox.isSelected()) {
            contopcoes = contopcoes + 1;
        }
        if (barCheckBox.isSelected()) {
            contopcoes = contopcoes + 1;
        }
        if (hotCheckBox.isSelected()) {
            contopcoes = contopcoes + 1;
        }
        if (cafeCheckBox.isSelected()) {
            contopcoes = contopcoes + 1;
        }
        if (cultCheckBox.isSelected()) {
            contopcoes = contopcoes + 1;
        }
        if (evCheckBox.isSelected()) {
            contopcoes = contopcoes + 1;
        }
        if (outrosCheckBox.isSelected()) {
            contopcoes = contopcoes + 1;
        }

        if ((Float.parseFloat(orcamentolabel.getText()) >= 200) || (contopcoes <= 3 && Float.parseFloat(orcamentolabel.getText()) <= 200)) {
            roteiroCasoA();
        } else if (contopcoes > 3 && Float.parseFloat(orcamentolabel.getText()) < 200) {
            roteiroCasoB();
        }

        initComponents();

        this.setLocationRelativeTo(null);
        DefaultListModel dlm = new DefaultListModel();
        for (int i = 0; i < listaRoteiro.size(); i++) {
            dlm.addElement(listaRoteiro.get(i).toHtml());
        }
        jList1.setModel(dlm);
        valortotallabel.setText(Float.toString(valorTotal));
    }

    private void roteiroCasoA() {
        Servico aux = new Servico();
        for (int i = 0; i < listaServicos.size(); i++) {
            for (int j = 0; j < listaServicos.size() - 1; j++) {
                if (listaServicos.get(j).getNota() < listaServicos.get(j + 1).getNota()) {
                    aux = listaServicos.get(j);
                    listaServicos.set(j, listaServicos.get(j + 1));
                    listaServicos.set(j + 1, aux);
                }
            }
        }

        if (restCheckBox.isSelected()) {
            int flag = 0;
            int i;
            for (i = 0; i < listaServicos.size(); i++) {
                if (listaServicos.get(i).getCat().getNome().equals("restaurantes") && listaServicos.get(i).getCidade().equals(cidadelabel.getText()) && listaServicos.get(i).getPreco() + valorTotal <= Float.parseFloat(orcamentolabel.getText())) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                // Ainda não foram cadastrados servicos nessa categoria
                JOptionPane.showMessageDialog(null, "Ainda não foram cadastrados serviços nesta cidade na categoria Restaurantes ou seu orçamento é muito baixo!");
            } else {
                listaRoteiro.add(listaServicos.get(i));
                valorTotal += listaServicos.get(i).getPreco();
            }
        }

        if (outrosCheckBox.isSelected()) {
            int flag = 0;
            int i;
            for (i = 0; i < listaServicos.size(); i++) {
                if (listaServicos.get(i).getCat().getNome().equals("outros") && listaServicos.get(i).getCidade().equals(cidadelabel.getText()) && listaServicos.get(i).getPreco() + valorTotal <= Float.parseFloat(orcamentolabel.getText())) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                // Ainda não foram cadastrados servicos nessa categoria
                JOptionPane.showMessageDialog(null, "Ainda não foram cadastrados serviços nesta cidade na categoria Outros ou seu orçamento é muito baixo!");
            } else {
                listaRoteiro.add(listaServicos.get(i));
                valorTotal += listaServicos.get(i).getPreco();
            }
        }

        if (barCheckBox.isSelected()) {
            int flag = 0;
            int i;
            for (i = 0; i < listaServicos.size(); i++) {
                if (listaServicos.get(i).getCat().getNome().equals("bares") && listaServicos.get(i).getCidade().equals(cidadelabel.getText()) && listaServicos.get(i).getPreco() + valorTotal <= Float.parseFloat(orcamentolabel.getText())) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                // Ainda não foram cadastrados servicos nessa categoria
                JOptionPane.showMessageDialog(null, "Ainda não foram cadastrados serviços nesta cidade na categoria Bares ou seu orçamento é muito baixo!");
            } else {
                listaRoteiro.add(listaServicos.get(i));
                valorTotal += listaServicos.get(i).getPreco();
            }
        }

        if (cafeCheckBox.isSelected()) {
            int flag = 0;
            int i;
            for (i = 0; i < listaServicos.size(); i++) {
                if (listaServicos.get(i).getCat().getNome().equals("cafes") && listaServicos.get(i).getCidade().equals(cidadelabel.getText()) && listaServicos.get(i).getPreco() + valorTotal <= Float.parseFloat(orcamentolabel.getText())) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                // Ainda não foram cadastrados servicos nessa categoria
                JOptionPane.showMessageDialog(null, "Ainda não foram cadastrados serviços nesta cidade na categoria Cafés ou seu orçamento é muito baixo!");
            } else {
                listaRoteiro.add(listaServicos.get(i));
                valorTotal += listaServicos.get(i).getPreco();
            }
        }

        if (cultCheckBox.isSelected()) {
            int flag = 0;
            int i;
            for (i = 0; i < listaServicos.size(); i++) {
                if (listaServicos.get(i).getCat().getNome().equals("culturais") && listaServicos.get(i).getCidade().equals(cidadelabel.getText()) && listaServicos.get(i).getPreco() + valorTotal <= Float.parseFloat(orcamentolabel.getText())) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                // Ainda não foram cadastrados servicos nessa categoria
                JOptionPane.showMessageDialog(null, "Ainda não foram cadastrados serviços nesta cidade na categoria Culturais ou seu orçamento é muito baixo!");
            } else {
                listaRoteiro.add(listaServicos.get(i));
                valorTotal += listaServicos.get(i).getPreco();
            }
        }

        if (evCheckBox.isSelected()) {
            int flag = 0;
            int i;
            for (i = 0; i < listaServicos.size(); i++) {
                if (listaServicos.get(i).getCat().getNome().equals("eventos") && listaServicos.get(i).getCidade().equals(cidadelabel.getText()) && listaServicos.get(i).getPreco() + valorTotal <= Float.parseFloat(orcamentolabel.getText())) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                // Ainda não foram cadastrados servicos nessa categoria
                JOptionPane.showMessageDialog(null, "Ainda não foram cadastrados serviços nesta cidade na categoria Eventos ou seu orçamento é muito baixo!");
            } else {
                listaRoteiro.add(listaServicos.get(i));
                valorTotal += listaServicos.get(i).getPreco();
            }
        }

        if (hotCheckBox.isSelected()) {
            int flag = 0;
            int i;
            for (i = 0; i < listaServicos.size(); i++) {
                if (listaServicos.get(i).getCat().getNome().equals("hoteis") && listaServicos.get(i).getCidade().equals(cidadelabel.getText()) && listaServicos.get(i).getPreco() + valorTotal <= Float.parseFloat(orcamentolabel.getText())) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                // Ainda não foram cadastrados servicos nessa categoria
                JOptionPane.showMessageDialog(null, "Ainda não foram cadastrados serviços nesta cidade na categoria Hotéis ou seu orçamento é muito baixo!");
            } else {
                listaRoteiro.add(listaServicos.get(i));
                valorTotal += listaServicos.get(i).getPreco();
            }
        }

    }

    private void roteiroCasoB() {

        Servico aux = new Servico();
        for (int i = 0; i < listaServicos.size(); i++) {
            for (int j = 0; j < listaServicos.size() - 1; j++) {
                if (listaServicos.get(j).getPreco() > listaServicos.get(j + 1).getPreco()) {
                    aux = listaServicos.get(j);
                    listaServicos.set(j, listaServicos.get(j + 1));
                    listaServicos.set(j + 1, aux);
                }
            }
        }

        if (restCheckBox.isSelected()) {
            int flag = 0;
            int i;
            for (i = 0; i < listaServicos.size(); i++) {
                if (listaServicos.get(i).getCat().getNome().equals("restaurantes") && listaServicos.get(i).getCidade().equals(cidadelabel.getText()) && listaServicos.get(i).getPreco() + valorTotal <= Float.parseFloat(orcamentolabel.getText())) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                // Ainda não foram cadastrados servicos nessa categoria
                JOptionPane.showMessageDialog(null, "Ainda não foram cadastrados serviços nesta cidade na categoria Restaurantes ou seu orçamento é muito baixo!");
            } else {
                listaRoteiro.add(listaServicos.get(i));
                valorTotal += listaServicos.get(i).getPreco();
            }
        }

        if (outrosCheckBox.isSelected()) {
            int flag = 0;
            int i;
            for (i = 0; i < listaServicos.size(); i++) {
                if (listaServicos.get(i).getCat().getNome().equals("outros") && listaServicos.get(i).getCidade().equals(cidadelabel.getText()) && listaServicos.get(i).getPreco() + valorTotal <= Float.parseFloat(orcamentolabel.getText())) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                // Ainda não foram cadastrados servicos nessa categoria
                JOptionPane.showMessageDialog(null, "Ainda não foram cadastrados serviços nesta cidade na categoria Outros ou seu orçamento é muito baixo!");
            } else {
                listaRoteiro.add(listaServicos.get(i));
                valorTotal += listaServicos.get(i).getPreco();
            }
        }

        if (barCheckBox.isSelected()) {
            int flag = 0;
            int i;
            for (i = 0; i < listaServicos.size(); i++) {
                if (listaServicos.get(i).getCat().getNome().equals("bares") && listaServicos.get(i).getCidade().equals(cidadelabel.getText()) && listaServicos.get(i).getPreco() + valorTotal <= Float.parseFloat(orcamentolabel.getText())) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                // Ainda não foram cadastrados servicos nessa categoria
                JOptionPane.showMessageDialog(null, "Ainda não foram cadastrados serviços nesta cidade na categoria Bares ou seu orçamento é muito baixo!");
            } else {
                listaRoteiro.add(listaServicos.get(i));
                valorTotal += listaServicos.get(i).getPreco();
            }
        }

        if (cafeCheckBox.isSelected()) {
            int flag = 0;
            int i;
            for (i = 0; i < listaServicos.size(); i++) {
                if (listaServicos.get(i).getCat().getNome().equals("cafes") && listaServicos.get(i).getCidade().equals(cidadelabel.getText()) && listaServicos.get(i).getPreco() + valorTotal <= Float.parseFloat(orcamentolabel.getText())) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                // Ainda não foram cadastrados servicos nessa categoria
                JOptionPane.showMessageDialog(null, "Ainda não foram cadastrados serviços nesta cidade na categoria Cafés ou seu orçamento é muito baixo!");
            } else {
                listaRoteiro.add(listaServicos.get(i));
                valorTotal += listaServicos.get(i).getPreco();
            }
        }

        if (cultCheckBox.isSelected()) {
            int flag = 0;
            int i;
            for (i = 0; i < listaServicos.size(); i++) {
                if (listaServicos.get(i).getCat().getNome().equals("culturais") && listaServicos.get(i).getCidade().equals(cidadelabel.getText()) && listaServicos.get(i).getPreco() + valorTotal <= Float.parseFloat(orcamentolabel.getText())) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                // Ainda não foram cadastrados servicos nessa categoria
                JOptionPane.showMessageDialog(null, "Ainda não foram cadastrados serviços nesta cidade na categoria Culturais ou seu orçamento é muito baixo!");
            } else {
                listaRoteiro.add(listaServicos.get(i));
                valorTotal += listaServicos.get(i).getPreco();
            }
        }

        if (evCheckBox.isSelected()) {
            int flag = 0;
            int i;
            for (i = 0; i < listaServicos.size(); i++) {
                if (listaServicos.get(i).getCat().getNome().equals("eventos") && listaServicos.get(i).getCidade().equals(cidadelabel.getText()) && listaServicos.get(i).getPreco() + valorTotal <= Float.parseFloat(orcamentolabel.getText())) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                // Ainda não foram cadastrados servicos nessa categoria
                JOptionPane.showMessageDialog(null, "Ainda não foram cadastrados serviços nesta cidade na categoria Eventos ou seu orçamento é muito baixo!");
            } else {
                listaRoteiro.add(listaServicos.get(i));
                valorTotal += listaServicos.get(i).getPreco();
            }
        }

        if (hotCheckBox.isSelected()) {
            int flag = 0;
            int i;
            for (i = 0; i < listaServicos.size(); i++) {
                if (listaServicos.get(i).getCat().getNome().equals("hoteis") && listaServicos.get(i).getCidade().equals(cidadelabel.getText()) && listaServicos.get(i).getPreco() + valorTotal <= Float.parseFloat(orcamentolabel.getText())) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                // Ainda não foram cadastrados servicos nessa categoria
                JOptionPane.showMessageDialog(null, "Ainda não foram cadastrados serviços nesta cidade na categoria Hotéis ou seu orçamento é muito baixo!");
            } else {
                listaRoteiro.add(listaServicos.get(i));
                valorTotal += listaServicos.get(i).getPreco();
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

        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        valortotallabel = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jButton1.setBackground(new java.awt.Color(0, 51, 255));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("< Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rubisco.jpg"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setText("Roteiro Turístico");

        jList1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jButton2.setBackground(new java.awt.Color(0, 51, 255));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("< Voltar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 51, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Avaliar Serviços");
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        valortotallabel.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        valortotallabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valortotallabelActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        jLabel2.setText("Orçamento total do Roteiro:");

        jLabel3.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel3.setText("R$:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel9)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(valortotallabel, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(131, 131, 131))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel1)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 26, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(valortotallabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        for (int i = 0; i < listaRoteiro.size(); i++) {
            Avaliacao ava = new Avaliacao(listaRoteiro.get(i));
            ava.setVisible(true);
        }
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void valortotallabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valortotallabelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valortotallabelActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Roteiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Roteiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Roteiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Roteiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Roteiro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField valortotallabel;
    // End of variables declaration//GEN-END:variables
}
