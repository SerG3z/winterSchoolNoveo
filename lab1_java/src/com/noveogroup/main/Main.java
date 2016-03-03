package com.noveogroup.main;

import com.noveogroup.algorithm.BubleSort;
import com.noveogroup.algorithm.InsertSort;
import com.noveogroup.algorithm.QuickSort;
import com.noveogroup.device.Device;
import com.noveogroup.device.Laptop;
import com.noveogroup.device.Phone;
import com.noveogroup.device.Tablet;

public class Main {

    public static void main(String[] args) {
        //You can check your algorithms here.

        Device[] devices = new Device[4];
        devices[0] = new Phone(36000, "Motorolla");
        devices[1] = new Laptop(54000, "ASUS X202E");
        devices[2] = new Tablet(17000, "Samsung z250");
        devices[3] = new Phone(95444, "LG Google Nexus 5X");

        System.out.println("\nbefore");
        showArrayDevice(devices);

        BubleSort bSort = new BubleSort();
        bSort.sort(devices, true);

        System.out.println("\nafter bublesort ");
        showArrayDevice(devices);

        InsertSort insertSort = new InsertSort();
        insertSort.sort(devices, false);


        System.out.println("\nafter - insertionsort");
        showArrayDevice(devices);

        QuickSort quickSort = new QuickSort();
        quickSort.sort(devices, true);

        System.out.println("\nafter - quicksort");
        showArrayDevice(devices);

    }

    public static void showArrayDevice(Device[] devices) {
        if (devices == null) {
            return;
        }
        for (int i = 0; i < devices.length; i++) {
            System.out.println("name = " + devices[i].getName());
            System.out.println("price = " + devices[i].getPrice());
        }
    }

}
