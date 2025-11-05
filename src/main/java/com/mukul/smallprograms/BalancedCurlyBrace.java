// java
package com.mukul.smallprograms;

import java.util.Stack;

/**
 * Utility class to validate balanced grouping symbols (parentheses, braces and brackets).
 *
 * <p>This class provides a single static method {@link #isBalanced(String)} to check whether an
 * input string containing grouping symbols is balanced. The {@link #main(String[])} method
 * demonstrates usage with simple examples.</p>
 *
 * <p>Expected input characters: only the six grouping characters {@code '(', ')', '{', '}', '['}
 * and {@code ']'}. Other characters will be treated as closing symbols and will likely cause the
 * method to return {@code false} unless the stack matches them exactly.</p>
 *
 * <p>Examples:
 * <pre>
 * isBalanced("[()[]]")  // returns true
 * isBalanced("[()[]]}") // returns false
 * </pre>
 * </p>
 *
 * <p>Time complexity: O(n) where n is the length of the input string.
 * Space complexity: O(n) in the worst case (all opening symbols).</p>
 *
 * <p>Thread-safety: This class is stateless and its public method is thread-safe.</p>
 */
public class BalancedCurlyBrace {

    /**
     * Example entry point demonstrating {@link #isBalanced(String)}.
     *
     * <p>Prints the boolean result of checking two sample strings to standard output.</p>
     *
     * @param args command-line arguments (ignored)
     */
    public static void main(String[] args) {
        System.out.println(isBalanced("[()[]]"));
        System.out.println(isBalanced("[()[]]}"));
    }

    /**
     * Determines whether the provided input string contains balanced grouping symbols.
     *
     * <p>The method uses a stack to push the expected closing symbol when an opening symbol is
     * encountered. When a character that is not an opening symbol is encountered, it is compared
     * with the top of the stack. If they match, the top is popped; otherwise the string is not
     * balanced.</p>
     *
     * @param input the string to validate; expected to contain grouping symbols {@code () {} []}
     * @return {@code true} if the grouping symbols in {@code input} are balanced and properly nested,
     *         {@code false} otherwise
     *
     * @throws NullPointerException if {@code input} is {@code null}
     */
    private static boolean isBalanced(String input) {
        Stack<Character> stack = new Stack<>();
        for (char data : input.toCharArray()) {
            switch (data) {
                case '(':
                    stack.push(')');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case '[':
                    stack.push(']');
                    break;
                default:
                    if (stack.isEmpty() || stack.peek() != data) {
                        return false;
                    } else {
                        stack.pop();
                    }
            }
        }
        return stack.isEmpty();
    }
}
