import java.util.*;

class Permutations1{

public static void find(int ind,String str,int[] array)
{

if(ind==array.length)
{
System.out.println();
System.out.println(str);
}


for(int i=ind;i<array.length;i++)
{

swap(ind,i,array);
str+=""+array[ind]+" ";
find(ind+1,str,array);
swap(ind,i,array);
str=str.substring(0,str.length()-2);
}

}


public static void swap(int a,int b,int[] array)
{
int temp=array[a];
array[a]=array[b];
array[b]=temp;
}


public static void main(String[] args){
int[] array={1,1,2,3};
boolean[] freq=new boolean[array.length];
find(0,"",array);
} 
}