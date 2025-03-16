package com.mycompany.gymproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class CustomerPage {

    private static JFrame customerFrame;
    private static JPanel cardPanel;
    private static CardLayout cardLayout;

    public CustomerPage(String id)throws IOException {
        customerFrame = new JFrame("Customer Page");
        customerFrame.setVisible(true);
        customerFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        customerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        customerFrame.setSize(1000, 600);
        customerFrame.setLocationRelativeTo(null); 

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(Color.decode("#6E54B5"));
        menuBar.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));


        // Home Menu
        JMenu homeMenu = new JMenu("Home");
        homeMenu.setForeground(Color.WHITE);
        homeMenu.setFont(new Font("Arial", Font.BOLD, 20));

        // Logout Menu
        JMenu logoutMenu = new JMenu("Logout");
        logoutMenu.setForeground(Color.WHITE);
        logoutMenu.setFont(new Font("Arial", Font.BOLD, 20));

        menuBar.add(homeMenu);
        menuBar.add(logoutMenu);

        JPanel homeCard = createHomeCard(id);

        cardPanel.add(homeCard, "Home");

        homeMenu.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                cardLayout.show(cardPanel, "Home");
            }
        });

        logoutMenu.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                int confirm = JOptionPane.showConfirmDialog(
                        customerFrame, 
                        "Are you sure you want to logout?", 
                        "Logout Confirmation", 
                        JOptionPane.YES_NO_OPTION
                );
                if (confirm == JOptionPane.YES_OPTION) {
                    customerFrame.setVisible(false);
            new LoginPagee().setVisible(true);// Close the application
                }
            }
        });

        customerFrame.setJMenuBar(menuBar);
        customerFrame.add(cardPanel);

        customerFrame.setVisible(true);
    }

    private static JPanel createHomeCard(String id) throws IOException{
       JPanel homePanel = new JPanel();
        homePanel.setLayout(new GridLayout(5, 1, 10, 10));
        Customer customer=Customer.readCustomerFromFile("Customers.txt",id);

        JLabel idLabel = new JLabel("ID: " + (customer != null ? id : "N/A"));
        JLabel nameLabel = new JLabel("Name: " + (customer != null ? customer.getName() : "N/A"));
        JLabel ageLabel = new JLabel("Age: " + (customer != null ? customer.getAge() : "N/A"));
        JLabel phoneLabel = new JLabel("Phone: " + (customer != null ? customer.getPhone() : "N/A"));
        JLabel emailLabel = new JLabel("Email: " + (customer != null ? customer.getEmail() : "N/A"));
        JLabel heightLabel = new JLabel("height: " + (customer != null ? customer.getHeight() : "N/A"));
        JLabel weightLabel = new JLabel("weight: " + (customer != null ? customer.getWeight() : "N/A"));
        JLabel membershipLabel = new JLabel("membership: " + (customer != null ? customer.getMembership() : "N/A"));
        JLabel exerciseplanLabel = new JLabel("exerciseplan: " + (customer != null ? customer.getExerciseplan() : "N/A"));


        homePanel.add(nameLabel);
        homePanel.add(idLabel);
        homePanel.add(ageLabel);
        homePanel.add(phoneLabel);
        homePanel.add(emailLabel);
        homePanel.add(heightLabel);
        homePanel.add(weightLabel);
        homePanel.add(membershipLabel);
        homePanel.add(exerciseplanLabel);

        return homePanel;
}}