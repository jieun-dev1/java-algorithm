package leetcode;

class ClosestCost {
    //2개까지 토핑  base1개 + toppingCosts up to *2의 조합.
    //타겟보다 낮은 걸 return 한다.
    int closest = Integer.MAX_VALUE;
    boolean found = false;

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {

        for (int i=0; i<baseCosts.length; i++) {
            for (int j=0; j<toppingCosts.length;j++) {
                if (found) { return target; }
                dfs(baseCosts, toppingCosts, baseCosts[i], target, j);
                dfs(baseCosts, toppingCosts, baseCosts[i]+toppingCosts[j], target, j);
                dfs(baseCosts, toppingCosts, baseCosts[i]+toppingCosts[j]*2, target, j);
            }
        }
        return closest;
    }
    //일치하는 값 찾으면 return
    public void dfs(int[] baseCosts, int[] toppingCosts, int currentSum, int target, int toppingIndex) {
        if (currentSum == target) {
            found = true;
            closest = target;
            return;
        }
        if (Math.abs(closest-target) == Math.abs(currentSum - target)) {
            closest = Math.min(currentSum, closest);
        }
        if (Math.abs(closest-target) > Math.abs(currentSum - target)) {
            closest = currentSum;
        }
        for (int i=toppingIndex+1; i<toppingCosts.length;i++) {
            dfs(baseCosts, toppingCosts, currentSum, target, i);
            dfs(baseCosts, toppingCosts, currentSum + toppingCosts[i], target, i);
            dfs(baseCosts, toppingCosts, currentSum + toppingCosts[i]*2, target, i);
        }
    }
}
