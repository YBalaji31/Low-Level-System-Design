import java.util.*;

class Vehicle{
static int total_vehicles=0;
int reg_no;
String type;
int curr_hold;
int capacity;
int spent;
ArrayList<String>transactions=new ArrayList<>();
Vehicle(String type,int curr_hold,int capacity){					
	total_vehicles++;
	this.reg_no=total_vehicles;
	this.type=type;
	this.curr_hold=curr_hold;
	this.capacity=capacity;	
	this.spent=0;
}
}

class PetrolBunks{
	
	static int total_bunks;
	int petrol_id;
	String type;
	int earnings;
	int capacity;
	int curr_hold;
	ArrayList<String>transactions=new ArrayList<>();
	int price;
	PetrolBunks(String type,int capacity,int curr_hold,int price){
		total_bunks++;
		this.petrol_id=total_bunks;
		this.type=type;
		this.capacity=capacity;
		this.curr_hold=curr_hold;
		this.price=price;	
		this.earnings=0;
	}
	
}

class PetrolBunkManagement{
	public static void createVehicles(ArrayList<Vehicle>vehicles){
		Scanner sc=new Scanner(System.in);
		System.out.println();
		System.out.println("Enter the Type of vehicle (Car,Bike,Truck)");
		String type=sc.next();
		System.out.println();
		System.out.println("Enter the Fuel capacity of the vehicle");
		int capacity=sc.nextInt();
		System.out.println();
		System.out.println("Enter the current filled amount");
		int curr_hold=sc.nextInt();
		System.out.println();
	
		vehicles.add(new Vehicle(type,curr_hold,capacity));
					
	}
	
	public static void fillVehicle(PetrolBunks bunk,ArrayList<Vehicle>vehicles){
		Scanner sc=new Scanner(System.in);
		System.out.println();
		System.out.println("Enter the vehicle reg no ");
		int regno=sc.nextInt();
		for(Vehicle vehicle:vehicles){
			if(vehicle.reg_no==regno){
				System.out.println("Enter the litres to be added");
				int fill=sc.nextInt();
				if(vehicle.curr_hold+fill>vehicle.capacity){
					System.out.println("Entered amount of fuel is above your vehicles's capacity");
					int temp=vehicle.curr_hold+fill-vehicle.capacity;
					vehicle.spent+=(fill-temp)*bunk.price;
					bunk.earnings+=(fill-temp)*bunk.price;
					bunk.curr_hold-=fill;
					vehicle.curr_hold+=fill;
					vehicle.transactions.add(bunk.petrol_id+" "+(fill-temp)+" "+((fill-temp)*bunk.price));
					bunk.transactions.add(vehicle.reg_no+" "+(fill-temp)+" "+((fill-temp)*bunk.price));
					System.out.println("Fuel "+(fill-temp)+"added to your vehicle .");
					System.out.println("Amount : "+ ((fill-temp)*bunk.price));
					}
				else{
					vehicle.spent+=(fill)*bunk.price;
					bunk.earnings+=(fill)*bunk.price;
					bunk.curr_hold-=fill;
					vehicle.curr_hold+=fill;
					vehicle.transactions.add(bunk.petrol_id+" "+fill+" "+((fill)*bunk.price));
					bunk.transactions.add(vehicle.reg_no+" "+fill+" "+((fill)*bunk.price));
					System.out.println("Fuel "+fill+"added to your vehicle .");
					System.out.println("Amount : "+ ((fill)*bunk.price));
				}
				}	
		}
		
		
	}
	
	public static void displayVehicleDetails(PetrolBunks bunk,ArrayList<Vehicle>vehicles){
		Scanner sc=new Scanner(System.in);
		System.out.println();
		System.out.println("Enter the vehicle reg no ");
		int regno=sc.nextInt();
		System.out.println("Reg No");
		for(Vehicle vehicle:vehicles){
			if(vehicle.reg_no==regno){
				System.out.println(vehicle.reg_no+" "+vehicle.type+" "+vehicle.capacity+" "+vehicle.curr_hold);	
			}	
		}
	}
	
	public static void displayDetails(PetrolBunks bunk){
		Scanner sc=new Scanner(System.in);
		System.out.println();
		for(String s:bunk.transactions){
			System.out.println(s);
			
		}
	}
	
	public static void addFuel(PetrolBunks bunk){
		Scanner sc=new Scanner(System.in);
		System.out.println();
		System.out.println("Enter the amount to fill");
		int litre=sc.nextInt();
		if(bunk.curr_hold+litre<=bunk.capacity){
		bunk.curr_hold+=litre;
		}
		else{
			System.out.println("The amount is above the capacity of the bunk");
			int temp=bunk.curr_hold+litre-bunk.capacity;
			bunk.curr_hold=bunk.capacity;
			System.out.println("After filling the bunk to its capacity,remaining fuel is "+temp);
		}
	}
	
	public static void displayHolding(PetrolBunks bunk){
		Scanner sc=new Scanner(System.in);
	System.out.println();
	System.out.println("The Current Holding of the bunk is "+bunk.curr_hold);	
	}
	
	public static void  displayRevenue(PetrolBunks bunk){
		Scanner sc=new Scanner(System.in);
	System.out.println();
	System.out.println("The Revenue of the bunk is "+bunk.earnings);
		
	}
	
	public static void displayCapacity(PetrolBunks bunk){
	Scanner sc=new Scanner(System.in);
	System.out.println();
	System.out.println("The capacity of the bunk is "+bunk.capacity);
		
	}
	
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		
		PetrolBunks bunk=new PetrolBunks("Diesel",100,100,70);
		ArrayList<Vehicle>vehicles=new ArrayList<>();
		boolean flag1=true;
		while(flag1){
			System.out.println();
			System.out.println("Enter your choice");
			System.out.println("1.Bunk Modules");
			System.out.println("2.Car Modules");
			System.out.println("3.Exit");
			int choice1=sc.nextInt();
			
			switch(choice1){
				
				case 1:
				boolean flag2=true;
				while(flag2){
					System.out.println();
				System.out.println("Enter your choice");
				System.out.println("1.Capacity of a Bunk");
				System.out.println("2.Revenue Earned");
				System.out.println("3.Current Holding ");
				System.out.println("4.Fill a Vehicle ");
				System.out.println("5.Display Details ");
				System.out.println("6.Display a particular Vehicle Details ");
				System.out.println("7.Add fuel to the Bunk");
				System.out.println("8.Exit");
				
				int choice2=sc.nextInt();
				switch(choice2){
					
					case 1:
					displayCapacity(bunk);
					break;
					
					case 2:
					displayRevenue(bunk);
					break;
					
					case 3:
					displayHolding(bunk);
					break;
					
					case 4:
					fillVehicle(bunk,vehicles);
					break;
					
					case 5:
					displayDetails(bunk);
					break;
					
					case 6:
					displayVehicleDetails(bunk,vehicles);
					break;
					
					case 7:
					addFuel(bunk);
					break;
					
					case 8:
					flag2=false;
					break;
					
				}
					
				}
				break;
				
				case 2:
				boolean flag3=true;
				while(flag3){
					System.out.println();
				System.out.println("Enter your choice");
				System.out.println("1.Create a Vehicle");
				System.out.println("2.Exit");
				int choice3=sc.nextInt();	
				switch(choice3){
					case 1:
					createVehicles(vehicles);
					break;
					
					case 2:
					flag3=false;
					break;
				}	
					
				}
				break;
				
				case 3:
				flag1=false;
				break;
			}
			
			
		}
		
		




	}
}