package trie_dataStructure;

public class AutoCompleteMain {

	public static void main(String[] args) {
		String[] dictionary = {"shubham","shubh","shu"};
		
		AutoComplete auto = new AutoComplete(dictionary);
		System.out.println(auto.getAllWords("sh"));

	}

}
