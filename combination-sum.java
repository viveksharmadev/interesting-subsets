// https://leetcode.com/problems/combination-sum/

class Solution {
    // tc -> n^target, sc-> target*n(to add intermediate list to result)
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // Result
        List<List<Integer>> result = new LinkedList<>();
        
        // Combinations Sum
        combinationsSum(candidates, target, new LinkedList<>(), result, 0);
        
        // Return Result
        return result;
    }
    
    private void combinationsSum(int[] candidates, int target, List<Integer> list,
                                List<List<Integer>> result, int index){
        // Base condition
        if(target<0)
            return;
        
        // If target becomes zero then add intermediate list to result
        if(target == 0){
            result.add(new LinkedList(list));
        }
        
        // Traverse through array
        for(int i=index; i<candidates.length; i++){
            // Add to intermediate list
            list.add(candidates[i]);
            
            // Recursion to find all combinations
            combinationsSum(candidates, target - candidates[i], list, result, i);
            
            // Backtrack to find all combinations
            list.remove(list.size()-1);
        }
    }
}
