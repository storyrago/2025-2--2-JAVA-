package lecture;
class Circle{
	//Ŭ���� = Ư��(����) + ���(�޼ҵ�)
	static int radius;
	
	public static double getArea(){
		return 3.14*radius*radius;
	}
}

public class CircleEx {

	public static void main(String[] args) {
		Circle pizza = new Circle();
		pizza.radius = 10;
		System.out.println(pizza.getArea());
	}

}
