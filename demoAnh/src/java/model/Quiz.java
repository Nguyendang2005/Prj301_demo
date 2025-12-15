package model;

public class Quiz {
    private int a;
    private int b;
    private String op;

    public Quiz(int a, int b, String op) {
        this.a = a; this.b = b; this.op = op;
    }
    public int getA(){ return a; }
    public int getB(){ return b; }
    public String getOp(){ return op; }

    public double getAnswer(){
        switch(op){
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return b==0 ? Double.NaN : (double) a / b;
        }
        return Double.NaN;
    }
}