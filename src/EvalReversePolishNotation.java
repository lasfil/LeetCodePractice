import java.util.Stack;

public class EvalReversePolishNotation {
	private String[] tokens;

	public void setTokens(String[] tokens) {
		this.tokens = tokens;
	}

	public int evalRPN() {
		Stack<Integer> stack = new Stack<Integer>();

		for (String s : tokens) {
			if (s.matches("[-]?\\d+")) {
				stack.push(Integer.valueOf(s));
			} else {
				int num2 = stack.pop();
				int num1 = stack.pop();
				stack.push(calculator(num1, num2, s));
			}
		}

		return stack.pop();
	}

	public int calculator(int num1, int num2, String operator) {
		switch (operator) {
		case "+":
			return num1 + num2;
		case "-":
			return num1 - num2;
		case "*":
			return num1 * num2;
		case "/":
			if(num2 ==0)
				return 0;
			else
				return num1 / num2;
		default :
			return 0;
		}
	}
	
	public static void main(String[] args) {
		EvalReversePolishNotation eval = new EvalReversePolishNotation();
		String[] tokens = new String[]{"3","-4","+"};
		eval.setTokens(tokens);
		
		System.out.println(eval.evalRPN());
	}
}
