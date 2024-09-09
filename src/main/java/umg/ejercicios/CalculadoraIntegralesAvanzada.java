package umg.ejercicios;

import org.matheclipse.core.eval.ExprEvaluator;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.parser.client.SyntaxError;
import org.matheclipse.parser.client.math.MathException;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculadoraIntegralesAvanzada {
    private static final ExprEvaluator evaluator = new ExprEvaluator();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // El avanzada es porque andaba con autoestima, mas tarde se me pasa y regresamos a depresion
        System.out.println("Bienvenido a la Calculadora de Integrales Avanzada con Método de Sustitución");

        while (true) {
            System.out.print("Ingrese la función a integrar (o 'salir' para terminar): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("salir")) {
                break;
            }

            try {
                calcularYMostrarIntegral(input);
            } catch (Exception e) {
                System.out.println("Error al calcular la integral: " + e.getMessage());
            }
        }

        System.out.println("Gracias por usar la Calculadora de Integrales Avanzada Tilin. ¡Hasta luego, Ve a ver Loki!");
    }

    private static void calcularYMostrarIntegral(String funcion) throws SyntaxError, MathException {
        System.out.println("\nCalculando la integral de: " + funcion);
        // Aqui pues estan los pasos no hay mucho que explicar, ve al main ahi puse anotaciones del metodo
        String u = identificarSustitucion(funcion);
        System.out.println("Paso 1: Seleccionamos u = " + u);

        String du = calcularDerivada(u);
        System.out.println("Paso 2: Calculamos du/dx = " + du);

        String integralEnU = reescribirIntegral(funcion, u, du);
        System.out.println("Paso 3: Reescribimos la integral: " + integralEnU);

        String resultadoEnU = resolverIntegral(integralEnU);
        System.out.println("Paso 4: Resolvemos la integral simplificada: " + resultadoEnU);

        String resultadoFinal = sustituirDeVuelta(resultadoEnU, u);
        System.out.println("Paso 5: Volvemos a la variable original: " + resultadoFinal);

        System.out.println("\nResultado final: " + resultadoFinal + " + C\n");
    }

    // esto es para que la calculadora acepte caracteres especiales como los parentesis y
    // lo demas que ven ahi pues para que no le agarre la patada y funcione chido
    private static String identificarSustitucion(String funcion) {
        Pattern pattern = Pattern.compile("\\(([^()]+)\\)|(?:sin|cos|tan|exp)\\([^()]+\\)");
        Matcher matcher = pattern.matcher(funcion);
        if (matcher.find()) {
            return matcher.group();
        }
        return "x";
    }

    private static String calcularDerivada(String expresion) throws SyntaxError, MathException {
        String comando = "D[" + expresion + ", x]";
        IExpr resultado = evaluator.evaluate(comando);
        return resultado.toString();
    }

    private static String reescribirIntegral(String funcion, String u, String du) throws SyntaxError, MathException {
        // Reemplazar u en la función original
        String nuevaFuncion = funcion.replace(u, "u");

        // Dividir la función por du/dx para cancelar dx
        String comandoSimplificar = "Simplify[(" + nuevaFuncion + ")/(" + du + ")]";
        IExpr resultadoSimplificado = evaluator.evaluate(comandoSimplificar);

        // El resultado simplificado ya está en términos de u, solo necesitamos añadir du
        return resultadoSimplificado.toString() + "*du";
    }

    private static String resolverIntegral(String integralEnU) throws SyntaxError, MathException {
        String comando = "Integrate[" + integralEnU + ", u]";
        IExpr resultado = evaluator.evaluate(comando);
        return resultado.toString();
    }

    private static String sustituirDeVuelta(String resultadoEnU, String u) {
        return resultadoEnU.replace("u", "(" + u + ")");
    }
}