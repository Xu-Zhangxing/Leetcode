public class FindMediaSortedArray{
    static int m;
    static int n;
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        m = nums1.length;n = nums2.length;
        if((m+n)%2==1){
            int k = (m+n)/2+1;
            return Double.valueOf(findKthMin(nums1,nums2,k));
        }else{
            int k1 = (m+n)/2;
            int k2 = k1+1;
            double b1 = Double.valueOf(findKthMin(nums1,nums2,k1));
            double b2 = Double.valueOf(findKthMin(nums1,nums2,k2));
            return (b1+b2)/2;
        }
    }
    public int findKthMin(int[] nums1,int[] nums2,int k){
        int index1 = 0;
        int index2 = 0;
        int offset1 = -1;
        int offset2 = -1;
        while(true){
            if(offset1==m-1){
                return nums2[offset2+k];
            }
            if(offset2==n-1){
                return nums1[offset1+k];
            }
            if(k==1){
                return Math.min(nums1[offset1+1],nums2[offset2+1]);
            }
            int temp = k/2;
            index1 = Math.min(temp+offset1,m-1);
            index2 = Math.min(temp+offset2,n-1);
            if(nums1[index1]<=nums2[index2]){
                k-=(index1-offset1);
                offset1=index1;
            }else{
                k-=(index2-offset2);
                offset2=index2;
            }
        }
    }
}
