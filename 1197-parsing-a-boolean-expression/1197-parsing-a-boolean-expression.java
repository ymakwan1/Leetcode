class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> operators = new Stack<>();
        Stack<Character> operands = new Stack<>();

        for(char ch : expression.toCharArray()) {
            if(ch == ',' || ch == '('){
                continue; //Ignore comma and open brackets
            }else if(ch == 't' || ch == 'f'){
                operands.push(ch); //Push operands t or f on the operands stack
            }else if(ch == ')'){
                Stack<Character> subExpression = new Stack<>();
                while(operands.peek() != '('){
                    subExpression.push(operands.pop()); //Collecting operands of current operation
                }
                operands.pop(); //Pop '('

                char operator = operators.pop();

                char result = evaluate(operator, subExpression); //Evaluate the sub-expression

                operands.push(result); //Push back on stack if further processing needed
            }else{
                operators.push(ch);
                operands.push('(');
            }
        }

        return operands.pop() == 't';
    }

    private char evaluate(char operator, Stack<Character> subExpression){
        //NOT op - negate every operand
        if(operator == '!'){
            return subExpression.pop() == 't' ?'f' : 't';
        }
        //AND op - return t if all true
        else if(operator == '&'){
            while(!subExpression.isEmpty()){
                if(subExpression.pop() == 'f'){
                    return 'f';
                }
            }
            return 't';
        }
        //OR op -  return t if any true
        else{
            while(!subExpression.isEmpty()){
                if(subExpression.pop() == 't'){
                    return 't';
                }
            }
            return 'f';
        }
    }
}