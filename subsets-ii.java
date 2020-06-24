// https://leetcode.com/problems/subsets-ii/
class Solution {
    // tc -> n*2^n, sc-> n*2^n
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums==null || nums.length==0) return res;
        Arrays.sort(nums);
        findAndSetSubsets(nums, new ArrayList<>(), res, 0);
        return res;
    }
    
    private void findAndSetSubsets(int[] nums, List<Integer> list,
                                  List<List<Integer>> res, int index){
        res.add(new ArrayList<>(list));
        
        for(int i=index; i<nums.length; i++){
            if(i>index && nums[i]==nums[i-1]) continue;
            list.add(nums[i]);
            findAndSetSubsets(nums, list, res, i+1);
            list.remove(list.size()-1);
        }
    }
    
    // tc -> n*2^n, sc-> n*2^n
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums==null || nums.length==0) return res;
        Arrays.sort(nums);
        res.add(new ArrayList());
        int startIndex = 0, endIndex = 0;
        
        for(int i=0; i<nums.length; i++){
            startIndex = 0;
            // if current and the previous elements are same, 
            // create new subsets only from the subsets 
            // added in the previous step
            if(i > 0  && nums[i]==nums[i-1])
                startIndex = endIndex+1;
                endIndex = res.size()-1;
                for(int j=startIndex; j<=endIndex; j++){
                    List<Integer> list = new ArrayList(res.get(j));
                    list.add(nums[i]);
                    res.add(list);                    
                }
            }
        return res;
    }
}
