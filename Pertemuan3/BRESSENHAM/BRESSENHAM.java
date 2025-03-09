package BRESSENHAM;

public class BRESSENHAM {
    public static void lineBresenham(int xa, int ya, int xb, int yb) {
        int x, y, xEnd;
        if (xa > xb) {
            x = xb;
            y = yb;
            xEnd = xa;
        } else {
            x = xa;
            y = ya;
            xEnd = xb;
        }

        int dx = Math.abs(xa - xb);
        int dy = Math.abs(ya - yb);

        int p = 2 * dy - dx;
        
        int twoDy = 2 * dy;
        int twoDx = 2 * (dy - dx);

        System.out.printf("%-7s | %2s\n", "(x, y)", "P");
        System.out.println("-".repeat(16));
        System.out.printf("(%d, %d)   %2d\n", x, y, p);

        while (x < xEnd) {
            x++;

            if (p < 0) {
                p += twoDy;
            } else {
                y++;
                p += twoDx;
            }

            System.out.printf("(%d, %d)   %2d\n", x, y, p);
        }
    }

    public static void lineBresenhamV2(int xa, int ya, int xb, int yb) {
        int count = 1;
        
        int dx = Math.abs(xb - xa);
        int dy = Math.abs(yb - ya);
        
        int sx = xa < xb ? 1 : -1;
        int sy = ya < yb ? 1 : -1;
        
        boolean isStepLine = dx < dy;
        
        if (isStepLine) {
            int temp = dx;
            dx = dy;
            dy = temp;
        }
        
        int p = 2 * dy - dx;
        
        int x = xa;
        int y = ya;
        
        System.out.printf("%-7s | %2s\n", "(x, y)", "P");
        System.out.println("-".repeat(16));
        System.out.printf("(%d, %d)   %2d\n", x, y, p);
        
        for (int i = 0; i < dx; i++) {
            count++;

            if (isStepLine) {
                y += sy;
            } else {
                x += sx;
            }
            
            if (p < 0) {
                p += 2 * dy;
            } else {
                if (isStepLine) {
                    x += sx;
                } else {
                    y += sy;
                }
                p += 2 * (dy - dx);
            }
            
            System.out.printf("(%d, %d)   %2d\n", x, y, p);
        }
        System.out.println("n titik: " + count);
    }

    public static void main(String[] args) {
        // lineBresenham(-5, 5, 1, 2);
        // System.out.println();
        // System.out.println("=".repeat(16));
        // lineBresenhamV2(-5, 5, 1, 2);
        // lineBresenhamV2(4,3,8,-2);
        lineBresenham(4,19,10000,1000);
        // lineBresenhamV2(4,19,10000,1000);
    }
}
