import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;


public class DriwingApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Triangle triangle = new Triangle();
//		triangle.draw();
		
		
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
		Triangle triangle =(Triangle)factory.getBean("triangle");
		
		triangle.draw();
	}

}
