/*
 * Copyright 2010 Christos Gioran
 *
 * This file is part of DoubleArrayTrie.
 *
 * DoubleArrayTrie is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * DoubleArrayTrie is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with DoubleArrayTrie.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.digitalstain.datrie;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.digitalstain.datrie.store.IntegerArrayList;
import org.digitalstain.datrie.store.IntegerList;
import org.digitalstain.datrie.util.String2IntList;

public class TestDoubleArrayTrie{

	public void testRobustnessUnderStress() {

		final int ALPHABET_SIZE = 120;
		final int NUMBER_OF_STRINGS = 100000;
		final int MAXIMUM_STRING_SIZE = 100;

		List<IntegerList> data = new ArrayList<IntegerList>(NUMBER_OF_STRINGS);
		AbstractDoubleArrayTrie trie = new DoubleArrayTrieImpl(ALPHABET_SIZE);
		Random rng = new Random();

		for (int i = 0; i < NUMBER_OF_STRINGS; i++) {
			IntegerList toAdd = new IntegerArrayList(MAXIMUM_STRING_SIZE);
			for (int j = 0; j < MAXIMUM_STRING_SIZE; j++) {
				toAdd.add(rng.nextInt(ALPHABET_SIZE));
			}
			data.add(toAdd);
		}

		for (IntegerList list : data) {
			
		}

		for (IntegerList list : data) {		}

		for (IntegerList list : data) {
			int removeSize = rng.nextInt(list.size()) + 1;
			for (; removeSize > 0; removeSize--) {
				list.remove(list.size() - 1);
			}
		}

		// TODO
		// Insert a NOT_FOUND test here that is on the one hand random and
		// on the other succeeds always regardless of the generated strings.
	}

	public void testMarginCases() {
		AbstractDoubleArrayTrie trie = new DoubleArrayTrieImpl(3);

		IntegerList empty = new IntegerArrayList();

		IntegerList notIn = new IntegerArrayList();
		notIn.add(1);
		notIn.add(2);

		IntegerList one = new IntegerArrayList();
		one.add(2);

		one.add(1);
	}

	public void testCountingTrie() {
		CountingTrie trie = new CountingTrie();
		IntegerList string1 = new IntegerArrayList();
		string1.add(0);
		string1.add(1);
		string1.add(2);
		string1.add(3);
		string1.add(4);
		string1.add(5);
		string1.add(6);
		string1.add(7);
		IntegerList string2 = new IntegerArrayList();
		string2.add(0);
		string2.add(1);
		string2.add(2);
		string2.add(3);
		string2.add(4);
		IntegerList string3 = new IntegerArrayList();
		string3.add(0);
		string3.add(1);
		string3.add(2);
		string3.add(3);
		string3.add(4);
		trie.addToTrie(string1);
		trie.addToTrie(string2);
		trie.addToTrie(string3);
		System.out.println("count1 : " + trie.getExistCountFor(string3));
		IntegerList string4 = new IntegerArrayList();
		string4.add(0);
		string4.add(1);
		string4.add(2);
		string4.add(3);
		string4.add(4);
		trie.addToTrie(string4);
		System.out.println("count2 : " + trie.getExistCountFor(string3));
		System.out.println("prefix : " + trie.containsPrefix(string4));
		
		String str5 = "我是谁呀";
		String str6 = "我是谁";
		String str7 = "我是谁呀谁谁谁谁";
		IntegerList string5 = String2IntList.formatFor(str5);
		IntegerList string6 = String2IntList.formatFor(str6);
		IntegerList string7 = String2IntList.formatFor(str7);
		
		trie.addToTrie(string7);
		trie.addToTrie(string5);
		trie.addToTrie(string6);
		
		System.out.println("count3 : " + trie.getExistCountFor(string5));
		System.out.println("count3 : " + trie.containsPrefix(string6));
		
		List<String> prefixIndex = trie.prefixIndex(string5);
		for(String index : prefixIndex) {
			System.out.println("前缀词: " + str5.substring(0, Integer.valueOf(index) + 1));
		}
		System.out.println("---------------------------");
		prefixIndex = trie.prefixIndex(string7);
		for(String index : prefixIndex) {
			System.out.println("前缀词: " + str7.substring(0, Integer.valueOf(index) + 1));
		}
	}
	
	public static void main(String[] args) {
		TestDoubleArrayTrie testTrie = new TestDoubleArrayTrie();
		testTrie.testCountingTrie();
	}
}
