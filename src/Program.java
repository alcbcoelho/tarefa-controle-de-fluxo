import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double val1 = getGradeInput(Order.PRIMEIRA, sc);
        double val2 = getGradeInput(Order.SEGUNDA, sc);
        double val3 = getGradeInput(Order.TERCEIRA, sc);
        double val4 = getGradeInput(Order.QUARTA, sc);

        List<Grade> grades = new ArrayList<>(Arrays.asList(new Grade(val1), new Grade(val2), new Grade(val3), new Grade(val4)));

        Grade finalGrade = getFinalGrade(grades);
        System.out.println("\nMédia final: " + finalGrade);
        printStudentSituation(finalGrade);
    }

    public static double getGradeInput(Order order, Scanner scanner) {
        System.out.print("Insira a " + order.toString().toLowerCase() + " nota: ");
        return scanner.nextDouble();
    }

    private static Grade getFinalGrade(List<Grade> grades) {
        double sum = grades.stream().map(Grade::getValue).reduce(0.0, Double::sum);
        return new Grade(sum / grades.size());
    }

    public static void printStudentSituation(Grade finalGrade) {

        if (finalGrade.getValue() >= 7.0)
            System.out.println("Estudante APROVADO");
        else if (finalGrade.getValue() >= 5.0)
            System.out.println("Estudante DE RECUPERAÇÃO");
        else
            System.out.println("Estudante REPROVADO");
    }
}
