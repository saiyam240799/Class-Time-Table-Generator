package application;

public class Pair {
    private String[][][] array1;
    private int[] array2;
    private int[] array3;
    private int[] array4;
    private int[] array5;
    private int[] array6;
    private int[] array7;
    private int array8;
    
    public Pair(String[][][] array1, int[] array2,int [] array3,int[] array4,int[] array5,int[] array6,int[] array7, int array8)
    {
        this.array1 = array1;
        this.array2 = array2;
        this.array3 = array3;
        this.array4 = array4;
        this.array5 = array5;
        this.array6 = array6;
        this.array7 = array7;
        this.array8 = array8;

    }
    public String[][][] getArray1() { return array1; }
    public int[] getArray2() { return array2; }
    public int[] getArray3() { return array3; }
    public int[] getArray4() { return array4; }
    public int[] getArray5() { return array5; }
    public int[] getArray6() { return array6; }
    public int[] getArray7() { return array7; }
    public int    getArray8()   { return array8; }
}