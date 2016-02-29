package com.noveogroup.algorithm;

import com.noveogroup.device.Device;

/**
 * This interface represents sorting algorithm.
 */
public interface Algorithm {

    /**
     * Sorts <code>devices</code> by price.
     * @param devices array of devices.
     * @param ascendingSort true for ascending sort, false for descending sort.
     */
    void sort(Device[] devices, boolean ascendingSort);

}
