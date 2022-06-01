package PasswordEncryptionDecryption;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class USER {
    private int userId;
		private static String userPassword;
		
		USER(int id, String password){
			userId = id;
			userPassword = password;
		}
		
		public static void addUSER(int id, String password) {
			// TODO Auto-generated method stub
			USER user1 = new USER(id,password);
			System.out.println("Account Created Succesfully");
		}
		public static boolean access(String inputPassword){
			if(inputPassword.equals(userPassword)) {
				return true;
			}
			else
			return false;
		}
			
		
		public static void setPassword(String prevPassword, String newPassword){
			if(userPassword.equals(prevPassword)) {
				userPassword = newPassword;
				System.out.println("Password updated succesfully");
			}
			else {
				System.out.println("BAD CREDINALS");
			}
		}
		public static void encryptPassword(String passwordToBeEncrypt) {
			// TODO Auto-generated method stub
			Encoder s = Base64.getEncoder(); 									//declaring a method s for encoding purpose
			String encodedPassword = s.encodeToString(passwordToBeEncrypt.getBytes()); // password will convert into bytes 
																				//and then it will encoded to a new aString
			System.out.println("your Encoded Password is :"+encodedPassword);
			
		}
		public static void decryptPassword(String encodedPassword) {
			// TODO Auto-generated method stub
			Decoder s = Base64.getDecoder();				//declaring a method s for decoding purpose
			byte[] b = s.decode(encodedPassword);			//here the string will become bytes after decoding
			String S = new String(b);
				System.out.println("your Decode Password is :"+S);
			
		}
		public static boolean userExist() {
			// TODO Auto-generated method stub
			if(userPassword != null) {
				return true;
			}
			return false;
		}
}
