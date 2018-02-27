package com.opitzconsulting.binutils.elf;

import com.opitzconsulting.binutils.elf.Elf.SegmentHeader;

import nl.lxtreme.binutils.elf.ProgramHeader;
import nl.lxtreme.binutils.elf.SegmentType;

class SegmentHeaderWrapper implements SegmentHeader {
    private final ProgramHeader programHeader;

    SegmentHeaderWrapper(ProgramHeader programHeader) {
        this.programHeader = programHeader;
    }

    @Override
    public long getVirtualAddress() {
        return programHeader.virtualAddress;
    }

    @Override
    public SegmentType getType() {
        return programHeader.type;
    }

    @Override
    public long getSegmentMemorySize() {
        return programHeader.segmentMemorySize;
    }

    @Override
    public long getSegmentFileSize() {
        return programHeader.segmentFileSize;
    }

    @Override
    public long getSegmentAlignment() {
        return programHeader.segmentAlignment;
    }

    @Override
    public long getPhysicalAddress() {
        return programHeader.physicalAddress;
    }

    @Override
    public long getOffset() {
        return programHeader.offset;
    }

    @Override
    public long getFlags() {
        return programHeader.flags;
    }
}