package Section07;

import java.util.*;

/**
 * 풀이 시간: 초과 
 * 시간 복잡도 : O(N)
 * 풀이 방법 : Retrieval (TRIE)
 * 검색 키워드는 와일드카드 문자인 '?'가 하나 이상 포함돼 있으며, '?'는 각 검색 키워드의 접두사 아니면 접미사 중 하나로만 주어집니다.
	 -- 예를 들어 "??odo", "fro??", "?????"는 가능한 키워드입니다.
	 -- 반면에 "frodo"('?'가 없음), "fr?do"('?'가 중간에 있음), "?ro??"('?'가 양쪽에 있음)는 불가능한 키워드입니다.

	               *
	           f    k
	       r          a
	    o    a         k
	 d    n    m         a
   o       t    e         o
   	 
 *         
 */


public class programmers_가사검색_ps {
    public static void main(String args[]){
        String words[] = {"frodo", "front", "frost", "frozen", "frame", "kakao", "friday"};
        String queries[] = {"fro??", "????o", "fr???", "fro???", "pro?"};
        System.out.println(Arrays.toString(solution(words, queries)));
        // 	["frodo", "front", "frost", "frozen", "frame", "kakao"], ["fro??", "????o", "fr???", "fro???", "pro?"]
        //  [3, 2, 4, 1, 0]
    }
    
    public static int[] solution(String[] words, String[] queries) {
    	int[] answer = new int[queries.length];
    	
    	// 문자열 앞에서 읽기 
    	Trie root = new Trie();
    	// 문자열 뒤에서 읽기 
    	Trie tail = new Trie();
    	
    	// 문자열 tree 생성 
    	for(String word: words) {
    		root.insert(word, word.length(), 0, 0);
    		tail.insert(word, word.length(), word.length()-1 , 1);
    	}
    	int index = 0;
    	// 각 query 마다 일치하는 word 찾기 
    	for(String query : queries) {
    		// root node 에서부터 탐색 
    		if(query.charAt(0) != '?') answer[index++] = root.find(query, query.length(), 0, 0);
    		else  //  첫 글자가 '?' 아면 뒤에서 부터 탐색 
    			answer[index++] = tail.find(query, query.length(), query.length()-1, 1);
    	}
    	return answer;
    }
    
    private static class Trie {
    	private HashMap<Character, Trie>  children;
    	private HashMap<Integer, Integer> wordLength;
    	
    	public Trie() {
    		children = new HashMap<>(); //다음 문자열 노드 
    		wordLength = new HashMap<>(); // 문자열 길이 동일한 문자열 개수 
    		
    	}
    	
    	// 문자열 트리 생성 
    	public void insert(String word, int length, int index, int flag ) {
    		// 1. 문자열 범위 
    		if(word.length() == index || index < 0) return; 
    		// 2. ? 만나게 되었을때
    		if(word.charAt(index) == '?') return; 
    		// 3. 현재문자열의 길이 개수 추가 
    		// 찾는키가 있다면 찾는 키의 값 반환. 없다면 기본값 반환 
    		wordLength.put(length, wordLength.getOrDefault(length,0) + 1);
    			
    		//현재 인덱스에 해당하는 문자
            char ch = word.charAt(index);

            // 다음 문자 노드중에 현재 문자를 포함하는노드가 없을 경우 새로 등록 
            if (!children.containsKey(ch)) children.put(ch,new Trie());

            // 해당 문자가 노드에 존재하면 다음 index 의 번호로 넘어가기 
            if (flag == 0) children.get(ch).insert(word,length,index+1,0);
            // 단어가 끝나는 경우 표시 
            else children.get(ch).insert(word,length,index-1,1);
    	}
    	
    	// 문자열 트리에서 탐색 
    	public int find(String query, int length, int index, int flag) {
    		//쿼리 범위 밖이면 종료
            if (query.length() == index || index < 0) return 0;

            //?를 만났을 때, 해당 쿼리 길이와 일치하는 문자열 개수 
            if (query.charAt(index) == '?') return wordLength.getOrDefault(length,0);

            //현재 인덱스의 문자
            char ch = query.charAt(index);

            //현재 문자에 대한 다음 노드가 존재하지 않다면 종료
            if (!children.containsKey(ch)) return 0;

            //해당 문자열에 대한 다음 인덱스부터 재탐색
            if (flag == 0) return children.get(ch).find(query,length,index+1,0);
            // 문자열이 끝났을 경우 flag =1 표시 
            else return children.get(ch).find(query,length,index-1,1);
        }
    	
    }
}
    


