package umg.ejercicios;

/* Este Main esta pa´flexiar nomas  */
/* Porque el code esta en la clase  */
/* Asi que ya se la saben  */

/* MISTBORN cambió mi Vida  */

/* Método de Sustitución
El método de sustitución es una técnica que se utiliza para simplificar una función complicada y convertirla en otra más fácil de integrar.
Es útil cuando una función contiene una composición de funciones (es decir, cuando una función está dentro de otra).
Pasos:
1. Elegir una expresión para 'u': Selecciona una parte de la función original que sea fácil de derivar y que simplifique la integral.
Usualmente se elige una función dentro de paréntesis o en el denominador de una fracción.
2. Calcular 'du': Deriva la expresión elegida para 'u' respecto a la variable original (generalmente 'x'). Esto te dará 'du'.
3. Reemplazar en términos de 'u': Sustituye tanto la expresión original como su diferencial (dx) en función de 'u' y 'du'.
4. Calcular la integral en función de 'u': Integra la nueva expresión, que debería ser más sencilla.
5. Volver a la variable original: Finalmente, sustituye nuevamente 'u' por la expresión original para obtener el resultado en términos de la variable original.
Notas adicionales:
•	Integral de fracciones: Cuando tienes una integral en forma de división entre dos funciones, generalmente el denominador será lo que se elija como 'u'. Ejemplo:
  ∫ f'(x) / f(x) dx, donde f(x) será igual a 'u'.
•	Funciones con paréntesis: Cuando ves una función dentro de paréntesis y otra fuera multiplicándola, la expresión dentro del paréntesis será 'u'.
Para saber si puedes aplicar sustitución, deriva la función dentro del paréntesis. Si la derivada se parece (en cuanto a su estructura) a la función fuera del paréntesis, puedes usar el método de sustitución.
  Ejemplo: ∫ x²(2x³ - 5)⁴ dx
  Aquí, puedes elegir u = 2x³ - 5. La derivada de u es du = 6x² dx, y como x² está fuera del paréntesis, es compatible para la sustitución.
•	Integrales en forma de du/u: Si encuentras una integral en la forma du/u, como dx/x, dt/t, etc., la solución siempre será el logaritmo natural de la variable en valor absoluto:
  ∫ 1/u du = ln|u| + C
  Ejemplo: ∫ dx/x = ln|x| + C
•	No olvidar el '+C': En las integrales indefinidas, siempre debes agregar la constante de integración +C al final del resultado.
 */

/* MISTBORN cambió mi Vida x2 */