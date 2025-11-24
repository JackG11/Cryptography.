public class Vinegar{
    public static void main(String[] args){
        System.out.println(encode("sugoi", "CAT"));
        System.out.println(decode("uuzqi", "CAT"));
    }

    public static String encode(String plainText, String keyword) {
        String Vinegar = "";
        String ans = "";
        //write my plainText with keyword
        for(int i = 0; i < plainText.length(); i++){
            if(i > keyword.length() - 1){
                Vinegar += keyword.charAt(i%keyword.length());
            }else{
                Vinegar += keyword.charAt(i);
            }

        }
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //encrypt my keyword affect plainText into the cipher
        for (int j = 0; j < plainText.length(); j++) {
            char letter = Character.toUpperCase(plainText.charAt(j));
            char keyChar = Character.toUpperCase(Vinegar.charAt(j));

            //find the index of the letter in alpha
            int letterIndex = 0;
            for (int x = 0; x < alpha.length(); x++) {
                if (alpha.charAt(x) == letter) {
                    letterIndex = x;
                }
            }

            //find the index of the key character in alpha
            int keyIndex = 0;
            for (int x = 0; x < alpha.length(); x++) {
                if (alpha.charAt(x) == keyChar) {
                    keyIndex = x;
                }
            }

            //add its position in the alphabet to the key letters position, and wrap around if needed
            int newIndex = (letterIndex + keyIndex) % 26;

            //add the coded letter by using the index found to find character
            ans += alpha.charAt(newIndex);
        }
        return ans;
    }

    public static String decode(String cipherText, String keyword) {
        String Vinegar = "";
        String ans = "";
        //putting keyword to match the viginere code
        for(int i = 0; i < cipherText.length(); i++){
            if(i > keyword.length() - 1){
                Vinegar += keyword.charAt(i % keyword.length());
            } else {
                Vinegar += keyword.charAt(i);
            }
        }

        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for (int j = 0; j < cipherText.length(); j++) {
            char letter = Character.toUpperCase(cipherText.charAt(j));
            char keyChar = Character.toUpperCase(Vinegar.charAt(j));
            int letterIndex = 0;
            //index of the letter in alpha
            for (int i = 0; i < alpha.length(); i++) {
                if (alpha.charAt(i) == letter) {
                    letterIndex = i;
                }
            }
            
            //find the index of the key character in alpha
            int keyIndex = 0;
            for (int i = 0; i < alpha.length(); i++) {
                if (alpha.charAt(i) == keyChar) {
                    keyIndex = i;
                }
            }

            int newIndex = (letterIndex - keyIndex + 26) % 26;//find the letter coordinating with the index found and wraps around if reached to the end

            ans += alpha.charAt(newIndex);//add the character at the index to answer
        }

        return ans;
    }
}
