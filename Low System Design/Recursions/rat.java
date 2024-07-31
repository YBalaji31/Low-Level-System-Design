class rat{

static int[][] directions={{1,0},{0,1}};
static boolean[][] visited=new boolean[4][4];
public static void dfs(int x,int y,String str,int tx,int ty,int[][]mat){
	if(x==tx && y==ty)
	{
		System.out.println(str);
	}
	for(int[] dirs:directions){
		
		int dx=x+dirs[0];
		int dy=y+dirs[1];
		
		if(dx>=0 && dy>=0 && dx<mat.length && dy<mat.length && visited[dx][dy]==false && mat[dx][dy]==1){
			if(dirs[0]==1 && dirs[1]==0){str+='D';}
			else{str+='R';}
			visited[dx][dy]=true;
			dfs(dx,dy,str,tx,ty,mat);
			visited[dx][dy]=false;
		}
		
	}

} 

public static void main(String[] args){
int[][] mat={{1,0,0,0},{1,1,0,0},{1,1,0,0},{1,1,1,1}};
dfs(0,0,"",4,4,mat);

}
}