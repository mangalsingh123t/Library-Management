import javax.swing.*;
import java.awt.*;

public class Home {
    Home() {
        JFrame homeFrame = new JFrame();
        JLabel label,logo;
        JButton librarianB,studentB,newStudentB,exitB;
        // JTextField field;
        homeFrame.setLayout(null);
        homeFrame.setSize(600,700);
        logo = new JLabel();
        logo.setBounds(10,10,100,100);

        // ImageIcon imageIcon1 = new ImageIcon("LibreryManagement/src/Images/Ssism.png");
        // Image image1 = imageIcon1.getImage();
        // Image myImg1 = image1.getScaledInstance(logo.getWidth(),logo.getHeight(),Image.SCALE_SMOOTH);
        // ImageIcon ssismLogo = new ImageIcon(myImg1);
        // logo.setIcon(ssismLogo);
        
        label = new JLabel("Welcome To Ssism Library");
        label.setBounds(140,35,400,50);
        label.setFont(new Font("MONOSPACED",Font.BOLD,26));

        librarianB = new JButton("Login As Admin");
        librarianB.setBounds(150,150,300,50);
        librarianB.setFont(new Font("MONOSPACED",Font.BOLD,20));
        librarianB.addActionListener(e -> {
            homeFrame.dispose();
            new AdminLogin().librarianLogin();
        });

        studentB = new JButton("Login As Student");
        studentB.setBounds(150,210,300,50);
        studentB.setFont(new Font("MONOSPACED",Font.BOLD,20));
        studentB.addActionListener(e -> {
            new StudentLogin().studentLogin();
            homeFrame.dispose();
        });

        newStudentB = new JButton("Register As Student");
        newStudentB.setBounds(150,270,300,50);
        newStudentB.setFont(new Font("MONOSPACED",Font.BOLD,20));
        newStudentB.addActionListener(e -> {
            homeFrame.dispose();
            new NewStudent().newStudent();
        });

        exitB = new JButton("Exit");
        exitB.setBounds(150,330,300,50);
        exitB.setFont(new Font("MONOSPACED",Font.BOLD,20));
        exitB.addActionListener(e -> {
            homeFrame.dispose();
            System.exit(0);
        });

        homeFrame.add(exitB);
        homeFrame.add(newStudentB);
        homeFrame.add(librarianB);
        homeFrame.add(studentB);
        homeFrame.add(label);
        homeFrame.add(logo);
        homeFrame.setVisible(true);
    }
    public static void main(String[] args) {
        new Home();
    }
}
