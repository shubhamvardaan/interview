package design_pattern;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializeDemo implements Serializable {
	public static void main(String[] args) {
		Singleton singleton = Singleton.INSTANCE;
		singleton.setValue(1);
		try {
			FileOutputStream fileout = new FileOutputStream("out.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileout);
			out.writeObject(singleton);
			out.close();
			fileout.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		singleton.setValue(2);

		Singleton singleton2 = null;
		try {
			FileInputStream filein = new FileInputStream("out.ser");
			ObjectInputStream in = new ObjectInputStream(filein);
			singleton2 = (Singleton) in.readObject();
			in.close();
			filein.close();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (singleton == singleton2)
			System.out.println("same");
		else
			System.out.println("not same");
		System.out.println(singleton.getValue());
		System.out.println(singleton2.getValue());
	}
}
