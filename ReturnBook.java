import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
 import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.*;


public class ReturnBook {

     JTextField retunid;
  JTextField bnamee;
  JTextField sid;
  JTextField returndate;
  JTextField quantity;
  JFrame jFrame;
  private int currentStudentID;
  String root, root1,root2,root3;
  JTextField booksm;


  public ReturnBook() {
    jFrame = new JFrame();
    jFrame.setSize(1400, 700);
    jFrame.setLayout(null);
    JLabel jLabel = new JLabel("Return Book");
    jLabel.setBounds(0, 30, 500, 40);
    jLabel.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel.setFont(new Font("monospaced", Font.BOLD, 25));
    jFrame.add(jLabel);

    // jFrame.setSize(1000, 800);
    // JLabel jLabel1 = new JLabel("Return Id");
    // jLabel1.setBounds(40, 110, 200, 40);
    // jLabel1.setFont(new Font("monospaced", Font.BOLD, 20));
    // jFrame.add(jLabel1);

    // retunid = new JTextField();
    // retunid.setBounds(240, 110, 200, 30);
    // retunid.setFont(new Font("monospaced", Font.BOLD, 18));
    // jFrame.add(retunid);

    // jFrame.setSize(500, 600);
    JLabel jLabel2 = new JLabel("Book Name");
    jLabel2.setBounds(40, 150, 200, 40);
    jLabel2.setFont(new Font("monospaced", Font.BOLD, 20));
    jFrame.add(jLabel2);

    bnamee= new JTextField();
    bnamee.setBounds(240, 150, 200, 30);
    bnamee.setFont(new Font("monospaced", Font.BOLD, 18));
    jFrame.add(bnamee);

    // jFrame.setSize(500, 600);
    JLabel jLabel3 = new JLabel("Student Id");
    jLabel3.setBounds(40, 190, 200, 40);
    jLabel3.setFont(new Font("monospaced", Font.BOLD, 20));
    jFrame.add(jLabel3);

    sid = new JTextField();
    sid.setBounds(240, 190, 200, 30);
    sid.setFont(new Font("monospaced", Font.BOLD, 18));
    jFrame.add(sid);

    // jFrame.setSize(500, 600);
    JLabel jLabel4 = new JLabel("Quantity");
    jLabel4.setBounds(40, 270, 200, 40);
    jLabel4.setFont(new Font("monospaced", Font.BOLD, 20));
    jFrame.add(jLabel4);

    long m= System.currentTimeMillis();
    Date currentDate= new Date(m);
    returndate = new JTextField(""+currentDate);
    returndate.setBounds(240, 230, 200, 30);
    returndate.setFont(new Font("monospaced", Font.BOLD, 18));
    jFrame.add(returndate);

    // jFrame.setSize(500, 600);
    JLabel jLabel5 = new JLabel("Return Date");
    jLabel5.setBounds(40, 230, 200, 40);
    jLabel5.setFont(new Font("monospaced", Font.BOLD, 20));
    jFrame.add(jLabel5);

    quantity = new JTextField("");
    quantity.setBounds(240, 270, 200, 30);
    quantity.setFont(new Font("monospaced", Font.BOLD, 18));
    jFrame.add(quantity);

    JButton jButton = new JButton();
    jButton.setText("Return Book");
    jButton.setBounds(150, 350, 200, 30);
    jButton.setFont(new Font("monospaced", Font.BOLD, 18));
    jFrame.add(jButton);

    jButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

        // ReturnBookDatatable(); 
        returnbookm();
        try{
          // int quantitycalculate;
          String url = "jdbc:mysql://localhost/library_managment";
       String userName = "root";
       String pass = "7410";
       Class.forName("com.mysql.cj.jdbc.Driver");
       Connection connection = DriverManager.getConnection(url, userName, pass);
        PreparedStatement pr = connection.prepareStatement("update books_info set BQUANTITY = BQUANTITY + "+ Integer.parseInt( (String) quantity.getText())+" where bname = '"+bnamee.getText() + "' ;");
       pr.executeUpdate();
         }catch(Exception f){
         f.printStackTrace();
         }

          currentStudentID = Integer.parseInt(sid.getText());
      }
    });

    JButton viewissuedbokk = new JButton();
    viewissuedbokk.setText("View All Return Book");
    viewissuedbokk.setBounds(150, 390, 200, 30);
    viewissuedbokk.setFont(new Font("monospaced", Font.BOLD, 18));
    jFrame.add(viewissuedbokk);

    viewissuedbokk.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        
        viewReturnBook();
        
      }
    });

    JButton Back = new JButton();
    Back.setText("Back");
    Back.setBounds(150, 430, 200, 30);
    Back.setFont(new Font("monospaced", Font.BOLD, 18));
    jFrame.add(Back);
    Back.addActionListener(e -> {
      jFrame.dispose();
    //   new AdminDashboard();
    });


    JButton viewreturnbookPS = new JButton();
    viewreturnbookPS.setText("view Returnbook");
    viewreturnbookPS.setBounds(150, 470, 200, 30);
    viewreturnbookPS.setFont(new Font("monospaced", Font.BOLD, 18));
    jFrame.add(viewreturnbookPS);
    viewreturnbookPS.addActionListener(e -> {
      // jFrame.dispose();
      // new AdminDashboard();
      // returnbookm();
      

      // yha pr jo abhi method banayenge vo dalna he
      viewreturnbookPS();

      // currentStudentID = Integer.parseInt(sid.getText());

    });

      JButton searchisubook = new JButton();
    searchisubook.setText("Search issuebook");
    searchisubook.setBounds(150, 510, 210, 30);
    searchisubook.setFont(new Font("monospaced", Font.BOLD, 18));
    jFrame.add(searchisubook);

    searchisubook.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

       new searchissuedbook();
       root1 = sid.getText();
       root2 = bnamee.getText();
       root3 = quantity.getText();
      //  new showtablereturn(root);
        
      }
    });


    jFrame.setVisible(true);
  }



    

   public void returnbookm() {

    try {
      // int r_id = Integer.parseInt(retunid.getText());
      String b_name = bnamee.getText();
      int s_id = Integer.parseInt(sid.getText());
      int b_quantity = Integer.parseInt(quantity.getText());
      String return_Date = returndate.getText();
      // String piread = periud.getText();

      String url = "jdbc:mysql://localhost/library_managment";
      String userName = "root";
      String pass = "7410";
      Class.forName("com.mysql.cj.jdbc.Driver");

      Connection connection = DriverManager.getConnection(url, userName, pass);
      PreparedStatement pst = connection.prepareStatement(
          "insert into returned_books(bookname,student_id,quantity,return_date) VALUES(?,?,?,?)");
      // pst.setInt(1, r_id); 
      pst.setString(1, b_name);
      pst.setInt(2, s_id);
      pst.setInt(3, b_quantity);
      pst.setString(4, return_Date);
      // pst.setString(5, piread);
      pst.executeUpdate();
      JOptionPane.showMessageDialog(jFrame, "Book Return Succesfully : ");

      // System.out.println("data is Inserted ***** :: :: :: :");

    } catch (Exception e) {
      // System.out.println("Error in Connection : ");
      e.printStackTrace();
    }
  }

 public void viewReturnBook() {

    // improment krna he 
    JLabel isbook = new JLabel("Return Book Table");
    isbook.setBounds(800, 10, 300, 40);
    isbook.setFont(new Font("monospaced", Font.BOLD, 20));
    isbook.setVisible(true);
    jFrame.add(isbook);
    // Query for retrieving data from database
    String sql = "select * from returned_books";
    try {
      String url = "jdbc:mysql://localhost/library_managment";
      String userName = "root";
      String pass = "7410";
      Class.forName("com.mysql.cj.jdbc.Driver");

      Connection connection = DriverManager.getConnection(url, userName , pass);

      // Creating Statement
      Statement stmt = connection.createStatement();
      // Executing query
      ResultSet rs = stmt.executeQuery(sql);
      // Creating Table for to data will be in table format
      JTable book_list = new JTable();
      String[] bookColumnNames = { "Rid", "Book Name", "Sid", "quantity","return date" };
      // Creating model for the table
      DefaultTableModel bookModel = new DefaultTableModel();
      // Setting up the columns names of the model
      bookModel.setColumnIdentifiers(bookColumnNames);
      // Adding model to the table component
      book_list.setModel(bookModel);
      // Setting background colour of the table

      book_list.setBackground(Color.WHITE);
      book_list.setFont(new Font("MONOSPADE", Font.BOLD, 15));
      // Setting foreground colour of the table
      book_list.setForeground(Color.LIGHT_GRAY);
      // Setting up table auto-resizable
      book_list.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
      book_list.setFillsViewportHeight(true);
      book_list.setFocusable(false);
      // Creating scrollbars for table
      JScrollPane scrollBook = new JScrollPane(book_list);
      scrollBook.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
      scrollBook.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
      while (rs.next()) {
        // Fetching the data from mysql database
        int Rid = rs.getInt(1);
        String b_name = rs.getString(2);
        int s_id = rs.getInt(3);
        int b_qua = rs.getInt(4);
        String r_date = rs.getString(5);
      
        // String b_piriad = rs.getString(5);
        // Adding fetched data in model
        bookModel.addRow(new Object[] { Rid, b_name, s_id,b_qua, r_date });
      }
      scrollBook.setBounds(600, 400, 500, 250);
      // Adding scrollbars in the frame
      // issueDatatable.add(scrollBook);
      // Setting up the size of the frame (width,height)
      // / // issueDatatable.setSize(500,600);
      // issueDatatable.setBounds(600, 400, 500, 400);
      // Setting up frame visible for user
      // issueDatatable.setVisible(true);
      jFrame.add(scrollBook);


      // jFrame.add(scrollBook);

      // Show the JFrame containing the returned books table
      jFrame.setVisible(true);

      // Wait until the JFrame is closed by the user
      jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);



    } catch (Exception e1) {
      JOptionPane.showMessageDialog(null, e1);
    }
  }

  public void viewreturnbookPS(){

      String sql = "SELECT * FROM returned_books WHERE student_id = ?";
      try {
          String url = "jdbc:mysql://localhost/library_managment";
          String userName = "root";
          String pass = "7410";
          Class.forName("com.mysql.cj.jdbc.Driver");
          Connection connection = DriverManager.getConnection(url, userName, pass);
          PreparedStatement pst = connection.prepareStatement(sql);
          pst.setInt(1, currentStudentID);
          ResultSet rs = pst.executeQuery();
          // ... (the rest of the code to populate the JTable remains the same)
          
               // Creating Table for to data will be in table format
      JTable book_list = new JTable();
      String[] bookColumnNames = { "Rid", "Book Name", "Sid", "quantity","return date" };
      // Creating model for the table
      DefaultTableModel bookModel = new DefaultTableModel();
      // Setting up the columns names of the model
      bookModel.setColumnIdentifiers(bookColumnNames);
      // Adding model to the table component
      book_list.setModel(bookModel);
      // Setting background colour of the table

      book_list.setBackground(Color.WHITE);
      book_list.setFont(new Font("MONOSPADE", Font.BOLD, 15));
      // Setting foreground colour of the table
      book_list.setForeground(Color.LIGHT_GRAY);
      // Setting up table auto-resizable
      book_list.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
      book_list.setFillsViewportHeight(true);
      book_list.setFocusable(false);
      // Creating scrollbars for table
      JScrollPane scrollBook = new JScrollPane(book_list);
      scrollBook.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
      scrollBook.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
      while (rs.next()) {
        // Fetching the data from mysql database
        int Rid = rs.getInt(1);
        String b_name = rs.getString(2);
        int s_id = rs.getInt(3);
        int b_qua = rs.getInt(4);
        String r_date = rs.getString(5);
      
        // String b_piriad = rs.getString(5);
        // Adding fetched data in model
        bookModel.addRow(new Object[] { Rid, b_name, s_id,b_qua, r_date });
      }
      scrollBook.setBounds(600, 400, 500, 250);
      // Adding scrollbars in the frame
      // issueDatatable.add(scrollBook);
      // Setting up the size of the frame (width,height)
      // / // issueDatatable.setSize(500,600);
      // issueDatatable.setBounds(600, 400, 500, 400);
      // Setting up frame visible for user
      // issueDatatable.setVisible(true);
      jFrame.add(scrollBook);


    } catch (Exception e1) {
      JOptionPane.showMessageDialog(null, e1);
    }
  }
    public static void main(String[] args) {
        new ReturnBook();
    }
   
public class searchissuedbook extends JFrame {
    JButton Back;
  public static void main(String[] args) {
    // new searchissuedbook();
  
  }
    private JPanel contentPanee;
   
    private JTextField bookField;
    private JButton searchButton;
    public searchissuedbook(){
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
            String root= bookField.getText();
             new showtablereturn(root);
            
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
            // new showtablereturn
            // showtablereturn(root);
        
            // new Student_Deshboard();

            
        }            
    });
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

}
 class showtablereturn
 extends JFrame{
    private JPanel contentPanee;
     private javax.swing.JTable jt1;
      showtablereturn
      (String root) {
           JTable table = new JTable();
        table.setVisible(true);

       
        JLabel main1 = new JLabel("Issued Book");
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
        String[] column = { "SID", "BNAME","BQUANTITY"};
        jt1 = new javax.swing.JTable(obj.my_db_selected1(root), column);
        scrollPane.setViewportView(jt1);
           jt1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            int index=  jt1.getSelectedRow();
       sid.setText((String)jt1.getValueAt(index, 0));
             bnamee.setText((String)jt1.getValueAt(index, 1));
               quantity.setText((String)jt1.getValueAt(index, 2));
               System.out.println("================================");
            }

           });
    //     jt1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
    // public void valueChanged(ListSelectionEvent event) {
    //     if (!event.getValueIsAdjusting()) {
    //         int selectedRow = jt1.getSelectedRow();
    //         if (selectedRow >= 0) { 
    //             Object[] rowData = new Object[6];
    //             for (int col = 0; col < 6; col++) {
    //                 rowData[col] = jt1.getValueAt(selectedRow, col);
    //             }

    //             sid.setText(rowData[0] != null ? rowData[0].toString() : "");
    //             bnamee.setText(rowData[1] != null ? rowData[1].toString() : "");
    //             quantity.setText(rowData[3] != null ? rowData[3].toString() : "");
    //         }
    //     }
    // }
// });




        

        //  setSize(800, 300);
        setBounds(500, 10, 800, 300);
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
            PreparedStatement st = con.prepareStatement("select Student_id,Bname,BQUANTITY from issued_books where bname=?");
            st.setString(1, root);
            ResultSet rs = st.executeQuery();
           
            int i = 0;
            while (rs.next()) {
                for (int j = 0; j < 8; j++) {
                    data[i][j] = rs.getString(j + 1);
                }
                i = i + 1;
            }
            JOptionPane.showMessageDialog(contentPanee,"Book is not Issued");
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
}