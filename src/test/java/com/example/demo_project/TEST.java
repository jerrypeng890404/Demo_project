package com.example.demo_project;

import java.util.Scanner;

public class TEST {

	public static void main(String[] args) {
		Scanner scn=new Scanner (System.in);
		int n,i=1,sum=0;

		do{
			System.out.print("請輸入值");
			n=scn.nextInt();
		}while (n<1); //輸入值要為大於0，否則將會一直印字串
		do
			sum+=i++; // 計算sum=sum+i, i值再加1
		while(i<=n);

		System.out.println("1+2+...+"+n+"="+sum);
	}
}
