
public class Caesar{
    public static void main(String[] args){
        System.out.println(encodeCaesor("zygOi", 4));
        System.out.println(decodeCaesor("dckSm", 4));
    }

    public static String encodeCaesor(String plainText, int key){
        String ans = "";
        for(int i = 0; i < plainText.length(); i++){
            char letter = plainText.charAt(i);
            if(Character.isUpperCase(letter)){
                int n = letter - 65; //sets the letter index to 0
                n = (n + key)%26; //makes sure that the new letter is within 26
                n += 65; //sets the letter back to the list index
                char newLetter = (char)n; //sets n to a char
                ans +=  newLetter;
            }else if (Character.isLowerCase(letter)){
               int j = letter - 97;
                j = (j + key)%26;
                j += 97;
                char newLetter = (char)j;
                ans +=  newLetter; 
            }else{
                ans+= letter; //if its not a uppercase letter or a lowercase letter it will print normally
            }
            
        }
        return ans;
    }
    
    public static String decodeCaesor(String cipherText, int key){
        String ans = "";
        for(int i = 0; i < cipherText.length(); i++){
            char letter = cipherText.charAt(i);
            if(Character.isUpperCase(letter)){
                int n = letter - 65;
                n = (n - key + 26 )%26; //26 added here in order to get it to wrap before checking if its within 26 due to the risk of it going out of bounds in the next step.
                n += 65;
                char newLetter = (char)n;
                ans +=  newLetter;
            }else if (Character.isLowerCase(letter)){
               int j = letter - 97;
                j = (j - key + 26)%26;
                j += 97;
                char newLetter = (char)j;
                ans +=  newLetter; 
            }else{
                ans+= letter;
            }
            
        }
        return ans;
    }
}