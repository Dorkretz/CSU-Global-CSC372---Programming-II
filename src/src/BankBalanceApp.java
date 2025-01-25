package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankBalanceApp extends JFrame {
    // GUI Components
    private JPanel mainPanel;
    private JTextField balanceField;
    private JTextField amountField;
    private JButton depositButton;
    private JButton withdrawButton;
    private JTextArea resultArea;
    private double balance = 0;

    public BankBalanceApp() {
        setTitle("Bank Balance App");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize main panel
        mainPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        createComponents();
        add(mainPanel);
        setLocationRelativeTo(null); // Centering frame
    }

    private void createComponents() {
        // Initialize Balance
        mainPanel.add(new JLabel("Initial Balance: $"));
        balanceField = new JTextField(10);
        mainPanel.add(balanceField);

        // Transaction Amount
        mainPanel.add(new JLabel("Transaction Amount: $"));
        amountField = new JTextField(10);
        mainPanel.add(amountField);

        // Deposit Button
        depositButton = new JButton("Deposit");
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processTransaction(true);
            }
        });
        mainPanel.add(depositButton);

        // Withdraw Button
        withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processTransaction(false);
            }
        });
        mainPanel.add(withdrawButton);

        // Results
        resultArea = new JTextArea(3, 20);
        resultArea.setEditable(false);
        mainPanel.add(new JLabel("Account Status:"));
        mainPanel.add(new JScrollPane(resultArea));
    }

    private void processTransaction(boolean isDeposit) {
        try {
            // Initialize balance if not already
            if (balance == 0 && !balanceField.getText().isEmpty()) {
                balance = Double.parseDouble(balanceField.getText());
                balanceField.setEditable(false);
            }

            // Get transaction amount
            double amount = Double.parseDouble(amountField.getText());

            // Process transaction
            if (isDeposit) {
                balance += amount;
                resultArea.append("Deposited: $" + amount + "\n");
            } else {
                // Check for sufficient funds
                if (amount > balance) {
                    JOptionPane.showMessageDialog(this,
                            "Insufficient Funds!",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                balance -= amount;
                resultArea.append("Withdrawn: $" + amount + "\n");
            }

            // Update results with current balance
            resultArea.append("Current Balance: $" + balance + "\n\n");

            // Clear amount field
            amountField.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Please enter a valid number",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BankBalanceApp app = new BankBalanceApp();
            app.setVisible(true);
        });
    }
}
