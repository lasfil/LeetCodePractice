import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class WordLadder2 {
	public List<List<String>> findLadders(String start, String end,
			Set<String> dict) {
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
			String str = item.get(item.size() - 1);
			if (differ(str, end) == 1) {
				item.add(end);
				temp.add(item);
			} else {
				StringBuffer sb = new StringBuffer(str);
				for (int i = 0; i < sb.length(); i++) {
					for (int j = 0; j < 26; j++) {
						char c = sb.charAt(i);
						sb.setCharAt(i, (char) ('a' + j));
						if (dict.contains(sb.toString())
								&& !item.contains(sb.toString())) {
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

	}

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
		String start = "cet";
		String end = "ism";
		String[] s = new String[] { "kid", "tag", "pup", "ail", "tun", "woo",
				"erg", "luz", "brr", "gay", "sip", "kay", "per", "val", "mes",
				"ohs", "now", "boa", "cet", "pal", "bar", "die", "war", "hay",
				"eco", "pub", "lob", "rue", "fry", "lit", "rex", "jan", "cot",
				"bid", "ali", "pay", "col", "gum", "ger", "row", "won", "dan",
				"rum", "fad", "tut", "sag", "yip", "sui", "ark", "has", "zip",
				"fez", "own", "ump", "dis", "ads", "max", "jaw", "out", "btu",
				"ana", "gap", "cry", "led", "abe", "box", "ore", "pig", "fie",
				"toy", "fat", "cal", "lie", "noh", "sew", "ono", "tam", "flu",
				"mgm", "ply", "awe", "pry", "tit", "tie", "yet", "too", "tax",
				"jim", "san", "pan", "map", "ski", "ova", "wed", "non", "wac",
				"nut", "why", "bye", "lye", "oct", "old", "fin", "feb", "chi",
				"sap", "owl", "log", "tod", "dot", "bow", "fob", "for", "joe",
				"ivy", "fan", "age", "fax", "hip", "jib", "mel", "hus", "sob",
				"ifs", "tab", "ara", "dab", "jag", "jar", "arm", "lot", "tom",
				"sax", "tex", "yum", "pei", "wen", "wry", "ire", "irk", "far",
				"mew", "wit", "doe", "gas", "rte", "ian", "pot", "ask", "wag",
				"hag", "amy", "nag", "ron", "soy", "gin", "don", "tug", "fay",
				"vic", "boo", "nam", "ave", "buy", "sop", "but", "orb", "fen",
				"paw", "his", "sub", "bob", "yea", "oft", "inn", "rod", "yam",
				"pew", "web", "hod", "hun", "gyp", "wei", "wis", "rob", "gad",
				"pie", "mon", "dog", "bib", "rub", "ere", "dig", "era", "cat",
				"fox", "bee", "mod", "day", "apr", "vie", "nev", "jam", "pam",
				"new", "aye", "ani", "and", "ibm", "yap", "can", "pyx", "tar",
				"kin", "fog", "hum", "pip", "cup", "dye", "lyx", "jog", "nun",
				"par", "wan", "fey", "bus", "oak", "bad", "ats", "set", "qom",
				"vat", "eat", "pus", "rev", "axe", "ion", "six", "ila", "lao",
				"mom", "mas", "pro", "few", "opt", "poe", "art", "ash", "oar",
				"cap", "lop", "may", "shy", "rid", "bat", "sum", "rim", "fee",
				"bmw", "sky", "maj", "hue", "thy", "ava", "rap", "den", "fla",
				"auk", "cox", "ibo", "hey", "saw", "vim", "sec", "ltd", "you",
				"its", "tat", "dew", "eva", "tog", "ram", "let", "see", "zit",
				"maw", "nix", "ate", "gig", "rep", "owe", "ind", "hog", "eve",
				"sam", "zoo", "any", "dow", "cod", "bed", "vet", "ham", "sis",
				"hex", "via", "fir", "nod", "mao", "aug", "mum", "hoe", "bah",
				"hal", "keg", "hew", "zed", "tow", "gog", "ass", "dem", "who",
				"bet", "gos", "son", "ear", "spy", "kit", "boy", "due", "sen",
				"oaf", "mix", "hep", "fur", "ada", "bin", "nil", "mia", "ewe",
				"hit", "fix", "sad", "rib", "eye", "hop", "haw", "wax", "mid",
				"tad", "ken", "wad", "rye", "pap", "bog", "gut", "ito", "woe",
				"our", "ado", "sin", "mad", "ray", "hon", "roy", "dip", "hen",
				"iva", "lug", "asp", "hui", "yak", "bay", "poi", "yep", "bun",
				"try", "lad", "elm", "nat", "wyo", "gym", "dug", "toe", "dee",
				"wig", "sly", "rip", "geo", "cog", "pas", "zen", "odd", "nan",
				"lay", "pod", "fit", "hem", "joy", "bum", "rio", "yon", "dec",
				"leg", "put", "sue", "dim", "pet", "yaw", "nub", "bit", "bur",
				"sid", "sun", "oil", "red", "doc", "moe", "caw", "eel", "dix",
				"cub", "end", "gem", "off", "yew", "hug", "pop", "tub", "sgt",
				"lid", "pun", "ton", "sol", "din", "yup", "jab", "pea", "bug",
				"gag", "mil", "jig", "hub", "low", "did", "tin", "get", "gte",
				"sox", "lei", "mig", "fig", "lon", "use", "ban", "flo", "nov",
				"jut", "bag", "mir", "sty", "lap", "two", "ins", "con", "ant",
				"net", "tux", "ode", "stu", "mug", "cad", "nap", "gun", "fop",
				"tot", "sow", "sal", "sic", "ted", "wot", "del", "imp", "cob",
				"way", "ann", "tan", "mci", "job", "wet", "ism", "err", "him",
				"all", "pad", "hah", "hie", "aim", "ike", "jed", "ego", "mac",
				"baa", "min", "com", "ill", "was", "cab", "ago", "ina", "big",
				"ilk", "gal", "tap", "duh", "ola", "ran", "lab", "top", "gob",
				"hot", "ora", "tia", "kip", "han", "met", "hut", "she", "sac",
				"fed", "goo", "tee", "ell", "not", "act", "gil", "rut", "ala",
				"ape", "rig", "cid", "god", "duo", "lin", "aid", "gel", "awl",
				"lag", "elf", "liz", "ref", "aha", "fib", "oho", "tho", "her",
				"nor", "ace", "adz", "fun", "ned", "coo", "win", "tao", "coy",
				"van", "man", "pit", "guy", "foe", "hid", "mai", "sup", "jay",
				"hob", "mow", "jot", "are", "pol", "arc", "lax", "aft", "alb",
				"len", "air", "pug", "pox", "vow", "got", "meg", "zoe", "amp",
				"ale", "bud", "gee", "pin", "dun", "pat", "ten", "mob" };
		Set<String> d = new HashSet<String>();
		for (String str : s)
			d.add(str);
//		System.out.println(new WordLadder().ladderLength(start, end, d));
		 new WordLadder2().findLadders1(start, end, d);
//		new WordLadder2().findLadders(start, end, d);
		
	}
}
