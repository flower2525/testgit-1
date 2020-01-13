package kr.co.ca;

import java.util.Scanner;

public class GetMemberDTOByIdCommand implements Command {

	@Override
	public void execute(Scanner sc) {

		MemberDAO dao = new MemberDAO();
		System.out.println("��ȸ�� ID�� �Է��ϼ���");
		while(true) {
			String id = sc.nextLine();
			MemberDTO dto = dao.selectById(id);
			if (dto!= null) {
				System.out.println(dto);
				break;
			}else {
				System.out.println("�������� �ʴ� ȸ���Դϴ�.\n�ٽ� ID�� �Է��ϼ���.");
			}
		}
	}
}
