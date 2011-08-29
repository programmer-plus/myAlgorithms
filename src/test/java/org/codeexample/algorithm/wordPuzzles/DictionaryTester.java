/*
 * Copyright 2011 Jeffery Yuan.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.codeexample.algorithm.wordPuzzles;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Set;

import org.codeexample.common.ArrayUtils;
import org.junit.Test;

/**
 * 
 * @author Jeffery Yuan
 */
public class DictionaryTester {

    @Test
    public void testFormWords() throws IOException {
        Dictionary dictionary = new Dictionary(this.getClass().getResource("dict.txt").getFile());

        Set<String> words = dictionary.formWords("atc");
        assertTrue(ArrayUtils.equalsIgnoreOrder(new String[]{"act", "cat"},
                words.toArray(new String[0])));

        words = dictionary.formWords("google");
        assertTrue(ArrayUtils.equalsIgnoreOrder(new String[]{"google"},
                words.toArray(new String[0])));

        words = dictionary.formWords("notdound");
        assertTrue(words.isEmpty());
    }

    @Test(expected=IllegalArgumentException.class)
    public void testNullParameter() throws IOException {
        Dictionary dictionary = new Dictionary(this.getClass().getResource("dict.txt").getFile());
        dictionary.formWords(null);
    }
}
