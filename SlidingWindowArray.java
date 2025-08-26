import java.util.*;

//first window -> slide window -> add new and remove old ->do action based on problem -> return answer
public class SlidingWindowArray{
    //1. Maximum sum subarray of size k
    public int maxSumSubarray(int[] arr,int k){
        int n=arr.length;
        int sum=0;
        //first window
        for(int i=0;i<k;i++){
            sum +=arr[i];
        }
        int maxSum=sum;
        //slide window
        for(int i=k;i<n;i++){
            sum +=arr[i]-arr[i-k];
            maxSum=Math.max(maxSum,sum);
        }
        return maxSum;
    }

    //2. Minimum sum subarray of size k
     public int minSumSubarray(int[] arr,int k){
        int n=arr.length;
        int sum=0;
        //first window
        for(int i=0;i<k;i++){
            sum +=arr[i];
        }
        int minSum=sum;
        //slide window
        for(int i=k;i<n;i++){
            sum +=arr[i]-arr[i-k];
            minSum=Math.min(minSum,sum);
        }
        return minSum;
     }

    //3. Maximum product subarray of size k
    public int maxProductSubarray(int[] arr,int k){
        int n=arr.length;
        int prod=1;
        //first window
        for(int i=0;i<k;i++){
            prod *=arr[i];
        }
        int maxProd=prod;
        //slide window
        for(int i=k;i<n;i++){
            prod = (prod /arr[i-k]) * arr[i];//remove first element in old window and add new element
            maxProd=Math.max(maxProd,prod);
        }
        return maxProd;
    }

    //4. Minimum product subarray of size k
    public int minProductSubarray(int[] arr,int k){
        int n=arr.length;
        int prod=1;
        //first window
        for(int i=0;i<k;i++){
            prod *=arr[i];
        }
        int minProd=prod;
        //slide window
        for(int i=k;i<n;i++){
            prod = (prod /arr[i-k]) * arr[i];//remove first element in old window and add new element
            minProd=Math.min(minProd,prod);
        }
        return minProd;
    }

    //5. subarray of size k with maximum even sum
    public int maxEvenSumSubarray(int[] arr,int k){
        int sum=0;
        //first window
        for(int i=0;i<k;i++){
            sum +=arr[i];
        }
        int maxEvenSum=(sum % 2==0) ? sum:Integer.MIN_VALUE;
        //slide window
        for(int i=k;i<arr.length;i++){
            sum +=arr[i] -arr[i-k];
            if(sum % 2==0){
                maxEvenSum=Math.max(maxEvenSum,sum);
            }
        }
        return maxEvenSum;
    }

    //6. subarray of size k with maximum odd sum
    public int maxOddSumSubarray(int[] arr,int k){
        int sum=0;
        //first window
        for(int i=0;i<k;i++){
            sum +=arr[i];
        }
        int maxOddSum=(sum % 2 !=0) ? sum:Integer.MIN_VALUE;
        //slide window
        for(int i=k;i<arr.length;i++){
            sum +=arr[i] -arr[i-k];
            if(sum % 2 !=0){
                maxOddSum=Math.max(maxOddSum,sum);
            }
        }
        return maxOddSum;
    }

    //7. subarray of size k with  odd sum
    public int minEvenSumSubarray(int[] arr,int k){
        int sum=0;
        //first window
        for(int i=0;i<k;i++){
            sum +=arr[i];
        }
        int minEvenSum=(sum % 2 ==0) ? sum:Integer.MIN_VALUE;
        //slide window
        for(int i=k;i<arr.length;i++){
            sum +=arr[i] -arr[i-k];
            if(sum % 2 ==0){
                minEvenSum=Math.min(minEvenSum,sum);
            }
        }
        return minEvenSum;
    }

    //8. subarray of size k with  odd sum
    public int minOddSumSubarray(int[] arr,int k){
        int sum=0;
        //first window
        for(int i=0;i<k;i++){
            sum +=arr[i];
        }
        int minOddSum=(sum % 2 !=0) ? sum:Integer.MIN_VALUE;
        //slide window
        for(int i=k;i<arr.length;i++){
            sum +=arr[i] -arr[i-k];
            if(sum % 2 !=0){
                minOddSum=Math.min(minOddSum,sum);
            }
        }
        return minOddSum;
    }





    public static void main(String ar[]){

    }

}