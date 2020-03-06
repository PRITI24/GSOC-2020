import java.util.*;
class pair implements Comparator<pair>
{
	int vertex;
	int matrix[][];
	int hn;
	int gn;//heuristic value of each node
	int fn;								//fn=hn+gn
	pair(int h,int g,int m[][])
	{
		hn=h;
		gn=g;
		matrix=m;
		fn=hn+gn;
	}
	pair()
	{

	}
	@Override
	public int compare(pair arg0, pair arg1) {
		// TODO Auto-generated method stub
		if(arg0.fn>arg1.fn)
		{
			return 1;
		}
		else
		{
			return -1;
		}

	}

}
class puzzle
{
	Scanner sc=new Scanner(System.in);
	int matrix[][]=new int[3][3];
	final int finalmatrix[][]=new int[3][3];
	int level=0;
	void accept()											//accept initial and final matrix and indicate blank tile with 0 
	{
		System.out.println("Initial Matrix:-");
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				matrix[i][j]=sc.nextInt();
			}
		}
		System.out.println("********************Initial***************************");
		print(matrix);
		System.out.println("Final Matrix");
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				finalmatrix[i][j]=sc.nextInt();
			}
		}
		System.out.println("********************Final***************************");
		print(finalmatrix);
		System.out.println("****************************************************");
	}

	void implement()
	{
		int g=0,flag=0;
		int count=0;
		while(checkgoal_reached(matrix,finalmatrix)!=true) {					//while goal state reached
			//position of blank tile
			count++;
			if(count>30) {System.out.println("Solution not possible!!!!");break;}
			g++;
			int i=0,j=0;
			flag=0;
			for(i=0;i<3;i++)													//searching blank tile and have position of blank tile in i,j
			{
				for(j=0;j<3;j++)
				{
					if(matrix[i][j]==0)
					{
						flag=1;
						break;
					}
				}
				if(flag==1)break;
			}
			//move tile
			matrix=movetile(i,j,matrix,g);									//move the blank tile
			System.out.println("Step "+(g)+" :");							//print the matrix
			print(matrix);
		}
	}	
	int[][] movetile(int mi,int nj,int[][] m,int g)
	{
		int h=0;
		PriorityQueue<pair> pq=new PriorityQueue<pair>(3,new pair());
		if(nj>=0 && nj<2)																	//when column is greater than 0 and less than 2,move right
		{
			m=moveright(mi,nj);
			h=calculateh(m);
			pair pr=new pair(h,g,m);
			pq.add(pr);
		}
		if(nj<=2 && nj>0)																	//when column is less than 2 and greater than 0,move left
		{	
			m=moveleft(mi,nj);
			h=calculateh(m);
			pair pl=new pair(h,g,m);
			pq.add(pl);
		}
		if(mi>=0 && mi<2)																	//when row is greater than 0 move down
		{

			m=movedown(mi,nj);
			h=calculateh(m);
			pair pd=new pair(h,g,m);
			pq.add(pd);
		}
		if(mi<=2 && mi>0)																	//when row is than 2 move up	
		{

			m=moveup(mi,nj);
			h=calculateh(m);
			pair p=new pair(h,g,m);
			pq.add(p);
		}
		pair f=pq.remove();
		return f.matrix;
	}

	boolean checkgoal_reached(int matrix[][],int finalmatrix[][])						//function for checking if goal is reached or not
	{
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(matrix[i][j]!=finalmatrix[i][j])
				{
					return false;
				}
			}
		}
		return true;
	}

	int[][] moveleft(int p,int q)											
	{

		int tempmatrix[][]=new int[3][3];
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				tempmatrix[i][j]=matrix[i][j];

			}
		}
		int swap=tempmatrix[p][q];
		tempmatrix[p][q]=tempmatrix[p][q-1];
		tempmatrix[p][q-1]=swap;
		return tempmatrix;
	}
	int[][] movedown(int s,int t)
	{
		int tempmatrix[][]=new int[3][3];
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				tempmatrix[i][j]=matrix[i][j];

			}
		}
		int swap=tempmatrix[s][t];
		tempmatrix[s][t]=tempmatrix[s+1][t];
		tempmatrix[s+1][t]=swap;
		return tempmatrix;
	}
	int[][] moveup(int n,int m)
	{
		int tempmatrix[][]=new int[3][3];
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				tempmatrix[i][j]=matrix[i][j];

			}
		}
		int swap=tempmatrix[n][m];
		tempmatrix[n][m]=tempmatrix[n-1][m];
		tempmatrix[n-1][m]=swap;
		return tempmatrix;

	}
	int[][] moveright(int p,int q)
	{
		int tempmatrix[][]=new int[3][3];
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				tempmatrix[i][j]=matrix[i][j];

			}
		}
		int swap=tempmatrix[p][q];
		tempmatrix[p][q]=tempmatrix[p][q+1];
		tempmatrix[p][q+1]=swap;
		return tempmatrix;
	}
	int calculateh(int[][] mat)
	{
		int h=0;
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(mat[i][j]!=finalmatrix[i][j])
				{
					h++;
				}
			}
		}
		return h;
	}
	void print(int[][] m)
	{
		System.out.println("___________________");
		for(int i=0;i<3;i++)
		{
			System.out.println("|     |     |     |");
			for(int j=0;j<3;j++)
			{
				if(m[i][j]==0)
					System.out.print("|  "+" "+"  ");
				else
					System.out.print("|  "+m[i][j]+"  ");
			}
			System.out.print("|\n");
			System.out.print("|_____|_____|_____|");
			System.out.println();
		}
		System.out.println();
	}
}
public class Eight_puzzle_astar {

	public static void main(String[] args) {
		puzzle p=new puzzle();
		p.accept();
		p.implement();
	}
}
/*
 * OUTPUT:-
 * 
Initial Matrix:-
1
2
3
0
4
6
7
5
8
********************Initial***************************
___________________
|     |     |     |
|  1  |  2  |  3  |
|_____|_____|_____|
|     |     |     |
|     |  4  |  6  |
|_____|_____|_____|
|     |     |     |
|  7  |  5  |  8  |
|_____|_____|_____|

Final Matrix
1
2
3
4
5
6
7
8
0
********************Final***************************
___________________
|     |     |     |
|  1  |  2  |  3  |
|_____|_____|_____|
|     |     |     |
|  4  |  5  |  6  |
|_____|_____|_____|
|     |     |     |
|  7  |  8  |     |
|_____|_____|_____|

****************************************************
Step 1 :
___________________
|     |     |     |
|  1  |  2  |  3  |
|_____|_____|_____|
|     |     |     |
|  4  |     |  6  |
|_____|_____|_____|
|     |     |     |
|  7  |  5  |  8  |
|_____|_____|_____|

Step 2 :
___________________
|     |     |     |
|  1  |  2  |  3  |
|_____|_____|_____|
|     |     |     |
|  4  |  5  |  6  |
|_____|_____|_____|
|     |     |     |
|  7  |     |  8  |
|_____|_____|_____|

Step 3 :
___________________
|     |     |     |
|  1  |  2  |  3  |
|_____|_____|_____|
|     |     |     |
|  4  |  5  |  6  |
|_____|_____|_____|
|     |     |     |
|  7  |  8  |     |
|_____|_____|_____|


 * 
 * 
 */
