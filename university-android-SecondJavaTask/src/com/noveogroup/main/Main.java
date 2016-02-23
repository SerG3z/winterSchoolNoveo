package com.noveogroup.main;

import com.noveogroup.exception.BinaryTreeException;
import com.noveogroup.exception.WritingToFileException;
import com.noveogroup.model.ElementForExample;
import com.noveogroup.model.TreeElement;
import com.noveogroup.tree.BinaryTree;
import com.noveogroup.tree.BinaryTreeImpl;

import java.io.File;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        //You can check your implementation here.
        //For example:

        //create BinaryTree
        BinaryTree<Integer, TreeElement> tree = new BinaryTreeImpl<Integer, TreeElement>();
        try {
            //add element
            tree.addElement(10, new ElementForExample());
            tree.addElement(12, new ElementForExample());
            tree.addElement(2, new ElementForExample());
            tree.addElement(4, new ElementForExample());
            tree.addElement(8, new ElementForExample());
            tree.addElement(17, new ElementForExample());
            tree.addElement(21, new ElementForExample());
            tree.addElement(89, new ElementForExample());
            tree.addElement(-1, new ElementForExample());

//            tree.removeElement(1034324);

            Iterator<TreeElement> iterator = tree.getIterator();
            while (iterator.hasNext()) {
                TreeElement next = iterator.next();
                System.out.println(next.getId());
            }
        } catch (BinaryTreeException e) {
            //handle the exception
        }

        File file = new File("tree.txt");
        BinaryTreeImpl treeFile = (BinaryTreeImpl) tree;
        try {
            treeFile.writeToFile(file);
        } catch (WritingToFileException e) {
            e.printStackTrace();
        }
    }
}
