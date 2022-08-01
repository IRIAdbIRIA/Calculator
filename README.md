# Calculator

To start program you need to open kalkulator.iml via Jetbrains IntelliJ IDEA or run Calculator.java via in src directory. But if you want to open it by running Calculator.java, you may need to move eurofxref-daily.XML file into src directory. Instruction to run java file you can find on this page:
https://www.tutorialspoint.com/How-to-run-a-java-program.

Program will ask you to enter currency name and amount in EUR for exchange.
If you enter something wrong like name that not on list or negative currency amount program will ask you to start from entering currency name again.

After successfully entering currency name and EUR amount program returns amount of previously specified currency that you can exchange your entered EUR for.
After that program returns to start and ask you to enter currency name again

To close program you need to type "ESC" at any time


TESTS:

For tests was created CalculatorForTest Class. The only different between Calculator and CalculatorForTests is "return".Returning double instead of printing into System.out and reading from it just easier.


Made on jdk 1.8
