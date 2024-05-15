import javax.swing.*;
import javax.swing.table.DefaultTableModel;

// import org.w3c.dom.events.MouseEvent;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.sql.*;
import java.awt.Component;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class IssueBook {
  // JTextField issueid;
  JTextField Student_id;
  JTextField BookName;
  JTextField BQUANTITYi;
  JTextField issuedate;
  JTextField studentfm;
  // JTextField periud;
  JFrame jFrame;
  JTextField Bookfm;

  public IssueBook() {
    jFrame = new JFrame();
    jFrame.setSize(1400, 700);
    jFrame.setLayout(null);
    JLabel jLabel = new JLabel("Issue Book");
    jLabel.setBounds(0, 30, 500, 40);
    jLabel.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel.setFont(new Font("monospaced", Font.BOLD, 25));
    jFrame.add(jLabel);

    // jFrame.setSize(1000, 800);
    // JLabel jLabel1 = new JLabel("Issue Id");
    // jLabel1.setBounds(40, 110, 200, 40);
    // jLabel1.setFont(new Font("monospaced", Font.BOLD, 20));
    // jFrame.add(jLabel1);

    // issueid = new JTextField();
    // issueid.setBounds(240, 110, 200, 30);
    // issueid.setFont(new Font("monospaced", Font.BOLD, 18));
    // jFrame.add(issueid);

    // jFrame.setSize(500, 600);
    JLabel jLabel2 = new JLabel("Student Id");
    jLabel2.setBounds(40, 150, 200, 40);
    jLabel2.setFont(new Font("monospaced", Font.BOLD, 20));
    jFrame.add(jLabel2);

    Student_id = new JTextField();
    Student_id.setBounds(240, 150, 200, 30);
    Student_id.setFont(new Font("monospaced", Font.BOLD, 18));
    jFrame.add(Student_id);

    // jFrame.setSize(500, 600);
    JLabel jLabel3 = new JLabel("Book Name");
    jLabel3.setBounds(40, 190, 200, 40);
    jLabel3.setFont(new Font("monospaced", Font.BOLD, 20));
    jFrame.add(jLabel3);

    BookName = new JTextField();
    BookName.setBounds(240, 190, 200, 30);
    BookName.setFont(new Font("monospaced", Font.BOLD, 18));
    jFrame.add(BookName);

    JLabel jbq = new JLabel("Book Qunatity");
    jbq.setBounds(40, 230, 200, 40);
    jbq.setFont(new Font("monospaced", Font.BOLD, 20));
    jFrame.add(jbq);

    BQUANTITYi = new JTextField();
    BQUANTITYi.setBounds(240, 230, 200, 30);
    BQUANTITYi.setFont(new Font("monospaced", Font.BOLD, 18));
    jFrame.add(BQUANTITYi);

    // jFrame.setSize(500, 600);
    JLabel jLabel4 = new JLabel("Issued Date");
    jLabel4.setBounds(40, 270, 200, 40);
    jLabel4.setFont(new Font("monospaced", Font.BOLD, 20));
    jFrame.add(jLabel4);

    issuedate = new JTextField();
    issuedate.setBounds(240, 270, 200, 30);
    issuedate.setFont(new Font("monospaced", Font.BOLD, 18));
    jFrame.add(issuedate);

    // jFrame.setSize(500, 600);
    // JLabel jLabel5 = new JLabel("Period");
    // jLabel5.setBounds(40, 310, 200, 40);
    // jLabel5.setFont(new Font("monospaced", Font.BOLD, 20));
    // jFrame.add(jLabel5);

    // periud = new JTextField();
    // periud.setBounds(240, 310, 200, 30);
    // periud.setFont(new Font("monospaced", Font.BOLD, 18));
    // jFrame.add(periud);

    JButton jButton = new JButton();
    jButton.setText("Issue Book");
    jButton.setBounds(150, 350, 200, 30);
    jButton.setFont(new Font("monospaced", Font.BOLD, 18));
    jFrame.add(jButton);

    jButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // Call the method to handle the button click
        // onButtonClick();
        // System.out.print("Print");
        issueBook();
        try {
          String url = "jdbc:mysql://localhost/library_managment";
          String userName = "root";
          String pass = "7410";
          Class.forName("com.mysql.cj.jdbc.Driver");
          Connection connection = DriverManager.getConnection(url, userName, pass);
          PreparedStatement pr = connection.prepareStatement("update books_info set BQUANTITY = BQUANTITY - "
              + Integer.parseInt((String) BQUANTITYi.getText()) + " where bname = '" + BookName.getText() + "' ;");
          pr.executeUpdate();
        } catch (Exception f) {
          f.printStackTrace();
        }

        // new ViewBooks();
        // IssueBookdatatable();

      }
    });

    JButton viewissuedbokk = new JButton();
    viewissuedbokk.setText("View IssuedBook");
    viewissuedbokk.setBounds(150, 390, 200, 30);
    viewissuedbokk.setFont(new Font("monospaced", Font.BOLD, 18));
    jFrame.add(viewissuedbokk);

    viewissuedbokk.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        viewIssedBookm();
      }
    });

    JButton Back = new JButton();
    Back.setText("Back");
    Back.setBounds(150, 510, 200, 30);
    Back.setFont(new Font("monospaced", Font.BOLD, 18));
    jFrame.add(Back);
    Back.addActionListener(e -> {
      jFrame.dispose();
      new AdminDashboard();
    });

    JButton searchbookButton = new JButton();
    searchbookButton.setText("Search Book");
    searchbookButton.setBounds(150, 430, 200, 30);
    searchbookButton.setFont(new Font("monospaced", Font.BOLD, 18));
    jFrame.add(searchbookButton);

    searchbookButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        new search();
        // new StudentSearchIssuebook();
        // // new libraryStudentSearchm();
        // new StudentSearchIssuebook().dispose();
        String root = Bookfm.getText();
        new showtable(root);

      }
    });

    JButton searchstudentmButton = new JButton();
    searchstudentmButton.setText("Search Student");
    searchstudentmButton.setBounds(150, 470, 200, 30);
    searchstudentmButton.setFont(new Font("monospaced", Font.BOLD, 18));
    jFrame.add(searchstudentmButton);

    searchstudentmButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        new StudentSearchIssuebook();
        // new libraryStudentSearchm();
        new StudentSearchIssuebook().dispose();
        String root = studentfm.getText();
        new ShowtabledataStudent(root);
      }
    });

    jFrame.setVisible(true);
  }

  public void issueBook() {

    try {
      // int iid = Integer.parseInt(issueid.getText());
      int sid = Integer.parseInt(Student_id.getText());
      String b_name = BookName.getText();
      int b_q = Integer.parseInt(BQUANTITYi.getText());
      String issued = issuedate.getText();
      // String piread = periud.getText();
      String piread = "7";

      String url = "jdbc:mysql://localhost/library_managment";
      String userName = "root";
      String pass = "7410";
      Class.forName("com.mysql.cj.jdbc.Driver");

      Connection connection = DriverManager.getConnection(url, userName, pass);

      // Connection connection = DriverManager.getConnection(url, userName, pass);
      PreparedStatement checkQuantity = connection.prepareStatement("SELECT BQUANTITY FROM books_info WHERE bname=?");
      checkQuantity.setString(1, b_name);
      ResultSet rs = checkQuantity.executeQuery();
      if (rs.next()) {
          int availableQuantity = rs.getInt("BQUANTITY");
          if (b_q > availableQuantity) {
              JOptionPane.showMessageDialog(jFrame, "Requested book quantity exceeds available quantity: " + availableQuantity);
              return; 
          }
      } else {
          JOptionPane.showMessageDialog(jFrame, "Book not found");
      }
       
      PreparedStatement pst = connection.prepareStatement(
          "insert into issued_books(Student_id,BNAME,BQUANTITY,issued_date,period) VALUES(?,?,?,?,?)");
      // pst.setInt(1, iid);
      pst.setInt(1, sid);
      pst.setString(2, b_name);
      pst.setInt(3, b_q);
      pst.setString(4, issued);
      pst.setString(5, piread);
      pst.executeUpdate();
      JOptionPane.showMessageDialog(jFrame, "Book issued Succesfully : ");

      // System.out.println("data is Inserted ***** :: :: :: :");
    } catch (Exception e) {
      // System.out.println("Error in Connection : ");
      System.out.println(e);
    }

  }

  public void viewIssedBookm() {

    // improment krna he
    JLabel isbook = new JLabel("Issued Book Table");
    isbook.setBounds(800, 10, 300, 40);
    isbook.setFont(new Font("monospaced", Font.BOLD, 20));
    isbook.setVisible(true);
    jFrame.add(isbook);
    // Query for retrieving data from database
    String sql = "select iid,student_id,bquantity,bname,issued_date from issued_books;";
    try {
      String url = "jdbc:mysql://localhost/library_managment";
      String userName = "root";
      String pass = "7410";
      Class.forName("com.mysql.cj.jdbc.Driver");

      Connection connection = DriverManager.getConnection(url, userName, pass);

      // Creating Statement
      Statement stmt = connection.createStatement();
      // Executing query
      ResultSet rs = stmt.executeQuery(sql);
      // Creating Table for to data will be in table format
      JTable book_list = new JTable();
      String[] bookColumnNames = { "Issue_id", "Student_id", "Book Name", "BQantity", "Issued_Date" };
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
        int Iid = rs.getInt(1);
        int s_id = rs.getInt(2);
        // System.out.println(s_id + "==================================");
        String b_name = rs.getString(4);
        // System.out.println(b_name);
        int is_q = rs.getInt(3);
        String i_date = rs.getString(5);
        // String b_piriad = rs.getString(6);
        // Adding fetched data in model
        bookModel.addRow(new Object[] { Iid, s_id, b_name, is_q, i_date });
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
      // Creating Dialog box to show any error if occured!
      JOptionPane.showMessageDialog(null, e1);
      e1.printStackTrace();
      // System.out.println("Issue - " + (e1.printStackTrace());
    }
  }

  public static void main(String[] args) {
    new IssueBook();
  }

  public class StudentSearchIssuebook extends JFrame {
    JButton Back;

    public static void main(String[] args) {
      // new StudentSearchIssuebook();
    }

    private JPanel contentpanne;

    private JTextField studentf;
    private JButton searchButton;

    public StudentSearchIssuebook() {
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

      studentf = new JTextField(3);
      studentf.setFont(new Font("MONOSPACED", Font.BOLD, 18));
      studentf.setBounds(310, 90, 150, 30);
      contentpanne.add(bookLabel);
      contentpanne.add(studentf);

      searchButton = new JButton("Search");
      searchButton.setFont(new Font("MONOSPACED", Font.BOLD, 20));
      searchButton.setBounds(150, 150, 150, 40);
      // searchButton.setBackground(Color.DARK_GRAY);
      // searchButton.setForeground(Color.white);

      contentpanne.add(searchButton);
      searchButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          String root = studentf.getText();
          new ShowtabledataStudent(root);

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

  class ShowtabledataStudent extends JFrame {
    private JPanel contentPane;
    private JTable jt1;
    // private JTextField textField;

    ShowtabledataStudent(String root) {
      JLabel main1 = new JLabel("View Student");
      main1.setBounds(250, 30, 300, 50);
      main1.setFont(new Font("MONOSPACE", Font.BOLD, 26));
      contentPane = new JPanel();
      setContentPane(contentPane);
      contentPane.setLayout(null);

      JScrollPane scrollPane = new JScrollPane();
      scrollPane.setBackground(Color.DARK_GRAY);
      scrollPane.setBounds(40, 100, 700, 100);
      contentPane.add(scrollPane);

      libraryStudentSearchm obj = new libraryStudentSearchm();
      String[] column = { "STUDENTID", "STUDENTNAME", "PASSWORD", "SUBJECT", "ADDRESS", "MOBILE NO" };
      jt1 = new JTable(obj.my_db_selected1(root), column);
      scrollPane.setViewportView(jt1);

      jt1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
        public void valueChanged(ListSelectionEvent event) {
          if (!event.getValueIsAdjusting()) {
            int selectedRow = jt1.getSelectedRow();
            int selectedColumn = jt1.getSelectedColumn();
            Object selectedValue = jt1.getValueAt(selectedRow, selectedColumn);
            if (selectedValue != null) {
              Student_id.setText(selectedValue.toString());
            }
          }
        }
      });

      // textField = new JTextField();
      // textField.setBounds(40, 220, 200, 30);
      // contentPane.add(textField);
      // setSize(800, 180);
      setBounds(500, 35, 800, 300);
      add(main1);
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      setVisible(true);
    }

  }

  class libraryStudentSearchm {

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
        JOptionPane.showMessageDialog(contentPanne, "Student is not found");
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

  class search extends JFrame {
    JButton Back;

    public static void main(String[] args) {
      // new search();

    }

    private JPanel contentpanem;

    private JTextField bookField;
    private JButton searchButton;

    public search() {
      setBounds(700, 100, 500, 600);
      setLayout(null);
      contentpanem = new JPanel();

      contentpanem.setLayout(null);
      setContentPane(contentpanem);

      JLabel main = new JLabel("Search Book");
      main.setBounds(110, 20, 250, 30);
      main.setFont(new Font("MONOSPACED", Font.BOLD, 25));
      main.setForeground(Color.DARK_GRAY);
      contentpanem.add(main);

      JLabel bookLabel = new JLabel("Enter Book Name");
      bookLabel.setBounds(100, 90, 320, 30);
      bookLabel.setFont(new Font("MONOSPACED", Font.BOLD, 18));

      bookField = new JTextField(3);
      bookField.setFont(new Font("MONOSPACED", Font.BOLD, 18));
      bookField.setBounds(280, 90, 150, 30);
      contentpanem.add(bookLabel);
      contentpanem.add(bookField);

      searchButton = new JButton("Search");
      searchButton.setFont(new Font("MONOSPACED", Font.BOLD, 20));
      searchButton.setBounds(150, 150, 150, 40);
      // searchButton.setBackground(Color.DARK_GRAY);
      // searchButton.setForeground(Color.white);

      contentpanem.add(searchButton);
      searchButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          // new search();
          String root = bookField.getText();
          new showtable(root);

        }
      });

      Back = new JButton("Back");
      Back.setFont(new Font("MONOSPACED", Font.BOLD, 20));
      Back.setBounds(150, 210, 150, 40);
      contentpanem.add(Back);
      Back.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          // String root = bookField.getText();
          // new showtable(root);

          // new Student_Deshboard();

        }
      });

      setVisible(true);
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

  }

  class showtable extends JFrame {
    private JPanel contentpanem;
    private javax.swing.JTable jt1;

    JTextField textField;

    showtable(String root) {
      JTable table = new JTable();
      table.setVisible(true);

      JLabel main1 = new JLabel("Search Book");
      main1.setBounds(250, 30, 300, 50);
      main1.setFont(new Font("MONOSPACE", Font.BOLD, 26));
      contentpanem = new JPanel();

      setContentPane(contentpanem);
      contentpanem.setLayout(null);
      JScrollPane scrollPane = new JScrollPane();
      scrollPane.setBackground(Color.DARK_GRAY);
      scrollPane.setBounds(40, 100, 700, 100);
      contentpanem.add(scrollPane);
      libraryii obj = new libraryii();
      String[] column = { "BID", "BNAME", "AUTHOR", "BQUANTITY", "PUBLISHER", "PUBLICATION_YEAR" };
      jt1 = new javax.swing.JTable(obj.my_db_selected1(root), column);
      scrollPane.setViewportView(jt1);

      jt1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
        public void valueChanged(ListSelectionEvent event) {
          if (!event.getValueIsAdjusting()) {
            int selectedRow = jt1.getSelectedRow();
            int selectedColumn = jt1.getSelectedColumn();
            Object selectedValue = jt1.getValueAt(selectedRow, selectedColumn);
            if (selectedValue != null) {
              BookName.setText(selectedValue.toString());
            }
          }
        }
      });

      setSize(800, 300);
      add(main1);

      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      setVisible(true);

    }
  }

  class libraryii {

    private static final Component contentpanem = null;

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
        JOptionPane.showMessageDialog(contentpanem, "Book is not Available");
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