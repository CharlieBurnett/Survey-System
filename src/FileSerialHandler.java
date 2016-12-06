import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class FileSerialHandler {

	public FileSerialHandler() {
		// TODO Auto-generated constructor stub
	}
	public void save(Survey s)
	{
		try{
		FileOutputStream fout = new FileOutputStream(s.surveyName+".ser");
		ObjectOutputStream oout = new ObjectOutputStream(fout);
		oout.writeObject(s);
		oout.close();
		fout.close();
		}
		catch(IOException e)
		{
			System.out.println("IOException in save");
			e.printStackTrace();
		}
		
	}
	
	public void saveTest(Test t)
	{
		try{
		FileOutputStream fout = new FileOutputStream(t.surveyName+".ser");
		ObjectOutputStream oout = new ObjectOutputStream(fout);
		oout.writeObject(t);
		oout.close();
		fout.close();
		}
		catch(IOException e)
		{
			System.out.println("IOException in save");
			e.printStackTrace();
		}
		
	}
	
	public Survey load(String path)
	{
		try
	      {
			FileInputStream fin = new FileInputStream(path+ ".ser");
	        ObjectInputStream oin = new ObjectInputStream(fin);
	        Survey s = (Survey) oin.readObject();
	        oin.close();
	        fin.close();
	        return s;
	      }
		catch(IOException e)
	      {
			System.out.println("IOException in load");
	        e.printStackTrace();
	        return null;
	      }
		catch(ClassNotFoundException c)
	      {
			System.out.println("IOException in save");
	         c.printStackTrace();
	         return null;
	       }
	}
	public Test loadTest(String path)
	{
		try
	      {
			FileInputStream fin = new FileInputStream(path+ ".ser");
	        ObjectInputStream oin = new ObjectInputStream(fin);
	        Test t = (Test) oin.readObject();
	        oin.close();
	        fin.close();
	        return t;
	      }
		catch(IOException e)
	      {
			System.out.println("IOException in load");
	        e.printStackTrace();
	        return null;
	      }
		catch(ClassNotFoundException c)
	      {
			System.out.println("IOException in save");
	         c.printStackTrace();
	         return null;
	       }
	}

}
