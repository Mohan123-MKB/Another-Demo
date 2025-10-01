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
    //9. prime number start with 2 goes with root.
     static boolean isPrime(int n) {
        // code here
        // 1 and below are not prime
        if (n <= 1) return false;

        // Check divisibility up to sqrt(n)
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false; // divisor found, not prime
            }
        }

        return true; 
    }


    //10. second smallest number
     public ArrayList<Integer> minAnd2ndMin(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>();  
        if (arr.length < 2) {
            res.add(-1);
            return res;
        }
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for (int num : arr) {
            if (num < min) {
                secondMin = min; // previous min becomes secondMin
                min = num;
            } else if (num > min && num < secondMin) {
                secondMin = num; // update secondMin only if it's greater than min
            }
        }
        if (secondMin == Integer.MAX_VALUE) {
            // No second smallest exists (all elements same)
            res.add(-1);
        } else {
            res.add(min);
            res.add(secondMin);
        }
        return res;
    }

    //11.common in 3 sorted arrays:
     public List<Integer> commonElements(List<Integer> arr1, List<Integer> arr2,
                                        List<Integer> arr3) {
        ArrayList<Integer> res=new ArrayList<>();
        int i = 0, j = 0, k = 0; // pointers for three arrays
        int n1 = arr1.size(), n2 = arr2.size(), n3 = arr3.size();
        while (i < n1 && j < n2 && k < n3) {
            int a = arr1.get(i), b = arr2.get(j), c = arr3.get(k);
            if (a == b && b == c) {
                // avoid duplicates in result
                if (res.isEmpty() || res.get(res.size() - 1) != a) {
                    res.add(a);
                }
                i++; j++; k++;
            }
            else if (a < b) i++;
            else if (b < c) j++;
            else k++;
        }
        return res;
    }

    //array main method 
    public static void main(String ar[]){
        int[] arr={2,5,4,6,9,7,2,4,3,1};
        int k=3;
        System.out.println(maxSumSubarray(arr,k));
        System.out.println(minSumSubarray(arr,k));
        System.out.println(maxProductSubarray(arr,k));
        System.out.println(minProductSubarray(arr,k));
        System.out.println(maxEvenSumSubarray(arr,k));
        System.out.println(maxOddSumSubarray(arr,k));
        System.out.println(minEvenSumSubarray(arr,k));
        System.out.println(minOddSumSubarray(arr,k));
    }
}





