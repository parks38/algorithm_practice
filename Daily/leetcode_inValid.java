package practice;
/*
    Stack 문제 풀이
    -  괄호 앞부분을 stack안에 쌓아서 닫는 괄호")" 가 나왔을때 마지막으로 들어갔던 시작괄호와 일치하는 지 확인한다
    - 일치하면 해당 시작 괄호와 닫는 괄호 모두 없앤다.
    - 일치하는 char 이 없는 경우에는 stack에 계속 쌓아둔다.

    { [ [ ] { } ] }
    stack { [ [
    char c = ]
    same.containsKey(']') = '['
    stack.pop = [

 */

import java.util.*;

public class leetcode_inValid {

    public boolean isValid(String s) {
        HashMap<Character, Character> same = new HashMap<Character, Character>();
        same.put(')', '(');
        same.put('}', '{');
        same.put(']', '[');


        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (same.containsKey(c)) {
                if (stack.empty() || stack.pop() != same.get(c)) return false;
            } else {
                stack.push(c);
            }
        }
        // check when 한개의 char symbol
        return stack.empty();
    }

}
