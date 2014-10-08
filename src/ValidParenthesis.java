/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
import java.util.Stack;
public class ValidParenthesis {
	 public boolean isValid(String s) {
	        int len = s.length();
	        if (len == 0)
	            return true;
	        if (len % 2 == 1)
	            return false;
	       Stack<Character> stack= new Stack<Character>();
	        
	        for (int i = 0; i < len; i++) {
	            char c = s.charAt(i);
	            switch (c) {
	                case '(' :
	                    stack.push(c);
	                    break;
	                case ')' :
	                    if (stack.isEmpty() || stack.pop() != '(')
	                        return false;
	                    break;
	                case '[' :
	                   stack.push(c);
	                    break;
	                case ']' :
	                    if (stack.isEmpty() || stack.pop() != '[')
	                        return false;
	                    break;
	                case '{' :
	                    stack.push(c);
	                    break;
	                case '}' :
	                   if (stack.isEmpty() || stack.pop() != '{')
	                        return false;
	                    break;
	                default :
	                    return false;
	            }
	           
	        }
	        
	        return stack.isEmpty();
	    }
}
