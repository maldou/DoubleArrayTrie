package org.digitalstain.datrie.util;

import org.digitalstain.datrie.store.IntegerArrayList;
import org.digitalstain.datrie.store.IntegerList;
/**
 * 编码方便，String转换成IntegerList
 * @author waldoudou
 *
 */
public class String2IntList {

	public static IntegerList formatFor(String str) {
		if(str == null || str.length() == 0) {
			return null;
		}
		
		IntegerList stringList = new IntegerArrayList();
		for(int i = 0; i < str.length(); i++) {
			int intValue = (int)str.charAt(i);
			stringList.add(intValue);
		}
		
		return stringList;
	}
	
	public static void main(String[] args) {
		String s = "��";
		System.out.println((char)25105);
	}
}

