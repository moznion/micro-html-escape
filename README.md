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

Comparison of this library (version:0.0.1), [StringEscapeUtils (Apache Commons Lang, version:3.4)](https://commons.apache.org/proper/commons-lang/javadocs/api-3.4/org/apache/commons/lang3/StringEscapeUtils.html) and [HtmlEscapers (guava, version:18.0)](http://docs.guava-libraries.googlecode.com/git/javadoc/com/google/common/html/HtmlEscapers.html):

```
Score:

guavaHtmlEscapers:  1 wallclock secs ( 1.62 usr +  0.09 sys =  1.71 CPU) @ 58568.96/s (n=100000)
commonsLangStringEscapeUtils:  4 wallclock secs ( 4.91 usr +  0.02 sys =  4.93 CPU) @ 20296.85/s (n=100000)
microHTMLEscaper:  1 wallclock secs ( 1.18 usr +  0.01 sys =  1.19 CPU) @ 84111.50/s (n=100000)

Comparison chart:

                                   Rate  guavaHtmlEscapers  commonsLangStringEscapeUtils  microHTMLEscaper
             guavaHtmlEscapers  58569/s                 --                          189%              -30%
  commonsLangStringEscapeUtils  20297/s               -65%                            --              -76%
              microHTMLEscaper  84112/s                44%                          314%                --
```

This library gets faster about 400% than commons lang's StringEscapeUtils, about 40% than guava's HtmlEscapers.

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

