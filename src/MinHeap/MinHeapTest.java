package MinHeap;



public class MinHeapTest {

    int[] frequency = {16,10,5,12,3,4,13,1};


    public MinHeapTest(){
        addToHeap();
        printHeap();
    }

    IntegerHeapMin heap = new IntegerHeapMin();
    private void addToHeap(){
        for (int i : frequency){

            heap.addNode(i);
            System.out.println("test root node : "+ heap.getRootNode());
        }
    }

    private void printHeap(){
        System.out.println("root node : " + heap.getRootNode());
        heap.removeRootNode();
        System.out.println("After removing root node, new root : "  + heap.getRootNode());
        heap.addNode(2);
        System.out.println("After adding new node, new root : "  + heap.getRootNode());
    }



}
