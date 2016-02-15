package com.noveogroup.main;

import com.noveogroup.exception.BinaryTreeException;
import com.noveogroup.model.ElementForExample;
import com.noveogroup.model.TreeElement;
import com.noveogroup.tree.BinaryTree;
import com.noveogroup.tree.BinaryTreeImpl;

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
            //remove element
            tree.removeElement(10);
            //get iterator
            Iterator<TreeElement> iterator = tree.getIterator();
            while (iterator.hasNext()) {
                TreeElement next = iterator.next();
                System.out.println(next.getId());
            }
        } catch (BinaryTreeException e) {
            //handle the exception
        }
    }
}
