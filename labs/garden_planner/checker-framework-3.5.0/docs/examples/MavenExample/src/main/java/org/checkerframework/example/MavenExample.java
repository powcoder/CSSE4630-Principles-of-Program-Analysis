https://powcoder.com
代写代考加微信 powcoder
Assignment Project Exam Help
Add WeChat powcoder
https://powcoder.com
代写代考加微信 powcoder
Assignment Project Exam Help
Add WeChat powcoder
package org.checkerframework.example;

import org.apache.commons.lang3.text.StrBuilder;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * If you run:
 *
 * <pre>mvn compile</pre>
 *
 * then the build for this project should fail with a warning for the line:
 *
 * <pre>@NonNull Object nn = nullable;</pre>
 */
public class MavenExample {

    public static @Nullable Object nullable = null;

    public static void main(final String[] args) {
        System.out.println("Hello World!");

        StrBuilder stb = new StrBuilder();

        @NonNull Object nn = nullable; // error on this line
        System.out.println(nn);
    }
}
