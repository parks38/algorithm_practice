package Section8;

// abcdcba
// a     a
//  b   b
//   c c
//    d  : true -> 7

// abacde
// a    e false
// a   d false
// a  c false
// a  a true
// aba : true -> 3 

public class programmers_palendorme {
	public static void main(String[] args) {
	      String s = "abacde";
	      int ans = solution(s);
	      System.out.println(ans);
	   }
	    public static int solution(String s)
	    {
	        int answer = 1;
	        boolean isPal = true;
	        for(int i = s.length(); i > 0; i--){
	            for(int index = 0; index <= i-1; index++){
	                for(int j = i-index-1; j > index; j--) {
	                    if(s.charAt(index) == s.charAt(j)) {
	                       if(isPal) {
	                           answer = Math.max(answer, j+1);
	                       } else {
	                          isPal = true;
	                          answer = j+1;
	                       }
	                     
	                       index++;
	                    } else {
	                        isPal = false;
	                    }
	                }
	                // don't have to loop through every single 
	                if(isPal && answer > 0) return answer;
	            }
	            
	        
	        }
	        return answer;
	    }
	}

