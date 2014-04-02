

package gui;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.Graphics;
public class PolygonComponent extends JComponent{ 
		public void paintComponent(Graphics g) {
		
			Graphics2D gr1 =  (Graphics2D) g;
//			Graphics2D gr2 =  (Graphics2D) g;

			Polygon sqr = new Polygon();
			Polygon pen = new Polygon();
			sqr.addPoint(0,0);	
			sqr.addPoint(0,10);
			sqr.addPoint(10,10);
			sqr.addPoint(10,0);
			pen.addPoint(0,0);
			pen.addPoint(0,20);
			pen.addPoint(10,20);
			pen.addPoint(20,20);
			pen.addPoint(20,0);
	
			sqr.draw(gr1);
//			pen.draw(gr2);
		}
}
