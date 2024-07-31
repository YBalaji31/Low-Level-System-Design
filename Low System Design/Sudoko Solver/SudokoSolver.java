import java.util.*;
class SudokoSolver{
public static boolean valid(int row,int col,char val,char[][]board){

	for(int i=0;i<9;i++){
		if(board[i][col]==val){
			return false;
		}
		if(board[row][i]==val){
			return false;
		}
		int temprow=(row/3)*3;
		int tempcol=(col/3)*3;
		for(int j=temprow;j<temprow+3;j++){
			for(int k=tempcol;k<tempcol+3;k++){
				if(board[j][k]==val)
					return false;
			}
		}
	}
	return true;
}
public static boolean solve(char[][]board){

	for(int i=0;i<9;i++){
	for(int j=0;j<9;j++){

	if(board[i][j]=='.'){
		int k=1;
		for(k=1;k<=9;k++){
		char temp=Integer.toString(k).charAt(0);
		if(valid(i,j,temp,board)){
		board[i][j]=temp;
			if(solve(board)==true){
				//System.out.println(i+""+j);
				return true;
				}
			else{
				//System.out.println(i+""+j);
				board[i][j]='.';
				}
			}	
		}
		if(k==10){
			return false;
		}
		
	}

	}
	}
return true;
}

public static void main(String[] args){
Scanner sc=new Scanner(System.in);
char[][] board=new char[9][9];
for(int i=0;i<9;i++){
	for(int j=0;j<9;j++){
		board[i][j]=sc.next().charAt(0);
	}
}
solve(board);
System.out.println();
System.out.println();



for(int i=0;i<9;i++){
	for(int j=0;j<9;j++){
		if(board[i][j]=='.'){
			System.out.println("Invalid Sudoko");
			System.exit(0);
		}

	}

}
System.out.println("valid Sudoko");
for(int i=0;i<9;i++){
	if((i)%3==0){
		System.out.println("--------------------");
	}
	for(int j=0;j<9;j++){
		if(j%3==0){
				System.out.print("|");
		}
		System.out.print(board[i][j]+" ");

	}
	
System.out.println();
}
System.out.println("--------------------");
}
}