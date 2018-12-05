// The test checks that stack after NullPointerException occurs is correct despite inlining
class Main {
    final static int iterations = 10;
    
    public static void main(String[] args) {
        Test test = new Test(iterations);

        char nextThingy = 'a';
        char sumArrElements = '0';
        for(int i = 0; i < iterations; i++) {
            SuperTest.thingiesArray[i] = (char)(nextThingy + 1);
            sumArrElements = (char)(sumArrElements + SuperTest.thingiesArray[i]);
        }
	try
	{
        for(int i = 0; i < iterations; i++) {
            nextThingy = (char)(test.getThingies(SuperTest.thingiesArray, i) + 1);
            if (i == iterations - 1)
                SuperTest.thingiesArray = null;
            test.setThingies(SuperTest.thingiesArray, nextThingy, i);
        }
	}
	catch(NullPointerException ex)
        {
            ex.printStackTrace();
        }
        catch (Exception ex)
        {
          System.out.println("Caught unhandled exception");
          ex.printStackTrace();
        }
    }
}
