# java-binutils-wrapper

The [Java BinUtils](https://github.com/jawi/java-binutils) is a useful collection or readers for various binary container formats.

Unfortunately the original projects design makes it hard to decouple it from your own code (e.g. for unit testing your own code). 

This project provides a "dump" decoupling layer (almost) only delegating to the original objects from the `java-binutils` library. 
Therefore this code is "too simple to fail" and does not need unit tests of its own.

Currently we only need process ELF files in our own projects.
Therefore ELF is the only file type supported so far.
Other types may follow.


## external requirements

You must checkout and  build the [Java BinUtils](https://github.com/jawi/java-binutils) separately and provide the jar in the classpath of this project.

There is a [PullRequest](https://github.com/jawi/java-binutils/pull/1) for the `Java BinUtils` project turning it into a `maven` project of its own which might ease this step.

## License

This implementation is released under the Apache License v2.

Copyright (C) 2018, OPITZ CONSULTING

## Authors

This version is created and maintained by Thomas Papendieck @ OPITZ CONSULTING.

## Contribution

If you find a bug or want to contribute otherwise (e.g.: add support for other file type) feel free to fork and file a pull-request.

