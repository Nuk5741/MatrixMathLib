package com.nickwetter;

public class Matrix implements Comparable <Matrix>
{
    //Instance fields
    protected double[][] values;
    private final int rows;
    private final int columns;

    //Empty constructor creates a new 3x3 identity matrix
    public Matrix()
    {
        this.rows = 3;
        this.columns = 3;
        this.values = new double[][]
                {
                        {1,0,0},
                        {0,1,0},
                        {0,0,1},
                };
    }

    //This constructor provides custom matrix functionality
    //Creates a matrix of user given dimensions and fills it withs zeros
    public Matrix(int rows, int columns)
    {
        this.rows=rows;
        this.columns=columns;
        this.values=new double[this.rows][this.columns];
    }

    //Setters and getters
    /*There is no getValues because we provide comparable
      functionality elsewhere in the class

      I also provide no methods to alter the rows and columns of a matrix,
      upon creation they are stuck with their values
     */
    public int getRows(){return this.rows;}
    public int getColumns(){return this.columns;}
    public void setValues(int row, int column, double value)
    {
        try
        {
            this.values[row-1][column-1] = value;
        }
        catch(ArrayIndexOutOfBoundsException a)
        {
            System.out.println("Whoops, you seem to have entered a value out of bounds.");
        }
    }

    //Finds a minor determinant of a matrix at a given row and column
    //Used in DeterminantMatrix class, implemented here because it's easier
    protected Matrix findMinor(int r, int c)
    {
        Matrix mat = new Matrix(this.rows-1,this.columns-1);
        int ctrR = 1;
        int ctrC = 1;
        for(int i = 0; i<this.rows;i++)
        {
            if(i == r-1)
                continue;
            for(int j = 0; j< this.columns; j++)
            {
                if(j==c-1)
                    continue;
                mat.setValues(ctrR,ctrC,this.values[i][j]);
                ctrC++;
            }
            ctrR++;
            ctrC=1;
        }
        return mat;
    }


    //TODO: Finish implementation
    //returns null if the determinant does not exist
    public Double findDeterminant()
    {
        Double value = new Double(0);
        //First check if 2x2
        if(this.rows!=this.columns)
        {
            value = null;
        }
        else if(this.rows==1) //We only need to check the number of rows because the method will exit if not square
        {
            return this.values[0][0];
        }
        else if(this.rows==2)
        {
            value = (this.values[0][0]*this.values[1][1])-(this.values[0][1]*this.values[1][0]);
        }
        else
        {
            //TODO:Implement finding the determinant by co-factors

        }
        return value;
    }

    //Prints a matrix to the console
    public void printMatrix()
    {
        System.out.println();
        for(double[] d: this.values)
        {
            System.out.print("[  ");
            for(double f:d)
            {
                System.out.print(f+"  ");
            }
            System.out.print("]\n");
        }
        System.out.println();
    }

    //Copies a matrix exactly as the given input matrix
    public static Matrix copyMatrix(Matrix mat)
    {
        Matrix ans = new Matrix(mat.getRows(),mat.getColumns());
        //System.arraycopy(mat.values,0,ans.values,0,mat.values.);
        for (int i = 0; i < mat.values.length; i++)
        {
            System.arraycopy(mat.values[i], 0, ans.values[i], 0, mat.values[0].length);
        }
        return ans;
    }

    /*Copies the values of a matrix from one to another, used in some
    various methods within the library but not intended for outside use;
    just makes some things easier for me
     */
    protected static void copyValuesArray(Matrix src, Matrix dest)
    {
        if(src.rows==dest.rows&&src.columns==dest.columns)
        {
            for (int i = 0; i < src.values.length; i++)
            {
                System.arraycopy(src.values[i], 0, dest.values[i], 0, src.values[0].length);
            }
        }   //TODO: Add exception functionality V V
        else
            System.out.println("Matrices must be same dimensions to copy values!");

    }


    //Compareto method functionality
    @Override
    public int compareTo(Matrix m)
    {

        return 0;
    }
}
