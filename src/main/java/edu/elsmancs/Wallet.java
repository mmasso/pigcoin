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
    private List<Transaction> inputTransactions = new ArrayList<Transaction>();
    private List<Transaction> outputTransactions = new ArrayList<Transaction>();


	void setSK(PrivateKey privateKey) {
        this.sKey = privateKey;
	}

	void setAddress(PublicKey adress) {
        this.address = adress;
    }
    
    void updateBalance() {

        this.balance = this.total_input - this.total_output;
    }

    /**
     * @param total_input the total_input to set
     */
    public void setTotal_input(Double total_input) {
        this.total_input = total_input;
    }

    /**
     * @param total_output the total_output to set
     */
    public void setTotal_output(Double total_output) {
        this.total_output = total_output;
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

	public void loadCoins(BlockChain bChain) {
        List<Double> sendsAndRecieves = bChain.loadWallet(address);
        for(int i = 0 ; i < sendsAndRecieves.size(); i++){
            if(i == 0)setTotal_output(sendsAndRecieves.get(i));
            if(i == 1)setTotal_input(sendsAndRecieves.get(i));
        updateBalance();
        }
	}

}
