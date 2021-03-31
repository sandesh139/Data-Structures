package MinHeap;

import java.util.Arrays;

public class IntegerHeapMin {

    /* This is the size of the heap. It is also equal to the total number of nodes in the heap.*/
    private int heapSize = 0;

    /* This is the size of the arrays which is always greater or equal to the size of the heap */
    private int heapCapacity = 20;

    /* This is the array of nodes. This is the basic data structure for building the heap data structure on top of it.*/
    int[] nodes = new int[heapCapacity];

    /**
     * @param nodeIndex is the index of the node
     * @returns the index of the left node in the heap
     */
    private int getLeftNodeIndex(int nodeIndex){
        return 2 *nodeIndex +1;
    }

    /**
     * @param nodeIndex is the index of the node in the heap
     * @returns the index of the right node in the heap
     */
    private int getRightNodeIndex(int nodeIndex){
        return 2 * nodeIndex + 2;
    }

    /**
     * @param nodeIndex is the index of the node in the heap
     * @returns the index of the parent node in the heap
     */
    private int getParentNodeIndex(int nodeIndex){
        return (nodeIndex -1) /2;
    }

    /**
     * @param nodeIndex is the index of the node in the heap
     * @returns true if the node has a left node, otherwise false.
     */
    private boolean hasLeftNode(int nodeIndex){
        return getLeftNodeIndex(nodeIndex) < heapSize;
    }


    /**
     * @param nodeIndex is the index of the node in the heap
     * @returns true if the node has a right node, otherwise false.
     */
    private boolean hasRightNode(int nodeIndex){
        return getRightNodeIndex(nodeIndex) < heapSize;
    }

    /**
     * @param nodeIndex is the index of the node in the heap
     * @returns true if the node has a parent node, otherwise false.
     */
    private boolean hasParentNode(int nodeIndex){
        return getParentNodeIndex(nodeIndex) >= 0;
    }

    /**
     * @param nodeIndex is the index of the node in the heap
     * @returns the left node
     */
    private int getLeftNode(int nodeIndex){
        return nodes[getLeftNodeIndex(nodeIndex)];
    }

    /**
     * @param nodeIndex is the index of the node in the heap
     * @returns the right node
     */
    private int getRightNode(int nodeIndex){
        return nodes[getRightNodeIndex(nodeIndex)];
    }

    /**
     * @param nodeIndex is the index of the node in the heap
     * @returns the parent node
     */
    private int getParentNode(int nodeIndex){
        return nodes[getParentNodeIndex(nodeIndex)];
    }

    /**
     * this method swaps the nodes in the heap
     * @param nodeIndexOne
     * @param nodeIndexTwo
     */
    private void swapNodes(int nodeIndexOne, int nodeIndexTwo){
        int temp = nodes[nodeIndexOne];
        nodes[nodeIndexOne] = nodes[nodeIndexTwo];
        nodes[nodeIndexTwo] = temp;
    }

    /**
     * this method ensures heap capacity is always enough to store all the heap nodes
     */
    private void maintainHeapCapacity(){
        if(heapSize==heapCapacity){
            nodes= Arrays.copyOf(nodes, heapCapacity *2);
            heapCapacity *= 2;
        }
    }

    /**
     * @returns the root node
     */
    public int getRootNode(){
        if(heapSize == 0) throw new IllegalStateException();
        return nodes[0];
    }

    public void removeRootNode(){
        if(heapSize == 0) throw new IllegalStateException();
        nodes[0] = nodes[heapSize-1];
        heapSize--;
        heapifyDown();
    }

    public void addNode(int node){
        maintainHeapCapacity();
        nodes[heapSize] = node;
        heapSize++;
        heapifyUp();
    }

    public void heapifyUp(){
        int currIndex = heapSize -1;
//        System.out.println("this is parent node "+ getParentNode(currIndex));
//        System.out.println("nodes : "+ nodes[currIndex]);
//        System.out.println("curr Index : " + currIndex);
//        System.out.println(hasParentNode(currIndex));
        while(hasParentNode(currIndex) && getParentNode(currIndex) > nodes[currIndex]){
            swapNodes(getParentNodeIndex(currIndex),currIndex);
            currIndex = getParentNodeIndex(currIndex);

        }
    }

    public void heapifyDown(){
        int currIndex = 0;
        while(hasLeftNode(currIndex)){
            int smallerChildIndex = getLeftNodeIndex(currIndex);
            if(hasRightNode(currIndex) && getRightNode(currIndex) < getLeftNode(currIndex)){
                smallerChildIndex = getRightNodeIndex(currIndex);
            }
            if(nodes[currIndex] < nodes[smallerChildIndex]){
                break;
            } else {
                swapNodes(currIndex, smallerChildIndex);
            }
            currIndex = smallerChildIndex;
        }
    }

}
