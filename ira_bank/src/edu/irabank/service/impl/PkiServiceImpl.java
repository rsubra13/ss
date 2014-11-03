package edu.irabank.service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Date;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpSession;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import sun.security.x509.AlgorithmId;
import sun.security.x509.CertificateAlgorithmId;
import sun.security.x509.CertificateIssuerName;
import sun.security.x509.CertificateSerialNumber;
import sun.security.x509.CertificateSubjectName;
import sun.security.x509.CertificateValidity;
import sun.security.x509.CertificateVersion;
import sun.security.x509.CertificateX509Key;
import sun.security.x509.X500Name;
import sun.security.x509.X509CertImpl;
import sun.security.x509.X509CertInfo;

import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;

import edu.irabank.dao.UserDAO;
import edu.irabank.dto.UserDTO;
import edu.irabank.service.PkiService;

/**
 * @author Ishaan Sharma
 *
 */

@Service
public class PkiServiceImpl implements PkiService {
	
@Autowired
private UserDAO userDAO;

@Autowired
private JavaMailSender mailSender;
	
	//Generate public/private keyPair
	
	@Override
	@Transactional
	public String KeyPairGenerator(){
		
		//System.out.println("comes in keypair gen service");
		KeyPairGenerator generateKeys = null;
		
		try{
			
			generateKeys = KeyPairGenerator.getInstance("RSA");
			generateKeys.initialize(2048);
			
			KeyPair keyPair = generateKeys.generateKeyPair();
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			BASE64Encoder encoder = new BASE64Encoder();

			X509EncodedKeySpec  publicKeyInfo = keyFactory.getKeySpec(keyPair.getPublic(),
					X509EncodedKeySpec.class);
			
			//create publicKey
			String pbKey = encoder.encode(publicKeyInfo.getEncoded());

			PKCS8EncodedKeySpec  privateKeyInfo = keyFactory.getKeySpec(
					keyPair.getPrivate(), PKCS8EncodedKeySpec .class);
			
			
			//create private key
			String prKey = encoder.encode(privateKeyInfo.getEncoded());
			System.out.println(("******Your private key for IRA BANK is******** "+"\n"+prKey));
			
			
			//*********Now create the certificate************
			
			/*X509Certificate x509 = null;
			try{
				
				String dname = "CN=GroupProject, L=Tempe, C=USA";
				x509 = generateCertificate(dname, keyPair, 100, "SHA1withRSA");
			} catch (GeneralSecurityException | IOException e) {
				e.printStackTrace();
			}
			
			String path = "";
			
			try {
				File file = new File(userId + "_cer.cer");
				if (!file.exists()) {
					file.createNewFile();
				}
				path = file.getAbsolutePath();
				System.out.println("FilePath1 = "+path);
				FileWriter fw = new FileWriter(path);
				BufferedWriter writer = new BufferedWriter(fw);
				writer.write("-----BEGIN CERTIFICATE-----");
				writer.newLine();
				writer.write(Base64.encode(x509.getEncoded()));
				writer.newLine();
				writer.write("-----END CERTIFICATE-----");
	
				writer.close();
				
				// Send as attachment
				try {
					
					OTPMailAPI.sendMailWithAttachment(UserManager.emailidreturn(userId),
							"Digital Certificate for HappyTT Bank",
							"Please save this Certificate at a secure location",
							filePath, file.getName());
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				// Delete file
				file.delete();
			} catch (IOException | CertificateEncodingException c){
				
			}*/
			
			
			
			//Send an email to the user
			SimpleMailMessage email = new SimpleMailMessage();
	        email.setTo("ishaan_0990@yahoo.com");
	        email.setSubject("Your private Key");
	        email.setText("******Your private key for IRA BANK is******** "+"\n"+prKey+"\n"+""+"Please store at a secure location");
	        
	        mailSender.send(email); 
			
			//Return the public key to the new User registration object
			return pbKey;
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null; // Unreachable code !!
	}
	
	@Override
	@Transactional
	public String sendEncryptedPaymentInfo(Integer userId, String alias_privateKey) 
	{
		
		//get corresponding userName of userID
		String userName = userDAO.getuserName(userId);
		
		try
		{
		byte[] _byte = Base64.decode(alias_privateKey);
	
		
		PKCS8EncodedKeySpec privateKeyInfo = new PKCS8EncodedKeySpec(_byte);
	
		KeyFactory factory = KeyFactory.getInstance("RSA");
		
		PrivateKey privateKey = factory.generatePrivate(privateKeyInfo);
	//	System.out.println(("**************privateKEY VALUE************"+privateKey));
		
		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher.init(Cipher.ENCRYPT_MODE, privateKey); // Encrypting the userName with private key
		
		byte[] test =  cipher.doFinal(Base64.decode(userName));
		
		BASE64Encoder b64 = new BASE64Encoder();
		String encryptedPayment= b64.encode(test);
		
		//boolean test2 = DecryptPaymentInfo(userId, en); //test both services.
		
		return encryptedPayment;
		}
		catch(Exception e)
		{
			 e.printStackTrace();
		}
		return null;
	}
	
	@Override
	@Transactional
	public boolean DecryptPaymentInfo(Integer userId, String paymentReceipt)
	{
		//get corresponding public Key of userID
		String alias_publicKey = userDAO.getPublicKey(userId);
		
		byte[] decryptedPayment = null;
			try {
				decryptedPayment= Base64.decode(paymentReceipt);
			} catch (Base64DecodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		String userName = userDAO.getuserName(userId); //get corresponding userName from the DTO
		
		try
		{
	
		byte[] _byte = Base64.decode(alias_publicKey);
		X509EncodedKeySpec publicKeyInfo = new X509EncodedKeySpec(_byte);
		KeyFactory factory = KeyFactory.getInstance("RSA");
		PublicKey publicKey = factory.generatePublic(publicKeyInfo);
		
		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher.init(Cipher.DECRYPT_MODE, publicKey); // Decrypting paymentReceipt with public Key
		
		byte[] decryptedUserName = cipher.doFinal(decryptedPayment);
		
		String decryptedUsername= Base64.encode(decryptedUserName);
		
		
		if(decryptedUsername.equals(userName)) //Check authenticity of the user
		{
			return true; //Approve the payment
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		return false;
	}
}
