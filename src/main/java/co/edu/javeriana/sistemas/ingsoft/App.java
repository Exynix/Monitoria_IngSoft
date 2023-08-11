package co.edu.javeriana.sistemas.ingsoft;

import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        System.out.println("--------------------//------------------");
        System.out.println("Bievenido. A continación puede calcular su promedio ponderado.");


    }


    /* User input is formed by 3 pieces of data:
    1. Grade obtained in the course.
    2. Number of credits of that course.
    3. NUmber of total credits approved in the career.
     */
    public void obtainUserInput(){

        float courseGrade;
        int courseCredits;
        int totalCreditsApproved;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nota obtenida en  la materia: ");
        courseGrade = scanner.nextFloat();
        System.out.println("Numero de créditos de la materia: ");
        courseCredits = scanner.nextInt();
        System.out.println("Numero de creditos totales aprovados: ");
        totalCreditsApproved = scanner.nextInt();

        calculateWeightedAverage();
    }

    public float calculateWeightedAverage(float courseGrade, int courseCredits, int totalCreditsApproved){

        float weightedAverage;

        weightedAverage = (courseCredits * courseCredits)/totalCreditsApproved;

        return weightedAverage;
    }

}
