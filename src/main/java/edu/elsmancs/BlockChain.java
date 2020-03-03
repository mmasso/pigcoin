package edu.elsmancs;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class BlockChain {

    private List<Transaction> bchain = new ArrayList<Transaction>();

    public BlockChain(){};

	public void addOrigin(Transaction trx) {
        bchain.add(trx);
	}

	public void summarize() {
        bchain.forEach(transaction -> System.out.println(transaction.toString()));
	}

	public void summarize(Integer position) {
        System.out.println(bchain.get(position).toString());
	}

	public List<Double> loadWallet(PublicKey address) {
        Double send = 0d;
        Double recieve = 0d;
        for (Transaction transaction : bchain){
            if (transaction.getpKey_recipient() == address) recieve += transaction.getPigcoins();
            if (transaction.getpKey_sender() == address) send += transaction.getPigcoins();
        }
        List<Double> sendsAndRecieves = new ArrayList<Double>();
        sendsAndRecieves.add(send);
        sendsAndRecieves.add(recieve);
        return sendsAndRecieves;
    }

	public List<Transaction> loadOutputTransactions(PublicKey address) {
        List<Transaction> senders = new ArrayList<Transaction>();
        for (Transaction transaction : bchain){
            if (transaction.getpKey_sender() == address) senders.add(transaction);
        }
		return senders;
	}

	public List<Transaction> loadInputTransactions(PublicKey address) {
        List<Transaction> recieveds = new ArrayList<Transaction>();
        for (Transaction transaction : bchain){
            if (transaction.getpKey_recipient() == address) recieveds.add(transaction);
        }
		return recieveds;
	}
}
