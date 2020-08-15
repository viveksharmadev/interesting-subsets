// https://leetcode.com/problems/letter-tile-possibilities/
class Solution {
    // tc -> n*n!, sc-> n
    public int numTilePossibilities(String tiles) {
        Set<String> set = new HashSet<>();
        tilePossibilities(tiles, new StringBuilder(), set, new boolean[tiles.length()]);
        return set.size();
    }
    
    private void tilePossibilities(String tiles, StringBuilder sb, Set<String> set,
                                  boolean[] visited){
        for(int i=0; i<tiles.length(); i++){
            if(visited[i]) continue;
            visited[i] = true;
            sb.append(tiles.charAt(i));
            set.add(sb.toString());
            tilePossibilities(tiles, sb, set, visited);
            sb.deleteCharAt(sb.length()-1);
            visited[i] = false;
        }
    }
    
}
