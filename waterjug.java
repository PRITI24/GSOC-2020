import java.util.*;
public class waterjug {

        static int pour(int toCap,int jug1,int fromCap,int jug2,int goal1,int goal2){
                int step=1;
                int to=0;
                int from=fromCap;
                int g1,g2,cap=toCap*fromCap,count=0;
                if(jug1==1){
                        g1=goal1;
                        g2=goal2;
                }
                else{
                        g1=goal2;
                        g2=goal1;
                }
                while(from!=g2||to!=g1){
                        int temp=Math.min(from, toCap-to);
                        //System.out.print("rubbush");
                        to+=temp;
                        from-=temp;
                        if(jug1==1)
                                System.out.println("Jug1: "+to+"\tJug2: "+from);
                        else
                                System.out.println("Jug1: "+from+"\tJug2: "+to);
                        step++;

                        if(to==g1&&from==g2)
                                break;

                        if(to==toCap){
                                to=0;
                                if(jug1==1)
                                        System.out.println("Jug1: "+to+"\tJug2: "+from);
                                else
                                        System.out.println("Jug1: "+from+"\tJug2: "+to);
                                step++;
                        }

                        if(from==0){
                                from=fromCap;
                                if(jug1==1)
                                        System.out.println("Jug1: "+to+"\tJug2: "+from);
                                else
                                        System.out.println("Jug1: "+from+"\tJug2: "+to);
                                step++;
                        }
                        count++;
                        if(count==cap){
                                System.out.println("No solution possible!");
                                break;
                        }
                }
                return step;
        }

        public static void main(String[] args) {
                // TODO Auto-generated method stub
                Scanner sc=new Scanner(System.in);
                System.out.print("Enter volume of Jug1: ");
                int v1=sc.nextInt();
                System.out.print("Enter volume of Jug2: ");
                int v2=sc.nextInt();
                System.out.println("Enter the goal state: ");
                System.out.print("Jug1: ");
                int g1=sc.nextInt();
                if(g1>v1){
                        do{
                                System.out.print("\nGoal state cannot be greater than volume of jug!\nRe-Enter: ");
                                g1=sc.nextInt();
                        }while(g1>v1);
                }
                System.out.print("Jug2: ");
                int g2=sc.nextInt();
                if(g2>v2){
                        do{
                                System.out.print("\nGoal state cannot be greater than volume of jug!\nRe-Enter: ");
                                g2=sc.nextInt();
                        }while(g2>v2);
                }

                //int t1=0,t2=0;
                System.out.println("Filling Jug2:\nJug1: "+0+"\tJug2: "+v2);
                int step=pour(v1,1,v2,2,g1,g2);
                System.out.println("\nTotal no. of steps: "+step);


                System.out.println("\n\nFilling Jug1:\nJug1: "+v1+"\tJug2: "+0);
                step=pour(v2,2,v1,1,g1,g2);
                System.out.println("\nTotal no. of steps: "+step);

        }

}

/*
OUTPUT:-
Enter volume of Jug1: 5
Enter volume of Jug2: 2
Enter the goal state: 
Jug1: 4
Jug2: 0
Filling Jug2:
Jug1: 0	Jug2: 2
Jug1: 2	Jug2: 0
Jug1: 2	Jug2: 2
Jug1: 4	Jug2: 0

Total no. of steps: 4


Filling Jug1:
Jug1: 5	Jug2: 0
Jug1: 3	Jug2: 2
Jug1: 3	Jug2: 0
Jug1: 1	Jug2: 2
Jug1: 1	Jug2: 0
Jug1: 0	Jug2: 1
Jug1: 5	Jug2: 1
Jug1: 4	Jug2: 2
Jug1: 4	Jug2: 0

Total no. of steps: 9

*/