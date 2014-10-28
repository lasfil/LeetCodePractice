import java.util.Arrays;

public class ThreeSumClosest {
	public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int closest = twoSumClosest(num, target, 0);
        
        for(int i = 1; i < num.length - 2; i++) {
            if (num[i] != num[i - 1]) {
                int tmp = twoSumClosest(num, target, i);
                if (tmp == target)
                    return target;
                if (Math.abs(target - tmp) < Math.abs(target - closest))
                closest = tmp;
            }
        }
        
        return closest;
    }
    
    private int twoSumClosest(int[]num, int target, int index) {
        int i = index + 1;
        int j = num.length - 1;
        int closest = num[index] + num[i] + num[j];
        while(i < j) {
            int sum = num[index] + num[i] + num[j];
            if (sum == target) {
                return target;
            }
            if (Math.abs(target - sum) < Math.abs(target - closest))
                closest = sum;
            
            if (target < sum) {
                int k = j;
                while (k > i && num[k] == num[j])
                    k--;
                j = k;
            } else {
                int k = i;
                while (k < j && num[k] == num[i])
                    k++;
                i = k;
            } 
        }
        return closest;
    }

	public static void main(String[] args) {
		int[] num = new int[] { 0, 2, 1, -3 };
		System.out.println(new ThreeSumClosest().threeSumClosest(num, 1));
	}
}
