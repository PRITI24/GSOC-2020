import java.util.*;
class node
{
	node left,right;
	int data;
	node(int d)
	{
		left=null;
		right=null;
		data=d;
	}
}
class list
{
	node root;
	list()
	{
		root=null;
	}
	public void accept()
	{
		Scanner sc=new Scanner(System.in);
		int ans=1;
		while(ans==1)
		{
			System.out.println("Enter data of the node : ");
			int data=sc.nextInt();
			node n=new node(data);
			if(root==null)
			{
				root=n;
			}
			else
			{
				int flag=0;
				node temp=root;
				while(flag==0)
				{
				if(n.data<temp.data)
				{
					while(temp.left!=null) {
					temp=temp.left;}
					temp.left=n;
					n=temp;
					flag=1;
				}
				if(n.data>temp.data)
				{
					while(temp.right!=null) {
					temp=temp.right;}
					temp.right=n;
					n=temp;
					flag=1;
				}
				}
			}
			System.out.println("do you want to add more nodes?(1/0)");
			ans=sc.nextInt();
		}
		sc.close();
	}
	void display()
	{
		node temp=root;
//		preorder(temp);
		nonrecursive(temp);
	}
	private void nonrecursive(node temp) {
		// TODO Auto-generated method stub
		Stack <node> s=new Stack<>();
		node ptr=root;
		while(ptr!=null || !s.empty())
		{
			while(ptr!=null)
			{
				System.out.println(ptr.data);
				s.push(ptr);
				ptr=ptr.left;
			}
			if(!s.empty())
			{
				ptr=s.pop();
				ptr=ptr.right;
			}
		}
		
	}
	@SuppressWarnings("unused")
	private void preorder(node temp) {
		// TODO Auto-generated method stub
		if(temp!=null) {
		System.out.println(temp.data+"    ");
		preorder(temp.left);
		preorder(temp.right);
	}
		
	}
}
public class trees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		list l=new list();
		l.accept();
		l.display();
		
	}

}
