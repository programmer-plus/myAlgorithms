package org.codeexample.autocomplete;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Test;
public class WordTreeTester {
	private WordTree wordTree;
	{
		wordTree = new WordTree();
		wordTree.addWord("a");
		wordTree.addWord("ab");
		wordTree.addWord("abc");
		wordTree.addWord("b");
		wordTree.addWord("bb");
		wordTree.addWord("bbc");
		// what would happen if we insert same word twice
		wordTree.addWord("a");
		wordTree.addWord("ab");
		wordTree.addWord("abc");
		// has extra space before or after the word
		wordTree.addWord(" abc");
		wordTree.addWord("abc ");
		wordTree.addWord(" abc ");
		// boundar case
		wordTree.addWord("");
		wordTree.addWord("  ");
		wordTree.addWord("   ");
		wordTree.addWord(null);
	}
	@Test
	public void testWordsPrefixWith() {
		// boundary case,
		List<String> words = wordTree.wordsPrefixWith("");
		assertEquals(6, words.size());
		assertArrayEquals(new String[] { "a", "ab", "abc", "b", "bb", "bbc" }, words.toArray());
		words = wordTree.wordsPrefixWith("a");
		assertEquals(3, words.size());
		assertArrayEquals(new String[] { "a", "ab", "abc" }, words.toArray());
		words = wordTree.wordsPrefixWith("ab");
		assertEquals(2, words.size());
		assertArrayEquals(new String[] { "ab", "abc" }, words.toArray());
		words = wordTree.wordsPrefixWith("abc");
		assertEquals(1, words.size());
		assertArrayEquals(new String[] { "abc" }, words.toArray());
	}
	@Test
	public void testHasWord() {
		assertTrue(wordTree.hasWord("a"));
		assertTrue(wordTree.hasWord("ab"));
		assertTrue(wordTree.hasWord("abc"));
		assertFalse(wordTree.hasWord("invalid"));
		assertFalse(wordTree.hasWord("abcd"));
		// boundary case
		assertTrue(wordTree.hasWord(""));
		assertFalse(wordTree.hasWord(null));
	}
}
