/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package db1;
//package demo;    //change package name accordingly
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class myGUI {
    static JTextField t1,t2,t3,t4,t5,t6;
    static Connection connection;
    static PreparedStatement ps;
    static ResultSet rs;
    public static void main(String[] args) {
        JFrame frame= new JFrame();
        frame.setTitle("Software Development Database");
        frame.setLayout(new GridLayout(8,1));
        frame.setSize(500,600);
        frame.setResizable(false);
        JPanel panel0=new JPanel();
        JLabel l0=new JLabel("Software Project Table",JLabel.CENTER);
        l0.setFont(new Font("Arial",0,32));
        panel0.add(l0);
        frame.add(panel0);
        
        JPanel panel1=new JPanel(new GridLayout(1,2));
        JLabel l1=new JLabel("project id(pid) :",JLabel.RIGHT);
        l1.setFont(new Font("Arial",0,18));
        t1=new JTextField(50);
        panel1.add(l1);
        panel1.add(t1);
        frame.add(panel1);
        
        JPanel panel2=new JPanel(new GridLayout(1,2));
        JLabel l2=new JLabel("Project name(name) :",JLabel.RIGHT);
        l2.setFont(new Font("Arial",0,18));
        t2=new JTextField(50);
        panel2.add(l2);
        panel2.add(t2);
        frame.add(panel2);
        
        JPanel panel3=new JPanel(new GridLayout(1,2));
        JLabel l3=new JLabel("category :",JLabel.RIGHT);
        l3.setFont(new Font("Arial",0,18));
        t3=new JTextField(50);
        panel3.add(l3);
        panel3.add(t3);
        frame.add(panel3);
        
        JPanel panel4=new JPanel(new GridLayout(1,2));
        JLabel l4=new JLabel("budget(pbudget) :",JLabel.RIGHT);
        l4.setFont(new Font("Arial",0,18));
        t4=new JTextField(50);
        panel4.add(l4);
        panel4.add(t4);
        frame.add(panel4);
        
        JPanel panel5=new JPanel(new GridLayout(1,2));
        JLabel l5=new JLabel("start date :",JLabel.RIGHT);
        l5.setFont(new Font("Arial",0,18));
        t5=new JTextField(50);
        panel5.add(l5);
        panel5.add(t5);
        frame.add(panel5);
        
        JPanel panel6=new JPanel(new GridLayout(1,2));
        JLabel l6=new JLabel("deadline :",JLabel.RIGHT);
        l6.setFont(new Font("Arial",0,18));
        t6=new JTextField(50);
        panel6.add(l6);
        panel6.add(t6);
        frame.add(panel6);
        
        JPanel panel7=new JPanel();
        panel7.setSize(10, 700);
        JButton insert=new JButton("Insert");
        JButton select=new JButton("Select");
        JButton delete=new JButton("Delete");
        insert.addActionListener(new InsertButtonClickListener());
        select.addActionListener(new SelectButtonClickListener());
        delete.addActionListener(new DeleteButtonClickListener());
        panel7.add(insert);
        panel7.add(select);
        panel7.add(delete);
        frame.add(panel7);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }

    private static class InsertButtonClickListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String pid=t1.getText();
            String name=t2.getText();
            String cat=t3.getText();
            String bud=t4.getText();
            String start=t5.getText();
            String deadline=t6.getText();
            try{
            Class.forName("org.postgresql.Driver");
            //connection = DriverManager.getConnection("jdbc:postgresql://localhost:5418/Software_Development","postgres", "l;'");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Software_Development","postgres", "l;'");
            ps =connection.prepareStatement("insert into \"software_project\" values(?,?,?,?,?,?)");
            ps.setString(1, pid);
            ps.setString(2, cat);
            ps.setString(3, name);
            ps.setInt(4,Integer.parseInt(bud));
            ps.setDate(5,Date.valueOf(start));
            ps.setDate(6,Date.valueOf(deadline));
            ps.executeUpdate();
            connection.close();
            }catch(Exception e1){}
        }
    }
private static class SelectButtonClickListener  implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String pid=t1.getText();
            String name=t2.getText();
            String cat=t3.getText();
            String bud=t4.getText();
            String start=t5.getText();
            String deadline=t6.getText();
            try{
            Class.forName("org.postgresql.Driver");
//            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5418/Software_Development","postgres", "l;'");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Software_Development","postgres", "l;'");
            String temp = " ";
            int flag=0;
            if( !"".equals(pid)){
            flag=1;
                temp=temp.concat("pid='"+pid+"' ");
            }
            if( !"".equals(name)){
            if(flag==1)temp=temp.concat("and name='"+name+"' ");
            else temp=temp.concat("name='"+name+"' ");
            flag=1;
                    
            }
            if( !"".equals(cat)){
                if(flag==1)temp=temp.concat("and category='"+cat+"' ");
                else temp=temp.concat("category='"+cat+"' ");
                flag=1;
            }
            if( !"".equals(bud)){
                if(flag==1)temp=temp.concat("and pbudget="+Integer.parseInt(bud)+" ");
                else temp=temp.concat("pbudget="+Integer.parseInt(bud)+" ");
                flag=1;
                
            }
            if( !"".equals(start)){
                if(flag==1)temp=temp.concat("and start_date='"+start+"' ");
                else temp=temp.concat("start_date='"+start+"' ");
                flag=1;
                
            }
            if( !"".equals(deadline)){
                if(flag==1)temp=temp.concat("and deadline='"+deadline+"' ");
                else temp=temp.concat("deadline='"+deadline+"' ");
                flag=1;
           }
            if(flag==0){
                temp="select * from \"software_project\"";
            }
            else{
                temp="select * from \"software_project\" where ".concat(temp);
            }
                ps=connection.prepareStatement(temp);
                  ResultSet rs=ps.executeQuery();
            
                if (rs != null)
                while(rs.next()) {
                    int i = 1;
                    while(i <= 6){
                        String fname = rs.getString(i);
                        System.out.print(fname + "   ");
                        i++;
                    }
                    System.out.println("");
                    
            }
            connection.close();
            }catch(Exception e1){}
    }
}
private static class DeleteButtonClickListener  implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String pid=t1.getText();
            String name=t2.getText();
            String cat=t3.getText();
            String bud=t4.getText();
            String start=t5.getText();
            String deadline=t6.getText();
            try{
            Class.forName("org.postgresql.Driver");
//            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5418/Software_Development","postgres", "l;'");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Software_Development","postgres", "l;'");
            String temp = " ";
            int flag=0;
            if( !"".equals(pid)){
            flag=1;
                temp=temp.concat("pid='"+pid+"' ");
            }
            if( !"".equals(name)){
            if(flag==1)temp=temp.concat("and name='"+name+"' ");
            else temp=temp.concat("name='"+name+"' ");
            flag=1;
                    
            }
            if( !"".equals(cat)){
                if(flag==1)temp=temp.concat("and category='"+cat+"' ");
                else temp=temp.concat("category='"+cat+"' ");
                flag=1;
            }
            if( !"".equals(bud)){
                if(flag==1)temp=temp.concat("and pbudget="+Integer.parseInt(bud)+" ");
                else temp=temp.concat("pbudget="+Integer.parseInt(bud)+" ");
                flag=1;
                
            }
            if( !"".equals(start)){
                if(flag==1)temp=temp.concat("and start_date='"+start+"' ");
                else temp=temp.concat("start_date='"+start+"' ");
                flag=1;
                
            }
            if( !"".equals(deadline)){
                if(flag==1)temp=temp.concat("and deadline='"+deadline+"' ");
                else temp=temp.concat("deadline='"+deadline+"' ");
                flag=1;
           }
            if(flag==1){
                temp="delete from \"software_project\" where ".concat(temp);
            }
            else temp=" ";
                System.out.println(temp);
            ps=connection.prepareStatement(temp);
                ps.executeUpdate();
                connection.close();
            }catch(Exception e1){}
    }
}
}