package resources;
class TrieNode {
	char value;
	TrieNode links[];
	boolean isFullWord;

	TrieNode(char value) {
		this.value = value;
		links = new TrieNode[26];
		isFullWord = false;
	}

	public int addString(String str) {
		if (str.isEmpty() || !str.matches("[a-z]*"))
			return 0;
		str = str.toLowerCase();
		TrieNode temp = this;
		for (int i = 0; i < str.length(); i++) {
			int childindex = str.charAt(i) - 'a';
			while (temp.links[childindex] != null) {
				temp = temp.links[childindex];
				childindex = str.charAt(++i) - 'a';
			}
			char value = (char) (childindex + 'a');
			temp.links[childindex] = new TrieNode(value);
			if (i == str.length() - 1)
				temp.links[childindex].isFullWord = true;
			temp = temp.links[childindex];
		}
		return 1;
	}

	public String[] findMatch(String str) {
		if (str.isEmpty() || !str.matches("[a-z]*"))
			return null;
		TrieNode temp = this, tempParent = null;
		StringBuilder matchedPart = new StringBuilder("");
		StringBuilder matches = new StringBuilder("");
		boolean broke = false;
		for (int i = 0; i < str.length(); i++) {
			int childindex = str.charAt(i) - 'a';
			tempParent = temp;
			temp = temp.links[childindex];
			if (temp == null) {
				broke = true;
				break;
			}
			matchedPart.append(temp.value);
		}
		if (matchedPart.length() > 0)
			matchedPart.replace(matchedPart.length() - 1, matchedPart.length(),
					"");
		if (broke)
			getMatchesFrom(tempParent, matchedPart.toString(), matches);
		else
			getMatchesFrom(temp, matchedPart.toString(), matches);
		return matches.toString().split("\n");
	}

	private void getMatchesFrom(TrieNode node, String parent,
			StringBuilder matches) {
		if (node == null)
			return;
		parent += node.value;
		if (node.isFullWord)
			matches.append(parent + "\n");
		for (int i = 0; i < 26; i++)
			getMatchesFrom(node.links[i], parent, matches);
	}
}
