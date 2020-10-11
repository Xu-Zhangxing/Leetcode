public class PartitionSubset{
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if(n<2){
            return false;
        }
        int sum = 0;int maxnum = 0;
        for(int i = 0;i < n;i++){
            sum+=nums[i];
            maxnum=Math.max(maxnum,nums[i]);
        }
        if(sum%2!=0){
            return false;
        }
        int target = sum/2;
        if(maxnum>target) return false;
        // boolean[][] dp = new boolean[n][target+1];
        // dp[0][nums[0]] = true;
        // for(int i = 1;i < n;i++){
        //     int num = nums[i];
        //     for(int j = 0;j <= target;j++){
        //         if(j>=num){
        //             dp[i][j] = dp[i-1][j] | dp[i-1][j-num];
        //         }else{
        //             dp[i][j] = dp[i-1][j];
        //         }
        //     }
        // }
        // return dp[n-1][target];
        boolean[] dp = new boolean[target+1];
        dp[nums[0]] = true; 
        for(int i = 1;i < n;i++){
            int num = nums[i];
            for(int j = target;j > num;j--){
                dp[j] |= dp[j-num];
            }
            if(dp[target]) return true;
        }
        return dp[target];
    }
}
