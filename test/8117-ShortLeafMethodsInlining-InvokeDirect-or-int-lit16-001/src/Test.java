class Test {
    public int shim(int jj){
        return simple_method(jj);
    }

    private int simple_method(int jj) {
        jj = jj | 32767;
        return jj;
    }

}
