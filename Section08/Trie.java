package Section8;

import java.util.HashMap;
import java.util.Map;

/*
 * 풀이 시간: 시간 초과 
 * 시간 복잡도 : O(M)  - M : length of the longest word 
 * 공간 복잡도 : O(1) 
 * 풀이 방법 : 
 * 		(1) insert - trie 트리안에 넣을 문자를 하나씩 삽입 하고 마지막 글자는 boolean isCompleteWord 로 표시
 * 
		  					a
		  				p 
		  	(true)	p 
		  		l       
		  	 e      y
		  (true))
 * 		
 * 		(2) search - 트리를 탐색하여 해당 문자가 트리안에 존재하는 문자가 있는지 확인 
 *                   모든 단어가 존재하고 isCompleteWord - true 이면 해당 문자는 트리에 존재한다.
 *          
 *      (3) startWith(prefix)- 트리를 탐색하여 해당 문자가 트리안에 존재하는지 탐색
 *      			 문자 길이와 상관없음. (앞에 단어만 동일하다면 true) 
 */


public class Trie {
    private TrieNode root;
 
    public Trie() {
        root = new TrieNode();
    }
 
    // trie 트리 생성하기 
    public void insert(String word) {
    	// 현재 확인 하는 노드는 root 의 자식 
        HashMap<Character, TrieNode> current = root.children;
 
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
 
            TrieNode node;
            // 현재 trie 에 문자열이 존재하는 경우 
            // 다음 children 으로 넘어가기  
            if(current.containsKey(c)){
                    node = current.get(c);
            }else{
            // 현재 trie 에 해당 문자열이 존재하지 않는 경우
            // parent 다음에 새로운 node 생성 
                node = new TrieNode(c);
                current.put(c, node);
            }
            
            // update current 
            current = node.children;
 
            // 단어의 끝 표시 
            if(i==word.length()-1)
                node.isCompleteWord = true;    
        }
    }
 
    // trie 트리에 해당 문자가 존재한다면 return true else false 
    public boolean search(String word) {
        TrieNode current = searchNode(word);
        if(current != null && current.isCompleteWord) 
            return true;
        else
            return false;
    }
 
    // 트리안에 문자 중에 해당 prefix로 시작하는 문자가 있다면 return true else false 
    public boolean startsWith(String prefix) {
        if(searchNode(prefix) == null) 
            return false;
        else
            return true;
    }
 
    // Trie 트리 안에 str 와 동일한 문자가 있는지 탐색하는 공통된 메소드 
    public TrieNode searchNode(String str){
        Map<Character, TrieNode> current = root.children; 
        TrieNode parent = null;
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            //str 의 문자 letter이 Trie 트리에 존재하는 경우 다음 문자도 탐색하
            if(current.containsKey(c)){
                // update : parent -> current
                //          current -> child 
                parent = current.get(c);
                current = parent.children;
            }else{
            // 동일한 letter 이 없을 시
                return null;
            }
        }
        
        return parent;
    }
    
    class TrieNode {
    char c;
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    boolean isCompleteWord;
 
    public TrieNode() {}
 
    public TrieNode(char c){
        this.c = c;
        isCompleteWord = false;
    }
}
}
