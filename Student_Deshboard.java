import javax.swing.*;
import java.awt.*;

public class Student_Deshboard {
    Student_Deshboard(){
        JFrame homeFrame = new JFrame();
        JLabel label;
        JButton librarianB,exitB;
        JButton viewBook;
        // JTextField field;
        homeFrame.setLayout(null);
        homeFrame.setSize(600,700);

        label = new JLabel("Student DashBoard");
        label.setBounds(0,35,600,50);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("MONOSPACED",Font.BOLD,26));

        viewBook = new JButton("View Book");
        viewBook.setBounds(150,150,300,50);
        viewBook.setFont(new Font("MONOSPACED",Font.BOLD,20));
        viewBook.addActionListener(e -> {
            homeFrame.dispose();
            // new ViewBooks();
            new SviewBooks();
        });
         librarianB = new JButton("Search Book");
        librarianB.setBounds(150,210,300,50);
        librarianB.setFont(new Font("MONOSPACED",Font.BOLD,20));
        librarianB.addActionListener(e -> {
            homeFrame.dispose();
            // new addBooks();
            new search();
        });


        exitB = new JButton("Exit");
        exitB.setBounds(150,270,300,50);
        exitB.setFont(new Font("MONOSPACED",Font.BOLD,20));
        exitB.addActionListener(e -> {
            homeFrame.dispose();
            new Home();
        });

        homeFrame.add(exitB);
        homeFrame.add(viewBook);
        // homeFrame.add(newStudentB);
        homeFrame.add(librarianB);
        // homeFrame.add(studentB);
        homeFrame.add(label);
        
        // homeFrame.add(dButton);
        // homeFrame.add(rButton);
        homeFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new Student_Deshboard();
    }
    }

    
