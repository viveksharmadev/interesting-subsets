// https://leetcode.com/problems/letter-combinations-of-a-phone-number/
class letter-combinations-of-a-phone-number {
    // tc - 3^n(digits: 2,3,4,5,6,8)*4^m(digits: 7,9)
    // sc - 3^n*4^m
    private static String[] LETTERS = 
    {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits==null || digits.length()==0) return res;
        helper(digits, 0, new StringBuilder(), res);
        return res;
    }
    
    private void helper(String digits, int indx, StringBuilder sb,
                       List<String> res){
        if(sb.length()==digits.length()){
            res.add(sb.toString());
            return;
        }
        
        String letters = LETTERS[digits.charAt(indx)-'0'];
        for(int i=0; i<letters.length(); i++){
            sb.append(letters.charAt(i));
            helper(digits, indx+1, sb, res);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
