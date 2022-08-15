package com.yojik.katas.sandboxes;

public class SandboxForHammingSlow {

    static long copyOfSample;
    static int indexOfHamming = 0;
    static long i = 1;


    public static void main(String[] args) {
        int n= 1000;


        while (indexOfHamming < n){
            if (isHamming(i)) {
                indexOfHamming++;
                System.out.println(i + " is hamming number with index " + indexOfHamming);

            }
            i++;
        }
    }



    private static boolean isHamming(long sampleNumber) {
        int pool = 0;
        copyOfSample = sampleNumber;
        pool += count(2L);
        pool += count(3L);
        pool += count(5L);

        if (copyOfSample == 1L) System.out.print(" for " + sampleNumber + " order is " + pool + "; ");

        return copyOfSample == 1L;
    }

    private  static int count(long divider){
        int thisPool = 0;
        while( (copyOfSample % divider) == 0) {
//            copyOfSample = Math.divideExact(copyOfSample, divider);
           copyOfSample /= divider;
//           if (indexOfHumming >= 1691) {System.out.print(copyOfSample + ", ");}
            thisPool++;
//            if ( (copyOfSample % divider) != 0 && indexOfHumming >= 1691) System.out.println();
            if (copyOfSample < 0) {
                System.out.println("checking number " + i + " and divide result " + copyOfSample);
                throw new IllegalArgumentException();
            }
        }

        //if (divider == 5) System.out.print("remainder: " + copyOfSample + " ");
        return thisPool;
    }

}
