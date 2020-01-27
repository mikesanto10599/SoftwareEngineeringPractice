package edu.ithaca.dragon.bank;

public class BankAccount {

    private String email;
    private double balance;

    /**
     * @throws IllegalArgumentException if email is invalid
     */
    public BankAccount(String email, double startingBalance){
        if (isEmailValid(email)){
            this.email = email;
            this.balance = startingBalance;
        }
        else {
            throw new IllegalArgumentException("Email address: " + email + " is invalid, cannot create account");
        }
    }

    public double getBalance(){
        return balance;
    }

    public String getEmail(){
        return email;
    }

    /**
     * @post reduces the balance by amount if amount is non-negative and smaller than balance
     */
    public void withdraw (double amount)  {
        balance -= amount;

    }

//what I edited to help make your tests pass
    public static boolean isEmailValid(String email){
        if (email.indexOf('@') == -1){
            return false;
        }
        //make sure email doesn't start with or end with '.' or '@'
        if (email.indexOf('@') == 0 || email.indexOf('@') == email.length()-1){
            return false;
        }
        if (email.indexOf('.') == 0 || email.indexOf('.') == -1){
            return false;
        }
        //make sure there's a '.' where it needs to be
        if (email.indexOf('.') == (email.length()-1) || email.indexOf('.') == (email.length()-2)){
            return false;
        }
        if (email.indexOf('.') != (email.length()-4)){
            return false;
        }
        //no '..'
        if (email.charAt(email.indexOf('.')+1) == '.'){
            return false;
        }
        //make sure no consecutive symbols
        if (email.indexOf('.') != (email.indexOf('@')-1) || email.indexOf('.') != (email.indexOf('@')+1)){
            return false;
        }
        if (email.indexOf('.') != (email.indexOf('-')-1) || email.indexOf('.') != (email.indexOf('-')+1)){
            return false;
        }
        if (email.indexOf('-') != (email.indexOf('@')-1) || email.indexOf('-') != (email.indexOf('@')+1)){
            return false;
        }
        //make sure email doesn't start or ends with a symbol
        if(email.startsWith("!") || email.startsWith("#") || email.startsWith("/") || email.startsWith("-")){
            return false;
        }
        if(email.endsWith("!") || email.endsWith("#") || email.endsWith("/") ||  email.endsWith("-")){
            return false;
        }
        //make sure email has proper ending to domain
        if(email.endsWith(".com") == false || email.endsWith(".org") == false || email.endsWith(".edu") == false || email.endsWith(".gov") == false){
            return false;
        }

        return true;
    }
}
