/*
 * Copyright (C) 2018 Heinrich-Heine-Universitaet Duesseldorf, Institute of Computer Science,
 * Department Operating Systems
 *
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public
 * License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

//package de.hhu.bsinfo.dxmem.data;
package de.hhu.bsinfo.dxapp;

import java.security.InvalidParameterException;

import de.hhu.bsinfo.dxutils.serialization.Exporter;
import de.hhu.bsinfo.dxutils.serialization.Importer;

import de.hhu.bsinfo.dxmem.data.AbstractChunk;
/**
 * Implementation of a chunk based on a generic byte array
 *
 * @author Stefan Nothaas, stefan.nothaas@hhu.de, 31.03.2017
 */
public final class TestObject extends AbstractChunk {
    private String name;
    private int size;

    /**
     * Constructor
     */
    public TestObject(String Name, int Size){
        super();
        this.name = Name;
        this.size = Size;
    }

    /**
     * Get the size of the data
     *
     * @return Data size in bytes
     */
    public int getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    public int getNameLength() {
        return name.length();
    }


    @Override
    public void importObject(final Importer p_importer) {
        p_importer.readString(name);
    }

    @Override
    public void exportObject(final Exporter p_exporter) {
        p_exporter.writeString(name);
    }

    @Override
    public int sizeofObject() {
        return name.length();
    }
}
