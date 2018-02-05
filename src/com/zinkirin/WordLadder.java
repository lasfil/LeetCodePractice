package com.zinkirin;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	public int ladderLength(String start, String end, Set<String> dict) {
		if (start == null || end == null || dict == null || start.length() == 0
				|| end.length() == 0 || dict.size() == 0 || start.equals(end))
			return 0;

		List<String> cur = new ArrayList<String>();
		HashSet<String> visited = new HashSet<String>();
		cur.add(start);
		return bfs(dict, cur, 1, end, visited);
	}

	private int bfs(Set<String> dict, List<String> cur, int step, String end,
			HashSet<String> visited) {
		if (cur.size() == 0 || dict.size() == 0)
			return 0;
		List<String> next = new ArrayList<String>();

		for (String str : cur) {
			if (differ(str, end) == 1)
				return step + 1;
			StringBuffer sb = new StringBuffer(str);
			for (int i = 0; i < sb.length(); i++) {
				for (int j = 0; j < 26; j++) {
					char c = sb.charAt(i);
					sb.setCharAt(i, (char) ('a' + j));
					if (dict.contains(sb.toString())) {
						next.add(sb.toString());
						dict.remove(sb.toString());
					}
					sb.setCharAt(i, c);
				}
			}
		}

		return bfs(dict, next, step + 1, end, visited);
	}

	private int differ(String a, String b) {
		int count = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i))
				count++;
		}
		return count;
	}

	public int ladderLength1(String start, String end, Set<String> dict) {
		if (dict.size() == 0)
			return 0;
		int currentLevel = 1;
		int nextLevel = 0;
		int step = 1;
		boolean found = false;
		Queue<String> st = new LinkedList<String>();
		HashSet<String> visited = new HashSet<String>();
		st.add(start);
		while (!st.isEmpty()) {
			String s = st.remove();
			currentLevel--;
			if (differ(s, end) == 1) {
				found = true;
				step++;
				break;
			} else {
				int length = s.length();
				StringBuffer sb = new StringBuffer(s);
				for (int i = 0; i < length; i++) {
					for (int j = 0; j < 26; j++) {
						char c = sb.charAt(i);
						sb.setCharAt(i, (char) ('a' + j));
						if (dict.contains(sb.toString())
								&& !visited.contains(sb.toString())) {
							nextLevel++;
							st.add(sb.toString());
							visited.add(sb.toString());
						}
						sb.setCharAt(i, c);
					}
				}
			}
			if (currentLevel == 0) {
				currentLevel = nextLevel;
				nextLevel = 0;
				step++;
			}
		}
		return found ? step : 0;
	}

	public static void main(String[] args) {
		String start = "nape";
		String end = "mild";
		String[] s = new String[] { "slit", "bunk", "wars", "ping", "viva",
				"wynn", "wows", "irks", "gang", "pool", "mock", "fort", "heel",
				"send", "ship", "cols", "alec", "foal", "nabs", "gaze", "giza",
				"mays", "dogs", "karo", "cums", "jedi", "webb", "lend", "mire",
				"jose", "catt", "grow", "toss", "magi", "leis", "bead", "kara",
				"hoof", "than", "ires", "baas", "vein", "kari", "riga", "oars",
				"gags", "thug", "yawn", "wive", "view", "germ", "flab", "july",
				"tuck", "rory", "bean", "feed", "rhee", "jeez", "gobs", "lath",
				"desk", "yoko", "cute", "zeus", "thus", "dims", "link", "dirt",
				"mara", "disc", "limy", "lewd", "maud", "duly", "elsa", "hart",
				"rays", "rues", "camp", "lack", "okra", "tome", "math", "plug",
				"monk", "orly", "friz", "hogs", "yoda", "poop", "tick", "plod",
				"cloy", "pees", "imps", "lead", "pope", "mall", "frey", "been",
				"plea", "poll", "male", "teak", "soho", "glob", "bell", "mary",
				"hail", "scan", "yips", "like", "mull", "kory", "odor", "byte",
				"kaye", "word", "honk", "asks", "slid", "hopi", "toke", "gore",
				"flew", "tins", "mown", "oise", "hall", "vega", "sing", "fool",
				"boat", "bobs", "lain", "soft", "hard", "rots", "sees", "apex",
				"chan", "told", "woos", "unit", "scow", "gilt", "beef", "jars",
				"tyre", "imus", "neon", "soap", "dabs", "rein", "ovid", "hose",
				"husk", "loll", "asia", "cope", "tail", "hazy", "clad", "lash",
				"sags", "moll", "eddy", "fuel", "lift", "flog", "land", "sigh",
				"saks", "sail", "hook", "visa", "tier", "maws", "roeg", "gila",
				"eyes", "noah", "hypo", "tore", "eggs", "rove", "chap", "room",
				"wait", "lurk", "race", "host", "dada", "lola", "gabs", "sobs",
				"joel", "keck", "axed", "mead", "gust", "laid", "ends", "oort",
				"nose", "peer", "kept", "abet", "iran", "mick", "dead", "hags",
				"tens", "gown", "sick", "odis", "miro", "bill", "fawn", "sumo",
				"kilt", "huge", "ores", "oran", "flag", "tost", "seth", "sift",
				"poet", "reds", "pips", "cape", "togo", "wale", "limn", "toll",
				"ploy", "inns", "snag", "hoes", "jerk", "flux", "fido", "zane",
				"arab", "gamy", "raze", "lank", "hurt", "rail", "hind", "hoot",
				"dogy", "away", "pest", "hoed", "pose", "lose", "pole", "alva",
				"dino", "kind", "clan", "dips", "soup", "veto", "edna", "damp",
				"gush", "amen", "wits", "pubs", "fuzz", "cash", "pine", "trod",
				"gunk", "nude", "lost", "rite", "cory", "walt", "mica", "cart",
				"avow", "wind", "book", "leon", "life", "bang", "draw", "leek",
				"skis", "dram", "ripe", "mine", "urea", "tiff", "over", "gale",
				"weir", "defy", "norm", "tull", "whiz", "gill", "ward", "crag",
				"when", "mill", "firs", "sans", "flue", "reid", "ekes", "jain",
				"mutt", "hems", "laps", "piss", "pall", "rowe", "prey", "cull",
				"knew", "size", "wets", "hurl", "wont", "suva", "girt", "prys",
				"prow", "warn", "naps", "gong", "thru", "livy", "boar", "sade",
				"amok", "vice", "slat", "emir", "jade", "karl", "loyd", "cerf",
				"bess", "loss", "rums", "lats", "bode", "subs", "muss", "maim",
				"kits", "thin", "york", "punt", "gays", "alpo", "aids", "drag",
				"eras", "mats", "pyre", "clot", "step", "oath", "lout", "wary",
				"carp", "hums", "tang", "pout", "whip", "fled", "omar", "such",
				"kano", "jake", "stan", "loop", "fuss", "mini", "byrd", "exit",
				"fizz", "lire", "emil", "prop", "noes", "awed", "gift", "soli",
				"sale", "gage", "orin", "slur", "limp", "saar", "arks", "mast",
				"gnat", "port", "into", "geed", "pave", "awls", "cent", "cunt",
				"full", "dint", "hank", "mate", "coin", "tars", "scud", "veer",
				"coax", "bops", "uris", "loom", "shod", "crib", "lids", "drys",
				"fish", "edit", "dick", "erna", "else", "hahs", "alga", "moho",
				"wire", "fora", "tums", "ruth", "bets", "duns", "mold", "mush",
				"swop", "ruby", "bolt", "nave", "kite", "ahem", "brad", "tern",
				"nips", "whew", "bait", "ooze", "gino", "yuck", "drum", "shoe",
				"lobe", "dusk", "cult", "paws", "anew", "dado", "nook", "half",
				"lams", "rich", "cato", "java", "kemp", "vain", "fees", "sham",
				"auks", "gish", "fire", "elam", "salt", "sour", "loth", "whit",
				"yogi", "shes", "scam", "yous", "lucy", "inez", "geld", "whig",
				"thee", "kelp", "loaf", "harm", "tomb", "ever", "airs", "page",
				"laud", "stun", "paid", "goop", "cobs", "judy", "grab", "doha",
				"crew", "item", "fogs", "tong", "blip", "vest", "bran", "wend",
				"bawl", "feel", "jets", "mixt", "tell", "dire", "devi", "milo",
				"deng", "yews", "weak", "mark", "doug", "fare", "rigs", "poke",
				"hies", "sian", "suez", "quip", "kens", "lass", "zips", "elva",
				"brat", "cosy", "teri", "hull", "spun", "russ", "pupa", "weed",
				"pulp", "main", "grim", "hone", "cord", "barf", "olav", "gaps",
				"rote", "wilt", "lars", "roll", "balm", "jana", "give", "eire",
				"faun", "suck", "kegs", "nita", "weer", "tush", "spry", "loge",
				"nays", "heir", "dope", "roar", "peep", "nags", "ates", "bane",
				"seas", "sign", "fred", "they", "lien" };

		Set<String> d = new HashSet<String>();
		for (String str : s)
			d.add(str);
		System.out.println(Calendar.getInstance().getTimeInMillis());
		System.out.println(new WordLadder().ladderLength1(start, end, d));
		System.out.println(Calendar.getInstance().getTimeInMillis());
		System.out.println(new WordLadder().ladderLength(start, end, d));
		System.out.println(Calendar.getInstance().getTimeInMillis());
	}
}
