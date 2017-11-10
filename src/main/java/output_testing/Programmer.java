package output_testing;

 
public class Programmer extends Author
{
	
    public   void write()
    {
        System.out.println("Writing code");
    }
 
    public static void main(String[] args)
    {
    	Author a = new Programmer();
        a.write();
    }
}


class Writer{
    public   void write()
    {
        System.out.println("Writing...");
    }
}
class Author extends Writer
{
    public   void write()
    {
        System.out.println("Writing book");
    }
}