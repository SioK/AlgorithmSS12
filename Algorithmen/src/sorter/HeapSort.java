package sorter;

import java.util.List;

import utils.ToolBox;
import interfaces.ISorter;

public class HeapSort<T extends Comparable<T>> implements ISorter<T> {

  private int[] array;

  @Override
  public void sort(List<T> list) {
    int count = array.length;
    int end = count - 1;
    createHeap(array, array.length);

    while (end > 0) {
      ToolBox.swap(array, end, 0);
      end--;
      reHeap(array, 0, end);
    }
  }

  private void createHeap(int[] array, int count) {
    // index of the last parent node in array a
    int start = count / 2 - 1;
    // sift down so that all elements finally are in max heap order
    while (start >= 0) {
      // generates a node of the heap that passes the max heap order
      reHeap(array, start, count - 1);
      start--;
    }
  }

  private void reHeap(int[] array, int start, int end) {
    int node = start;
    int swap = node;
    // while node has at least one child
    while (node * 2 + 1 <= end) {
      int leftChild = node * 2 + 1; // left child
      // check leftChild is bigger than node
      if (array[node] < array[leftChild]) {
        swap = leftChild;
      }
      int rightChild = leftChild + 1; // right child
      // check right child exists
      if (rightChild <= end) {
        // check right child is bigger than the current swap
        if (array[swap] < array[rightChild]) {
          swap = rightChild;
        }
      }
      if (swap != node) {
        ToolBox.swap(array, swap, node);
        node = swap; // shifting down at child position
      } else {
        return;
      }
    }
  }

}
