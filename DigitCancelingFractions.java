public class DigitCancelingFractions 
{
    private double[] numeratorArray = new double[4];
    private double[] denominatorArray = new double[4];
    
    public DigitCancelingFractions() {
    }
    
    public void calculateArrays() {

        int arrayCount = 0;
        
        for(double numerator = 10; numerator < 100; numerator++) {
            for(double denominator = 10; denominator < 100; denominator++) {
                if(numerator < denominator) {  
                    if(checkCurious(numerator, denominator)) {
                        if(arrayCount != 4) {
                            numeratorArray[arrayCount] = numerator;
                            denominatorArray[arrayCount] = denominator;
                            arrayCount++;
                        }      
                    } 
                }   
            } // End denominator For-Loop
        } // End numerator For-Loop
    }
    
    public void printFractionToReduce() {
        double numerator = 1;
        double denominator = 1;
        for(int i = 0; i < 4; i++ ) {
            System.out.printf("%.0f / %.0f\n", numeratorArray[i], 
                                denominatorArray[i]);
            numerator *= numeratorArray[i];
            denominator *= denominatorArray[i];
        }
        System.out.printf("The numerator is: %.0f. The denominator is: %.0f\n", 
                            numerator, denominator);
    }
    
    private boolean checkCurious(double numerator, double denominator) {
        
        String numerString = Double.toString(numerator);
        String denomString = Double.toString(denominator);
        double testNumer;
        double testDenom;
        
        if(numerString.charAt(0) == denomString.charAt(1)) {
            testNumer = numerString.charAt(1) - 48;
            testDenom = denomString.charAt(0) - 48;
            if(testNumer / testDenom == numerator / denominator) {
                return true;
            }
        } else if (numerString.charAt(1) == denomString.charAt(0)) {
            testNumer = numerString.charAt(0) - 48;
            testDenom = denomString.charAt(1) - 48;
            if(testNumer / testDenom == numerator / denominator) {
                return true;
            }
        }      
        return false;
    }   
}
