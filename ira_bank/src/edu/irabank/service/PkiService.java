package edu.irabank.service;

import java.security.spec.InvalidKeySpecException;

public interface PkiService {

	public String KeyPairGenerator();
	
	public String sendEncryptedPaymentInfo(Integer userId, String privateKey) ;
	
	public boolean DecryptPaymentInfo(Integer userId, String paymentReceipt);
	
}
