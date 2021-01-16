package Section8;

/*
 * 풀이 시간: 시간 초과 
 * 시간 복잡도 : O(M)  - M : length of the longest word 
 * 공간 복잡도 : O(1) 
 * 풀이 방법 : 
 * 		(1) insert - trie 트리안에 넣을 문자를 하나씩 삽입 하고 마지막 글자는 boolean isCompleteWord 로 표시
 * 
		  					a
		  				p 
		  	(true)- p 
		  		l       
	(true)	- e   y - (true)
		  
 * 		
 * 		(2) search - 트리를 탐색하여 해당 문자가 트리안에 존재하는 문자가 있는지 확인 
 *                   모든 단어가 존재하고 isCompleteWord - true 이면 해당 문자는 트리에 존재한다.
 *          
 *      (3) startWith(prefix)- 트리를 탐색하여 해당 문자가 트리안에 존재하는지 탐색
 *      			 문자 길이와 상관없음. (앞에 단어만 동일하다면 true) 
 */

public class leetcode_Implement_Trie_ps {
	public static void main(String[] args) {
		Trie trie = new Trie();

		trie.insert("apple");
		System.out.println(trie.search("apple"));   // returns true
		System.out.println(trie.search("app"));     // returns false
		System.out.println(trie.startsWith("app")); // returns true
		trie.insert("app");   
		System.out.println(trie.search("app"));     // returns true
	}
	
}
