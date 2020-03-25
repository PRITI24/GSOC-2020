import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.*;
import org.checkerframework.checker.index.qual.*;
class pair implements Comparator<pair>
{
	int node;
	int heuristic_value;
	
	public pair(int node,int heuristic_value)
	{
	this.node=node;
	this.heuristic_value=heuristic_value;
	}
	
	public pair()
	{

	}
	
	public int compare(pair p1,pair p2)
	{
		if(p1.heuristic_value<p2.heuristic_value)
		{
			return -1;
		}
		else if(p1.heuristic_value>p2.heuristic_value)
		{
			return 1;
		}
	return 0;
	}
}
class graph
{
Scanner sc=new Scanner(System.in);
int v,e;
int mat[][]=new int[20][20];
int heuristics[];
void accept()
{
@IndexFor("this.mat") int start,end;
int weight;
System.out.println("Enter the number of vertices: ");
v=sc.nextInt();
heuristics=new int[v];
pair p[]=new pair[v];
System.out.println("Enter the number of edges: ");
e=sc.nextInt();
for(int i=1;i<=e;i++)
{
System.out.println("Enter the starting vertex: ");
start=sc.nextInt();

System.out.println("Enter the ending vertex: ");
end=sc.nextInt();

System.out.println("Enter the weight: ");
weight=sc.nextInt();

mat[start][end]=weight;
mat[end][start]=weight;
}
for(int i=0;i<v;i++)
{
System.out.println("enter heuristic value of:"+i);
int n=sc.nextInt();
heuristics[i]=n;
p[i]=new pair(i,n);
}

}
public int heuristicreturn1(@Positive int n)
{
		for(int i=0;i<v;i++)
		{
			if(i==n)
			{
				return heuristics[i];
			}
		}
		return 0;
}
public void bestfirstsearch()
{

@LTLengthOf("this.heurstics") int start_vertex; //pair p[]=new pair[v];
PriorityQueue<pair> pg=new PriorityQueue<pair>(this.v,new pair());
int visited[]=new int[v];
@Positive int end_vertex;
System.out.println("enter start vertex");
start_vertex=sc.nextInt();
System.out.println("enter end vertex");
end_vertex=sc.nextInt();

int temp=0;
	
heuristics[end_vertex]=0;

pair p=new pair(start_vertex,heuristics[start_vertex]);
pair p3=new pair(end_vertex,heuristics[end_vertex]);
pg.add(p);
visited[start_vertex]=1;

int arr[]=new int[v];
@LTLengthOf("arr") int j=0;
while(!pg.isEmpty())
{
pair p1=pg.remove();
int node=p1.node;
arr[j++]=node;
	
int heuristic=p1.heuristic_value;
	
if(p1.node==p3.node && p1.heuristic_value==p3.heuristic_value)
{
//System.out.println("goal state is reached");
break;
}
for(int i=0;i<v;i++)
{
if(mat[node][i]>=1 && visited[i]==0)
{
int h=heuristicreturn1(i);
pair p2=new pair(i,h);
pg.add(p2);
visited[i]=1;
}
}
}

//after goal state reached

for(int i=0;i<v;i++){
System.out.print(arr[i]+"\t");		//stores close list
}
System.out.println("");
@Positive int o=arr.length-1;
while(arr[o]==0){
o--;
}
int arr1[]=new int[v];
@NonNegative int r=0;

int temp2=end_vertex;
arr1[r++]=temp2;
while(temp2!=start_vertex)
{
for(int i=0;i<v;i++)
{
if(mat[arr[i]][temp2]>=1)
{
arr1[r++]=arr[i];
temp2=arr[i];
break;
}
}
}
int ans=0;
for(int i=0;i<v;i++)
{
if(arr1[i]==start_vertex)
{
ans=i;
break;
}
}
System.out.println("path is:");
for(int i=ans;i>=0;i--){
System.out.print(arr1[i]+"\t");
}
int cost=0;
@IndexFor("arr") int v=r-1;
int end=arr1[v];
v--;
while(end!=end_vertex)
{
cost=cost+mat[end][arr1[v]];
end=arr1[v];
v--;
}
System.out.println("\ncost of path = "+cost);
}
}

public class bestfirstsearch {
	public static void main(String[] args) {
			// TODO Auto-generated method stub
			graph g=new graph();
			g.accept();
			g.bestfirstsearch();
	}
}
/*OUTPUT:-
 * 
Enter the number of vertices: 
5
Enter the number of edges: 
7
Enter the starting vertex: 
0
Enter the ending vertex: 
1
Enter the weight: 
1
Enter the starting vertex: 
0
Enter the ending vertex: 
2
Enter the weight: 
4
Enter the starting vertex: 
1
Enter the ending vertex: 
2
Enter the weight: 
2
Enter the starting vertex: 
1
Enter the ending vertex: 
3
Enter the weight: 
5
Enter the starting vertex: 
1
Enter the ending vertex: 
4
Enter the weight: 
12
Enter the starting vertex: 
2
Enter the ending vertex: 
3
Enter the weight: 
2
Enter the starting vertex: 
3
Enter the ending vertex: 
4
Enter the weight: 
3
enter heuristic value of:0
7
enter heuristic value of:1
6
enter heuristic value of:2
2
enter heuristic value of:3
1
enter heuristic value of:4
0
enter start vertex
0
enter end vertex
4
path is:
0	2	3	4	
cost of path = 9

 * 
 * 
 */
