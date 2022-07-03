package passwordEncoding_JAVA_Project;
import java.util.Scanner;

public class mainPage {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("WELCOME TO PASSWORD MANAGEMENT SYSTEM");
		goToInstructions();     
    }
    static void goToInstructions() {
        Store st = new Store();
// 	USER user = new USER();
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("Enter any number to continue");
        int k = sc.nextInt();
        
        do{
            System.out.println("1.Create an Account");
            System.out.println("2.login Account");
            System.out.println("3.Encrypt your password");
            System.out.println("4.Decrypt your password");
            System.out.println("5.Reset your password");
            System.out.println("0.Exit");
            k = sc.nextInt();
            switch(k) 
            {
                case 1:
                    if(USER.userExist() == true) {
                        System.out.println("User already exist");
                        break;
                    }
                    System.out.println("Enter Numerical UserID");
                    int id = sc.nextInt();
                    System.out.println("1.CHOOSE OWN PASSWORD");
                    System.out.println("2.GENERATE PASSWORD AUTOMATICALLY");
                    String password;
                    int wish = sc.nextInt();
                    if(wish == 1) {
                        System.out.println("ENTER PASSWORD");
                        password = sc.next();
                    }
                    else if(wish == 2){
                        password = st.generatePassword();
                        System.out.println(password);
                    }
                    else {
                        System.out.println("Invalid Input :(");
                        break;
                    }
                    USER.addUSER(id,password);
                    break;
                case 2:
                    if(USER.userExist()==false) {
                        System.out.println("ACCOUNT NOT CREATED YET");
                        break;
                    }
                    System.out.println("ENTER YOUR PASSWORD");
                    String inputPassword = sc.next();
                    if(USER.access(inputPassword) == true) {
                        st.choose();
                    }
                    else {
                        System.out.println("PASSWORD IS INCORRECT");
                    }
                    break;
                case 3:
                    System.out.println("Enter the passwrd to encode");
                    String passwordToBeEncrypt = sc.next();
                    USER.encryptPassword(passwordToBeEncrypt);
                    break;
                case 4:
                    System.out.println("Enter the encodedpasswrd to decode");
                    String encodedPassword = sc.next();
                    USER.decryptPassword(encodedPassword);
                    break;
                case 5:
                    if(USER.userExist()==false) {
                        System.out.println("NO ACCOUNT CREATED YET");
                        break;
                    }
                    System.out.println("Enter your prevPassword");
                    String prevPassword = sc.next();
                    System.out.println("Enter your newPassword");
                    String newPassword = sc.next();
                    USER.setPassword(prevPassword, newPassword);
                    break;
                case 0:
                    break;
            }
        }while(k != 0);
    }
}
