//
//На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга. И вывести Доску. Пример вывода доски 8x8
//        0x000000
//        0000x000
//        00x00000


public class Task03 {
    public static void main(String[] args) {
        int[] queensPos = new int[8];
        findPosition(0, queensPos);

        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                if (queensPos[row] == column) {
                    System.out.print("x ");
                } else {
                    System.out.print("o ");
                }
            }
            System.out.println();
        }
    }


    private static boolean findPosition(int row, int[] queensPos) {
        if (row == 8) {
            return true;
        }
        for (int column = 0; column < 8; column++) {
            boolean safePos = true;
            for (int i = 0; i < row; i++) {

                if (queensPos[i] == column || queensPos[i] == column - row + i || queensPos[i] == column + row - i) {
                    safePos = false;
                    break;
                }
            }
            if (safePos) {
                queensPos[row] = column;
                if (findPosition(row + 1, queensPos)) {
                    return true;
                }
            }
        }
        return false;
    }

}







