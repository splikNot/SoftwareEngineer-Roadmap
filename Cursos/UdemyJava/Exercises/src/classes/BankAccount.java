package classes;
import java.util.Locale;


public class BankAccount {
	
	static { Locale.setDefault(Locale.US); }
	
    private String holderName;
    
    private final int accountNumber;
    
    private double balanceAccount = 0.00;

    //Constructor
    public BankAccount(int accountNumber, String holderName, double inicialDeposit){
        this.holderName = holderName;
        this.accountNumber = accountNumber;
        deposit(inicialDeposit);
    }

    // WithDraw
    public void withDraw(double valueToDraw){
    	final int withDrawTax = 5;
        balanceAccount -= (valueToDraw + withDrawTax);
    }

    // Deposit
    public void deposit(double valueToDeposit){
        balanceAccount += valueToDeposit;
        
    }
    //DataAccount;
    public void dataAccount() {
    	System.out.printf("Account %d, Holder: %s, Balance: $%.2f %n",
    			accountNumber, holderName, balanceAccount);
    }
    
}
