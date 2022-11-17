import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;

public class Frame extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private static ArrayList<Customer> C = new ArrayList<>();
    private static ArrayList<Books> B = new ArrayList<>();

    JButton dispCustButton;
    JButton dispBooksButton;
    JTextField field;
    JTextField field2;

    JTextArea header;
    JTextArea area;

    JTextArea area2;
    JTextArea area3;

    Frame() throws IOException {
        getArrayList();
        getBookList();

        area = new JTextArea();
        area.setBounds(550, 20, 800, 640);
        area.setEditable(false);

        Font font3 = new Font("SansSerif", Font.BOLD, 50);
        header = new JTextArea();
        header.setBounds(18, 25, 515, 60);
        header.setEditable(false);
        header.setBackground(new java.awt.Color(0,0,0,1));
        header.setFont(font3);
        header.setForeground(new Color(92, 209, 255));
        header.setText("VRAJ'S BOOKSTORE");

        Font font1 = new Font("SansSerif", Font.BOLD, 20);
        area2 = new JTextArea();
        area2.setBounds(142, 255, 265, 30);
        area2.setEditable(false);
        area2.setBackground(new java.awt.Color(0,0,0,1));
        area2.setFont(font1);
        area2.setText("Enter Customer First Name:");

        Font font2 = new Font("SansSerif", Font.BOLD, 20);
        area3 = new JTextArea();
        area3.setBounds(139, 485, 275, 30);
        area3.setEditable(false);
        area3.setBackground(new java.awt.Color(0,0,0,1));
        area3.setFont(font2);
        area3.setText("Enter The Title Of The Book:");


        dispCustButton = new JButton();
        dispCustButton.setBounds(15, 100, 250, 100);
        dispCustButton.addActionListener(this);
        dispCustButton.setText("Display All Customers!");
        dispCustButton.setFocusable(false);

        dispBooksButton = new JButton();
        dispBooksButton.setBounds(285, 100, 250, 100);
        dispBooksButton.addActionListener(this);
        dispBooksButton.setText("Display All Available Books!");
        dispBooksButton.setFocusable(false);

        field = new JTextField(10);
        field.setBounds(125, 285, 300, 50);
        field.addActionListener(this);

        field2 = new JTextField(10);
        field2.setBounds(125, 515, 300, 50);
        field2.addActionListener(this);

        JButton searchButton = new JButton(new AbstractAction("Search For This Customer!") {
            /**
             *
             */
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
                for (Customer element : C) {
                    if (element.getFirstName().equals(field.getText())) {
                        int x = C.indexOf(element);
                        area.setText(C.get(x).toString());
                        area.setForeground(Color.red);
                        return;
                    }
                }
                area.setText("TRY AGAIN WITH A VALID CUSTOMER NAME!");
                area.setForeground(Color.red);

            }
        });
        searchButton.setBounds(175, 350, 200, 50);

        JButton rentButton = new JButton(new AbstractAction("Rent This Book!") {
            /**
             *
             */
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
                for (Books element : B) {
                    if (element.getTitle().equals(field2.getText())) {
                        B.remove(element);
                        area.setText("BOOK SUCCESSFULLY RENTED!");
                        area.setForeground(Color.red);
                        return;
                    }
                }
                area.setText("THIS BOOK IS ALREADY RENTED OR YOU HAVE ENTERED THE TITLE INCORRECTLY, PLEASE CHOOSE FROM THESE BOOKS:\n " + B.toString());
                area.setForeground(Color.red);
            }
        });
        rentButton.setBounds(175, 575, 200, 50);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(1380, 720);
        this.setTitle("Book Store Application");
        this.setVisible(true);
        this.add(dispCustButton);
        this.add(dispBooksButton);
        this.add(field);
        this.add(field2);
        this.add(searchButton);
        this.add(rentButton);
        this.add(area);
        this.add(area2);
        this.add(area3);
        this.add(header);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == dispCustButton) {
            area.setText(C.toString().replace("[","").replace("]",""));
            area.setForeground(Color.red);
        }
        if (e.getSource() == dispBooksButton) {
            area.setText(B.toString().replace("[","").replace("]",""));
            area.setForeground(Color.red);
        }
    }
    public static String getArrayList() throws IOException {
        File f = new File("customers.txt");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        while (line != null) {
            String t[] = line.split(",");
            String firstName = t[0];
            String lastName = t[1];
            String email = t[2];
            String phone = t[3];
            String address = t[4];
            C.add(new Customer(firstName, lastName, email, phone, address));
            line = br.readLine();
        }
        br.close();
        return C.toString();
    }
    public static String getBookList() throws IOException {
        File f = new File("books.txt");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        while (line != null) {
            String t[] = line.split(",");
            String title = t[0];
            String author = t[1];
            String pages = t[2];
            String publisher = t[3];
            String year = t[4];
            String copies = t[5];
            String category = t[6];
            B.add(new Books(title, author, pages, publisher, year, copies, category));
            line = br.readLine();
        }
        br.close();
        return B.toString();
    }
}
