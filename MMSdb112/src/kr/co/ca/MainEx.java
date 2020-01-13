package kr.co.ca;

import java.util.InputMismatchException;
import java.util.Scanner;


public class MainEx {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Command[] com = {
				new InsertCommand(),
				new GetListCommand(),
				new GetMemberDTOByIdCommand(),
				new UpdateCommand(),
				new DeleteCommand()
		};
		System.out.println("�޴��� �����ϼ���");
		String strMenu = "0-ȸ������ 1-��ü��ȸ 2-ȸ����ȸ\n3-ȸ������ 4-���� 5-����";
		boolean isTrue = true;
		while(isTrue) {
			System.out.println(strMenu);
			int tempVal = 0, menu = 0;
			boolean excpt = true;
			while(excpt) {
				try {
					tempVal = sc.nextInt();
					sc.nextLine();
					excpt = false;
				} catch (InputMismatchException e) {
					sc.nextLine();
					System.out.println("���ڰ� �Է� �Ǿ����ϴ�.\n�Ʒ� �޴��� �ִ� ���ڸ� �Է� �ϼ���.\n"+strMenu);
				}		
			}
			menu = tempVal;
			if (menu < com.length && menu >= 0) {
				com[menu].execute(sc);
			}else if(menu == com.length) {
				System.out.println("���񽺰� ���� �Ǿ����ϴ�.\n�ٽ� �����Ϸ��� F11�� ���� �ּ���");
				isTrue = false;
			}else {
				System.out.println("�޴��� �ִ� ���ڸ� �����ϼ���");
			}
		}
		sc.close();
	}
}
