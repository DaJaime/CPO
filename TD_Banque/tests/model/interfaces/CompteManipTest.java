package model.interfaces;

import model.exceptions.InsufficientBalance;
import model.fact.CompteFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompteManipTest {

    CompteManip cm ;

    CompteManipTest(){
        cm = CompteFactory.INSTANCE.createCompteCourant("John Doe");}

    /*@BeforeAll
    void setUpAll(){
        cm = CompteFactory.INSTANCE.createCompteCourant("John Doe");
    }*/

    @BeforeEach
    void setUp() {
        cm.setBalance(1000.d);
    }

    @AfterEach
    void tearDown() {
        cm.setBalance(0.0d);
    }

    @Test
    void testWithdraw() throws InsufficientBalance {
        double oldBal = cm.getBalance();
        double amount = 500.0d;
        double newBal = cm.withdraw(amount);
        assertEquals(newBal,oldBal - amount);
    }

}