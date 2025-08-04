package eu.oberon.oss.serz.io.writer;

import eu.oberon.oss.serz.defs.SerzDataStructure;
import eu.oberon.oss.serz.io.SerzIOException;

/**
 * Defines the contract for classes that provide services to write SERZ data structures as XML or binary files.
 *
 * @param <S> The class of the Serz data instance to be written
 * @param <O> Represents the target to output/write the data to.
 *
 * @author TigerLilly64
 * @since 1.0.0
 */
public interface SerzWriter<S extends SerzDataStructure, O> {
    /**
     * Writes the data object as XML data to the output target
     *
     * @param serzDataStructure Data structure to write
     * @param outputTarget      The target to write the data.
     *
     * @throws SerzIOException If any error occurred while writing.
     * @since 1.0.0
     */
    void writeXmlFile(S serzDataStructure, O outputTarget);

    /**
     * Writes the data structure as a binary SERZ data file.
     *
     * @param serzDataStructure Data structure to write
     * @param outputTarget      The target to write the data.
     *
     * @throws SerzIOException If any error occurred while writing.
     * @since 1.0.0
     */
    void readFromBinFile(S serzDataStructure, O outputTarget);
}
