package com.company.Test;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by dokek on 2/10/16.
 */
public class JourneyToMoon {

    public static int baseArr[];
    public static int baseSize[];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int lines = scanner.nextInt();
        int[][] arr = new int[lines][2];
        for(int i=0;i<lines;i++){
            int t =scanner.nextInt();
            arr[i][0]=t;
            int y =scanner.nextInt();
            arr[i][1]=y;
        }
        baseArr = new int[n];
        baseSize = new int[n];
        for(int i=0;i<n;i++){
            baseArr[i]=i;
            baseSize[i]=1;
        }
        /*for(int i=0;i<baseArr.length;i++)
            System.out.print(baseArr[i]+" ");
        System.out.println(" ");*/
        long t = quickFindAlgo(arr,baseArr,lines,n);
        System.out.println(t);
    }

    private static long quickFindAlgo(int[][] arr, int[] baseArr, int lines, int n) {
        for(int i=0;i<arr.length;i++){
            quickunion(arr[i][0],arr[i][1]);
        }

        Map<Integer,Integer> countBase = new HashMap<>();

        for(int i=0;i<baseArr.length;i++){
            int k = baseArr[i];
            int v = 1;
            if(countBase.containsKey(k)){
                countBase.put(k,countBase.get(k)+1);
            }else {
                countBase.put(k, v);
            }
        }
        //System.out.println("map size :"+countBase.size());

        for(Map.Entry<Integer,Integer> map:countBase.entrySet()){
            int k = map.getKey();
            int v = map.getValue();

        }

        List<Integer> flist = new ArrayList<Integer>(countBase.values());
        /*for (int i=0;i<flist.size();i++){
            System.out.print(" "+flist.get(i));
        }*/
        long combi =0;
        for(int i=0;i<flist.size();i++){
            int e1 = flist.get(i);
            for(int j=i+1;j<flist.size();j++){
                int e2 = flist.get(j);
                combi = combi+(e1*e2);
            }
        }

        return combi;
    }

    private static void quickunion(int p, int q) {
       // System.out.println("basearr leng :"+baseArr.length);
        int pid = baseArr[p];
        int qid = baseArr[q];
        for(int i=0;i<baseArr.length;i++){
            if(baseArr[i]==pid){
                baseArr[i]=qid;
               // baseSize[qid]=baseSize[qid]+1;
            }
        }
    /*    for(int i=0;i<baseArr.length;i++)
            System.out.print(baseArr[i]+" ");

        for(int i=0;i<baseSize.length;i++)
            System.out.print("baseSIze :"+baseSize[i]+" ");*/

    }


}
