import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ATM_UI extends JFrame implements ActionListener {

    double balance = 10000;

    JButton checkBtn, depositBtn, withdrawBtn, exitBtn;
    JLabel title;

    ATM_UI() {
        setTitle("ATM Machine");
        setSize(400, 350);
        setLocationRelativeTo(null); // center screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Font
        Font btnFont = new Font("Arial", Font.BOLD, 14);

        // Title
        title = new JLabel("ATM MACHINE", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setForeground(Color.BLUE);
        title.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));

        // Buttons
        checkBtn = new JButton("Check Balance");
        depositBtn = new JButton("Deposit");
        withdrawBtn = new JButton("Withdraw");
        exitBtn = new JButton("Exit");

        JButton[] buttons = { checkBtn, depositBtn, withdrawBtn, exitBtn };

        for (JButton btn : buttons) {
            btn.setFont(btnFont);
            btn.setFocusPainted(false);
            btn.setBackground(new Color(60, 179, 113));
            btn.setForeground(Color.WHITE);
            btn.addActionListener(this);
        }

        exitBtn.setBackground(Color.RED);

        // Panel for buttons
        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new GridLayout(4, 1, 15, 15));
        btnPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        btnPanel.setBackground(Color.WHITE);

        btnPanel.add(checkBtn);
        btnPanel.add(depositBtn);
        btnPanel.add(withdrawBtn);
        btnPanel.add(exitBtn);

        // Main layout
        setLayout(new BorderLayout());
        add(title, BorderLayout.NORTH);
        add(btnPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == checkBtn) {
            JOptionPane.showMessageDialog(this,
                    "Current Balance: ₹" + balance);
        }

        if (e.getSource() == depositBtn) {
            String input = JOptionPane.showInputDialog(this,
                    "Enter amount to deposit:");
            if (input != null) {
                double amount = Double.parseDouble(input);
                if (amount > 0) {
                    balance += amount;
                    JOptionPane.showMessageDialog(this,
                            "₹" + amount + " deposited successfully");
                }
            }
        }

        if (e.getSource() == withdrawBtn) {
            String input = JOptionPane.showInputDialog(this,
                    "Enter amount to withdraw:");
            if (input != null) {
                double amount = Double.parseDouble(input);
                if (amount > 0 && amount <= balance) {
                    balance -= amount;
                    JOptionPane.showMessageDialog(this,
                            "₹" + amount + " withdrawn successfully");
                } else {
                    JOptionPane.showMessageDialog(this,
                            "Insufficient balance");
                }
            }
        }

        if (e.getSource() == exitBtn) {
            JOptionPane.showMessageDialog(this,
                    "Thank you for using ATM");
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new ATM_UI();
    }
}

public class ATM {

}
