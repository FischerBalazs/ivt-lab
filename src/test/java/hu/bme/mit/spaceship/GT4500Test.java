package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class GT4500Test {

  private GT4500 ship;
  private TorpedoStore primary = mock(TorpedoStore.class);
  private TorpedoStore secondary = mock(TorpedoStore.class);

  @BeforeEach
  public void init(){
    this.ship = new GT4500(primary,secondary);
  }

  @Test
  public void fireTorpedo_Single_Success(){
    // Arrange
    when(primary.fire(1)).thenReturn(true);
    when(secondary.fire(1)).thenReturn(true);

    // Act
    boolean result = ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
    assertEquals(true, result);
    verify(primary,times(0)).fire(1);
    verify(secondary,times(0)).fire(1);

  }

  @Test
  public void fireTorpedo_All_Success(){
    // Arrange
    when(primary.fire(1)).thenReturn(true);
    when(secondary.fire(1)).thenReturn(true);


    // Act
    boolean result = ship.fireTorpedo(FiringMode.ALL);

    // Assert
    assertEquals(true, result);
    verify(primary,times(1)).fire(1);
    verify(secondary,times(1)).fire(1);
  }
  @Test
  public void fireTorpedo_Single_Success_other(){
       // Arrange
       when(primary.fire(1)).thenReturn(true);
       when(secondary.fire(1)).thenReturn(true);
   
       // Act
       boolean result = ship.fireTorpedo(FiringMode.SINGLE);
   
       // Assert
       assertEquals(true, result);
       verify(primary,times(0)).fire(1);
       verify(secondary,times(0)).fire(1);
  }

  @Test
  public void fireTorpedo_All_Failure(){
    // Arrange
    when(primary.fire(1)).thenReturn(false);
    when(secondary.fire(1)).thenReturn(false);


    // Act
    boolean result = ship.fireTorpedo(FiringMode.ALL);

    // Assert
    assertEquals(true, result);
    verify(primary,times(0)).fire(1);
    verify(secondary,times(0)).fire(1);
  }

  @Test
  public void fireTorpedo_Single_Failure(){
    // Arrange
    when(primary.fire(1)).thenReturn(false);
    when(secondary.fire(1)).thenReturn(false);

    // Act
    boolean result = ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
    assertEquals(true, result);
    verify(primary,times(0)).fire(1);
    verify(secondary,times(0)).fire(1);

  }
  @Test
  public void fireTorpedo_Single_Failure_other(){
    // Arrange
    when(primary.fire(1)).thenReturn(false);
    when(secondary.fire(1)).thenReturn(false);

    // Act
    boolean result = ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
    assertEquals(true, result);
    verify(primary,times(0)).fire(1);
    verify(secondary,times(0)).fire(1);

  }
  @Test
  public void fireTorpedo_Single_and_All_Success(){
    // Arrange
    when(primary.fire(1)).thenReturn(true);
    when(secondary.fire(1)).thenReturn(true);


    // Act
    ship.fireTorpedo(FiringMode.ALL);
    boolean result = ship.fireTorpedo(FiringMode.ALL);

    // Assert
    assertEquals(true, result);
    verify(primary,times(1)).fire(1);
    verify(secondary,times(1)).fire(1);
  }

}
