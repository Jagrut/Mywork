
package gui;

import java.util.Scanner;


public class Treap {

   public static void main(String[] args)
   { 
        Scanner sc=new Scanner(System.in);
        
        System.out.println("How many nodes you want to enter..??");
        int n=sc.nextInt();
        System.out.println("Enter 1st tree value and after it min heap value for each node");
        Node[] A=new Node[n];
        int j;
        for(j=0;j<n;j++)
        {
            int t1=sc.nextInt();
            int t2=sc.nextInt();
            
            A[j]=new Node(t1,t2);
            

          System.out.println();
        }
        
        treapify(A,n);
        printchild(A);
        printparent(A);
       
       
       
   }
   
   public static void treapify(Node[] A,int n)
   {
       sortNodesbyHeap(A);
       
       
       for(int j=1;j<n;j++)
       {
          if(A[j].tree_key > A[0].tree_key)
          {
             rt[r]=A[j];
             r++;
          }  
          else if(A[j].tree_key < A[0].tree_key)
          {
             lt[l]=A[j];
             l++;
          }
       }
      if(l!=0) 
      {   A[0].l_child=lt[0];
       lt[0].parent=A[0];
      }
      if(r!=0) 
      {
          A[0].r_child=rt[0];
          rt[0].parent=A[0];
      }
       
       
       
     if(r!=0)
     {    
       for(int i=1;i<r;i++)
       {
           int x=0,y=0;
          for(int j=0;i>j;j++)
          {
             if(rt[j].r_child==null && ((rt[j].tree_key>rt[j].parent.tree_key && rt[i].tree_key>rt[j].parent.tree_key )||(rt[j].tree_key<rt[j].parent.tree_key && rt[i].tree_key<rt[j].parent.tree_key)))
             {
               if(rt[i].tree_key > rt[j].tree_key && x==0)
               {
                  rt[j].r_child=rt[i];
                  rt[i].parent=rt[j];
                  x++;
               }
             }   
             
             if(rt[j].l_child==null && ((rt[j].tree_key>rt[j].parent.tree_key && rt[i].tree_key>rt[j].parent.tree_key )||(rt[j].tree_key<rt[j].parent.tree_key && rt[i].tree_key<rt[j].parent.tree_key)))
             {
               if(rt[i].tree_key < rt[j].tree_key && y==0)
               {
                  rt[j].l_child=rt[i];
                  rt[i].parent=rt[j];
                  y++;
               }
             } 
             
          }  
              
        }   
     }
     
     if(l!=0)
     {    
       
       for(int i=1;i<l;i++)
       { 
           int x=0,y=0;
          for(int j=0;i>j;j++)
          {  
             if(lt[j].r_child==null && ((lt[j].tree_key>lt[j].parent.tree_key && lt[i].tree_key>lt[j].parent.tree_key )||(lt[j].tree_key<lt[j].parent.tree_key && lt[i].tree_key<lt[j].parent.tree_key)))
             {
               if(lt[i].tree_key > lt[j].tree_key && x==0)
               {
                  lt[j].r_child=lt[i];
                  lt[i].parent=lt[j];
                  x++;
               }
             }   
             
             if(lt[j].l_child==null && ((lt[j].tree_key>lt[j].parent.tree_key && lt[i].tree_key>lt[j].parent.tree_key )||(lt[j].tree_key<lt[j].parent.tree_key && lt[i].tree_key<lt[j].parent.tree_key)))
             {
               if(lt[i].tree_key < lt[j].tree_key && y==0)
               {
                  lt[j].l_child=lt[i];
                  lt[i].parent=lt[j];
                  y++;
               }
             } 
             
          }  
              
        }
     } 
   }
   
  public static void printchild(Node A[])
  {
     
   if(r!=0) 
   {   
     System.out.println("Right child of root"+A[0].tree_key+" ,"+ A[0].heap_key+" is "+rt[0].tree_key+" ,"+rt[0].heap_key);
    for(int i=0;i<r;i++)
    {
       if(rt[i].l_child!=null && rt[i].r_child!=null)
        System.out.println("Children of "+rt[i].tree_key+" ,"+ rt[i].heap_key + " are" +rt[i].l_child.tree_key+" ,"+rt[i].l_child.heap_key+" and" +rt[i].r_child.tree_key+" ,"+rt[i].r_child.heap_key );
       
       else if(rt[i].l_child!=null)
         System.out.println("Left child of "+rt[i].tree_key+" ,"+ rt[i].heap_key + " is" +rt[i].l_child.tree_key+" ,"+rt[i].l_child.heap_key);
       
      else if(rt[i].r_child!=null)
         System.out.println("Right child of "+rt[i].tree_key+" ,"+ rt[i].heap_key + " is" +rt[i].r_child.tree_key+" ,"+rt[i].r_child.heap_key); 
      }
   }
   
   if(l!=0)
   {   
    System.out.println("Left child of root"+A[0].tree_key+" ,"+ A[0].heap_key + " is" +lt[0].tree_key+" ,"+lt[0].heap_key);   
    for(int i=0;i<l;i++)
    {
       if(lt[i].l_child!=null && lt[i].r_child!=null)
        System.out.println("Children of "+lt[i].tree_key+" ,"+ lt[i].heap_key + " are" +lt[i].l_child.tree_key+" ,"+lt[i].l_child.heap_key+" and" +lt[i].r_child.tree_key+" ,"+lt[i].r_child.heap_key );
       
       else if(lt[i].l_child!=null)
         System.out.println("Left child of "+lt[i].tree_key+" ,"+ lt[i].heap_key + " is" +lt[i].l_child.tree_key+" ,"+lt[i].l_child.heap_key);
       
      else if(lt[i].r_child!=null)
         System.out.println("Right child of "+lt[i].tree_key+" ,"+ lt[i].heap_key + " is" +lt[i].r_child.tree_key+" ,"+lt[i].r_child.heap_key); 
     }
   }
  }      
        
  public static void printparent(Node[] A)
  {
     System.out.println("Parent of root "+A[0].tree_key+","+A[0].heap_key+" is null");
    if(r!=0)
    {     
     for(int i=0;i<r;i++)
     {
      System.out.println("Parent of "+rt[i].tree_key+","+rt[i].heap_key+" is "+rt[i].parent.tree_key+","+rt[i].parent.heap_key);
     }
    }
    
    if(l!=0)
   {     
    for(int i=0;i<l;i++)
    {
      System.out.println("Parent of "+lt[i].tree_key+","+lt[i].heap_key+" is "+lt[i].parent.tree_key+","+lt[i].parent.heap_key);
    }
   }
  
  } 
   
  
       public static void sortNodesbyHeap(Node[] A)
    {
       for(int j=0;j<=A.length-1;j++)
       {
          for(int m=0;m<A.length-1;m++)
          {
            if(A[m].heap_key>A[m+1].heap_key)
            {
              Node y;
              y=A[m];
              A[m]=A[m+1];
              A[m+1]=y;
            }
          }
       }
    }
       
   public static class Node
  {
    int tree_key,heap_key;
    Node parent,l_child,r_child;
    
     public Node(int tree_key,int heap_key){
        this.tree_key=tree_key;    
        this.heap_key=heap_key; 
     }
             
  }
   
  static Node rt[]=new Node[15];
  static Node lt[]=new Node[15]; 
  static int r=0,l=0;
}

