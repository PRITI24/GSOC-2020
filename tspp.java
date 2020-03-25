package tsp;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import org.checkerframework.checker.index.qual.*;

class graph
{
Scanner sc=new Scanner(System.in);
int v,e;
int mat[][]=new int[20][20];

void accept()
{
@IndexOf("mat") int start,end;
int weight;
System.out.println("Enter the number of vertices: ");
@Positive v=sc.nextInt();
System.out.println("Enter the number of edges: ");
@Positive e=sc.nextInt();


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

}

void display()
{
for(int i=0;i<v;i++)
{
for(int j=0;j<v;j++)
{
System.out.print(mat[i][j]+"\t");
}
System.out.println();
}

}

void dfs_1()
{
@LTLengthOf("mat") Stack <Integer> s=new Stack<Integer> ();
System.out.println("Enter the starting vertex: ");

@IndexOf("visited") int start=sc.nextInt();
int visited[]=new int[v];

s.push(start);
visited[start]=1;
System.out.print("Path :    "+start+"     ");
@IndexOf("visited") int vertex=1;
int cost=0;
int min=Integer.MAX_VALUE;

while(!s.isEmpty())
{
int flag=0;
int ele=s.peek();

min=Integer.MAX_VALUE;

for(int i=0;i<v;i++)
{
if(mat[ele][i]<min && visited[i]==0 && mat[ele][i]!=0)
{
min=mat[ele][i];
vertex=i;
flag=1;

}
}

if(flag==0)
{
s.pop();
}
else
{
cost=cost+min;
s.push(vertex);
System.out.print(vertex+"     ");
visited[vertex]=1;

}

}
System.out.println("\ncost = "+cost);
}

}
public class tspp {

/**
* @param args
*/
public static void main(String[] args) {
// TODO Auto-generated method stub
graph g=new graph();
g.accept();
g.display();
g.dfs_1();
}

}
/*OUTPUT:-
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
1
Enter the ending vertex: 
2
Enter the weight: 
7
Enter the starting vertex: 
2
Enter the ending vertex: 
3
Enter the weight: 
6
Enter the starting vertex: 
3
Enter the ending vertex: 
4
Enter the weight: 
3
Enter the starting vertex: 
0
Enter the ending vertex: 
4
Enter the weight: 
4
Enter the starting vertex: 
0
Enter the ending vertex: 
3
Enter the weight: 
2
Enter the starting vertex: 
1
Enter the ending vertex: 
4
Enter the weight: 
3
0	1	0	2	4	
1	0	7	0	3	
0	7	0	6	0	
2	0	6	0	3	
4	3	0	3	0	
Enter the starting vertex: 
0
Path :    0     1     4     3     2     
cost = 13

 */
