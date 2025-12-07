class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] temp = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                temp[i][j] = matrix[i][j];
            }
        }

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(temp[i][j]==0){
                    for(int k=0;k<cols;k++){
                        matrix[i][k]=0;
                    }
                    for(int l=0;l<rows;l++){
                        matrix[l][j]=0;
                    }
                }
            }
        }  
    }
}