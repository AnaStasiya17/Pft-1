package ru.stqa.pft.sandbox;
<<<<<<< HEAD
<<<<<<< HEAD
=======

>>>>>>> origin/master
=======

>>>>>>> c13c0d83c7d3feb4c90186ceeacfdabb2ff734ba
import org.testng.Assert;
import org.testng.annotations.Test;

/**
<<<<<<< HEAD
<<<<<<< HEAD
 * Created by Анастасия Цыбулько on 21.06.2017.
 */
public class SquareTest {

        @Test
           public void testPoint() {
                   Point borsh = new Point(0.0, 0.0);
                    Assert.assertEquals(borsh.getDistance(new Point(5.0, 5.0)), 7.0710678118654755);
             }
           @Test
            public void testPoint2() {
                    Point borsh = new Point(-0.0, 0.0);
                   Assert.assertEquals(borsh.getDistance(new Point(-5.0, -5.0)), 7.0710678118654755);
               }

                   @Test
           public void testPoint3() {
                    Point borsh = new Point(500.0, 1532.43);
                    Assert.assertEquals(borsh.getDistance(new Point(50.0, 1.0)), 1596.1760068676638);
                }
        }

=======
=======
>>>>>>> c13c0d83c7d3feb4c90186ceeacfdabb2ff734ba
 * Created by Dmitriy on 07.06.2017.
 */
public class SquareTest {

    @Test
    public void testPoint() {
        Point borsh = new Point(0.0, 0.0);
        Assert.assertEquals(borsh.getDistance(new Point(5.0, 5.0)), 7.0710678118654755);
    }

    @Test
    public void testPoint2() {
        Point borsh = new Point(-0.0, 0.0);
        Assert.assertEquals(borsh.getDistance(new Point(-5.0, -5.0)), 7.0710678118654755);
    }

    @Test
    public void testPoint3() {
        Point borsh = new Point(500.0, 1532.43);
        Assert.assertEquals(borsh.getDistance(new Point(50.0, 1.0)), 1596.1760068676638);
    }
}
<<<<<<< HEAD
>>>>>>> origin/master
=======
>>>>>>> c13c0d83c7d3feb4c90186ceeacfdabb2ff734ba
