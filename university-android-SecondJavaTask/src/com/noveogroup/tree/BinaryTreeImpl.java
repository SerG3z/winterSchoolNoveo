package com.noveogroup.tree;

import java.util.Iterator;


/**
 * Sample implementation.
 */
public class BinaryTreeImpl<K, V> implements BinaryTree<K, V> {

    Node root;

    class Node implements Comparable<K> {
        K key;
        V value;
        Node left;
        Node right;

        public Node(K key, V element) {
            this.key = key;
            this.value = element;
        }

        @Override
        public String toString() {
            return "key = " + key + ", value =  " + value;
        }

        @Override
        public int compareTo(K o) {
            K tmpKey = o;
            if ((Integer) this.key < (Integer) tmpKey) {
                return -1;
            } else if ((Integer) this.key > (Integer) tmpKey) {
                return 1;
            }
            return 0;
        }

    }

    @Override
    public void addElement(K key, V element) {
        Node newNode = new Node(key, element);
        if (root == null) {
            root = newNode;
        } else {
            Node rootNode = root;

            Node parent;

            while (true) {
                parent = rootNode;

                if (this.root.compareTo(rootNode.key) == 1) {
                    rootNode = rootNode.left;
                    if (rootNode == null) {
                        parent.left = newNode;
                        return;
                    }
                } else if (this.root.compareTo(rootNode.key) == -1) {
                    rootNode = rootNode.right;
                    if (rootNode == null) {
                        parent.right = newNode;
                        return;
                    }
                } else {
                    System.out.println("такой ключ уже есть");
                    return;
                }
            }
        }
    }

    private Node getLastHouseOnTheLeft(final Node start) {
        Node candidate = null;
        Node parent = null;
        Node node = start;

        while (node != null) {
            if (node.left != null) {
                parent = node;
                candidate = node.left;
            }
            node = node.left;
        }

        if (parent != null) {
            parent.left = null;
        }

        return candidate;
    }


    @Override
    public void removeElement(K key) {
        if (root == null) {
            return;
        }
        Node rootNode = root;
        Node deleteNode = null;
        Node parent = null;
        while (true) {
            if (this.root.compareTo(key) == 1) {
                parent = rootNode;
                rootNode = rootNode.left;
            } else if (this.root.compareTo(key) == -1) {
                parent = rootNode;
                rootNode = rootNode.right;
            } else {
                deleteNode = rootNode;
                break;
            }
        }
        if (deleteNode == null) {
            return;
        }

        boolean isLeft = (deleteNode == parent.left);

        if (deleteNode == root) {
            rootNode = getLastHouseOnTheLeft(parent.right);
            if (rootNode != null) {
                rootNode.left = parent.left;
                rootNode.right = parent.right;
                root = rootNode;
            }
        } else if (deleteNode.left == null && deleteNode.right == null) {
            if (isLeft) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else if (deleteNode.left != null && deleteNode.right != null) //two children, some shuffling
        {
            if (isLeft) {
                parent.left = deleteNode.right;
                parent.left.left = deleteNode.left;
            } else {
                parent.right = deleteNode.right;
                parent.right.left = deleteNode.left;
            }
        } else {
            if (deleteNode.left == null) {
                if (isLeft) {
                    parent.left = deleteNode.left;
                } else {
                    parent.right = deleteNode.left;
                }
            } else {
                if (isLeft) {
                    parent.left = deleteNode.right;
                } else {
                    parent.right = deleteNode.right;
                }
            }
        }
    }

    @Override
    public Iterator<V> getIterator() {
        //TODO
        return null;
    }


}
