package edu.elsmancs;

import java.security.PublicKey;

public class Transaction {
    private String hash = null;
    private String prev_hash = null;
    private PublicKey pKey_sender = null;
    private PublicKey pKey_recipient = null;
    private Double pigcoins = 0d;
    private String message = null;
    byte[] signature;


    public Transaction() {
	}

	public Transaction(String hash, String prev_hash, PublicKey address, PublicKey address2, int pigcoins, String message) {
        this.hash = hash;
        this.prev_hash = prev_hash;
        this.pKey_sender = address;
        this.pKey_recipient = address2;
        Double pigcoinsD = Double.valueOf(pigcoins);
        this.pigcoins = pigcoinsD;
        this.message = message;
    }

    /**
     * @return the pKey_recipient
     */
    public PublicKey getpKey_recipient() {
        return pKey_recipient;
    }

    /**
     * @return the pKey_sender
     */
    public PublicKey getpKey_sender() {
        return pKey_sender;
    }
    
    /**
     * @return the pigcoins
     */
    public Double getPigcoins() {
        return pigcoins;
    }

    @Override
    public String toString() {
        return "\n" + 
                "hash = " + hash + "\n" +
                "prev_hash = " + prev_hash + "\n" +
                "pKey_sender = " + pKey_sender.hashCode() + "\n" +
                "pKey_recipient = " + pKey_recipient.hashCode() + "\n" +
                "pigcoins = " + pigcoins + "\n" +
                "message = " + message 
                + "\n";
    }

}
