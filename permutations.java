// https://leetcode.com/problems/permutations/
class Solution {
    // tc-> n*n!, sc-> n*n!
    public List<List<Integer>> permute(int[] nums) {
        // Result
        List<List<Integer>> result = new LinkedList<>();
        
        // Base condition
        if(nums==null || nums.length==0)
            return result;
        
        // Permutations calculation
        permutations(nums, new LinkedList<>(), result, new boolean[nums.length]);
        
        // Return Result
        return result;
    }
    
    private void permutations(int[] nums, List<Integer> list, 
                             List<List<Integer>> result,
                             boolean[] visited){
        // Base Condition
        if(list.size()==nums.length){
            result.add(new LinkedList(list));
        }
        
        // Traverse the given array and populate the intermediate list
        for(int i=0; i<nums.length; i++){
            // Check if number is already visited, then skip it
            if(visited[i]) continue;
            
            // Add to intermediate list and mark it as visited
            list.add(nums[i]);
            visited[i] = true;
            
            // Recursion to find all permutations
            permutations(nums, list, result, visited);
            
            // Backtrack
            list.remove(list.size()-1);
            visited[i] = false;
        }
        
    }
    
    
}
