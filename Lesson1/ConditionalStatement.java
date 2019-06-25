public class ConditionalStatement {
	public static void main(String[] args) {
	int Age = 18;
	if (Age > 20) {
	System.out.println(Age);
	}
	char Sex = 'W';
	if (Sex == 'M') {
		System.out.println("Мужик");
	}
	else if (Sex == 'W') {
		System.out.println("Женщина");
	}
	double Growtt = 1.5;
	if (Growtt < 1.8) {
		System.out.println("Карлик");
	}
	char FirstLetterName = 'g';
	if (FirstLetterName == 'M') {
		System.out.println("Первая буква " + FirstLetterName);
	}
	else if (FirstLetterName == 'N') {
		System.out.println("Первая буква " + FirstLetterName);
	}
	else {
		System.out.println(" Нет такой буквы" );
	}
	}
	
}