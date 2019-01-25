package com.opitzconsulting.binutils.elf;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class ElfParser {
    public Elf parse(Path elfFilePath) throws IOException {
        return new ElfWrapper(new nl.lxtreme.binutils.elf.Elf(FileChannel.open(elfFilePath, StandardOpenOption.READ)));
    }

    public Elf parse(FileChannel channel) throws IOException {
        return new ElfWrapper(new nl.lxtreme.binutils.elf.Elf(channel));
    }
}
