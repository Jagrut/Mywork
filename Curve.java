

package gui;
//import java.lang.Math;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
public class Curve
{

  public double a,b,c,d,x,y,d1=4;
  public Curve(double a,double b,double c,double d)
      {
         this.a=a;
         this.b=b;
         this.c=c;
         this.d=d;
       }
  public double getY(double x)
   {
    y=a*Math.pow(x,3) + b*Math.pow(x,2) + c*x + d;
    return y;
    }
  public void draw(Graphics2D g2)
   {	
//	Graphics2D g2=(Graphics2D)g;
     for(x=0;x<100;x++)
        {
          Point2D.Double x1= new Point2D.Double(x*d1,this.getY(x*d1));
          Point2D.Double x2= new Point2D.Double((x*d1)+d1,this.getY((x*d1)+d1));
          Line2D.Double l= new Line2D.Double(x1,x2);
          g2.draw(l);
         }
    }
}
