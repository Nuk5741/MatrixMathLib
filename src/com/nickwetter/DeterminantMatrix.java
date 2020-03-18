package com.nickwetter;

public class DeterminantMatrix extends Matrix
{
    //Inherits rows, columns, and values from Matrix
    private double value;
    private String test;

    public DeterminantMatrix()
    {
        super();
        this.value = 1;
        /*I know magic numbers are bad practice but since
        the empty constructor for Matrix instantiates an identity
        matrix, I do it this way for efficiency
         */
    }

    public DeterminantMatrix(Matrix mat)
    {
        super(mat.getRows(),mat.getColumns());
        Matrix.copyValuesArray(mat, this);
        this.value=mat.findDeterminant();
    }

    //Getters and Setters
    public double getValue(){return this.value;}

    //Gets a minor determinant of a matrix at a given row and column
    public DeterminantMatrix getMinor(int r, int c, DeterminantMatrix dmat)
    {
        DeterminantMatrix ans = new DeterminantMatrix(dmat.findMinor(r,c));
        return ans;
    }


    @Override
    public void printMatrix()
    {
        System.out.println();
        for(double[] d: this.values)
        {
            System.out.print("|  ");
            for(double f:d)
            {
                System.out.print(f+"  ");
            }
            System.out.print("|\n");
        }
        System.out.println();
    }
}
