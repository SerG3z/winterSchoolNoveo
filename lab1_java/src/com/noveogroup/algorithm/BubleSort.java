package com.noveogroup.algorithm;

import com.noveogroup.device.Device;

/**
 * Created by serg on 12.02.16.
 */
public class BubleSort implements Algorithm {

    @Override
    public synchronized void sort(Device[] devices, boolean ascendingSort) {
        if (devices == null) {
            return;
        }
        boolean swapped = true;
        int j = 0;
        Device tmp;

        if (ascendingSort) {
            while (swapped) {
                swapped = false;
                j++;
                for (int i = 0; i < devices.length - j; i++) {
                    if (devices[i].getPrice() > devices[i + 1].getPrice()) {
                        tmp = devices[i];
                        devices[i] = devices[i + 1];
                        devices[i + 1] = tmp;
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
                        tmp = devices[i];
                        devices[i] = devices[i + 1];
                        devices[i + 1] = tmp;
                        swapped = true;
                    }
                }
            }
        }
    }
}
