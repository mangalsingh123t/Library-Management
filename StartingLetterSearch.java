import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class StartingLetterSearch extends JFrame implements ActionListener {

    private JTextField searchField;
    private JTextArea resultArea;

    public StartingLetterSearch() {
        setTitle("Book Search App");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Initialize components
        searchField = new JTextField(10);
        JButton searchButton = new JButton("Search");
        resultArea = new JTextArea(10, 30);
        resultArea.setEditable(false);

        // Add action listener to the search button
        searchButton.addActionListener(this);

        // Create a panel to hold the components
        JPanel panel = new JPanel();
        panel.add(new JLabel("Enter starting letter:"));
        panel.add(searchField);
        panel.add(searchButton);

        // Add the panel and result area to the frame
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panel, BorderLayout.NORTH);
        getContentPane().add(new JScrollPane(resultArea), BorderLayout.CENTER);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Search")) {
            String startingLetter = searchField.getText().trim();

            // Clear the result area
            resultArea.setText("");

            // Perform the database search
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_managment",
                    "root", "7410");
                    Statement statement = connection.createStatement()) {

                // Query the database
                String query = "SELECT * FROM books_info WHERE BNAME LIKE '" + startingLetter + "%'";
                ResultSet resultSet = statement.executeQuery(query);

                // Display the search results
                while (resultSet.next()) {
                    String title = resultSet.getString("BNAME");
                    resultArea.append(title + "\n");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StartingLetterSearch app = new StartingLetterSearch();
            app.setVisible(true);
        });
    }
}
