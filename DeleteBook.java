import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteBook  extends JFrame{
    private JTextField bookFiald;
    private JButton deleteButton;
    private JButton Back;
    

    DeleteBook(){
      setTitle("Delete book");
      setBounds(980,20,400, 600);
      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      setLayout(null);

      JLabel main = new JLabel("Delete book");
      main.setBounds(100,20,200,30);
      main.setFont(new Font("MONOSPACED",Font.BOLD,25));
     main.setForeground(Color.DARK_GRAY);   

        JLabel booklaLabel = new JLabel("Enter Name");
        booklaLabel.setBounds(70,80,220,20);
        booklaLabel.setFont(new Font("MONOSPACED",Font.BOLD,15));
        bookFiald = new JTextField(3);
        bookFiald.setFont(new Font("MONOSPACED",Font.BOLD,15));
        bookFiald.setBounds(190,80,120,20);
       

        deleteButton = new JButton("Delete book");
        deleteButton.setFont(new Font("MONOSPACED",Font.BOLD,15));
       deleteButton.setBounds(90,140,150,40);
        // deleteButton.setBackground(Color.DARK_GRAY);
        // deleteButton.setForeground(Color.white);
       deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delete();
            }
        });


        Back = new JButton("Back");
        Back.setFont(new Font("MONOSPACED",Font.BOLD,15));
       Back.setBounds(90,200,150,40);
        // Back.setBackground(Color.DARK_GRAY);
        // Back.setForeground(Color.white);
       Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  new ViewBooks(); 
            }
        });
        add(main);
        add(booklaLabel);
        add(bookFiald);
        add(new JLabel());
        add(deleteButton);
        add(Back);

       setVisible(true);
        
    }
    private void delete() {
      
        String banmee = bookFiald.getText();

       
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_managment", "root", "7410");
            String query = "Delete from books_info where bname=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,banmee );
           
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Book Removed successfully!");
               
            } else {
                JOptionPane.showMessageDialog(this, "Failed to Remove data!");
            }

            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }
    public static void main(String[] args) {
        new DeleteBook();
    }
    
    }