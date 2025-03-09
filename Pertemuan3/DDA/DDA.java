package DDA;

public class DDA {
    public static void lineDDA(int xa, int ya, int xb, int yb) {
        int count = 1;

        int dx = xb - xa;
        int dy = yb - ya;
        int steps;
        
        if (Math.abs(dx) > Math.abs(dy)) {
            steps = Math.abs(dx);
        } else {
            steps = Math.abs(dy);
        }
        
        float xIncrement = (float) dx / steps;
        float yIncrement = (float) dy / steps;
        
        float x = xa;
        float y = ya;
        
        System.out.println("(" + Math.round(x) + ", " + Math.round(y) + ")");
        
        for (int k = 0; k < steps; k++) {
            count++; 

            x += xIncrement;
            y += yIncrement;
            
            System.out.println("(" + Math.round(x) + ", " + Math.round(y) + ")");
        }
        System.out.println("n titik:" + count);
    }

    public static void main(String[] args) {
        lineDDA(-5, 5, 1, 2);
    }
}
