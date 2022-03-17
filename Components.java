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

    public JTextField getBase() {
        return this.base;
    }

    public int getValue() {
        return Integer.parseInt(this.value.getText());
    }
}

class ConvertView extends JPanel {
    private GridBagConstraints c; 
    private JTextField base, value;

    public ConvertView() {
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

    }
}

class OperationsView extends JPanel {

    public OperationsView(JButton add, JButton sub, JButton calculate) {
        this.setLayout(new GridLayout(0, 1));
        this.add(new Controls(add, sub, calculate));
        // todo add another enclosing panel for rows to separate from calculations
        this.addRow();
        this.addRow();
    }

    public void addRow() {
        if(TermRow.getCount() <= 4) {
            if(this.getComponentCount() > 1) {
                this.add(new Operations(), this.getComponentCount()-1);
            }
            this.add(new TermRow(), this.getComponentCount()-1);
        }
    }

    public void removeRow() {
        if(TermRow.getCount() >= 4) {
            try {
                this.remove(this.getComponentCount()-2);
                this.remove(this.getComponentCount()-2);
                TermRow.decCount();
            } catch(Exception e) {
                
            }
        }
    }

    public int totalValues() {
        TermRow firstTerm = (TermRow) this.getComponent(0);
        int sum = firstTerm.getValue();
        for (int i = 1; i < (this.getComponentCount()) / 2 + 2; i+=2) {
            Operations o = (Operations) this.getComponent(i);
            TermRow secondTerm = (TermRow) this.getComponent(i+1);
            if (o.getOperations().getSelectedItem() == "add") {
                sum += secondTerm.getValue();
            }
            else if (o.getOperations().getSelectedItem() == "multiply") {
                sum *= secondTerm.getValue();
            }
        }
        return sum;

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
        this.add(calculate, c); // TODO add button
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


