/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.gymproject;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * @author Haneen
 */
public class LoginPagee extends javax.swing.JFrame {

    /**
     * Creates new form LoginPagee
     */
    public LoginPagee() {
        initComponents();
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowOpened(java.awt.event.WindowEvent evt) {
                getContentPane().requestFocusInWindow();
            }

        });
        jComboBox1.setRenderer(new javax.swing.plaf.basic.BasicComboBoxRenderer() {
            @Override
            public java.awt.Component getListCellRendererComponent(javax.swing.JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                java.awt.Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                list.setSelectionBackground(Color.decode("#6E54B5"));
                list.setSelectionForeground(Color.WHITE);
                list.setBackground(Color.decode("#3B364C"));
                list.setForeground(Color.decode("#7E7A8B"));
                if (c instanceof javax.swing.JLabel) {
                    ((javax.swing.JLabel) c).setOpaque(true);
                    ((javax.swing.JLabel) c).setBackground(isSelected ? Color.decode("#6E54B5") : Color.decode("#3B364C")); // تغيير لون العنصر المحدد
                    ((javax.swing.JLabel) c).setForeground(isSelected ? Color.WHITE : Color.decode("#7E7A8B")); // النص
                }
                return c;
            }
        });


        getContentPane().setBackground(Color.decode("#2B2738"));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        //this.setSize(1440,1024);
        setVisible(true);
        jLabel2.setVisible(false);
        jLabel1.setForeground(Color.decode("#FCFCFA"));
        jLabel3.setSize(684, 940);

        jTextField1.setBackground(Color.decode("#3B364C"));
        jPasswordField1.setBackground(Color.decode("#3B364C"));
        jComboBox1.setBackground(Color.decode("#3B364C"));
        jCheckBox1.setBackground(Color.decode("#2B2738"));
        jButton2.setBackground(Color.decode("#6E54B5"));
        jTextField1.setForeground(Color.decode("#7E7A8B"));
        jCheckBox1.setForeground(Color.decode("#7E7A8B"));
        jButton2.setForeground(Color.decode("#FCFCFA"));
        jPasswordField1.setText(" Enter Password");
        jPasswordField1.setForeground(Color.decode("#7E7A8B"));
        jPasswordField1.setEchoChar((char) 0);
        jPasswordField1.setFont(new java.awt.Font("Segoe UI", 1, 18));
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 51, 204));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Welcome Back!");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 100, 410, 60));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 0, 0));
        jLabel2.setText("incorrect username or password");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 400, 345, 30));

        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTextField1.setText("  Enter Username");
        jTextField1.setBorder(null);
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField1FocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField1FocusLost(evt);
            }
        });
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 210, 338, 40));

        jComboBox1.setBackground(new java.awt.Color(152, 18, 18));
        jComboBox1.setEditable(true);
        jComboBox1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Select Department", "Admin", "Customer", "Trainer", "TrainerManager", "CustomerManager", "ScheduleManager", "EquipmentManager"}));
        jComboBox1.setBorder(null);
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 310, 170, 40));
        jComboBox1.getAccessibleContext().setAccessibleName("");

        jCheckBox1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jCheckBox1.setText("show password");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 360, -1, 40));

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setText("Login");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButton2ActionPerformed(evt);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 510, 340, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/5967541068914345023.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -270, 750, 1230));

        jPasswordField1.setText("  Enter Password");
        jPasswordField1.setBorder(null);
        jPasswordField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPasswordField1FocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                jPasswordField1FocusLost(evt);
            }
        });
        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 260, 338, 40));

        pack();
    }// </editor-fold>                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        // TODO add your handling code here:
        String role = (String) jComboBox1.getSelectedItem();
        String username = jTextField1.getText().trim();
        String password = new String(jPasswordField1.getPassword()).trim();
        jLabel2.setVisible(false);
        if (username.equals("Enter Username") || password.equals("Enter Password") || username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields before logging in!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (role.equals("Admin")) {
            if (isAdminRegistered()) {
                // Validate existing Admin credentials
                if (validateCredentials(role, username, password)) {
                    //messageLabel.setText("Login successful! Redirecting to Admin page...");
                    this.dispose();
                    openAdminPage();
                } else {
                    jLabel2.setText("Incorrect Admin credentials.");
                    jLabel2.setVisible(true);
                }
            } else {
                // Register Admin
                registerAdmin(username, password);
                JOptionPane.showMessageDialog(this, "Admin registered successfully! Please log in again.", "Success", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                new LoginPagee(); // Restart login page
            }
        } else if (role.equals("CustomerManager")) {
            if (validateCredentials(role, username, password)) {
                this.dispose();
                openCustomerManagerPage();
            } else {
                jLabel2.setText("Incorrect username or password.");
                jLabel2.setVisible(true);
            }
        } else if (role.equals("TrainerManager")) {
            if (validateCredentials(role, username, password)) {
                this.dispose();
                openTrainerManagerPage();
            } else {
                jLabel2.setText("Incorrect username or password.");
                jLabel2.setVisible(true);
            }
        } else if (role.equals("ScheduleManager")) {
            if (validateCredentials(role, username, password)) {
                this.dispose();
                openScheduleManager();
            } else {
                jLabel2.setText("Incorrect username or password.");
                jLabel2.setVisible(true);
            }

        } else if (role.equals("EquipmentManager")) {
            if (validateCredentials(role, username, password)) {
                this.dispose();
                openEquipmentManager();
            } else {
                jLabel2.setText("Incorrect username or password.");
                jLabel2.setVisible(true);
            }
        } else if (role.equals("Trainer")) {
            if (validateCredentials(role, username, password)) {
                String id = getUserId(role, username, password);
                this.dispose();
                openTrainerPage(id);
            } else {
                jLabel2.setText("Incorrect username or password.");
                jLabel2.setVisible(true);
            }
        } else if (role.equals("Customer")) {
            if (validateCredentials(role, username, password)) {
                String id = getUserId(role, username, password);
                this.dispose();
                openCustomerPage(id);
            } else {
                jLabel2.setText("Incorrect username or password.");
                jLabel2.setVisible(true);
            }
        } else {
            jLabel2.setText("Invalid role selected.");
            jLabel2.setVisible(true);
        }


    }


    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField1FocusGained(java.awt.event.FocusEvent evt) {
        // Hide the label when the text field gains focus
        jLabel2.setVisible(false);

        // If the text field contains the placeholder text ("Enter Username")
        if (jTextField1.getText().trim().equalsIgnoreCase("Enter Username")) {
            jTextField1.setText(""); // Clear the placeholder text
            jTextField1.setForeground(new Color(255, 255, 255)); // Change the text color to white
        }
    }

    private void jTextField1FocusLost(java.awt.event.FocusEvent evt) {
        // Hide the label when the text field loses focus
        jLabel2.setVisible(false);

        // If the text field is empty, restore the placeholder text
        if (jTextField1.getText().trim().isEmpty()) {
            jTextField1.setText(" Enter Username"); // Set the default placeholder text
            jTextField1.setForeground(new Color(153, 153, 153)); // Set the default text color
        }
    }

    private void jPasswordField1FocusGained(java.awt.event.FocusEvent evt) {
        // Hide the label when the password field gains focus
        jLabel2.setVisible(false);

        // If the password field contains the default text ("Enter Password")
        if (new String(jPasswordField1.getPassword()).trim().equalsIgnoreCase("Enter Password")) {
            jPasswordField1.setText(""); // Clear the placeholder text
            jPasswordField1.setForeground(new Color(255, 255, 255)); // Change the text color to white
            jPasswordField1.setEchoChar('*'); // Enable password masking with asterisks
        }
    }

    private void jPasswordField1FocusLost(java.awt.event.FocusEvent evt) {
        // Hide the label when the password field loses focus
        jLabel2.setVisible(false);

        // If the password field is empty, restore the placeholder text
        if (new String(jPasswordField1.getPassword()).trim().isEmpty()) {
            jPasswordField1.setText("Enter Password"); // Set the default placeholder text
            jPasswordField1.setForeground(Color.decode("#7E7A8B")); // Set the default text color
            jPasswordField1.setEchoChar((char) 0); // Disable password masking (no asterisk)
        }
    }


    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        // Check if the checkbox is selected
        if (jCheckBox1.isSelected()) {
            // If selected, show the password as plain text
            jPasswordField1.setEchoChar((char) 0);  // Disable echo char to show plain text

            // You can also change the text field's font color to indicate that it's visible
            jPasswordField1.setForeground(Color.BLACK);
        } else {
            // If not selected, hide the password again
            jPasswordField1.setEchoChar('*');  // Reset to '*' character to hide password

            // Optionally change the font color back to gray
            jPasswordField1.setForeground(new Color(153, 153, 153));
        }
    }

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }


    //method checks if the admin is already registered by reading from a file.
    private boolean isAdminRegistered() {
        try (BufferedReader reader = new BufferedReader(new FileReader("myDirectory/login.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Admin,")) {
                    return true; // Admin is already registered
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false; // Admin is not registered
    }

    //method writes the new admin's username and password to a file to register them.
    private void registerAdmin(String username, String password) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("myDirectory/login.txt", true))) {
            writer.write("Admin," + username + "," + password); // Register the admin with the given username and password
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //method verifies if the provided credentials (role, username, and password) match any record in the file.
    private boolean validateCredentials(String role, String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader("myDirectory/login.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if ((parts.length == 3 || parts.length == 4) && parts[0].equals(role) && parts[1].equals(username) && parts[2].equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private String getUserId(String role, String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader("myDirectory/login.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4 && parts[0].equals(role) && parts[1].equals(username) && parts[2].equals(password)) {
                    return parts[3]; // Return user id
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; // If user is not found
    }


    private void openAdminPage() {
        new AdminPage(); // Open Admin page
    }

    private void openCustomerManagerPage() {
        new CustomerManagerPagee();
    }

    private void openTrainerManagerPage() {
        new TrainerManagerPagee();
    }

    private void openScheduleManager() {
        new SchedulerManagerPagee();
    }

    private void openEquipmentManager() {
        new EquipmenentApp();
    }


    private void openTrainerPage(String id) throws IOException {
        new TrainerPage(id);
    }

    private void openCustomerPage(String id) throws IOException {
        new CustomerPage(id);
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration                   
}
