package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BMICalculator extends JFrame{
    private JTextField heightField;
    private JTextField weightField;
    private JLabel bmiLabel;
    private JButton calculateButton;
    private JButton logoutButton;

    public BMICalculator() {
        setTitle("BMI Calculator");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen

        // Create components
        heightField = new JTextField(10);
        weightField = new JTextField(10);
        bmiLabel = new JLabel("BMI will be calculated here");
        calculateButton = new JButton("Calculate BMI");
        logoutButton = new JButton("Logout");

        // Layout components using BorderLayout
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(new JLabel("Height (m):"), BorderLayout.WEST);
        panel.add(heightField, BorderLayout.CENTER);
        panel.add(new JLabel("Weight (kg):"), BorderLayout.SOUTH);
        panel.add(weightField, BorderLayout.EAST);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(calculateButton);
        buttonPanel.add(logoutButton);

        JPanel resultPanel = new JPanel();
        resultPanel.add(bmiLabel);

        // Add panels to the frame
        add(panel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(resultPanel, BorderLayout.SOUTH);

        // Add action listeners
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateBMI();
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logout();
            }
        });
    }

    private void calculateBMI() {
        try {
            double height = Double.parseDouble(heightField.getText());
            double weight = Double.parseDouble(weightField.getText());
            double bmi = weight / (height * height);
            bmiLabel.setText("BMI: " + bmi);
        } catch (NumberFormatException | ArithmeticException ex) {
            bmiLabel.setText("Invalid input. Please enter valid numbers.");
        }
    }

    private void logout() {
        dispose(); // Close the JFrame
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BMICalculator calculator = new BMICalculator();
            calculator.setVisible(true);
        });
    }
}