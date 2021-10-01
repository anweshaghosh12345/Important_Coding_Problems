package DSA.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class trapping_Rain_water {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){

            //size of array
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");

            //adding elements to the array
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            rain obj = new rain();

            //calling trappingWater() function
            System.out.println(obj.trappingWater(arr, n));
        }
    }
}

// } Driver Code Ends



class rain{

    // arr: input array
    // n: size of array
    // Function to find the trapped water between the blocks.
    static int trappingWater(int arr[], int n) {

        // Your code here

       if(n<=2)
           return 0;

        int leftMax = arr[0];
        int rightMax = arr[n-1];

        int left = 1;
        int right = n-2;
        int water = 0;

        while(left <= right) {
            if (leftMax < rightMax) {
                if (arr[left] >= leftMax) {
                    leftMax = arr[left];
                } else
                    water = water + (leftMax - arr[left]);

                //leftMax = Math.max(leftMax, arr[left]);
                left++;
            } else {
                if (arr[right] > rightMax) {
                    rightMax = arr[right];
                }

                water = water + (rightMax - arr[right]);
                right--;
            }
        }
        return water;

    }

}


