package com.springproject.xml.di.constructor;

public class Marks {
    private int mark1;
    private int mark2;

    public Marks(int mark1, int mark2) {
        this.mark1 = mark1;
        this.mark2 = mark2;
    }

    public void getMarks(){
        System.out.println(mark1);
        System.out.println(mark2);
    }
}
