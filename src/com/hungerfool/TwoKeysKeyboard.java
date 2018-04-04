package com.hungerfool;

public class TwoKeysKeyboard {
	public static void minSteps() {
		minSteps(536);
	}
	public static int minSteps(int n) {
        int step = 0;
        int buf  = 0; // number of A's copied
        int num  = 1; // number of A's on the notepad

        while (num < n) {
            if (n % num == 0) {
                buf = num;
                step++; // copy
            }
            num += buf;
            step++; // paste
        }
        return step;
    }
}
