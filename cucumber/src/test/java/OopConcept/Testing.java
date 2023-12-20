package OopConcept;

import org.junit.Test;

public class Testing {
@Test
public void test1() {
	Tesla t= new Tesla(4);

     Car c[]=new Car[4];
     c[0]=new BMW();
     c[1]=new Tesla(4);

  for (int i =0; i<c.length;i++) {
	  c[i].Move();
	  c[i].Engine();
	 // Polymorphism is an concept of giving object in many form. ex:Car=BMW, Tesla.
	  
	   }
  SourceLog ab=new SourceLog();
  ab.setUserid("Sahedarin");
  ab.setPassword("abcdefghijklmnopqrstuvwxyz");
  ab.LogIn(ab.getUserid(), ab.getPassword());
  
  
  SourceLog s1=new SourceLog();
  s1.setUserid("Sahedarin");
  s1.setPassword("abcdefghijklmnopqrstuvwxyz");
  s1.LogIn(s1.getUserid(), s1.getPassword());
  Day d=Day.Sunday;
  Day d1[]=Day.values();
  for(Day x:d1)
  {
	  System.out.println(x);
  }
}
}