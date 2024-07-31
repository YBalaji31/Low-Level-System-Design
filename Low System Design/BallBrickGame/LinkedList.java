import java.util.*;
class Node{
	int data;
	Node next;
	
	Node(int data){
		this.data=data;
	}

}
class LinkedList{
	
	public static Node insertNode(Node temp,int val,int pos){
		Node node=new Node(val);
		while(pos!=1){
			temp=temp.next;
			pos--;
		}
		node.next=temp.next;
		temp.next=node;
	}
	
	public static void main(){
		
		Node head=new Node(1);
		head.next=new Node(2);
		head.next.next=new Node(4);
		head.next.next.next=new Node(5);
		insertNode(head,3,2);
		
	}
}