import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class trafficlight_2 extends JFrame implements ActionListener {
    private JPanel lightPanel;
    private JButton redButton, yellowButton, greenButton;
    private Color activeColor = Color.DARK_GRAY;

    public trafficlight_2() {
        // Set up the frame
        setTitle("Traffic Light Simulator with Rectangle Structure");
        setSize(200, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the main panel for the traffic light
        lightPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // Draw the rectangle structure
                g.setColor(Color.BLACK);
                g.fillRect(40, 20, 120, 300);

                // Draw the red light
                g.setColor(activeColor == Color.RED ? Color.RED : Color.DARK_GRAY);
                g.fillOval(75, 40, 50, 50);

                // Draw the yellow light
                g.setColor(activeColor == Color.YELLOW ? Color.YELLOW : Color.DARK_GRAY);
                g.fillOval(75, 140, 50, 50);

                // Draw the green light
                g.setColor(activeColor == Color.GREEN ? Color.GREEN : Color.DARK_GRAY);
                g.fillOval(75, 240, 50, 50);
            }
        };
        lightPanel.setPreferredSize(new Dimension(200, 350));
        add(lightPanel, BorderLayout.CENTER);

        // Create a panel for the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3));

        // Create individual buttons for each light
        redButton = new JButton("Red");
        yellowButton = new JButton("Yellow");
        greenButton = new JButton("Green");

        // Add action listeners to the buttons
        redButton.addActionListener(this);
        yellowButton.addActionListener(this);
        greenButton.addActionListener(this);

        // Add the buttons to the button panel
        buttonPanel.add(redButton);
        buttonPanel.add(yellowButton);
        buttonPanel.add(greenButton);

        // Add the button panel to the frame
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Update the active light color based on the button clicked
        if (e.getSource() == redButton) {
            activeColor = Color.RED;
        } else if (e.getSource() == yellowButton) {
            activeColor = Color.YELLOW;
        } else if (e.getSource() == greenButton) {
            activeColor = Color.GREEN;
        }
        lightPanel.repaint();  // Repaint the light panel to show the updated light
    }

    public static void main(String[] args) {
        new trafficlight_2();
    }
}
