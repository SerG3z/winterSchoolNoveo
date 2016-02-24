package com.noveogroup.main;

import com.noveogroup.exception.BinaryTreeException;
import com.noveogroup.exception.IOStreamBinaryTreeException;
import com.noveogroup.model.AndroidPlatform;
import com.noveogroup.model.IosPlatform;
import com.noveogroup.model.Phone;
import com.noveogroup.model.TreeElement;
import com.noveogroup.tree.BinaryTree;
import com.noveogroup.tree.BinaryTreeImpl;

import java.io.File;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws BinaryTreeException, IOStreamBinaryTreeException {
        //You can check your implementation here.
        //For example:

        //create BinaryTree
        BinaryTree<Integer, TreeElement> tree = new BinaryTreeImpl<Integer, TreeElement>();
        try {
            //add element
            tree.addElement(10, new Phone("Nokia 3310", 2312));
            tree.addElement(12, new AndroidPlatform("Nexus 5", 3213));
            tree.addElement(2, new IosPlatform("iphone 5s", 3121));
            tree.addElement(4, new Phone("kirpi4 42", 4343));
            tree.addElement(8, new Phone("alcatel 2", 434234));
            tree.addElement(17, new AndroidPlatform("Red note 3", 43422));
            tree.addElement(21, new IosPlatform("iphone 6 plus", 1312));
            tree.addElement(89, new AndroidPlatform("Galaxy S7", 324234));
            tree.addElement(-1, new Phone("motorolla 3300", 75756));

            tree.removeElement(89);

            Iterator<TreeElement> iterator = tree.getIterator();
            while (iterator.hasNext()) {
                TreeElement next = iterator.next();
                System.out.println(next.getName());
            }
        } catch (BinaryTreeException e) {
            throw new BinaryTreeException(e.getMessage());
        }

        File file = new File("BinaryTree");
        BinaryTreeImpl<Integer, TreeElement> treeFile = (BinaryTreeImpl<Integer, TreeElement>) tree;
        BinaryTreeImpl<Integer, TreeElement> treeFile2 = null;
        try {
            treeFile.writeToFile(file);
            treeFile2 = new BinaryTreeImpl<Integer, TreeElement>();
            treeFile2.readFromFile(file);
        } catch (IOStreamBinaryTreeException e) {
            throw new IOStreamBinaryTreeException(e.getMessage());
        }
        Iterator<TreeElement> iter = treeFile2.getIterator();
        while (iter.hasNext()) {
            TreeElement next = iter.next();
            System.out.println(next.getName());
        }
    }
}
