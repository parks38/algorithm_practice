package practice;

import java.util.Scanner;

public class if_switch {
    public static void main (String[] args){
        System.out.println("what grade is my score? ");
        Scanner input = new Scanner(System.in);

        int score = input.nextInt();
        System.out.println(ifMethod(score));
        System.out.println(switchMethod(score));

    }

    public static String ifMethod(int score) {
        String grade = "";
        if(score >= 90) {
            grade = "A";
        } else if(score >= 80) {
            grade = "B";
        } else if (score >= 70 ){
            grade = "C";
        } else if (score >= 60 ){
            grade = "D";
        } else {
            grade = "F";
        }
        return grade;
    }

    public static String switchMethod(int score) {
        String grade = "";
        score = score / 10;
        switch(score){
            case 10: case 9:
                grade = "A";
                break;
            case 8 :
                grade = "B";
                break;
            case 7 :
                grade = "C";
                break;
            case 6 :
                grade = "D";
                break;
            default :
                grade = "F";
        }
        return grade;
    }
}
