
package gui;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JOptionPane;

class SimpleCalculator {

    SimpleCalculator() {

        JFrame window = new JFrame();
        window.setTitle("Simple Calculator");
        window.setSize(300,300);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout( new GridLayout(4,2) );

        ops.addItem("Add");
        ops.addItem("Subtract");
        ops.addItem("Multiply");
        ops.addItem("Divide");

        window.add( new JLabel("A:  ", SwingConstants.RIGHT) );
        window.add( txtA );
        window.add( new JLabel("B:  ", SwingConstants.RIGHT) );
        window.add( txtB );
        window.add( new JLabel("Operation:  ", SwingConstants.RIGHT) );
        window.add( ops );
        window.add( new JLabel("Result:  ", SwingConstants.RIGHT) );
        window.add( txtC );

        /* Below is approach using anonymous class        
        ActionListener listener = new ActionListener() { 
            public void actionPerformed(ActionEvent event) {
                JOptionPane.showMessageDialog(null, "" + ops.getSelectedItem());
            }
        };
        */

        ActionListener listener = new OperationComputer();
        ops.addActionListener( listener );

        txtC.setEditable( false );
        setFont();
        window.setVisible(true);
    }
    private  JTextField txtA = new JTextField(0);
    private JTextField txtB = new JTextField(0);
    private  JTextField txtC = new JTextField(0);
    private  JComboBox ops = new JComboBox();

    private class OperationComputer implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            double a = Double.parseDouble( txtA.getText());
            double b = Double.parseDouble( txtB.getText());
            double c = 0;
            String op = (String) ops.getSelectedItem();
            if (op.equalsIgnoreCase("add"))
                c = a + b;
            else if (op.equalsIgnoreCase("subtract"))
                    c = a - b;
            else if (op.equalsIgnoreCase("multiply"))
                    c = a * b;
            else if (op.equalsIgnoreCase("divide"))
                    c = a / b;
            txtC.setText("" + c);
        }
    }
    private void setFont() {
        ops.setFont( new Font("SansSerif", Font.BOLD, 24) );        
        txtA.setFont( new Font("SansSerif", Font.BOLD, 24) );
        txtB.setFont( new Font("SansSerif", Font.BOLD, 24) );
        txtC.setFont( new Font("SansSerif", Font.BOLD, 24) );
 }
    public static void main(String[] args ) {
        new SimpleCalculator();
    }
}