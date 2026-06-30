/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Turma;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author guest.jb
 */
public class RemoverTurma extends javax.swing.JFrame {

    /**
     * Creates new form RemoverTurma
     */
    public RemoverTurma() {
        initComponents();
        try {
    // Abre a conexão usando a sua classe de conexão
    Connection conn = conexao.conexao.conectar();

    // Limpa os itens antigos da combo box para não duplicar
    cbTurmaRemover.removeAllItems();

    // Comando SQL para buscar os usuários
    String Sql = "select nome_turma from turmas order by nome_turma asc;";

    PreparedStatement stmt = conn.prepareStatement(Sql);
    
    // Executa a consulta e guarda os resultados no ResultSet
    ResultSet rs = stmt.executeQuery();

    // Percorre todos os usuários encontrados no banco
    while (rs.next()) {
        // Pega o texto da coluna "usuario" e adiciona na cbxUsuario
        cbTurmaRemover.addItem(rs.getString("nome_turma"));
    }

    // Fecha os recursos na ordem correta
    rs.close();
    stmt.close();
    conn.close();
    
} catch(Exception e) {
    e.printStackTrace();
    JOptionPane.showMessageDialog(null, "Erro ao carregar usuários: " + e.getMessage());
}
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblRemoverTurma = new javax.swing.JLabel();
        lblTurma = new javax.swing.JLabel();
        lblSenhaTurma = new javax.swing.JLabel();
        cbTurmaRemover = new javax.swing.JComboBox<>();
        txtSenhaRemover = new javax.swing.JTextField();
        btnDeletar = new javax.swing.JButton();
        btnvoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblRemoverTurma.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblRemoverTurma.setText("REMOVER TURMA");

        lblTurma.setText("Turma");

        lblSenhaTurma.setText("Senha");

        cbTurmaRemover.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione..", "Item 2", "Item 3", "Item 4" }));

        btnDeletar.setText("DELETAR");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        btnvoltar.setFont(new java.awt.Font("Segoe UI", 1, 8)); // NOI18N
        btnvoltar.setText("Voltar");
        btnvoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(lblRemoverTurma)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnvoltar)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnDeletar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblSenhaTurma)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtSenhaRemover))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblTurma)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cbTurmaRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblRemoverTurma)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTurma)
                    .addComponent(cbTurmaRemover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSenhaTurma)
                    .addComponent(txtSenhaRemover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(btnDeletar)
                .addGap(47, 47, 47)
                .addComponent(btnvoltar)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnvoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvoltarActionPerformed
      this.dispose();
    }//GEN-LAST:event_btnvoltarActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
    
        String turma = (String) cbTurmaRemover.getSelectedItem();
        try{ Connection conn = conexao.conexao.conectar();
            String sql = "DELETE FROM turmas WHERE nome_turma=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1,turma);
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Deletado!");
            stmt.close();
            conn.close();
      }catch(Exception e){
            e.printStackTrace();
    }                                          
    }//GEN-LAST:event_btnDeletarActionPerformed

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
            java.util.logging.Logger.getLogger(RemoverTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RemoverTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RemoverTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RemoverTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RemoverTurma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnvoltar;
    private javax.swing.JComboBox<String> cbTurmaRemover;
    private javax.swing.JLabel lblRemoverTurma;
    private javax.swing.JLabel lblSenhaTurma;
    private javax.swing.JLabel lblTurma;
    private javax.swing.JTextField txtSenhaRemover;
    // End of variables declaration//GEN-END:variables
}
