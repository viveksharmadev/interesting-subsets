// https://leetcode.com/problems/permutations-ii/
class Solution {
    // tc -> n*n!, sc-> n*n!
    public List<List<Integer>> permuteUnique(int[] nums) {
        // Result 
        List<List<Integer>> result = new LinkedList<>();
        
        // Base condition
        if(nums==null || nums.length==0)
            return result;
        
        // Sort the Array
        Arrays.sort(nums);
        
        // Premutations
        permutations(nums, new LinkedList<>(), result, new boolean[nums.length]);
        
        // Return Result
        return result;
    }
    
    private void permutations(int[] nums, List<Integer> list,
                             List<List<Integer>> result,
                             boolean[] visited){
        // Base condition
        if(list.size()==nums.length)
            result.add(new LinkedList(list));
        
        // Traverse the array to find permutations
        for(int i=0; i<nums.length; i++){
            // Skip Duplicates
            if(visited[i] || (i>0 && nums[i]==nums[i-1] && !visited[i-1]))
                continue;
            
            // Add to intermediate list and mark it visited
            list.add(nums[i]);
            visited[i] = true;
            
            //Recursion
            permutations(nums, list, result, visited);
            
            // Back track to find all permutations
            list.remove(list.size()-1);
            visited[i] = false;
        }
        
    }
}
