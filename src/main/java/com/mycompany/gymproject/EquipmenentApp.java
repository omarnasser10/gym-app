package com.mycompany.gymproject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class EquipmenentApp extends javax.swing.JFrame {
 private EquipmentManager equipmentManager=new EquipmentManager();;
    /**
     * Creates new form EqyipmntManagerPage
     */
    public EquipmenentApp (){
         equipmentManager = new EquipmentManager();
        initComponents();
        this.setVisible(true);
        // Set background color of JFrame
        this.getContentPane().setBackground(Color.decode("#2B2738"));

        // Set the menu bar background color after initializing the UI components
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                jMenuBar1.setBackground(Color.decode("#6E54B5"));
            }
        });

        // Maximize the window
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(43, 39, 56));
        jPanel1.setForeground(new java.awt.Color(255, 51, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Welcome to Equipment Manager Page");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(275, 275, 275)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 969, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(302, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(296, 296, 296)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(477, Short.MAX_VALUE))
        );

        // Setting the JMenuBar's properties
        jMenuBar1.setBackground(Color.decode("#6E54B5"));
        jMenuBar1.setBorder(null);
        jMenuBar1.setForeground(new java.awt.Color(51, 0, 51));
        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jMenuBar1.setPreferredSize(new java.awt.Dimension(1198, 40));

        jMenu1.setText("Add Equipment");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Delete Equipment");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Update equipment");
        jMenu3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        jMenu4.setText("search equipment");
        jMenu4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu4);

        jMenu5.setText("Show Equipment");
        jMenu5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu5MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu5);

     
   

        jMenu7.setText("Logout");
        jMenu7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jMenu7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu7MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu7);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void jMenu7MouseClicked(java.awt.event.MouseEvent evt) {                                      
        int a=JOptionPane.showConfirmDialog(null, "Do you really want to Logout?", "Select", JOptionPane.YES_NO_OPTION);
        if(a == 0) {
            setVisible(false);
            new LoginPagee().setVisible(true);
        }
    }

  

    private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {                                      
        // Handle Show Exercise Plan by Id logic
        ShowEquipmentWindow show=new ShowEquipmentWindow(equipmentManager);
    }

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {                                      
        // Handle Show Membership by Id logic
        SearchEquipmentWindow serach=new SearchEquipmentWindow(equipmentManager);
    }

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {                                      
        // Handle Show Customer by Id logic
        UpdateEquipmentWindow update=new UpdateEquipmentWindow(equipmentManager);
    }

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {                                      
        // Handle Delete Customer logic
        DeleteEquipmentWindow delete=new DeleteEquipmentWindow(equipmentManager);
    }

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {                                      
        // Handle Add Customer logic
        AddEquipmentWindow add= new AddEquipmentWindow( equipmentManager);
    }

public class AddEquipmentWindow {
    private JFrame frame;
    private JTextField nameField;
    private JCheckBox availabilityCheckBox;
    private EquipmentManager equipmentManager;

    public AddEquipmentWindow(EquipmentManager equipmentManager) {
        this.equipmentManager = equipmentManager;

        frame = new JFrame("Add Equipment");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Set background color of the frame
        frame.getContentPane().setBackground(new Color(0x2B2738));  // #2B2738 color

        // Set up GroupLayout
        GroupLayout layout = new GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);

        // Create labels and components
        JLabel nameLabel = new JLabel("Equipment Name:");
        nameLabel.setForeground(Color.WHITE);
        nameField = new JTextField();
        nameField.setBackground(new Color(0x3B364C));
        nameField.setForeground(Color.WHITE);
        nameField.setPreferredSize(new Dimension(200, 30));

        JLabel availabilityLabel = new JLabel("Is Available:");
        availabilityLabel.setForeground(Color.WHITE);
        availabilityCheckBox = new JCheckBox();
        availabilityCheckBox.setBackground(new Color(0x3B364C));
        availabilityCheckBox.setForeground(Color.WHITE);

        // Add button to submit the equipment
        JButton addButton = new JButton("Add Equipment");
        addButton.setBackground(new Color(0x6E54B5));
        addButton.setForeground(new Color(0xFCFCFA));
        addButton.setPreferredSize(new Dimension(150, 40));
        addButton.addActionListener(e -> addEquipment());

        // Arrange components using GroupLayout
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        // Set the layout for horizontal grouping
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(nameLabel)
                .addComponent(nameField)
                .addComponent(availabilityLabel)
                .addComponent(availabilityCheckBox)
                .addComponent(addButton)
        );

        // Set the layout for vertical grouping
        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addComponent(nameLabel)
                .addComponent(nameField)
                .addComponent(availabilityLabel)
                .addComponent(availabilityCheckBox)
                .addComponent(addButton)
        );

        frame.pack();
        frame.setVisible(true);
            frame.setLocationRelativeTo(null);
    }

   
    private void addEquipment() {
        String name = nameField.getText();
        boolean isAvailable = availabilityCheckBox.isSelected();

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Equipment name must be filled!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Equipment equipment = new Equipment(name, isAvailable);
        equipmentManager.add(equipment);
        JOptionPane.showMessageDialog(frame, "Equipment added successfully!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
        frame.dispose(); // Close the window after adding
    }
}

// Class for searching equipment
public class SearchEquipmentWindow {
    private JFrame frame;
    private JTextField searchIdField;
    private EquipmentManager equipmentManager;

    public SearchEquipmentWindow(EquipmentManager equipmentManager) {
        this.equipmentManager = equipmentManager;

        frame = new JFrame("Search Equipment");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Set the background color of the frame
        frame.getContentPane().setBackground(new Color(0x2B2738));  // color #2B2738

        // Set up FlowLayout to align components in the center
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 10, 10);
        JPanel panel = new JPanel(flowLayout);
        panel.setBackground(new Color(0x2B2738));  // Set the JPanel background to the same color
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Create labels and text fields
        JLabel idLabel = new JLabel("Equipment ID:");
        idLabel.setForeground(Color.WHITE); // Set the label text color

        searchIdField = new JTextField();
        searchIdField.setBackground(new Color(0x3B364C)); // Set the background of the text field to #3B364C
        searchIdField.setForeground(Color.WHITE); // Set the text color inside the text field
        searchIdField.setPreferredSize(new Dimension(150, 30)); // Set the size

        JButton searchButton = new JButton("Search");
        searchButton.setBackground(new Color(0x6E54B5)); // Set the button background color
        searchButton.setForeground(new Color(0xFCFCFA)); // Set the text color inside the button
        searchButton.setPreferredSize(new Dimension(100, 30)); // Set the size
        searchButton.addActionListener(e -> searchEquipment());

        // Add components to the JPanel
        panel.add(idLabel);
        panel.add(searchIdField);
        panel.add(searchButton);
        panel.add(new JLabel()); // Empty placeholder

        // Add the JPanel to the JFrame
        frame.add(panel);

        // Set the frame size to fit the components
        frame.pack(); // Adjust size automatically according to content
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(true);
    }
    private void searchEquipment() {
        String id = searchIdField.getText();
         try {
            int eqId = Integer.parseInt(id);
        if (equipmentManager.search_by_id(id)) {
            JOptionPane.showMessageDialog(frame, "Equipment with ID " + id + " found!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(frame, "Equipment with ID " + id + " not found!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        frame.dispose(); // Close the window after searching
         }catch (NumberFormatException e) {
            // Handle the error if IDs are not valid integers
            JOptionPane.showMessageDialog(frame, "Equipment ID must be valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

// Class for updating equipment
public class UpdateEquipmentWindow {
    private JFrame frame;
    private JTextField updateIdField, newNameField;
    private JCheckBox availabilityCheckBox;
    private EquipmentManager equipmentManager;

    public UpdateEquipmentWindow(EquipmentManager equipmentManager) {
        this.equipmentManager = equipmentManager;

        // Create the frame for Update Equipment window
        frame = new JFrame("Update Equipment");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Set the background color of the frame
        frame.getContentPane().setBackground(new Color(0x2B2738));  // color #2B2738

        // Set up GroupLayout
        GroupLayout layout = new GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);

        // Create the labels and text fields for Equipment ID, New Name, and Availability
        JLabel updateIdLabel = new JLabel("Equipment ID:");
        updateIdLabel.setForeground(Color.WHITE);
        updateIdField = new JTextField();
        updateIdField.setBackground(new Color(0x3B364C));
        updateIdField.setForeground(Color.WHITE);
        updateIdField.setPreferredSize(new Dimension(200, 30));

        JLabel newNameLabel = new JLabel("New Name:");
        newNameLabel.setForeground(Color.WHITE);
        newNameField = new JTextField();
        newNameField.setBackground(new Color(0x3B364C));
        newNameField.setForeground(Color.WHITE);
        newNameField.setPreferredSize(new Dimension(200, 30));

        JLabel availabilityLabel = new JLabel("Is Available:");
        availabilityLabel.setForeground(Color.WHITE);
        availabilityCheckBox = new JCheckBox();
        availabilityCheckBox.setBackground(new Color(0x2B2738));

        // Create the Update button
        JButton updateButton = new JButton("Update Equipment");
        updateButton.setBackground(new Color(0x6E54B5));
        updateButton.setForeground(new Color(0xFCFCFA));
        updateButton.setPreferredSize(new Dimension(150, 40));
        updateButton.addActionListener(e -> updateEquipment());

        // Set up the layout for components
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        // Organize the components vertically
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(updateIdLabel)
                .addComponent(updateIdField)
                .addComponent(newNameLabel)
                .addComponent(newNameField)
                .addComponent(availabilityLabel)
                .addComponent(availabilityCheckBox)
                .addComponent(updateButton)
        );

        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addComponent(updateIdLabel)
                .addComponent(updateIdField)
                .addComponent(newNameLabel)
                .addComponent(newNameField)
                .addComponent(availabilityLabel)
                .addComponent(availabilityCheckBox)
                .addComponent(updateButton)
        );

        // Set the frame size and center it on the screen
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void updateEquipment() {
        String id = updateIdField.getText();
        String newName = newNameField.getText().isEmpty() ? null : newNameField.getText();
        String newIsAvail = availabilityCheckBox.isSelected() ? "true" : "false"; // Convert boolean to String

        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Equipment ID must be filled!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            int Id = Integer.parseInt(id);
             if (!equipmentManager.search_by_id("" + Id)) {
                JOptionPane.showMessageDialog(frame, "Schedule ID not found", "Error", JOptionPane.ERROR_MESSAGE);
            }else {
        equipmentManager.update(Id, newName, newIsAvail);
        JOptionPane.showMessageDialog(frame, "Equipment updated successfully!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
        updateIdField.setText("");
                updateIdField.setText("");
                newNameField.setText("");
                availabilityCheckBox.setSelected(false); // el mafrod te3mel uncheck

                }
        
             }catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Equipment ID must be a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        frame.dispose(); // Close the window after updating
        }
    }


// Class for deleting equipment
public class DeleteEquipmentWindow {
    private JFrame frame;
    private JTextField deleteIdField;
    private EquipmentManager equipmentManager;

    public DeleteEquipmentWindow(EquipmentManager equipmentManager) {
        this.equipmentManager = equipmentManager;

        // Create the frame for Delete Equipment window
        frame = new JFrame("Delete Equipment");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);

        // Set the background color of the frame
        frame.getContentPane().setBackground(new Color(0x2B2738));  // color #2B2738

        // Create JPanel and set up the layout
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10)); // Use FlowLayout to arrange components
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add padding to the panel
        panel.setBackground(new Color(0x2B2738)); // Set the background color of the panel

        // Create the label and text field for Equipment ID
        JLabel idLabel = new JLabel("Equipment ID:");
        idLabel.setForeground(Color.WHITE); // Set the label text color

        deleteIdField = new JTextField();
        deleteIdField.setBackground(new Color(0x3B364C)); // Set the background color of the text field
        deleteIdField.setForeground(Color.WHITE); // Set the text color inside the text field
        deleteIdField.setPreferredSize(new Dimension(150, 30)); // Set the preferred size of the text field

        // Create the delete button
        JButton deleteButton = new JButton("Delete");
        deleteButton.setBackground(new Color(0x6E54B5)); // Set the button background color
        deleteButton.setForeground(new Color(0xFCFCFA)); // Set the text color inside the button
        deleteButton.setPreferredSize(new Dimension(100, 30)); // Set the preferred size of the button
        deleteButton.addActionListener(e -> deleteEquipment()); // Add action listener to delete equipment

        // Add components to the JPanel
        panel.add(idLabel);
        panel.add(deleteIdField);
        panel.add(deleteButton);

        // Add the JPanel to the JFrame
        frame.add(panel);

        // Center the frame on the screen
        frame.setLocationRelativeTo(null);

        // Set the frame visibility
        frame.setVisible(true);
        frame.pack();
    }
    private void deleteEquipment() {
        String id = deleteIdField.getText();
        try{
            int eqId = Integer.parseInt(id);
            if (id.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "ID field must be filled!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            equipmentManager.delete(id);
            JOptionPane.showMessageDialog(frame, "Equipment deleted successfully!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
        }catch (NumberFormatException e) {
            // Handle the error if IDs are not valid integers
            JOptionPane.showMessageDialog(frame, "Equipment ID must be valid integers.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        frame.dispose(); // Close the window after deleting
    }
}

// Class for showing equipment
class ShowEquipmentWindow {
    private JFrame frame;
    private JTextField showIdField;
    private EquipmentManager equipmentManager;

    public ShowEquipmentWindow(EquipmentManager equipmentManager) {
        this.equipmentManager = equipmentManager;

        // Create the frame for Show Equipment window
        frame = new JFrame("Show Equipment");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Set the background color of the frame
        frame.getContentPane().setBackground(new Color(0x2B2738)); // Dark background color

        // Create JPanel with FlowLayout for alignment
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panel.setBackground(new Color(0x2B2738)); // Set panel background to match the frame
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add padding

        // Create label and text field for Equipment ID
        JLabel idLabel = new JLabel("Equipment ID:");
        idLabel.setForeground(Color.WHITE); // Set label text color

        showIdField = new JTextField();
        showIdField.setPreferredSize(new Dimension(150, 30)); // Set size of the text field
        showIdField.setBackground(new Color(0x3B364C)); // Darker background for text field
        showIdField.setForeground(Color.WHITE); // Text color inside the text field

        // Create the Show button
        JButton showButton = new JButton("Show");
        showButton.setPreferredSize(new Dimension(100, 30)); // Set button size
        showButton.setBackground(new Color(0x6E54B5)); // Button background color
        showButton.setForeground(new Color(0xFCFCFA)); // Button text color
        showButton.addActionListener(e -> showEquipment()); // Attach action listener

        // Add components to the panel
        panel.add(idLabel);
        panel.add(showIdField);
        panel.add(showButton);

        // Add the panel to the frame
        frame.add(panel);

        // Set the frame to center on the screen and make it visible
        frame.pack();
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setVisible(true);
    }

    private void showEquipment() {
        String id = showIdField.getText();
        try{
            int eqId = Integer.parseInt(id);
            String result = equipmentManager.show_by_id(id);
            JOptionPane.showMessageDialog(frame, result, "Equipment Details", JOptionPane.INFORMATION_MESSAGE);
        }catch (NumberFormatException e) {
            // Handle the error if IDs are not valid integers
            JOptionPane.showMessageDialog(frame, "Equipment ID must be valid integers.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        frame.dispose(); // Close the window after showing
    }
}


    // Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration                   
}
