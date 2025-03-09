def dda_line(x1, y1, x2, y2):
    dx = x2 - x1
    dy = y2 - y1
    
    steps = max(abs(dx), abs(dy))
    
    x_increment = dx / steps
    y_increment = dy / steps
    
    x = x1
    y = y1
    
    line_points = []
    
    for _ in range(steps + 1):
        line_points.append((round(x), round(y)))
        
        x += x_increment
        y += y_increment
    
    return line_points

line = dda_line(1, 1, 8, 5)

for point in line:
    print(point)

