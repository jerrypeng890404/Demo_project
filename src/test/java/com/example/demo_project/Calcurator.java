package com.example.demo_project;

import java.util.Scanner;

public class Calcurator {

	public static void main(String[] args) {

		int count = 0;
		for (;;) {
			if (count >= 3) {
				System.out.println("輸入超過三次掰掰");
				break;
			}
			Scanner scanner = new Scanner(System.in);
			System.out.println("輸入兩個數字 (限2~20 add,minus,multi,division,mod)");
			String input = scanner.nextLine();
			String[] inputArr = input.split("\\s+");
			if (inputArr.length < 3) {
				System.out.println("要三個參數");
				count++;
				continue;
			}
			for (int i = 0; i < inputArr.length; i++) {
				System.out.println(inputArr[i]);
			}
			System.out.println("是否正確?");
			input = scanner.nextLine();
			if (!input.equalsIgnoreCase("y")) {
				continue;
			}
			try {
				double num1 = Double.parseDouble(inputArr[1]);
				double num2 = Double.parseDouble(inputArr[2]);
				if ((num1 < 2.0 || num1 > 20.0) || (num2 < 2.0 || num2 > 20.0)) {
					System.out.println("只能輸入數字2~20");
					count++;
					continue;
				}
				if (inputArr[0].equalsIgnoreCase("add")) {
					System.out.println(num1 + "+" + num2 + "=" + (num1 + num2));
				} else if (inputArr[0].equalsIgnoreCase("minus")) {
					System.out.println(num1 + "-" + num2 + "=" + (num1 - num2));
				} else if (inputArr[0].equalsIgnoreCase("multi")) {
					System.out.println(num1 + "*" + num2 + "=" + (num1 * num2));
				} else if (inputArr[0].equalsIgnoreCase("division")) {
					System.out.println(num1 + "/" + num2 + "=" + (num1 / num2));
				} else if (inputArr[0].equalsIgnoreCase("mod")) {
					System.out.println(num1 + "%" + num2 + "=" + (num1 % num2));
				} else {
					System.out.println("無法辨識行為,只能輸入數字");
					count++;
					continue;
				}
			} catch (NumberFormatException e) {
				System.out.println("無法轉換,只能輸入數字");
				count++;
				continue;
			}

		}
	}
}
