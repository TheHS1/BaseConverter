import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BaseConverter implements ActionListener,ItemListener {

    private JLabel total;
    private JComboBox<String> operations;
    private JPanel content, container, main;
    private JFrame frame;
    private JButton calculate, add, sub;

    public BaseConverter() {
        frame = new JFrame("BaseConverter");

        JPanel functionSelect = new JPanel();
        JComboBox<String> cb = new JComboBox<String>(new String[] {"Convert", "Operate"});
        cb.addItemListener(this);
        functionSelect.add(cb);

        calculate = new JButton("Calculate");
        calculate.addActionListener(this);
        add = new JButton("+");
        add.addActionListener(this);
        add.setBackground(Color.GREEN);
        sub = new JButton("-");
        sub.addActionListener(this);
        sub.setBackground(Color.RED);

        main = new JPanel();
        main.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = GridBagConstraints.RELATIVE;
        c.gridy = 0;
        c.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        c.fill = java.awt.GridBagConstraints.NONE;
        c.insets = new Insets(30,0,0,0);
        JLabel title = new JLabel("Base Converter", JLabel.CENTER);
        title.setFont(title.getFont().deriveFont(64f));
        main.add(title, c);

        c.gridy = 1;
        c.insets = new Insets(2,2,50,2);
        main.add(functionSelect, c);

        c.gridy = 2;
        content = new JPanel(new CardLayout());
        main.add(content, c);

        content.add(new ConvertView(), "Convert");

        container = new JPanel(new GridBagLayout());
        GridBagConstraints containC = new GridBagConstraints();
        containC.gridy = 0;
        container.add(new OperationsView(), containC);
        containC.gridy = 1;
        containC.insets = new Insets(15, 0, 0, 0);
        container.add(new Controls(add, sub, calculate), containC);
        content.add(container, "Operate");

        c.gridy = 4;
        total = new JLabel();
        main.add(new Output(), c);

        frame.setContentPane(main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        OperationsView opView = (OperationsView) container.getComponent(0);
        if (e.getSource() == add) {
            opView.addRow();
        } else if (e.getSource() == sub) {
            opView.removeRow();
        } else if (e.getSource() == calculate) {
            ((JLabel)((Output)this.main.getComponent(this.main.getComponentCount()-1)).getComponent(2)).setText(opView.totalValues());
        }
        frame.pack();
    } 

    public void itemStateChanged(ItemEvent e) {
        CardLayout cl = (CardLayout)(content.getLayout());
        cl.show(content, (String)e.getItem());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BaseConverter();
            }
        });
    }
}
