
/**
*
* Expected result: 
* in nested loops sinking occurs:
* 1. addition/subtraction: if result overflows
* 2. multiplication: if (overflows or result is 0) and (constant operand cst >= 0)
* 3. division : if (overflows or result is 0) and (constant operand cst > 0 )
* 4. reminder, always sink
*
**/

public class Main {                                                                                                                                                   
    final int iterationsLessThanThreshold = 50;
    final int iterationsGreaterThanThreshold = 70;

    public double testLoopAddLess(double n) {
        double testVar = 1.0d;
        double additionalVar = 0;
        for (int j = 0; j < 1100; j++) {
            for (int i = -10; i < iterationsLessThanThreshold; i++) {
                testVar += 3.5d;
                additionalVar += (i*2)/5 + n;
            }
        }
        testVar += additionalVar;
        return testVar;
    }

    public double testLoopAddGreater(double n) {
        double testVar = 1.0d;
        double additionalVar = 0;
        for (int j = 0; j < 1100; j++) {
            for (int i = -10; i < iterationsGreaterThanThreshold; i++) {
                testVar += 3.5d;
                additionalVar += (i*2)/5 + n;
            }
        }
        testVar += additionalVar;
        return testVar;
    }

    public double testLoopAddInfinity(double n) {
        double testVar = 1.0d;
        double additionalVar = 0;
        for (int j = 0; j < 1100; j++) {
            int i = -10;
            while (i < iterationsGreaterThanThreshold) {
                i++;
                testVar += Double.MAX_VALUE/3.5d;
                additionalVar += (i*2)/5 + n;
            }
        }
        testVar += additionalVar;
        return testVar;
    }


    public double testLoopSubLess(double n) {
        double testVar = 1.0d;
        double additionalVar = 0;
        double f = -1.2345d;
        do {
            for (int i = -10; i < iterationsLessThanThreshold; i++) {
                testVar -= 3.5d;
                additionalVar += (i*2)/5 + n;
                f += 0.2134d;
            }
        } while (f < 50.3);
        testVar += additionalVar;
        return testVar;
    }

    public double testLoopSubGreater(double n) {
        double testVar = 1.0d;
        double additionalVar = 0;

        double f = -1.2345d;
        do {
            for (int i = -10; i < iterationsGreaterThanThreshold; i++) {
                testVar -= 3.5d;
                additionalVar += (i*2)/5 + n;
                f += 0.2134d;
            }
        } while (f < 50.3);
        testVar += additionalVar;
        return testVar;
    }

    public double testLoopSubInfinity(double n) {
        double testVar = 1.0d;
        double additionalVar = 0;
        double f = -1.2345d;
        do {
            for (int i = -10; i < iterationsGreaterThanThreshold; i += 1) {
                testVar -= Double.MAX_VALUE/3.5d;
                additionalVar += (i*2)/5 + n;
                f += 0.2134d;
            }
        } while (f < 50.3);
        testVar += additionalVar;
        return testVar;
    }


 public double testLoopMulLess(double n) {
        double testVar = 1.0d;
        double additionalVar = 0;
        for (int j = 0; j < 1100; j++) {
            for (int i = -10; i < iterationsLessThanThreshold; i++) {
                testVar *= 1.1d;
                additionalVar += (i*2)/5 + n;
            }
        }
        testVar += additionalVar;
        return testVar;
    }

    public double testLoopMulGreater(double n) {
        double testVar = 1.0d;
        double additionalVar = 0;
        for (int j = 0; j < 1100; j++) {
        for (int i = -10; i < iterationsGreaterThanThreshold; i++) {
              testVar *= 1.1d;
              additionalVar += (i*2)/5 + n;
        }
        }
        testVar += additionalVar;
        return testVar;
    }

    public double testLoopMulInfinity(double n) {
        double testVar = 1.0d;
        double additionalVar = 0;
        for (int j = 0; j < 1100; j++) {
        for (int i = -10; i < iterationsGreaterThanThreshold; i++) {
              testVar *= Double.MAX_VALUE/3.5d;
              additionalVar += (i*2)/5 + n;
        }
        }
        testVar += additionalVar;
        return testVar;
    }

    public double testLoopMulInfinityNeg(double n) {
        double testVar = 1.0d;
        double additionalVar = 0;
        for (int j = 0; j < 1100; j++) {
        for (int i = -10; i < iterationsGreaterThanThreshold; i++) {
              testVar *= -Double.MAX_VALUE/3.5d;
              additionalVar += (i*2)/5 + n;
        }
        }
        testVar += additionalVar;
        return testVar;
    }



   public double testLoopMulZero(double n) {
        double testVar = 1.0d;
        double additionalVar = 0;
        double smallVar = 3.5f/Double.MAX_VALUE;
        for (int j = 0; j < 1100; j++) {
        for (int i = -10; i < iterationsGreaterThanThreshold; i++) {
              testVar *= smallVar;
              additionalVar += (i*2)/5 + n;
        }
        }
        testVar += additionalVar;
        return testVar;
    }

   public double testLoopMulZeroNeg(double n) {
        double testVar = 1.0d;
        double additionalVar = 0;
        double smallVar = 3.5f/Double.MAX_VALUE;
        for (int j = 0; j < 1100; j++) {
        for (int i = -10; i < iterationsGreaterThanThreshold; i++) {
              testVar *= -smallVar;
              additionalVar += (i*2)/5 + n;
        }
        }
        testVar += additionalVar;
        return testVar;
    }




 public double testLoopDivLess(double n) {
        double testVar = 10000000.0d;
        double additionalVar = 0;
        for (int j = 0; j < 1100; j++) {
        for (int i = -10; i < 10; i++) {
              testVar /= 3.5d;
              additionalVar += (i*2)/5 + n;
        }
        }
        testVar += additionalVar;
        return testVar;
    }

    public double testLoopDivGreater(double n) {
        double testVar = 1000000.0d;
        double additionalVar = 0;
        for (int j = 0; j < 1100; j++) {
        for (int i = -10; i < iterationsGreaterThanThreshold; i++) {
              testVar /= 1.1d;
              additionalVar += (i*2)/5 + n;
        }
        }
        testVar += additionalVar;
        return testVar;
    }

    public double testLoopDivZero(double n) {
        double testVar = 1.0d;
        double additionalVar = 0;
        for (int j = 0; j < 1100; j++) {
        for (int i = -10; i < iterationsGreaterThanThreshold; i++) {
              testVar /= 300000000000000.5d;
              additionalVar += (i*2)/5 + n;
        }
        }
        testVar += additionalVar;
        return testVar;
    }

    public double testLoopDivZeroNeg(double n) {
        double testVar = 1.0d;
        double additionalVar = 0;
        for (int j = 0; j < 1100; j++) {
        for (int i = -10; i < iterationsGreaterThanThreshold; i++) {
              testVar /= -30.5d;
              additionalVar += (i*2)/5 + n;
        }
        }
        testVar += additionalVar;
        return testVar;
    }

    public double testLoopDivInfinity(double n) {
        double testVar = 1.0d;
        double additionalVar = 0;
        double smallVar = 10/Double.MAX_VALUE;
        for (int j = 0; j < 1100; j++) {
        for (int i = -10; i < iterationsGreaterThanThreshold; i++) {
              testVar /= smallVar;
              additionalVar += (i*2)/5 + n;
        }
        }
        testVar += additionalVar;
        return testVar;
    }

    public double testLoopDivInfinityNeg(double n) {
        double testVar = 1.0d;
        double additionalVar = 0;
        double smallVar = 10/Double.MAX_VALUE;
        for (int j = 0; j < 1100; j++) {
        for (int i = -10; i < iterationsGreaterThanThreshold; i++) {
              testVar /= -smallVar;
              additionalVar += (i*2)/5 + n;
        }
        }
        testVar += additionalVar;
        return testVar;
    }




    public double testLoopRemLess(double n) {
        double testVar = 100.0d;
        double additionalVar = 0;
        for (int j = 0; j < 1100; j++) {
        for (int i = -10; i < iterationsLessThanThreshold; i++) {
              testVar %= -0.5d;
              additionalVar += (i*2)/5 + n;
        }
        }
        testVar += additionalVar;
        return testVar;
    }

    public double testLoopRemGreater(double n) {
        double testVar = 100.0d;
        double additionalVar = 0;
        for (int j = 0; j < 1100; j++) {
        for (int i = -10; i < iterationsGreaterThanThreshold; i++) {
              testVar %= 0.5d;
              additionalVar += (i*2)/5 + n;
        }
        }
        testVar += additionalVar;
        return testVar;
    }

    public double testLoopRemZero(double n) {
        double testVar = 10.1d;
        double additionalVar = 0;
        for (int j = 0; j < 1100; j++) {
        for (int i = -10; i < iterationsGreaterThanThreshold; i++) {
              testVar %= 10.1d;
              additionalVar += (i*2)/5 + n;
        }
        }
        testVar += additionalVar;
        return testVar;
    }


    public double testLoopNaN(double n) {
        double testVar = 0.0d;
        double additionalVar = 0;
        for (int j = 0; j < 1100; j++) {
        for (int i = -10; i < iterationsGreaterThanThreshold; i++) {
              testVar /= 0.0d;
              additionalVar += (i*2)/5 + n;
        }
        }
        testVar += additionalVar;
        return testVar;

    }

    public double testLoopInfinity1(double n) {
        double testVar = 1.0f/0.0d;
        double additionalVar = 0;
        for (int j = 0; j < 1100; j++) {
        for (int i = -10; i < iterationsGreaterThanThreshold; i++) {
              testVar += 1.0d;
              additionalVar += (i*2)/5 + n;
        }
        }
        testVar += additionalVar;
        return testVar;

    }

    public double testLoopInfinity2(double n) {
        double testVar = 1.0f/0.0d;
        double additionalVar = 0;
        for (int j = 0; j < 1100; j++) {
        for (int i = -10; i < iterationsGreaterThanThreshold; i++) {
              testVar *= -11.0f/0d;
              additionalVar += (i*2)/5 + n;
        }
        }
        testVar += additionalVar;
        return testVar;

    }

    public double testLoopInfinity3(double n) {
        double testVar = -1.0f/0.0d;
        double additionalVar = 0;
        for (int j = 0; j < 1100; j++) {
        for (int i = -10; i < iterationsGreaterThanThreshold; i++) {
              testVar *= 11.0f/0d;
              additionalVar += (i*2)/5 + n;
        }
        }
        testVar += additionalVar;
        return testVar;

    }


 public double testLoopUnkownStart(double testVar, double n) {
        double additionalVar = 0;
        for (int j = 0; j < 1100; j++) {
        for (int i = -10; i < iterationsLessThanThreshold; i++) {
              testVar += 3.5d;
              additionalVar += (i*2)/5 + n;
        }
        }
        testVar += additionalVar;
        return testVar;
    }


    public static void main(String[] args)
    {
         System.out.println(new Main().testLoopAddLess(1.2d));
         System.out.println(new Main().testLoopAddGreater(1.2d));
         System.out.println(new Main().testLoopAddInfinity(1.2d));

         System.out.println(new Main().testLoopSubLess(1.2d));
         System.out.println(new Main().testLoopSubGreater(1.2d));
         System.out.println(new Main().testLoopSubInfinity(1.2d));


         System.out.println(new Main().testLoopMulLess(1.2d));
         System.out.println(new Main().testLoopMulGreater(1.2d));
         System.out.println(new Main().testLoopMulZero(1.2d));
         System.out.println(new Main().testLoopMulZeroNeg(1.2d));
         System.out.println(new Main().testLoopMulInfinity(1.2d));
         System.out.println(new Main().testLoopMulInfinityNeg(1.2d));

         System.out.println(new Main().testLoopDivLess(1.2d));
         System.out.println(new Main().testLoopDivGreater(1.2d));
         System.out.println(new Main().testLoopDivZero(1.2d));
         System.out.println(new Main().testLoopDivZeroNeg(1.2d));
         System.out.println(new Main().testLoopDivInfinity(1.2d));
         System.out.println(new Main().testLoopDivInfinityNeg(1.2d));

         System.out.println(new Main().testLoopRemLess(1.2d));
         System.out.println(new Main().testLoopRemGreater(1.2d));
         System.out.println(new Main().testLoopRemZero(1.2d));

         System.out.println(new Main().testLoopNaN(1.2d));
         System.out.println(new Main().testLoopInfinity1(1.2d));
         System.out.println(new Main().testLoopInfinity2(1.2d));
         System.out.println(new Main().testLoopInfinity3(1.2d));
         
         System.out.println(new Main().testLoopUnkownStart(1.2d, 3.5d));

    }

}  

