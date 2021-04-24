package spelling;

public class TrieTester {
	public static void main(String[] args) {
		AutoCompleteDictionaryTrie tr = new AutoCompleteDictionaryTrie();
		tr.addWord("ask");
		tr.addWord("asking");
		tr.addWord("klop");
		//tr.addWord("as");
		tr.addWord("ado");
		tr.addWord("broom");
		tr.addWord("bro");
		tr.addWord("blob");
		tr.addWord("a");
		
		tr.printTree();
		System.out.println(tr.size());
		
		System.out.println(tr.isWord("br"));
	}
}
