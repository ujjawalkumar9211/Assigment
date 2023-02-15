import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CoinGameLogin extends JFrame implements ActionListener {

    private JLabel usernameLabel, passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public CoinGameLogin() {
        setTitle("Coin Game Login");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");
        usernameField = new JTextField(10);
        passwordField = new JPasswordField(10);
        loginButton = new JButton("Login");

        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel());
        panel.add(loginButton);

        loginButton.addActionListener(this);

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        
        if (username.equals("admin") && password.equals("admin1234")) {
            JOptionPane.showMessageDialog(this, "Welcome, admin!");
            
        } else if (username.equals("guest") && password.equals("guest1234")) {
            JOptionPane.showMessageDialog(this, "Welcome, guest!");
            
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password. Please try again.");
        }
    }

    public static void main(String[] args) {
        new CoinGameLogin();
}
}