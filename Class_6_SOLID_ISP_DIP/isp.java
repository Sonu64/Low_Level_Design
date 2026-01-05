// The Interface Segregation Principle (ISP) states that no client should be forced to depend on methods it does not use.

// Instead of creating one large "fat" interface that does everything, you should break it down into several smaller, highly specific interfaces. This ensures that classes only implement the functions that are actually relevant to them.

interface TwoDshape {
    public void area();
}

interface ThreeDshape {
    public void area();
    public void volume();
}

class Square implements TwoDshape {
    private int side;
    public Square(int side) {
        this.side = side;
    }
    // Square only needs area, it is inherited from the interface having only area() method
    public void area() {
        System.out.println("Area of the Square is " + (side * side));
    }
}

class Cube implements ThreeDshape {
    private int edge;
    public Cube(int edge) {
        this.edge = edge;
    }

    // Cube is a 3D shape child, so will have both area() and volume() implementation
    public void area() {
        System.out.println("Area of the Cube-Face is " + (edge * edge));
    }
    public void volume() {
        System.out.println("Volume of the Cube is " + (edge * edge * edge));
    }
}


public class isp {
    public static void main(String[] args) {
        TwoDshape s = new Square(5);
        ThreeDshape c = new Cube(5);
        s.area();
        System.out.println();
        c.area();
        c.volume();
    }
}
