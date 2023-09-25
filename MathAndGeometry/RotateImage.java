package MathAndGeometry;

public class RotateImage {
    public static void main(String[] args) {

    }

    public void rotate(int[][] matrix) {
        int leftIndex = 0;
        int rightIndex = matrix.length - 1;

        while (leftIndex < rightIndex) {
            for (int i = 0; i < rightIndex - leftIndex; i++) {
                int top = leftIndex;
                int bottom = rightIndex;
                int topLeft = matrix[top][leftIndex + i];
            }
        }
    }
    
}
