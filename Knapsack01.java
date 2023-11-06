public class Knapsack01 {

    //tabulation approach
    public static int knapsackTab(int val[] , int wt[] , int W) {
        int n = val.length;
        int dp[][] = new int[n+1][W+1];
        for(int i=0 ; i<n+1 ; i++) {
            dp[i][0] = 0;
        }
        for(int j=0 ; j<W+1 ; j++) {
            dp[0][j] = 0;
        }

        for(int i=1 ; i<n+1 ; i++) {
            for(int j=1 ; j<W+1 ; j++) {
                int v = val[i-1];
                int w = wt[i-1];
                if(w <= j) { //valid condition
                    int incProfit = v + dp[i-1][j-w]; //choice 1: include item
                    int exProfit = dp[i-1][j];  //choice 2: exclude item
                    dp[i][j] = Math.max(incProfit , exProfit);
                }
                else { //invalid condition
                    int exProfit = dp[i-1][j];
                    dp[i][j] = exProfit;
                }
            }
        }
        return dp[n][W];
    }
    public static void main(String args[]) {
        int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int w = 7;
        int dp[][] = new int[val.length+1][w+1];
        for(int i=0 ; i<val.length+1 ; i++) {
            for(int j=0 ; j<w+1 ; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(knapsackTab(val , wt , w));
    }
}
