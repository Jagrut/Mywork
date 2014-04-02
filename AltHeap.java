
package gui;
import java.util.Scanner;
public class AltHeap {

  public static void main(String[] args)
  {
      int n;
      Scanner sc=new Scanner(System.in);
      System.out.println("Enter the size of heap..");
      n=sc.nextInt();
      int[] heap=new int[n];
      int[] altheap=new int[n];
      
      System.out.println("Enter the elemets for heap..");
      for(int i=0;i<n;i++)
      {
        heap[i]=sc.nextInt();
      }
      buildAltHeap(heap,altheap,n);
      System.out.println("Elements of altered heap are..");
      for(int i=0;i<n;i++)
      {
        System.out.println(altheap[i]);
      }   
  }     
    
 public static void buildAltHeap(int[] heap,int[] altheap,int n)
 {
    int i=0,j,l=0,c,temp;
    
    while(i<n)
    { 
        
       if(l%2==0)
       {
         c=i+(int)Math.pow(2,l);
        if(c<=n)       
        {
          for(j=i;j<c;j++)
         {
           
           altheap[j]=heap[min(heap,n-i)];
           temp=heap[min(heap,n-i)];
           heap[min(heap,n-i)]=heap[n-i-1];
           heap[n-i-1]=temp;
           
           i++;
         }  
         
        l++;
        }
        else
       {
          for(j=i;j<n;j++)
         {
           
           altheap[j]=heap[min(heap,n-i)];
           temp=heap[min(heap,n-i)];
           heap[min(heap,n-i)]=heap[n-i-1];
           heap[n-i-1]=temp;
           
           i++;
         }  
         
        l++;
       }
       }
          
       
       if(l%2!=0)
       {
         c=i+(int)Math.pow(2,l);
         if(c<=n)
         {     
         for(j=i;j<c;j++)
         {
           altheap[j]=heap[max(heap,n-i)];
           temp=heap[max(heap,n-i)];
           heap[max(heap,n-i)]=heap[n-i-1];
           heap[n-i-1]=temp;
           
           i++;
         }  
          l++;
         }
       
        else
        {     
         for(j=i;j<n;j++)
         {
           altheap[j]=heap[max(heap,n-i)];
           temp=heap[max(heap,n-i)];
           heap[max(heap,n-i)]=heap[n-i-1];
           heap[n-i-1]=temp;
           
           i++;
         }  
          l++;
         }
       }   
    }    
 }     
  
 public static int min(int[] a,int size)
 {
   int min=a[0],j,y=0;
   for(j=0;j<size;j++)
   {
      if(a[j]<min)
      {
        min=a[j];
        y=j;
      }  
   }
   return y;
 }      
 
 public static int max(int[] a,int size)
 {
   int max=a[0],j,y=0;
   for(j=0;j<size;j++)
   {
      if(a[j]>max)
      {
        max=a[j];
        y=j;
      }  
   }
   return y;
 }      
}

