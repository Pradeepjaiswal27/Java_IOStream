package task1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Student implements java.io.Serializable{

	public int id;
	public String name;
	public Student(int id, String name) {
		
		this.id = id;
		this.name = name;
	}
	 public static void main(String[] args)
	    {   
	        Student object = new Student(111, "raj");
	        String filename ="example.txt";
	        
	        // Serialization 
	        try
	        {   
	           
	            FileOutputStream file = new FileOutputStream(filename);
	            ObjectOutputStream out = new ObjectOutputStream(file);
	            
	            
	            out.writeObject(object);
	            
	            out.close();
	            file.close();
	            
	            System.out.println("Object has been serialized");

	        }
	        
	        catch(IOException ex)
	        {
	            System.out.println("IOException is caught");
	        }


	        Student object1 = null;

	        // Deserialization
	        try
	        {   
	            
	            FileInputStream file = new FileInputStream(filename);
	            ObjectInputStream in = new ObjectInputStream(file);
	            
	            
	            object1 = (Student)in.readObject();
	            
	            in.close();
	            file.close();
	            
	            System.out.println("Object has been deserialized ");
	            System.out.println("id = " + object1.id);
	            System.out.println("name = "+ object1.name);
	        }
	        
	        catch(IOException ex)
	        {
	            System.out.println("IOException is caught");
	        }
	        
	        catch(ClassNotFoundException ex)
	        {
	            System.out.println("ClassNotFoundException is caught");
	        }

	    }
	
}
