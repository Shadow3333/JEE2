package monapp.utilitaire;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Class util Hash
 * 
 * @author Mariana, Fred
 *
 */
public class Hash {

	/**
	 * function which hash the password return the hash's password
	 * 
	 * @param key
	 * @return String
	 */
	public static String getEncodedPassword(String key) {
		byte[] uniqueKey = key.getBytes();
		byte[] hash = null;
		try {
			hash = MessageDigest.getInstance("MD5").digest(uniqueKey);
		} catch (NoSuchAlgorithmException e) {
			throw new Error("no MD5 support in this VM");
		}
		StringBuffer hashString = new StringBuffer();
		for (int i = 0; i < hash.length; ++i) {
			String hex = Integer.toHexString(hash[i]);
			if (hex.length() == 1) {
				hashString.append('0');
				hashString.append(hex.charAt(hex.length() - 1));
			} else {
				hashString.append(hex.substring(hex.length() - 2));
			}
		}

		return hashString.toString();
	}

	/**
	 * genered a Random password
	 * 
	 * @return random password
	 */
	public static String generedRandomPwd() {
		String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		int size = chars.length();
		String pass = "";
		for (int i = 0; i < 8; i++) {
			double random = Math.random();
			int num = (int) Math.floor(random * size - 1);
			pass += chars.charAt(num);
		}
		return pass;
	}

}
