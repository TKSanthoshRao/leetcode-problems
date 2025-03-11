class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      int arr[] = new int[nums1.length+nums2.length];
      int i = 0,j = 0,k = 0;
      while(i<nums1.length && j <nums2.length){
            if(nums1[i]<nums2[j]){
               arr[k] = nums1[i];
               i++;
               k++;
            }else{
                arr[k] = nums2[j];
                j++;
                k++;
            }
      }     
      while(i<nums1.length){
        arr[k] =nums1[i];
        i++;
        k++;
      }
      while(j<nums2.length){
        arr[k] = nums2[j];
        j++;
        k++;              
      }


if(arr.length%2==0){ 
    return (double) (arr[arr.length/2]+ arr[(arr.length/2)-1])/2;     
    }
    else{
   return (double) arr[arr.length/2];
    }
         
    }
}