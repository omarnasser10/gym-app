package com.mycompany.gymproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class TrainerPage {

    private static JFrame trainerFrame;
    private static JPanel cardPanel;
    private static CardLayout cardLayout;

    public TrainerPage(String id)throws IOException {
        trainerFrame = new JFrame("Trainer Page");
        trainerFrame.setVisible(true);
        trainerFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        trainerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        trainerFrame.setSize(1000, 600);
        trainerFrame.setLocationRelativeTo(null); 

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(Color.decode("#6E54B5"));
        menuBar.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); 

        JMenu homeMenu = new JMenu("Home");
        homeMenu.setForeground(Color.WHITE);
        homeMenu.setFont(new Font("Arial", Font.BOLD, 20));
        JMenu createPlanMenu = new JMenu("Create Plan");
        createPlanMenu.setForeground(Color.WHITE);
        createPlanMenu.setFont(new Font("Arial", Font.BOLD, 20));
        JMenu logoutMenu = new JMenu("Logout"); // إضافة قائمة Logout
        logoutMenu.setForeground(Color.WHITE);
        logoutMenu.setFont(new Font("Arial", Font.BOLD, 20));

        menuBar.add(homeMenu);
        menuBar.add(createPlanMenu);
        menuBar.add(logoutMenu);

        JPanel homeCard = createHomeCard(id);
        JPanel createPlanCard = createCreatePlanCard(id);

        cardPanel.add(homeCard, "Home");
        cardPanel.add(createPlanCard, "CreatePlan");

        homeMenu.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                cardLayout.show(cardPanel, "Home");
            }
        });

        createPlanMenu.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                cardLayout.show(cardPanel, "CreatePlan");
            }
        });

        logoutMenu.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                int a = JOptionPane.showConfirmDialog(null, "Do you really want to Logout?", "Select", JOptionPane.YES_NO_OPTION);
                if (a == 0) {
                    trainerFrame.setVisible(false);
                    new LoginPagee().setVisible(true);
                }
            }
        });

        trainerFrame.setJMenuBar(menuBar);
        trainerFrame.add(cardPanel);

        trainerFrame.setVisible(true);
    }

    private static JPanel createHomeCard(String id) throws IOException {
             JPanel homePanel = new JPanel();
        homePanel.setLayout(new GridLayout(5, 1, 10, 10));
        Trainer trainer = Trainer.readTrainerFromFile("myDirectory/Trainers.txt", id);

        JLabel idLabel = new JLabel("ID: " + (trainer != null ? trainer.getTrainerID() : "N/A"));
        JLabel nameLabel = new JLabel("Name: " + (trainer != null ? trainer.getName() : "N/A"));
        JLabel ageLabel = new JLabel("Age: " + (trainer != null ? trainer.getAge() : "N/A"));
        JLabel phoneLabel = new JLabel("Phone: " + (trainer != null ? trainer.getPhone() : "N/A"));
        JLabel emailLabel = new JLabel("Email: " + (trainer != null ? trainer.getEmail() : "N/A"));
        JLabel experienceLabel = new JLabel("Experience: " + (trainer != null ? trainer.getExperienceYears() + " years" : "N/A"));
        JLabel specializationLabel = new JLabel("Specialization: " + (trainer != null ? trainer.getSpecialty() : "N/A"));
        JLabel salaryLabel = new JLabel("Salary: " + (trainer != null ? trainer.getSalary() : "N/A"));
        JLabel hiringdateLabel = new JLabel("ID: " + (trainer != null ? trainer.getHiringDate() : "N/A"));
        JLabel customersLabel = new JLabel("Customers: " + (trainer != null ? trainer.getCustomers() : "N/A"));

        homePanel.add(nameLabel);
        homePanel.add(idLabel);
        homePanel.add(ageLabel);
        homePanel.add(phoneLabel);
        homePanel.add(emailLabel);
        homePanel.add(experienceLabel);
        homePanel.add(specializationLabel);
        homePanel.add(salaryLabel);
        homePanel.add(hiringdateLabel);
        homePanel.add(customersLabel);

        return homePanel;
    }

    private static JPanel createCreatePlanCard(String id) throws IOException {
   JPanel createPlanPanel = new JPanel();
        createPlanPanel.setLayout(new GridLayout(6, 2, 10, 10));
        Trainer trainer = Trainer.readTrainerFromFile("myDirectory/Trainers.txt", id);

        JLabel customerIdLabel = new JLabel("Customer ID:");
        JTextField customerIdField = new JTextField();

        JLabel descriptionLabel = new JLabel("Description:");
        JTextField descriptionField = new JTextField();

        JLabel durationLabel = new JLabel("Duration:");
        JTextField durationField = new JTextField();

        JLabel exercisesLabel = new JLabel("Exercises:");
        JTextArea exercisesArea = new JTextArea();
        exercisesArea.setLineWrap(true);
        exercisesArea.setWrapStyleWord(true);

        JButton createButton = new JButton("Create Plan");
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String customerIdText = customerIdField.getText().trim();
                String description = descriptionField.getText().trim();
                String duration = durationField.getText().trim();
                String exercises = exercisesArea.getText().trim();

                if (customerIdText.isEmpty() || description.isEmpty() || duration.isEmpty() || exercises.isEmpty()) {
                    JOptionPane.showMessageDialog(trainerFrame, "All fields must be filled!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    int customerId = Integer.parseInt(customerIdText);
                    if (trainer != null) {
                        Customer customer = Customer.readCustomerFromFile("Customers.txt",customerIdText); // Replace with actual method to fetch customer
                        if (customer != null) {
                            trainer.create_plane_to_customer(description, duration, exercises, customerIdText);
                            JOptionPane.showMessageDialog(trainerFrame, "Plan created successfully for customer ID: " + customerId, "Success", JOptionPane.INFORMATION_MESSAGE);
                            customerIdField.setText("");
                            descriptionField.setText("");
                            durationField.setText("");
                            exercisesArea.setText("");
                        } else {
                            JOptionPane.showMessageDialog(trainerFrame, "Customer not found.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(trainerFrame, "Trainer data is unavailable.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(trainerFrame, "Customer ID must be a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        createPlanPanel.add(customerIdLabel);
        createPlanPanel.add(customerIdField);
        createPlanPanel.add(descriptionLabel);
        createPlanPanel.add(descriptionField);
        createPlanPanel.add(durationLabel);
        createPlanPanel.add(durationField);
        createPlanPanel.add(exercisesLabel);
        createPlanPanel.add(new JScrollPane(exercisesArea));
        createPlanPanel.add(createButton);

        return createPlanPanel;
    }


}
