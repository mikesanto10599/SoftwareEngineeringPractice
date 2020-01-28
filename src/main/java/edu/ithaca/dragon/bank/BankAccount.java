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

//what I edited to help make your tests pass (re-edited and should work now)
    public static boolean isEmailValid(String email){
        int length = email.length();
        //make sures these two symbols are in the email address
        if (email.indexOf('@') == -1){
            return false;
        }
        if (email.indexOf('.') == -1){
            return false;
        }
        //invalid
        if (email.indexOf('!') != -1 || email.indexOf('#') != -1 || email.indexOf('$') != -1 || email.indexOf('%') != -1){
            return false;
        }

        //checks to see if email starts or ends with symbols
        if(email.charAt(0) == '@' || email.charAt(0) == '.' || email.charAt(0) == '#' || email.charAt(0) == '-' || email.charAt(0) == '_' || email.charAt(0) == '!'){
            return false;
        }
        if(email.charAt(length-1) == '@' || email.charAt(length-1) == '.' || email.charAt(length-1) == '#' || email.charAt(length-1) == '-' || email.charAt(length-1) == '_' || email.charAt(length-1) == '!'){
            return false;
        }
        //checks double symbols
        if (email.indexOf('.')!=-1){
            int idx = email.indexOf('.');
            if (email.charAt(idx) == email.charAt(idx+1) || email.charAt(idx) == email.charAt(idx-1)) {
                return false;
            }
            if (email.charAt(idx-1) == '@'){
                return false;
            }
            if (email.charAt(idx+1) == '#' || email.charAt(idx-1) == '#'){
                return false;
            }
            if (email.charAt(idx+1) == '-' || email.charAt(idx-1) == '-'){
                return false;
            }
            if (email.charAt(idx+1) == '_' || email.charAt(idx-1) == '_'){
                return false;
            }
        }
        if (email.indexOf('#')!=-1){
            int idx = email.indexOf('#');
            if (email.charAt(idx+1) == '.' || email.charAt(idx-1) == '.'){
                return false;
            }
            if (email.charAt(idx+1) == '@' || email.charAt(idx-1) == '@'){
                return false;
            }
            if (email.charAt(idx+1) == email.charAt(idx) || email.charAt(idx-1) == email.charAt(idx)){
                return false;
            }
            if (email.charAt(idx+1) == '-'|| email.charAt(idx-1) == '-'){
                return false;
            }
            if (email.charAt(idx+1) == '_' || email.charAt(idx-1) == '_'){
                return false;
            }
        }
        if (email.indexOf('@')!=-1){
            int idx = email.indexOf('@');
            if (email.charAt(idx+1) == '.' || email.charAt(idx-1) == '.'){
                return false;
            }
            if (email.charAt(idx+1) == email.charAt(idx) || email.charAt(idx-1) == email.charAt(idx)){
                return false;
            }
            if (email.charAt(idx+1) == '#' || email.charAt(idx-1) == '#'){
                return false;
            }
            if (email.charAt(idx+1) == '-' || email.charAt(idx-1) == '-'){
                return false;
            }
            if (email.charAt(idx+1) == '_' || email.charAt(idx-1) == '_'){
                return false;
            }
        }
        if (email.indexOf('-')!=-1){
            int idx = email.indexOf('-');
            if (email.charAt(idx+1) == email.charAt(idx)  || email.charAt(idx-1) == email.charAt(idx)){
                return false;
            }
            if (email.charAt(idx+1) == '@' || email.charAt(idx-1) == '@'){
                return false;
            }
            if (email.charAt(idx+1) == '#'  || email.charAt(idx-1) == '#'){
                return false;
            }
            if (email.charAt(idx+1) == '-' || email.charAt(idx-1) == '-'){
                return false;
            }
            if (email.charAt(idx+1) == '_' || email.charAt(idx-1) == '_'){
                return false;
            }
        }
        if (email.indexOf('_')!=-1){
            int idx = email.indexOf('_');
            if (email.charAt(idx+1) == '.' || email.charAt(idx-1) == '.'){
                return false;
            }
            if (email.charAt(idx+1) == '@' || email.charAt(idx-1) == '@'){
                return false;
            }
            if (email.indexOf('#') == idx+1 || email.indexOf('#') == idx-1){
                return false;
            }
            if (email.charAt(idx+1) == '-' || email.charAt(idx-1) == '-'){
                return false;
            }
            if (email.charAt(idx+1) == email.charAt(idx) || email.charAt(idx-1) == email.charAt(idx)){
                return false;
            }
        }
        if(email.indexOf('.') >= length-3 ){
            return false;
        }
        return true;
    }
}
