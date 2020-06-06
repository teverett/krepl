![CI](https://github.com/teverett/krepl/workflows/CI/badge.svg)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/ea088223d07242f196809250a2d255e9)](https://www.codacy.com/app/teverett/krepl?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=teverett/krepl&amp;utm_campaign=Badge_Grade)
[![DepShield Badge](https://depshield.sonatype.org/badges/teverett/krepl/depshield.svg)](https://depshield.github.io)

K-REPL
===

K-REPL is a simple framework for building command-line REPLs in Java

Maven coordinates
---

```
<groupId>com.khubla.krepl</groupId>
<artifactId>krepl</artifactId>
<version>1.2.0</version>
<packaging>jar</packaging>
```

Adding Commands
---

To add a command, simply implement a class which extends `AbstractCommandImpl`.  K-Repl will automatically find the class and add the command to the REPL.

Running the REPL
---

Simply instantiate the REPL class and call the method `repl()`

```
REPL repl = new REPL();
repl.repl();
```

It is possible to pass command strings directly to the repl via the `REPL.executeCommmandString()` API.

