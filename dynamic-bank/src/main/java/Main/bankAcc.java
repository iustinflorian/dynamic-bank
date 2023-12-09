package Main;

public class bankAcc{
    public String firstName;
    public String lastName;
    private int ID;
    private int balance;
    public bankAcc(String firstName, String lastName, int ID,int balance){
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.balance = balance;
    }
    public int getBalance(){
        return this.balance;
    }
    public void deposit(int num){
        this.balance += num;
    }
    public void withdraw(int num){
        this.balance -= num;
    }
}
