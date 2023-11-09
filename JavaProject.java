package com.javaProjects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class JavaProject extends JFrame{
    JavaProject(){
        JFrame f = new JFrame("first");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(Color.CYAN);
        f.setSize(1000,1000);
        f.setResizable(false);
        //f.setVisible(true);
        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        panel.setBackground(Color.BLUE);
        panel1.setBackground(Color.YELLOW);
        panel2.setBackground(Color.DARK_GRAY);
        f.add(panel).setBounds(0, 0, 400, 1000);
        f.add(panel1).setBounds(200, 0, 800, 400);
        f.add(panel2).setBounds(200, 100, 500, 400);
    }
    static class LoginPage extends JavaProject{
        LoginPage(){
            JFrame my_frame = new JFrame("Login Page");
            my_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            my_frame.getContentPane().setBackground(Color.CYAN);
            my_frame.setSize(1000,1000);
            my_frame.setResizable(false);
            my_frame.setVisible(true);
            JPanel my_panel = new JPanel();
            my_panel.setLayout(new GridLayout(5, 2));
            my_panel.setBackground(Color.CYAN);
            JLabel username = new JLabel("Username or Email Address");
            username.setBounds(200, 100, 200, 50);
            JTextField textField = new JTextField();
            textField.setBounds(500, 100, 300, 50);
            JLabel second_label = new JLabel("Enter your password");
            second_label.setBounds(200, 300, 300, 50);
            JPasswordField passwordField = new JPasswordField(10);
            passwordField.contains(500, 300);
            JButton login = new JButton("Login");
            login.setBounds(500, 200, 100, 30);
            my_panel.add(username);
            my_panel.add(second_label);
            my_panel.add(passwordField);
            my_panel.add(login);
            my_panel.add(textField);
            my_frame.add(my_panel).setBounds(200, 200, 600, 600);
            login.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {

                    JavaProject mySecondWindow = new JavaProject();
                    mySecondWindow.setVisible(true);
                    //mySecondWindow.setSize(1000, 1000);
                    mySecondWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    mySecondWindow.getContentPane().setBackground(Color.CYAN);
                    mySecondWindow.setSize(1000,1000);
                    mySecondWindow.setResizable(false);
                    //f.setVisible(true);
                    JPanel panel = new JPanel();
                    JPanel panel1 = new JPanel();
                    JPanel panel2 = new JPanel();
                    panel.setBackground(Color.BLUE);
                    panel1.setBackground(Color.YELLOW);
                    panel2.setBackground(Color.DARK_GRAY);
                    mySecondWindow.add(panel).setBounds(0, 0, 400, 1000);
                    mySecondWindow.add(panel1).setBounds(200, 0, 800, 400);
                    mySecondWindow.add(panel2).setBounds(200, 100, 500, 400);
                }
            });
        }
    }
    public static void main(String[] args) {
        new LoginPage();
    }
}