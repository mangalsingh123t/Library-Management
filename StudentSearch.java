

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class StudentSearch extends JFrame {
    JButton Back;
  public static void main(String[] args) {
    new StudentSearch();
  }
    private JPanel contentpanne;
   
    private JTextField bookField;
    private JButton searchButton;
    public StudentSearch(){
        setBounds(700, 100, 500, 600);
        setLayout(null);
        contentpanne = new JPanel();
       
        contentpanne.setLayout(null);
        setContentPane(contentpanne);

        JLabel main = new JLabel("Search Student");
        main.setBounds(110, 20, 250, 30);
        main.setFont(new Font("MONOSPACED", Font.BOLD, 25));
        main.setForeground(Color.DARK_GRAY);
        contentpanne.add(main);

        JLabel bookLabel = new JLabel("Enter Student Name");
        bookLabel.setBounds(100, 90, 320, 30);
        bookLabel.setFont(new Font("MONOSPACED", Font.BOLD, 18));

        bookField = new JTextField(3);
        bookField.setFont(new Font("MONOSPACED", Font.BOLD, 18));
        bookField.setBounds(310, 90, 150, 30);
       contentpanne.add(bookLabel);
       contentpanne.add(bookField);

       searchButton = new JButton("Search");
       searchButton.setFont(new Font("MONOSPACED", Font.BOLD, 20));
       searchButton.setBounds(150, 150, 150, 40);
    //    searchButton.setBackground(Color.DARK_GRAY);
    //    searchButton.setForeground(Color.white);

       contentpanne.add(searchButton);
       searchButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String root = bookField.getText();
            new showtabledatta(root);
            
        }            
    });

      Back = new JButton("Back");
       Back.setFont(new Font("MONOSPACED", Font.BOLD, 20));
       Back.setBounds(150, 210, 150, 40);
       contentpanne.add(Back);
       Back.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // String root = bookField.getText();
            // new showtabledatta(root);
        
            // new Student_Deshboard();

            
        }            
    });
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

}
class showtabledatta extends JFrame{
    private JPanel contentPanne;
     private javax.swing.JTable jt1;
      showtabledatta(String root) {
           JTable table = new JTable();
        table.setVisible(true);

       
        JLabel main1 = new JLabel("Student Data");
        main1.setBounds(250, 30, 300, 50);
        main1.setFont(new Font("MONOSPACE", Font.BOLD, 26));
        contentPanne = new JPanel();
       
        setContentPane(contentPanne);
        contentPanne.setLayout(null);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBackground(Color.DARK_GRAY);
        scrollPane.setBounds(40, 100, 700, 100);
        contentPanne.add(scrollPane);
        librarym obj = new librarym();
        String[] column = { "STUDENTID", "STUDENTNAME", "PASSWORD", "SUBJECT", "ADDRESS", "MOBILE NO"};
        jt1 = new javax.swing.JTable(obj.my_db_selected1(root), column);
        scrollPane.setViewportView(jt1);

        // row me student id ko select krne ke liye
        //  jt1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
        //     public void valueChanged(ListSelectionEvent event) {
        //         if (!event.getValueIsAdjusting()) {
        //             int selectedRow = jt1.getSelectedRow();
        //             int selectedColumn = jt1.getSelectedColumn();
        //             Object selectedValue = jt1.getValueAt(selectedRow, selectedColumn);
        //             if (selectedValue != null) {
        //                 textField.setText(selectedValue.toString());
        //             }
        //         }
        //     }
        // });
        

        // textField = new JTextField();
        // textField.setBounds(40, 220, 200, 30);
        // contentPane.add(textField);






         setSize(800, 300);
        add(main1);
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        }
}
class librarym{

    private static final Component contentPanne = null;

    public String[][] my_db_selected1(String root) {
        String[][] data = new String[50][8]; // [rows][columns]
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_managment", "root", "7410");
            PreparedStatement st = con.prepareStatement("SELECT * FROM student where name=?");
            st.setString(1, root);
            ResultSet rs = st.executeQuery();
           
            int i = 0;
            while (rs.next()) {
                for (int j = 0; j < 9; j++) {
                    data[i][j] = rs.getString(j + 1);
                }
                i = i + 1;
            }
            JOptionPane.showMessageDialog(contentPanne,"Student is not found");
            con.close();
        } catch (Exception e) {
            // System.out.println(e);
            e.printStackTrace();
        }
        return data;
    }

    public Object[][] library(String root) {
        return null;
    }
}


