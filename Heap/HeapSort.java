public class HeapSort {

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

    public static void heapSort(int[] arr, int n){
        // * build heap
        for(int i=(n/2)-1; i>=0; i--){
            heapify(arr, n, i);
        }
        // * one by one extract an element from heap
        for(int i=n-1; i>0; i--){
            // * move current root to end
            swap(arr, 0, i);
            // * call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }
    public static void main(String[] args) {
        
        int[] arr = {12, 11, 13, 5, 6, 7};
        heapSort(arr, arr.length);
        printArray(arr, arr.length);
    }
}
