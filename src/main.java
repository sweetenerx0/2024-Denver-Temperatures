import java.util.Scanner;
import java.util.ArrayList;

class Home{ // only one public class
	private int square_footage;
	private String address;
	private String city;
	private String Model_name;
	private int zip_code;
	private String sale_status;
	
	public Home(int square_footage, String address, String city, String Model_name, int zip_code, String sale_status){
		this.square_footage = square_footage;
		this.address = address;
		this.city = city;
		this.Model_name = Model_name;
		this.zip_code = zip_code;
		this.sale_status = sale_status;
		
	}// closer for square footage constructor
	public int getsquare_footage(){
		return square_footage;
	    }// closer for return square footage
	public String getaddress() {
		return address;
	}//closer for getaddress)(
	public String getcity() {
		return city;
	}// closer for getcity()
	public String getModel_name() {
		return Model_name;
	}//closer for getModel_name()
	public int getzip_code() {
		return zip_code;
	}//closer for getzipcode()
	public String getsale_status() {
		return sale_status;
	}
}// closer for public class home

public class main {
	String[] hashmap; // testing array for storage of objects
	
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		ArrayList<Home> homeInventory = new ArrayList<>();
		while (true) {
			System.out.println("Please enter one the following options:");
			System.out.println("ADD a home listing");
			System.out.println("REMOVE a home listing");
			System.out.println("VIEW current inventory");
			//System.out.println("PRINT current inventory");// ask if want to print to file
			// ask if they want to view, add, remove, or print inventory
			// remember to lower.case everything for try catch exception
			String response = scnr.nextLine();
			System.out.println(response.toLowerCase());
			try {
				if (response.toLowerCase().equals("add")) {
					Home makeHome = addHome(scnr); // tell it to make a new home listing
					homeInventory.add(makeHome); // add that to the Inventory
				}
				else if (response.toLowerCase().equals("view")) {
					if (homeInventory.isEmpty()){
			            System.out.println("There are no current listings.");
			        }
				    int indexUI = 1; // start numbering from 1
				    for (Home listing : homeInventory) {
				    	System.out.println(indexUI + ". " + listing.getaddress().toUpperCase() + ", " + listing.getcity().toUpperCase() + " " + listing.getzip_code() + ". " + listing.getModel_name().toUpperCase() + ". " + listing.getsquare_footage() + " sq ft. " + listing.getsale_status().toUpperCase());
				        indexUI++; // increment for next listing
				    }
				}// closer for view else if
				else if (response.toLowerCase().equals("remove")) {
					removeHome(homeInventory, scnr);
				    }
			System.out.println();
			}
		 // closer for try
			catch (Exception e) {
				System.out.println("Try again.");
			}
		}// closer for while loop
	}// closer for main(String[] args)
	
public static Home addHome(Scanner scnr){
	System.out.println("Enter square footage of home");
	int addsquare_footage = scnr.nextInt();
	scnr.nextLine(); 
	
	System.out.println("Enter the street address of home");
	String addaddress = scnr.nextLine();
	//scnr.nextLine();
	
	System.out.println("Enter the city of home");
	String addcity = scnr.nextLine();
	
	System.out.println("Enter the model of this home");
	String addModel_name = scnr.nextLine();
	
	System.out.println("Enter the zip of this home");
	int addzip_code = scnr.nextInt();
	scnr.nextLine();// switch from leftover of int scanner input to string for next  input
	
	System.out.println("Enter the sale satus of this home (SOLD , AVAILABLE, or UNDER CONTRACT)");
	String addsale_status = scnr.nextLine();
	
	Home newHome = new Home(addsquare_footage, addaddress, addcity, addModel_name, addzip_code, addsale_status); // tell it we are creating a new object, a new Home listing
	System.out.println("Successfully added " + addaddress + ", "+ addcity + " " + addzip_code + ". This home is a " + addModel_name + " and has " + addsquare_footage + " sqaure feet. It is currently marked as " + addsale_status + ".");
	System.out.println();
	return newHome;
	//KEEP THIS AS TEST but this will eventually be moved to View method 
	// create the object under assigned variable newHome
	        //set the square footage
}

public static void removeHome(ArrayList<Home> homeInventory,Scanner scnr) { // remove the home from index
    try{
        if (homeInventory.isEmpty()){
            throw new Exception("There are no listings.");
        }// closer for checking if homeInventory has no listings
        
        int indexUI = 1; // to correspond with how the user sees the inex in the list
        System.out.println("Enter the number of the home you want to remove.");
        int removeIndex = scnr.nextInt();
        scnr.nextLine();
        if (removeIndex < 1 || removeIndex > homeInventory.size()) {// checking if it is within the listing numbers
            System.out.println("No listing exists. Please try again.");
            return;// go back to asking
        }// closer for if checking number listings
        Home removedHome = homeInventory.remove(removeIndex - 1);
        System.out.println("Successfully removed " + removedHome.getaddress().toUpperCase()+ " from listings.");
    } catch (Exception e) {
        System.out.println("There are no current listings.");
    }
}


}// closer for main{}
