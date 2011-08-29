package org.codeexample.algorithm.wordPuzzles;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class Dictionary {

    private Map<String, HashSet<String>> wordMap = new HashMap<>();

    /**
     * @param dictionaryFile, the file contains list of words, 
     * each line may contain several words that are separated by space.
     * @throws IOException
     */
    public Dictionary(String dictionaryFile) throws IOException {
        init(dictionaryFile);
    }

    private void init(String dictionaryFile) throws IOException {
        FileReader fr = new FileReader(new File(dictionaryFile));
        BufferedReader br = new BufferedReader(fr);

        Pattern pattern = Pattern.compile("\\s+");
        while (true) {
            String line = br.readLine();
            if (line == null) {
                break;
            }
            String[] words = pattern.split(line);
            for (String word : words) {
                word = word.trim();
                if (!word.isEmpty()) {
                    String sortedWord = getMapKey(word);

                    HashSet<String> matchedWordSet = wordMap.get(sortedWord);
                    if (matchedWordSet == null) {
                        matchedWordSet = new HashSet<>();
                    }
                    matchedWordSet.add(word);
                    wordMap.put(sortedWord, matchedWordSet);
                }
            }
        }
    }

    private String getMapKey(String letters) {
        char[] chars = letters.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }

    /**
     * Return a list of word that can constructed by rearranging these letters.
     * 
     * @param letters
     * @return a hash set that containing all words, if can't find one, return
     *         empty list, instead of null to avoid NPE in client code.
     * @throws IllegalArgumentException if parameter is null.
     */
    public Set<String> formWords(String letters) 
            throws IllegalArgumentException {
        if (letters == null) {
            throw new IllegalArgumentException("parameter can't be null.");
        }
        Set<String> wordsSet = wordMap.get(getMapKey(letters));
        if (wordsSet == null) {
            wordsSet = new HashSet<>();
        }
        
        return wordsSet;
    }
}