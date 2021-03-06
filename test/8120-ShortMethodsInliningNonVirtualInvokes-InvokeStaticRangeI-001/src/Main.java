class Main {
    final static int iterations = 10;
    
    public static void main(String[] args) {
        Test test = new Test();
        int nextThingy = -10;
        char c1 = 'a';
        char c2 = 'b';
        char c3 = 'c';
        char c4 = 'd';
        char c5 = 'e';
        char c6 = 'f';

        System.out.println("Initial nextThingy value is " + nextThingy);

        for(int i = 0; i < iterations; i++) {
            nextThingy = Test.getThingies(test, c1, c2, c3, c4, c5, c6) + i;
            Test.setThingies(test, nextThingy, c1, c2, c3, c4, c5, c6);
        }

        System.out.println("Final nextThingy value is " + nextThingy);

    }
}
