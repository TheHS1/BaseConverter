import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class TermRow extends JPanel{
    private static int count;
    private JTextField base;
    private JTextField value;

    static {
        count = 1;
    }

    public TermRow() {
        base = new JTextField();
        value = new JTextField();

        this.setLayout(new GridBagLayout());
        this.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = GridBagConstraints.RELATIVE;;
        c.fill = java.awt.GridBagConstraints.HORIZONTAL;
        c.gridy = 0;
        c.ipadx = 100;
        c.ipady = 20;
        c.weightx = 0;
        c.weighty = 1;


        Insets defaultMargin = new Insets(0,0,0,0);
        c.insets = defaultMargin;

        this.add(new JLabel("Enter value " + count), c);
        this.add(base, c);
        this.add(new JLabel("base"), c);
        this.add(value, c);
        this.add(new JLabel("value"), c);
        count++;

    }

    public static int getCount() {
        return count;
    }

    public static void decCount() {
        count--;
    }
}

class Operations extends JPanel {
    private final String[] operators = {"add", "multiply"};
    private JComboBox<String> operations;

    public Operations() {
        operations = new JComboBox<>(operators);
        this.setLayout(new GridBagLayout());
        this.add(operations);
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = GridBagConstraints.RELATIVE;;
        c.gridy = 0;
        c.ipadx = 300;
        c.ipady = 50;
    }

}


