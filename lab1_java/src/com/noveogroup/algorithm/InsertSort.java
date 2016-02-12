package com.noveogroup.algorithm;

import com.noveogroup.device.Device;

/**
 * Created by serg on 12.02.16.
 */
public class InsertSort implements Algorithm {

    @Override
    public synchronized void sort(Device[] devices, boolean ascendingSort) {
        if (devices == null) {
            return;
        }
        if (ascendingSort) {
            for (int i = 1; i < devices.length; i++) {
                Device tmp = devices[i];
                int prevKey = i - 1;
                while (prevKey >= 0 && devices[prevKey].getPrice() > tmp.getPrice()) {
                    devices[prevKey + 1] = devices[prevKey];
                    devices[prevKey] = tmp;
                    prevKey--;
                }
            }
        } else {
            for (int i = 1; i < devices.length; i++) {
                Device tmp = devices[i];
                int prevKey = i - 1;
                while (prevKey >= 0 && devices[prevKey].getPrice() < tmp.getPrice()) {
                    devices[prevKey + 1] = devices[prevKey];
                    devices[prevKey] = tmp;
                    prevKey--;
                }
            }
        }
    }
}
