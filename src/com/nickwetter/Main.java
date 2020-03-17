package com.nickwetter;



public class Main
{

    public static void main(String[] args)
    {
        Matrix change = new Matrix();

        Matrix mat = new Matrix();
        mat.printMatrix();

        Matrix mat2 = Matrix.copyMatrix(mat);
        mat2.printMatrix();

        DeterminantMatrix dmat = new DeterminantMatrix(mat);
        dmat = dmat.getMinor(3,1,dmat);

        dmat.printMatrix();
    }
}
