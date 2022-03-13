import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BaseConverter implements ActionListener,ItemListener {

    private JLabel total;
    private JComboBox<String> operations;
    private JPanel elemList, content;
    private JFrame frame;

    private JButton calculate, add, sub;

    public BaseConverter() {
        frame = new JFrame("BaseConverter");

        JPanel functionSelect = new JPanel();
        JComboBox<String> cb = new JComboBox<String>(new String[] {"Convert", "Operate"});
        // cb.addItemListener(this);
        functionSelect.add(cb);
        cb.addItemListener(this);

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
        c.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        c.fill = java.awt.GridBagConstraints.NONE;
        c.insets = new Insets(30,0,0,0);
        c.weightx = 1;
        JLabel title = new JLabel("Base Converter", JLabel.CENTER);
        title.setFont(title.getFont().deriveFont(100f));
        main.add(title, c);

        c.gridy = 1;
        c.insets = new Insets(2,2,100,2);
        main.add(functionSelect, c);

        c.gridy = 2;
        content = new JPanel(new CardLayout());
        main.add(content, c);

        JPanel convert = new JPanel();
        convert.add(new JLabel("test"));
        content.add(convert, "Convert");

        elemList = new JPanel();
        elemList.setLayout(new GridLayout(0, 1));
        content.add(elemList, "Operate");

        total = new JLabel();
        elemList.add(add, c);

        elemList.add(sub, c);

        
        addRow();
        addRow();
        frame.setContentPane(main);
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
