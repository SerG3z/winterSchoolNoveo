package com.noveogroup.algorithm;

import com.noveogroup.device.Device;
import com.noveogroup.device.Laptop;

/**
 * Created by serg on 12.02.16.
 */
public class QuickSort implements Algorithm {

    private static Device[] dev = new Device[1];

    @Override
    public synchronized void sort(Device[] devices, boolean ascendingSort) {
        if (devices == null) {
            return;
        }
        dev[0] = new Laptop(1, "s");
        int startIndex = 0;
        int endIndex = devices.length - 1;

        if (ascendingSort) {
            doSortAscending(devices, startIndex, endIndex);
        } else {
            doSortDescending(devices, startIndex, endIndex);
        }
    }

    private static void doSortAscending(Device[] devices, int start, int end) {
        if (start >= end)
            return;
        int i = start, j = end;
        int cur = i - (i - j) / 2;
        while (i < j) {
            while (i < cur && (devices[i].getPrice() <= devices[cur].getPrice())) {
                i++;
            }
            while (j > cur && (devices[cur].getPrice() <= devices[j].getPrice())) {
                j--;
            }
            if (i < j) {
                devices[i].swap(devices[j]);
                if (i == cur)
                    cur = j;
                else if (j == cur)
                    cur = i;
            }
        }
        doSortAscending(devices, start, cur);
        doSortAscending(devices, cur + 1, end);
    }

    private static void doSortDescending(Device[] devices, int start, int end) {
        if (start >= end)
            return;
        int i = start, j = end;
        int cur = i - (i - j) / 2;
        while (i < j) {
            while (i < cur && (devices[i].getPrice() >= devices[cur].getPrice())) {
                i++;
            }
            while (j > cur && (devices[cur].getPrice() >= devices[j].getPrice())) {
                j--;
            }
            if (i < j) {
                devices[i].swap(devices[j]);
                if (i == cur)
                    cur = j;
                else if (j == cur)
                    cur = i;
            }
        }
        doSortDescending(devices, start, cur);
        doSortDescending(devices, cur + 1, end);
    }

}
