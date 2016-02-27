package com.noveogroup.tree;

import com.noveogroup.exception.DuplicateKeyException;
import com.noveogroup.exception.NotFoundElementToTreeException;
import com.noveogroup.exception.ReadingFromFileException;
import com.noveogroup.exception.WritingToFileException;
import com.noveogroup.model.TreeElement;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;


/**
 * Sample implementation.
 */
public class BinaryTreeImpl<K extends Comparable, V extends TreeElement> implements BinaryTree<K, V>, Serializable {

    private Node root;
    private int size;

    private class Node implements Serializable {
        K key;
        V value;
        Node left;
        Node right;

        public Node(K key, V element) {
            this.key = key;
            this.value = element;
            left = null;
            right = null;
        }
    }

    public BinaryTreeImpl() {
        this.root = null;
        this.size = 0;
    }

    public BinaryTreeImpl(K key, V element) {
        if (key == null || element == null) {
            root = null;
            size = 0;
        } else {
            root = new Node(key, element);
            size++;
        }
    }

    @Override
    public void addElement(K key, V element) throws DuplicateKeyException {
        if (key == null || element == null) {
            return;
        }
        size++;
        Node newNode = new Node(key, element);
        if (root == null) {
            root = newNode;
        } else {
            Node rootNode = root;
            Node parent = null;

            while (true) {
                parent = rootNode;

                if (key.compareTo(rootNode.key) == -1) {
                    rootNode = rootNode.left;
                    if (rootNode == null) {
                        parent.left = newNode;
                        return;
                    }
                } else if (key.compareTo(rootNode.key) == 1) {
                    rootNode = rootNode.right;
                    if (rootNode == null) {
                        parent.right = newNode;
                        return;
                    }
                } else {
                    throw new DuplicateKeyException(key.toString());
                }
            }
        }
    }

    
    @Override
    public void removeElement(K key) throws NotFoundElementToTreeException {
        if (key == null) {
            return;
        }
        if (root == null) {
            return;
        }
        Node node = root;
        Node parent = null;

        while (node != null) {
            if (key.compareTo(node.key) == 0) {
                break;
            } else {
                parent = node;
                node = (key.compareTo(node.key) == -1) ? node.left : node.right;
            }
        }

        if (node == null) {
            throw new NotFoundElementToTreeException(key.toString());
        }

        if (node.right == null) {
            if (parent == null) {
                root = node.left;
            } else {
                if (node == parent.left) {
                    parent.left = node.left;
                } else {
                    parent.right = node.left;
                }
            }
        } else {
            Node left = node.right;
            parent = null;

            while (left.left != null) {
                parent = left;
                left = left.left;
            }

            if (parent != null) {
                parent.left = left.right;
            } else {
                node.right = left.right;
            }
            node.key = left.key;
        }
        size--;
    }

    private class IteratorImpl implements Iterator<V> {
        LinkedList<V> array = new LinkedList<V>();

        public IteratorImpl() {
            addAllArray(root);
        }

        private void addAllArray(Node node) {
            if (node == null) {
                return;
            }
            array.addLast(node.value);
            addAllArray(node.left);
            addAllArray(node.right);
        }

        @Override
        public boolean hasNext() {
            return array.size() > 0;
        }

        @Override
        public V next() {
            return array.removeFirst();
        }

        @Override
        public void remove() {
            array.remove();
        }

    }

    @Override
    public Iterator<V> getIterator() {
        return new IteratorImpl();
    }

    public void writeToFile(File file) throws WritingToFileException {
        if (file == null) {
            return;
        }
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
            outputStream.writeObject(size);
            writeToFileTree(outputStream, root);
            outputStream.close();
            System.out.println("\n Tree complete writed to file, " + size + " - node writed\n");
        } catch (IOException e) {
            throw new WritingToFileException(e.getMessage());
        }
    }

    private void writeToFileTree(ObjectOutputStream outputStream, Node node) throws IOException {
        if (node == null) {
            return;
        }
        outputStream.writeObject(node);
        writeToFileTree(outputStream, node.left);
        writeToFileTree(outputStream, node.right);
        return;
    }

    public void readFromFile(File file) throws ReadingFromFileException, DuplicateKeyException {
        if (file == null || !file.exists()) {
            return;
        }
        LinkedList<K> list = new LinkedList<K>();
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
            int sizeT = (Integer) inputStream.readObject();
            Node node;

            for (int i = 0; i < sizeT; i++) {
                node = (Node) inputStream.readObject();
                list.add(node.key);
                try {
                    addElement(node.key, node.value);
                } catch (DuplicateKeyException e) {
                    System.out.println("Element " + e.getMessage() + " duplicated !!!");
                }
            }
            inputStream.close();
            System.out.println("\n Tree readed from file, " + sizeT + " - node readed\n");
        } catch (IOException e) {
            throw new ReadingFromFileException(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
