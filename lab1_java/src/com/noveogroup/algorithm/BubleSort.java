package com.noveogroup.algorithm;

import com.noveogroup.device.Device;

/**
 * Created by serg on 12.02.16.
 */
public class BubleSort implements Algorithm {

    @Override
    public void sort(Device[] devices, boolean ascendingSort) {
        if (devices == null) {
            return;
        }
        boolean swapped = true;
        int j = 0;

        if (ascendingSort) {
            while (swapped) {
                swapped = false;
                j++;
                for (int i = 0; i < devices.length - j; i++) {
                    if (devices[i].getPrice() > devices[i + 1].getPrice()) {
                        devices[i].swap(devices[i + 1]);
                        swapped = true;
                    }
                }
            }
        }
        else {
            while (swapped) {
                swapped = false;
                j++;
                for (int i = 0; i < devices.length - j; i++) {
                    if (devices[i].getPrice() < devices[i + 1].getPrice()) {
                        devices[i].swap(devices[i + 1]);
                        swapped = true;
                    }
                }
            }
        }
    }
}
