package punto4_serializable;

import java.io.Serializable;

public abstract class  FiguraGeometrica implements Comparable<FiguraGeometrica>, Serializable {
    private String color;

    public FiguraGeometrica() {}

    public abstract void dibujar();

    public abstract int area();

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public int compareTo(FiguraGeometrica figura) {
        if (this.area() == figura.area())
            return 0;
        else if (this.area() > figura.area())
            return 1;
        else
            return -1;
    }
}
