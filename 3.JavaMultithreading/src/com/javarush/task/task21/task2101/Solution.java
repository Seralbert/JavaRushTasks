package com.javarush.task.task21.task2101;

/* 
Определяем адрес сети
*/
public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte[] bytes = new byte[]{(byte)(ip[0] & mask[0]),(byte)(ip[1] & mask[1]),(byte)(ip[2] & mask[2]),(byte)(ip[3] & mask[3])};
        return bytes;
    }

    public static void print(byte[] bytes) {
        String i0 = String.format("%8s",Integer.toBinaryString(bytes[0] & 0xff)).replace(' ', '0');
        String i1 = String.format("%8s",Integer.toBinaryString(bytes[1] & 0xff)).replace(' ', '0');
        String i2 = String.format("%8s",Integer.toBinaryString(bytes[2] & 0xff)).replace(' ', '0');
        String i3 = String.format("%8s",Integer.toBinaryString(bytes[3] & 0xff)).replace(' ', '0');
        System.out.println(i0 + " " + i1 + " " + i2 + " " + i3);
        //System.out.println(Integer.parseInt(i,2));
    }

}
