import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Car1 extends JFrame {
    private ArrayList<Car> cars = new ArrayList<>();
    private JComboBox<String> carModelDropdown;
    private JComboBox<String> carNameDropdown;
    private JTextField carOwnerField;
    private JTextField carPriceField;
    private JTextArea carDataDisplay;
    private JButton addCarButton;
    private JLabel carImageLabel;

    public Car1() {
        setTitle("GROUP 7 CAR MANAGEMENT SYSTEM");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        carModelDropdown = new JComboBox<>(new String[]{"Ford", "Subaru", "Toyota", "Lexus", "Honda", "Mercedes"});
        carNameDropdown = new JComboBox<>();
        carOwnerField = new JTextField(15);
        carPriceField = new JTextField(15);
        carDataDisplay = new JTextArea(15, 40);
        carDataDisplay.setEditable(false);
        addCarButton = new JButton("SUBMIT CAR DETAILS");
        carImageLabel = new JLabel();

        carModelDropdown.addActionListener(e -> {
            updateCarNameDropdown();
            updateCarImageDisplay();
        });

        addCarButton.addActionListener(e -> addCar());

        setLayout(new BorderLayout());
        add(createUserDetailsPanel(), BorderLayout.NORTH);
        add(createUserEntryPanel(), BorderLayout.CENTER);
        add(createOutputPanel(), BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createUserDetailsPanel() {
        JPanel userDetailsPanel = new JPanel();
        userDetailsPanel.setBackground(Color.GREEN);
        userDetailsPanel.setLayout(new GridLayout(5, 2));
        userDetailsPanel.add(new JLabel("Car Model:"));
        userDetailsPanel.add(carModelDropdown);
        userDetailsPanel.add(new JLabel("Car Name:"));
        userDetailsPanel.add(carNameDropdown);
        userDetailsPanel.add(new JLabel("Car Owner:"));
        userDetailsPanel.add(carOwnerField);
        userDetailsPanel.add(new JLabel("Add Price:"));
        userDetailsPanel.add(carPriceField);
        return userDetailsPanel;
    }

    private JPanel createUserEntryPanel() {
        JPanel userEntryPanel = new JPanel();
        userEntryPanel.setBackground(Color.ORANGE);
        userEntryPanel.setLayout(new FlowLayout());
        userEntryPanel.add(addCarButton);
        userEntryPanel.add(carImageLabel);
        return userEntryPanel;
    }

    private JPanel createOutputPanel() {
        JPanel outputPanel = new JPanel();
        outputPanel.setBackground(Color.BLUE);
        outputPanel.add(new JScrollPane(carDataDisplay));
        return outputPanel;
    }

    private void addCar() {
        String model = (String) carModelDropdown.getSelectedItem();
        String name = (String) carNameDropdown.getSelectedItem();
        String owner = carOwnerField.getText();
        String price = carPriceField.getText();

        // Here is a restriction to users for them to only enter valid integers for car price
        try {
            Integer.parseInt(price);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error: Car price must contain numbers between 0-9.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // A  code to restrict  car owner and name from being empty strings
        if (model.isEmpty() || name.isEmpty() || owner.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Error: Please fill all the required fields to proceed", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // A code to get the image representative of the selected car model
        ImageIcon icon = getCarImageForModel(model);

        Car car = new Car(model, name, owner, price, icon);
        cars.add(car);
        updateCarInfoDisplay();
        updateCarImageDisplay(icon);
    }

    // Using the switch and case statements to get the image paths for the images
    private ImageIcon getCarImageForModel(String model) {
        // Add more cases for other car models
        switch (model) {
            case "Toyota":
                return new ImageIcon("alphard.jfif");
            case "Ford":
                return new ImageIcon("ford.jfif");
            case "Subaru":
                return new ImageIcon("subaru.jfif");
            case "Lexus":
                return new ImageIcon("lx.jfif");
            case "Mercedes":
                return new ImageIcon("merc.jfif");
            case "Honda":

                return new ImageIcon("honda.jfif");
            default:
                return new ImageIcon("alphard.jfif");
        }
    }

    private void updateCarInfoDisplay() {
        carDataDisplay.setText("Car Information:\n");
        for (Car car : cars) {
            carDataDisplay.append("Model: " + car.getCarModel() + "\n" + " Name: " + car.getCarName() + "\n" +
                    " Owner: " + car.getCarOwner() + "\n" + " Price: " + car.getCarPrice() + "\n\n");
        }
    }

    private void updateCarImageDisplay(ImageIcon icon) {
        carImageLabel.setIcon(icon);
    }

    private void updateCarImageDisplay() {
        ImageIcon placeholderIcon = new ImageIcon(new ImageIcon("default_image.jpg").getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT));
        updateCarImageDisplay(placeholderIcon);
    }

    private void updateCarNameDropdown() {
        // Logic to update car name dropdown based on the selected car model
        String inputSelected = (String) carModelDropdown.getSelectedItem();
        carNameDropdown.removeAllItems();
        if ("Toyota".equals(inputSelected)) {
            carNameDropdown.addItem("Corolla");
            carNameDropdown.addItem("Camry");
            carNameDropdown.addItem("Harrier");
            carNameDropdown.addItem("Vitz");
            carNameDropdown.addItem("Alphard");
            carNameDropdown.addItem("Landcruiser");
            carNameDropdown.addItem("Probox");
        } else if ("Honda".equals(inputSelected)) {
            carNameDropdown.addItem("Civic");
            carNameDropdown.addItem("Accord");
        } else if ("Ford".equals(inputSelected)) {
            carNameDropdown.addItem("Mustang");
        } else if ("Subaru".equals(inputSelected)) {
            carNameDropdown.addItem("Legacy");
            carNameDropdown.addItem("Outback");
        } else if ("Mercedes".equals(inputSelected)) {
            carNameDropdown.addItem("E class");
            carNameDropdown.addItem("Gwagon");
        } else if ("Lexus".equals(inputSelected)) {
            carNameDropdown.addItem("Lx 570");
            carNameDropdown.addItem("Lx 680");
        } else if ("Ford".equals(inputSelected)) {
            carNameDropdown.addItem("Mustang");
            carNameDropdown.addItem("Double Cabin");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Car1());
    }

    class Car {
        private String carModel;
        private String carName;
        private String carOwner;
        private String carPrice;
        private ImageIcon carImage;

        public Car(String carModel, String carName, String carOwner, String carPrice, ImageIcon carImage) {
            this.carModel = carModel;
            this.carName = carName;
            this.carOwner = carOwner;
            this.carPrice = carPrice;
            this.carImage = carImage;
        }

        public String getCarModel() {
            return carModel;
        }

        public String getCarName() {
            return carName;
        }

        public String getCarOwner() {
            return carOwner;
        }

        public String getCarPrice() {
            return carPrice;
        }

        public ImageIcon getCarImage() {
            return carImage;
        }
    }
}
