import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DigitalClockGUI extends JFrame {
    private JLabel timeLabel;
    private JLabel dateLabel;
    private JButton changeBackgroundColorButton;
    private JButton changeFontColorButton;
    private Color backgroundColor = Color.WHITE;
    private Color fontColor = Color.BLACK;

    public DigitalClockGUI() {
        setTitle("Digital Clock");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel clockPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Draw rounded rectangle
                g.setColor(backgroundColor);
                g.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
            }
        };
        clockPanel.setLayout(new GridLayout(2, 1));
        clockPanel.setPreferredSize(new Dimension(200, 100));
        timeLabel = new JLabel();
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        clockPanel.add(timeLabel);

        dateLabel = new JLabel();
        dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        clockPanel.add(dateLabel);

        add(clockPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        changeBackgroundColorButton = new JButton("Change Background Color");
        changeBackgroundColorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backgroundColor = JColorChooser.showDialog(null, "Choose Background Color", backgroundColor);
                clockPanel.repaint();
            }
        });
        buttonPanel.add(changeBackgroundColorButton);

        changeFontColorButton = new JButton("Change Font Color");
        changeFontColorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fontColor = JColorChooser.showDialog(null, "Choose Font Color", fontColor);
                updateTime();
            }
        });
        buttonPanel.add(changeFontColorButton);

        add(buttonPanel, BorderLayout.SOUTH);

        Timer timer = new Timer(1000, e -> updateTime());
        timer.start();

        updateTime();
        setVisible(true);
    }

    private void updateTime() {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
        Date now = new Date();
        String timeStr = timeFormat.format(now);
        String dateStr = dateFormat.format(now);
        timeLabel.setText(timeStr);
        timeLabel.setForeground(fontColor);
        dateLabel.setText(dateStr);
        dateLabel.setForeground(fontColor);
    }

    public static void main(String[] args) {
        new DigitalClockGUI();
    }
}

