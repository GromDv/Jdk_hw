package compArrs;


public class CompareArrays {
    /**
     * Обобщённый метод, который принимает два массива и возвращает true, если они одинаковые,
     * и false в противном случае. Массивы могут быть любого типа данных, но должны иметь одинаковую длину
     * и содержать элементы одного типа.
     *
     * @param arr1 - любой
     * @param arr2 - любой
     * @return
     */
    public static <T> boolean compareArrays(T[] arr1, T[] arr2) {
        int indx = 0;
        if (arr1.length == arr2.length) {
            for (T e1 : arr1)
                if (!e1.equals(arr2[indx++]))
                    return false;
            return true;
        } else {
            System.out.print("Длины масивов не равны! ");
            return false;
        }
    }
}
