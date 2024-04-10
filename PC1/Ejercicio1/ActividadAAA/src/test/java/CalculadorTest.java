import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.example.Calculador;

public class CalculadorTest {

    @Test
    public void testSum_PositiveNumbers_ShouldReturnCorrectSum() {
        Calculador calculador = new Calculador();
        //Arrange
        int numeroA = 10;
        int numeroB = 5;
        //Act
        int resultado = calculador.sumar(numeroA, numeroB);
        //assert
        assertEquals(15, resultado, "10 + 5 debería ser 15");
    }

    @Test
    public void testRestar_PositiveNumbers_ShouldReturnCorrectDifference() {
        Calculador calculador = new Calculador();
        //arrange
        int numeroA = 10;
        int numeroB = 5;
        //act
        int resultado = calculador.restar(numeroA, numeroB);
        //assert
        assertEquals(5, resultado, "10 - 5 debería ser 5");
    }

    @Test
    public void testMultiplicacion_PositiveNumbers_ShouldReturnCorrectProduct() {
        Calculador calculador = new Calculador();
        //arrange
        int numeroA = 4;
        int numeroB = 3;
        //act
        int resultado = calculador.multiplicacion(numeroA, numeroB);
        //assert
        assertEquals(12, resultado, "4 * 3 debería ser 12");
    }

    @Test
    public void testDivision_PositiveNumbers_ShouldReturnCorrectQuotient() {
        Calculador calculador = new Calculador();
        //arrange
        int numeroA = 10;
        int numeroB = 2;
        //act
        double resultado = calculador.division(numeroA, numeroB);
        //assert
        assertEquals(5.0, resultado, "10 / 2 debería ser 5.0");
    }

    @Test
    public void testDivision_DivideByZero_ShouldThrowArithmeticException() {
        Calculador calculador = new Calculador();
        //arrange
        int numeroA = 10;
        int numeroB = 0;
        //Act & assert
        assertThrows(ArithmeticException.class, () -> {
            //act
            calculador.division(numeroA, numeroB);
        });
    }

    @Test
    public void testRestar_NegativeNumbers_ShouldReturnCorrectDifference() {
        Calculador calculador = new Calculador();
        //arrange
        int numeroA = -10;
        int numeroB = -5;
        //act
        int resultado = calculador.restar(numeroA, numeroB);
        //assert
        assertEquals(-5, resultado, "-10 - (-5) debería ser -5");
    }

    @Test
    public void testMultiplicacion_NegativeAndPositiveNumbers_ShouldReturnCorrectProduct() {
        Calculador calculador = new Calculador();
        //arrange
        int numeroA = -4;
        int numeroB = 3;
        //act
        int resultado = calculador.multiplicacion(numeroA, numeroB);
        //assert
        assertEquals(-12, resultado, "-4 * 3 debería ser -12");
    }

    @Test
    public void testDivision_NegativeNumbers_ShouldReturnCorrectQuotient() {
        Calculador calculador = new Calculador();
        //arrange
        int numeroA = -10;
        int numeroB = 2;
        //act
        double resultado = calculador.division(numeroA, numeroB);
        //assert
        assertEquals(-5.0, resultado, "-10 / 2 debería ser -5.0");
    }
}