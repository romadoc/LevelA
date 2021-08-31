package org.epam.tasks.fundamentals.randomdigits;

public class DigitGenerator {
    int amountOfNumbers;
    int outputType;

    public DigitGenerator(int amountOfNumbers, int outputType) {
        this.amountOfNumbers = amountOfNumbers;
        this.outputType = outputType;
    }

    private int[] createSolution(int i, int y) {
        int[] arrayOut = new int[i];
        for (int z : arrayOut) {
            arrayOut[z] = (int) (Math.random() * (200 - 2)) + 2;
            if (y == 0) {
                System.out.println(arrayOut[z]);
            } else {
                System.out.print(arrayOut[z] + "; ");
            }
        }
        return arrayOut;
    }

    public void startSolution() {
        int[] arrayOfDigits = createSolution(amountOfNumbers, outputType);
    }

}
