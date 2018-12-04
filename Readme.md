[![Travis](https://travis-ci.org/teverett/krepl.svg?branch=master)](https://travis-ci.org/teverett/krepl)
[![DepShield Badge](https://depshield.sonatype.org/badges/teverett/krepl/depshield.svg)](https://depshield.github.io)

K-REPL
===

K-REPL is a simple framework for building command-line REPLs in Java

Maven coordinates
---

```
<groupId>com.khubla.krepl</groupId>
<artifactId>krepl</artifactId>
<version>1.0</version>
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

