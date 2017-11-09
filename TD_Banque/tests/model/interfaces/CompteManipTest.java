package model.interfaces;

import model.exceptions.InsufficientBalance;
import model.fact.CompteFactory;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.DoublePredicate;
import java.util.stream.DoubleStream;

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

    @AfterAll
    void tearDownAll(){
        cm = null;
    }

    @Test
    void testWithdraw() throws InsufficientBalance {
        double oldBal = cm.getBalance();
        double amount = 500.0d;
        double newBal = cm.withdraw(amount);
        assertEquals(newBal,oldBal - amount);
    }

    @ParameterizedTest
    @MethodSource("range500To1000")
    void withdrawWithParam(double amount) throws InsufficientBalance{
        double oldBal = cm.getBalance();
        double newBal = cm.withdraw(amount);
        assertEquals(newBal, oldBal - amount);
    }

    static DoubleStream range500To1000(){
        return DoubleStream.iterate(500.0d, n -> n +100.0d).limit(6);
    }

    @ParameterizedTest
    @MethodSource("rangeForOverdraft")
    void withdrawWithParamExpectOverdraft(double amount){
        assertThrows(InsufficientBalance.class, () -> cm.withdraw(amount));
    }

    static DoubleStream rangeForOverdraft(){
        return DoubleStream.iterate(1100.0d, n -> n + 100.0d).limit(3);
    }
}