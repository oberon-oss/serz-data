package eu.oberon.oss.serz.defs;

/**
 * The data structure to hold SERZ data that was read.
 *
 * @author TigerLilly64
 * @since 1.0.0
 */
public interface SerzDataStructure {
    /**
     * Returns the version string
     *
     * @return The version string for the data represented in the structure.
     *
     * @since 1.0.0
     */
    String getSerzVersion();
}
