import java.util.*;

class Permutations1{

public static void find(int ind,int i,String str,int[] array){
if(str.length()==array.length*2){
System.out.println(str);
}

for(int i=ind;i<array.length;i++){
swap(ind,i);
str+=""+array[ind]+" ";
find(ind,i,str,array);
str=str.substring(0,array.length-2);
swap(ind,i);
}

}
}

public static void main(String[] args){
int[] array={1,2,3};
boolean[] freq=new boolean[array.length];
find(0,0,"",array);
} 
}