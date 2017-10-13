package main;

import model.dec.CompteManip;
import model.exceptions.InsufficientBalance;
import model.fact.CompteFactory;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Main
{
    private static final Logger LOG = Logger.getLogger(Main.class.getCanonicalName());

    public static void main (String[] args)
    {
        Handler handler = new ConsoleHandler();
        handler.setLevel(Level.FINE);

        LOG.addHandler(handler);

        CompteFactory cf = new CompteFactory();

        CompteManip c1 = cf.createCompteCourant("John Doe");
        CompteManip c2 = cf.createCompteCourant("Jack Bauer");

        c1.deposit(1500.0d);
        double amount = 1900.0d;
        try {
            double retrait = c1.withdraw(amount);
        }
        catch (InsufficientBalance ex){
            LOG.severe(ex.getMessage());
        } finally {
            System.out.print("bloc finally");
            LOG.fine("Withdraw operation of " + amount);
        }
        double newSolde = c2.deposit(100000.0d);

        System.out.println(c1);
        LOG.info(c1.toString());
        System.out.println(c2.toString());
    }
}
