/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rumahsakit;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Muhammad Ilham H
 */
public class ManagePegawai extends javax.swing.JDialog {
    Connection koneksi;
    String action, nipp;
    public ManagePegawai(java.awt.Frame parent, boolean modal, String act, String nips) {
        super(parent, modal);
        initComponents();
        koneksi = DatabaseConnection.getKoneksi("localhost", "3306", "root", "", "rumahsakit");
        action = act;
        nipp = nips;
        txtJen.setEnabled(false);
        
        if (act.equals("add")){
            ShowForm(act, null);
        } else if (act.equals("edit")){
            ShowForm(act, nips);
            txtNIP.setEnabled(false);
        }
    }
    
    void ShowForm(String act, String nip){
        if (act.equals("edit")){
            try{
                Statement stmt = koneksi.createStatement();
                String query = "SELECT * FROM tbl_pegawai WHERE nip = '"+nip+"'";
                ResultSet rs = stmt.executeQuery(query);
                rs.first();
                txtNIP.setText(rs.getString("nip"));
                txtNama.setText(rs.getString("nama"));
                txtJenpe.setSelectedItem(rs.getString("jenis_pekerjaan"));
                txtTemla.setText(rs.getString("tempat_lahir"));
                txtTgl.setDate(rs.getDate("tanggal_lahir"));
                txtAlamat.setText(rs.getString("alamat"));
                txtNotelp.setText(rs.getString("no_telp"));
                txtEmail.setText(rs.getString("email"));
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Terjadi Kesalahan di Query!");
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNIP = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTemla = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtAlamat = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNotelp = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtTgl = new com.toedter.calendar.JDateChooser();
        btnSave = new javax.swing.JButton();
        txtJenpe = new javax.swing.JComboBox();
        txtJen = new javax.swing.JTextField();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Big Winks", 1, 36)); // NOI18N
        jLabel1.setText("Manage Data Pegawai");

        jLabel2.setText("NIP");

        jLabel3.setText("Nama");

        jLabel4.setText("Jenis Pekerjaan");

        jLabel5.setText("Tempat Lahir");

        jLabel6.setText("Tanggal Lahir");

        jLabel7.setText("Alamat");

        jLabel8.setText("No. Telp");

        jLabel9.setText("Email");

        txtTgl.setDateFormatString("yyyy-MM-dd");

        btnSave.setText("Simpan");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        txtJenpe.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Dokter", "Perawat", "Security", "Cleaning Service", "Administrasi", "Supir Ambulan", "Petugas Kamar Mayat", "Petugas Peralatan", "Staff" }));
        txtJenpe.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                txtJenpeItemStateChanged(evt);
            }
        });
        txtJenpe.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtJenpeFocusLost(evt);
            }
        });
        txtJenpe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJenpeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSave)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtJen, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNIP, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtTemla, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                                .addComponent(txtNama, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtJenpe, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtAlamat)
                            .addComponent(txtTgl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtEmail)
                            .addComponent(txtNotelp, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7)
                    .addComponent(txtJen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNotelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9)
                    .addComponent(txtJenpe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTemla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(btnSave)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        String tampilan = "yyyy-MM-dd";
        SimpleDateFormat format = new SimpleDateFormat(tampilan);
        RumahSakitApp rsa = new RumahSakitApp();
        
        String jen = txtJen.getText();
        String nip = txtNIP.getText();
        String nama = txtNama.getText();
        String jenpe = txtJenpe.getSelectedItem().toString();
        String tempat_lahir = txtTemla.getText();
        String tgl_lahir = String.valueOf(format.format(txtTgl.getDate()));
        String alamat = txtAlamat.getText();
        String notelp = txtNotelp.getText();
        String email = txtEmail.getText();

        if(action.equals("add")){
            try{
                Statement stmt = koneksi.createStatement();
                String query = "INSERT INTO tbl_pegawai(nip, nama, jenis_pekerjaan, tempat_lahir, tanggal_lahir, alamat, "
                + "no_telp, email)"
                + "VALUES('"+jen+nip+"','"+nama+"', '"+jenpe+"', '"+tempat_lahir+"','"
                + tgl_lahir+"','"+alamat+"','"+notelp+"','"
                + email+"')";
                System.out.println(query);
                int berhasil = stmt.executeUpdate(query);
                if(berhasil == 1){
                    JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan!");
                } else {
                    JOptionPane.showMessageDialog(null, "Data Gagal Ditambahkan!");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Terjadi Kesalahan di Query!");
            }
            rsa.showDatapegawai();
            setVisible(false);
        } else {
            try{
                Statement stmt = koneksi.createStatement();
                String query = "UPDATE tbl_pegawai SET nama = '"+nama
                +"', jenis_pekerjaan = '"+jenpe+"', tempat_lahir = '"+tempat_lahir+"', tanggal_lahir = '"+tgl_lahir+"', "
                + "alamat = '"+alamat+"', no_telp = '"+notelp+"', email = '"+email+"' WHERE nip = '"+nip+"'";
                int berhasil = stmt.executeUpdate(query);
                if(berhasil == 1){
                    JOptionPane.showMessageDialog(null, "Data Berhasil Diubah!");
                } else {
                    JOptionPane.showMessageDialog(null, "Data Gagal Diubah!");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Terjadi Kesalahan di Query!");
            }
            rsa.showDatapegawai();
            setVisible(false);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtJenpeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtJenpeFocusLost
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtJenpeFocusLost

    private void txtJenpeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_txtJenpeItemStateChanged
        // TODO add your handling code here:
        int jenis = txtJenpe.getSelectedIndex();
        if (jenis == 0){
            txtJen.setText("D");
        }else if (jenis == 1){
            txtJen.setText("PE");
        }else if (jenis == 2){
            txtJen.setText("SE");
        }else if (jenis == 3){
            txtJen.setText("CS");
        }else if (jenis == 4){
            txtJen.setText("AM");
        }else if (jenis == 5){
            txtJen.setText("SA");
        }else if (jenis == 6){
            txtJen.setText("KM");
        }else if (jenis == 7){
            txtJen.setText("PP");
        }else {
            txtJen.setText("SF");
        }
    }//GEN-LAST:event_txtJenpeItemStateChanged

    private void txtJenpeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJenpeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJenpeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtAlamat;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtJen;
    private javax.swing.JComboBox txtJenpe;
    private javax.swing.JTextField txtNIP;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNotelp;
    private javax.swing.JTextField txtTemla;
    private com.toedter.calendar.JDateChooser txtTgl;
    // End of variables declaration//GEN-END:variables
}