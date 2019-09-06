package com.algo.sort;

/**
 *  4.希尔排序的过程如下:
 * 
 * [ 13 14 94 33 82 25 59 94 65 23 45 27 73 25 39 10 ]
 * 
 * 	1 ,获取数组的长度，对半，获取增量
 *   13 14 94 33 82
 *   25 59 94 65 23 
 *   45 27 73 25 39 
 *   10
 *  2，将每一列进行排序 
 *   
 *   10 14 73 25 23
 *   13 27 94 33 39
 *   25 59 94 65 82
 *   45
 *   
 *  3，得到第2次排序的数组 
 *   10 14 73 25 23 13 27 94 33 39 25 59 94 65 82 45 
 *   
 *  4，增量减1,继续按照步骤的方式进行排序，得到排序的结果 
 *   10 14 73 25
 *   23 13 27 94
 *   33 39 25 59
 *   94 65 82 45
 *   
 *   10 13 25 25
 *   23 14 27 45
 *   33 39 73 59
 *   94 65 82 94
 *   
 *   10 13 25 25 23 14 27 45 33 39 73 59 94 65 82 94
 *   
 *   10 13 25
 *   25 23 14
 *   27 45 33
 *   39 73 59
 *   94 65 82
 *   94
 *   
 *   10 13 14
 *   25 23 25
 *   27 45 33
 *   39 73 59
 *   94 65 82
 *   94
 *   
 *   10 13 14 25 23 25 27 45 33 39 73 59 94 65 82 94
 *   
 *   排序后的结果：[1 1 2 3 4 5 5 6 9 23 23 32 32 34 34 65 65 76 76 78 78]
 * @author Administrator
 *
 */

public class ShellSort
{
	public static void main(String[] args)
	{
		int[] ins = {2,3,5,1,23,6,78,34,23,4,5,78,34,65,32,65,76,32,76,1,9};
		int[] ins2 = shellsort1(ins);
		for(int in: ins2){
			System.out.print (in+" ");
		}
	}

	public static int[] shellsort1(int[] arr){
		int n=arr.length;
		int gap = n/2;
		while(gap>0){
			for(int i=0;i<arr.length;i++){
				int j=i;
				while(j>=gap&&arr[j-gap]>arr[j] ){
					int temp=arr[j-gap];
					arr[j-gap]=arr[j];
					arr[j]=temp;
					j-=gap;
				}
			}
			gap=gap/2;
		}
		return arr;
	}
}

