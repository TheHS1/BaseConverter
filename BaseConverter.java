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
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
	    c.gridy = 0;
        c.ipadx = 100;
        c.ipady = 20;
        // c.weightx = 1;
        // c.weighty = 1;
        c.insets = new Insets(2,2,2,2);

        panel.add(label1, c);
        c.gridx = GridBagConstraints.RELATIVE;
        panel.add(textField1, c);
        panel.add(label3, c);
        panel.add(textField2, c);
        panel.add(label5, c);
	    c.gridy = 2;
        panel.add(label2, c);
        c.gridx = GridBagConstraints.RELATIVE;
        panel.add(textField3, c);
        panel.add(label4, c);
        panel.add(textField4, c);
        panel.add(label6, c);
	    c.gridy = 3;
        panel.add(button1, c);


        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    public void actionPerformed(ActionEvent e)
    {
            System.out.println("bruh");
    }

    public static void main(String[] args) {
        new BaseConverter();
    }
}

