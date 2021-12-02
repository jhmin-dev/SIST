package kr.s05.supertest;
// 부모 클래스
class Point {
	int x;
	int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public String getLocation() {
		return "x : " + x + ", y : " + y;
	}
}
// 자식 클래스
class Point3D extends Point {
	int z;
	public Point3D() {
		super(10, 20); // 부모 클래스에 기본 생성자가 없으므로, 인자가 있는 생성자를 호출해야 함
		z = 7;
	}
	public Point3D(int x, int y, int z) {
		super(x, y);
		this.z = z;
	}
	@Override
	public String getLocation() {
		return "x : " + x + ", y : " + y + ", z : " + z;
	}
}

public class SuperMain04 {
	public static void main(String[] args) {
		Point3D p3 = new Point3D();
		System.out.println(p3.getLocation());
		Point3D p3new = new Point3D(10, 20, 30);
		System.out.println(p3new.getLocation());
	}
}