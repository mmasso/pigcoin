package edu.elsmancs;

import static org.junit.Assert.assertNotNull;

import org.junit.*;

public class TransactionTest{
    private Wallet wallet_1 = null;
    private Wallet wallet_2 = null;
    private Transaction trans1 = null;
    private Transaction trans2 = null;

    @Before
    public void initalize(){
        wallet_1 = new Wallet();
        wallet_2 = new Wallet();
        wallet_2.generateKeyPair();
        wallet_1.generateKeyPair();
        trans1 = new Transaction();
        trans2 = new Transaction("hash", "prev_hash", wallet_1.getAddress(), wallet_2.getAddress(), 500, "hola que tal");
    }

    @Test
    public void notNullTest(){
        assertNotNull(trans1);
        assertNotNull(trans2);
    }

    @Test
    public void toStringNotNull(){
        assertNotNull(trans2.toString());
    }
}