class Main{
    public static void main(String[] args) {

        for (int i=0;i<=999999999;i++){
            String toString = String.format("%s",i);
            int total=0;
            for(int j=0;j<toString.length();j++){
                int pow = Character.getNumericValue(toString.charAt(toString.length()-j-1));
                int num = Character.getNumericValue(toString.charAt(j));
                total += Math.pow(num,pow);
            }
            if(total == i){
                System.out.println(i);
            }
        }
    }
}

/*
* The powers are the same as the digits, but in reverse order:
*
* 48625 = 4⁵ + 8² + 6⁶ +2⁸ + 5⁴
*
*/
