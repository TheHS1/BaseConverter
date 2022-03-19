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

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = GridBagConstraints.RELATIVE;
        c.fill = java.awt.GridBagConstraints.HORIZONTAL;
        c.gridy = 0;
        c.ipadx = 100;
        c.ipady = 20;
        c.weightx = 0;
        c.weighty = 1;
        c.insets = new Insets(2,2,2,2);

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

    public int getBase() {
        return Integer.parseInt(this.base.getText());
    }

    public String getValue() {
        return this.value.getText();
    }
}

class ConvertView extends JPanel {
    private GridBagConstraints c; 
    private JTextField base, value;

    public ConvertView(JButton convert) {
        this.setLayout(new GridBagLayout());
        base = new JTextField();
        value = new JTextField();
        c = new GridBagConstraints();
        
        c.gridx = GridBagConstraints.RELATIVE;;
        c.gridy = 0;
        c.ipadx = 100;
        c.ipady = 20;
        c.weightx = 0;
        c.weighty = 1;
        c.fill = java.awt.GridBagConstraints.HORIZONTAL;

        this.add(new JLabel("base"), c);
        this.add(base, c);

        c.gridy = 1;
        this.add(new JLabel("value"), c);
        this.add(value, c);

        c.gridy = 2;
        c.gridwidth = 2;
        c.insets = new Insets(20, 0, 0, 0);
        c.fill = java.awt.GridBagConstraints.BOTH;
        this.add(convert, c);

    }

    public String convert(JTextField outputBase) {
        try {
            if(Integer.parseInt(this.base.getText()) > 64 || Integer.parseInt(this.base.getText()) < 2 || Integer.parseInt(outputBase.getText()) > 64 || Integer.parseInt(outputBase.getText()) < 2) {
                return "Only bases 1-64 are allowed";
            }
            return NumberBased.convert(this.value.getText(), Integer.parseInt(this.base.getText()), Integer.parseInt(outputBase.getText()));
        } catch (Exception e) {
            return "Invalid input or input unfilled";
        }
    }
}

class OperationsView extends JPanel {

    public OperationsView() {
        this.setLayout(new GridLayout(0, 1));
        this.addRow();
        this.addRow();
    }

    public void addRow() {
        if(TermRow.getCount() <= 4) {
            if(this.getComponentCount() > 0) {
                this.add(new Operations());
            }
            this.add(new TermRow());
        }
    }

    public void removeRow() {
        if(TermRow.getCount() >= 4) {
            try {
                this.remove(this.getComponentCount()-1);
                this.remove(this.getComponentCount()-1);
                TermRow.decCount();
            } catch(Exception e) {
                
            }
        }
    }

    public String totalValues(JTextField outputBase) {
        try {
            TermRow firstTerm = (TermRow) this.getComponent(0);
            int base = firstTerm.getBase();
            String sum = firstTerm.getValue();
            for (int i = 1; i < (this.getComponentCount()); i+=2) {
                Operations o = (Operations) this.getComponent(i);
                TermRow secondTerm = (TermRow) this.getComponent(i+1);
                if(base > 64 || base < 2 || secondTerm.getBase() > 64 || secondTerm.getBase() < 2 || Integer.parseInt(outputBase.getText()) > 64 || Integer.parseInt(outputBase.getText()) < 2) {
                    return "Only bases 1-64 are allowed";
                }
                if (o.getOperations().getSelectedItem() == "add") {
                    sum = NumberBased.add(sum, base, secondTerm.getValue(), secondTerm.getBase(), Integer.parseInt(outputBase.getText()));
                }
                else if (o.getOperations().getSelectedItem() == "multiply") {
                    sum = NumberBased.multiply(sum, base, secondTerm.getValue(), secondTerm.getBase(), Integer.parseInt(outputBase.getText()));
                }
                base = Integer.parseInt(outputBase.getText());
            }
            return sum;
        } catch (Exception e) {
            return "Please enter a valid input";
        }
    }
}

class Controls extends JPanel {
    private GridBagConstraints c;

    public Controls(JButton add, JButton sub, JButton calculate) {

        this.setLayout(new GridBagLayout());
        c = new GridBagConstraints();
        c.fill = java.awt.GridBagConstraints.BOTH;
        c.gridy = 1;
        c.ipadx = 40;
        c.ipady = 10;
        this.add(sub, c);
        c.gridy = 0;
        c.gridx = GridBagConstraints.RELATIVE;
        this.add(add, c);
        c.gridx = 1;
        c.gridheight = 2;
        this.add(calculate, c);
    }
}

class Operations extends JPanel {
    private final String[] operators = {"add", "multiply"};
    private JComboBox<String> operations;
    private GridBagConstraints c;

    public Operations() {
        operations = new JComboBox<>(operators);
        this.setLayout(new GridBagLayout());
        this.add(operations);
        c = new GridBagConstraints();
        c.gridx = GridBagConstraints.RELATIVE;;
        c.gridy = 0;
        c.ipadx = 300;
        c.ipady = 50;
    }

    public JComboBox<String> getOperations() {
        return this.operations;
    }

}

class Output extends JPanel {
    private JLabel total;
    private JTextField outputBase;
    private GridBagConstraints c;
    
    public Output() {
        this.setLayout(new GridBagLayout());

        total = new JLabel("", SwingConstants.CENTER);
        total.setOpaque(true);
        total.setBackground(Color.YELLOW);

        c = new GridBagConstraints();
        c.ipadx = 80;
        c.ipady = 15;
        outputBase = new JTextField();
        this.add(outputBase, c);
        c.insets = new Insets(0, 10, 0, 0);
        this.add(new JLabel("Output Base"), c);
        c.insets = new Insets(0, 50, 0, 0);
        c.ipady = 80;
        c.ipadx = 160;
        this.add(total, c);
    }

}


