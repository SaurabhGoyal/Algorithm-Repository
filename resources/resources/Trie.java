package resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Trie {
	public TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public void addWord(String word) {
		int len = word.length();
		TrieNode temp = getMaxMatch(word);
		if (temp.depth < len)
			temp.addWord(word, temp.depth);
		else
			temp.isWordEnd = true;
	}

	public TrieNode getMaxMatch(String word) {
		TrieNode temp = root, child = null;
		int len = word.length(), i = 0;
		if (len == 0)
			return root;
		while (true) {
			if (i >= len)
				break;
			child = temp.children.get(word.charAt(i) - 'a');
			if (child == null)
				break;
			temp = child;
			i++;
		}
		return temp;
	}

	public List<String> matchesWithExactPrefix(String prefix) {
		List<String> list = new ArrayList<String>();
		TrieNode temp = getMaxMatch(prefix);
		if (temp.depth == prefix.length()) {
			wordsFromNode(temp,
					new StringBuilder(prefix.substring(0, temp.depth - 1)),
					list);
		}
		return list;
	}

	public List<String> matchesWithWord(String word) {
		List<String> list = new ArrayList<String>();
		TrieNode temp = getMaxMatch(word);
		if(temp==root) return null;
		wordsFromNode(temp,
				new StringBuilder(word.substring(0, temp.depth - 1)), list);
		return list;
	}

	public void wordsFromNode(TrieNode node, StringBuilder prev,
			List<String> list) {
		StringBuilder sb = new StringBuilder();
		sb.append(prev);
		if (node.c != 0)
			sb.append((char) (node.c + 'a'));
		if (node.isWordEnd) {
			list.add(sb.toString());
			// System.out.println(String.format("reached end : %s",sb));
			if (node.isLeaf)
				return;
		}
		for (int i = 0; i < 26; i++) {
			TrieNode child = node.children.get(i);
			if (child != null) {
				wordsFromNode(child, sb, list);
			}
		}
		return;
	}

	public class TrieNode {
		private int c;
		private HashMap<Integer, TrieNode> children;
		private int depth;
		private boolean isLeaf = false;
		private boolean isWordEnd = false;

		public TrieNode() {
			super();
			this.c = 0;
			this.depth = 0;
			this.children = new HashMap<Integer, TrieNode>();
		}

		public TrieNode(int c, int depth, boolean isLeaf, boolean isWordEnd) {
			super();
			this.c = c;
			this.depth = depth;
			this.isLeaf = isLeaf;
			this.isWordEnd = isWordEnd;
			this.children = new HashMap<Integer, TrieNode>();
		}

		private void addWord(String word, int from) {
			int len = word.length();
			len = len - from;
			int c = word.charAt(from) - 'a';
			TrieNode child = new TrieNode(c, depth + 1, false, false);
			if (len == 1)
				child.isLeaf = child.isWordEnd = true;
			// System.out.println(String.format("adding node: %s",child));
			if (len > 1)
				child.addWord(word, from + 1);
			this.children.put(c, child);
		}
	}
}

class Test {
	public static void main(String[] args) throws Exception {
		Trie trie = new Trie();
		String[] words = { "husk", "hi", "hello", "hell" };
		for (String word : words)
			trie.addWord(word);
		String match = "h";
		List<String> matches = trie.matchesWithExactPrefix(match);
		for (String str : matches) {
			System.out.println(str);
		}
		matches = trie.matchesWithWord(match);
		for (String str : matches) {
			System.out.println(str);
		}
	}
}