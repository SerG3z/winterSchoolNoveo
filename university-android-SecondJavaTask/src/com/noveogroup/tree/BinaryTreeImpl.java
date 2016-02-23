package com.noveogroup.tree;

import com.noveogroup.model.TreeElement;

import java.util.Iterator;
import java.util.LinkedList;


/**
 * Sample implementation.
 */
public class BinaryTreeImpl<K extends Comparable, V extends TreeElement> implements BinaryTree<K, V> {

    private Node root;
    private int size;

    private class Node  {
        private Object key;
        private Object value;
        Node left;
        Node right;

        public Node(K key, V element) {
            this.key = key;
            this.value = element;
            left = null;
            right = null;
        }

        @Override
        public String toString() {
            return "key = " + key + ", value =  " + value;
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
    public void addElement(K key, V element) {
        if (key == null || element == null) {
            return;
        }

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

    private void leftMissingRightMissing(K key, Node node, Node parent) {
        if (parent == null) {
            root = null;
        } else {
            if (key.compareTo(parent.key) == -1) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
    }

    private void leftExistRightExist(K key, Node node, Node parent) {
        Node tmp = node.right;
        Node p = node;

        while (tmp.left != null) {
            p = tmp;
            tmp = tmp.left;
        }
        if (p != node) {
            p.left = tmp.right;
        } else {
            p.right = tmp.right;
        }

        tmp.left = node.left;
        tmp.right = node.right;

        if (parent == null) {
            root = tmp;
        } else {
            if (key.compareTo(parent.key) == -1) {
                parent.left = tmp;
            } else {
                parent.right = tmp;
            }
        }
    }

    private void leftMissingRightExist(K key, Node node, Node parent) {
        if (parent == null) {
            root = node.left;
        } else {
            if (key.compareTo(parent.key) == -1) {
                parent.left = node.right;
            } else {
                parent.right = node.right;
            }
        }
    }

    private void leftExistRightMissing(K key, Node node, Node parent) {
        if (parent == null) {
            root = null;
        } else {
            if (key.compareTo(parent.key) == -1) {
                parent.left = node.left;
            } else {
                parent.right = node.left;
            }
        }
    }

    @Override
    public void removeElement(K key) {
        if (key == null) {
            return;
        }
        if (root == null) {
            return;
        }
        Node rootNode = root;
        Node deleteNode = null;
        Node parent = null;

        while (rootNode != null) {
            if (key.compareTo(rootNode.key) == 0) {
                size--;
                if (rootNode.left != null && rootNode.right != null) {
                    leftExistRightExist(key,rootNode, parent);
                }
                if (rootNode.left != null && rootNode.right == null) {
                    leftExistRightMissing(key,rootNode, parent);
                }
                if (rootNode.left == null && rootNode.right != null) {
                    leftMissingRightExist(key, rootNode, parent);
                }
                if (rootNode.left == null && rootNode.right == null) {
                    leftMissingRightMissing(key,rootNode, parent);
                }
            } else {
                parent = rootNode;
                rootNode = (key.compareTo(rootNode.key) == -1) ? rootNode.left : rootNode.right;
            }
        }

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
            array.addLast((V)node.value);
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


}
