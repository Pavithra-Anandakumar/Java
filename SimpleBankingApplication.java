import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BankAccount {
    private String name;
    private double balance;

    public BankAccount(String name) {
        this.name = name;
        this.balance = 0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited " + amount + " into " + name + "'s account.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew " + amount + " from " + name + "'s account.");
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public double getBalance() {
        return balance;
    }
}

public class SimpleBankingApplication extends JFrame {
    private BankAccount account;

    public SimpleBankingApplication(String title) {
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        panel.add(nameLabel);
        panel.add(nameField);

        JLabel amountLabel = new JLabel("Amount:");
        JTextField amountField = new JTextField();
        panel.add(amountLabel);
        panel.add(amountField);

        JButton depositButton = new JButton("Deposit");
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                double amount = Double.parseDouble(amountField.getText());
                account.deposit(amount);
                JOptionPane.showMessageDialog(null, "Deposited " + amount + " into " + name + "'s account.");
            }
        });
        panel.add(depositButton);

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                double amount = Double.parseDouble(amountField.getText());
                if (amount <= account.getBalance()) {
                    account.withdraw(amount);
                    JOptionPane.showMessageDialog(null, "Withdrew " + amount + " from " + name + "'s account.");
                } else {
                    JOptionPane.showMessageDialog(null, "Insufficient funds.");
                }
            }
        });
        panel.add(withdrawButton);

        JButton checkBalanceButton = new JButton("Check Balance");
        checkBalanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                double balance = account.getBalance();
                JOptionPane.showMessageDialog(null, "Current balance in " + name + "'s account: " + balance);
            }
        });
        panel.add(checkBalanceButton);

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SimpleBankingApplication app = new SimpleBankingApplication("Simple Banking Application");
                app.account = new BankAccount("");
                app.setVisible(true);
            }
        });
    }
}
