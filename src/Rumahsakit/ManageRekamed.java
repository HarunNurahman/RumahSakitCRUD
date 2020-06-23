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
public class ManageRekamed extends javax.swing.JDialog {
    Connection koneksi;
    String action,id;
    public ManageRekamed(java.awt.Frame parent, boolean modal, String act, String id_periksa) {
        super(parent, modal);
        initComponents();
        koneksi = DatabaseConnection.getKoneksi("localhost", "3306", "root", "", "rumahsakit");
        action = act;
        id = id_periksa;
        if (act.equals("add")){
            ShowForm(act, null);
            comboShowDokter();
            comboShowPasien();
            tb_idperiksa.setEnabled(false);
        } else if (act.equals("edit")){
            ShowForm(act, id);
            tb_idperiksa.setEnabled(false);
            comboShowDokter();
            comboShowPasien();
        }
        
    }
    public void comboShowDokter(){
        try{
            Statement stmt = koneksi.createStatement();
            ResultSet rset = stmt.executeQuery("SELECT * FROM tbl_pegawai WHERE nip LIKE 'D%'");
            
            while(rset.next()){
                String s = rset.getString("nama");
                cmb_dokter.addItem(s);
            }
        } catch(SQLException ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan di Query");
        }
    }
    
    public void comboShowPasien(){
        try{
            Statement stmt = koneksi.createStatement();
            ResultSet rset = stmt.executeQuery("SELECT * FROM pasien'");
            
            while(rset.next()){
                String s = rset.getString("nama_pasien");
                cmb_pasien.addItem(s);
            }
        } catch(SQLException ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan di Query");
        }
    }
      void ShowForm(String act,String id_periksa){
        if(action.equals("edit")){
        try{
            Statement stmt = koneksi.createStatement();
            String query = "SELECT * FROM rekammedis WHERE id_periksa = '"+id_periksa+"'";
            ResultSet rs = stmt.executeQuery(query);
            rs.first();
            tb_idperiksa.setText(rs.getString("id_periksa"));
            tb_tanggalp.setDate(rs.getDate("tgl_periksa"));
            cmb_dokter.setSelectedItem(rs.getString("nama_dokter"));
            cmb_pasien.setSelectedItem(rs.getString("nama_pasien"));
            tb_diagnosa.setText(rs.getString("diagnosa")); 
       }catch(SQLException ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan di Query");
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

        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tb_diagnosa = new javax.swing.JTextField();
        btn_simpan = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        tb_tanggalp = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tb_idperiksa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cmb_dokter = new javax.swing.JComboBox();
        cmb_pasien = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel4.setText("Dokter Pemeriksa");

        jLabel3.setText("Tanggal Periksa");

        btn_simpan.setText("Simpan");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });

        jLabel5.setText("Diagnosa");

        tb_tanggalp.setDateFormatString("yyyy-MM-dd");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Id Periksa");

        jLabel1.setFont(new java.awt.Font("Big Winks", 1, 36)); // NOI18N
        jLabel1.setText("Manage Data Rekam Medis");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Nama Pasien");

        cmb_pasien.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tb_tanggalp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tb_idperiksa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                            .addComponent(cmb_pasien, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmb_dokter, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tb_diagnosa, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_simpan))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(tb_idperiksa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cmb_pasien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cmb_dokter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tb_diagnosa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(tb_tanggalp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_simpan)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        String tampilan = "yyy-MM-dd";
        SimpleDateFormat format = new SimpleDateFormat(tampilan);
        RumahSakitApp rsa = new RumahSakitApp();
        
        String id_periksa = tb_idperiksa.getText();
        String tglPeriksa = String.valueOf(format.format(tb_tanggalp.getDate()));
        String idDokter   = cmb_dokter.getSelectedItem().toString();
        String namaPasien   = cmb_pasien.getSelectedItem().toString();
        String diagnosa   = tb_diagnosa.getText();
        
        if(action.equals("add")){
            try {
                Statement stmt = koneksi.createStatement();
                String query = "INSERT INTO rekammedis(nama_pasien,tgl_periksa, nama_dokter,diagnosa) "
                        + "VALUES('"+namaPasien+"','"+tglPeriksa+"','"+idDokter+"','"+diagnosa+"')";
                System.out.println(query);
                int berhasil = stmt.executeUpdate(query);
                if (berhasil == 1){
                    JOptionPane.showMessageDialog(null, "Data Berhasil Dimasukkan");
                }else {
                    JOptionPane.showMessageDialog(null, "Data Gagal Dimasukkan");
                }
            }catch(SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Pada Database");
            }
            rsa.showDatarekammedis();
            setVisible(false);
       }else{
            try{
                Statement stmt = koneksi.createStatement();
                String query = "UPDATE rekammedis SET nama_pasien ='"+namaPasien+"',"
                            + "tgl_periksa='"+tglPeriksa+"'," + "nama_dokter='"+idDokter+"',"
                            + "diagnosa='"+diagnosa+"' WHERE id_periksa = '"+id_periksa+"'";

                System.out.println(query);
                int berhasil = stmt.executeUpdate(query);
                if (berhasil == 1){
                    JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
                }else{
                    JOptionPane.showMessageDialog(null, "Data Gagal Diubah");
                }
            }catch (SQLException ex){
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Terjadi Kesalahan pada Query");
            }  
            rsa.showDatarekammedis();
            setVisible(false);  
        }
        
    }//GEN-LAST:event_btn_simpanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_simpan;
    private javax.swing.JComboBox cmb_dokter;
    private javax.swing.JComboBox cmb_pasien;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField tb_diagnosa;
    private javax.swing.JTextField tb_idperiksa;
    private com.toedter.calendar.JDateChooser tb_tanggalp;
    // End of variables declaration//GEN-END:variables

    private void ShowForm(String act, Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
