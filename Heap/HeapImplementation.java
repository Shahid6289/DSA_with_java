public class HeapImplementation {

    static int n = 0;
    static int[] heap = new int[100];

    public static void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public static void insert(int key) {
        n = n + 1;
        heap[n - 1] = key;
        int i = n - 1;
        while(i>0 && heap[(i-1)/2]<heap[i]){
            swap((i-1)/2, i);
            i = (i-1)/2;
        }
    }

    public static int delete(){
        int deleted = heap[0];
        // * swap root with last element
        heap[0] = heap[n-1];
        n--;
        int i = 0;
        while(i<(n-1)/2){
            if(heap[2*i+1] > heap[i] || heap[2*i+2] > heap[i]){
                // * swap with maximum
                int max = (heap[2*i+1] > heap[2*i+2]) ? 2*i+1 : 2*i+2;
                swap(i, max);
                i = max;
            }
        }
        return deleted;
    }

    public static void print() {
        for (int i = 0; i < n; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        insert(50);
        insert(30);
        insert(40);
        insert(10);
        insert(5);
        insert(20);
        insert(30);
        System.out.println("Before Insertion: ");
        print();

        insert(60);
        System.out.println("After Insertion: ");
        print();
        
        delete();
        System.out.println("After Deletion: ");
        print();
    }
}
