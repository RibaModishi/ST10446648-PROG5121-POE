/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package st10446648;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 *
 * @author Ore
 */
public class MessageTest 
{
    Message message = new Message();
    public MessageTest() {}

    @Test
    public void testGetMessage() 
    {
      String expected ="I have arrived";
      String actual = message.getMessage();
      
      assertEquals(expected,actual);
    }
    
}
