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
This library provides HTML escaping function (not provides unescaping one).

This supports following features:

- Escape HTML special characters (`&<>"'`)
- Escape `{` and `}` characters for some JavaScript templates (e.g. AngularJS and such JavaScript framework)
- Escape `\`` character for Internet Explorer

This is a Java port of [HTML::Escape](https://metacpan.org/pod/HTML::Escape).

Benchmark
--

Comparison of this library (version:0.0.1), [StringEscapeUtils (Apache Commons-Lang, version:3.4)](https://commons.apache.org/proper/commons-lang/javadocs/api-3.4/org/apache/commons/lang3/StringEscapeUtils.html) and [HtmlEscapers (guava, version:18.0)](http://docs.guava-libraries.googlecode.com/git/javadoc/com/google/common/html/HtmlEscapers.html) (using Java8u25):

```
Score:

guavaHtmlEscapers:  0 wallclock secs ( 0.12 usr +  0.02 sys =  0.14 CPU) @ 715251.30/s (n=100000)
commonsLangStringEscapeUtils:  1 wallclock secs ( 1.73 usr +  0.01 sys =  1.74 CPU) @ 57519.92/s (n=100000)
microHTMLEscaper:  0 wallclock secs ( 0.11 usr +  0.01 sys =  0.12 CPU) @ 803871.44/s (n=100000)

Comparison chart:

                                    Rate  guavaHtmlEscapers  commonsLangStringEscapeUtils  microHTMLEscaper
             guavaHtmlEscapers  715251/s                 --                         1143%              -11%
  commonsLangStringEscapeUtils   57520/s               -92%                            --              -93%
              microHTMLEscaper  803871/s                12%                         1298%                --
```

This library gets faster about 1300% than commons-lang's StringEscapeUtils, about 10% than guava's HtmlEscapers
(I think performance of between this library and guava is almost the same).

A code of benchmarking is [here](https://github.com/moznion/micro-html-escape/blob/master/author/BasicBench.java).

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

