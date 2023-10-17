package calculator;

public class Main {
    public static void main(String[] args) {
        Long al = 5L;
        Float bl = 7F;
        System.out.println("Сумма = " + Calc.sum(al, bl) + ", ("
                + al.getClass().getTypeName() + " + " + bl.getClass().getTypeName() + ")");
        Float af = 5F;
        Double bf = 7.;
        System.out.println("Произведение = " + Calc.multiply(af, bf) + ", ("
                + af.getClass().getTypeName() + " * " + bf.getClass().getTypeName() + ")");
        Double ad = 35D;
        Integer bd = 7;
        System.out.println("Частное = " + Calc.divide(ad, bd) + ", ("
                + ad.getClass().getTypeName() + " / " + bd.getClass().getTypeName() + ")");
        Integer ai = 7;
        Float bi = 5.356F;
        System.out.println("Разность = " + Calc.subtract(ai, bi) + ", ("
                + ai.getClass().getTypeName() + " - " + bi.getClass().getTypeName() + ")");
    }
}
