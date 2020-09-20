// https://leetcode.com/problems/combination-sum-ii/

class Solution {
    // tc -> n^target, sc-> target*n
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // Result
        List<List<Integer>> result = new LinkedList<>();
        
        // Base condition
        if(candidates==null || candidates.length==0)
            return result;
        
        // Sort the candidates
        Arrays.sort(candidates);
        
        // Combinations Sum
        combinationsSum(candidates, new LinkedList<>(), result, target, 0);
        
        // Return result
        return result;
    }
    
    private void combinationsSum(int[] candidates, List<Integer> list,
                                 List<List<Integer>> result,
                                int target, int index){
        // Base condition
        if(target<0)
            return;
        
        // Add to Result
        if(target==0)
            result.add(new LinkedList(list));
        
        // Traverse the array
        for(int i=index; i<candidates.length; i++){
            // skip duplicates
            if(i>index && candidates[i]==candidates[i-1])
                continue;
            
            // Add to intermediate list
            list.add(candidates[i]);
            
            // Recursion to find all combinations
            combinationsSum(candidates, list, result, target-candidates[i], i+1);
            
            // Back track
            list.remove(list.size()-1);
        }
    }
}
