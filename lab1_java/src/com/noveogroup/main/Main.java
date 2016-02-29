package com.noveogroup.main;

import com.noveogroup.algorithm.BubleSort;
import com.noveogroup.algorithm.QuickSort;
import com.noveogroup.device.Device;
import com.noveogroup.device.Laptop;
import com.noveogroup.device.Phone;
import com.noveogroup.device.Tablet;

public class Main {

    public static void main(String[] args) {
        //You can check your algorithms here.

        Device[] devices = new Device[3];
        devices[0] = new Phone(36000, "Motorolla");
        devices[1] = new Laptop(54000, "ASUS X202E");
        devices[2] = new Tablet(17000, "Samsung z250");

        System.out.println("\nbefore");
        showArrayDevice(devices);

        BubleSort bSort = new BubleSort();
        bSort.sort(devices, true);

        System.out.println("\nafter - 1");
        showArrayDevice(devices);

//        InsertSort insertSort = new InsertSort();
//        insertSort.sort(devices, false);
        QuickSort quickSort = new QuickSort();
        quickSort.sort(devices, false);


        System.out.println("\nafter - 2");
        showArrayDevice(devices);

        quickSort.sort(devices, true);

        System.out.println("\nafter - 3");
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
