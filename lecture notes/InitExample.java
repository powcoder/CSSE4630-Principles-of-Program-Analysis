https://powcoder.com
代写代考加微信 powcoder
Assignment Project Exam Help
Add WeChat powcoder
https://powcoder.com
代写代考加微信 powcoder
Assignment Project Exam Help
Add WeChat powcoder
package initvars;

/**
 * Example of static 'initialised-variable' checking in Java.
 *
 * Static Analysis is 'forward, must', with reverse powerset of all vars.
 * So our lattice bottom is: {a,b,args}
 * and our lattice top is: {}
 * JOIN operator is: intersection
 * Transfer fn for x=E:  JOIN(...) u {x}
 */
public class InitExample {

    public static void main(String args[]) {
        // {args}
        int a;
        // {args}
        int b;
        // {args}
        b = 2;
        // {args,b}
        if (args.length > 1) {
            a = args.length;
            // {args,b,a}
        }
        // JOIN = {args,b} n {args,b,a} = {args,b}
        // Note that 'a' is not in the set.  So we give an error about 'a'.
        System.out.println("a=" + a + " b=" + b);
    }
}












/*
        for (int i=args.length; i >= 0; i--) {
            if (i == args.length) {
                a = 0;
            } else {
                a = Math.max(a, args[i].length());
            }
        }
 */