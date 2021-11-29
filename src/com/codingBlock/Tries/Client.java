package com.codingBlock.Tries;

public class Client {
	
	public static void main(String [] args){
		
		Trie trie = new Trie();
		trie.addWord("arts");
		trie.addWord("art");
		trie.addWord("bug");
		trie.addWord("boy");
		trie.addWord("see");
		trie.addWord("seen");
		trie.addWord("sea");
		trie.addWord("amit");
		
		trie.display();
		System.out.println("--------------------");
		System.out.println(trie.search("arts"));
		System.out.println(trie.search("art"));
		System.out.println(trie.search("arpit"));
		System.out.println("--------------------");
		trie.remove("arts");
		trie.remove("art");
		trie.display();
		System.out.println(trie.numWord());
	}

}
