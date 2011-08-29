package org.codeexample.autocomplete;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
public class WordTree {
	private WordNode root;
	public WordTree() {
		root = new WordNode(null);
	}
	/**
	 * Add a string into this word tree, if word is null or an empty string, do
	 * nothing
	 */
	public void addWord(String word) {
		if (word == null)
			return;
		word = word.trim();
		if ("".equals(word)) {
			return;
		}
		WordNode parentNode = root, curretNode;
		for (int i = 0; i < word.length(); i++) {
			char character = word.charAt(i);
			Map<Character, WordNode> children = parentNode
					.getChildrenMap();
			if (children.containsKey(character)) {
				curretNode = children.get(character);
			} else {
				curretNode = new WordNode(character);
				parentNode.addChild(curretNode);
			}
			parentNode = curretNode;
		}
		// at last, add a leaf node - whose character value is null to indicate
		// the end of the word
		curretNode = new WordNode(null);
		parentNode.addChild(curretNode);
	}
	/**
	 * @param prefix
	 * @return all words in this tree that starts with the prefix, <br>
	 *         if prefix is null, return an empty list, if prefix is empty
	 *         string, return all words in this word tree.
	 */
	public List<String> wordsPrefixWith(String prefix) {
		List<String> words = new ArrayList<String>();
		if (prefix == null)
			return words;
		prefix = prefix.trim();
		WordNode currentNode = root;
		for (int i = 0; i < prefix.length(); i++) {
			char character = prefix.charAt(i);
			Map<Character, WordNode> children = currentNode
					.getChildrenMap();
			if (!children.containsKey(character)) {
				return words;
			}
			currentNode = children.get(character);
		}
		return currentNode.subWords();
	}
	/**
	 * @param word
	 * @return whether this tree contains this word, <br>
	 *         if the word is null return false, if word is empty string, return
	 *         true.
	 */
	public boolean hasWord(String word) {
		if (word == null)
			return false;
		word = word.trim();
		if ("".equals(word))
			return true;
		WordNode currentNode = root;
		for (int i = 0; i < word.length(); i++) {
			char character = word.charAt(i);
			Map<Character, WordNode> children = currentNode
					.getChildrenMap();
			if (!children.containsKey(character)) {
				return false;
			}
			currentNode = children.get(character);
		}
		// at last, check whether the parent node contains one null key - the
		// leaf node, if so return true, else return false.
		return currentNode.getChildrenMap().containsKey(
				null);
	}
}
class WordNode {
	private Character character;
	private WordNode parent;
	private Map<Character, WordNode> childrenMap = new HashMap<Character, WordNode>();
	public WordNode(Character character) {
		this.character = character;
	}
	/**
	 * @return all strings of this sub tree
	 */
	public List<String> subWords() {
		List<String> subWords = new ArrayList<String>();
		String prefix = getPrefix();
		List<String> noPrefixSubWords = subWordsImpl();
		for (String noPrefixSubWord : noPrefixSubWords) {
			subWords.add(prefix + noPrefixSubWord);
		}
		return subWords;
	}
	private List<String> subWordsImpl() {
		List<String> words = new ArrayList<String>();
		Iterator<Character> keyIterator = childrenMap
				.keySet().iterator();
		while (keyIterator.hasNext()) {
			Character key = keyIterator.next();
			if (key == null) {
				words.add(convertToString(this.character));
			} else {
				WordNode node = childrenMap.get(key);
				List<String> childWords = node
						.subWordsImpl();
				for (String childWord : childWords) {
					words
							.add(convertToString(this.character)
									+ childWord);
				}
			}
		}
		return words;
	}
	public void addChild(WordNode child) {
		child.parent = this;
		childrenMap.put(child.getCharacter(), child);
	}
	public Character getCharacter() {
		return character;
	}
	public WordNode getParent() {
		return parent;
	}
	public Map<Character, WordNode> getChildrenMap() {
		return childrenMap;
	}
	private String convertToString(Character character) {
		return (character == null) ? "" : String
				.valueOf(character);
	}
	private String getPrefix() {
		StringBuilder sb = new StringBuilder();
		WordNode parentNode = this.parent;
		while (parentNode != null) {
			if (parentNode.getCharacter() != null) {
				sb.append(parentNode.getCharacter());
			}
			parentNode = parentNode.parent;
		}
		return sb.reverse().toString();
	}
}