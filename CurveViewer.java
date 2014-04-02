
package gui;

import javax.swing.JFrame;
public class CurveViewer
{
  public static void main(String[] args)
     {
      JFrame frm=new JFrame();
      frm.setSize(500,500);
      frm.setTitle("CurveViewer");
      frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frm.setVisible(true);
      
      CurveComponent c=new CurveComponent();
      frm.add(c);
     }
}
