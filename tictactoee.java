package tictactoe;
import java.util.*;

class node implements Comparator<node>
{
	int eval;
	int i,j;
	node(int eval,int i,int j)
	{
		this.eval=eval;
		this.i=i;
		this.j=j;
	}

	public node()
	{

	}
	public int compare(node a,node b)
	{
		if(a.eval>b.eval)
		{
			return 1;
		}
		return -1;
	}

}

class nodes
{

	Scanner sc=new Scanner(System.in);
	String[][] start=new String[3][3];
	void accept()
	{
		int flag=0;
		for(int m=0;m<3;m++)
		{
			for(int n=0;n<3;n++)
			{
				start[m][n]="_";
			}
		}
		System.out.println("Enter user(1) or computer(0)");
		int x=sc.nextInt();
		if(x==1)
		{
			while(flag==0){
				int flag1=0;
				int i=0,j=0;
				while(flag1==0)
				{
					System.out.println();

					System.out.println("Enter row index: ");
					i=sc.nextInt();

					System.out.println("Enter column index: ");
					j=sc.nextInt();
					if(i<3 && j<3 )
					{
						if( start[i][j]=="_" )
						{
							start[i][j]="X";	
							flag1=1;
						}

					}
					else
					{
						flag1=0;
					}

				}
				print(start);
				if(comparewithgoal("X")==1){System.out.println("USER WON!!!!!");break;}
				if(draw()==1){
					System.out.println("DRAW!!!!!!!!!!!!!!!!!!!!");
					break;
				}

				System.out.println();
				System.out.println("Second Player-Computer:");
				minmax();
				print(start);
				if(comparewithgoal("O")==1){System.out.println("COMPUTER WON!!!!!");break;}
				if(draw()==1){
					System.out.println("DRAW!!!!!!!!!!!!!!!!!!!!");
					break;
				}
			}
		}
		else
		{
			while(flag==0){
				int flag1=0;
				int i=0,j=0;
				System.out.println("Second Player-Computer:");
				minmax();
				print(start);
				if(comparewithgoal("O")==1){System.out.println("COMPUTER WON!!!!!");break;}
				if(draw()==1){
					System.out.println("DRAW!!!!!!!!!!!!!!!!!!!!");

				}
				while(flag1==0)
				{
					System.out.println();

					System.out.println("Enter row index: ");
					i=sc.nextInt();

					System.out.println("Enter column index: ");
					j=sc.nextInt();
					if(i<3 && j<3 )
					{
						if( start[i][j]=="_" )
						{
							start[i][j]="X";	
							flag1=1;
						}

					}
					else
					{
						flag1=0;
					}
					if(comparewithgoal("X")==1){System.out.println("USER WON!!!!!");flag=1;break;}
					if(draw()==1){
						System.out.println("DRAW!!!!!!!!!!!!!!!!!!!!");
						break;
					}

				}

			}
		}



	}
	int draw()
	{
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(start[i][j]=="_")
				{
					return 0;
				}
			}
		}
		return 1;
	}
	void print(String[][] mat)
	{
		System.out.println("___________________");
		for(int i=0;i<3;i++)
		{
			System.out.println("|     |     |     |");
			for(int j=0;j<3;j++)
			{
				if(mat[i][j]=="_")
					System.out.print("|  "+" "+"  ");
				else
					System.out.print("|  "+mat[i][j]+"  ");
			}
			System.out.print("|\n");
			System.out.print("|_____|_____|_____|");
			System.out.println();
		}
		System.out.println();
	}

	int comparewithgoal(String m)
	{
		int flag=1;
		for(int i=0;i<3;i++)
		{
			if(start[0][i]!=m)
				flag=0;

		}
		if(flag==1)return flag;
		flag=1;
		for(int i=0;i<3;i++)
		{
			if(start[1][i]!=m)
				flag=0;
		}
		if(flag==1)return flag;
		flag=1;
		for(int i=0;i<3;i++)
		{
			if(start[2][i]!=m)
				flag=0;
		}
		if(flag==1)return flag;
		flag=1;
		for(int i=0;i<3;i++)
		{
			if(start[i][0]!=m)
				flag=0;
		}
		if(flag==1)return flag;
		flag=1;
		for(int i=0;i<3;i++)
		{
			if(start[i][1]!=m)
				flag=0;
		}
		if(flag==1)return flag;
		flag=1;
		for(int i=0;i<3;i++)
		{
			if(start[i][2]!=m)
				flag=0;
		}

		if(flag==1)return flag;
		flag=1;
		for(int i=0;i<3;i++)
		{
			if(start[i][i]!=m)
				flag=0;
		}

		if(flag==1)return flag;
		flag=1;
		int j=2;
		for(int i=0;i<3;i++)
		{
			if(start[i][j]!=m)
				flag=0;
			j--;
		}
		return flag;


	}
	int depth=9;
	void minmax()
	{
		node n;
		depth--;
		PriorityQueue<node> pq=new PriorityQueue<>(depth,new node());
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(start[i][j]=="_")
				{
					start[i][j]="O";
					int e=evaluation();
					n=new node(e,i,j);
					pq.add(n);
					start[i][j]="_";

				}
			}
		}
		int check_two_elements[]=new int[2];
		check_two_elements=intelligent(start);

		if(check_two_elements[0]==-1 && check_two_elements[1]==-1)
		{
			node check=pq.peek();
			int cnt=0;
			ArrayList<node>list=new ArrayList<node>();
			Iterator<node> itr=pq.iterator();
			while(itr.hasNext())
			{
				node x=itr.next();
				if(x.equals(check))
				{
					list.add(x);
					cnt++;
				}

			}

			Random r=new Random();
			int indx=r.nextInt(cnt);
			node selected=list.get(indx);
			start[selected.i][selected.j]="O";
		}
		else
		{
			start[check_two_elements[0]][check_two_elements[1]]="O";
		}
		pq.clear();

	}

	int arr[]=new int[2];
	int[] intelligent(String[][] mat)
	{ 
		int count=0;
		int start=-1,end=-1;

		arr[0]=-1;
		arr[1]=-1;

		for(int i=0;i<3;i++)     //row 0
		{
			if(mat[0][i]=="X")
			{
				count++;
			}
			if(mat[0][i]=="_")
			{
				start=0;
				end=i;

			}
		}

		if(count==2)
		{
			arr[0]=start;
			arr[1]=end;
			return arr;
		}


		count=0;
		start=-1;
		end=-1;
		for(int i=0;i<3;i++)       //row 1
		{
			if(mat[1][i]=="X")
			{
				++count;

			}
			if(mat[1][i]=="_")
			{
				start=1;
				end=i;

			}
		}
		if(count==2)
		{
			arr[0]=start;
			arr[1]=end;
			return arr;
		}


		count=0;
		start=-1;
		end=-1;
		for(int i=0;i<3;i++)         //row 2
		{
			if(mat[2][i]=="X")
			{
				++count;

			}
			if(mat[2][i]=="_")
			{
				start=2;
				end=i;

			}
		}
		if(count==2)
		{
			arr[0]=start;
			arr[1]=end;
			return arr;
		}


		count=0;
		start=-1;
		end=-1;
		for(int i=0;i<3;i++)         //column 0
		{
			if(mat[i][0]=="X")
			{
				++count;

			}
			if(mat[i][0]=="_")
			{
				start=i;
				end=0;

			}
		}
		if(count==2)
		{
			arr[0]=start;
			arr[1]=end;
			return arr;
		}


		count=0;
		start=-1;
		end=-1;
		for(int i=0;i<3;i++)		//column 1
		{
			if(mat[i][1]=="X")
			{
				++count;

			}
			if(mat[i][1]=="_")
			{
				start=i;
				end=1;

			}
		}
		if(count==2)
		{
			arr[0]=start;
			arr[1]=end;
			return arr;
		}


		count=0;
		start=-1;
		end=-1;
		for(int i=0;i<3;i++)		//column 2
		{
			if(mat[i][2]=="X")
			{
				++count;

			}
			if(mat[i][2]=="_")
			{
				start=i;
				end=2;

			}
		}
		if(count==2)
		{
			arr[0]=start;
			arr[1]=end;
			return arr;
		}
		count=0;
		start=-1;
		end=-1;
		for(int i=0;i<3;i++)		//diagonal 1
		{
			if(mat[i][i]=="X")
			{
				++count;

			}
			if(mat[i][i]=="_")
			{
				start=i;
				end=i;

			}
		}
		if(count==2)
		{
			arr[0]=start;
			arr[1]=end;
			return arr;
		}



		count=0;
		start=-1;
		end=-1;
		int j=2;
		for(int i=0;i<3;i++)		//diagonal 2
		{
			if(mat[i][j]=="X")
			{
				++count;

			}
			if(mat[i][j]=="_")
			{
				start=i;
				end=j;

			}
			j=j-1;
		}
		if(count==2)
		{
			arr[0]=start;
			arr[1]=end;
			return arr;
		}


		return arr;
	}

	int evaluation()
	{
		return possibilityofwinning("X")-possibilityofwinning("O");
	}
	int possibilityofwinning(String m)
	{
		int i1=direction1(m);//first row
		int i2=direction2(m);
		int i3=direction3(m);
		int i4=direction4(m);
		int i5=direction5(m);
		int i6=direction6(m);
		int i7=direction7(m);
		int i8=direction8(m);
		int sum=i1+i2+i3+i4+i5+i6+i7+i8;
		return sum;
	}
	int direction1(String m)
	{
		for(int i=0;i<3;i++)
		{
			if(start[0][i]!=m && start[0][i]!="_")
			{
				return 0;
			}
		}
		return 1;
	}

	int direction2(String m)
	{
		for(int i=0;i<3;i++)
		{
			if(start[1][i]!=m && start[1][i]!="_")
			{
				return 0;
			}
		}
		return 1;
	}

	int direction3(String m)
	{
		for(int i=0;i<3;i++)
		{
			if(start[2][i]!=m && start[2][i]!="_")
			{
				return 0;
			}
		}
		return 1;
	}

	int direction4(String m)
	{
		for(int i=0;i<3;i++)
		{
			if(start[i][0]!=m && start[i][0]!="_")
			{
				return 0;
			}
		}
		return 1;
	}

	int direction5(String m)
	{
		for(int i=0;i<3;i++)
		{
			if(start[i][1]!=m && start[i][1]!="_")
			{
				return 0;
			}
		}
		return 1;
	}

	int direction6(String m)
	{
		for(int i=0;i<3;i++)
		{
			if(start[i][2]!=m && start[i][2]!="_")
			{
				return 0;
			}
		}
		return 1;
	}

	int direction7(String m)
	{
		for(int i=0;i<3;i++)
		{
			if(start[i][i]!=m && start[i][i]!="_")
			{
				return 0;
			}
		}
		return 1;
	}

	//diagonal 2
	int direction8(String m)
	{
		int j=2;
		for(int i=0;i<3;i++)
		{
			if(start[i][j]!=m && start[i][j]!="_")
			{
				return 0;
			}
			j--;
		}
		return 1;
	}
}
public class tictactoee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("**************************    LET'S PLAY TIC TAC TOE!!!!!!!******************************\n");
		nodes n=new nodes();
		n.accept();
	}

}
/*
 * OUtPUT:-
 * 
 * **************************    LET'S PLAY TIC TAC TOE!!!!!!!******************************

Enter user(1) or computer(0)
1

Enter row index: 
0
Enter column index: 
0
___________________
|     |     |     |
|  X  |     |     |
|_____|_____|_____|
|     |     |     |
|     |     |     |
|_____|_____|_____|
|     |     |     |
|     |     |     |
|_____|_____|_____|


Second Player-Computer:
___________________
|     |     |     |
|  X  |     |     |
|_____|_____|_____|
|     |     |     |
|     |  O  |     |
|_____|_____|_____|
|     |     |     |
|     |     |     |
|_____|_____|_____|


Enter row index: 
1
Enter column index: 
1

Enter row index: 
1
Enter column index: 
2
___________________
|     |     |     |
|  X  |     |     |
|_____|_____|_____|
|     |     |     |
|     |  O  |  X  |
|_____|_____|_____|
|     |     |     |
|     |     |     |
|_____|_____|_____|


Second Player-Computer:
___________________
|     |     |     |
|  X  |     |     |
|_____|_____|_____|
|     |     |     |
|     |  O  |  X  |
|_____|_____|_____|
|     |     |     |
|     |     |  O  |
|_____|_____|_____|


Enter row index: 
2
Enter column index: 
0
___________________
|     |     |     |
|  X  |     |     |
|_____|_____|_____|
|     |     |     |
|     |  O  |  X  |
|_____|_____|_____|
|     |     |     |
|  X  |     |  O  |
|_____|_____|_____|


Second Player-Computer:
___________________
|     |     |     |
|  X  |     |     |
|_____|_____|_____|
|     |     |     |
|  O  |  O  |  X  |
|_____|_____|_____|
|     |     |     |
|  X  |     |  O  |
|_____|_____|_____|


Enter row index: 
0
Enter column index: 
2
___________________
|     |     |     |
|  X  |     |  X  |
|_____|_____|_____|
|     |     |     |
|  O  |  O  |  X  |
|_____|_____|_____|
|     |     |     |
|  X  |     |  O  |
|_____|_____|_____|


Second Player-Computer:
___________________
|     |     |     |
|  X  |  O  |  X  |
|_____|_____|_____|
|     |     |     |
|  O  |  O  |  X  |
|_____|_____|_____|
|     |     |     |
|  X  |     |  O  |
|_____|_____|_____|


Enter row index: 
2
Enter column index: 
1
___________________
|     |     |     |
|  X  |  O  |  X  |
|_____|_____|_____|
|     |     |     |
|  O  |  O  |  X  |
|_____|_____|_____|
|     |     |     |
|  X  |  X  |  O  |
|_____|_____|_____|

DRAW!!!!!!!!!!!!!!!!!!!!

 */