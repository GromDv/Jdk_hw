package compArrs;

public class compArrsApp {
    public static void main(String[] args) {
        Integer[] ar1 = new Integer[]{1, 2, 3, 4, 5};
        Integer[] ar2 = new Integer[]{1, 2, 3, 4, 5};

        System.out.println(CompareArrays.compareArrays(ar1, ar2));

        String[] str1 = new String[]{"we", "wrre", "eert", "ertert"};
        String[] str2 = new String[]{"we", "wrre", "eert", "ertert"};

        System.out.println(CompareArrays.compareArrays(str1, str2));

        Long[] ar11 = new Long[]{1L, 2L, 3L, 4L, 5L};
        Long[] ar12 = new Long[]{1L, 2L, 20L, 4L, 5L};

        System.out.println(CompareArrays.compareArrays(ar11, ar12));

        Integer[] ar21 = new Integer[]{1, 2, 3, 4, 5};
        Integer[] ar22 = new Integer[]{1, 2, 4, 5};

        System.out.println(CompareArrays.compareArrays(ar21, ar22));
    }
}
