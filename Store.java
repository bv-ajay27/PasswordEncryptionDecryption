package PasswordEncryptionDecryption;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Store {
		// TODO Auto-generated method stub
	static Scanner sc = new Scanner(System.in);
	static HashMap<String, String> map = new HashMap<>();
	public void choose() {
		System.out.println("1.SAVE NEW CREDINALS");
		System.out.println("2.GET PASSWORD OF ACCOUNT");
		System.out.println("3.EXIT");
		int k = sc.nextInt();
		do {
		switch(k) 
        {
            case 1:
                storeFun();
                System.out.println("1.SAVE NEW CREDINALS");
                System.out.println("2.GET PASSWORD OF ACCOUNT");
                System.out.println("3.EXIT");
                k = sc.nextInt();
                break;
            case 2:
                getThePassCode();
                System.out.println("1.SAVE NEW CREDINALS");
                System.out.println("2.GET PASSWORD OF ACCOUNT");
                System.out.println("3.EXIT");
                k = sc.nextInt();
                break;
            }
		}
        while(k!=3);
	}
	static void getThePassCode() {
		// TODO Auto-generated method stub
		System.out.println("Enter the ACCOUNT NAME");
		String accountId = sc.next();
		if(map.containsKey(accountId)) {
			System.out.println(map.get(accountId));
		}
		else {
			System.out.println("GIVEN ACCOUNT NAME IS NOT EXISTED");
		}
		return;
	}
	public void storeFun() {
		// TODO Auto-generated method stub
		
		System.out.println("ENTER ACCOUNT NAME");
		String account = sc.next();
		System.out.println("1.CHOOSE OWN PASSWORD");
		System.out.println("2.GENERATE PASSWORD AUTOMATICALLY");
		String passCode = "";
		int userWish = sc.nextInt();
		if(userWish == 1) 
        {
			System.out.print("ENTER PASSWORD");
			passCode = sc.next();
		}
		else if(userWish == 2)
        {
			passCode = generatePassword();
			
		}
		storeTheCredinals(account,passCode);
		return;
		
	}
		static void storeTheCredinals(String account, String passCode) {
		
			map.put(account, passCode);
			System.out.println("Credinals saved Successfully");
			return;
		}
		
		public String generatePassword() {
			// TODO Auto-generated method stub
			System.out.println("ENTER THE REQUIRED PASSWORD LENGTH");
			int len = sc.nextInt();
			String capitalChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
			String smallChar = "abcdefghijklmnopqrstuvwxyz";
			String numbers = "0123456789";
			String Symbols = "!@#$%^&*<>?/+_-";
			String values = capitalChar+smallChar+numbers+Symbols;
			Random rndm = new Random();
			String password = "";
			for(int i=0;i<len;i++) {
				password += values.charAt(rndm.nextInt(values.length()));
				
			}
			return password;
        }
    }
