package win.waylib.anmould.json;
/**
 * 供Json测试用的Bean
 * @author Leve
 *
 */
public class Person {
	private int age;
	private String name;

	public Person() {
		// TODO Auto-generated constructor stub }
	}

	public Person(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}
}