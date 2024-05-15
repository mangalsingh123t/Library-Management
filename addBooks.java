
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
// import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
// import java.text.SimpleDateFormat;

import javax.swing.*;
// import java.awt.*;

public class addBooks {

    JTextField bookname;
    JTextField author;
    JTextField quantity;
    JTextField publisher;
    JTextField publication_year;
    JFrame jFrame;

    public addBooks() {
         jFrame = new JFrame();
        jFrame.setSize(500, 600);
        jFrame.setLayout(null);

        JLabel jLabel = new JLabel("Add Books");
        jLabel.setBounds(0, 30, 500, 40);
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel.setFont(new Font("monospaced", Font.BOLD, 25));
        jFrame.add(jLabel);

        jFrame.setSize(500, 600);
        JLabel jLabel1 = new JLabel("Book Name");
        jLabel1.setBounds(30, 110, 200, 40);
        jLabel1.setFont(new Font("monospaced", Font.BOLD, 20));
        jFrame.add(jLabel1);

        bookname = new JTextField();
        bookname.setBounds(240, 110, 200, 30);
        bookname.setFont(new Font("monospaced", Font.BOLD, 18));
        jFrame.add(bookname);

        jFrame.setSize(500, 600);
        JLabel jLabel2 = new JLabel("Author");
        jLabel2.setBounds(30, 150, 200, 40);
        jLabel2.setFont(new Font("monospaced", Font.BOLD, 20));
        jFrame.add(jLabel2);

        author = new JTextField();
        author.setBounds(240, 150, 200, 30);
        author.setFont(new Font("monospaced", Font.BOLD, 18));
        jFrame.add(author);

        jFrame.setSize(500, 600);
        JLabel jLabel3 = new JLabel("Quantity");
        jLabel3.setBounds(30, 190, 200, 40);
        jLabel3.setFont(new Font("monospaced", Font.BOLD, 20));
        jFrame.add(jLabel3);

        quantity = new JTextField();
        quantity.setBounds(240, 190, 200, 30);
        quantity.setFont(new Font("monospaced", Font.BOLD, 18));
        jFrame.add(quantity);

        jFrame.setSize(500, 600);
        JLabel jLabel4 = new JLabel("Publisher");
        jLabel4.setBounds(30, 230, 200, 40);
        jLabel4.setFont(new Font("monospaced", Font.BOLD, 20));
        jFrame.add(jLabel4);

        publisher = new JTextField();
        publisher.setBounds(240, 230, 200, 30);
        publisher.setFont(new Font("monospaced", Font.BOLD, 18));
        jFrame.add(publisher);

        jFrame.setSize(500, 600);
        JLabel jLabel5 = new JLabel("Publication Year");
        jLabel5.setBounds(30, 270, 200, 40);
        jLabel5.setFont(new Font("monospaced", Font.BOLD, 20));
        jFrame.add(jLabel5);

        publication_year = new JTextField();
        publication_year.setBounds(240, 270, 200, 30);
        publication_year.setFont(new Font("monospaced", Font.BOLD, 18));
        jFrame.add(publication_year);

        JButton jButton = new JButton();
        jButton.setText("Add Book");
        jButton.setBounds(150, 350, 200, 30);
        jButton.setFont(new Font("monospaced", Font.BOLD, 18));
        jFrame.add(jButton);

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the method to handle the button click
                // onButtonClick();
                addbook();

            }
        });

        JButton jButton2 = new JButton();
        jButton2.setText("Back");
        jButton2.setBounds(150, 390, 200, 30);
        jButton2.setFont(new Font("monospaced", Font.BOLD, 18));
        jFrame.add(jButton2);
            jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the method to handle the button click
                // onButtonClick();
            jFrame.dispose();
            new AdminDashboard();

            }
        });






        jFrame.setVisible(true);

    }

public void addbook() {
    try {
        String bname = bookname.getText();
        String bauthor = author.getText();
        int bquantity = Integer.parseInt(quantity.getText());
        String bpublisher = publisher.getText();
        String bpublication_year = publication_year.getText();

        String url = "jdbc:mysql://localhost/library_managment";
        String userName = "root";
        String pass = "7410";
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection(url, userName, pass);

        // Check if the book already exists in the database
        PreparedStatement checkStmt = connection.prepareStatement(
            "SELECT * FROM books_info WHERE BNAME = ?");
        checkStmt.setString(1, bname);
        ResultSet resultSet = checkStmt.executeQuery();

        if (resultSet.next()) {
            // Book already exists, update its data
            PreparedStatement updateStmt = connection.prepareStatement(
                "UPDATE books_info SET AUTHOR = ?, BQUANTITY = ?, PUBLISHER = ?, PUBLICATION_YEAR = ? WHERE BNAME = ?");
            updateStmt.setString(1, bauthor);
            updateStmt.setInt(2, bquantity);
            updateStmt.setString(3, bpublisher);
            updateStmt.setString(4, bpublication_year);
            updateStmt.setString(5, bname);
            updateStmt.executeUpdate();
            JOptionPane.showMessageDialog(jFrame, "Book data updated successfully");
        } else {
            // Book does not exist, insert as a new book
            PreparedStatement insertStmt = connection.prepareStatement(
                "INSERT INTO books_info (BNAME, AUTHOR, BQUANTITY, PUBLISHER, PUBLICATION_YEAR) VALUES (?, ?, ?, ?, ?)");
            insertStmt.setString(1, bname);
            insertStmt.setString(2, bauthor);
            insertStmt.setInt(3, bquantity);
            insertStmt.setString(4, bpublisher);
            insertStmt.setString(5, bpublication_year);
            insertStmt.executeUpdate();
            JOptionPane.showMessageDialog(jFrame, "Book is successfully added");
        }

        // Close resources
        resultSet.close();
        checkStmt.close();
        connection.close();
    } catch (Exception e) {
        System.out.println(e);
    }
} 

 public static void main(String[] args) {
        new addBooks();
    }
}



//     public void addbook() {

//         try {
//             String bname = bookname.getText();
//             String bauthor = author.getText();

//             int bquantity = Integer.parseInt(quantity.getText());

//             String bpublisher = publisher.getText();
//            String  bpublication_year   =  publication_year.getText();

//             // int bpublication_year =dateFormat.parse(publication_year.getText());

//             String url = "jdbc:mysql://localhost/library_managment";
//             String userName = "root";
//             String pass = "7410";
//             Class.forName("com.mysql.cj.jdbc.Driver");

//             Connection connection = DriverManager.getConnection(url, userName, pass);
//             PreparedStatement pst = connection.prepareStatement(
//                     "insert into books_info(BNAME,AUTHOR,BQUANTITY,PUBLISHER,PUBLICATION_YEAR) VALUES(?,?,?,?,?)");
//             pst.setString(1, bname);
//             pst.setString(2, bauthor);
//             pst.setInt(3, bquantity);
//             pst.setString(4, bpublisher);
//             pst.setString(5, bpublication_year);
//             pst.executeUpdate();
//             JOptionPane.showMessageDialog(jFrame, "Book is succesfully add");
            
//             // System.out.println("data is Inserted ***** :: :: :: :");

//         } catch (Exception e) {
//             // System.out.println("Error in Connection : ");
//             System.out.println(e);
//         }
//     }

//     public static void main(String[] args) {
//         new addBooks();
//     }
// }