package lecture;
class Circle{
	//클래스 = 특성(변수) + 기능(메소드)
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
