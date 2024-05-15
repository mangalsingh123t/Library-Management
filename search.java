import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class search extends JFrame {
    JButton Back;
  public static void main(String[] args) {
    new search();
  
  }
    private JPanel contentPanee;
   
    private JTextField bookField;
    private JButton searchButton;
    public search(){
        setBounds(700, 100, 500, 600);
        setLayout(null);
        contentPanee = new JPanel();
       
        contentPanee.setLayout(null);
        setContentPane(contentPanee);

        JLabel main = new JLabel("Search Book");
        main.setBounds(110, 20, 250, 30);
        main.setFont(new Font("MONOSPACED", Font.BOLD, 25));
        main.setForeground(Color.DARK_GRAY);
        contentPanee.add(main);

        JLabel bookLabel = new JLabel("Enter Book Name");
        bookLabel.setBounds(100, 90, 320, 30);
        bookLabel.setFont(new Font("MONOSPACED", Font.BOLD, 18));

        bookField = new JTextField(3);
        bookField.setFont(new Font("MONOSPACED", Font.BOLD, 18));
        bookField.setBounds(280, 90, 150, 30);
       contentPanee.add(bookLabel);
       contentPanee.add(bookField);

       searchButton = new JButton("Search");
       searchButton.setFont(new Font("MONOSPACED", Font.BOLD, 20));
       searchButton.setBounds(150, 150, 150, 40);
    //    searchButton.setBackground(Color.DARK_GRAY);
    //    searchButton.setForeground(Color.white);

       contentPanee.add(searchButton);
       searchButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String root = bookField.getText();
            new showtable(root);
            
        }            
    });

      Back = new JButton("Back");
       Back.setFont(new Font("MONOSPACED", Font.BOLD, 20));
       Back.setBounds(150, 210, 150, 40);
       contentPanee.add(Back);
       Back.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // String root = bookField.getText();
            // new showtable(root);
        
            new Student_Deshboard();

            
        }            
    });
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

}
class showtable extends JFrame{
    private JPanel contentPanee;
     private javax.swing.JTable jt1;
      showtable(String root) {
           JTable table = new JTable();
        table.setVisible(true);

       
        JLabel main1 = new JLabel("Search Book");
        main1.setBounds(250, 30, 300, 50);
        main1.setFont(new Font("MONOSPACE", Font.BOLD, 26));
        contentPanee = new JPanel();
       
        setContentPane(contentPanee);
        contentPanee.setLayout(null);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBackground(Color.DARK_GRAY);
        scrollPane.setBounds(40, 100, 700, 100);
        contentPanee.add(scrollPane);
        libraryii obj = new libraryii();
        String[] column = { "BID", "BNAME", "AUTHOR", "BQUANTITY", "PUBLISHER", "PUBLICATION_YEAR"};
        jt1 = new javax.swing.JTable(obj.my_db_selected1(root), column);
        scrollPane.setViewportView(jt1);

         setSize(800, 300);
        add(main1);
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        }
}
class libraryii{

    private static final Component contentPanee = null;

    public String[][] my_db_selected1(String root) {
        String[][] data = new String[50][8]; // [rows][columns]
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_managment", "root", "7410");
            PreparedStatement st = con.prepareStatement("SELECT * FROM books_info where bname=?");
            st.setString(1, root);
            ResultSet rs = st.executeQuery();
           
            int i = 0;
            while (rs.next()) {
                for (int j = 0; j < 8; j++) {
                    data[i][j] = rs.getString(j + 1);
                }
                i = i + 1;
            }
            JOptionPane.showMessageDialog(contentPanee,"Book is not Available");
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return data;
    }

    public Object[][] libraryii(String root) {
        return null;
    }
}


