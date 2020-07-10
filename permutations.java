// https://leetcode.com/problems/permutations/
class Solution {
    // tc -> n*n!, sc-> n*n!
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        calculatePermutations(nums, new LinkedList<>(), res);
        return res;
    }
    
    private void calculatePermutations(int[] nums, 
                                 List<Integer> list, List<List<Integer>> res){
             
        if(list.size()==nums.length){
            res.add(new LinkedList(list));
        }
        for(int i=0; i<nums.length; i++){           
            if(list.contains(nums[i])) continue;
            list.add(nums[i]);
            calculatePermutations(nums, list, res);
            list.remove(list.size()-1);
        }
    }
}
