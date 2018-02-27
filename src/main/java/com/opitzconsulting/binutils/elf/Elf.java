package com.opitzconsulting.binutils.elf;

import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Collection;

import nl.lxtreme.binutils.elf.AbiType;
import nl.lxtreme.binutils.elf.DynamicEntry;
import nl.lxtreme.binutils.elf.ElfClass;
import nl.lxtreme.binutils.elf.MachineType;
import nl.lxtreme.binutils.elf.ObjectFileType;
import nl.lxtreme.binutils.elf.SectionType;
import nl.lxtreme.binutils.elf.SegmentType;

public interface Elf extends Closeable, AutoCloseable {
    public interface FileHeader {

        long getSectionHeaderOffset();

        long getSegmentHeaderOffset();

        int getFlags();

        long getEntryPoint();

        int getElfVersion();

        MachineType getMachineType();

        ObjectFileType getElfType();

        int getAbiVersion();

        AbiType getAbiType();

        ByteOrder getElfByteOrder();

        ElfClass getElfClass();

        boolean is32bit();

        boolean is64bit();

        boolean isBigEndian();

        boolean isLittleEndian();

    }

    public interface SectionHeader {

        String getName();

        SectionType getType();

        long getFlags();

        long getVirtualAddress();

        long getFileOffset();

        long getSize();

        int getLink();

        int getInfo();

        long getSectionAlignment();

        long getEntrySize();
    }

    public interface SegmentHeader {

        SegmentType getType();

        long getFlags();

        long getOffset();

        long getVirtualAddress();

        long getPhysicalAddress();

        long getSegmentFileSize();

        long getSegmentMemorySize();

        long getSegmentAlignment();
    }

    FileHeader getFileHeader();

    Collection<DynamicEntry> getDynamicEntrys();

    Collection<SectionHeader> getSectionHeaders();

    Collection<SegmentHeader> getSegmentHeaders();

    SegmentHeader getSegmentHeaderByType(SegmentType type);

    String getProgramInterpreter() throws IOException;

    ByteBuffer getSection(SectionHeader shdr) throws IOException;

    SectionHeader getSectionHeaderByType(SectionType type);

    ByteBuffer getSegment(SegmentHeader phdr) throws IOException;

    Collection<String> getSharedDependencies() throws IOException;

}
