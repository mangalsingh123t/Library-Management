import javax.swing.*;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentLogin {
    public void studentLogin() {
        JFrame studentLogin = new JFrame();
        JLabel label, logo, userNameL, passwordL;
        JTextField userNameF, passwordF;
        JButton login, exit;
        studentLogin.setSize(600, 500);
        studentLogin.setLayout(null);

        label = new JLabel("Student Login");
        label.setBounds(180, 35, 400, 50);
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        label.setFont(new Font("MONOSPACED", Font.BOLD, 30));
        logo = new JLabel();
        logo.setBounds(10, 10, 100, 100);
        // ImageIcon imageIcon1 = new ImageIcon("LibreryManagement/src/Images/Librarian.png");
        // Image image1 = imageIcon1.getImage();
        // Image myImg1 = image1.getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH);
        // ImageIcon ssismLogo = new ImageIcon(myImg1);
        // logo.setIcon(ssismLogo);

        userNameL = new JLabel("UserName ");
        userNameL.setBounds(100, 145, 200, 50);
        userNameL.setFont(new Font("MONOSPACED", Font.BOLD, 25));

        userNameF = new JTextField();
        userNameF.setBounds(250, 150, 200, 40);
        userNameF.setFont(new Font("MONOSPACED", Font.BOLD, 25));

        passwordL = new JLabel("Password ");
        passwordL.setBounds(100, 205, 200, 50);
        passwordL.setFont(new Font("MONOSPACED", Font.BOLD, 25));

        passwordF = new JTextField();
        passwordF.setBounds(250, 210, 200, 40);
        passwordF.setFont(new Font("MONOSPACED", Font.BOLD, 25));

        login = new JButton("Login");
        login.setBounds(225, 280, 150, 50);
        login.setFont(new Font("MONOSPACED", Font.BOLD, 25));
        login.addActionListener(e -> {

            String name = userNameF.getText();
            String pass = passwordF.getText();

            try {
                JDBC jdbc = new JDBC();
                jdbc.setConnection();
                PreparedStatement pst = jdbc.connection.prepareStatement("select name,password from student;");
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    if (rs.getString(1).equals(name) && rs.getString(2).equals(pass)) {
                        // System.out.println("Succesfully loged in ");
                        JOptionPane.showMessageDialog(studentLogin,"Student login succesfully");
                        new Student_Deshboard();
                        studentLogin.dispose();
                        return;
                    }
                }
                 JOptionPane.showMessageDialog(studentLogin, "Student not found Register First");

            } catch (Exception e1) {
                e1.printStackTrace();

            }

        });

        exit = new JButton("Exit");
        exit.setBounds(225, 340, 150, 50);
        exit.setFont(new Font("MONOSPACED", Font.BOLD, 25));
        exit.addActionListener(e -> {
            studentLogin.dispose();
            new Home();
        });

        studentLogin.add(login);
        studentLogin.add(exit);
        studentLogin.add(userNameF);
        studentLogin.add(userNameL);
        studentLogin.add(passwordF);
        studentLogin.add(passwordL);
        studentLogin.add(logo);
        studentLogin.add(label);
        studentLogin.setVisible(true);
    }

    public static void main(String[] args) {
        new StudentLogin().studentLogin();
    }
}
