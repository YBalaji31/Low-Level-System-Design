import java.util.*;

class Ball{
	int x;
	int y;
	int count;
	
	Ball(int x,int y){
		this.x=x;
		this.y=y;
	}
}

class BallBrickGame{
	static int n;
	static Ball ball;
	static int baseleft=0;
	static int baseright=0;
	static{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter board size");
		n=sc.nextInt();
	}
	static String[][] board=new String[n][n];
	static{
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				board[i][j]="-";
				if( i==0 || j==0 || i==n-1 ||j==n-1 ){
					board[i][j]="W";
				}
				if(i==n-1 && (j>=1 && j<=n-2)){
					board[i][j]="G";
				}
				if(i==n-1 && j==(n/2)){
					board[i][j]="O";
					ball=new Ball(i,j);
					continue;
				}
				
					
				
				
			}
			
		}
		char temp='Y';
			while(temp=='Y'){
				System.out.println("Enter the brick's position and the brick type :");
				int x=sc.nextInt();
				int y=sc.nextInt();
				String s=sc.next();
				board[x][y]=s;
				System.out.println("Do you want to continue(Y or N)");
				temp=sc.next().charAt(0);
			}
		System.out.println("Enter the Ball's Count");
		int count=sc.nextInt();
		ball.count=count;
					
	}
	
	public static void display(){
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("The ball Count is "+ball.count);
	}
	
	public static void demolishDE(int x,int y){
		board[x][y]="-";
		for(int i=1;i<n-1;i++){
			char c=board[x][i].charAt(0);
			boolean flag=Character.isDigit(c);
			if(flag || board[x][i]=="-"){
				board[x][i]="-";
			}
			else if(board[x][i].equals("DS")){
				demolishDS(x,i);
			}
			else if(board[x][i].equals("DE")){
				continue;
			}
			else if(board[x][i].equals("B")){
					base(x,i);
				}
				else if(board[x][i].equals("B")){
					north(x,i);
				}
				else if(board[x][i].equals("S")){
					south(x,i);
				}
				else if(board[x][i].equals("E")){
					east(x,i);
				}
				else if(board[x][i].equals("W")){
					west(x,i);
				}
		}
	}
	
	public static boolean valid(int i,int j){
		
		if(i>=1 && i<n-1 && j>=1 && j<n-1){
			return true;
		}
		return false;
		
	}
	public static void demolishDS(int x,int y){
		board[x][y]="-";
		for(int i=x-1;i<=x+1;i++){
			for(int j=y-1;j<=y+1;j++){
				
				if(valid(i,j)){
					
					char c=board[i][j].charAt(0);
					boolean flag=Character.isDigit(c);
					if(flag || board[i][j]=="-"){
					board[i][j]="-";
					}
				else if(board[i][j].equals("DS")){
					demolishDS(i,j);
				}
				else if(board[i][j].equals("DE")){
					demolishDE(i,j);
				}
				else if(board[i][j].equals("B")){
					System.out.println(i+" "+j);
					base(i,j);
				}
				else if(board[i][j].equals("B")){
					north(i,j);
				}
				else if(board[i][j].equals("S")){
					south(i,j);
				}
				else if(board[i][j].equals("E")){
					east(i,j);
				}
				else if(board[i][j].equals("W")){
					west(i,j);
				}
				}
			}
		}
	}
	
	
	public static void north(int x,int y){
		
		
	}
	
	
	public static void base(int x,int y){
		board[x][y]="-";
		if(baseleft==baseright){
			board[ball.x][ball.y+1]="O";
			baseright++;
		}
		else{
			board[ball.x][ball.y-1]="O";
			baseleft++;
		}
	}
	
	
	public static void traverseST(){
		int x=ball.x;
		int y=ball.y;
		x--;
		while(board[x][y]!="W"){
			if(board[x][y]!="W" && board[x][y]!="-"){
				char c=board[x][y].charAt(0);
				boolean flag=Character.isDigit(c);
				if(flag)
				{
				
						int val=Integer.parseInt(board[x][y]);
					val--;
					if(val!=0){
					board[x][y]=Integer.toString(val);
					}
					else{
					board[x][y]="-";	
					}
					if(board[ball.x][y]!="O"){
						
						ball.count--;	
						return;
					}
					else{
						return;
					}
				}
				else if (board[x][y].equals("DE")){
					board[x][y]="-";demolishDE(x,y);
				}
				else if(board[x][y].equals("DS")){
					demolishDS(x,y);
				}
				else if(board[x][y].equals("B")){
					base(x,y);
				}
				else if(board[x][y].equals("B")){
					base(x,y);
				}
				else if(board[x][y].equals("B")){
					north(x,y);
				}
				else if(board[x][y].equals("S")){
					south(x,y);
				}
				else if(board[x][y].equals("E")){
					east(x,y);
				}
				else if(board[x][y].equals("W")){
					west(x,y);
				}
		}
			x--;
		}
		x++;
		
		while(board[x][y]!="W" && board[x][y]!="O"){
			if(board[x][y]!="W" && board[x][y]!="-"){
				char c=board[x][y].charAt(0);
				boolean flag=Character.isDigit(c);
				if(flag)
				{
				
					int val=Integer.parseInt(board[x][y]);
					val--;
					if(val!=0){
					board[x][y]=Integer.toString(val);
					}
					else{
					board[x][y]="-";	
					}
					if(board[ball.x][y]!="O"){
						
						ball.count--;
						return;
					}
					else{
						return;
					}
				}
				else if (board[x][y].equals("DE")){
					board[x][y]="-";demolishDE(x,y);
				}
				else if(board[x][y].equals("DS")){
					demolishDS(x,y);
				}
				else if(board[x][y].equals("B")){
					base(x,y);
				}
				else if(board[x][y].equals("B")){
					north(x,y);
				}
				else if(board[x][y].equals("S")){
					south(x,y);
				}
				else if(board[x][y].equals("E")){
					east(x,y);
				}
				else if(board[x][y].equals("W")){
					west(x,y);
				}
		}
			x++;
		}
		if(board[ball.x][y]!="O"){
						
						ball.count--;
						return;
					}
					else{
						return;
					}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void traverseLD(){
		int x=ball.x;
		int y=ball.y;
		x--;
		y--;
		while(board[x][y]!="W"){
			if(board[x][y]!="W" && board[x][y]!="-"){
				char c=board[x][y].charAt(0);
				boolean flag=Character.isDigit(c);
				if(flag)
				{
				
					int val=Integer.parseInt(board[x][y]);
					val--;
					board[x][y]=Integer.toString(val);
					if(y==ball.y){
						
						ball.count--;
						return;
					}
				}
				else if (board[x][y].equals("DE")){
					board[x][y]="-";demolishDE(x,y);
				}
				else if(board[x][y].equals("DS")){
					demolishDS(x,y);
				}
				else if(board[x][y].equals("B")){
					base(x,y);
				}
				else if(board[x][y].equals("B")){
					north(x,y);
				}
				else if(board[x][y].equals("S")){
					south(x,y);
				}
				else if(board[x][y].equals("E")){
					east(x,y);
				}
				else if(board[x][y].equals("W")){
					west(x,y);
				}
		}
			x--;
			y--;
		}
		y++;
		
		while(board[x][y]!="W"){
			if(board[x][y]!="W" && board[x][y]!="-"){
				char c=board[x][y].charAt(0);
				boolean flag=Character.isDigit(c);
				if(flag)
				{
				
						int val=Integer.parseInt(board[x][y]);
					val--;
					if(val!=0){
					board[x][y]=Integer.toString(val);
					}
					else{
					board[x][y]="-";	
					}
					if(board[ball.x][y]!="O"){
						
						ball.count--;
						return;
					}
					else{
						return;
					}
				}
				else if (board[x][y].equals("DE")){
					board[x][y]="-";demolishDE(x,y);
				}
				else if(board[x][y].equals("DS")){
					demolishDS(x,y);
				}
				else if(board[x][y].equals("B")){
					base(x,y);
				}
				else if(board[x][y].equals("B")){
					north(x,y);
				}
				else if(board[x][y].equals("S")){
					south(x,y);
				}
				else if(board[x][y].equals("E")){
					east(x,y);
				}
				else if(board[x][y].equals("W")){
					west(x,y);
				}
		}
			y--;
		}
		y++;
		
		while(board[x][y]!="W"){
			if(board[x][y]!="W" && board[x][y]!="-"){
				char c=board[x][y].charAt(0);
				boolean flag=Character.isDigit(c);
				if(flag)
				{
					
					int val=Integer.parseInt(board[x][y]);
					val--;
					if(val!=0){
					board[x][y]=Integer.toString(val);
					}
					else{
					board[x][y]="-";	
					}
					if(board[ball.x][y]!="O"){
						
						ball.count--;
						return;
					}
					else{
						return;
					}
				}
				else if (board[x][y].equals("DE")){
					board[x][y]="-";demolishDE(x,y);
				}
				else if(board[x][y].equals("DS")){
					demolishDS(x,y);
				}
				else if(board[x][y].equals("B")){
					base(x,y);
				}
				else if(board[x][y].equals("B")){
					north(x,y);
				}
				else if(board[x][y].equals("S")){
					south(x,y);
				}
				else if(board[x][y].equals("E")){
					east(x,y);
				}
				else if(board[x][y].equals("W")){
					west(x,y);
				}
		}
			y++;
		}
	
	
		if(board[ball.x][y]!="O"){
						
						ball.count--;
						return;
					}
					else{
						return;
					}
	}
	
	
	
	
	
	
	
	
	
	
	
	public static void traverseRD(){
		int x=ball.x;
		int y=ball.y;
		x--;
		y++;
		while(board[x][y]!="W"){
			if(board[x][y]!="W" && board[x][y]!="-"){
				char c=board[x][y].charAt(0);
				boolean flag=Character.isDigit(c);
				if(flag)
				{
					
					int val=Integer.parseInt(board[x][y]);
					val--;
					board[x][y]=Integer.toString(val);
					if(y==ball.y){
						
						ball.count--;
						return;
					}
				}
				else if (board[x][y].equals("DE")){
					board[x][y]="-";demolishDE(x,y);
				}
				else if(board[x][y].equals("DS")){
					demolishDS(x,y);
				}else if(board[x][y].equals("B")){
					base(x,y);
				}
				else if(board[x][y].equals("B")){
					north(x,y);
				}
				else if(board[x][y].equals("S")){
					south(x,y);
				}
				else if(board[x][y].equals("E")){
					east(x,y);
				}
				else if(board[x][y].equals("W")){
					west(x,y);
				}
		}
			x--;
			y++;
		}
		y--;
		while(board[x][y]!="W"){
			if(board[x][y]!="W" && board[x][y]!="-"){
				char c=board[x][y].charAt(0);
				boolean flag=Character.isDigit(c);
				if(flag)
				{
		
					int val=Integer.parseInt(board[x][y]);
					val--;
					if(val!=0){
					board[x][y]=Integer.toString(val);
					}
					else{
					board[x][y]="-";	
					}
					if(board[ball.x][y]!="O"){
						
						ball.count--;
						return;
					}
					else{
						return;
					}
				}
				else if (board[x][y].equals("DE")){
					board[x][y]="-";demolishDE(x,y);
				}
				else if(board[x][y].equals("DS")){
					demolishDS(x,y);
				}
				else if(board[x][y].equals("B")){
					base(x,y);
				}
				else if(board[x][y].equals("B")){
					north(x,y);
				}
				else if(board[x][y].equals("S")){
					south(x,y);
				}
				else if(board[x][y].equals("E")){
					east(x,y);
				}
				else if(board[x][y].equals("W")){
					west(x,y);
				}
		}
			y++;
		}
		y--;
		while(board[x][y]!="W"){
			if(board[x][y]!="W" && board[x][y]!="-"){
				char c=board[x][y].charAt(0);
				boolean flag=Character.isDigit(c);
				if(flag)
				{
			
					int val=Integer.parseInt(board[x][y]);
					val--;
					if(val!=0){
					board[x][y]=Integer.toString(val);
					}
					else{
					board[x][y]="-";	
					}
					if(board[ball.x][y]!="O"){
						
						ball.count--;
						return;
					}
					else{
						return;
					}
				}
				else if (board[x][y].equals("DE")){
					board[x][y]="-";demolishDE(x,y);
				}
				else if(board[x][y].equals("DS")){
					demolishDS(x,y);
				}
				else if(board[x][y].equals("B")){
					base(x,y);
				}
				else if(board[x][y].equals("B")){
					north(x,y);
				}
				else if(board[x][y].equals("S")){
					south(x,y);
				}
				else if(board[x][y].equals("E")){
					east(x,y);
				}
				else if(board[x][y].equals("W")){
					west(x,y);
				}
				
		}
			y--;
		}
		if(board[ball.x][y]!="O"){
						
						ball.count--;
						return;
					}
					else{
						return;
					}
	}
	
	
	public static void checkball(){
		
		if(ball.count<=0){
			System.out.println("You have Lost");
			System.exit(0);
		}
		
	}
	
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		
		display();
		boolean flag1=true;
		
		while(flag1){
			System.out.println("Enter the direction in which the ball need to traverse :");
			String opt=sc.next();
			if(opt.equals("LD")){
				traverseLD();
			}
			else if(opt.equals("ST")){
				traverseST();
			}
			else{
				traverseRD();
			}
			
			display();
			checkball();
		}
		
	}
}