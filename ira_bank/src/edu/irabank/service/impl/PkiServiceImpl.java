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
import java.security.spec.X509EncodedKeySpec;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

import com.sun.org.apache.xml.internal.security.utils.Base64;

import edu.irabank.dao.UserDAO;
import edu.irabank.dto.UserDTO;
import edu.irabank.service.PkiService;


@Service
public class PkiServiceImpl implements PkiService {
	
@Autowired
private UserDAO userDAO;
	
	//Generate public/private keyPair
	public String KeyPairGenerator(){
		
		//System.out.println("comes in keypair gen service");
		KeyPairGenerator generateKeys = null;
		
		try{
			
			generateKeys = KeyPairGenerator.getInstance("RSA");
			generateKeys.initialize(1024);
			
			KeyPair keyPair = generateKeys.generateKeyPair();
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			BASE64Encoder encoder = new BASE64Encoder();

			X509EncodedKeySpec publicKeyInfo = keyFactory.getKeySpec(keyPair.getPublic(),
					X509EncodedKeySpec.class);
			
			//create publicKey
			String pbKey = encoder.encode(publicKeyInfo.getEncoded());

			PKCS8EncodedKeySpec privateKeyInfo = keyFactory.getKeySpec(
					keyPair.getPrivate(), PKCS8EncodedKeySpec.class);
			
			
			//create private key
			String prKey = encoder.encode(privateKeyInfo.getEncoded());
			System.out.println("**********PRIVATE KEY********");
			System.out.println(prKey);
			
			//*************OTP**************
			//Now, Email private key to the user
			//************OTP********************
			
			//Return the public key to the new User registration object
			return pbKey;
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null; // Unreachable code !!
	}
	
	public String sendEncryptedPaymentInfo(Integer userId, String alias_privateKey)
	{
		
		//get corresponding password of userID
		String password = userDAO.getPassword(userId);
		
		try
		{
		BASE64Decoder base64 = new BASE64Decoder();
		byte[] _byte = base64.decodeBuffer(alias_privateKey);
		X509EncodedKeySpec privateKeyInfo = new X509EncodedKeySpec(_byte);
		KeyFactory factory = KeyFactory.getInstance("RSA");
		PrivateKey privateKey = factory.generatePrivate(privateKeyInfo);
		
		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher.init(Cipher.ENCRYPT_MODE, privateKey); // Encrypting the hashed password with private key
		
		return cipher.doFinal(password.getBytes("ISO-8859-1")).toString();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return null; //Unreachable code !!
		
	}
	
	public boolean DecryptPaymentInfo(Integer userId, String paymentReceipt)
	{
		//get corresponding public Key of userID
		String alias_publicKey = userDAO.getPublicKey(userId);
		
		String hashedPassword = userDAO.getPassword(userId);
		
		try
		{
		BASE64Decoder base64 = new BASE64Decoder();
		byte[] _byte = base64.decodeBuffer(alias_publicKey);
		X509EncodedKeySpec publicKeyInfo = new X509EncodedKeySpec(_byte);
		KeyFactory factory = KeyFactory.getInstance("RSA");
		PublicKey publicKey = factory.generatePublic(publicKeyInfo);
		
		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher.init(Cipher.DECRYPT_MODE, publicKey); // Decrypting paymentReceipt with public Key
		
		String decryptedPassword = cipher.doFinal(paymentReceipt.getBytes("ISO-8859-1")).toString();
		
		if(decryptedPassword == hashedPassword)
		{
			return true;
		}
		else
		{
			return false;
		}
		
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return false; //Unreachable code !!
		

	}
}
		/*	
			
			
			
			X509Certificate x509 = null;
			
			try {
				String domain = "CN=IRA_BANK, L=Tempe, C=USA"; // find the domain name
				x509 = CertificateGenerator(domain, keyPair, 100, "SHA1withRSA");
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
				FileWriter fileWriter = new FileWriter(path);
				
				BufferedWriter writer = new BufferedWriter(fileWriter);
				writer.write("***************************************");
				writer.write("******CERTIFICATE BEGINNING*************");
				writer.newLine();
				writer.write(Base64.encode(x509.getEncoded()));
				writer.newLine();
				writer.write("******************************************");
				writer.write("*********CERTIFICATE ENDS*****************");
	
				writer.close();
				
			
		
		
			// Send digital certificate as attachment
				//OTP code to be used here
			try {
				
				OTPMailAPI.sendMailWithAttachment(UserManager.emailidreturn(userId),
						"Digital Certificate for HappyTT Bank",
						"Please save this Certificate at a secure location",
						filePath, file.getName());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		
				
			file.delete(); // NOT TO BE STORED ANYWHERE
			
		} catch (IOException | CertificateEncodingException c){
			
		}

	} catch (NoSuchAlgorithmException e) {
		System.out.println("Error in generating Key Pair for userId: " + userId);
	} catch (InvalidKeySpecException e) {
		System.out.println("Error in setting Key pair for userId: " + userId);
	}
		
		
	}
	
	
	
	// Generate the X509 Certificate.
	private X509Certificate CertificateGenerator(String domain, KeyPair keyPair, Integer range, String algo_used)
			throws GeneralSecurityException, IOException
			{
		PrivateKey prkey = keyPair.getPrivate();
		X509CertInfo x509info = new X509CertInfo();
		Date from = new Date();
		Date to = new Date(from.getTime() + range * 86400000l);
		CertificateValidity interval = new CertificateValidity(from, to);
		BigInteger secureNo = new BigInteger(64, new SecureRandom());
		X500Name owner = new X500Name(secureNo);

		x509info.set(X509CertInfo.VALIDITY, interval);
		x509info.set(X509CertInfo.SERIAL_NUMBER, new CertificateSerialNumber(secureNo));
		x509info.set(X509CertInfo.SUBJECT, new CertificateSubjectName(owner));
		x509info.set(X509CertInfo.ISSUER, new CertificateIssuerName(owner));
		x509info.set(X509CertInfo.KEY, new CertificateX509Key(keyPair.getPublic()));
		x509info.set(X509CertInfo.VERSION, new CertificateVersion(CertificateVersion.V3));
		AlgorithmId algo = new AlgorithmId(AlgorithmId.md5WithRSAEncryption_oid);
		x509info.set(X509CertInfo.ALGORITHM_ID, new CertificateAlgorithmId(algo));

		
		X509CertImpl x509certificate = new X509CertImpl(x509info);
		x509certificate.sign(prkey, algo_used);

		algo = (AlgorithmId)x509certificate.get(X509CertImpl.SIG_ALG);
		x509info.set(CertificateAlgorithmId.NAME + "." + CertificateAlgorithmId.ALGORITHM, algo);
		x509certificate = new X509CertImpl(x509info);
		x509certificate.sign(prkey, algo_used);
		
		return x509certificate;

	}


}
*/