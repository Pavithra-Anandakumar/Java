import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankingApplicationGUI extends JFrame implements ActionListener {
    private JTextField accountNumberField;
    private JTextField accountTypeField;
    private JTextField nameField;
    private JComboBox<String> operationComboBox;
    private JButton submitButton;

    public BankingApplicationGUI() {
        setTitle("Banking Application");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel accountNumberLabel = new JLabel("Account Number:");
        accountNumberLabel.setBounds(50, 30, 120, 20);
        add(accountNumberLabel);

        accountNumberField = new JTextField();
        accountNumberField.setBounds(180, 30, 150, 20);
        add(accountNumberField);

        JLabel accountTypeLabel = new JLabel("Account Type:");
        accountTypeLabel.setBounds(50, 60, 120, 20);
        add(accountTypeLabel);

        accountTypeField = new JTextField();
        accountTypeField.setBounds(180, 60, 150, 20);
        add(accountTypeField);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 90, 120, 20);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(180, 90, 150, 20);
        add(nameField);

        JLabel operationLabel = new JLabel("Operation:");
        operationLabel.setBounds(50, 120, 120, 20);
        add(operationLabel);

        operationComboBox = new JComboBox<>(new String[]{"Deposit", "Withdraw", "Check Balance"});
        operationComboBox.setBounds(180, 120, 150, 20);
        add(operationComboBox);

        submitButton = new JButton("Submit");
        submitButton.setBounds(150, 170, 100, 30);
        submitButton.addActionListener(this);
        add(submitButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String accountNumber = accountNumberField.getText();
        String accountType = accountTypeField.getText();
        String name = nameField.getText();
        String operation = (String) operationComboBox.getSelectedItem();

        if (!isValidAccountNumber(accountNumber)) {
            JOptionPane.showMessageDialog(this, "Invalid account number. Please enter a 10-digit number.");
            return;
        }

        // Perform operation based on user input
        switch (operation) {
            case "Deposit":
                double depositAmount = Double.parseDouble(JOptionPane.showInputDialog(this, "Enter amount to deposit:"));
                // Perform deposit operation
                JOptionPane.showMessageDialog(this, "Deposit successful.");
                break;
            case "Withdraw":
                double withdrawAmount = Double.parseDouble(JOptionPane.showInputDialog(this, "Enter amount to withdraw:"));
                // Perform withdrawal operation
                JOptionPane.showMessageDialog(this, "Withdrawal successful.");
                break;
            case "Check Balance":
                // Perform balance check operation
                JOptionPane.showMessageDialog(this, "Balance: $1000.00"); // Placeholder balance
                break;
            default:
                JOptionPane.showMessageDialog(this, "Invalid operation.");
        }
    }

    private boolean isValidAccountNumber(String accountNumber) {
        return accountNumber.matches("\\d{10}");
    }

    public static void main(String[] args) {
        new BankingApplicationGUI();
    }
}

