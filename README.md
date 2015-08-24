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

Comparison between this library (version:0.0.1) and [StringEscapeUtils (Apache Commons Lang, version:3.4)](https://commons.apache.org/proper/commons-lang/javadocs/api-3.4/org/apache/commons/lang3/StringEscapeUtils.html):

```
Score:

commonsLangStringEscapeUtils:  6 wallclock secs ( 5.82 usr +  0.11 sys =  5.93 CPU) @ 16864.20/s (n=100000)
microHTMLEscaper:  1 wallclock secs ( 1.15 usr +  0.01 sys =  1.16 CPU) @ 86195.30/s (n=100000)

Comparison chart:

                                   Rate  commonsLangStringEscapeUtils  microHTMLEscaper
  commonsLangStringEscapeUtils  16864/s                            --              -80%
              microHTMLEscaper  86195/s                          411%                --
```

This library gets faster about 400% than StringEscapeUtils.

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

