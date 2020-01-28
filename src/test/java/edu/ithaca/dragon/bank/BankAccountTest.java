package edu.ithaca.dragon.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void getBalanceTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals(200, bankAccount.getBalance());
    }

    /*@Test
    void withdrawTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        bankAccount.withdraw(100);
        assertEquals(100, bankAccount.getBalance());

    }*/

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

        //Symbol followed by non-letter or non-number
        assertFalse(BankAccount.isEmailValid("djs@$@gmail.com"));
        assertFalse(BankAccount.isEmailValid("df-.ds@dfm.eo"));
        assertTrue(BankAccount.isEmailValid("da.s.e.4@hotmail.com"));
        assertFalse(BankAccount.isEmailValid("gh--dfa@gds.tr"));

        //invalid characters
        assertFalse(BankAccount.isEmailValid("djak#dk@dl.cc"));
        assertFalse(BankAccount.isEmailValid("djakdk@d!l.cc"));
        assertFalse(BankAccount.isEmailValid("dja$dk@dl.cc"));
        assertFalse(BankAccount.isEmailValid("dj%dk@dl.cc"));
        assertFalse(BankAccount.isEmailValid("djadk@dl.c!c"));

        //Prefix must start with number or letter
        assertFalse(BankAccount.isEmailValid(".fdsf@gmail.com"));
        assertFalse(BankAccount.isEmailValid("-fdsf@gmail.com"));
        assertFalse(BankAccount.isEmailValid("_fdsf@gmail.com"));
        assertTrue(BankAccount.isEmailValid("fdsf@gmail.com"));
        assertTrue(BankAccount.isEmailValid("32jfl2@gmail.com"));

        //Only dashes allowed in suffix
        assertTrue(BankAccount.isEmailValid("hello_world@dj-fs.co"));
        assertTrue(BankAccount.isEmailValid("fdja@dd.c-o"));
        assertFalse(BankAccount.isEmailValid("dsa@df.fd.oew"));
        assertFalse(BankAccount.isEmailValid("dsa@df_d-fd.oew"));

        //The last portion of the domain must be at least two characters
        assertFalse(BankAccount.isEmailValid("dsa@fad.o"));
        assertFalse(BankAccount.isEmailValid("dsa@fad."));
        assertTrue(BankAccount.isEmailValid("dsa@fad.fd"));
        assertTrue(BankAccount.isEmailValid("dsa@fad.ff-d-s-f-d-sd"));




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