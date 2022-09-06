import java.util.Arrays;
public class Cube {
    // Colors according to its number:
    // 0: Red | 1: White | 2: Orange | 3: Yellow | 4: Green | 5: Blue
    private int[][] array = {
        {0,0,0,0,0,0,0,0,0},
        {1,1,1,1,1,1,1,1,1},
        {2,2,2,2,2,2,2,2,2},
        {3,3,3,3,3,3,3,3,3},
        {0,1,2,3,4,5,6,7,8},
        {0,1,2,3,4,5,6,7,8}
    };
    //Behaviors to move from one face to another. In a cube we can move to the right, left, upper, bottom of the cube
    public void right() {
        int[] temp = array[0]; //Stores the values stored in the face 0
        array[0] = array[1]; //The face 1 is now face 0
        int[] temp2 = array[3]; //Store another temporary array to store the values in face 3
        array[3] = temp; //The face 0 is now face 3
        temp = array[2]; //Store face 2 temporarily
        array[2] = temp2; //The face 3 is now face 2
        array[1] = temp; //The face 2 is now face 1
        //The squares in face 4 and 5 change positions
        //Face 4 adjustments 
        rotateFaceRight(4);
        //Face 5 adjustments
        rotateFaceLeft(5);
    }
    public void left(){
        //Face 3 is face 0
        int[] temp = array[0];
        array[0] = array[3];
        //Face 0 is face 1
        int[] temp2 = array[1];
        array[1] = temp;
        //Face 1 is face 2
        temp = array[2];
        array[2] = temp2;
        //Face 2 is face 3
        array[3] = temp;
        //Face 4 adjustments
        rotateFaceLeft(4);
        //Face 5 adjustments
        rotateFaceRight(5);
    }
    public String toString(){
        String cube = "";
        for (int i=0; i < array.length; i++) {
            cube += Arrays.toString(array[i]) + "\n";
        }
        return cube;
    }
    //Private methods
    private void rotateFaceRight(int numFace){
        int[] temp = Arrays.copyOf(array[numFace],9);
        int start = 6;
        for(int i=0; i < array[numFace].length; i+=3){
            array[numFace][i] = temp[start];
            array[numFace][i+1] = temp[start - 3];
            array[numFace][i+2] = temp[start - 6];
            ++start;
        }
    }
    private void rotateFaceLeft(int numFace){
        int start = 2;
        int[] temp = Arrays.copyOf(array[numFace],9);
        for(int i=0; i < array[5].length; i+=3){
            array[numFace][i] = temp[start];
            array[numFace][i+1] = temp[start + 3];
            array[numFace][i+2] = temp[start + 6];
            --start;
        }
    }
}