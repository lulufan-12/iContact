package cadastrocontatos.gui;

import cadastrocontatos.controladores.Validador;
import cadastrocontatos.entidades.ContatoCliente;
import cadastrocontatos.excecoes.CnpjInvalidoException;
import cadastrocontatos.excecoes.CpfInvalidoException;
import javax.swing.JOptionPane;

/**
 *
 * @author luluf
 */
public class ClienteJDialog extends javax.swing.JDialog {

    /**
     * Creates new form ClienteJDialog
     */
    public ClienteJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public boolean operacaoConfirmada(){
        return confirmado;
    }
    
    public ClienteJDialog(java.awt.Frame parent, OperacaoCadastro operacaoCadastro, ContatoCliente contato){
        super(parent, true);
        confirmado = false;
        this.operacaoCadastro = operacaoCadastro;
        this.contato = contato;
        initComponents();
        if(operacaoCadastro == OperacaoCadastro.ocAlterar
                || operacaoCadastro == OperacaoCadastro.ocConsultar){
            
            edNome.setText(contato.getNome());
            edTelefone.setText(contato.getTelefone());
            edTelefoneTrabalho.setText(contato.getTelefoneTrabalho());
            edCelular.setText(contato.getCelular());
            edEmail.setText(contato.getEmail());
            edFax.setText(contato.getFax());
            edCnpj.setText(contato.getCnpj());
            edCpf.setText(contato.getCpf());
        }
        labelCnpj.setVisible(false);
        btnSalvar.setVisible(operacaoCadastro != OperacaoCadastro.ocConsultar);
        edNome.setEditable(operacaoCadastro != OperacaoCadastro.ocConsultar);
        edEmail.setEditable(operacaoCadastro != OperacaoCadastro.ocConsultar);
        edTelefone.setEditable(operacaoCadastro != OperacaoCadastro.ocConsultar);
        edTelefoneTrabalho.setEditable(operacaoCadastro != OperacaoCadastro.ocConsultar);
        edCelular.setEditable(operacaoCadastro != OperacaoCadastro.ocConsultar);
        edFax.setEditable(operacaoCadastro != OperacaoCadastro.ocConsultar);
        edCnpj.setEditable(operacaoCadastro != OperacaoCadastro.ocConsultar);
        edCpf.setEditable(operacaoCadastro != OperacaoCadastro.ocConsultar);
        radioCnpj.setEnabled(operacaoCadastro != OperacaoCadastro.ocConsultar);
        radioCpf.setEnabled(operacaoCadastro != OperacaoCadastro.ocConsultar);
    }
    
    public static boolean executar(java.awt.Frame parent, OperacaoCadastro operacaoCadastro, ContatoCliente contato){
        ClienteJDialog dialog = new ClienteJDialog(parent, operacaoCadastro, contato);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
        return dialog.operacaoConfirmada();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radioGroupId = new javax.swing.ButtonGroup();
        btnFechar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        edEmail = new javax.swing.JTextField();
        edNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        edCpf = new javax.swing.JFormattedTextField();
        edTelefone = new javax.swing.JFormattedTextField();
        edCnpj = new javax.swing.JFormattedTextField();
        radioCpf = new javax.swing.JRadioButton();
        radioCnpj = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        edTelefoneTrabalho = new javax.swing.JFormattedTextField();
        edCelular = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        edFax = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        labelCpf = new javax.swing.JLabel();
        labelCnpj = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Clientes");
        setResizable(false);

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel1.setLabelFor(edNome);
        jLabel1.setText("Nome");

        jLabel2.setLabelFor(edEmail);
        jLabel2.setText("E-mail");

        jLabel3.setLabelFor(edTelefone);
        jLabel3.setText("Telefone");

        jLabel4.setLabelFor(edFax);
        jLabel4.setText("FAX");

        try {
            edCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            edTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            edCnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        edCnpj.setEnabled(false);

        radioGroupId.add(radioCpf);
        radioCpf.setSelected(true);
        radioCpf.setText("CPF");
        radioCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioCpfActionPerformed(evt);
            }
        });

        radioGroupId.add(radioCnpj);
        radioCnpj.setText("CNPJ");
        radioCnpj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioCnpjActionPerformed(evt);
            }
        });

        jLabel7.setLabelFor(edTelefoneTrabalho);
        jLabel7.setText("Fone Trabalho");

        try {
            edTelefoneTrabalho.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            edCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel8.setLabelFor(edCelular);
        jLabel8.setText("Celular");

        try {
            edFax.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel6.setForeground(new java.awt.Color(204, 51, 0));
        jLabel6.setText("*");

        jLabel10.setForeground(new java.awt.Color(204, 51, 0));
        jLabel10.setText("*");

        jLabel11.setForeground(new java.awt.Color(204, 51, 0));
        jLabel11.setText("*");

        labelCpf.setForeground(new java.awt.Color(204, 51, 0));
        labelCpf.setText("*");

        labelCnpj.setForeground(new java.awt.Color(204, 51, 0));
        labelCnpj.setText("*");

        jLabel9.setForeground(new java.awt.Color(204, 51, 0));
        jLabel9.setText("*");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(edEmail, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(edTelefoneTrabalho, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                    .addComponent(edTelefone, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel8))
                                .addGap(14, 14, 14)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(edFax, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(edCelular, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(edNome))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9))
                        .addGap(14, 14, 14))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radioCpf)
                            .addComponent(radioCnpj))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(edCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelCpf))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(edCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelCnpj)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(edNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(edTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(edTelefoneTrabalho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(edCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(edFax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioCpf)
                    .addComponent(edCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCpf))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCnpj)
                    .addComponent(radioCnpj))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setForeground(new java.awt.Color(204, 51, 0));
        jLabel5.setText("* Campos obrigatórios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFechar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFechar)
                    .addComponent(btnSalvar)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if(operacaoCadastro != OperacaoCadastro.ocConsultar){
            if(edNome.getText().trim().equals("") || edEmail.getText().trim().equals("") ||
                        edTelefone.getText().trim().equals("")){
                
                JOptionPane.showMessageDialog(this, "Preencha todos os campos obrigatórios.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(radioCnpj.isSelected()){
                if(edCnpj.getText().replaceAll("{^0-9]", "").trim().equals("")){
                    JOptionPane.showMessageDialog(this, "Preencha todos os campos obrigatórios.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try{
                    String cnpj = edCnpj.getText().replaceAll("[^0-9]", "");
                    System.out.println("O CNPJ é: " + cnpj);
                    Validador.isCnpj(cnpj);
                }
                catch(CnpjInvalidoException e){
                    JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            else if(radioCpf.isSelected()){
                if(edCpf.getText().replaceAll("{^0-9]", "").trim().equals("")){
                    JOptionPane.showMessageDialog(this, "Preencha todos os campos obrigatórios.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try{
                    String cpf = edCpf.getText().replaceAll("[^0-9]", "");
                    System.out.println("O CPF é: " + cpf);
                    Validador.isCpf(cpf);
                }
                catch(CpfInvalidoException e){
                    JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            
            contato.setNome(edNome.getText());
            contato.setEmail(edEmail.getText());
            contato.setTelefone(edTelefone.getText());
            contato.setCelular(edCelular.getText());
            contato.setTelefoneTrabalho(edTelefoneTrabalho.getText());
            contato.setFax(edFax.getText());
            contato.setCnpj(edCnpj.getText());
            contato.setCpf(edCpf.getText());
            
            String mensagem = (operacaoCadastro == OperacaoCadastro.ocIncluir) ? "Contato adicionado com sucesso." : "Contato alterado com sucesso.";
            JOptionPane.showMessageDialog(this, mensagem, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            confirmado = true;
        }
        dispose();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void radioCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioCpfActionPerformed
        
        edCpf.setEnabled(true);
        labelCpf.setVisible(true);
        edCnpj.setText("");
        edCnpj.setEnabled(false);
        labelCnpj.setVisible(false);
    }//GEN-LAST:event_radioCpfActionPerformed

    private void radioCnpjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioCnpjActionPerformed
        
        edCnpj.setEnabled(true);
        labelCnpj.setVisible(true);
        edCpf.setText("");
        edCpf.setEnabled(false);
        labelCpf.setVisible(false);
    }//GEN-LAST:event_radioCnpjActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

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
            java.util.logging.Logger.getLogger(ClienteJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ClienteJDialog dialog = new ClienteJDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    private boolean confirmado;
    private ContatoCliente contato;
    private OperacaoCadastro operacaoCadastro;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JFormattedTextField edCelular;
    private javax.swing.JFormattedTextField edCnpj;
    private javax.swing.JFormattedTextField edCpf;
    private javax.swing.JTextField edEmail;
    private javax.swing.JFormattedTextField edFax;
    private javax.swing.JTextField edNome;
    private javax.swing.JFormattedTextField edTelefone;
    private javax.swing.JFormattedTextField edTelefoneTrabalho;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelCnpj;
    private javax.swing.JLabel labelCpf;
    private javax.swing.JRadioButton radioCnpj;
    private javax.swing.JRadioButton radioCpf;
    private javax.swing.ButtonGroup radioGroupId;
    // End of variables declaration//GEN-END:variables
}
