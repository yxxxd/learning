package com.yxd.leetcode.nb;

/**
 * @author yuxudong
 * @date 2019/10/28 13:52
 */
public class HexToString {
    public String hexToAscii(String hex){
        StringBuilder sb = new StringBuilder();

        //49204c6f7665204a617661 split into two characters 49, 20, 4c...
        for( int i=0; i<hex.length()-1; i+=2 ) {

            //grab the hex in pairs
            String output = hex.substring(i, (i + 2));
            //convert hex to decimal
            int decimal = Integer.parseInt(output, 16);
            //convert the decimal to character
            sb.append((char) decimal);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String hex = "49204c6f7665204a617661";
        System.out.println(new HexToString().hexToAscii(hex));
    }
}
