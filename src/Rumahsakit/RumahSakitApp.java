package Rumahsakit;

import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.table.DefaultTableModel;

public class RumahSakitApp extends javax.swing.JFrame {
    int selected, baris = -1;
    Connection koneksi;
    DefaultTableModel dtm;
    static final int min = 1;
    static final int max = 10000;
    
    public RumahSakitApp() {
        initComponents();
        koneksi = DatabaseConnection.getKoneksi("localhost", "3306", "root", "", "rumahsakit");
        
        showDatarekammedis();
        showDatapegawai();
        showDataPasien();
        showDataObat();
        showDataAlat();
        
        loadingBar.setMinimum(min);
        loadingBar.setMaximum(max);
    }
    
    public void showDataAlat() {
        String kolom[] = {"No","id_alat","nama_alat","stok","jenis"};
        dtm = new DefaultTableModel(null, kolom);
        try {
            Statement stmt = koneksi.createStatement();
            String query = "SELECT * FROM tbl_alat";
            ResultSet rs = stmt.executeQuery(query);
            int no = 1;
            while (rs.next()) {
                String id = rs.getString("id_alat");
                String nama = rs.getString("nama_alat");
                String stok = rs.getString("stok");
                String jenis = rs.getString("jenis");

                dtm.addRow(new String[]{no+"",id,nama,stok,jenis});
                no++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        tbl_alat.setModel(dtm);
    }
    public void showDataObat() {
        String kolom[] = {"No","id_obat","nama_obat","stok","jenis"};
        dtm = new DefaultTableModel(null, kolom);
        try {
            Statement stmt = koneksi.createStatement();
            String query = "SELECT * FROM tbl_obat";
            ResultSet rs = stmt.executeQuery(query);
            int no = 1;
            while (rs.next()) {
                String id = rs.getString("id_obat");
                String nama = rs.getString("nama_obat");
                String stok = rs.getString("stok");
                String jenis = rs.getString("jenis");

                dtm.addRow(new String[]{no+"",id,nama,stok,jenis});
                no++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        tbl_obat.setModel(dtm);
    }
    public void showDataPasien() {
        String[] kolom = {"No", "ID Pasien", "Nama", "Tempat Lahir", "Tanggal Lahir", "Alamat", "Kota", "No. Telp"};
        
        dtm = new DefaultTableModel (null, kolom);
        try{
            Statement stmt = koneksi.createStatement();
            String query = "SELECT * FROM pasien";
            ResultSet rs = stmt.executeQuery(query);
            int no = 1;
            while(rs.next()){
                String nomedrec = rs.getString("nomedrec");
                String nama = rs.getString("nama_pasien");
                String tempat_lahir = rs.getString("tempat_lahir");
                String tgl_lahir = rs.getString("tgl_lahir");
                String alamat = rs.getString("alamat");
                String kota = rs.getString("kota");
                String telp = rs.getString("telepon");
                
                dtm.addRow(new String[] {no+"",nomedrec, nama, tempat_lahir, tgl_lahir, alamat, kota, telp});
                no++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        tbl_pasien.setModel(dtm);
    }
    public void showDatarekammedis(){
        String[] kolom = {"NO","ID Periksa", "Nama Pasien" , "Tanggal Periksa", "ID Dokter", "Diagnosa"};
        
        dtm = new DefaultTableModel(null, kolom);
        try{
            Statement stmt = koneksi.createStatement();
            String query = "SELECT * FROM rekammedis";
            ResultSet rs = stmt.executeQuery(query);
            int no = 1;
            while (rs.next()){
                String id_periksa = rs.getString("id_periksa");
                String nama_pasien = rs.getString("nama_pasien");
                String tgl_periksa = rs.getString("tgl_periksa");
                String id_dokter = rs.getString("nama_dokter");
                String diagnosa = rs.getString("diagnosa");
                
                dtm.addRow(new String[]{no+"",id_periksa,nama_pasien,tgl_periksa,id_dokter,diagnosa});
                no++;
            }
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        tbl_rekammedis.setModel(dtm);
    }
    public void showDatapegawai(){
        String[] kolom = {"NO", "NIP", "Nama", "Jenis Pekerjaan", "Tempat Lahir", "Tanggal Lahir", "Alamat", "No. Telp", "Email"};
        
        dtm = new DefaultTableModel(null, kolom);
        try {
            Statement stmt = koneksi.createStatement();
            String query = "SELECT * FROM tbl_pegawai";
            ResultSet rs = stmt.executeQuery(query);
            int no = 1;
            while (rs.next()){
                String nip = rs.getString("nip");
                String nama = rs.getString("nama");
                String jenis_pekerjaan = rs.getString("jenis_pekerjaan");
                String tempat_lahir = rs.getString("tempat_lahir");
                String tanggal_lahir = rs.getString("tanggal_lahir");
                String alamat = rs.getString("alamat");
                String no_telp = rs.getString("no_telp");
                String email = rs.getString("email");
                
                dtm.addRow(new String[]{no+"",nip,nama,jenis_pekerjaan,tempat_lahir,tanggal_lahir,alamat,no_telp,email});
                no++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        tbl_pegawai.setModel(dtm);
    }
    
    public void addPegawai(){
        ManagePegawai Tambah = new ManagePegawai(this, true, "add","");
        Tambah.setVisible(true);
    }
    public void addPasien(){
        ManagePasien Tambah = new ManagePasien(this, true, "add","");
        Tambah.setVisible(true);
    }
    public void addRekam(){
        ManageRekamed Tambah = new ManageRekamed(this, true, "add","");
        Tambah.setVisible(true);
    }
    public void addObat(){
        ManageObat Tambah = new ManageObat(this, true, "add","");
        Tambah.setVisible(true);
    }
    public void addAlat(){
        ManageAlat Tambah = new ManageAlat(this, true, "add","");
        Tambah.setVisible(true);
    }
    
    public void editPegawai(){
        String nip = tbl_pegawai.getValueAt (baris, 1).toString();
        if(baris == -1){
            JOptionPane.showMessageDialog(null, "Data belum dipilih!");
        } else {
            new ManagePegawai(this, true, "edit",nip).setVisible(true);
        }
    }
    public void editPasien(){
        String id_pasien = tbl_pasien.getValueAt (baris, 1).toString();
        if(baris == -1){
            JOptionPane.showMessageDialog(null, "Data belum dipilih!");
        } else {
            new ManagePasien(this, true, "edit", id_pasien).setVisible(true);
        }
    }
    public void editRekam(){
        String id_rekamed = tbl_rekammedis.getValueAt (baris, 1).toString();
        if(baris == -1){
            JOptionPane.showMessageDialog(null, "Data belum dipilih!");
        } else {
            new ManageRekamed(this, true, "edit", id_rekamed).setVisible(true);
        }
    }
    public void editObat(){
        String id_obat = tbl_obat.getValueAt (baris, 1).toString();
        if(baris == -1){
            JOptionPane.showMessageDialog(null, "Data belum dipilih!");
        } else {
            new ManageObat(this, true, "edit",id_obat).setVisible(true);
        }
    }
    public void editAlat(){
        String id_alat = tbl_alat.getValueAt (baris, 1).toString();
        if(baris == -1){
            JOptionPane.showMessageDialog(null, "Data belum dipilih!");
        } else {
            new ManageAlat(this, true, "edit",id_alat).setVisible(true);
        }
    }
    
    public void deletePegawai(){
        String id_pegawai = tbl_pegawai.getValueAt (baris, 1).toString();
        if(baris == -1){
            JOptionPane.showMessageDialog(null, "Data belum dipilih!");
        } else {
            try{
                Statement stmt = koneksi.createStatement();
                String delete = "DELETE FROM tbl_pegawai WHERE nip='"+id_pegawai+"';";
                int berhasil = stmt.executeUpdate(delete);
                if(berhasil == 1){
                    JOptionPane.showMessageDialog(null, "Data Berhasil dihapus!");
                    dtm.getDataVector().removeAllElements();
                    showDataPasien();
                } else {
                    JOptionPane.showMessageDialog(null, "Data Gagal dihapus!");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    public void deletePasien(){
        String id_pasien = tbl_pasien.getValueAt (baris, 1).toString();
        
        if(baris == -1){
            JOptionPane.showMessageDialog(null, "Data belum dipilih!");
        } else {
            try{
                Statement stmt = koneksi.createStatement();
                String delete = "DELETE FROM pasien WHERE nomedrec='"+id_pasien+"';";
                int berhasil = stmt.executeUpdate(delete);
                if(berhasil == 1){
                    JOptionPane.showMessageDialog(null, "Data Berhasil dihapus!");
                    dtm.getDataVector().removeAllElements();
                    showDataPasien();
                } else {
                    JOptionPane.showMessageDialog(null, "Data Gagal dihapus!");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    public void deleteRekam(){
        String id_rekamed = tbl_rekammedis.getValueAt (baris, 1).toString();
        if(baris == -1){
            JOptionPane.showMessageDialog(null, "Data belum dipilih!");
        } else {
            try{
                Statement stmt = koneksi.createStatement();
                String delete = "DELETE FROM rekammedis WHERE id_periksa='"+id_rekamed+"';";
                int berhasil = stmt.executeUpdate(delete);
                if(berhasil == 1){
                    JOptionPane.showMessageDialog(null, "Data Berhasil dihapus!");
                    dtm.getDataVector().removeAllElements();
                    showDataPasien();
                } else {
                    JOptionPane.showMessageDialog(null, "Data Gagal dihapus!");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    public void deleteObat(){
        String id_obat = tbl_obat.getValueAt (baris, 1).toString();
        if(baris == -1){
            JOptionPane.showMessageDialog(null, "Data belum dipilih!");
        } else {
            try{
                Statement stmt = koneksi.createStatement();
                String delete = "DELETE FROM tbl_obat WHERE id_obat='"+id_obat+"';";
                int berhasil = stmt.executeUpdate(delete);
                if(berhasil == 1){
                    JOptionPane.showMessageDialog(null, "Data Berhasil dihapus!");
                    dtm.getDataVector().removeAllElements();
                    showDataPasien();
                } else {
                    JOptionPane.showMessageDialog(null, "Data Gagal dihapus!");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    public void deleteAlat(){
        String id_alat = tbl_alat.getValueAt (baris, 1).toString();
        if(baris == -1){
            JOptionPane.showMessageDialog(null, "Data belum dipilih!");
        } else {
            try{
                Statement stmt = koneksi.createStatement();
                String delete = "DELETE FROM tbl_alat WHERE id_alat='"+id_alat+"';";
                int berhasil = stmt.executeUpdate(delete);
                if(berhasil == 1){
                    JOptionPane.showMessageDialog(null, "Data Berhasil dihapus!");
                    dtm.getDataVector().removeAllElements();
                    showDataPasien();
                } else {
                    JOptionPane.showMessageDialog(null, "Data Gagal dihapus!");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        TabContent = new javax.swing.JTabbedPane();
        tabPasien = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_pasien = new javax.swing.JTable();
        tabRekammedis = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_rekammedis = new javax.swing.JTable();
        tabPegawai = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_pegawai = new javax.swing.JTable();
        tabObat = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_obat = new javax.swing.JTable();
        tabAlat = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_alat = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        loadingBar = new javax.swing.JProgressBar();
        lbl_proses = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setFocusable(false);
        setForeground(java.awt.Color.white);

        jLabel1.setFont(new java.awt.Font("Made With B", 0, 36)); // NOI18N
        jLabel1.setText("Hospital Data Manager");

        TabContent.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        TabContent.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                TabContentStateChanged(evt);
            }
        });

        tabPasien.setAutoscrolls(true);
        tabPasien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabPasienMouseClicked(evt);
            }
        });

        tbl_pasien.setBackground(new java.awt.Color(240, 240, 240));
        tbl_pasien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_pasien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_pasienMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_pasien);

        javax.swing.GroupLayout tabPasienLayout = new javax.swing.GroupLayout(tabPasien);
        tabPasien.setLayout(tabPasienLayout);
        tabPasienLayout.setHorizontalGroup(
            tabPasienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 856, Short.MAX_VALUE)
        );
        tabPasienLayout.setVerticalGroup(
            tabPasienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabPasienLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        TabContent.addTab("Data Pasien", tabPasien);

        tabRekammedis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabRekammedisMouseClicked(evt);
            }
        });

        tbl_rekammedis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_rekammedis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_rekammedisMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_rekammedis);

        javax.swing.GroupLayout tabRekammedisLayout = new javax.swing.GroupLayout(tabRekammedis);
        tabRekammedis.setLayout(tabRekammedisLayout);
        tabRekammedisLayout.setHorizontalGroup(
            tabRekammedisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 856, Short.MAX_VALUE)
        );
        tabRekammedisLayout.setVerticalGroup(
            tabRekammedisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabRekammedisLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        TabContent.addTab("Data Rekam Medis", tabRekammedis);

        tabPegawai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabPegawaiMouseClicked(evt);
            }
        });

        tbl_pegawai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_pegawai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_pegawaiMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_pegawai);

        javax.swing.GroupLayout tabPegawaiLayout = new javax.swing.GroupLayout(tabPegawai);
        tabPegawai.setLayout(tabPegawaiLayout);
        tabPegawaiLayout.setHorizontalGroup(
            tabPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 856, Short.MAX_VALUE)
        );
        tabPegawaiLayout.setVerticalGroup(
            tabPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabPegawaiLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        TabContent.addTab("Data Pegawai", tabPegawai);

        tabObat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabObatMouseClicked(evt);
            }
        });

        tbl_obat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_obat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_obatMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbl_obat);

        javax.swing.GroupLayout tabObatLayout = new javax.swing.GroupLayout(tabObat);
        tabObat.setLayout(tabObatLayout);
        tabObatLayout.setHorizontalGroup(
            tabObatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 856, Short.MAX_VALUE)
        );
        tabObatLayout.setVerticalGroup(
            tabObatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
        );

        TabContent.addTab("Data Obat", tabObat);

        tabAlat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabAlatMouseClicked(evt);
            }
        });

        tbl_alat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_alat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_alatMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbl_alat);

        javax.swing.GroupLayout tabAlatLayout = new javax.swing.GroupLayout(tabAlat);
        tabAlat.setLayout(tabAlatLayout);
        tabAlatLayout.setHorizontalGroup(
            tabAlatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 856, Short.MAX_VALUE)
        );
        tabAlatLayout.setVerticalGroup(
            tabAlatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
        );

        TabContent.addTab("Data Alat", tabAlat);

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rumahsakit/add.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rumahsakit/edit.png"))); // NOI18N
        btnUpdate.setText("Edit");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rumahsakit/del.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rumahsakit/refresh.png"))); // NOI18N
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        lbl_proses.setText("Action Status");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TabContent)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRefresh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAdd)
                        .addGap(19, 19, 19))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(loadingBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_proses, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd)
                            .addComponent(btnUpdate)
                            .addComponent(btnDelete)
                            .addComponent(btnRefresh))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TabContent, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_proses)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(loadingBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabRekammedisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabRekammedisMouseClicked
  
    }//GEN-LAST:event_tabRekammedisMouseClicked
    private void tabPegawaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabPegawaiMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tabPegawaiMouseClicked
    private void tabPasienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabPasienMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabPasienMouseClicked
    private void tabObatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabObatMouseClicked
    }//GEN-LAST:event_tabObatMouseClicked
    private void tabAlatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabAlatMouseClicked
    }//GEN-LAST:event_tabAlatMouseClicked

    private void TabContentStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_TabContentStateChanged
        selected = TabContent.getSelectedIndex();
        baris = -1;
    }//GEN-LAST:event_TabContentStateChanged

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        loadingBar.setValue(0);
        lbl_proses.setText("Adding...");
        loadingBar.setStringPainted(true);

        if (selected == 0){
            addPasien();
            showDataPasien();
        }
        else if (selected == 1){
            addRekam();
            showDatarekammedis();
        }
        else if (selected == 2){
            addPegawai();
            showDatapegawai();
        }
        else if (selected == 3){
            addObat();
            showDataObat();
        }
        else if (selected == 4){
            addAlat();
            showDataAlat();
        }
        loadingBar.setValue(max);
        lbl_proses.setText("Add Data Complete.");
    }//GEN-LAST:event_btnAddActionPerformed

    private void tbl_pasienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_pasienMouseClicked
        baris = tbl_pasien.getSelectedRow();
    }//GEN-LAST:event_tbl_pasienMouseClicked
    private void tbl_rekammedisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_rekammedisMouseClicked
        baris = tbl_rekammedis.getSelectedRow();
    }//GEN-LAST:event_tbl_rekammedisMouseClicked
    private void tbl_pegawaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_pegawaiMouseClicked
        baris = tbl_pegawai.getSelectedRow();
    }//GEN-LAST:event_tbl_pegawaiMouseClicked
    private void tbl_obatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_obatMouseClicked
        baris = tbl_obat.getSelectedRow();
    }//GEN-LAST:event_tbl_obatMouseClicked
    private void tbl_alatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_alatMouseClicked
        baris = tbl_alat.getSelectedRow();
    }//GEN-LAST:event_tbl_alatMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        loadingBar.setValue(0);
        
        if (baris == -1){
            JOptionPane.showMessageDialog(null, "Data Belum Dipilih!");
        } else {
            lbl_proses.setText("Updating...");
            loadingBar.setStringPainted(true);
            
            if (selected == 0){
                editPasien();
                showDataPasien();
            }
            else if (selected == 1){
                editRekam();
                showDatarekammedis();
            }
            else if (selected == 2){
                editPegawai();
                showDatapegawai();
            }
            else if (selected == 3){
                editObat();
                showDataObat();
            }
            else if (selected == 4){
                editAlat();
                showDataAlat();
            }
            loadingBar.setValue(max);
            lbl_proses.setText("Update Data Complete.");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        JFrame frame = new JFrame();
        String message = "Yakin Mau dihapus ini teh???";
        loadingBar.setValue(0);
        
        if (baris == -1){
            JOptionPane.showMessageDialog(null, "Data Belum Dipilih!");
        } else {
            lbl_proses.setText("Deleting...");
            loadingBar.setStringPainted(true);
            int answer = JOptionPane.showConfirmDialog(frame, message);
            
            if (answer == JOptionPane.YES_OPTION) {
                loadingBar.setValue(max);
                lbl_proses.setText("Deleting Complete.");
                if (selected == 0){
                    deletePasien();
                    showDataPasien();
                }
                else if (selected == 1){
                    deleteRekam();
                    showDatarekammedis();
                }
                else if (selected == 2){
                    deletePegawai();
                    showDatapegawai();
                }
                else if (selected == 3){
                    deleteObat();
                    showDataObat();
                }
                else if (selected == 4){
                    deleteAlat();
                    showDataAlat();
                }
            } else {
                loadingBar.setValue(max);
                lbl_proses.setText("Delete data canceled.");
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed
    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        if (selected == 0){
                showDataPasien();
            }
            else if (selected == 1){
                showDatarekammedis();
            }
            else if (selected == 2){
                showDatapegawai();
            }
            else if (selected == 3){
                showDataObat();
            }
            else if (selected == 4){
                showDataAlat();
            }
    }//GEN-LAST:event_btnRefreshActionPerformed
   
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
            java.util.logging.Logger.getLogger(RumahSakitApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RumahSakitApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RumahSakitApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RumahSakitApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RumahSakitApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane TabContent;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lbl_proses;
    private javax.swing.JProgressBar loadingBar;
    private javax.swing.JPanel tabAlat;
    private javax.swing.JPanel tabObat;
    private javax.swing.JPanel tabPasien;
    private javax.swing.JPanel tabPegawai;
    private javax.swing.JPanel tabRekammedis;
    private javax.swing.JTable tbl_alat;
    private javax.swing.JTable tbl_obat;
    private javax.swing.JTable tbl_pasien;
    private javax.swing.JTable tbl_pegawai;
    private javax.swing.JTable tbl_rekammedis;
    // End of variables declaration//GEN-END:variables
}
