#include <iostream>
#include <cmath>
#include <iomanip>

void lineDDA(int xa, int ya, int xb, int yb) {
    int count = 1;
    int dx = xb - xa;
    int dy = yb - ya;
    int steps;

    if (std::abs(dx) > std::abs(dy)) {
        steps = std::abs(dx);
    } else {
        steps = std::abs(dy);
    }

    float xIncrement = static_cast<float>(dx) / steps;
    float yIncrement = static_cast<float>(dy) / steps;

    float x = xa;
    float y = ya;

    std::cout << "(" << std::round(x) << ", " << std::round(y) << ")" << std::endl;

    for (int k = 0; k < steps; k++) {
        count++;
        x += xIncrement;
        y += yIncrement;

        std::cout << "(" << std::round(x) << ", " << std::round(y) << ")" << std::endl;
    }
    std::cout << "n titik:" << count << std::endl;
}

int main() {
    // lineDDA(-5, 5, 1, 2);
    // lineDDA(0,0,10000,1000);
    lineDDA(4,19,10000,1000);
    // lineDDA(0, 0, 10, 5);

    return 0;
}