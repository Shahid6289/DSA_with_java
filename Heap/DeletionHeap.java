public class DeletionHeap {

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void printArray(int[] arr, int n){
        for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void heapify(int[] arr, int n, int i){
        int largest = i;
        int l = 2*i+1;
        int r = 2*i+2;

        // * if left child is larger than root
        if(l<n && arr[l]>arr[largest]){
            largest = l;
        }
        // * if right child is larger than root
        if(r<n && arr[r]>arr[largest]){
            largest = r;
        }
        // * if largest is not root
        if(largest!=i){
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }

    public static int delete(int[] arr, int n){
        // * swap root with last element
        int lastElement = arr[n-1];
        // * replace root with the last element
        arr[0] = lastElement;
        n--;
        heapify(arr, n, 0);
        return n;
    }
    public static void main(String[] args) {
        
        int MAX = 100;
        int[] arr = new int[MAX];
        arr[0] = 200;
        arr[1] = 100;
        arr[2] = 50;
        arr[3] = 30;
        arr[4] = 20;

        int n = 5;
        System.out.println("Before Deletion: ");
        printArray(arr, n);

        n = delete(arr, n);
        
        System.out.println("After Deletion: ");
        printArray(arr, n);
    }
}
