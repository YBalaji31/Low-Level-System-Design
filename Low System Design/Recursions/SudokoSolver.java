class SudokoSolver{
public static boolean valid(int row,int col,int val,char[][]board){
	
	for(int i=0;i<9;i++){
		if(board[i][col]==val){
			return false;
		}
		if(board[col][i]==val){
			return false;
		}
		int temprow=row/3;
		int tempcol=col/3;
		for(int j=temprow;j<temprow+3;j++){
			for(int k=tempcol;k<tempcol+3;k++){
				if(board[temprow][tempcol]==val)
					return false;
			}
		}
	}
	return true;
}
public static boolean solve(char[][]board){

	for(int i=0;i<9;i++){
	for(int j=0;j<9;j++){

	if(board[i][j]=='-'){
		for(int k=1;k<=9;k++){
		if(valid(i,j,k)){
		board[i][j]=k;
			if(solve(i,j)==true){
r				return true;
				}
			else{
				board[i][j]='-';
				}
			}
		}
	}

	}
	}

}

public static void main(String[] args){

char[][] board=int[9][9];
solve(board);
}
}