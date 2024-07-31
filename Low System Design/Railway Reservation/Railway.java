import java.util.*;

class Seat{
	int seatno;
	int cabinno;
	String berth;
	int pnr=-1;
	String name="-";
	int age=-1;
	String status="AVL";
	
	Seat(int no,int cabin,String str){
		seatno=no;
		cabin=cabinno;
		berth=str;
	}
}

class Coach{
	int lower=4;
	int upper=4;
	int middlr=4;
	int sideupper=2;
	int sidelower=2;
	}

class Passenger{
	
	String name;
	int age;
	String bp;
	int pnr;
	ArrayList<String>travellers;
	
	Passenger(String name,int age,String bp,int pnr){
		this.name=name;
		this.age=age;
		this.bp=bp;
		this.pnr=pnr;
	}
}

class Railway{
	
	static int lower=4;
	static int upper=4;
	static int middlr=4;
	static int sideupper=2;
	static int sidelower=2;
	static int pnr=48000;
	
	static ArrayList<Seat>availseats=new ArrayList<>();
	static ArrayList<Seat>seats=new ArrayList<>();
	static ArrayList<Seat>lb=new ArrayList<>();
	static ArrayList<Seat>mb=new ArrayList<>();
	static ArrayList<Seat>ub=new ArrayList<>();
	static ArrayList<Seat>slb=new ArrayList<>();
	static ArrayList<Seat>sub=new ArrayList<>();
	static ArrayList<String>wl=new ArrayList<>();
	static ArrayList<Passenger>passengers=new ArrayList<>();
	static{
		int cabin=1;
		wl.add("-\t-\tWL1\t-\t-\t-");
		wl.add("-\t-\tWL2\t-\t-\t-");
		for(int i=1;i<17;i++){
			if(i>8){
				cabin=2;
			}
			if(i==1 ||i==4||i==9||i==12){
				Seat temp=new Seat(i,cabin,"LB");
				availseats.add(temp);
				seats.add(temp);
				lb.add(temp);
				continue;
			}
			else if(i==2 ||i==5||i==10||i==13){
				Seat temp=new Seat(i,cabin,"MB");
				availseats.add(temp);
				seats.add(temp);
				mb.add(temp);				
				continue;
			}
			else if(i==3 ||i==6||i==11||i==14){
				Seat temp=new Seat(i,cabin,"UB");
				availseats.add(temp);
				seats.add(temp);
				ub.add(temp);
				continue;
			}
			else if(i==8 ||i==16){
				Seat temp=new Seat(i,cabin,"SUB");
				availseats.add(temp);
				seats.add(temp);
				sub.add(temp);
				
				continue;
			}
			else{
				Seat temp=new Seat(i,cabin,"SLB");
				Seat temp1=new Seat(i,cabin,"SLB");
				temp.status="RAC1";
				temp1.status="RAC2";
				availseats.add(temp);
				seats.add(temp);
				slb.add(temp);
				availseats.add(temp1);
				seats.add(temp1);
				slb.add(temp1);
				continue;
			}
	}
	}
	
	static void printseats(){
		System.out.println("PNR\tSeat No\t Status\t Berth\t Name\tAge ");
		for(Seat seat:seats){
			String pnr="";
			String age="";
			if(seat.pnr==-1){
				pnr="-";
				age="-";
			}
			else{
				age=Integer.toString(seat.age);
				pnr=Integer.toString(seat.pnr);
			}
			System.out.println(pnr+"\t"+seat.seatno+"\t"+seat.status+"\t"+seat.berth+"\t"+seat.name+"\t"+age);
		}
		System.out.println(wl.get(0));
		System.out.println(wl.get(1));
		
	}
	
	static void book(){
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the name");
		String name=sc.next();
		System.out.println("Enter the age");
		int age=sc.nextInt();
		System.out.println("Enter the Berth Preference (Optional)");
		String bp=sc.next();
		Passenger passenger=new Passenger(name,age,bp,pnr);
		if(bp.isEquals("lb") && lower!=0){
			
			for(Seat seat:lb){
				if(seat.status.isEquals("AVL")){
					seat.name=name;
					seat.age=age;
					seat.status="CNF";
					seat.pnr=pnr;
				}
			}
		}
		
		
		
		
	}
	
	public static void main(String[] args){
			Scanner sc=new Scanner(System.in);
		
		boolean flag1=true;
		while(flag1){
			
			System.out.println("Enter Your Choice ");
			System.out.println("1.Available Tickets");
			System.out.println("2.Book Tickets");
			int choice1=sc.nextInt();
			
				switch(choice1){
				case 1:
					printseats();
					break;
				case 2:
					System.out.println("Enter the no of passengers");
					int num=sc.nextInt();
					if(num>1){
					bookpassengers();
					}
					else{
						book();
					}
					break;
			}
			
		}
		
		
	}
}