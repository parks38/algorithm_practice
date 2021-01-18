package Section8;
/*
 * 풀이 시간: 시간 초과 
 * 시간 복잡도 : O(N^2)
 * 공간 복잡도 : O(N^2) =  dp array
 * 풀이 방법 :                        i 0 1 2 3 4 5 6
 *         a b c d c b a         j    a b c d c b a
 *       a 1 0 0 0 0 0 1         0  a 1           1
 *       b 0 1 0 0 0 1 0         1  b   1       1 
 *       c 0 0 1 0 1 0 0         2  c     1   1 
 *       d 0 0 0 1 0 0 0         3  d       1 
 *       c 0 0 1 0 1 0 0         4  c     1   1
 *       b 0 1 0 0 0 1 0         5  b   1       1 
 *       a 1 0 0 0 0 0 1         6  a 1           1
 *       
 *         a b a c d e             table[i + 1][j - 1]    
 *       a 1   1                   a b c d c b a
 *       b   1                     l   r        
 *       a 1   1                   a b c d c b a
 *       c       1                 l     r
 *       d         1               a b c d c b a
 *       e           1             l       r
 *       
 *     ** left - k (substring의 길이) - right
 *       -짧은 substring 부터 탐색한다
 *       - left++ && right-- 를 통해 가운데 값들 
 *         s.charAt(left) == s.charAt(right) 를 확인한다. 
 */

public class programmers_가장_긴_팰린드롬_ps {
		public static void main(String[] args){
	
			String str = "abcdcba";
			System.out.println(longestPalSubstr(str));
		}

		static int longestPalSubstr(String str){
			int n = str.length();

			// table[i][j] : i 와 j 가 mirror index 이고 palindrome 인지 check 
			boolean table[][] = new boolean[n][n];

			// 길이가 1인 경우, 모두 palindrome
			int maxLength = 1;
			for (int i = 0; i < n; ++i)
				table[i][i] = true;

			// 길이가 2인 경우 palindrome 인지 check 
			for (int i = 0; i < n - 1; i++) {
				if (str.charAt(i) == str.charAt(i + 1)) {
					table[i][i + 1] = true;
					maxLength = 2;
				}
			}

			// 길이가 3 이상인 경우,
			// k : length of substring 
			for (int k = 3; k <= n; k++) {

				// 시작 index initialize  
				for (int left = 0; left < n - k + 1;left++) {
					// j: 끝 index 설정 (i : 시작 부터 K length 까지) 
					int right = left + k - 1;

					// 해당 i 와 j 의 글자가 같은지와 그 이전 값들이 palindrome 이였는지 확인 
					if (table[left + 1][right - 1] && str.charAt(left) == str.charAt(right)) {
						table[left][right] = true; // ispalindrome
						//update 
						if (k > maxLength) {
							maxLength = k;
						}
					}
				}
			}

			// 가장 긴 palindrome 길이 return 
			return maxLength;
		}
			
}


