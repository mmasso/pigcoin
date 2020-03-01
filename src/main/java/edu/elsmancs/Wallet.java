package edu.elsmancs;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.List;
import java.util.ArrayList;

public class Wallet {

    private PublicKey address = null;
    private PrivateKey sKey = null;
    private Double total_input = 0d;
    private Double total_output = 0d;
    private Double balance = 0d;
    private List<Transactions> inputTransactions = new ArrayList<Transactions>();
    private List<Transactions> outputTransactions = new ArrayList<Transactions>();


	void setSK(PrivateKey privateKey) {
        this.sKey = privateKey;
	}

	void setAddress(PublicKey adress) {
        this.address = adress;
	}

    /**
     * @return the adress
     */
    public PublicKey getAddress() {
        return address;
    }

	public void generateKeyPair() {
        KeyPair pair = GenSig.generateKeyPair();
        this.setSK(pair.getPrivate());
        this.setAddress(pair.getPublic());
    }

    @Override
    public String toString() {
        return "\n" + 
                "Wallet = " + address.hashCode() + "\n" +
                "Total Input = " + total_input + "\n" +
                "Total Output = " + total_output + "\n" +
                "Balance = " + balance 
                + "\n";
    }

}
