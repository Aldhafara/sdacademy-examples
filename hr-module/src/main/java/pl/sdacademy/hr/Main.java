package pl.sdacademy.hr;

public class Main {
	public static void main(String[] args) {
		HrManager hrManager = new HrManager();
		CommentLineRunner.load(args,hrManager );
		CommentLineRunner.list(hrManager).forEach(System.out::println);
	}
}
