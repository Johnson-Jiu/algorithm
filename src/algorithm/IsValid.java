package algorithm;

import java.util.Stack;

//'('，')'，'{'，'}'，'['，']'

public class IsValid {
    public boolean isValid(String s) {
        if(s.length() == 0){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
                continue;
            }
            Character pop = stack.peek();
            if(pop == '(' && s.charAt(i) == ')'){
                stack.pop();
            }
            if(pop == '{' && s.charAt(i) == '}'){
                stack.pop();
            }
            if(pop == '[' && s.charAt(i) == ']'){
                stack.pop();
            }
            stack.push(s.charAt(i));
        }
        return stack.isEmpty();

    }
}
