package com.example.demo_project;

import java.util.Scanner;

public class Calcurator {

	public static void main(String[] args) {

		int count = 0;
		for (;;) {
			if (count >= 3) {
				System.out.println("��J�W�L�T���T�T");
				break;
			}
			Scanner scanner = new Scanner(System.in);
			System.out.println("��J��ӼƦr (��2~20 add,minus,multi,division,mod)");
			String input = scanner.nextLine();
			String[] inputArr = input.split("\\s+");
			if (inputArr.length < 3) {
				System.out.println("�n�T�ӰѼ�");
				count++;
				continue;
			}
			for (int i = 0; i < inputArr.length; i++) {
				System.out.println(inputArr[i]);
			}
			System.out.println("�O�_���T?");
			input = scanner.nextLine();
			if (!input.equalsIgnoreCase("y")) {
				continue;
			}
			try {
				double num1 = Double.parseDouble(inputArr[1]);
				double num2 = Double.parseDouble(inputArr[2]);
				if ((num1 < 2.0 || num1 > 20.0) || (num2 < 2.0 || num2 > 20.0)) {
					System.out.println("�u���J�Ʀr2~20");
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
					System.out.println("�L�k���Ѧ欰,�u���J�Ʀr");
					count++;
					continue;
				}
			} catch (NumberFormatException e) {
				System.out.println("�L�k�ഫ,�u���J�Ʀr");
				count++;
				continue;
			}

		}
	}
}
