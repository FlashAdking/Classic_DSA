class Solution {
    public String customSortString(String order, String s) {
        
        // Character[] arr = new Character[s.length()];

        // for(int i=0 ; i < s.length() ; i++){
        //     arr[i] = s.charAt(i);
        // }

        // Arrays.sort(arr , (i , j)->{
        //     return Integer.compare( order.indexOf(i) , order.indexOf(j) );
        // });
        
        char[] str = s.toCharArray();

        MergeSort(0 , str.length-1 , str , order);

        return new String(str);
    }


    public void MergeSort(int start , int end , char[] str , String order){

        if(start < end ){
            int mid = start + (end - start) / 2;

            MergeSort( start , mid , str , order);
            MergeSort( mid+1 , end , str , order);


            Merge(start , mid , end , str , order);
        }


    }

    public void Merge(int start , int mid , int end , char[] str , String order){

        char[] oxy = new char[ (end - start) + 1];

        int i = start;
        int j = mid+1;
        int index = 0;


        while( i <= mid && j <= end ){

            if( order.indexOf(str[i]) < order.indexOf(str[j]) ){
                oxy[index++] = str[i++];
            }else{

                oxy[index++] = str[j++];
            }

        }

        while( i <= mid){
            oxy[index++] = str[i++];
        }

        while( j <= end){
            oxy[index++] = str[j++];
        }


        for( int m=start , k=0  ; m <= end ; m++ , k++){
            str[m] = oxy[k];
        }
    }
}
