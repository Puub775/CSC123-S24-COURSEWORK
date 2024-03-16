
//Name: Pablo Conde 
//Email: pconde1@csudh.edu

public class BankAccount{

     //declare instance fields 
	private String ownerFirstName;
	private String ownerLastName;
	private double balance;
	private boolean isOpen;

     //constructor

    public BankAccount(String ownerFirstName, String ownerLastName, double initialDepositAmount){
    	this.ownerFirstName = ownerFirstName;
    	this.ownerLastName = ownerLastName;
    	this.balance = initialDepositAmount;
    	this.isOpen = true;

    }

    public boolean deposit(double amount){

     //return true if deposit is successful 
    	if(isOpen && amount > 0) {
	   		 this.balance += amount;
	   		 return true;
    	}
    	else {
    		return false;
    	}   	
    }

    public boolean withdraw(double amount){

            //return true if withdrawal is successful 
    	if(isOpen && amount > 0 && amount <= balance) {
    		this.balance -= amount;
    		return true;
    	}
    	else {
    		return false;
    	}

     }
     public boolean isOpen(){

        //return true if account is open
    	 return isOpen;
     }

     public void close(){
          //close bank account
    	 this.isOpen = false;
     }
     public String getOwnerFullName(){
        //return Account Holder's full name
    	 return ownerFirstName + " " + ownerLastName;   	 
      }
     public double getBalance() {
    	 return balance;
     }
     public void viewAccountStatement() {
    	 if(isOpen) {
    		 System.out.print("Account Statement of: " + getOwnerFullName());
    		 System.out.println("Current Balance: $" + balance);
    	 } 	 
    	 else {
    		 System.out.println("This account cannot be viewed.");
    	 }    		 
     }
}