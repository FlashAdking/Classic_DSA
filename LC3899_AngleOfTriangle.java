class Solution {
    public double[] internalAngles(int[] sides) {

        Arrays.sort(sides);

        int first = sides[0];
        int second = sides[1];
        int third = sides[2];

        if( first + second <= third){
            return new double[]{};
        }

        
        return new double[]{ Math.toDegrees(Math.acos(getAngle(third , second , first))) ,
                            Math.toDegrees(Math.acos(getAngle(first , third , second))) ,
                            Math.toDegrees(Math.acos(getAngle(first , second , third)))};
    }

    public double getAngle(int a , int b , int c){

        double angle = (Math.pow(a , 2) + Math.pow(b , 2) - Math.pow(c,2)) / (2*a*b);

        return angle;
    }
}
