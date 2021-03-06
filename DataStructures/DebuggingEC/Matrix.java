//package 213Debugging;

public class Matrix {
  private static int MAXSIZE = 99;
  private Vect[] m = new Vect[MAXSIZE];
  private int rows;
  private int columns;

  // create default array of size 1
  public Matrix()
  {
    m[0] = new Vect();
    rows = 1;
    columns = 1;
  }

  // create an empty rxc matrix
  public Matrix(int r, int c)
  {
    rows = r;
    columns = c;

    for (int i = 0; i < c; i++)
    {
      // initialize matrix row
      m[i] = new Vect(c);
    }
  }

  // create array with dimensions r c
  // use r and c to parse args into an rxc matrix
  public Matrix(int r, int c, float[] args)
  {
    rows = r;
    columns = c;

    for (int i = 0; i < r; i++)
    {
      // initialize matrix row
      m[i] = new Vect(c);

      // loop through row, setting column values
      for (int j = 0; j < c; j++)
      {
        m[i].setValue(j, args[i*c + j]);  // changed 1st parameter i to j
      }
    }
  }

  // returns number of rows in Matrix
  public int getRows()
  {
    return(rows);
  }

  // returns number of Columns in Matrix
  public int getColumns()
  {
    return(columns);
  }

  // sets value at (r, c) to value
  public void setValue(int r, int c, float value)
  {
    m[r].setValue(c, value);
  }

  // returns row i as a Vect
  public Vect getRow(int r)
  {
    return(m[r]);
  }

  // returns column i as Vect
  public Vect getColumn(int c)
  {
    Vect columnVect = new Vect(rows);
    for (int i = 0; i < rows; i++)
      columnVect.setValue(i, m[i].getVect(c));
    return(columnVect);
  }

  // returns product of Matrix multiplication
  public Matrix matrixMult(Matrix m2)
  {
    Matrix product = new Matrix(rows, rows);
    for (int i = 0; i < rows; i++)
    {
      for (int j = 0; j < rows; j++)  // changed columns to rows
      {
    	// swapped i and j for the 1st two parameters
        product.setValue(i, j, m[i].dotProduct(m2.getColumn(j)));
      }
    }
    return(product);
  }

  // print matrix
  public void printMatrix()
  {
    for (int i = 0; i < rows; i++)
      m[i].printVect();
    System.out.println("");
  }
}
