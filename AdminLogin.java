import javax.swing.*;
import java.awt.*;

public class AdminLogin {
    public void librarianLogin() {
        JFrame adminF = new JFrame();
        JLabel label,logo,userNameL,passwordL;
        JTextField userNameF,passwordF;
        JButton login,exit;
        adminF.setSize(600,500);
        adminF.setLayout(null);

        label = new JLabel("Admin Login");
        label.setBounds(180,35,400,50);
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        label.setFont(new Font("MONOSPACED",Font.BOLD,30));
        logo = new JLabel();
        logo.setBounds(10,10,100,100);
        ImageIcon imageIcon1 = new ImageIcon("LibreryManagement/src/Images/Librarian.png");
        Image image1 = imageIcon1.getImage();
        Image myImg1 = image1.getScaledInstance(logo.getWidth(),logo.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon ssismLogo = new ImageIcon(myImg1);
        logo.setIcon(ssismLogo);

        userNameL = new JLabel("UserName ");
        userNameL.setBounds(100,145,200,50);
        userNameL.setFont(new Font("MONOSPACED",Font.BOLD,25));

        userNameF = new JTextField();
        userNameF.setBounds(250,150,200,40);
        userNameF.setFont(new Font("MONOSPACED",Font.BOLD,25));

        passwordL = new JLabel("Password ");
        passwordL.setBounds(100,205,200,50);
        passwordL.setFont(new Font("MONOSPACED",Font.BOLD,25));

        passwordF = new JTextField();
        passwordF.setBounds(250,210,200,40);
        passwordF.setFont(new Font("MONOSPACED",Font.BOLD,25));

        login = new JButton("Login");
        login.setBounds(225,280,150,50);
        login.setFont(new Font("MONOSPACED",Font.BOLD,25));
        login.addActionListener(e -> {
            if(userNameF.getText().equals("Mangal") && userNameF.getText().equals("Mangal")){

                JOptionPane.showMessageDialog(adminF,"Admin loged in succesfully");
                new AdminDashboard();
                adminF.dispose();
                
            } else {
                JOptionPane.showMessageDialog(adminF, "Admin username or Password incorrect");
            }

            
        });

        exit = new JButton("Exit");
        exit.setBounds(225,340,150,50);
        exit.setFont(new Font("MONOSPACED",Font.BOLD,25));
        exit.addActionListener(e -> {
            adminF.dispose();
            new Home();
        });

        adminF.add(login);
        adminF.add(exit);
        adminF.add(userNameF);
        adminF.add(userNameL);
        adminF.add(passwordF);
        adminF.add(passwordL);
        adminF.add(logo);
        adminF.add(label);
        adminF.setVisible(true);
    }
    public static void main(String[] args) {
        new AdminLogin().librarianLogin();
    }
}
