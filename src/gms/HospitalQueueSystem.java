package gms;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

 class HospitalQueueSystem extends JFrame {

    private JTextField nameField;
    private JTextArea displayArea;

    private Queue<String> queue = new LinkedList<>();
    private int tokenCounter = 100;

    public HospitalQueueSystem() {
        setTitle("Hospital Queue Management System");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Top Panel
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(2, 2, 10, 10));

        topPanel.add(new JLabel("Patient Name:"));
        nameField = new JTextField();
        topPanel.add(nameField);

        JButton addBtn = new JButton("Add Patient");
        JButton serveBtn = new JButton("Serve Next");

        topPanel.add(addBtn);
        topPanel.add(serveBtn);

        add(topPanel, BorderLayout.NORTH);

        // Display Area
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        // Button Actions
        addBtn.addActionListener(e -> addPatient());
        serveBtn.addActionListener(e -> servePatient());

        setVisible(true);
    }

    private void addPatient() {
        String name = nameField.getText().trim();

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter patient name!");
            return;
        }

        String token = "T-" + tokenCounter++;
        String entry = token + " : " + name;

        queue.add(entry);
        nameField.setText("");

        updateDisplay();
    }

    private void servePatient() {
        if (queue.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No patients in queue!");
            return;
        }

        String served = queue.poll();
        JOptionPane.showMessageDialog(this, "Serving: " + served);

        updateDisplay();
    }

    private void updateDisplay() {
        displayArea.setText("");

        displayArea.append("=== Hospital Queue ===\n\n");

        for (String patient : queue) {
            displayArea.append(patient + "\n");
        }

        displayArea.append("\nTotal Waiting: " + queue.size());
    }

    public static void main(String[] args) {
        new HospitalQueueSystem();
    }
}