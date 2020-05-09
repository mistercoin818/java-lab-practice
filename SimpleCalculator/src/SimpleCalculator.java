import java.util.Scanner;

public class SimpleCalculator {

	public static void main(String[] args) throws OutofRangeException, AddZeroException, SubtractZeroException {
		Scanner sc = new Scanner(System.in);
		String formula;
		int digit = 0;
		boolean check = true;
		int num1, num2;
		char op;
		int i = 0;

		formula = sc.nextLine();

		try{
			while(formula.charAt(i) != '+' && formula.charAt(i) != '-') {
				i++;
			}
			if(formula.charAt(i) == '+') {
				op = '+';
				String[] a = formula.split("\\+");
				String arr1 = a[0];
				String arr2 = a[1];
				num1 = Integer.parseInt(arr1);
				num2 = Integer.parseInt(arr2);
			}
			else {
				op = '-';
				String[] a = formula.split("\\-");
				String arr1 = a[0];
				String arr2 = a[1];
				num1 = Integer.parseInt(arr1);
				num2 = Integer.parseInt(arr2);
			}
			int flag = 0;
			if(num1 == 0 || num2 == 0) {
				if(op == '+') {
					flag = 1;
					throw new AddZeroException();
				}
				else {
					flag = 1;
					throw new SubtractZeroException();
				}
			}
			else if(num1 <0 || num1 > 1000) {
				flag = 1;
				throw new OutofRangeException();
			}
			else if(num2 <0 || num2 > 1000) {
				flag = 1;
				throw new OutofRangeException();
			}
			else if(op == '+') {
				if(num1 + num2 > 1000 || num1+num2 <0) {
					flag = 1;
					throw new OutofRangeException();
				}
			}
			else if(op == '-') {
				if(num1-num2>1000 || num1-num2 <0) {
					flag = 1;
					throw new OutofRangeException();
				}
			}
			if(flag == 0) {
				if(op == '+') {
					System.out.println(num1+num2);
				}
				if(op == '-') {
					System.out.println(num1-num2);
				}
			}
			
		}catch(OutofRangeException e1) {
			System.out.println("OutofRangeException");
		}
		catch(AddZeroException e2) {
			System.out.println("AddZeroException");
		}
		catch(SubtractZeroException e3) {
			System.out.println("SubtractZeroException");
		}
		finally {
			System.exit(0);
		}

	}

}

class OutofRangeException extends Exception{
	
}

class AddZeroException extends Exception{
	
}

class SubtractZeroException extends Exception{
	
}
