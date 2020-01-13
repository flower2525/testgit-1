package kr.co.ca;

import java.util.Scanner;

public class DeleteCommand implements Command {

	@Override
	public void execute(Scanner sc) {

		MemberDAO dao = new MemberDAO();
		System.out.println("������ ȸ�� ID�� �Է��ϼ���");
		while(true) {
			String id = sc.nextLine();
			MemberDTO dto = dao.selectById(id);
			if (dto!= null) {
				dao.delete(id);
				System.out.println("������ �Ϸ� �Ǿ����ϴ�");
				break;
			}else {
				System.out.println("�������� �ʴ� ȸ���Դϴ�.\n�ٸ� ID�� �Է��ϼ���");
				continue;
			}

		}

	}

}
