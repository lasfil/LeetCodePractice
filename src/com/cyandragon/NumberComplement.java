package com.cyandragon;

public class NumberComplement {
	public static int findComplement(int num)
	{
		int mask = 1;
		int temp = num;

		while (temp > 0)
		{
			System.out.println("mask: " + mask);
			mask = mask << 1;
			System.out.println("temp: " + temp);
			temp = temp >> 1;
			System.out.println("--------");

		}

		return mask - 1 - num;
	}

	public static int findComplement1(int num)
	{
		int mask = 1;
		int temp = num;

		while (mask > 0 && mask <= temp)
		{
			System.out.println("mask: " + mask);
			mask *= 2;
			System.out.println("temp: " + temp);
			//temp = temp >> 1;
			//System.out.println("--------");

		}

		return mask - 1 - num;
	}
	public static void main(String[] args)
	{
		System.out.println(findComplement(2147483647) - findComplement1(2147483647));
	}
}
