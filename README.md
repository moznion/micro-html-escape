micro-html-escape
=============

A lightweight HTML escaper for Java.

Synopsis
---

```java
import net.moznion.micro.escape.HTMLEscaper;

...

final String escaped = HTMLEscaper.escape("<^o^>"); // => "&lt;^o^&gt;"
```

Description
--

micro-html-escape is a lightweight (it has no dependencies and fast) HTML escaper.
This library __only__ escapes special characters of HTML.

This is a Java port of [HTML::Escape](https://metacpan.org/pod/HTML::Escape).

Benchmark
--

Comparison of this library (version:0.0.1), [StringEscapeUtils (Apache Commons-Lang, version:3.4)](https://commons.apache.org/proper/commons-lang/javadocs/api-3.4/org/apache/commons/lang3/StringEscapeUtils.html) and [HtmlEscapers (guava, version:18.0)](http://docs.guava-libraries.googlecode.com/git/javadoc/com/google/common/html/HtmlEscapers.html) (using Java8u25):

```
Score:

commonsLangStringEscapeUtils:  6 wallclock secs ( 5.42 usr +  0.12 sys =  5.54 CPU) @ 18033.18/s (n=100000)
microHTMLEscaper:  0 wallclock secs ( 0.84 usr +  0.03 sys =  0.86 CPU) @ 115710.07/s (n=100000)
guavaHtmlEscapers:  1 wallclock secs ( 1.11 usr +  0.02 sys =  1.13 CPU) @ 88675.52/s (n=100000)

Comparison chart:

                                    Rate  commonsLangStringEscapeUtils  microHTMLEscaper  guavaHtmlEscapers
  commonsLangStringEscapeUtils   18033/s                            --              -84%               -80%
              microHTMLEscaper  115710/s                          542%                --                30%
             guavaHtmlEscapers   88676/s                          392%              -23%                 --
```

This library gets faster about 540% than commons-lang's StringEscapeUtils, about 30% than guava's HtmlEscapers.

A code of benchmarking is [here](https://github.com/moznion/micro-html-escape/blob/master/author/Bench.java).

See Also
--

- [HTML::Escape](https://metacpan.org/pod/HTML::Escape)

Author
--

moznion (<moznion@gmail.com>)

License
--

```
The MIT License (MIT)
Copyright © 2015 moznion, http://moznion.net/ <moznion@gmail.com>

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the “Software”), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
```

