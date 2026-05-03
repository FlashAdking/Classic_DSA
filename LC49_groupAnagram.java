class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String , List<String>> map = new HashMap<>();


        for( int i=0 ; i < strs.length ; i++){
            char[] str = strs[i].toCharArray();
            Arrays.sort(str);
            String sort = new String(str);

            // int[] index = new int[26];

            // for(char c : strs[i].toCharArray()){
            //     index[c-'a']++;
            // }


            // StringBuilder str = new StringBuilder();

            // for( int val : index){
            //     str.append('#');
            //     str.append(val);
            // }


            map.putIfAbsent(sort , new ArrayList());
            map.get(sort).add(strs[i]);

            // if( map.containsKey(str.toString()) ){
            //     map.get(str.toString()).add(strs[i]);

            // }else{
            //     List<String> ls = new ArrayList<>();
            //     ls.add(strs[i]);
            //     map.put( str.toString() , ls );
            // }
        }



        return new ArrayList( map.values() );
    }
}
