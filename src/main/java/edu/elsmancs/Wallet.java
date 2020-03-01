package edu.elsmancs;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.List;
import java.util.ArrayList;

public class Wallet {

    private PublicKey address = null;
    private PrivateKey sKey = null;
    private byte total_input = 0;
    private byte total_output = 0;
    private byte balance = 0;
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

}
