package edu.irabank.service;

public interface PkiService {

	public String KeyPairGenerator();
	
	public String sendEncryptedPaymentInfo(Integer userId, String privateKey);
	
	public boolean DecryptPaymentInfo(Integer userId, String paymentReceipt);
	
}
