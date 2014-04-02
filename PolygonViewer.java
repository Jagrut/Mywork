
package gui;
import javax.swing.JFrame;

public class PolygonViewer{

	public static void main(String[] args){
	
	JFrame frame = new JFrame();
		
	frame.setSize(500,500);
	frame.setTitle("Curve");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	PolygonComponent comp = new PolygonComponent();
	frame.add(comp);
	frame.setVisible(true);
}
}

