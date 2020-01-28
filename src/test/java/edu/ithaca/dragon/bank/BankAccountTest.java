package edu.ithaca.dragon.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void getBalanceTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals(200, bankAccount.getBalance());
    }

    @Test
    void withdrawTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        bankAccount.withdraw(100);
        assertEquals(100, bankAccount.getBalance());

    }

    @Test
    void isEmailValidTest(){
        assertTrue(BankAccount.isEmailValid( "a@b.com"));
        assertFalse( BankAccount.isEmailValid(""));
        //last portion of domain less than 2 characters
        assertFalse(BankAccount.isEmailValid("fj32@gmail.o"));
        //underscore not followed by a letter or number
        assertFalse(BankAccount.isEmailValid("j32_@gmail.com"));
        //period not followed by a letter or number
        assertFalse(BankAccount.isEmailValid("jdfn.@fsj.tu"));
        //dash not followed by a number or letter
        assertFalse(BankAccount.isEmailValid("fdsfd-@rti.com"));
        //dash not followed by a number or letter
        assertFalse(BankAccount.isEmailValid("fdsfd-.fdgd@rti.com"));
        //invalid character in prefix
        assertFalse(BankAccount.isEmailValid("fdh!bfd@gmail.com"));
        //doesn't start with number or letter
        assertFalse(BankAccount.isEmailValid(".ksk@hotmail.com"));
    }

    @Test
    void constructorTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals("a@b.com", bankAccount.getEmail());
        assertEquals(200, bankAccount.getBalance());
        //check for exception thrown correctly
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("", 100));
    }

}