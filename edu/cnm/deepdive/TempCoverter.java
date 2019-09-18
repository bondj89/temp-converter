package edu.cnm.deepdive;

import java.util.*;

public class TempCoverter {

  private static Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
      convert(input);

  }

  private static void convert(Scanner scanner) {
    try {
      String line;
      while (!(line = scanner.nextLine().trim()).isEmpty()) {
        char finalChar = line.toUpperCase().charAt(line.length() - 1);
        if (finalChar == 'C') {
          double celsius = new ParseTemperature(line).invoke();
          System.out.printf("%.3fF%n", celsiusToFahrenheit(celsius));
        } else if (finalChar == 'F') {
          double fahrenheit = new ParseTemperature(line).invoke();
          System.out.printf("%.3fC%n", fahrenheitToCelsius(fahrenheit));
        }
      }
    } catch (NoSuchElementException expected) {
    }
  }

  public static double celsiusToFahrenheit(double celsius) {
    return 9 * celsius / 5 + 32;

  }

  public static double fahrenheitToCelsius(double fahrenheit) {
    return (fahrenheit - 32) * 5 / 9;
  }


  private static class ParseTemperature {

    private String line;

    public ParseTemperature(String line) {
      this.line = line;
    }

    public double invoke() {
      line = line.substring(0, line.length() - 1).trim();
      return Double.parseDouble(line);
    }
  }
}