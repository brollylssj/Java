
public class ONP {
        public static void main(String[] args) {
                Stack stack = new Stack(256);
                String result = "";
                String equation = "( 1 + 2 ) * 3";
                for (int i = 0; i < equation.length(); i++) {
                        if (equation.charAt(i) == '(') {
                                stack.push(equation.charAt(i));
                        } else if (equation.charAt(i) == ')') {
                                while (stack.peek() != '(') {
                                        result = result + stack.pop() + "";
                                }
                                stack.pop();
                        } else if (equation.charAt(i) == '*' || equation.charAt(i) == '/'
                                        || equation.charAt(i) == '%' || stack.isEmpty()
                                        || equation.charAt(i) == '+' || equation.charAt(i) == '-') {
                                while (!stack.isEmpty()
                                                && findPriority(stack.peek()) >= findPriority(equation
                                                                .charAt(i))) {
                                        result = result + stack.pop();
                                }
                                stack.push(equation.charAt(i));
                        } else {
                                result = result + equation.charAt(i);
                        }
                }
                while (!stack.isEmpty()) {
                        result = result + stack.pop();
                }
                System.out.println(result);
        }
 
        public static int findPriority(char equationOperator) {
                if (equationOperator == '+' || equationOperator == '-')
                        return 1;
 
                else if (equationOperator == '*' || equationOperator == '/')
                        return 2;
 
                else
                        return 0;
        }
}