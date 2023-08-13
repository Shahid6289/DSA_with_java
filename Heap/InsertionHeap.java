public class InsertionHeap{

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
        int largest = (i-1)/2;

        if(arr[largest]>0){
            if(arr[i]>arr[largest]){
                swap(arr, i, largest);
                heapify(arr, n, largest);
            }
        }
    }

    public static int insert(int[] arr, int n, int key){
        n = n+1;
        arr[n-1] = key;
        heapify(arr, n, n-1);
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
        System.out.println("Before Insertion: ");
        printArray(arr, n);

        n = insert(arr, n, 40);
        System.out.println("After Insertion: ");
        printArray(arr, n);
    }
}