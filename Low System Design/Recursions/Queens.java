class 	Queens{
public static boolean safe(int row,int col,char[][] mat,int num){
	int i,j;
	
	for(i=0;i<col;i++){
		if(mat[row][i]=='Q'){
			return false;
		}
	}
	
	int temprow=row;
	int tempcol=col;
	while(temprow<num && tempcol>=0){
		if(mat[temprow][tempcol]=='Q'){
			return false;
		}
		temprow++;
		tempcol--;
	}
	
	temprow=row;
	tempcol=col;
	
	while(temprow>=0 && tempcol>=0){
		if(mat[temprow][tempcol]=='Q'){
			return false;
		}
		temprow--;
		tempcol--;
	}
	
	return true;
}
public static void nqueens(int col,char[][] mat,int num){
if(col==num){
	System.out.println();
	for(int x=0;x<num;x++){
		for(int y=0;y<num;y++){
			
			System.out.print(mat[x][y]+" ");
		}
		System.out.println();
	}
	
System.out.println();	
}
for(int i=0;i<num;i++){

if(safe(i,col,mat,num)){

mat[i][col]='Q';
nqueens(col+1,mat,num);
mat[i][col]='-';
}
}

}

public static void main(String[] args){
int num=4;
char[][] mat=new char[num][num];

for(int i=0;i<num;i++){

for(int j=0;j<num;j++){
mat[i][j]='-';
}
}
nqueens(0,mat,num);
}
}