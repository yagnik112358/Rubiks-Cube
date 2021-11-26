import org.junit.Test;
import rubik.RubiksCube;
import rubik.RubiksCubeColor;
import rubik.Side;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class LastLayerTest {

    @Test
    public void setLastLayerPlusC1MajorT(){

        RubiksCube cube=new RubiksCube(3);
        cube.performMove("F");

        String s = cube.setLastLayerPlus();
        assertEquals("c1==Yellow : major clause","DBDRdrb",s);
    }
    @Test
    public void setLastLayerPlusC1MajorF(){
        RubiksCube cube=new RubiksCube(3);
        cube.performMove("FRUD");

        String s = cube.setLastLayerPlus();
        assertNotEquals("c1==Yellow : major clause","FURurf",s);
    }
    @Test
    public void setLastLayerPlusC2MajorT(){
        RubiksCube cube=new RubiksCube(3);
        cube.performMove("R");

        String s = cube.setLastLayerPlus();
        assertEquals("c2==Yellow : major clause","BDRdrb",s);


    }
    @Test
    public void setLastLayerPlusC2MajorF(){

        RubiksCube cube=new RubiksCube(3);
        cube.performMove("F");

        String s = cube.setLastLayerPlus();
        assertNotEquals("c2==Yellow : major clause","DBDRdru",s);
    }
    @Test
    public void setLastLayerPlusC3MajorT(){
        RubiksCube cube=new RubiksCube(3);
        cube.performMove("L");

        String s = cube.setLastLayerPlus();
        assertEquals("c3==Yellow : major clause","DDBDRdrb",s);
    }
    @Test
    public void setLastLayerPlusC3MajorF(){
        RubiksCube cube=new RubiksCube(3);
        cube.performMove("L");

        String s = cube.setLastLayerPlus();
        assertNotEquals("c3==Yellow : major clause","l",s);


    }
    @Test
    public void setLastLayerPlusC4MajorT(){
        RubiksCube cube=new RubiksCube(3);
        cube.performMove("B");

        String s = cube.setLastLayerPlus();
        assertEquals("c4==Yellow : major clause","BDRdrb",s);

    }
    @Test
    public void setLastLayerPlusC4MajorF(){
        RubiksCube cube=new RubiksCube(3);
        cube.performMove("B");

        String s = cube.setLastLayerPlus();
        assertNotEquals("c4==Yellow major clause","b",s);
    }
    @Test
    public void setLastLayerPlusAllTrue(){
        RubiksCube cube=new RubiksCube(3);
        String moves= cube.setLastLayerPlus();
        assertEquals("Test the moves when all sides orientation is correct","",moves);

    }
    @Test
    public  void setLastLayerPlusAllTrueF(){
        RubiksCube cube=new RubiksCube(3);
        String s = cube.setLastLayerPlus();
        assertEquals("Tests if function returns any moves when not required",0,s.length());
    }
}
