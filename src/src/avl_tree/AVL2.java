package avl_tree;

import java.util.NoSuchElementException;

/**
 * Your implementation of an AVL.
 */
public class AVL2<T extends Comparable<? super T>> {

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private AVLNode<T> root;
    private int size;

    /*
     * Do not add a constructor.
     */

    /**
     * Adds the element to the tree.
     *
     * Start by adding it as a leaf like in a regular BST and then rotate the
     * tree as necessary.
     *
     * If the data is already in the tree, then nothing should be done (the
     * duplicate shouldn't get added, and size should not be incremented).
     *
     * Remember to recalculate heights and balance factors while going back
     * up the tree after adding the element, making sure to rebalance if
     * necessary. This is as simple as calling the balance() method on the
     * current node, before returning it (assuming that your balance method
     * is written correctly from part 1 of this assignment).
     *
     * @param data The data to add.
     * @throws java.lang.IllegalArgumentException If data is null.
     */
    public void add(T data) {

        // Error Handling: Invalid data
        if (data == null) {
            throw new java.lang.IllegalArgumentException("Error: Provided data is null.");
        }

        root = rAdd(root, data);
    }

    private AVLNode<T> rAdd(AVLNode<T> currentNode, T data) {

        // Base case: Found position where to add data
        if (currentNode == null) {
            size++;
            return new AVLNode<T>(data);
        }

        // Current value is larger than data value, traverse to left node
        else if ((currentNode.getData().compareTo(data)) > 0) {
            currentNode.setLeft(rAdd(currentNode.getLeft(), data));
        }

        // Current value is smaller than data value, traverse to right node
        else if ((currentNode.getData().compareTo(data)) < 0) {
            currentNode.setRight(rAdd(currentNode.getRight(), data));
        }

        updateHeightAndBF(currentNode);
        return balance(currentNode);
    }

    /**
     * Removes and returns the element from the tree matching the given
     * parameter.
     *
     * There are 3 cases to consider:
     * 1: The node containing the data is a leaf (no children). In this case,
     *    simply remove it.
     * 2: The node containing the data has one child. In this case, simply
     *    replace it with its child.
     * 3: The node containing the data has 2 children. Use the successor to
     *    replace the data, NOT predecessor. As a reminder, rotations can occur
     *    after removing the successor node.
     *
     * Remember to recalculate heights and balance factors while going back
     * up the tree after removing the element, making sure to rebalance if
     * necessary. This is as simple as calling the balance() method on the
     * current node, before returning it (assuming that your balance method
     * is written correctly from part 1 of this assignment).
     *
     * Do NOT return the same data that was passed in. Return the data that
     * was stored in the tree.
     *
     * Hint: Should you use value equality or reference equality?
     *
     * @param data The data to remove.
     * @return The data that was removed.
     * @throws java.lang.IllegalArgumentException If the data is null.
     * @throws java.util.NoSuchElementException   If the data is not found.
     */
    public T remove(T data) {

        // Error Handling: Invalid data
        if (data == null) {
            throw new java.lang.IllegalArgumentException("Error: Provided data is null.");
        }

        // Error Handling: Empty tree
        if (size == 0) {
            throw new java.lang.IllegalArgumentException("Error: Empty tree.");
        }

        AVLNode<T> returnNode = new AVLNode<T>(null);

        root = rRemove(root, data, returnNode);

        return returnNode.getData();
    }

    private AVLNode<T> rRemove(AVLNode<T> currentNode, T data, AVLNode<T> returnData) {

        // Error Handling: Data doesn't exist in tree
        if (currentNode == null) {
            throw new NoSuchElementException("Error: Data does not exist in tree.");
        }

        // Current value is larger than data value, traverse to left node
        else if ((currentNode.getData().compareTo(data)) > 0) {
            currentNode.setLeft(rRemove(currentNode.getLeft(), data, returnData));
        }

        // Current value is smaller than data value, Add left
        else if ((currentNode.getData().compareTo(data)) < 0) {
            currentNode.setRight(rRemove(currentNode.getRight(), data, returnData));
        }

        // Base case: Found position of data value
        else if ((currentNode.getData().compareTo(data)) == 0) {
            size--;
            returnData.setData(currentNode.getData());

            // Case 1: Leaf Node
            if (currentNode.getLeft() == null && currentNode.getRight() == null) {
                return null;
            }

            // Case 2: One Child Node
            else if (currentNode.getLeft() != null && currentNode.getRight() == null) {
                return currentNode.getLeft();
            }

            else if (currentNode.getLeft() == null && currentNode.getRight() != null) {
                return currentNode.getRight();
            }

            // Case 3: Two Child Node - successor
            else {
                AVLNode<T> dummyNode = new AVLNode<T>(null);
                // Set right nodes
                currentNode.setRight(removeSuccessor(currentNode.getRight(), dummyNode));
                // Replace the current node's value with the successor value
                currentNode.setData(dummyNode.getData());
            }
        }

        updateHeightAndBF(currentNode);
        return balance(currentNode);
    }

    private AVLNode<T> removeSuccessor(AVLNode<T> currentNode, AVLNode<T> dummy) {

        // Base Case - Find last left node
        if (currentNode.getLeft() == null) {
            dummy.setData(currentNode.getData());
            // Removes the current node from the tree,
            // making the right child None or another subtree
            return currentNode.getRight();
        }

        else {
            // Add nodes
            currentNode.setLeft(removeSuccessor(currentNode.getLeft(), dummy));
        }

        updateHeightAndBF(currentNode);
        return balance(currentNode);
    }

    /**
     * Updates the height and balance factor of a node using its
     * setter methods.
     *
     * Recall that a null node has a height of -1. If a node is not
     * null, then the height of that node will be its height instance
     * data. The height of a node is the max of its left child's height
     * and right child's height, plus one.
     *
     * The balance factor of a node is the height of its left child
     * minus the height of its right child.
     *
     * This method should run in O(1).
     * You may assume that the passed in node is not null.
     *
     * This method should only be called in rotateLeft(), rotateRight(),
     * and balance().
     *
     * @param currentNode The node to update the height and balance factor of.
     */
    private void updateHeightAndBF(AVLNode<T> currentNode) {

        // Grab heights
        int leftHeight = (currentNode.getLeft() != null) ? currentNode.getLeft().getHeight() : -1;
        int rightHeight = (currentNode.getRight() != null) ? currentNode.getRight().getHeight() : -1;

        // Update height
        currentNode.setHeight(Math.max(leftHeight, rightHeight) + 1);

        // Update balance factor
        currentNode.setBalanceFactor(leftHeight - rightHeight);
    }

    /**
     * Method that rotates a current node to the left. After saving the
     * current's right node to a variable, the right node's left subtree will
     * become the current node's right subtree. The current node will become
     * the right node's left subtree.
     *
     * Don't forget to recalculate the height and balance factor of all
     * affected nodes, using updateHeightAndBF().
     *
     * This method should run in O(1).
     *
     * You may assume that the passed in node is not null and that the subtree
     * starting at that node is right heavy. Therefore, you do not need to
     * perform any preliminary checks, rather, you can immediately perform a
     * left rotation on the passed in node and return the new root of the subtree.
     *
     * This method should only be called in balance().
     *
     * @param currentNode The current node under inspection that will rotate.
     * @return The parent of the node passed in (after the rotation).
     */
    private AVLNode<T> rotateLeft(AVLNode<T> currentNode) {

        // Rotate
        AVLNode<T> newParentNode = currentNode.getRight();
        currentNode.setRight(newParentNode.getLeft());
        newParentNode.setLeft(currentNode);

        // Update height and bf
        updateHeightAndBF(currentNode);
        updateHeightAndBF(newParentNode);

        return newParentNode;
    }

    /**
     * Method that rotates a current node to the right. After saving the
     * current's left node to a variable, the left node's right subtree will
     * become the current node's left subtree. The current node will become
     * the left node's right subtree.
     *
     * Don't forget to recalculate the height and balance factor of all
     * affected nodes, using updateHeightAndBF().
     *
     * This method should run in O(1).
     *
     * You may assume that the passed in node is not null and that the subtree
     * starting at that node is left heavy. Therefore, you do not need to perform
     * any preliminary checks, rather, you can immediately perform a right
     * rotation on the passed in node and return the new root of the subtree.
     *
     * This method should only be called in balance().
     *
     * @param currentNode The current node under inspection that will rotate.
     * @return The parent of the node passed in (after the rotation).
     */
    private AVLNode<T> rotateRight(AVLNode<T> currentNode) {

        // Rotate
        AVLNode<T> newParentNode = currentNode.getLeft();
        currentNode.setLeft(newParentNode.getRight());
        newParentNode.setRight(currentNode);

        // Update height and bf
        updateHeightAndBF(currentNode);
        updateHeightAndBF(newParentNode);

        return newParentNode;
    }

    /**
     * Method that balances out the tree starting at the node passed in.
     * This method should be called in your add() and remove() methods to
     * facilitate rebalancing your tree after an operation.
     *
     * The height and balance factor of the current node is first recalculated.
     * Based on the balance factor, a no rotation, a single rotation, or a
     * double rotation takes place. The current node is returned.
     *
     * You may assume that the passed in node is not null. Therefore, you do
     * not need to perform any preliminary checks, rather, you can immediately
     * check to see if any rotations need to be performed.
     *
     * This method should run in O(1).
     *
     * @param currentNode The current node under inspection.
     * @return The AVLNode that the caller should return.
     */
    private AVLNode<T> balance(AVLNode<T> currentNode) {

        updateHeightAndBF(currentNode);

        // Check if node is right heavy
        if (currentNode.getBalanceFactor() < -1) {
            // Check if double rotation is needed (right-left)
            if (currentNode.getRight().getBalanceFactor() >= 1) {
                currentNode.setRight(rotateRight(currentNode.getRight()));
            }
            currentNode = rotateLeft(currentNode);

            // Check if node is left heavy
        } else if (currentNode.getBalanceFactor() > 1) {
            // Check if double rotation is needed (left-right)
            if (currentNode.getLeft().getBalanceFactor() <= -1 ) {
                currentNode.setLeft(rotateLeft(currentNode.getLeft()));
            }
            currentNode = rotateRight(currentNode);
        }

        return currentNode;
    }

    /**
     * Returns the root of the tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The root of the tree.
     */
    public AVLNode<T> getRoot() {
        // DO NOT MODIFY THIS METHOD!
        return root;
    }

    /**
     * Returns the size of the tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The size of the tree.
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}