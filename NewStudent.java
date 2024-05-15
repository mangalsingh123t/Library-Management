import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class NewStudent {

     PreparedStatement pst;

     public void newStudent() {
          JFrame newStudent = new JFrame();
          JLabel label, logo, name, mobileNo, subject, address, password;
          JTextField nameF, mobileNoF, subjectF, addressF, passwordF;
          JButton register, exit;
          newStudent.setSize(600, 650);
          newStudent.setLayout(null);

          label = new JLabel("Student Registration");
          label.setBounds(150, 35, 400, 50);
          label.setHorizontalTextPosition(SwingConstants.CENTER);
          label.setFont(new Font("MONOSPACED", Font.BOLD, 30));
          logo = new JLabel();
          logo.setBounds(10, 10, 100, 100);
          ImageIcon imageIcon1 = new ImageIcon("LibreryManagement/src/Images/NewStudent.png");
          Image image1 = imageIcon1.getImage();
          Image myImg1 = image1.getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH);
          ImageIcon ssismLogo = new ImageIcon(myImg1);
          logo.setIcon(ssismLogo);

          name = new JLabel("Enter Your Name");
          name.setBounds(10, 160, 270, 40);
          name.setFont(new Font("MONOSPACED", Font.BOLD, 23));
          nameF = new JTextField();
          nameF.setBounds(320, 160, 250, 40);
          nameF.setFont(new Font("MONOSPACED", Font.BOLD, 22));

          subject = new JLabel("Enter Your Subject");
          subject.setBounds(10, 210, 270, 40);
          subject.setFont(new Font("MONOSPACED", Font.BOLD, 23));
          subjectF = new JTextField();
          subjectF.setBounds(320, 210, 250, 40);
          subjectF.setFont(new Font("MONOSPACED", Font.BOLD, 22));

          address = new JLabel("Enter Your Address");
          address.setBounds(10, 260, 270, 40);
          address.setFont(new Font("MONOSPACED", Font.BOLD, 23));
          addressF = new JTextField();
          addressF.setBounds(320, 260, 250, 40);
          addressF.setFont(new Font("MONOSPACED", Font.BOLD, 22));

          mobileNo = new JLabel("Enter Your MobileNo");
          mobileNo.setBounds(10, 310, 270, 40);
          mobileNo.setFont(new Font("MONOSPACED", Font.BOLD, 23));
          mobileNoF = new JTextField();
          mobileNoF.setBounds(320, 310, 250, 40);
          mobileNoF.setFont(new Font("MONOSPACED", Font.BOLD, 22));

          password = new JLabel("Create Password ");
          password.setBounds(10, 360, 270, 40);
          password.setFont(new Font("MONOSPACED", Font.BOLD, 23));
          passwordF = new JTextField();
          passwordF.setBounds(320, 360, 250, 40);
          passwordF.setFont(new Font("MONOSPACED", Font.BOLD, 22));

          register = new JButton("Register");
          register.setBounds(210, 440, 180, 50);
          register.setFont(new Font("MONOSPACED", Font.BOLD, 25));
          register.addActionListener(e -> {
               Student student = new Student();
               student.setName(nameF.getText());
               student.setName(nameF.getText());
               student.setSubject(subjectF.getText());
               student.setAddress(addressF.getText());
               long m = Long.parseLong(mobileNoF.getText());
               student.setMobileNo(m);
               student.setPassword(passwordF.getText());

               JDBC jdbc = new JDBC();
               try {
                    jdbc.setConnection();
                    // Data Insertion
                    pst = jdbc.connection.prepareStatement(
                              "insert into student(name,password,subject,Address,mobileno) values(?,?,?,?,?)");
                    pst.setString(1, student.getName());
                    pst.setString(2, student.getPassword());
                    pst.setString(3, student.getSubject());
                    pst.setString(4, student.getAddress());
                    pst.setLong(5, student.getMobileNo());
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(newStudent,"Student Rigisterd Succesfully");

               } catch (Exception ex) {
                    ex.printStackTrace();
               }

          });

          exit = new JButton("Exit");
          exit.setBounds(210, 500, 180, 50);
          exit.setFont(new Font("MONOSPACED", Font.BOLD, 25));
          exit.addActionListener(e -> {
               newStudent.dispose();
               new Home();
          });
          newStudent.add(password);
          newStudent.add(passwordF);
          newStudent.add(exit);
          newStudent.add(register);
          newStudent.add(mobileNo);
          newStudent.add(mobileNoF);
          newStudent.add(subject);
          newStudent.add(subjectF);
          newStudent.add(address);
          newStudent.add(addressF);
          newStudent.add(name);
          newStudent.add(nameF);
          newStudent.add(logo);
          newStudent.add(label);
          newStudent.setVisible(true);
     }

     public static void main(String[] args) {
          new NewStudent().newStudent();
     }
}
