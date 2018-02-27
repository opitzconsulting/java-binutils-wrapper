package com.opitzconsulting.binutils.elf;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

import nl.lxtreme.binutils.elf.DynamicEntry;
import nl.lxtreme.binutils.elf.SectionType;
import nl.lxtreme.binutils.elf.SegmentType;

class ElfWrapper implements Elf {

    private nl.lxtreme.binutils.elf.Elf elf;

    public ElfWrapper(nl.lxtreme.binutils.elf.Elf elf) {
        this.elf = elf;
    }

    @Override
    public void close() throws IOException {
        elf.close();

    }

    @Override
    public FileHeader getFileHeader() {
        return new FileHeaderWrapper(elf.header);
    }

    @Override
    public Collection<DynamicEntry> getDynamicEntrys() {
        return Arrays.asList(elf.dynamicTable);
    }

    @Override
    public Collection<SectionHeader> getSectionHeaders() {
        Collection<SectionHeader> sectionHeaders = new ArrayList<>();
        for (final nl.lxtreme.binutils.elf.SectionHeader sectionHeader : elf.sectionHeaders) {
            sectionHeaders.add(new SectionHeaderWrapper(sectionHeader));
        }
        return sectionHeaders;
    }

    @Override
    public Collection<SegmentHeader> getSegmentHeaders() {
        Collection<SegmentHeader> segmentHeaders = new ArrayList<>();
        for (final nl.lxtreme.binutils.elf.ProgramHeader programHeader : elf.programHeaders) {
            segmentHeaders.add(new SegmentHeaderWrapper(programHeader));
        }
        return segmentHeaders;
    }

    @Override
    public SegmentHeader getSegmentHeaderByType(SegmentType type) {
        return new SegmentHeaderWrapper(elf.getProgramHeaderByType(type));
    }

    @Override
    public String getProgramInterpreter() throws IOException {
        return elf.getProgramInterpreter();
    }

    @Override
    public ByteBuffer getSection(SectionHeader shdr) throws IOException {
        return elf.getSection(Stream.of(elf.sectionHeaders)
                .filter(sh -> sh.type.equals(shdr.getType())
                        && sh.fileOffset == shdr.getFileOffset()
                        && sh.size == shdr.getSize())
                .findFirst()
                .orElse(null));
    }

    @Override
    public SectionHeader getSectionHeaderByType(SectionType type) {
        return new SectionHeaderWrapper(elf.getSectionHeaderByType(type));
    }

    @Override
    public ByteBuffer getSegment(SegmentHeader phdr) throws IOException {
        return elf.getSegment(Stream.of(elf.programHeaders)
                .filter(ph -> ph.type.equals(phdr.getType())
                        && ph.offset == phdr.getOffset()
                        && ph.segmentFileSize == phdr.getSegmentFileSize())
                .findFirst()
                .orElse(null));
    }

    @Override
    public Collection<String> getSharedDependencies() throws IOException {
        return elf.getSharedDependencies();
    }

}
