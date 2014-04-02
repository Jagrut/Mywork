package gui;
import java.util.Scanner;
import java.util.StringTokenizer;
public class Bst {
    int d=0;
    static Node root;
public static void main(String[] args){
    int nodecounter=0;
    Scanner sc=new Scanner(System.in);
    Scanner str=new Scanner(System.in);
    System.out.println("how many lines?");
    int n=sc.nextInt();
    Bst t=new Bst();
    for(int i=0; i<n; i++)
    {
    String op=str.nextLine();
    String temp=op.substring(0,2);
    if(temp.equals("I ")){
    int d=Integer.parseInt(temp.substring(2));
    nodecounter++;
    t.bstTree(root,d,nodecounter);
    System.out.println("ok");
    }
    if(temp.equals("F ")){
    String t2=temp.substring(2);
    int d=Integer.parseInt(t2);
    search(root,d);
    }
    if(temp.equals("F ")){
    int d=Integer.parseInt(temp.substring(2));
    successor(root,d,nodecounter);
    }
    if(temp.equals("P ")){
    int d=Integer.parseInt(temp.substring(2));
    predece(root,d,nodecounter);
    }
    if(temp.equals("M")){
        maximum(root);
    }
    if(temp.equals("m")){
        minimum(root);
    }
    }
}
public void bstTree(Node root,int k,int n){
        int i;
        if(d==0){
        root.key=k;
        d=1;
        return;
        }

        Node x=root;
        for(i=1; i<n; i++)
        {
        x=root;
        for(int j=1; j<=i; j++)
        {
        if(k<x.key)
        {
            if(x.lc==null)
            {
                Node temp=new Node(k);
                x.lc=temp;
                x.lc.parent=x;
            }
            x=x.lc;
        }
        else if(k>x.key)
        {
            if(x.rc==null)
            {
                Node temp=new Node(k);
                x.rc=temp;
                x.rc.parent=x;
            }
            x=x.rc;
        }
        }

}
}
public static class Node{
Node lc;
Node rc;
Node parent;
int key;
public Node(int key){
this.key=key;
}
}
public static void maximum(Node root)
{
    if(root==null)
    {
        System.out.println("-1");
        return;
    }
    Node x=root;
    boolean b=true;
    while(b){
            if(x.rc==null)
            {
                System.out.println(x.key);
                break;
            }
            x=x.rc;
            }
}

public static void minimum(Node root)
{
    if(root==null)
    {
        System.out.println("-1");
        return;
    }
    Node x=root;
    boolean b=true;
    while(b){
            if(x.lc==null)
            {
                System.out.println(x.key);
                break;

            }
            x=x.lc;
            }
}

public static void search(Node root,int k){
    Node x=root;
    if(x.key==k)
       System.out.println("1");
    while(x!=null)
    {
    if(k<x.key)
    {
	x=x.lc;
    }

    else if(k>x.key)
    {
        x=x.rc;
    }
    else
    {
     System.out.println("1");
     break;
    }
 }
    System.out.println("-1");
}
public static void successor(Node root,int k,int n){
    Node x=root;
    Node y;
    int c=0;
    while(x!=null)
    {
    if(k<x.key)
    {
	x=x.lc;
    }

    else if(k>x.key)
    {
        x=x.rc;
    }
    else
    {
     c=1;
     break;
    }
 }
    if(c==1)
    {
     if(x.rc!=null)
    {
    minimum(x.rc);
    }
    else if(x.rc==null)
    {
	if(x.parent==null)
		System.out.println("-1");
        else
        {
	   for(int i=0; i<n; i++)
            {
	    y=x.parent;
            if(y==null)
                {
                System.out.println("-1");
                break;
                }
           if(y.lc==null)
            {
                x=x.parent;
                continue;
            }
	    if(y.lc.key==x.key)
		{
		System.out.println(y.key);
		break;
		}
	    x=x.parent;
            }
	}
    }
    }

else
{
    System.out.println("-1");
}
}


public static void predece(Node root,int k,int n){
    Node x=root;
    Node y;
    int c=0;
    while(x!=null)
    {
    if(k<x.key)
    {
	x=x.lc;
    }

    else if(k>x.key)
    {
        x=x.rc;
    }
    else
    {
     c=1;
     break;
    }
    }
    if(c==1)
    {
     if(x.lc!=null)
    {
    maximum(x.lc);
    }
    else if(x.lc==null)
    {
	if(x.parent==null)
		System.out.println("-1");
        else
	{
	    boolean b=true;
            for(int i=0; i<n; i++)
            {
	    y=x.parent;
            if(y==null)
                {
                System.out.println("-1");
                break;
                }
           if(y.rc==null)
            {
                x=x.parent;
                continue;
            }
	    if(y.rc.key==x.key)
		{
		System.out.println(y.key);
		break;
		}
	    x=x.parent;
            }
	}
    }
    }
    else
        System.out.println("-1");
}
}