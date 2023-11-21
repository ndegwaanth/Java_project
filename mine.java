package com.javaProjects;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class JavaProject extends JFrame
{
    JavaProject()
    {
        JFrame f = new JFrame("first");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(Color.CYAN);
        f.setSize(1000,1000);
        f.setResizable(false);
        f.setVisible(true);
        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        panel.setBackground(Color.CYAN);
        panel1.setBackground(Color.YELLOW);
        panel2.setBackground(Color.BLUE);
        f.add(panel).setBounds(0, 0, 400, 1000);
        f.add(panel1).setBounds(200, 0, 800, 400);
        f.add(panel2).setBounds(200, 100, 500, 400);
        panel.setLayout(new GridLayout(16, 4));
        JLabel output = new JLabel("The Image of the Car selected will pop here");
        output.setBounds(700, 0, 300, 50);
        panel1.add(output);
        Font myFont = new Font("Serif", Font.BOLD, 15);
        output.setFont(myFont);
        JLabel myThirdLab = new JLabel("the Information of the car you have selected will pop up here");
        myThirdLab.setFont(myFont);
        panel2.add(myThirdLab);
        panel1.setLayout(new FlowLayout());
        myThirdLab.setBounds(600, 600, 200, 50);
        JButton my_button = new JButton("submit");
        JLabel my_icon_label = new JLabel();
        JLabel carName = new JLabel("Choose the name of the car");
        carName.setBounds(110, 10, 200, 30);
        JComboBox<String> my_carName = new JComboBox<>();
        /*my_carName.setBounds(110, 50, 200, 50);*/
        JLabel carModel = new JLabel("enter the car model");
        carModel.setBounds(110, 100, 200, 30);
        String[] carType = {"SUV", "BMW", "Ford", "Honda", "Nissan", "Chevrolet", "Chevrolet", "Mercedes-Benz", "Covertible", "Toyota", "Isuzu", "Mitsubishi", "Lexus", "Honda", "Volkswagen", "Hyundai", "Tesla", };
        JComboBox<String> my_carModel = new JComboBox<>(carType);
        my_carModel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String  inputSelected = (String) my_carModel.getSelectedItem();
                my_carName.removeAllItems();
                if("Toyota".equals(inputSelected)){
                    my_carName.addItem("Harrier");
                    my_carName.addItem("Probox");
                    my_carName.addItem("vitz");
                    my_carName.addItem("Alphard");
                } else if ("Isuzu".equals(inputSelected)) {
                    my_carName.addItem("DMAX");
                    my_carName.addItem("OFFROAD");
                    my_carName.addItem("Wide Load Truck");
                } else if ("Lexus".equals(inputSelected)) {
                    my_carName.addItem("LX 570");
                    my_carName.addItem("LX 1250");
                    my_carName.addItem("SUV");
                }
                else if ("Honda".equals(inputSelected)){
                    my_carName.addItem("Civic (Sedan)");
                    my_carName.addItem("Accord (Sedan)");
                    my_carName.addItem("CR-V (SUV)");
                    my_carName.addItem("Pilot (SUV)");
                }
                else if ("Chevrolet".equals(inputSelected)){
                    my_carName.addItem("Malibu (Sedan)");
                    my_carName.addItem("Imapala (Sedan)");
                    my_carName.addItem("Equinox (SUV)");
                    my_carName.addItem("Tahoe (SUV)");
                }
                else if ("Ford".equals(inputSelected)){
                    my_carName.addItem("Focus (Sedan)");
                    my_carName.addItem("Fusion");
                    my_carName.addItem("Escape (Sedan)");
                    my_carName.addItem("Explorer (SUV)");
                }
                else if ("Nissan".equals(inputSelected)){
                    my_carName.addItem("Altima (Sedan)\n");
                    my_carName.addItem("Maxima (Sedan)\n");
                    my_carName.addItem("Rogue (SUV)\n");
                    my_carName.addItem("Murano (SUV)\n");
                }
                else if ("BMW".equals(inputSelected)) {
                    my_carName.addItem("3 Series (Sedan)");
                    my_carName.addItem("5 Series (Sedan)");
                    my_carName.addItem("X3 (SUV)");
                    my_carName.addItem("X5 (SUV)");
                }
                else if ("Mercedes-Benz".equals(inputSelected)) {
                    my_carName.addItem("C-Class (Sedan)");
                    my_carName.addItem("E-Class (Sedan)");
                    my_carName.addItem("GLC (SUV)");
                    my_carName.addItem("GLE (SUV)");
                }
                else if ("Tesla".equals(inputSelected)) {
                    my_carName.addItem("Model 3 (Sedan)");
                    my_carName.addItem("Model S (Sedan)");
                    my_carName.addItem("Model X (SUV)");
                    my_carName.addItem("Model Y (SUV)");
                }
                else if ("Hyundai".equals(inputSelected)) {
                    my_carName.addItem("Elantra (Sedan)");
                    my_carName.addItem("Sonata (Sedan)");
                    my_carName.addItem("Tucson (SUV)");
                    my_carName.addItem("Santa Fe (SUV)");
                }
                else if ("Volkswagen".equals(inputSelected)) {
                    my_carName.addItem("Jetta (Sedan)");
                    my_carName.addItem("Passat (Sedan)");
                    my_carName.addItem("Tiguan (SUV)");
                    my_carName.addItem("Atlas (SUV)");
                    Integer[] originalPrice = {200, 300, 400, 500};
                    JComboBox<Integer> the_carPrice;
                    the_carPrice = new JComboBox<>(originalPrice);
                    the_carPrice.setBounds(110,350, 200, 30);
                } else if ("Mitsubishi".equals(inputSelected)) {
                    my_carName.addItem("Mitsubishi Lancer");
                    my_carName.addItem("Mitsubishi Outlander");
                    my_carName.addItem("Mitsubishi Eclipse Cross");
                    my_carName.addItem("Mitsubishi i-MiEV");
                }

            }
        });
        //my_carModel.setBounds(110, 150, 200, 30);
        JLabel carOwner = new JLabel("enter the your name \n");
        carOwner.setBounds(110, 200, 350, 30);
        JTextField the_carOwner = new JTextField();
        the_carOwner.setBounds(110, 250, 200, 30);
        JLabel carPrice = new JLabel("\nPrice of the car");
        carPrice.setBounds(110,400, 400, 30);
        Integer[] originalPrice = {2000000, 3000000, 400000, 500000};
        JComboBox<Integer> the_carPrice;
        the_carPrice = new JComboBox<>(originalPrice);
        //JTextField the_carPrice = new JTextField();
        the_carPrice.setBounds(110,350, 200, 30);
        my_button.setBounds(110, 400, 150, 30);
        panel.add(carName);
        panel.add(carModel);
        panel.add(carOwner);
        panel.add(carPrice);
        panel.add(my_carName);
        panel.add(my_carModel);
        panel.add(the_carOwner);
        panel.add(the_carPrice);
        my_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String carSelected = (String) my_carName.getSelectedItem();
                my_icon_label.removeAll();
                if ("Landcruiser".equals(carSelected))
                {
                    ImageIcon icon = myWindowImage("my.jpg");
                    my_icon_label.setIcon(icon);
                }
                if ("Harrier".equals(carSelected))
                {
                    ImageIcon icon = myWindowImage("second.jpg");
                    my_icon_label.setIcon(icon);
                }
                else {
                    return;
                }

                String comboValue = Objects.requireNonNull(my_carName.getSelectedItem()).toString();
                String carModelValue = (String) my_carModel.getSelectedItem();
                String carOwnerValue = the_carOwner.getText();
                int myCarPriceValue = Integer.parseInt("" + the_carPrice.getSelectedItem());
                JOptionPane.showMessageDialog(panel2, "The car selected :" + comboValue + "\n Model of the car :" + carModelValue + "\n The owner of the car : " + carOwnerValue + "\n Price of the car :" + myCarPriceValue);
            }
        });
        my_icon_label.setBounds(700, 300, 200, 50);
        panel1.add(my_icon_label);
        panel.add(my_button);
    }
    public ImageIcon myWindowImage(String my_image_location)
    {
        java.net.URL myImage = getClass().getResource(my_image_location);
        if (myImage != null){
            return new ImageIcon(myImage);
        }
        else{
            System.err.println("the image is not recognized"+ my_image_location);
            return null;
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JavaProject());
    }
}
