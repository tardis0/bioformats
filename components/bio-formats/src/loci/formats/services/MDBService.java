//
// MDBService.java
//

/*
OME Bio-Formats package for reading and converting biological file formats.
Copyright (C) 2005-@year@ UW-Madison LOCI and Glencoe Software, Inc.

This program is free software; you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation; either version 2 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
*/

package loci.formats.services;

import java.io.IOException;
import java.util.Vector;

import loci.common.services.Service;

/**
 * Interface defining methods for parsing MDB database files.
 *
 * <dl><dt><b>Source code:</b></dt>
 * <dd><a href="http://dev.loci.wisc.edu/trac/java/browser/trunk/components/bio-formats/src/loci/formats/services/MDBService.java">Trac</a>,
 * <a href="http://dev.loci.wisc.edu/svn/java/trunk/components/bio-format/src/loci/formats/services/MDBService.java">SVN</a></dd></dl>
 */
public interface MDBService extends Service {

  /**
   * Prepare the given .mdb file for reading.  This method must be called
   * before {@link #parseDatabase()}.
   *
   * @throws IOException if a problem occurs when opening the file
   */
  public void initialize(String filename) throws IOException;

  /**
   * Read all tables from a pre-initialized .mdb files.  Each Vector<String[]>
   * in the outer Vector represents a table; each String[] in a table represents
   * a row, and each element of the String[] represents the value of a
   * particular column within the row.
   *
   * The first row in each table contains the names for each column.
   * The first entry in the column name row is the name of the table.
   *
   * {@link #initialize(String)} must be called before calling parseDatabase().
   *
   * @throws IOException if there is a problem reading the table data
   */
  public Vector<Vector<String[]>> parseDatabase() throws IOException;

  /** Close the currently initialized file. */
  public void close();

}
