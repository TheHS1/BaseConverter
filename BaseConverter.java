import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BaseConverter implements ActionListener{

    private JLabel total;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;

    public BaseConverter() {
        JFrame frame = new JFrame("BaseConverter");

        JButton button1 = new JButton("Calculate");
        button1.addActionListener(this);

        JLabel label1 = new JLabel("Enter the first number");
        JLabel label2 = new JLabel("Enter the second number");
        JLabel label3 = new JLabel("Base ");
        JLabel label4 = new JLabel("Base ");
        JLabel label5 = new JLabel("Value ");
        JLabel label6 = new JLabel("Value ");
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        textField4 = new JTextField();
        total = new JLabel();
        JComboBox<String> operations = new JComboBox<>(new String[] {"add", "multiply"});

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
	    c.gridy = 0;
        c.ipadx = 100;
        c.ipady = 20;

        Insets defaultMargin = new Insets(2,2,2,2);
        c.insets = defaultMargin;

        panel.add(label1, c);
        c.gridx = GridBagConstraints.RELATIVE;
        panel.add(textField1, c);
        panel.add(label3, c);
        panel.add(textField2, c);
        panel.add(label5, c);

        c.gridy = 1;
        c.gridwidth = 5;
        c.insets = new Insets(30, 0, 30, 0);
        panel.add(operations, c);

        c.insets = defaultMargin;
        c.gridwidth = 1;
	    c.gridy = 2;
        panel.add(label2, c);

        c.gridx = GridBagConstraints.RELATIVE;
        panel.add(textField3, c);
        panel.add(label4, c);
        panel.add(textField4, c);
        panel.add(label6, c);

	    c.gridy = 3;
        c.gridwidth = 5;
        panel.add(button1, c);

        c.gridy = 4;
        c.gridwidth = 1;
        panel.add(total, c);


        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        total.setText((Integer.parseInt(textField2.getText()) + Integer.parseInt(textField4.getText())) + "");
    }

    public static void main(String[] args) {
        new BaseConverter();
    }
}

