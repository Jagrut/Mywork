
package gui;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.HashMap;

public class StudentForm extends JFrame
{
    JFrame frm=new JFrame();
    
    HashMap<Integer,Student> data=new HashMap<Integer, Student>();
    
    JTextField t1=new JTextField();
    JTextField t2=new JTextField();
    JTextField t3=new JTextField();
    JTextField t4=new JTextField();

    JButton b1=new JButton("Show");
    JButton b2=new JButton("Delete");
    JButton b3=new JButton("Save");  

  public StudentForm()
  {
   frm.setTitle("Student Data Entry Form");
   frm.setSize(300,500);
   frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   frm.setVisible(true);
   frm.setLayout(new GridLayout(6,3));

   frm.add(new JLabel("ID",SwingConstants.RIGHT));
   frm.add(t1);

   frm.add(new JLabel("Name",SwingConstants.RIGHT));
   frm.add(t2);

   frm.add(new JLabel("DOB",SwingConstants.RIGHT));
   frm.add(t3);
  
   frm.add(new JLabel("CPI",SwingConstants.RIGHT));
   frm.add(t4);

   frm.add(b1);
   frm.add(b2);
   frm.add(b3);
	
   b1.addActionListener(new StudentForm.StuData());
   b2.addActionListener(new StudentForm.StuData());
   b3.addActionListener(new StudentForm.StuData());
   }
  
  public class StuData implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
       {
          if(e.getActionCommand()=="Show")
            {
		try{
                  Integer.parseInt(t1.getText());
                  }
                  catch(NumberFormatException ex)
                  {
                          JOptionPane.showMessageDialog(null,"Invalid ID");
                   }

             /* if(t1.getText()=="")
                {
                  JOptionPane.showMessageDialog(null,"Please enter ID !");
                 }*/
            
              //else
              // {
                 Student s;
                 s=data.get(Integer.parseInt(t1.getText()));
                // System.out.println(s);
                 t1.setText(Integer.toString(s.getID()));
                 t2.setText(s.getName());
                 t3.setText(s.getDOB());
                 t4.setText(Double.toString(s.getCPI()));
               // }
       
             }

          if(e.getActionCommand()=="Delete")
            {
              try{
                 Integer.parseInt(t1.getText());
                 }
                 catch(NumberFormatException ex)
                 {
                         JOptionPane.showMessageDialog(null,"Invalid ID");
                 }

             
                 data.remove(Integer.parseInt(t1.getText()));
                
             }

          if(e.getActionCommand()=="Save")
            {

		try{	
		Integer.parseInt(t1.getText());
		}
		catch(NumberFormatException ex)
		{
			JOptionPane.showMessageDialog(null,"Invalid ID");
		}
              
                  Student s1=new Student(Integer.parseInt(t1.getText()),t2.getText(),t3.getText(),Double.parseDouble(t4.getText()));   
		   data.put(Integer.parseInt(t1.getText()),s1);
                   t1.setText(null);
                   t2.setText(null);
                   t3.setText(null);
                   t4.setText(null);
                 }
             
        }
    }

       public static void main(String[] args)
        {
           new StudentForm();
         }
 }

