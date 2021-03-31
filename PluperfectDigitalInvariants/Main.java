// This program works with the help of brute force. 
// Will be refactored later.
public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 100000000; i++) {
            int sum = 0;
            int powNum = String.valueOf(i).length();
            for (int j = 0; j < String.valueOf(i).toCharArray().length; j++){
                sum += Math.pow(Character.getNumericValue(String.valueOf(i).toCharArray()[j]),powNum);
            }
            if (sum == i){
                System.out.println(i);
            }
        }
    }
}
