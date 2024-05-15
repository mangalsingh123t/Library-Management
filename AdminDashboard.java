import javax.swing.*;
import java.awt.*;

public class AdminDashboard {
    AdminDashboard() {
        JFrame homeFrame = new JFrame();
        JLabel label;
        JButton librarianB,studentB,newStudentB,rButton,exitB;
        // JTextField field;
        homeFrame.setLayout(null);
        homeFrame.setSize(600,670);

        label = new JLabel("Manage Books");
        label.setBounds(0,35,600,50);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("MONOSPACED",Font.BOLD,26));

        librarianB = new JButton("Add Book");
        librarianB.setBounds(150,150,300,50);
        librarianB.setFont(new Font("MONOSPACED",Font.BOLD,20));
        librarianB.addActionListener(e -> {
            homeFrame.dispose();
            new addBooks();
        });

        studentB = new JButton("Issue Book");
        studentB.setBounds(150,210,300,50);
        studentB.setFont(new Font("MONOSPACED",Font.BOLD,20));
        studentB.addActionListener(e -> {
            homeFrame.dispose();
            //  new IssueBook(); 
            //  new IssueBook().IssueBookdatatable();
            new IssueBook();
        });

        newStudentB = new JButton("View Books");
        newStudentB.setBounds(150,270,300,50);
        newStudentB.setFont(new Font("MONOSPACED",Font.BOLD,20));
        newStudentB.addActionListener(e -> {
            homeFrame.dispose();
            new ViewBooks();
        });

        //   dButton = new JButton("Delete Book");
        // dButton.setBounds(150,330,300,50);
        // dButton.setFont(new Font("MONOSPACED",Font.BOLD,20));
        // dButton.addActionListener(e -> {
        //     homeFrame.dispose();
        //     //  new NewStudent().newStudent();
        // });

            rButton = new JButton("Return Book");
        rButton.setBounds(150,330,300,50);
        rButton.setFont(new Font("MONOSPACED",Font.BOLD,20));
        rButton.addActionListener(e -> {
            homeFrame.dispose();
            //  new NewStudent().newStudent();
            // new ReturnBook().ReturnBookDatatable();
            new ReturnBook();
            
        });


        exitB = new JButton("Exit");
        exitB.setBounds(150,390,300,50);
        exitB.setFont(new Font("MONOSPACED",Font.BOLD,20));
        exitB.addActionListener(e -> {
            homeFrame.dispose();
            new Home();
        });

        homeFrame.add(exitB);
        homeFrame.add(newStudentB);
        homeFrame.add(librarianB);
        homeFrame.add(studentB);
        homeFrame.add(label);
        // homeFrame.add(dButton);
        homeFrame.add(rButton);
        homeFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new AdminDashboard();
    }
}
