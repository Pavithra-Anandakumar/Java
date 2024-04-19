import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DigitalClock extends JFrame {
    private JLabel timeLabel;

    public DigitalClock() {
        setTitle("Digital Clock");
        setSize(200, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        timeLabel = new JLabel();
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        updateTime();
        add(timeLabel);

        Timer timer = new Timer(1000, e -> updateTime());
        timer.start();

        setVisible(true);
    }

    private void updateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Date now = new Date();
        String timeStr = sdf.format(now);
        timeLabel.setText(timeStr);
    }

    public static void main(String[] args) {
        new DigitalClock();
    }
}
