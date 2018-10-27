import java.util.* ;

public class  ArrayList implements List
{
  Object[] data ;
  int capacity ;
  int size ;

  public ArrayList(int initialCapacity )
     {


          this.data = new Object[initialCapacity];
           capacity  =  initialCapacity ;

      }
      /**

       * Constructs an empty list with an initial capacity of ten.

       */

      public ArrayList()
      {

          this(10);

      }

      void resize()
      {
		  System.out.println( "Inside the resize function" ) ;
          Object[] newData = new Object[capacity*2]  ;
          for( int i1=0 ; i1<size ; i1++ )
            {
				newData[i1] = data[i1]  ;
			}
		  capacity = capacity*2	  ;

          data = newData ;
	  }


	public void add(Object obj)
	{
        if( size >= capacity )
          resize() ;

         data[size] = obj ;
         size++ ;
	}



	public void add(int pos, Object obj)
	{

	   if( pos < 0 || pos > size() )
	       return ;
	   //it is full
        if( size >= capacity )
          resize() ;


       System.arraycopy(data, pos, data, pos + 1,
                        size - pos) ;

        data[pos] = obj ;
        size++ ;
	}

	public Object get(int pos)
	{
		if ( pos >= 0 && pos < size )
		   return data[pos] ;
		else
		   return null ;
	}


//	     2

//	0 1  2     3   4   5
//	1 2  3     4

//    1 2  4  null


	public Object remove(int pos)
	{
        Object result ;
        int numMoved = size - pos - 1;

        if (numMoved > 0)

            System.arraycopy(data, pos+1, data, pos,

                             numMoved);
        result = data[--size] ;
        data[size] = null;

        return result ;
	}

	public void printArray()
	{
		System.out.println( Arrays.toString(data)  )   ;
	}

	public int size()
	{
       return size ;
	}



   public static void main( String args[] )
     {
          ArrayList obj1 = new ArrayList() ;
          obj1.add( "1" ) ; obj1.add( "2" ) ;
          obj1.add( "3" ) ;
          obj1.remove(1) ;
          obj1.add( 1 , "2" ) ;
          obj1.printArray() ;



	 }


}