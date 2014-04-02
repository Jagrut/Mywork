
package gui;
import java.awt.geom.Point2D;
import java.awt.geom.Line2D;
import java.io.PrintStream;
import java.util.ArrayList;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class Polygon{
	ArrayList<Point2D.Double> list = new ArrayList<Point2D.Double>();
	int count = -1;
	public Polygon(){
			}
	
	public void addPoint(double x,double y){
			Point2D.Double p = new Point2D.Double(x,y);
			list.add(p);
			count++;
			}
	public void addPoint(Point2D.Double p){
			list.add(p);
			count++;
			}

	public double perimeter(){
			double dist=0;
			if(count>=2)
			       { 
				for(int i=0;i<count;i++){
					dist = dist + list.get(i).distance(list.get(i+1));
					}
				dist = dist + list.get(0).distance(list.get(count));
				return dist;
				}
			else return 0;
			} 
	public double area(){
			double area = 0;
			if(count>=2)
				{
				 list.add(list.get(0));  
			 	 for(int i = 0;i<=count;i++){
					area = area + list.get(i).getX() * list.get(i+1).getY() - list.get(i+1).getX() * list.get(i).getY();
					}
				 return Math.abs(area/2);
				}
			else return 0;
			}
	public void print(PrintStream out){
			for(Point2D.Double num: list){
		        	out.println(num);
				}
			}

       public void draw(Graphics2D g2){

			for(int i = 0; i<=count;i++){
				Line2D.Double l = new Line2D.Double(list.get(i),list.get(i+1));
				g2.draw(l);
				}
			}				
}
