K-REPL
===

K-REPL is a simple framework for building command-line REPLs in Java


Adding Commands
---

To add a command, simply implement a class which extends `AbstractCommandImpl`.  KRepl will automatically find the class and add the command to the REPL.

Running the REPL
---

Simply instantiate the REPL class and call the method `repl()`

<pre>
REPL repl = new REPL();
repl.repl();
</pre>

It is possible to pass command strings directly to the repl via the `REPL.executeCommmandString()` API.

