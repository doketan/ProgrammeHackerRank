package com.company.Test;

import java.util.Scanner;

/**
 * Created by dokek on 11/4/15.
 */
public class ServiceLane {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int len = scan.nextInt();
        int test = scan.nextInt();

        int[] width = new int[len];
        int[][] segment = new int[test][2];

        for(int i=0;i<len;i++){
            width[i]=scan.nextInt();
        }

        for(int i=0;i<test;i++){
            segment[i][0]=scan.nextInt();
            segment[i][1]=scan.nextInt();
        }

        for(int i=0;i<test;i++){
            int min = segment[i][0];
            int max = segment[i][1];
            int minWidth = 10;
            for(int j=min;j<=max;j++){
                if(width[j]<minWidth){
                    minWidth=width[j];
                }
            }
            System.out.println(minWidth);
        }
    }
}
