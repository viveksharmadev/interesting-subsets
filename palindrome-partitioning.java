// https://leetcode.com/problems/palindrome-partitioning/

class Solution {
    // I think tc -> n*2^n, sc-> n*2^n 
    public List<List<String>> partition(String s) {
        // Result
        List<List<String>> result = new LinkedList<>();
        
        // Palindrome Partitions
        palindromePartitions(s, new LinkedList<>(), result, 0);
        
        // Return Result
        return result;
    }
    
    private void palindromePartitions(String s, List<String> list,
                                     List<List<String>> result,
                                     int index){
        
        // Add intermediate list to result
        if(index==s.length())
           result.add(new LinkedList(list));
        
        for(int i=index; i<s.length(); i++){
            
            // Check if String is Palindrome
            if(isPalindrome(s, index, i)){
                // Add Substring to list
                list.add(s.substring(index, i+1));
                
                // Recursion to find other palindromic combinations
                palindromePartitions(s, list, result, i+1);
                
                // Back track
                list.remove(list.size()-1);                
            }
            
        }
    }
    
    private boolean isPalindrome(String s, int start, int end){
        
        while(start < end){
            
            if(s.charAt(start)!=s.charAt(end)) return false;
            
            start++; end--;
        }
        
        return true;
    }
}
