import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BaseConverter implements ActionListener,ItemListener {

    private JLabel total;
    private JComboBox<String> operations;
    private JPanel content, container, main;
    private JFrame frame;
    private JButton calculate, add, sub, convert;

    public BaseConverter() {
        frame = new JFrame("BaseConverter");

        // Iniitalize all buttons, add action listeners, set colors
        calculate = new JButton("Calculate");
        calculate.addActionListener(this);
        add = new JButton("+");
        add.addActionListener(this);
        add.setBackground(Color.GREEN);
        sub = new JButton("-");
        sub.addActionListener(this);
        sub.setBackground(Color.RED);
        convert = new JButton("Convert");
        convert.addActionListener(this);

        // Initialize main panel, set layout and initialize constraints variable
        main = new JPanel();
        main.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // add title JLabel to main panel
        c.gridx = GridBagConstraints.RELATIVE;
        c.gridy = 0;
        c.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        c.fill = java.awt.GridBagConstraints.NONE;
        c.insets = new Insets(30,0,0,0);
        JLabel title = new JLabel("Base Converter", JLabel.CENTER);
        title.setFont(title.getFont().deriveFont(64f));
        main.add(title, c);

        // Top dropdown menu to pick operation
        c.gridy = 1;
        c.insets = new Insets(2,2,50,2);
        JPanel functionSelect = new JPanel();
        JComboBox<String> cb = new JComboBox<String>(new String[] {"Convert", "Operate"});
        cb.addItemListener(this);
        functionSelect.add(cb);
        main.add(functionSelect, c);

        // Initialize card layout
        // Used to switch between which panel to display based on the dropdown menu
        c.gridy = 2;
        content = new JPanel(new CardLayout());
        main.add(content, c);

        // Add the views for the Convert and Operate functions
        content.add(new ConvertView(convert), "Convert");

        // messy fix to make sure that the GridLayout height is based on TermRow and not the Controls height
        container = new JPanel(new GridBagLayout());
        GridBagConstraints containC = new GridBagConstraints();
        containC.gridy = 0;
        container.add(new OperationsView(), containC);
        containC.gridy = 1;
        containC.insets = new Insets(15, 0, 0, 0);
        container.add(new Controls(add, sub, calculate), containC);
        content.add(container, "Operate");

        // initialize and add total/error message JLabel to the frame
        c.gridy = 4;
        total = new JLabel();
        main.add(new Output(), c);

        // Some frame settings then make sure to give all of the components the space they need and set the frame visible
        frame.setContentPane(main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        OperationsView opView = (OperationsView) container.getComponent(0);
        JLabel total = ((JLabel)((Output)this.main.getComponent(this.main.getComponentCount()-1)).getComponent(2));

        // Do the appropriate function based on which button was clicked
        if (e.getSource() == add) {
            opView.addRow();
        } else if (e.getSource() == sub) {
            opView.removeRow();
        } else if (e.getSource() == calculate) {
            // Could probably make an effort to make this not unreadable
            total.setText(opView.totalValues((JTextField)(((Output)main.getComponent(3)).getComponent(0))));
        } else if (e.getSource() == convert) {
            // Could probably make an effort to make this not unreadable
            total.setText(((ConvertView) this.content.getComponent(0)).convert((JTextField)((Output)(this.main.getComponent(3))).getComponent(0)));
        }
        frame.pack();
    } 

    // Change active JPanel based on top dropdown selection
    public void itemStateChanged(ItemEvent e) {
        CardLayout cl = (CardLayout)(content.getLayout());
        cl.show(content, (String)e.getItem());
    }

    // Run the constructor by adding to the event dispatch thread for safety
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BaseConverter();
            }
        });
    }
}
