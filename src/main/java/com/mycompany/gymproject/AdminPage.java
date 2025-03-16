package com.mycompany.gymproject;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class AdminPage {

    private static JFrame adminFrame;
    private static JPanel cardPanel;
    private static CardLayout cardLayout;
    private static FileHandler f = new FileHandler("myDirectory");
    private static String filename = "login.txt";

    public AdminPage() {
        // Create frame for Admin Dashboard

        adminFrame = new JFrame("Admin Page");
        adminFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminFrame.setSize(1000, 600);
        adminFrame.setLocationRelativeTo(null); // Center the frame

        // Set CardLayout for the frame
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        cardPanel.setBackground(new Color(43, 39, 56)); // Background color for the card panel

        // Create sidebar panel (left side navigation)
        JPanel sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setBackground(new Color(43, 39, 56)); // #2B2738
        sidebar.setPreferredSize(new Dimension(250, 0));

        // Adding the image to the sidebar
        ImageIcon img = new ImageIcon(getClass().getResource("/admin.png"));
        Image scaledImage = img.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        JLabel iconLabel = new JLabel(new ImageIcon(scaledImage));
        iconLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add the image to the sidebar
        sidebar.add(Box.createRigidArea(new Dimension(0, 20))); // Top spacing
        sidebar.add(iconLabel);
        sidebar.add(Box.createRigidArea(new Dimension(0, 20)));

        // Add navigation buttons
        Color buttonColor = new Color(0x6E54B5); // Updated button color
        JButton addManagerButton = createButton("Add Manager", buttonColor);
        JButton deleteManagerButton = createButton("Delete Manager", buttonColor);

        JButton logoutButton = createButton("Logout", buttonColor); // Logout button with a different color
        // Add buttons to sidebar
        sidebar.add(addManagerButton);
        sidebar.add(Box.createRigidArea(new Dimension(0, 20)));
        sidebar.add(deleteManagerButton);
        sidebar.add(Box.createRigidArea(new Dimension(0, 20)));
        sidebar.add(logoutButton);

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(null, "Do you really want to Logout?", "Select", JOptionPane.YES_NO_OPTION);
                if (a == 0) {
                    adminFrame.setVisible(false); // Close Admin Page
                    new LoginPagee().setVisible(true); // Open Login Page
                }
            }
        });

        // Create the main content panel for the cards
        JPanel addManagerCard = createAddManagerCard();
        JPanel deleteManagerCard = createDeleteManagerCard();

        // Add the cards to the card panel
        cardPanel.add(addManagerCard, "AddManager");
        cardPanel.add(deleteManagerCard, "DeleteManager");

        // Add sidebar and card panel to the frame
        adminFrame.add(sidebar, BorderLayout.WEST);
        adminFrame.add(cardPanel, BorderLayout.CENTER);

        // Display the Admin window
        adminFrame.setVisible(true);

        // Add action listeners for buttons
        addManagerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "AddManager");
            }
        });

        deleteManagerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "DeleteManager");
            }
        });
    }

    // Create buttons with hover effect
    private static JButton createButton(String text, Color backgroundColor) {
        JButton button = new JButton(text);
        button.setBackground(backgroundColor);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Add hover effect
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(button.getBackground().darker());
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(backgroundColor);
            }
        });
        return button;
    }

    // Create the Add Manager page (Card)
    private static JPanel createAddManagerCard() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout()); // استخدم GridBagLayout
        panel.setBackground(new Color(43, 39, 56)); // #2B2738

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // المسافات بين العناصر
        gbc.fill = GridBagConstraints.HORIZONTAL; // جعل المكونات تتمدد أفقيًا

        JLabel nameLabel = new JLabel("Manager Name:");
        JTextField nameField = createCustomTextField();
        JLabel phoneLabel = new JLabel("Phone:");
        JTextField phoneField = createCustomTextField();
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = createCustomTextField();
        JLabel ageLabel = new JLabel("Age:");
        JTextField ageField = createCustomTextField();
        JLabel salaryLabel = new JLabel("Salary:");
        JTextField salaryField = createCustomTextField();
        JLabel hiringDateLabel = new JLabel("Hiring Date (YYYY-MM-DD):");
        JTextField hiringDateField = createCustomTextField();
        JLabel departmentLabel = new JLabel("Department:");
        String[] departments = {"CustomerManager", "TrainerManager", "EquipmentManager", "ScheduleManager"};
        JComboBox<String> departmentComboBox = new JComboBox<>(departments);

        // Style ComboBox
        departmentComboBox.setBackground(new Color(59, 54, 76));
        departmentComboBox.setForeground(new Color(126, 122, 139));
        departmentComboBox.setFont(new Font("Arial", Font.BOLD, 14));

        JButton addButton = createButton("Add Manager", new Color(0x6E54B5));

        // Adjust sizes of components
        Dimension textFieldSize = new Dimension(200, 30);
        nameField.setPreferredSize(textFieldSize);
        phoneField.setPreferredSize(textFieldSize);
        emailField.setPreferredSize(textFieldSize);
        ageField.setPreferredSize(textFieldSize);
        salaryField.setPreferredSize(textFieldSize);
        hiringDateField.setPreferredSize(textFieldSize);

        Dimension buttonSize = new Dimension(150, 40);
        addButton.setPreferredSize(buttonSize);

        // Set foreground color for labels
        nameLabel.setForeground(Color.WHITE);
        phoneLabel.setForeground(Color.WHITE);
        emailLabel.setForeground(Color.WHITE);
        ageLabel.setForeground(Color.WHITE);
        salaryLabel.setForeground(Color.WHITE);
        hiringDateLabel.setForeground(Color.WHITE);
        departmentLabel.setForeground(Color.WHITE);

        // Add components to the panel using GridBagConstraints
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(nameLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(nameField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(phoneLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(phoneField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(emailLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(emailField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(ageLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(ageField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(salaryLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(salaryField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(hiringDateLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 5;
        panel.add(hiringDateField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(departmentLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 6;
        panel.add(departmentComboBox, gbc);
        gbc.gridx = 1;
        gbc.gridy = 7;
        panel.add(addButton, gbc);

        // Action listener to add manager details

// Action listener to add manager details
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String managerName = nameField.getText().trim();
                String phone = phoneField.getText().trim();
                String email = emailField.getText().trim();
                String ageText = ageField.getText().trim();
                String salaryText = salaryField.getText().trim();
                String hiringDate = hiringDateField.getText().trim();
                String department = (String) departmentComboBox.getSelectedItem();

                // Check if any field is empty
                if (managerName.isEmpty() || phone.isEmpty() || email.isEmpty() || ageText.isEmpty() || salaryText.isEmpty() || hiringDate.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "All fields are required. Please fill in all fields!", "error", JOptionPane.ERROR_MESSAGE);
                    return; // Stop the process if any field is empty
                }

                try {
                    int age = Integer.parseInt(ageText);
                    double salary = Double.parseDouble(salaryText);

                    // Save the new manager data to a file
                    saveManagerData(managerName, phone, email, age, salary, hiringDate, department);
                    String[] s = new FileHandler("myDirectory").readLastLine("login.txt").split(",");
                    JOptionPane.showMessageDialog(null, "Manager added successfully!\nand username =" + s[1] + " , password=" + s[2]);
                    nameField.setText("");
                    phoneField.setText("");
                    emailField.setText("");
                    ageField.setText("");
                    salaryField.setText("");
                    hiringDateField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter valid values for age and salary!", "error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        return panel;
    }

    private static JTextField createCustomTextField() {
        JTextField textField = new JTextField();
        textField.setBackground(new Color(59, 54, 76)); // #3B364C
        textField.setForeground(new Color(126, 122, 139)); // #7E7A8B
        textField.setFont(new Font("Arial", Font.BOLD, 14));
        textField.setSize(55, 15);
        return textField;
    }

    // Create the Delete Manager page (Card)
    private static JPanel createDeleteManagerCard() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(43, 39, 56)); // #2B2738
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));  // FlowLayout for horizontal alignment
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel idLabel = new JLabel("Manager ID:");
        idLabel.setForeground(Color.WHITE);
        JTextField idField = new JTextField(15);  // Set width of the text field
        JButton deleteButton = createButton("Delete", new Color(0x6E54B5));

        // Add components to the panel
        panel.add(idLabel);
        panel.add(idField);
        panel.add(deleteButton);

        // Action listener for Delete button
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (idField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter a Manager ID!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (Manager.search_Manager_by_id(idField.getText())) {
                    Manager.delete_Manager(idField.getText());
                    JOptionPane.showMessageDialog(null, "Manager deleted!");
                } else {
                    JOptionPane.showMessageDialog(null, "Manager by this ID not found!");
                }
            }
        });

        return panel;
    }

    // Save manager data to a file (simplified for this example)
    private static void saveManagerData(String name, String phone, String email, int age, double salary, String hiringDate, String department) {
        if (department.equals("CustomerManager")) {
            Manager.add_Manager(new CustomerManager(name, phone, email, age, salary, hiringDate));
            saveRandomCredentials(department);
        } else if (department.equals("TrainerManager")) {
            Manager.add_Manager(new TrainerManager(name, phone, email, age, salary, hiringDate));
            saveRandomCredentials(department);
        } else if (department.equals("EquipmentManager")) {
            Manager.add_Manager(new EquipmentManager(name, phone, email, age, salary, hiringDate));
            saveRandomCredentials(department);
        } else if (department.equals("ScheduleManager")) {
            Manager.add_Manager(new ScheduleManager(name, phone, email, age, salary, hiringDate));
            saveRandomCredentials(department);
        }
    }

    private static String generateRandomUsername() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder username = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(characters.length());
            username.append(characters.charAt(index));
        }
        return username.toString();
    }

    private static String generateRandomPassword() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*";
        Random random = new Random();
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int index = random.nextInt(characters.length());
            password.append(characters.charAt(index));
        }
        return password.toString();
    }

    // Save random username and password to file
    private static void saveRandomCredentials(String role) {
        String username = generateRandomUsername();
        String password = generateRandomPassword();

        String s = "\n" + role + "," + username + "," + password;
        f.appendToFile(filename, s);
    }
}
