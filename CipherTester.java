import java.util.Scanner;

public class CipherTester {

public static void main(String []args) {
	
	
	System.out.println("What is the key?");
	Scanner console = new Scanner(System.in);
	String key = console.nextLine();
	System.out.println("What is the plaintext?");
	String text = console.nextLine();
	Cipher newCipher = new VigenereCipher(key);

	String encrypted = newCipher.encrypt(text);
	String decrypted = newCipher.decrypt(encrypted);

	
	System.out.println("Encrypted: " + encrypted);
	System.out.println("Decrypted: " + decrypted);
	System.out.println("Key: " + key);
	
	console.close();
			
}

}
