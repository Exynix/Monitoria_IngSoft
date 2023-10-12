package co.edu.javeriana.sistemas.ingsoft;

//import jdk.internal.net.http.common.Pair;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        System.out.println("--------------------//------------------");
        System.out.println("Bievenido. A continación puede calcular su promedio ponderado.");
        obtainUserInput();


    }


    /* User input is formed by 3 pieces of data:
    1. Grade obtained in the course.
    2. Number of credits of that course.
    3. NUmber of total credits approved in the career.
     */
    public static void obtainUserInput(){

        float courseGrade;
        int courseCredits;
        int totalCreditsApproved;
        ArrayList<Pair<Float, Integer>> grade_Credits_Array = new ArrayList<>();
        int creditsLoopCounter = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Numero de creditos totales aprovados: ");
        totalCreditsApproved = scanner.nextInt();

        while(creditsLoopCounter != totalCreditsApproved){
            System.out.println("Nota obtenida en  la materia: ");
            courseGrade = scanner.nextFloat();
            System.out.println("Numero de créditos de la materia: ");
            courseCredits = scanner.nextInt();

            grade_Credits_Array.add(new Pair<>(courseGrade, courseCredits));
            creditsLoopCounter += courseCredits;
        }

        float promedioPonderado =  calculateWeightedAverage(grade_Credits_Array, totalCreditsApproved);

        System.out.println("Listos! El promedio ponderado es: " + promedioPonderado);
    }

    public static float calculateWeightedAverage(ArrayList<Pair<Float, Integer>> grades_CreditsArray, int totalCreditsApproved){

        float weightedAverage;
        float denominator = 0;

        for(Pair<Float, Integer> pair : grades_CreditsArray){
            denominator += pair.getKey() * pair.getValue();
            System.out.println(denominator);
        }


        weightedAverage = denominator/totalCreditsApproved;

        return weightedAverage;
    }

}
