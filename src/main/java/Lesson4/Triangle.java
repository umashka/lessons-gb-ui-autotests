package Lesson4;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Triangle {
    private  int a;
    private  int b;
    private  int c;
    private Color color = Color.WHITE;

    public enum Color{
        RED, WHITE, BLUE, GREEN
    }

    public Boolean isValid(){
        int maxSide = Math.max(a, Math.max(b, c));
        return maxSide < (a + b + c - maxSide);
    }

    public Boolean allPositiveSides(){
        return (a > 0) && (b > 0) && (c > 0);
    }

    public int countPerimeter(){
        if (!allPositiveSides()){
            throw new IllegalArgumentException("Triangle sides must be positive");
        }
        if (!isValid()){
            throw new IllegalArgumentException("Triangle sides must be valid");
        }
        return a + b + c;
    }

    public double countArea(){
        if (!allPositiveSides()){
            throw new IllegalArgumentException("Triangle sides must be positive");
        }
        if (!isValid()){
            throw new IllegalArgumentException("Triangle sides must be valid");
        }
        double pp = countPerimeter() / 2.0;
        return Math.sqrt(pp * (pp - a) * (pp - b) * (pp - c));
    }
}
