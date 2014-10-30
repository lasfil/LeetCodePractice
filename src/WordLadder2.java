import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class WordLadder2 {
	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        if (start == null || end == null || dict == null)
            return null;
        List<List<String>> result = new ArrayList<List<String>>();
        
        List<String> cur = new ArrayList<String>();
        cur.add(start);
        result.add(cur);
        dict.remove(start);
        dict.remove(end);
        wfs(dict, result, end);
        return result;
    }
    
    private void wfs(Set<String> dict, List<List<String>> result, String end) {
        
        List<List<String>> temp = new ArrayList<List<String>>();
        List<List<String>> temp1 = new ArrayList<List<String>>(result);
        result.clear();
		for (List<String> item : temp1) {
		    String str = item.get(item.size() -1);
			if (differ(str, end) == 1) {
				item.add(end);
				temp.add(item);
			} else {
    			StringBuffer sb = new StringBuffer(str);
    			for (int i = 0; i < sb.length(); i++) {
    				for (int j = 0; j < 26; j++) {
    					char c = sb.charAt(i);
    					sb.setCharAt(i, (char) ('a' + j));
    					if (dict.contains(sb.toString()) && !item.contains(sb.toString())) {
    					    List<String> newitem = new ArrayList<String>(item);
    						newitem.add(sb.toString());
    						result.add(newitem);
    					}
    					sb.setCharAt(i, c);
    				}
    			}
			}
		}
		if (temp.size() > 0) {
		    result.clear();
		    result.addAll(temp);
		    return;
		}
        if (result.size() == 0) {
            return;
        }
        
		wfs(dict, result, end);
        
    }/*
	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        if (start == null || end == null || dict == null)
            return null;
        List<List<String>> result = new ArrayList<List<String>>();
        
        List<String> cur = new ArrayList<String>();
        cur.add(start);
        
        wfs(dict, result, end, cur);
        return result;
    }
    
    private void wfs(Set<String> dict, List<List<String>> result, String end, List<String> cur) {
	    String str = cur.get(cur.size() -1);
		if (differ(str, end) == 1) {
		    List<String> item = new ArrayList<String>(cur);
			item.add(end);
			result.add(item);
		} else {
			StringBuffer sb = new StringBuffer(str);
			for (int i = 0; i < sb.length(); i++) {
				for (int j = 0; j < 26; j++) {
					char c = sb.charAt(i);
					sb.setCharAt(i, (char) ('a' + j));
					if (dict.contains(sb.toString()) && !cur.contains(sb.toString())) {
					    List<String> newitem = new ArrayList<String>(cur);
						newitem.add(sb.toString());
						wfs(dict, result, end, newitem);
					}
					sb.setCharAt(i, c);
				}
			}
		}
    }*/
	private int differ(String a, String b) {
		int count = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i))
				count++;
		}
		return count;
	}
	private void GeneratePath(Map<String, ArrayList<String>> prevMap,
			ArrayList<String> path, String word,
			ArrayList<ArrayList<String>> ret) {
		if (prevMap.get(word).size() == 0) {
			path.add(0, word);
			ArrayList<String> curPath = new ArrayList<String>(path);
			ret.add(curPath);
			path.remove(0);
			return;
		}

		path.add(0, word);
		for (String pt : prevMap.get(word)) {
			GeneratePath(prevMap, path, pt, ret);
		}
		path.remove(0);
	}

	public ArrayList<ArrayList<String>> findLadders1(String start, String end,
			Set<String> dict) {
		ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
		Map<String, ArrayList<String>> prevMap = new HashMap<String, ArrayList<String>>();
		dict.add(start);
		dict.add(end);
		for (String d : dict) {
			prevMap.put(d, new ArrayList<String>());
		}
		ArrayList<HashSet<String>> candidates = new ArrayList<HashSet<String>>();
		candidates.add(new HashSet<String>());
		candidates.add(new HashSet<String>());
		int current = 0;
		int previous = 1;
		candidates.get(current).add(start);
		while (true) {
			current = current == 0 ? 1 : 0;
			previous = previous == 0 ? 1 : 0;
			for (String d : candidates.get(previous)) {
				dict.remove(d);
			}
			candidates.get(current).clear();
			for (String wd : candidates.get(previous)) {
				for (int pos = 0; pos < wd.length(); ++pos) {
					StringBuffer word = new StringBuffer(wd);
					for (int i = 'a'; i <= 'z'; ++i) {
						if (wd.charAt(pos) == i) {
							continue;
						}

						word.setCharAt(pos, (char) i);

						if (dict.contains(word.toString())) {
							prevMap.get(word.toString()).add(wd);
							candidates.get(current).add(word.toString());
						}
					}
				}
			}

			if (candidates.get(current).size() == 0) {
				return ret;
			}
			if (candidates.get(current).contains(end)) {
				break;
			}
		}

		ArrayList<String> path = new ArrayList<String>();
		GeneratePath(prevMap, path, end, ret);

		return ret;
	}

	public static void main(String[] args) {
		String start = "qa";
		String end = "sq";
		String[] s = new String[]{"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};
		Set<String> d = new HashSet<String>();
		for (String str : s)
			d.add(str);
		new WordLadder2().findLadders(start, end, d);
	}
}
