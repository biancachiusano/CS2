import java.awt.Rectangle;

public class Square extends Rectangle
{

  private int height;

  /**
   * Class Constructor
   * @param x x-Coordinate
   * @param y y-Coordinate
   * @param h side length of the square
   * @param w side length of the square
   * Note that h = w
   * Square class inherits Rectangle java class
   * setLocation and setSize methods from the rectangle class are used
   */
  public Square(int x, int y, int h, int w)
  {
    super.setLocation(x - w/2, y + h/2);
    super.setSize(w, h);
    this.height = h;
  }

/**
 * Side lenght squared 
 * @return the area of the square
 */
  public int getArea()
  {
    return height * height;
  }

}
