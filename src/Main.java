import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Main {

    // =========================
    // Student Class
    // =========================
    static class Student {

        int id;
        String name;
        double marks;

        Student(int id, String name, double marks) {
            this.id = id;
            this.name = name;
            this.marks = marks;
        }
    }

    // =========================
    // GradeTracker Class
    // =========================
    static class GradeTracker {

        ArrayList<Student> students = new ArrayList<>();

        public void addStudent(Student student) {
            students.add(student);
        }

        // SEARCH STUDENT BY ID
        public Student searchById(int id) {

            for (Student student : students) {

                if (student.id == id) {
                    return student;
                }
            }

            return null;
        }

        public double getAverage() {

            if (students.isEmpty()) {
                return 0;
            }

            double total = 0;

            for (Student student : students) {
                total += student.marks;
            }

            return total / students.size();
        }

        public double getHighest() {

            if (students.isEmpty()) {
                return 0;
            }

            double highest = students.get(0).marks;

            for (Student student : students) {

                if (student.marks > highest) {
                    highest = student.marks;
                }
            }

            return highest;
        }

        public double getLowest() {

            if (students.isEmpty()) {
                return 0;
            }

            double lowest = students.get(0).marks;

            for (Student student : students) {

                if (student.marks < lowest) {
                    lowest = student.marks;
                }
            }

            return lowest;
        }

        public int getTotalStudents() {
            return students.size();
        }
    }

    // =========================
    // Calculate Grade
    // =========================
    public static String calculateGrade(double marks) {

        if (marks >= 90) {
            return "A+";
        } else if (marks >= 80) {
            return "A";
        } else if (marks >= 70) {
            return "B";
        } else if (marks >= 60) {
            return "C";
        } else if (marks >= 50) {
            return "D";
        } else {
            return "F";
        }
    }

    // =========================
    // Main
    // =========================
    public static void main(String[] args) {

        GradeTracker tracker = new GradeTracker();

        JFrame frame = new JFrame("Student Grade Tracker");

        frame.setSize(950, 680);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // =========================
        // Main Panel
        // =========================
        JPanel panel = new JPanel();

        panel.setLayout(null);

        panel.setBackground(
                new Color(245, 247, 250)
        );

        // =========================
        // HEADER
        // =========================
        JPanel header = new JPanel();

        header.setLayout(null);

        header.setBackground(
                new Color(37, 99, 235)
        );

        header.setBounds(
                0, 0, 950, 75
        );

        panel.add(header);

        JLabel title =
                new JLabel("Student Grade Tracker");

        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        30
                )
        );

        title.setForeground(Color.WHITE);

        title.setBounds(
                30, 10, 400, 40
        );

        header.add(title);

        JLabel subtitle =
                new JLabel(
                        "Manage student grades and performance"
                );

        subtitle.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        14
                )
        );

        subtitle.setForeground(Color.WHITE);

        subtitle.setBounds(
                32, 45, 400, 20
        );

        header.add(subtitle);

        // =========================
        // INPUT PANEL
        // =========================
        JPanel inputPanel = new JPanel();

        inputPanel.setLayout(null);

        inputPanel.setBackground(Color.WHITE);

        inputPanel.setBorder(
                BorderFactory.createTitledBorder(
                        "Student Information"
                )
        );

        inputPanel.setBounds(
                30, 100, 320, 270
        );

        panel.add(inputPanel);

        // ID
        JLabel idLabel =
                new JLabel("Student ID");

        idLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        idLabel.setBounds(
                25, 35, 120, 25
        );

        inputPanel.add(idLabel);

        JTextField idField =
                new JTextField();

        idField.setBounds(
                25, 65, 270, 32
        );

        inputPanel.add(idField);

        // Name
        JLabel nameLabel =
                new JLabel("Student Name");

        nameLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        nameLabel.setBounds(
                25, 105, 120, 25
        );

        inputPanel.add(nameLabel);

        JTextField nameField =
                new JTextField();

        nameField.setBounds(
                25, 135, 270, 32
        );

        inputPanel.add(nameField);

        // Marks
        JLabel marksLabel =
                new JLabel("Marks");

        marksLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        marksLabel.setBounds(
                25, 175, 120, 25
        );

        inputPanel.add(marksLabel);

        JTextField marksField =
                new JTextField();

        marksField.setBounds(
                25, 200, 120, 32
        );

        inputPanel.add(marksField);

        // Add Button
        JButton addButton =
                new JButton("Add Student");

        addButton.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        addButton.setBackground(
                new Color(37, 99, 235)
        );

        addButton.setForeground(Color.WHITE);

        addButton.setFocusPainted(false);

        addButton.setBounds(
                160, 200, 135, 32
        );

        inputPanel.add(addButton);

        // =====================================================
        // SEARCH PANEL
        // =====================================================
        JPanel searchPanel = new JPanel();

        searchPanel.setLayout(null);

        searchPanel.setBackground(Color.WHITE);

        searchPanel.setBorder(
                BorderFactory.createTitledBorder(
                        "Search Student"
                )
        );

        searchPanel.setBounds(
                380, 100, 530, 70
        );

        panel.add(searchPanel);

        // Search Label
        JLabel searchLabel =
                new JLabel("Student ID:");

        searchLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        searchLabel.setBounds(
                15, 25, 90, 25
        );

        searchPanel.add(searchLabel);

        // Search Field
        JTextField searchField =
                new JTextField();

        searchField.setBounds(
                105, 23, 180, 30
        );

        searchPanel.add(searchField);

        // Search Button
        JButton searchButton =
                new JButton("Search");

        searchButton.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        13
                )
        );

        searchButton.setBackground(
                new Color(16, 185, 129)
        );

        searchButton.setForeground(Color.WHITE);

        searchButton.setFocusPainted(false);

        searchButton.setBounds(
                300, 23, 100, 30
        );

        searchPanel.add(searchButton);

        // Clear Button
        JButton clearButton =
                new JButton("Clear");

        clearButton.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        13
                )
        );

        clearButton.setBounds(
                410, 23, 90, 30
        );

        searchPanel.add(clearButton);

        // =========================
        // TABLE
        // =========================
        String[] columns = {
                "Student ID",
                "Student Name",
                "Marks",
                "Grade"
        };

        DefaultTableModel model =
                new DefaultTableModel(
                        columns,
                        0
                );

        JTable table =
                new JTable(model);

        table.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        14
                )
        );

        table.setRowHeight(30);

        table.getTableHeader().setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        table.getTableHeader().setBackground(
                new Color(
                        37, 99, 235
                )
        );

        table.getTableHeader().setForeground(
                Color.WHITE
        );

        table.setSelectionBackground(
                new Color(
                        219, 234, 254
                )
        );

        table.setSelectionForeground(
                Color.BLACK
        );

        JScrollPane scrollPane =
                new JScrollPane(table);

        // TABLE IS BELOW SEARCH
        scrollPane.setBounds(
                380, 185, 530, 185
        );

        panel.add(scrollPane);

        // =========================
        // SUMMARY PANEL
        // =========================
        JPanel summaryPanel =
                new JPanel();

        summaryPanel.setLayout(null);

        summaryPanel.setBackground(
                Color.WHITE
        );

        summaryPanel.setBorder(
                BorderFactory.createTitledBorder(
                        "Performance Summary"
                )
        );

        summaryPanel.setBounds(
                30, 395, 880, 180
        );

        panel.add(summaryPanel);

        // Total
        JLabel totalLabel =
                new JLabel(
                        "Total Students"
                );

        totalLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        15
                )
        );

        totalLabel.setBounds(
                40, 45, 180, 25
        );

        summaryPanel.add(totalLabel);

        JLabel totalValue =
                new JLabel("0");

        totalValue.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        22
                )
        );

        totalValue.setForeground(
                new Color(
                        37, 99, 235
                )
        );

        totalValue.setBounds(
                40, 75, 180, 35
        );

        summaryPanel.add(totalValue);

        // Average
        JLabel averageLabel =
                new JLabel(
                        "Average Marks"
                );

        averageLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        15
                )
        );

        averageLabel.setBounds(
                250, 45, 180, 25
        );

        summaryPanel.add(averageLabel);

        JLabel averageValue =
                new JLabel("0.00");

        averageValue.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        22
                )
        );

        averageValue.setForeground(
                new Color(
                        16, 185, 129
                )
        );

        averageValue.setBounds(
                250, 75, 180, 35
        );

        summaryPanel.add(averageValue);

        // Highest
        JLabel highestLabel =
                new JLabel(
                        "Highest Marks"
                );

        highestLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        15
                )
        );

        highestLabel.setBounds(
                470, 45, 180, 25
        );

        summaryPanel.add(highestLabel);

        JLabel highestValue =
                new JLabel("0");

        highestValue.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        22
                )
        );

        highestValue.setForeground(
                new Color(
                        245, 158, 11
                )
        );

        highestValue.setBounds(
                470, 75, 180, 35
        );

        summaryPanel.add(highestValue);

        // Lowest
        JLabel lowestLabel =
                new JLabel(
                        "Lowest Marks"
                );

        lowestLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        15
                )
        );

        lowestLabel.setBounds(
                690, 45, 150, 25
        );

        summaryPanel.add(lowestLabel);

        JLabel lowestValue =
                new JLabel("0");

        lowestValue.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        22
                )
        );

        lowestValue.setForeground(
                new Color(
                        239, 68, 68
                )
        );

        lowestValue.setBounds(
                690, 75, 150, 35
        );

        summaryPanel.add(lowestValue);

        // =====================================================
        // ADD STUDENT ACTION
        // =====================================================
        addButton.addActionListener(e -> {

            try {

                String idText =
                        idField.getText().trim();

                String name =
                        nameField.getText().trim();

                String marksText =
                        marksField.getText().trim();

                if (idText.isEmpty()
                        || name.isEmpty()
                        || marksText.isEmpty()) {

                    JOptionPane.showMessageDialog(
                            frame,
                            "Please fill all fields."
                    );

                    return;
                }

                int id =
                        Integer.parseInt(
                                idText
                        );

                double marks =
                        Double.parseDouble(
                                marksText
                        );

                if (marks < 0 || marks > 100) {

                    JOptionPane.showMessageDialog(
                            frame,
                            "Marks must be between 0 and 100."
                    );

                    return;
                }

                String grade =
                        calculateGrade(marks);

                Student student =
                        new Student(
                                id,
                                name,
                                marks
                        );

                tracker.addStudent(student);

                model.addRow(
                        new Object[]{
                                id,
                                name,
                                marks,
                                grade
                        }
                );

                // UPDATE SUMMARY

                totalValue.setText(
                        String.valueOf(
                                tracker.getTotalStudents()
                        )
                );

                averageValue.setText(
                        String.format(
                                "%.2f",
                                tracker.getAverage()
                        )
                );

                highestValue.setText(
                        String.valueOf(
                                tracker.getHighest()
                        )
                );

                lowestValue.setText(
                        String.valueOf(
                                tracker.getLowest()
                        )
                );

                JOptionPane.showMessageDialog(
                        frame,
                        "Student added successfully!"
                );

                idField.setText("");
                nameField.setText("");
                marksField.setText("");

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                        frame,
                        "ID and Marks must be numbers."
                );
            }
        });

        // =====================================================
        // SEARCH ACTION
        // =====================================================
        searchButton.addActionListener(e -> {

            String searchText =
                    searchField.getText().trim();

            if (searchText.isEmpty()) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Please enter Student ID."
                );

                return;
            }

            try {

                int searchId =
                        Integer.parseInt(
                                searchText
                        );

                Student foundStudent =
                        tracker.searchById(
                                searchId
                        );

                if (foundStudent != null) {

                    JOptionPane.showMessageDialog(
                            frame,
                            "Student Found!\n\n"
                            + "Student ID: "
                            + foundStudent.id
                            + "\nStudent Name: "
                            + foundStudent.name
                            + "\nMarks: "
                            + foundStudent.marks
                            + "\nGrade: "
                            + calculateGrade(
                                    foundStudent.marks
                            )
                    );

                    // Select the student in table
                    for (
                            int i = 0;
                            i < model.getRowCount();
                            i++
                    ) {

                        int tableId =
                                Integer.parseInt(
                                        model.getValueAt(
                                                i,
                                                0
                                        ).toString()
                                );

                        if (tableId == searchId) {

                            table.setRowSelectionInterval(
                                    i,
                                    i
                            );

                            table.scrollRectToVisible(
                                    table.getCellRect(
                                            i,
                                            0,
                                            true
                                    )
                            );

                            break;
                        }
                    }

                } else {

                    JOptionPane.showMessageDialog(
                            frame,
                            "Student with ID "
                            + searchId
                            + " not found."
                    );
                }

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Student ID must be a number."
                );
            }
        });

        // =====================================================
        // CLEAR SEARCH
        // =====================================================
        clearButton.addActionListener(e -> {

            searchField.setText("");

            table.clearSelection();
        });

        // =========================
        // ADD PANEL TO FRAME
        // =========================
        frame.add(panel);

        frame.setVisible(true);
    }
}

