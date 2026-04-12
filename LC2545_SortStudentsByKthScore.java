class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {

        Arrays.sort(score , (i , j)->{
            return Integer.compare(j[k], i[k]);
        });
        
        return score;
    }
}
