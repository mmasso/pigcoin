package edu.elsmancs;

import static org.junit.Assert.assertNotNull;

import java.security.KeyPair;

import org.junit.*;

public class WalletTest{
    private Wallet wallet_1 = null;
    private KeyPair pair = null;

    @Before
    public void initalize(){
    wallet_1 = new Wallet();
    pair = GenSig.generateKeyPair();
    }

    @Test
    public void notNullTest(){
        assertNotNull(wallet_1);
    }

    @Test
    public void createKeysGensig(){
        wallet_1.setSK(pair.getPrivate());
        wallet_1.setAddress(pair.getPublic());
        assertNotNull(wallet_1.getAddress());
    }

}