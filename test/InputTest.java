/*
* File: InputTest.java
* Author: Király Péter
* Copyright: 2023, Király Péter
* Group: Szoft-1-2-E
* Date: 2023-05-23
* Github: https://github.com/KiralyPeter/swteszt_dolgozat_2.git
* Licenc: GNU GPL
*/

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InputTest {
    MainFrame mainFrame;

    @BeforeEach
    public void initEach(){
        this.mainFrame = new MainFrame();
    }

    @Test
    public void testCheckInputAlpha(){
        boolean actual = this.mainFrame.checkInput("a");        
        assertFalse(actual);        
    }

    @Test
    public void testCheckInputNumeric(){
        boolean actual = this.mainFrame.checkInput("55");        
        assertTrue(actual);        
    }
    
}
