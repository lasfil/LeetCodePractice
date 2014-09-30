
public class UniqueBST {

    public int numTrees(int n) {
        if (n <= 1)
            return 1;
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result += numTrees(i-1) * numTrees(n-i);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
    	System.out.println(new UniqueBST().numTrees(4));
    }
}