package gms;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class HospitalQueueSystem extends JFrame {


private ArrayList<Patient> patients;
private Queue<Patient> queue;

private JTable table;
private DefaultTableModel model;

private JTextField nameField;
private JTextField diseaseField;
private JTextField searchField;

private JLabel statsLabel;

private int tokenCounter = 100;

private Color primary =
        new Color(41,128,185);

private Color success =
        new Color(39,174,96);

private Color danger =
        new Color(231,76,60);

private Color background =
        new Color(245,247,250);

public HospitalQueueSystem() {

    patients =
            FileManager.loadPatients();

    queue =
            new LinkedList<>();

    for (Patient p : patients) {

        if (p.getStatus()
                .equalsIgnoreCase(
                        "Waiting")) {

            queue.add(p);
        }

        if (p.getToken()
                >= tokenCounter) {

            tokenCounter =
                    p.getToken() + 1;
        }
    }

    buildGUI();

    refreshTable();
}

private void buildGUI() {

    setTitle(
            "Hospital Queue Management System");

    setSize(1100,700);

    setLocationRelativeTo(null);

    setDefaultCloseOperation(
            EXIT_ON_CLOSE);

    getContentPane()
            .setBackground(background);

    setLayout(new BorderLayout());

    JPanel topPanel =
            new JPanel(
                    new BorderLayout());

    topPanel.setBackground(
            background);

    JLabel title =
            new JLabel(
                    "Hospital Queue Management Dashboard",
                    SwingConstants.CENTER);

    title.setFont(
            new Font(
                    "Segoe UI",
                    Font.BOLD,
                    24));

    title.setBorder(
            new EmptyBorder(
                    15,10,15,10));

    title.setForeground(primary);

    topPanel.add(
            title,
            BorderLayout.NORTH);

    JPanel formPanel =
            new JPanel(
                    new GridLayout(
                            2,
                            4,
                            10,
                            10));

    formPanel.setBorder(
            new EmptyBorder(
                    10,
                    20,
                    10,
                    20));

    formPanel.setBackground(
            background);

    nameField =
            new JTextField();

    diseaseField =
            new JTextField();

    JButton addBtn =
            new JButton(
                    "Add Patient");

    JButton updateBtn =
            new JButton(
                    "Update");

    JButton deleteBtn =
            new JButton(
                    "Delete");

    JButton searchBtn =
            new JButton(
                    "Search");

    addBtn.setBackground(primary);
  

    updateBtn.setBackground(success);


    deleteBtn.setBackground(danger);


    searchBtn.setBackground(primary);


    formPanel.add(
            new JLabel("Patient Name"));

    formPanel.add(nameField);

    formPanel.add(
            new JLabel("Disease"));

    formPanel.add(diseaseField);

    formPanel.add(addBtn);
    formPanel.add(updateBtn);
    formPanel.add(deleteBtn);
   // formPanel.add(searchBtn);

    topPanel.add(
            formPanel,
            BorderLayout.CENTER);

    add(
            topPanel,
            BorderLayout.NORTH);

    model =
            new DefaultTableModel();

    model.addColumn("Token");
    model.addColumn("Name");
    model.addColumn("Disease");
    model.addColumn("Status");

    table =
            new JTable(model);

    table.setRowHeight(30);

    table.setFont(
            new Font(
                    "Segoe UI",
                    Font.PLAIN,
                    13));

    table.getTableHeader()
            .setFont(
                    new Font(
                            "Segoe UI",
                            Font.BOLD,
                            14));

    JScrollPane scrollPane =
            new JScrollPane(table);

    add(
            scrollPane,
            BorderLayout.CENTER);

    JPanel bottomPanel =
            new JPanel(
                    new BorderLayout());

    bottomPanel.setBackground(
            background);

    JPanel controls =
            new JPanel();

    controls.setBackground(
            background);

    searchField =
            new JTextField(15);

    JButton sortBtn =
            new JButton("Sort");

    JButton serveBtn =
            new JButton("Serve Next");

    JButton saveBtn =
            new JButton("Save");

    JButton loadBtn =
            new JButton("Load");

    controls.add(new JLabel("Search"));

    controls.add(searchField);
    controls.add(searchBtn);
    controls.add(sortBtn);
    controls.add(serveBtn);
    controls.add(saveBtn);
    controls.add(loadBtn);

    statsLabel =
            new JLabel(
                    "Statistics");

    statsLabel.setBorder(
            new EmptyBorder(
                    10,
                    20,
                    10,
                    20));

    bottomPanel.add(
            controls,
            BorderLayout.NORTH);

    bottomPanel.add(
            statsLabel,
            BorderLayout.SOUTH);

    add(
            bottomPanel,
            BorderLayout.SOUTH);

    addBtn.addActionListener(
            e -> addPatient());

    updateBtn.addActionListener(
            e -> updatePatient());

    deleteBtn.addActionListener(
            e -> deletePatient());

    searchBtn.addActionListener(
            e -> searchPatient());

    sortBtn.addActionListener(
            e -> sortPatients());

    serveBtn.addActionListener(
            e -> servePatient());

    saveBtn.addActionListener(
            e -> savePatients());

    loadBtn.addActionListener(
            e -> loadPatients());

    setVisible(true);
}

private void addPatient() {

    String name =
            nameField
                    .getText()
                    .trim();

    String disease =
            diseaseField
                    .getText()
                    .trim();

    if (name.isEmpty()
            || disease.isEmpty()) {

        JOptionPane.showMessageDialog(
                this,
                "Fill all fields");

        return;
    }

    if (name.matches(".*\\d.*")) {

        JOptionPane.showMessageDialog(
                this,
                "Name cannot contain numbers");

        return;
    }

    Patient patient =
            new Patient(
                    tokenCounter++,
                    name,
                    disease,
                    "Waiting");

    patients.add(patient);

    queue.add(patient);

    refreshTable();

    clearFields();
}

private void updatePatient() {

    int row =
            table.getSelectedRow();

    if (row == -1) {

        JOptionPane.showMessageDialog(
                this,
                "Select a patient");

        return;
    }

    String disease =
            JOptionPane.showInputDialog(
                    this,
                    "Enter New Disease");

    if (disease != null
            && !disease.trim().isEmpty()) {

        patients.get(row)
                .setDisease(disease);

        refreshTable();
    }
}

private void deletePatient() {

    int row =
            table.getSelectedRow();

    if (row == -1) {

        JOptionPane.showMessageDialog(
                this,
                "Select a patient");

        return;
    }

    Patient patient =
            patients.get(row);

    patients.remove(patient);

    queue.remove(patient);

    refreshTable();
}

private Patient searchByToken(
        int token) {

    for (Patient p : patients) {

        if (p.getToken() == token) {

            return p;
        }
    }

    return null;
}

private Patient searchByName(String name) {

    for (Patient p : patients) {

        if (p.getName()
                .equalsIgnoreCase(name)) {

            return p;
        }
    }

    return null;
}

private void searchPatient() {

    String key =
            searchField
                    .getText()
                    .trim();

    if (key.isEmpty()) {

        JOptionPane.showMessageDialog(
                this,
                "Enter search value");

        return;
    }

    Patient patient = null;

    try {

        int token =
                Integer.parseInt(key);

        patient =
                searchByToken(token);

    } catch (Exception ex) {

        patient =
                searchByName(key);
    }

    if (patient == null) {

        JOptionPane.showMessageDialog(
                this,
                "Patient Not Found");

    } else {

        JOptionPane.showMessageDialog(
                this,
                patient.getDetails());
    }
}

private void sortPatients() {

    for (int i = 0; i < patients.size() - 1; i++) {

        for (int j = 0; j < patients.size() - i - 1; j++) {

            if (patients.get(j).getToken()
                    > patients.get(j + 1).getToken()) {

                Patient temp =
                        patients.get(j);

                patients.set(j,
                        patients.get(j + 1));

                patients.set(j + 1, temp);
            }
        }
    }

    refreshTable();
}

private void servePatient() {

    if (queue.isEmpty()) {

        JOptionPane.showMessageDialog(
                this,
                "No patients in queue");

        return;
    }

    Patient p =
            queue.poll();

    if (p != null) {

        p.setStatus("Served");
    }

    refreshTable();
}

private void savePatients() {

    FileManager.savePatients(patients);

    JOptionPane.showMessageDialog(
            this,
            "Data Saved Successfully");
}

private void loadPatients() {

    patients =
            FileManager.loadPatients();

    queue =
            new LinkedList<>();

    int maxToken = 100;

    for (Patient p : patients) {

        if (p.getStatus()
                .equalsIgnoreCase("Waiting")) {

            queue.add(p);
        }

        if (p.getToken() > maxToken) {

            maxToken = p.getToken();
        }
    }

    tokenCounter = maxToken + 1;

    refreshTable();

    JOptionPane.showMessageDialog(
            this,
            "Data Loaded Successfully");
}

private void refreshTable() {

    model.setRowCount(0);

    for (Patient p : patients) {

        model.addRow(new Object[]{
                p.getToken(),
                p.getName(),
                p.getDisease(),
                p.getStatus()
        });
    }

    updateStats();
}

private void updateStats() {

    long waiting =
            patients.stream()
                    .filter(p ->
                            p.getStatus()
                                    .equalsIgnoreCase("Waiting"))
                    .count();

    long served =
            patients.stream()
                    .filter(p ->
                            p.getStatus()
                                    .equalsIgnoreCase("Served"))
                    .count();

    statsLabel.setText(
            "Total Patients: " + patients.size()
                    + "   |   Waiting: " + waiting
                    + "   |   Served: " + served);
}

private void clearFields() {

    nameField.setText("");
    diseaseField.setText("");
}


}
