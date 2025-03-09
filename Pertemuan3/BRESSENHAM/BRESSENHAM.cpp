#include <iostream>
#include <iomanip>
#include <cmath>

void lineBresenhamV2(int xa, int ya, int xb, int yb) {
    int count = 1;

    int dx = std::abs(xb - xa);
    int dy = std::abs(yb - ya);
    
    int sx = xa < xb ? 1 : -1;
    int sy = ya < yb ? 1 : -1;
    
    bool isSteeepLine = dx < dy;
    
    if (isSteeepLine) {
        std::swap(dx, dy);
    }
    
    int p = 2 * dy - dx;
    
    int x = xa;
    int y = ya;
    
    std::cout << std::left << std::setw(10) << "(x, y)" 
              << " | " << std::right << std::setw(2) << "P" << std::endl;
    std::cout << std::string(16, '-') << std::endl;
    
    std::cout << std::left << std::setw(10) << "(" + std::to_string(x) + ", " + std::to_string(y) + ")" 
              << " | " << std::right << std::setw(2) << p << std::endl;
    
    for (int i = 0; i < dx; i++) {
        count++;

        if (isSteeepLine) {
            y += sy;
        } else {
            x += sx;
        }
        
        if (p < 0) {
            p += 2 * dy;
        } else {
            if (isSteeepLine) {
                x += sx;
            } else {
                y += sy;
            }
            p += 2 * (dy - dx);
        }
        
        std::cout << std::left << std::setw(10) << "(" + std::to_string(x) + ", " + std::to_string(y) + ")" 
                  << " | " << std::right << std::setw(2) << p << std::endl;
    }
    std::cout << "n titik: " + std::to_string(count) << std::endl;
}

int main() {
    // lineBresenhamV2(-5, 5, 1, 2);
    // lineBresenhamV2(4,3,8,-2);
    lineBresenhamV2(4,19,10000,1000);
    // lineBresenhamV2(0, 0, 10, 5);
    return 0;
}