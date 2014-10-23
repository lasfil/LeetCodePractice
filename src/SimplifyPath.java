import java.util.Stack;

public class SimplifyPath {
	public String simplifyPath(String path) {
		if (path == null || path.length() < 2)
			return path;

		String[] folder = path.split("/");

		Stack<String> s = new Stack<String>();
		for (int i = 0; i < folder.length; i++) {
			if (folder[i].equals("..")) {
				if (!s.isEmpty())
					s.pop();
			} else if (!folder[i].equals(".") && !folder[i].equals("")) {
				s.push(folder[i]);
			}
		}
		if (s.isEmpty())
			return "/";
		StringBuffer sb = new StringBuffer();
		while (!s.isEmpty()) {
			String tmp = s.pop();

			sb.insert(0, tmp);
			sb.insert(0, "/");

		}

		return sb.toString();
	}

	public static void main(String[] args) {
		new SimplifyPath().simplifyPath("/..");
	}
}
