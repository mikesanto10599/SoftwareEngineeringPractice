package edu.ithaca.dragon.bank;

import java.security.InvalidParameterException;

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
     * @throws InsufficientFundsException if balance is smaller than withdraw amount
     */
    public void withdraw (double amount) throws InsufficientFundsException, IllegalArgumentException {
        if (balance > 0) {
            if (amount < balance && amount >= .01) {
                balance -= amount;
            }
            else if (amount == 0){
                balance = balance;
            }
            else if (amount < .01){
                throw new IllegalArgumentException("insufficient amount to withdraw");
            }
            else if (amount > balance){
                throw new InsufficientFundsException("your balance is less than your withdraw amount");
            }
        }
        else {
            throw new InsufficientFundsException("Your balance is zero");
        }
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

        //makes sure there's no invalid symbol after @
        int idx = email.indexOf('@');
        for (int i = idx+1; i < length; i++){
            if (email.charAt(i) == '@'){
                return false;
            }
            else if (email.charAt(i) == '_'){
                return false;
            }
            else if (email.charAt(i) == '#'){
                return false;
            }
            else if (email.charAt(i) == '!'){
                return false;
            }
            else if (email.charAt(i) == '$'){
                return false;
            }
            else if (email.charAt(i) == '%'){
                return false;
            }
        }
        //make sures there's only 1 @
        for (int j = idx-1; j > -1; j--) {
            if (email.charAt(j) == '@'){
                return false;
            }
        }

        int count = 0;
        for (int k = idx+1; k < length; k ++){
            if (email.charAt(k)== '.'){
                count ++;
            }
            if (count > 1){
                return false;
            }
        }
        if(email.indexOf('.') > length-3 ){
            return false;
        }
        return true;
    }
}
