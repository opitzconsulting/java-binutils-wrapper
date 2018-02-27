package com.opitzconsulting.binutils.elf;

import com.opitzconsulting.binutils.elf.Elf.SectionHeader;

import nl.lxtreme.binutils.elf.SectionType;

class SectionHeaderWrapper implements SectionHeader {
    private final nl.lxtreme.binutils.elf.SectionHeader sectionHeader;

    SectionHeaderWrapper(nl.lxtreme.binutils.elf.SectionHeader sectionHeader) {
        this.sectionHeader = sectionHeader;
    }

    @Override
    public long getVirtualAddress() {
        return sectionHeader.virtualAddress;
    }

    @Override
    public SectionType getType() {
        return sectionHeader.type;
    }

    @Override
    public long getSize() {
        return sectionHeader.size;
    }

    @Override
    public long getSectionAlignment() {
        return sectionHeader.sectionAlignment;
    }

    @Override
    public String getName() {
        return sectionHeader.getName();
    }

    @Override
    public int getLink() {
        return sectionHeader.link;
    }

    @Override
    public int getInfo() {
        return sectionHeader.info;
    }

    @Override
    public long getFlags() {
        return sectionHeader.flags;
    }

    @Override
    public long getFileOffset() {
        return sectionHeader.fileOffset;
    }

    @Override
    public long getEntrySize() {
        return sectionHeader.entrySize;
    }
}