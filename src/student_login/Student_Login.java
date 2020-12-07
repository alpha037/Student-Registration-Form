package student_login;

/**
 * @author Alpha
 */
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.ParseException;
import javax.swing.*;
import javax.swing.text.MaskFormatter;

public class Student_Login extends JFrame implements ActionListener {

  private static final String JDBC_DRIVER = "oracle.jdbc.OracleDriver";
  private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";

  private static final String user = "system";
  private static final String pass = "alpha";

  private int count = 0;

  private String[] str = {
    "SELECT COUNTRY",
    "United States",
    "United Kingdom",
    "France",
    "Italy",
    "India",
    "Germany",
    "Australia",
    "Russia",
    "China",
    "Japan"
  };

  private JComboBox cb;
  private JRadioButton rb1, rb2, rb3, rb4, rb5, rb6, rb7, rb8, rb9;
  private ButtonGroup bg1, bg2;
  private JTextField t1, t2, t3, t4, t5, t6;
  private JTextArea ta;
  private JFormattedTextField ftf1, ftf2, ftf3;
  private JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, label;
  private JButton b1, b2, b3, b4;
  private MaskFormatter m1, m2, m3;

  public Student_Login() throws ParseException {
    super("Student Registration Form");

    label = new JLabel("STUDENT REGISTRATION FORM");
    label.setFont(new Font("Impact", Font.PLAIN, 36));
    label.setBounds(280, 20, 900, 30);

    t1 = new JTextField();
    t1.setBounds(180, 100, 220, 30);
    t1.setFont(new Font("Arial", Font.BOLD, 14));

    t2 = new JTextField();
    t2.setBounds(180, 160, 220, 30);
    t2.setFont(new Font("Arial", Font.BOLD, 14));

    m1 = new MaskFormatter("##-##-####");
    ftf1 = new JFormattedTextField(m1);
    ftf1.setBounds(180, 220, 220, 30);
    ftf1.setFont(new Font("Arial", Font.BOLD, 14));

    t3 = new JTextField();
    t3.setBounds(180, 280, 220, 30);
    t3.setFont(new Font("Arial", Font.BOLD, 14));

    m2 = new MaskFormatter("##########");
    ftf2 = new JFormattedTextField(m2);
    ftf2.setBounds(180, 340, 220, 30);
    ftf2.setFont(new Font("Arial", Font.BOLD, 14));

    rb1 = new JRadioButton("Male");
    rb1.setBounds(180, 400, 60, 30);
    rb1.setFont(new Font("Arial", Font.BOLD, 14));
    rb2 = new JRadioButton("Female");
    rb2.setBounds(240, 400, 80, 30);
    rb2.setFont(new Font("Arial", Font.BOLD, 14));
    rb3 = new JRadioButton("Others");
    rb3.setBounds(320, 400, 80, 30);
    rb3.setFont(new Font("Arial", Font.BOLD, 14));
    bg1 = new ButtonGroup();
    bg1.add(rb1);
    bg1.add(rb2);
    bg1.add(rb3);

    ta = createTextArea();

    t4 = new JTextField();
    t4.setBounds(640, 100, 220, 30);
    t4.setFont(new Font("Arial", Font.BOLD, 14));

    m3 = new MaskFormatter("######");
    ftf3 = new JFormattedTextField(m3);
    ftf3.setBounds(640, 160, 220, 30);
    ftf3.setFont(new Font("Arial", Font.BOLD, 14));

    t5 = new JTextField();
    t5.setBounds(640, 220, 220, 30);
    t5.setFont(new Font("Arial", Font.BOLD, 14));

    cb = new JComboBox(str);
    cb.setBounds(640, 280, 220, 30);
    cb.setFont(new Font("Arial", Font.BOLD, 14));

    t6 = new JTextField();
    t6.setBounds(640, 340, 220, 30);
    t6.setFont(new Font("Arial", Font.BOLD, 14));

    rb4 = new JRadioButton("BCA");
    rb4.setBounds(640, 400, 60, 30);
    rb4.setFont(new Font("Arial", Font.BOLD, 14));
    rb5 = new JRadioButton("B.Sc");
    rb5.setBounds(700, 400, 60, 30);
    rb5.setFont(new Font("Arial", Font.BOLD, 14));
    rb6 = new JRadioButton("B.TECH");
    rb6.setBounds(760, 400, 80, 30);
    rb6.setFont(new Font("Arial", Font.BOLD, 14));
    bg2 = new ButtonGroup();
    bg2.add(rb4);
    bg2.add(rb5);
    bg2.add(rb6);

    l1 = new JLabel("First Name : ");
    l1.setBounds(40, 100, 100, 30);
    l1.setFont(new Font("Arial", Font.BOLD, 14));

    l2 = new JLabel("Last Name : ");
    l2.setBounds(40, 160, 100, 30);
    l2.setFont(new Font("Arial", Font.BOLD, 14));

    l3 = new JLabel("Date of Birth : ");
    l3.setBounds(40, 220, 100, 30);
    l3.setFont(new Font("Arial", Font.BOLD, 14));

    l4 = new JLabel("Email : ");
    l4.setBounds(40, 280, 100, 30);
    l4.setFont(new Font("Arial", Font.BOLD, 14));

    l5 = new JLabel("Mobile No. : ");
    l5.setBounds(40, 340, 100, 30);
    l5.setFont(new Font("Arial", Font.BOLD, 14));

    l6 = new JLabel("Gender : ");
    l6.setBounds(40, 400, 100, 30);
    l6.setFont(new Font("Arial", Font.BOLD, 14));

    l7 = new JLabel("Address : ");
    l7.setBounds(40, 460, 100, 30);
    l7.setFont(new Font("Arial", Font.BOLD, 14));

    l8 = new JLabel("City : ");
    l8.setBounds(540, 100, 100, 30);
    l8.setFont(new Font("Arial", Font.BOLD, 14));

    l9 = new JLabel("Pincode : ");
    l9.setBounds(540, 160, 100, 30);
    l9.setFont(new Font("Arial", Font.BOLD, 14));

    l10 = new JLabel("State : ");
    l10.setBounds(540, 220, 100, 30);
    l10.setFont(new Font("Arial", Font.BOLD, 14));

    l11 = new JLabel("Country : ");
    l11.setBounds(540, 280, 100, 30);
    l11.setFont(new Font("Arial", Font.BOLD, 14));

    l12 = new JLabel("Hobbies : ");
    l12.setBounds(540, 340, 100, 30);
    l12.setFont(new Font("Arial", Font.BOLD, 14));

    l13 = new JLabel("Course : ");
    l13.setBounds(540, 400, 100, 30);
    l13.setFont(new Font("Arial", Font.BOLD, 14));

    b1 = new JButton("Submit");
    b1.setBounds(280, 860, 80, 30);
    b2 = new JButton("Exit");
    b2.setBounds(400, 860, 80, 30);
    b3 = new JButton("Reset");
    b3.setBounds(520, 860, 80, 30);
    b4 = new JButton("Row Count");
    b4.setBounds(640, 860, 100, 30);

    b1.addActionListener(this);
    b2.addActionListener(this);
    b3.addActionListener(this);
    b4.addActionListener(this);

    add(label);
    add(ta);
    add(cb);
    add(t1);
    add(t2);
    add(t3);
    add(t4);
    add(t5);
    add(t6);
    add(l1);
    add(l2);
    add(l3);
    add(l4);
    add(l5);
    add(l6);
    add(l7);
    add(l8);
    add(l9);
    add(l10);
    add(l11);
    add(l12);
    add(l13);
    add(b1);
    add(b2);
    add(b3);
    add(b4);
    add(ftf1);
    add(ftf2);
    add(ftf3);
    add(rb1);
    add(rb2);
    add(rb3);
    add(rb4);
    add(rb5);
    add(rb6);

    setSize(1000, 1000);
    setLayout(null);
    setVisible(true);
    setLocationRelativeTo(null);
    // setForeground(Color.blue);
  }

  public static void Insert(
      String s1,
      String s2,
      String s3,
      String s4,
      double s5,
      String s6,
      String s7,
      String s8,
      double s9,
      String s10,
      String s11,
      String s12,
      String s13) {
    Connection conn = null;
    PreparedStatement st = null;

    try {
      Class.forName(JDBC_DRIVER);

      System.out.println("Commencing Connection. Please Wait . . .");
      conn = DriverManager.getConnection(DB_URL, user, pass);

      System.out.println("Creating Prepared Statement. Please Wait . . .");
      String sql;
      sql = "INSERT INTO LOGIN VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";

      st = conn.prepareStatement(sql);
      st.setString(1, s1);
      st.setString(2, s2);
      st.setString(3, s3);
      st.setString(4, s4);
      st.setDouble(5, s5);
      st.setString(6, s6);
      st.setString(7, s7);
      st.setString(8, s8);
      st.setDouble(9, s9);
      st.setString(10, s10);
      st.setString(11, s11);
      st.setString(12, s12);
      st.setString(13, s13);

      st.executeUpdate();

      st.close();
      conn.close();
    } catch (ClassNotFoundException | SQLException ex1) {
      System.out.println(ex1);
    } finally {
      try {
        if (st != null) st.close();
      } catch (SQLException se2) {
      }
      try {
        if (conn != null) conn.close();
      } catch (SQLException se3) {
      }
    }
    System.out.println("Insertion Successful.");
  }

  /** @return */
  public int RowCount() {
    Connection conn = null;
    PreparedStatement st = null;

    try {
      Class.forName(JDBC_DRIVER);

      System.out.println("Commencing Connection. Please Wait . . .");
      conn = DriverManager.getConnection(DB_URL, user, pass);

      System.out.println("Creating Prepared Statement. Please Wait . . .");
      String sql;
      sql = "SELECT * FROM LOGIN";

      st = conn.prepareStatement(sql);

      ResultSet rs = st.executeQuery();

      while (rs.next()) {
        /*String s1 = rs.getString(1);
        String s2 = rs.getString(2);
        String s3 = rs.getString(3);
        String s4 = rs.getString(4);
        double s5 = rs.getDouble(5);
        String s6 = rs.getString(6);
        String s7 = rs.getString(7);
        String s8 = rs.getString(8);
        double s9 = rs.getDouble(9);
        String s10 = rs.getString(10);
        String s11 = rs.getString(11);
        String s12 = rs.getString(12);
        String s13 = rs.getString(13);*/
        this.count++;
      }

      st.close();
      conn.close();
    } catch (ClassNotFoundException | SQLException ex1) {
      System.out.println(ex1);
    } finally {
      try {
        if (st != null) st.close();
      } catch (SQLException se2) {
      }
      try {
        if (conn != null) conn.close();
      } catch (SQLException se3) {
      }
    }
    System.out.println("Fetch Successful.");
    return count;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String string = e.getActionCommand();
    if (string.equals("Submit")) {
      String s1 = t1.getText();
      String s2 = t2.getText();
      String s3 = ftf1.getText();
      String s4 = t3.getText();
      double s5 = Double.parseDouble(ftf2.getText());

      String s6 = "";
      if (rb1.isSelected()) s6 = "Male";
      else if (rb2.isSelected()) s6 = "Female";
      else if (rb3.isSelected()) s6 = "Others";

      String s7 = ta.getText();
      String s8 = t4.getText();
      double s9 = Double.parseDouble(ftf3.getText());
      String s10 = t5.getText();
      String s11 = String.valueOf(cb.getItemAt(cb.getSelectedIndex()));
      String s12 = t6.getText();

      String s13 = "";
      if (rb4.isSelected()) s13 = "BCA";
      else if (rb5.isSelected()) s13 = "B.Sc";
      else if (rb6.isSelected()) s13 = "B.TECH";

      Student_Login.Insert(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13);

      JOptionPane.showMessageDialog(
          this, "Data Insertion Is Successful!", "Message", JOptionPane.PLAIN_MESSAGE);
    } else if (string.equals("Exit")) {
      int i = JOptionPane.showConfirmDialog(this, "Are you sure you want to Exit ?");
      if (i == JOptionPane.YES_OPTION) dispose();
    } else if (string.equals("Reset")) {
      t1.setText("");
      t2.setText("");
      t3.setText("");
      t4.setText("");
      t5.setText("");
      t6.setText("");
      ftf1.setText("");
      ftf2.setText("");
      ftf3.setText("");
      ta.setText("");
      cb.setSelectedIndex(0);
      bg1.clearSelection();
      bg2.clearSelection();

      JOptionPane.showMessageDialog(
          this, "Input Fields Are Reset!", "Alert", JOptionPane.WARNING_MESSAGE);
    } else if (string.equals("Row Count")) {
      /*JFrame j = new JFrame();

      j.setVisible(true);
      j.setLayout(null);
      j.setLocationRelativeTo(null);
      j.setSize(500,500);*/

      int c = RowCount();
      JOptionPane.showMessageDialog(
          this,
          "Total Number of Rows : " + String.valueOf(c),
          "Message",
          JOptionPane.PLAIN_MESSAGE);
      this.count = 0;
    }

    repaint();
  }

  private static JTextArea createTextArea() {

    JTextArea tx = new JTextArea();
    tx.setWrapStyleWord(true);
    tx.setLineWrap(true);
    tx.setBounds(180, 460, 220, 220);
    tx.setFont(new Font("Arial", Font.BOLD, 14));
    return tx;
  }

  public static void main(String[] args) throws ParseException {

    new Student_Login();
  }
}
