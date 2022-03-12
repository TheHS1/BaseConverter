import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BaseConverter implements ActionListener {

    private JLabel total;
    private JComboBox<String> operations;
    private JPanel elemList;
    private JFrame frame;

    private JButton calculate, add, sub;

    public BaseConverter() {
        frame = new JFrame("BaseConverter");

        calculate = new JButton("Calculate");
        // button1.addActionListener(this);
        
        add = new JButton("+");
        add.addActionListener(this);
        add.setBackground(Color.GREEN);

        sub = new JButton("-");
        sub.addActionListener(this);
        sub.setBackground(Color.RED);

        JPanel main = new JPanel();
        main.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = GridBagConstraints.RELATIVE;;
        c.gridy = 0;
        c.insets = new Insets(2,2,200,2);
        c.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        c.fill = java.awt.GridBagConstraints.NONE;
        c.weightx = 1;
        JLabel title = new JLabel("Base Converter", JLabel.CENTER);
        title.setFont(title.getFont().deriveFont(100f));
        main.add(title, c);

        c.gridy = 1;
        elemList = new JPanel();
        elemList.setLayout(new GridLayout(0, 1));
        main.add(elemList, c);
        frame.setContentPane(main);

        total = new JLabel();
        c.weightx = 0;
        elemList.add(add, c);

        elemList.add(sub, c);

        addRow();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);

    }

    public void addRow() {
        if(TermRow.getCount() <= 4) {
            if(elemList.getComponentCount() > 2) {
                elemList.add(new Operations(), elemList.getComponentCount()-2);
            }
            elemList.add(new TermRow(), elemList.getComponentCount()-2);
        }
    }

    public void removeRow() {
        elemList.remove(elemList.getComponentCount()-3);
        elemList.remove(elemList.getComponentCount()-3);
        TermRow.decCount();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            addRow();
        } else if(e.getSource() == sub) {
            removeRow();
        }
        frame.pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BaseConverter();
            }
        });
    }
}
