import org.junit.Test;
import rubik.RubiksCube;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class MiddleLayerTest {

    @Test
    public void setMiddleLayeraMajorT(){

        RubiksCube cube=new RubiksCube(3);
        cube.performMove("l");

        String s = cube.setPlus()+cube.setCorner();
        s = s + cube.setMiddleLayer();
        assertEquals("Cx==0 : major clause","L",s);
    }
    @Test
    public void setMiddleLayeraMajorF(){

        RubiksCube cube=new RubiksCube(3);
        cube.performMove("LD");
        String s = cube.setPlus()+cube.setCorner();

        s = s + cube.setMiddleLayer();
        assertNotEquals("Cx==0 : major clause","DB",s);
    }
    @Test
    public void setMiddleLayerbMajorT(){

        RubiksCube cube=new RubiksCube(3);
        cube.performMove("R");
        String s = cube.setPlus()+cube.setCorner();

        s = s + cube.setMiddleLayer();
        assertEquals("Cx==2 : major clause","r",s);
    }
    @Test
    public void setMiddleLayerbMajorF(){

        RubiksCube cube=new RubiksCube(3);
        cube.performMove("DR");
        String s = cube.setPlus()+cube.setCorner();

        s = s + cube.setMiddleLayer();
        assertNotEquals("Cx==2 : major clause","Dr",s);
    }
    @Test
    public void setMiddleLayercMajorT(){

        RubiksCube cube=new RubiksCube(3);
        cube.performMove("RU");
        String s = cube.setPlus()+cube.setCorner();

        s = s + cube.setMiddleLayer();
        assertEquals("Cy==1 : major clause","ur",s);
    }
    @Test
    public void setMiddleLayercMajorF(){

        RubiksCube cube=new RubiksCube(3);
        cube.performMove("RUDr");
        String s = cube.setPlus()+cube.setCorner();

        s = s + cube.setMiddleLayer();
        assertNotEquals("Cy==1 : major clause","DRb",s);
    }
    @Test
    public void setMiddleLayerdMajorT(){

        RubiksCube cube=new RubiksCube(3);
        cube.performMove("RuF");
        String s = cube.setPlus()+cube.setCorner();

        s = s + cube.setMiddleLayer();
        assertEquals("Cz==0 : major clause","fUr",s);
    }
    @Test
    public void setMiddleLayerdMajorF(){

        RubiksCube cube=new RubiksCube(3);
        cube.performMove("RfU");
        String s = cube.setPlus()+cube.setCorner();

        s = s + cube.setMiddleLayer();
        assertNotEquals("Cz==0 : major clause","DBDR",s);
    }
    @Test
    public void setMiddleLayereMajorT(){

        RubiksCube cube=new RubiksCube(3);
        cube.performMove("RRu");
        String s = cube.setPlus()+cube.setCorner();

        s = s + cube.setMiddleLayer();
        assertEquals("Cz==2 : major clause","URR",s);
    }
    @Test
    public void setMiddleLayereMajorF(){

        RubiksCube cube=new RubiksCube(3);
        cube.performMove("fUl");
        String s = cube.setPlus()+cube.setCorner();
        s = s + cube.setMiddleLayer();
        assertNotEquals("Cz==2 : major clause","Drb",s);
    }

}
