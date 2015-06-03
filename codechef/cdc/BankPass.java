package cdc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BankPass {

	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// int t = Integer.parseInt(br.readLine());
		int t = 1;
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			String[] arr = new String[n];
			Trie trie = new Trie();
			boolean ok = true;
			for (int i = 0; i < n; i++) {
				arr[i] = br.readLine();
			}
			Arrays.sort(arr, new StringLengthComparator());
			for (int i = 0; i < n; i++) {
				if (trie.isWordPresent(arr[i])) {
					ok = false;
					break;
				}
				trie.addWord(arr[i]);
			}
			if (ok)
				sb.append("non vulnerable\n");
			else
				sb.append("vulnerable\n");
		}
		System.out.print(sb.toString());
	}

	public static class StringLengthComparator implements Comparator<String> {
		public int compare(String o1, String o2) {
			return o2.length() - o1.length();
		}
	}

	public static void main(String[] args) throws Exception {
		solve();
	}

}

class Trie {

	TrieNode root;

	Trie() {
		root = new TrieNode('$');
	}

	public void addWord(String word) {
		int len = word.length();
		TrieNode temp = root;
		int next = word.charAt(0) - 'a';
		int i = 1;
		while (i < len && temp.children[next] != null) {
			temp = temp.children[next];
			next = word.charAt(i) - 'a';
			//System.out.println(String.format("%d found", next));
			i++;
		}
		while (i < len) {
			temp.children[next] = new TrieNode(word.charAt(i));
			//System.out.println(String.format("added %d", next));
			temp = temp.children[next];
			next = word.charAt(i) - 'a';
			i++;
		}
	}

	public boolean isWordPresent(String word) {
		int len = word.length();
		TrieNode temp = root;
		int next = word.charAt(0) - 'a';
		int i = 1;
		while (i < len && temp.children[next] != null) {
			temp = temp.children[next];
			next = word.charAt(i) - 'a';
			i++;
		}
		if (i < len)
			return false;
		return true;
	}

	static class TrieNode {
		char c;
		TrieNode[] children;

		TrieNode(char c) {
			this.c = c;
			this.children = new TrieNode[26];
		}
	}
}