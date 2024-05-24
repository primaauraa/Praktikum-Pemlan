import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormPendaftaran {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RegistrationForm();
            }
        });
    }
}

class RegistrationForm extends JFrame {
    private JTextField nama, tanggalLahir, nomorDaftar, nomorHp, alamat, email;
    private JComboBox<String> jalurDaftarComboBox;

    public RegistrationForm() {
        setTitle("Form Pendaftaran Mahasiswa Baru Universitas Brawijaya 2024");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 2));

        panel.add(new JLabel("      Nama "));
        nama = new JTextField();
        panel.add(nama);

        panel.add(new JLabel("      Tempat, Tanggal Lahir "));
        tanggalLahir = new JTextField();
        panel.add(tanggalLahir);

        panel.add(new JLabel("      Nomor Pendaftaran "));
        nomorDaftar = new JTextField();
        panel.add(nomorDaftar);

        panel.add(new JLabel("      Jalur Pendaftaran "));
        String[] jalurDaftar = {"SNBP", "SNBT", "MANDIRI UTBK 1", "MANDIRI RAPOR 1", "MANDIRI UTBK 2", "MANDIRI RAPOR 2"};
        jalurDaftarComboBox = new JComboBox<>(jalurDaftar);
        panel.add(jalurDaftarComboBox);  

        panel.add(new JLabel("      Nomor Telepon "));
        nomorHp = new JTextField();
        panel.add(nomorHp);

        panel.add(new JLabel("      Alamat "));
        alamat = new JTextField();
        panel.add(alamat);

        panel.add(new JLabel("      Email "));
        email = new JTextField();
        panel.add(email);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSubmit();
            }
        });

        panel.add(submitButton);

        add(panel);
        setVisible(true);
    }

    private void handleSubmit() {
        String namaMhs = nama.getText();
        String tanggalLahirMhs = tanggalLahir.getText();
        String nomorDaftarMhs = nomorDaftar.getText();
        String jalurDaftarMHS = (String) jalurDaftarComboBox.getSelectedItem();
        String nomorHpMhs = nomorHp.getText();
        String alamatMhs = alamat.getText();
        String emailMhs = email.getText();

        if (namaMhs.isEmpty() || tanggalLahirMhs.isEmpty() || nomorDaftarMhs.isEmpty() || jalurDaftarMHS.isEmpty() || nomorHpMhs.isEmpty() || alamatMhs.isEmpty() || emailMhs.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Data Harus Lengkap!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        } else {
            int response = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin data yang Anda isi sudah benar?", "Konfirmasi", JOptionPane.OK_CANCEL_OPTION);
            if (response == JOptionPane.OK_OPTION) {
                showConfirmationDialog(namaMhs, tanggalLahirMhs, nomorDaftarMhs, jalurDaftarMHS, nomorHpMhs, alamatMhs, emailMhs);
            }
        }
    }

    private void showConfirmationDialog(String namaMhs, String tanggalLahirMhs, String nomorDaftarMhs, String jalurDaftarMhs, String nomorHpMhs, String alamatMhs, String emailMhs) {
        JFrame confirmationFrame = new JFrame("Data Mahasiswa Baru Universitas Brawijaya 2024");
        confirmationFrame.setSize(450, 300); 

        JPanel confirmationPanel = new JPanel();
        confirmationPanel.setLayout(new GridLayout(8, 1));

        confirmationPanel.add(new JLabel("      Nama : " + namaMhs));
        confirmationPanel.add(new JLabel("      Tempat, Tanggal Lahir : " + tanggalLahirMhs));
        confirmationPanel.add(new JLabel("      Nomor Pendaftaran : " + nomorDaftarMhs));
        confirmationPanel.add(new JLabel("      Jalur Pendaftaran : " + jalurDaftarMhs));
        confirmationPanel.add(new JLabel("      Nomor Telepon : " + nomorHpMhs));
        confirmationPanel.add(new JLabel("      Alamat : " + alamatMhs));
        confirmationPanel.add(new JLabel("      Email : " + emailMhs));

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmationFrame.dispose();
            }
        });

        confirmationPanel.add(closeButton);

        confirmationFrame.add(confirmationPanel);
        confirmationFrame.setVisible(true);
    }
}