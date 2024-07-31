import java.util.*;

class Adventurer{
int x;
int y;
Adventurer(int x,int y){
	this.x=x;
	this.y=y;
}
}

class Monster{
int x;
int y;
Monster(int x,int y){
	this.x=x;
	this.y=y;
}
}

class Gold{
int x;
int y;

Gold(int x,int y){
	this.x=x;
	this.y=y;
}
}

class Trigger{
int x;
int y;
Trigger(int x,int y){
	this.x=x;
	this.y=y;
}
}


class Pit{
int x;
int y;
Pit(int x,int y){
	this.x=x;
	this.y=y;
}
}


class Board{
	char[][] board;
	
	Board(int row,int col,Adventurer ad,Monster mon,Gold gold,Trigger trig,ArrayList<Pit>pits){
		board=new char[row+1][col+1];
		for(int i=0;i<=row;i++){
			for(int j=0;j<=col;j++){
				board[i][j]='-';
			}
		}
		board[ad.x][ad.y]='A';
		board[mon.x][mon.y]='M';
		board[gold.x][gold.y]='G';
		board[trig.x][trig.y]='T';
		for(Pit pit:pits){
			board[pit.x][pit.y]='P';
		}
	}
	
}

class Dungeon{
	
	static Board bd;
	static int row;
	static int col;
	static Adventurer adventurer;
	static Monster monster;
	static Gold gold;
	static	Trigger trigger;
	static	ArrayList<Pit>pits;
	static int adtogold;
	static int montogold;
	static int adtotrig;
	static int trigtogold;
	static int temp;
	static int[][] directions={{0,1},{1,0},{-1,0},{0,-1}};
	static boolean[][] visited;
	static char[][] board;
	static String path="";
	
	static {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Dimensions of the Board ");
		row=sc.nextInt();
		col=sc.nextInt();
		System.out.println("Enter the Adventurer's Location ");
		int x=sc.nextInt();
		int y=sc.nextInt();
		adventurer=new Adventurer(x,y);
		System.out.println("Enter the Monster's Location ");
		x=sc.nextInt();
		y=sc.nextInt();
		monster=new Monster(x,y);
		System.out.println("Enter the Gold's Location ");
		x=sc.nextInt();
		y=sc.nextInt();
		gold=new Gold(x,y);
		System.out.println("Enter the Trigger's Location ");
		x=sc.nextInt();
		y=sc.nextInt();
		trigger=new Trigger(x,y);
		System.out.println("Enter no of pits ");
		int num=sc.nextInt();
		pits=new ArrayList<>();
		for(int i=1;i<=num;i++){
		System.out.println("Enter the "+i+" Pit's Location ");
		x=sc.nextInt();
		y=sc.nextInt();
		pits.add(new Pit(x,y));
		}
		bd=new Board(row,col,adventurer,monster,gold,trigger,pits);
		board=bd.board;
		visited=new boolean[row+1][col+1];
	}
	
	
	public static void dfs1(int x,int y,int dist,int tx,int ty,String str){
		
		str+="("+x+","+y+") -> ";
		if(x==tx && y==ty){
			if(dist<temp){
				temp=dist;
				path=str;
			}
		}
		dist++;
		for(int [] dirs:directions){
			int dx=x+dirs[0];
			int dy=y+dirs[1];
			
			if(dx>0 && dy>0 && dx<=row && dy<=col && visited[dx][dy]==false && board[dx][dy]!='P'){
				visited[x][y]=true;
				dfs1(dx,dy,dist,tx,ty,str);
				visited[x][y]=false;
			}
		}
		
	}	
	
	public static void dfs2(int x,int y,int dist,int tx,int ty){
	
		if(x==tx && y==ty){
			if(dist<temp){
				temp=dist;
			}
			}
			dist++;
		for(int [] dirs:directions){
			int dx=x+dirs[0];
			int dy=y+dirs[1];
			
			if(dx>0 && dy>0 && dx<=row && dy<=col && visited[dx][dy]==false){
				visited[x][y]=true;
				dfs2(dx,dy,dist,tx,ty);
				visited[x][y]=false;
			}
		}
		
	}	
	
	
	public static void main(String[] args)
	{
		System.out.println();
		System.out.println();
		for(int i=1;i<=row;i++){
			for(int j=1;j<=col;j++){
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		
		
		temp=Integer.MAX_VALUE;
		dfs1(adventurer.x,adventurer.y,0,gold.x,gold.y,"");
		adtogold=temp;
		System.out.println();
		if(adtogold==Integer.MAX_VALUE){
			System.out.println("No Possible Solution ");
			System.exit(0);
		}
		else{
			System.out.println("Steps to reach gold for Adventurer :"+adtogold);
				
		
		}
		temp=Integer.MAX_VALUE;
		dfs2(monster.x,monster.y,0,gold.x,gold.y);
		montogold=temp;
		System.out.println();
		System.out.println("Steps to reach gold for Monster :"+montogold);
		
		System.out.println();
		if(montogold<adtogold){
			System.out.println("So Adventurer can't reach the gold before Monster");
			System.out.println("Reaching for Trigger ");
		}
		else{
			System.out.println("Reached Gold before Monster in "+adtogold+" steps");
			System.out.println(path+"(GOLD)");
			System.exit(0);
		}
		System.out.println();
		temp=Integer.MAX_VALUE;
		path="";
		dfs1(adventurer.x,adventurer.y,0,trigger.x,trigger.y,"");
		adtotrig=temp;
		String str1=path+"(TRIGGER) \n";
		System.out.println("Reached Trigger ");
		System.out.println("Killed Monster ");
		System.out.println();
		temp=Integer.MAX_VALUE;
		path="";
		dfs1(trigger.x,trigger.y,0,gold.x,gold.y,"");
		trigtogold=temp;
		String str2=path+"(GOLD)";
		System.out.println("Reached Gold in "+(adtotrig+trigtogold)+" steps");
		System.out.println("The path is \n23"+str1+str2);
		System.out.println();
	}
}