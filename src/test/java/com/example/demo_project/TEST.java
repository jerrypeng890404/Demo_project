package com.example.demo_project;

import java.util.Scanner;

public class TEST {

	public static void main(String[] args) {
		Scanner scn=new Scanner (System.in);
		int n,i=1,sum=0;

		do{
			System.out.print("�п�J��");
			n=scn.nextInt();
		}while (n<1); //��J�ȭn���j��0�A�_�h�N�|�@���L�r��
		do
			sum+=i++; // �p��sum=sum+i, i�ȦA�[1
		while(i<=n);

		System.out.println("1+2+...+"+n+"="+sum);
	}
}
