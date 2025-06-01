public class QucikSort {

    public static void printarr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int partition(int arr[], int si, int ei) {
        int pivot = arr[ei];
        int pIndex = si;
        for (int i = si; i < ei; i++) {
            if (arr[i] < pivot) {
                swap(arr, i, pIndex);
                pIndex++;
            }
        }
        swap(arr, pIndex, ei);
        return pIndex;
    }  
    
    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void quickSort(int arr[], int si, int ei){

        if(si>=ei){
            return;
        }
        int pIndex = partition(arr, si, ei);

        quickSort(arr,si,pIndex-1);
        quickSort(arr,pIndex+1,ei); 
    }
    public static void main(String[] args) {
        int arr[] = {5,4,3,2,1};
        quickSort(arr,0,arr.length-1);
        printarr(arr);
    }
}
