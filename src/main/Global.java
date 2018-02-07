package main;

public class Global {
    private static Global ourInstance = new Global();

    public static Global getInstance() {
        return ourInstance;
    }

    private int fieldSideLenght, numFieldsHeight, numFieldsWidth;

    private Global() {

    }

    public int getFieldSideLenght() {
        return fieldSideLenght;
    }

    public void setFieldSideLenght(int fieldSideLenght) {
        this.fieldSideLenght = fieldSideLenght;
    }

    public int getNumFieldsHeight() {
        return numFieldsHeight;
    }

    public void setNumFieldsHeight(int numFieldsHeight) {
        this.numFieldsHeight = numFieldsHeight;
    }

    public int getNumFieldsWidth() {
        return numFieldsWidth;
    }

    public void setNumFieldsWidth(int numFieldsWidth) {
        this.numFieldsWidth = numFieldsWidth;
    }
}
