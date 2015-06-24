import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.xml.bind.DatatypeConverter;


public class Hash {
	public static void main(String args[]){
		String password = "TestPass12#$";
		String verifyHash = "dc764e82535720ccb3fdfde38af4e8be";
		try {
			
			//***** MD5 hash
			byte[] bytesOfPassword = password.getBytes("UTF-8");

			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] md5Digest = md.digest(bytesOfPassword);
			String md5HashHex = DatatypeConverter.printHexBinary(md5Digest);
			System.out.println("passwd MD5 hex: " + md5HashHex);
			System.out.println("passwd MD5 hex equals: " + md5HashHex.equalsIgnoreCase(verifyHash));
			
			//***** encrypt AES
			// Generate key
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
		    kgen.init(128);
		    SecretKey aesKey = kgen.generateKey();
		    
		    System.out.println("***** key " + DatatypeConverter.printHexBinary(aesKey.getEncoded()));

		    // Encrypt cipher
		    Cipher encryptCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		    encryptCipher.init(Cipher.ENCRYPT_MODE, aesKey);

		    // Encrypt
		    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		    CipherOutputStream cipherOutputStream = new CipherOutputStream(outputStream, encryptCipher);
		    cipherOutputStream.write(md5HashHex.getBytes());
		    cipherOutputStream.flush();
		    cipherOutputStream.close();
		    byte[] encryptedBytes = outputStream.toByteArray();
		    
		    cipherOutputStream.close();
		    byte[] iv = encryptCipher.getIV();
		    
		    System.out.println("***** encrypted " + DatatypeConverter.printHexBinary(encryptedBytes));
			
		    //***** decrypt AES
		    // Decrypt cipher
		    Cipher decryptCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		    IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
		    decryptCipher.init(Cipher.DECRYPT_MODE, aesKey, ivParameterSpec);

		    // Decrypt
		    outputStream = new ByteArrayOutputStream();
		    ByteArrayInputStream inStream = new ByteArrayInputStream(encryptedBytes);
		    CipherInputStream cipherInputStream = new CipherInputStream(inStream, decryptCipher);
		    byte[] buf = new byte[1024];
		    int bytesRead;
		    while ((bytesRead = cipherInputStream.read(buf)) >= 0) {
		        outputStream.write(buf, 0, bytesRead);
		    }

		    System.out.println("Result: " + new String(outputStream.toByteArray()));
		
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IOException | InvalidAlgorithmParameterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
