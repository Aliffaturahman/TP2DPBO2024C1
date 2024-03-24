/*
    Saya Alif Faturahman Firdaus (2107377) mengerjakan Tugas Praktikum 2 dalam mata
    kuliah DPBO untuk keberkahan-Nya maka saya tidak melakukan kecurangan seperti yang
    telah dispesifikasikan. Aamiin.
*/

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Menu extends JFrame{
    public static void main(String[] args) {
        // buat object window
        Menu window = new Menu();

        // atur ukuran window
        window.setSize(700, 600);
        // Letakkan window di tengah layar
        window.setLocationRelativeTo(null);
        // isi window
        window.setContentPane(window.mainPanel);
        // ubah warna background
        window.getContentPane().setBackground(Color.white);
        // tampilkan window
        window.setVisible(true);
        // agar program ikut berhenti saat window diclose
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // index baris yang diklik
    private int selectedIndex = -1;
    // list untuk menampung semua mahasiswa
    private ArrayList<Mahasiswa> listMahasiswa;
    private Database database;

    private JPanel mainPanel;
    private JTextField nimField;
    private JTextField namaField;
    private JTable mahasiswaTable;
    private JButton addUpdateButton;
    private JButton cancelButton;
    private JComboBox jenisKelaminComboBox;
    private JButton deleteButton;
    private JLabel titleLabel;
    private JLabel nimLabel;
    private JLabel namaLabel;
    private JLabel jenisKelaminLabel;
    private JLabel hobbyLabel;
    private JTextField hobbyField;
    private JLabel mbtiLabel;
    private JComboBox mbtiComboBox;
    private JLabel ownerLabel;

    // constructor
    public Menu() {
        // inisialisasi listMahasiswa
        listMahasiswa = new ArrayList<>();

        // isi object database
        database = new Database();

        // isi tabel mahasiswa
        mahasiswaTable.setModel(setTable());

        // ubah styling title
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, 20f));

        // ubah styling owner
        ownerLabel.setFont(ownerLabel.getFont().deriveFont(Font.ITALIC, 10f));

        // atur isi combo box jenis kelamin
        String[] jenisKelaminData = {"", "Laki-laki", "Perempuan"};
        jenisKelaminComboBox.setModel(new DefaultComboBoxModel(jenisKelaminData));

        // atur isi combo box mbti
        String[] mbtiData = {"", "INTJ", "INTP", "ENTJ", "ENTP", "INFJ", "INFP", "ENFJ", "ENFP", "ISTJ", "ISFJ", "ESTJ", "ESFJ", "ISTP", "ESFP", "ESTP", "ESFP"};
        mbtiComboBox.setModel(new DefaultComboBoxModel(mbtiData));

        // sembunyikan button delete
        deleteButton.setVisible(false);

        // saat tombol add/update ditekan
        addUpdateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedIndex == -1) {
                  insertData();
                } else {
                  updateData();

                }
            }
        });

        // saat tombol delete ditekan
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedIndex >= 0) {
                    // menampilkan confirmation promt
                    int result = JOptionPane.showConfirmDialog(null, "Yakin hapus ga nih?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

                    // jika menekan tombol 'Yes' dalam confirmation promt
                    if (result == JOptionPane.YES_OPTION) {
                        // menghapus data
                        deleteData();
                    }
                }


            }
        });

        // saat tombol cancel ditekan
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearForm();
            }
        });

        //saat salah satu baris tabel ditekan
        mahasiswaTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // ubah selectedIndex menjadi baris tabel yang diklik
                selectedIndex = mahasiswaTable.getSelectedRow();

                // simpan value textfield dan combo box
                String selectedNim = mahasiswaTable.getModel().getValueAt(selectedIndex, 1). toString();
                String selectedNama = mahasiswaTable.getModel().getValueAt(selectedIndex, 2). toString();
                String selectedJenisKelamin = mahasiswaTable.getModel().getValueAt(selectedIndex, 3). toString();
                String selectedHobby = mahasiswaTable.getModel().getValueAt(selectedIndex, 4). toString();
                String selectedMBTI = mahasiswaTable.getModel().getValueAt(selectedIndex, 5). toString();

                // ubah isi textfield dan combo box
                nimField. setText(selectedNim);
                namaField.setText(selectedNama);
                jenisKelaminComboBox.setSelectedItem(selectedJenisKelamin);
                hobbyField.setText(selectedHobby);
                mbtiComboBox.setSelectedItem(selectedMBTI);

                // ubah button "Add" menjadi "Update"
                addUpdateButton.setText("Update");
                // tampilkan button delete
                deleteButton.setVisible(true);
            }
        });
    }

    public final DefaultTableModel setTable() {
        // tentukan kolom tabel
        Object[] column = {"No", "NIM", "Nama", "Jenis Kelamin", "Hobby", "MBTI"};

        // buat objek tabel dengan kolom yang sudah dibuat
        DefaultTableModel temp = new DefaultTableModel(null, column);

        try{
            ResultSet resultSet = database.selectQuery("SELECT * FROM mahasiswa");

            int i = 0;
            while(resultSet.next()){
                Object[] row = new Object[6];

                row[0] = i + 1;
                row[1] = resultSet.getString("nim");
                row[2] = resultSet.getString("nama");
                row[3] = resultSet.getString("jenis_kelamin");
                row[4] = resultSet.getString("hobby");
                row[5] = resultSet.getString("mbti");

                temp.addRow(row);
                i++;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return temp;
    }

    public void insertData() {
        // ambil value dari textfield dan combobox
        String nim = nimField.getText();
        String nama = namaField.getText();
        String jenisKelamin = jenisKelaminComboBox.getSelectedItem().toString();
        String hobby = hobbyField.getText();
        String mbti = mbtiComboBox.getSelectedItem().toString();

        // cek apakah ada input yang kosong
        if (nim.isEmpty() || nama.isEmpty() || jenisKelamin.isEmpty() || hobby.isEmpty() || mbti.isEmpty()) {
            // tampilkan prompt jika ada input yang kosong
            JOptionPane.showMessageDialog(null, "Maaf gagal INSERT data :( Pastikan semua kolomnya sudah terisi ya!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // cek apakah NIM sudah ada dalam database
        if (checkNIMDatabase(nim)) {
            // tampilkan dialog error jika NIM sudah ada
            JOptionPane.showMessageDialog(null, "Maaf NIM sudah ada di dalam database. Tolong masukan NIM yang baru!", "Error", JOptionPane.ERROR_MESSAGE);
            return; // hentikan proses insert
        }

        // tambahkan data ke dalam database
        String sql = "INSERT INTO mahasiswa VALUES (null, '" + nim + "', '" + nama + "', '" + jenisKelamin + "', '" + hobby + "', '" + mbti + "');";
        database.insertUpdateDeleteQuery(sql);

        // update tabel
        mahasiswaTable.setModel(setTable());

        // bersihkan form
        clearForm();

        // feedback
        System.out.println("Insert berhasil!");
        JOptionPane. showMessageDialog( null, "Data berhasil ditambahkan");
    }

    private boolean checkNIMDatabase(String nim) {
        // cek apakah NIM sudah ada dalam database
        String query = "SELECT COUNT(*) AS count FROM mahasiswa WHERE nim = '" + nim + "'";
        ResultSet resultSet = database.selectQuery(query);

        try {
            if (resultSet.next()) {
                int count = resultSet.getInt("count");
                return count > 0; // NIM sudah ada jika count lebih dari 0
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false; // NIM belum ada dalam database
    }

    public void updateData() {
        // ambil data dari form
        String nim = nimField. getText();
        String nama = namaField.getText();
        String jenisKelamin = jenisKelaminComboBox.getSelectedItem().toString();
        String hobby = hobbyField.getText();
        String mbti = mbtiComboBox.getSelectedItem().toString();

        // cek apakah ada input yang kosong
        if (nim.isEmpty() || nama.isEmpty() || jenisKelamin.isEmpty() || hobby.isEmpty() || mbti.isEmpty()) {
            // tampilkan prompt jika ada input yang kosong
            JOptionPane.showMessageDialog(null, "Maaf gagal UPDATE data :( Pastikan semua kolomnya sudah terisi ya!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // ubah data mahasiswa di database
        String sql = "UPDATE mahasiswa SET nama = '" + nama + "', jenis_kelamin = '" + jenisKelamin + "', hobby = '" + hobby + "', mbti = '" + mbti + "' WHERE nim = '" + nim + "'";
        database.insertUpdateDeleteQuery(sql);

        // update tabel
        mahasiswaTable.setModel(setTable());

        // bersihkan form
        clearForm();

        // feedback
        System.out.println("Update Berhasil!");
        JOptionPane. showMessageDialog(null, "Data berhasil diubah!");
    }

    public void deleteData() {
        // ambil NIM dari baris yang dipilih
        String deleteNIM = mahasiswaTable.getValueAt(selectedIndex, 1).toString();

        // hapus data dari database
        String sql = "DELETE FROM mahasiswa WHERE nim = '" + deleteNIM + "'";
        database.insertUpdateDeleteQuery(sql);

        // update tabel
        mahasiswaTable.setModel(setTable());

        // bersihkan form
        clearForm();

        // feedback
        System.out.println("Delete berhasil!");
        JOptionPane. showMessageDialog(null, "Data berhasil dihapus!");
    }

    public void clearForm() {
        // kosongkan semua texfield dan combo box
        nimField.setText("");
        namaField.setText("");
        jenisKelaminComboBox.setSelectedItem("");
        hobbyField.setText("");
        mbtiComboBox.setSelectedItem("");

        // ubah button "Update" menjadi "Add"
        addUpdateButton.setText("Add");
        // sembunyikan button delete
        deleteButton.setVisible(false);
        // ubah selectedIndex menjadi -1 (tidak ada baris yang dipilih)
        selectedIndex = -1;
    }

    private void populateList() {
        listMahasiswa.add(new Mahasiswa("2203999", "Amelia Zalfa Julianti", "Perempuan", "Memasak", "INTJ"));
        listMahasiswa.add(new Mahasiswa("2202292", "Muhammad Iqbal Fadhilah", "Laki-laki", "Berenang", "INTP"));
        listMahasiswa.add(new Mahasiswa("2202346", "Muhammad Rifky Afandi", "Laki-laki", "Ngoding", "ENTJ"));
        listMahasiswa.add(new Mahasiswa("2210239", "Muhammad Hanif Abdillah", "Laki-laki", "Bucin", "ENTP"));
        listMahasiswa.add(new Mahasiswa("2202046", "Nurainun", "Perempuan", "Jalan-Jalan", "INFJ"));
        listMahasiswa.add(new Mahasiswa("2205101", "Kelvin Julian Putra", "Laki-laki", "Ngoding", "INFP"));
        listMahasiswa.add(new Mahasiswa("2200163", "Rifanny Lysara Annastasya", "Perempuan", "Shopping", "ENFJ"));
        listMahasiswa.add(new Mahasiswa("2202869", "Revana Faliha Salma", "Perempuan", "Tidur", "ENFP"));
        listMahasiswa.add(new Mahasiswa("2209489", "Rakha Dhifiargo Hariadi", "Laki-laki", "Badminton", "ISTJ"));
        listMahasiswa.add(new Mahasiswa("2203142", "Roshan Syalwan Nurilham", "Laki-laki", "Makan", "ISFJ"));
        listMahasiswa.add(new Mahasiswa("2200311", "Raden Rahman Ismail", "Laki-laki", "Gym", "ESTJ"));
        listMahasiswa.add(new Mahasiswa("2200978", "Ratu Syahirah Khairunnisa", "Perempuan", "Nge-vlog", "ESFJ"));
        listMahasiswa.add(new Mahasiswa("2204509", "Muhammad Fahreza Fauzan", "Laki-laki", "Main Bola", "ISTP"));
        listMahasiswa.add(new Mahasiswa("2205027", "Muhammad Rizki Revandi", "Laki-laki", "Main Mobile Legend", "ISFP"));
        listMahasiswa.add(new Mahasiswa("2203484", "Arya Aydin Margono", "Laki-laki", "Berkebun", "ESTP"));
        listMahasiswa.add(new Mahasiswa("2200481", "Marvel Ravindra Dioputra", "Laki-laki", "Baca Buku", "ESFP"));
        listMahasiswa.add(new Mahasiswa("2209889", "Muhammad Fadlul Hafiizh", "Laki-laki", "Mandi", "ENTP"));
        listMahasiswa.add(new Mahasiswa("2206697", "Rifa Sania", "Perempuan", "Berdandan", "INFP"));
        listMahasiswa.add(new Mahasiswa("2207260", "Imam Chalish Rafidhul Haque", "Laki-laki", "Memancing", "ISTJ"));
        listMahasiswa.add(new Mahasiswa("2204343", "Meiva Labibah Putri", "Perempuan", "Live Streaming", "ISTP"));
    }
}
