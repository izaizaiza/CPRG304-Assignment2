/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package exceptions;




import org.junit.jupiter.api.BeforeEach;

//import org.junit.jupiter.api.Test;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author izalu
 * @author dlg12
 */
public class EmptyQueueException extends Exception{
    
    public EmptyQueueException(String message) {
        super(message);
    }
    
    
    
    @BeforeEach
    public void setUp() {
    }
    
    @Test
    public void testEmptyQueue(){
        fail("Intentional failure");
    }
}

    


