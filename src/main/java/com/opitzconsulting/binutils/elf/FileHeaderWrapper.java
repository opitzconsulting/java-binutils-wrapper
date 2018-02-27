package com.opitzconsulting.binutils.elf;

import java.nio.ByteOrder;

import com.opitzconsulting.binutils.elf.Elf.FileHeader;

import nl.lxtreme.binutils.elf.AbiType;
import nl.lxtreme.binutils.elf.ElfClass;
import nl.lxtreme.binutils.elf.Header;
import nl.lxtreme.binutils.elf.MachineType;
import nl.lxtreme.binutils.elf.ObjectFileType;

class FileHeaderWrapper implements FileHeader {
    private final Header _header;

    FileHeaderWrapper(Header header) {
        _header = header;
    }

    @Override
    public boolean isLittleEndian() {
        return _header.isLittleEndian();
    }

    @Override
    public boolean isBigEndian() {
        return _header.isBigEndian();
    }

    @Override
    public boolean is64bit() {
        return _header.is64bit();
    }

    @Override
    public boolean is32bit() {
        return _header.is32bit();
    }

    @Override
    public long getSectionHeaderOffset() {
        return _header.sectionHeaderOffset;
    }

    @Override
    public long getSegmentHeaderOffset() {
        return _header.programHeaderOffset;
    }

    @Override
    public MachineType getMachineType() {
        return _header.machineType;
    }

    @Override
    public int getFlags() {
        return _header.flags;
    }

    @Override
    public long getEntryPoint() {
        return _header.entryPoint;
    }

    @Override
    public int getElfVersion() {
        return _header.elfVersion;
    }

    @Override
    public ObjectFileType getElfType() {
        return _header.elfType;
    }

    @Override
    public ElfClass getElfClass() {
        return _header.elfClass;
    }

    @Override
    public ByteOrder getElfByteOrder() {
        return _header.elfByteOrder;
    }

    @Override
    public int getAbiVersion() {
        return _header.abiVersion;
    }

    @Override
    public AbiType getAbiType() {
        return _header.abiType;
    }
}