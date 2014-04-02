
package gui;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.ActionListener;

public class PollSimulator {

    int[] count = new int[5];
    JFrame frm = new JFrame();
    JButton b1 = new JButton("C1");
    JButton b2 = new JButton("C2");
    JButton b3 = new JButton("C3");
    JButton b4 = new JButton("C4");
    JButton b5 = new JButton("C5");
    JButton b6 = new JButton("Data");

    public PollSimulator() {
        
        for (int i = 0; i < 5; i++) {
            count[i] = 0;
        }
        
        frm.setSize(300, 300);
        frm.setTitle("Voting Scenario");
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setLayout(new GridLayout(3,2));
        frm.add(b1);
        frm.add(b2);
        frm.add(b3);
        frm.add(b4);
        frm.add(b5);
        frm.add(b6);
        
        b1.addActionListener(new CountVote());
        b2.addActionListener(new CountVote());
        b3.addActionListener(new CountVote());
        b4.addActionListener(new CountVote());
        b5.addActionListener(new CountVote());
        b6.addActionListener(new CountVote());
        frm.setVisible(true);

    }

    class CountVote implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == b1) 
                count[0]++;
             else if (e.getSource() == b2) 
                count[1]++;
             else if (e.getSource() == b3) 
                count[2]++;
             else if (e.getSource() == b4) 
                count[3]++;
             else if (e.getSource() == b5) 
                count[4]++;
             else if (e.getSource() == b6) 
            {
                String s= JOptionPane.showInputDialog("Enter Password :");
                if(s.equals("qwert"))
                {            
                for (int i = 0; i < 5; i++) 
//                    System.out.println("Total votes of candidate " + (i + 1) + "are" + count[i]);
                    JOptionPane.showMessageDialog(null,"Total votes of candidate " + (i + 1) + " are :" + count[i]);
                 }
                else
                    JOptionPane.showMessageDialog(null,"Incorrect Password");
            }
        }
    }

    public static void main(String[] args) {
        new PollSimulator();
    }
}
