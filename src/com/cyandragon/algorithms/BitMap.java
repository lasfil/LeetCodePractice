package com.cyandragon.algorithms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class BitMap {
	public static void main(String[] args) {
		int number = 10000000; // 待排序数的数量
		int len = (number - 1) / 32 + 1; // java中int占4字节,一位代表一个数,分配多少个int型变量
		int len1 = number / 32 + (number % 32 > 0 ? 1 : 0);
		int[] a = new int[len];
		int[] data = new int[number];
		// 产生随机输入数据,数据是乱序的
		int temp, temp1;
		Random rand = new Random();
		for (int i = 0; i < 10000000; i++) {
			data[i] = i;
			// 随机交换
			temp = rand.nextInt(i + 1);
			temp1 = data[temp];
			data[temp] = data[i];
			data[i] = temp1;
		}

		for (int i = 0; i < len; i++) {
			a[i] = 0;
		}

		for (int i = 0; i < number / 10; i++) {
			set(a, data[i]);
		}
		for (int i = 0; i < number / 10; i++) {
			if (read(a, i) == 1);
				//System.out.print(i + " ");
		}
	}// 将第i位置为1

	public static void set(int[] num, int i) {
		num[i >> 5] |= (1 << (i & 0x1F)); // i>>5指的是i/32,确定其在哪一个int中,i&0x1F则是i%32,确定其在int中的哪一位
	} // 将第i位置为0

	public static void clr(int[] num, int i) {
		num[i >> 5] &= ~(1 << (i & 0x1F));
	} // 读取第i位,判断是0/1

	public static int read(int[] num, int i) {
		System.out.println(Integer.toBinaryString(1 << (i & 0x1F)));
		System.out.println(Integer.toBinaryString(num[i >> 5]));
		return num[i >> 5] & (1 << (i & 0x1F));
	}
}

class Data {

	public static void generateData(int size) {
		Random rd = new Random();
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("qq.txt"));
			for (int i = 0; i < size; i++) {
				bw.write(Math.abs(rd.nextInt(size)) + "");
				bw.write("\n");
			}
			bw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
