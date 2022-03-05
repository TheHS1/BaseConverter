import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BaseConverter implements ActionListener{

    public BaseConverter() {
        JFrame frame = new JFrame("BaseConverter");

        JButton button1 = new JButton("Calculate");
        JLabel label1 = new JLabel("Enter the first number");
        JLabel label2 = new JLabel("Enter the second number");
        JLabel label3 = new JLabel("Base ");
        JLabel label4 = new JLabel("Base ");
        JLabel label5 = new JLabel("Value ");
        JLabel label6 = new JLabel("Value ");
        JTextField textField1 = new JTextField();
        JTextField textField2 = new JTextField();
        JTextField textField3 = new JTextField();
        JTextField textField4 = new JTextField();

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        panel.setLayout(new GridLayout(0, 5, 30, 30));
        panel.add(label1);
        panel.add(label3);
        panel.add(textField1);
        panel.add(label5);
        panel.add(textField2);
        panel.add(label2);
        panel.add(label4);
        panel.add(textField3);
        panel.add(label6);
        panel.add(textField4);
        panel.add(button1);


        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    public void actionPerformed(ActionEvent e)
    {
        // if the state combobox is changed
            System.out.println("bruh");
    }

    public static void main(String[] args) {
        new BaseConverter();
    }
}

