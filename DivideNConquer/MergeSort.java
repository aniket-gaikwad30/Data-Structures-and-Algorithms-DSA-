
public class MergeSort {
    public static void printarr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void merge(int arr[],int start,int mid,int end){
        int n1 = mid-start+1;
        int n2 = end-mid;

        int left[] = new int[n1];
        int right[] = new int[n2];

        for(int i=0;i<n1;i++){
            left[i] = arr[start+i];
        }
        for(int i=0;i<n2;i++){
            right[i] = arr[mid+1+i];
        }

        int i=0,j=0,k=start;
        while(i<n1 && j<n2){
            if(left[i]<=right[j]){
                arr[k] = left[i];
                i++;
            }
            else{
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            arr[k] = left[i];
            i++;
            k++;
        }
        while(j<n2){
            arr[k] = right[j];
            j++;
            k++;
        }
    }   

    public static void mergeSort(int arr[],int start,int end){
        if(start>=end){
            return;
        }
        int mid = (start+end)/2;
        mergeSort(arr,start,mid);
        mergeSort(arr,mid+1,end);
        merge(arr,start,mid,end);
    }
    public static void main(String[] args) {
        int arr[] = {5,4,3,2,1};
        mergeSort(arr,0,arr.length-1);
        printarr(arr);
    }
}
