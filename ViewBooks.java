import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ViewBooks {
    JFrame viewFrame;
    JLabel heading;
    JPanel tablePanel, navigationPanel;
    JButton back;
    JScrollPane scrollPane;
    JTable productsTable;
    JDBC jdbc;
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    public ViewBooks() {
        viewFrame = new JFrame();
        viewFrame.setSize(965, 625);
        viewFrame.setDefaultCloseOperation(viewFrame.EXIT_ON_CLOSE);
        // viewFrame.setLocationRelativeTo(null);
        viewFrame.setLayout(null);

        heading = new JLabel("All Books in Library");
        heading.setBounds(10, 10, 930, 40);
        heading.setFont(new Font("monospaced", Font.BOLD, 25));
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        heading.setBorder(new LineBorder(Color.GRAY, 2));
        viewFrame.add(heading);

        tablePanel = new JPanel();
        tablePanel.setBounds(10, 60, 930, 460);
        tablePanel.setBorder(new LineBorder(Color.gray, 2));
        tablePanel.setLayout(null);
        viewFrame.add(tablePanel);

        navigationPanel = new JPanel();
        navigationPanel.setBounds(10, 530, 930, 50);
        navigationPanel.setBorder(new LineBorder(Color.gray, 2));
        navigationPanel.setLayout(null);
        viewFrame.add(navigationPanel);

        back = new JButton("Back");
        back.setBounds(200, 5, 180, 40);
        back.setFont(new Font("monospaced", Font.BOLD, 25));
        back.setFocusable(false);
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        navigationPanel.add(back);

        back.addActionListener(e -> {
            // new Dashboard();
            viewFrame.dispose();
            new AdminDashboard();
        });
        JButton delete = new JButton("delete");
        delete.setBounds(600, 5, 180, 40);
        delete.setFont(new Font("monospaced", Font.BOLD, 25));
        delete.setFocusable(false);
        delete.setCursor(new Cursor(Cursor.HAND_CURSOR));
        navigationPanel.add(delete);

        delete.addActionListener(e -> {
            // new Dashboard();
            viewFrame.dispose();
            new DeleteBook();
        });
        showTable();

        viewFrame.setVisible(true);
    }

    public void showTable() {
        String tableColumns[] =  {"BID","BName","AUTHOR","BQUANTITY","Publisher", "PUBLICATION_YEAR"};
        String tableData[][] = new String[0][0];
        int count = 0;
        try {
            jdbc = new JDBC();
            jdbc.setConnection();
            
              


            preparedStatement = jdbc.connection.prepareStatement("SELECT Count(*) From books_info;");
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            count = resultSet.getInt(1);
            // System.out.println(count);

            tableData = new String[count][6];

            preparedStatement = jdbc.connection.prepareStatement("SELECT * from books_info;");
            resultSet = preparedStatement.executeQuery();

            for (int i = 0; i < count; i++) {
                resultSet.next();
                tableData[i][0] = resultSet.getString(1);
                tableData[i][1] = resultSet.getString(2);
                tableData[i][2] = resultSet.getString(3);
                tableData[i][3] = resultSet.getString(4);
                tableData[i][4] = resultSet.getString(5);
                tableData[i][5] = resultSet.getString(6);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        productsTable = new JTable(tableData, tableColumns);
        productsTable.setRowHeight(35);
        productsTable.setFont(new Font("monospaced", Font.BOLD, 18));
        scrollPane = new JScrollPane(productsTable);
        scrollPane.setBounds(5, 5, 920, 450);
        tablePanel.add(scrollPane);
        

        tablePanel.setVisible(true);
    }



public static void main(String[] args) {
    new ViewBooks();
}
}
