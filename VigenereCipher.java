public class VigenereCipher implements Cipher {
	private String key;
	
    public VigenereCipher(String key) {
		this.key = key;
    }
    
    public String encrypt(String plainText) {
    
    	int[] intText = new int[plainText.length()];
    	int[] intKey = new int[this.key.length()];
    	int[] encrypted_intText = new int [plainText.length()];
    	
    	intText = stringToIntArray(plainText);
		//dumpArray(intText, "Plaintext converted to integer: ");
		System.out.println("");

    	intKey = stringToIntArray(key);
    	
    	int i;
    	
		for(i = 0; i < plainText.length(); i++) {
			encrypted_intText[i] =(intKey[i%intKey.length] + intText[i])%26;
		}
		//dumpArray(encrypted_intText, "Encrypted integer text: ");
		System.out.println("");


			
		
		return intArrayToString(encrypted_intText);
    }

    
    public String decrypt(String cipherText) {
    	
    	int[] intText = new int[cipherText.length()];
    	int[] intKey = new int[this.key.length()];
    	int[] decrypted_intText = new int [cipherText.length()];
    	
    	intText = stringToIntArray(cipherText);
    	intKey = stringToIntArray(key);
    	
    	int i;
    	
		for(i = 0; i < cipherText.length(); i++) {
			decrypted_intText[i] =(intText[i]- intKey[i%intKey.length])%26;
				
		}
		
			
		
		return intArrayToString(decrypted_intText);    
		}

   
    public void setKey(String key) {
    }
	
	private void dumpArray(int[] array, String text){
		System.out.print(text + " ");
		int j;
		for(j = 0; j < array.length; j++) {
			System.out.print(array[j]);
		}
	}

	private int[] stringToIntArray(String text) {
		int[] intArray = new int[text.length()];
		int j;
		
		for(j = 0; j < text.length(); j++) {
			intArray[j] = text.charAt(j) - 97;
		}
		return intArray;
	}
	
	private String intArrayToString(int [] encodedText) {
		int j;
		char[] charEncodedText = new char[encodedText.length];
		
		for(j = 0; j < encodedText.length; j++) {
			
			charEncodedText[j] = (char)(encodedText[j] + 97);
			
		}
		String stringEncodedText = new String(charEncodedText);

		return stringEncodedText;
	}
	
}