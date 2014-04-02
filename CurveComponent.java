
package gui;
import javax.swing.JComponent;
import java.awt.Graphics2D;
import java.awt.Graphics;

public class CurveComponent extends JComponent
{
  public void paintComponent(Graphics g)
        {
           Graphics2D g2=(Graphics2D) g;
           Curve cur=new Curve(0.00005,-0.03,4,200);
           cur.draw(g2);
        
          }
}