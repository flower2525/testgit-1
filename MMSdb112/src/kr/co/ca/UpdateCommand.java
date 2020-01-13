package kr.co.ca;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class UpdateCommand implements Command {

	@Override
	public void execute(Scanner sc) {
		
		System.out.println("ȸ�� ���� ����");
		System.out.println("������ ȸ���� ID�� �Է��ϼ���");
		String id = sc.nextLine();
		MemberDAO dao = new MemberDAO();
		MemberDTO someone = dao.selectById(id);
		String name=null;
		if (someone!=null) {
			System.out.println("���̸��� �Է��ϼ���.\n�ִ� ���� 12�ڱ��� ����");
			while(true) {
				name = sc.nextLine();
				int namelen = name.length(); 
				if (namelen > 12 || namelen == 0) {
					System.out.println("������ �̸��� �ٽ� �Է��ϼ���.\n�ִ� ���� 12�ڱ��� ����");
				}else {
					break;
					}
				}

		DepartmentDAO departDao = new DepartmentDAO();
		Map<String, String> mapSorted = departDao.getAllDepartments();
		Set<String> keys = mapSorted.keySet();
		System.out.println("���� �а� �ڵ� Did �� �ϳ��� �Է��ϼ���.");
		System.out.println(mapSorted);
		String departCode = null;
		while(true) {
			String tmpCode = sc.nextLine();
			if (!keys.contains(tmpCode)) {
				System.out.println("���� �а��Դϴ�. �ٽ� �Է��ϼ���");
			}else {
				departCode = tmpCode;
				break;
			}
		}

		int age = 0;
		System.out.println("���̸� �Է��ϼ���.");
		while(true) {
			int tempAge = 0;
			boolean excpt = true;
			while(excpt) {
				try {
					tempAge = sc.nextInt();
					sc.nextLine();
					excpt = false;
				} catch (InputMismatchException e) {
					sc.nextLine();
					System.out.println("���ڰ� �Է� �Ǿ����ϴ�.\n0 ���� ũ�ų� 200�̸� ���ڸ� �Է� �ϼ���.");
				} 
			}
			age = tempAge;		
			if (age <= 0 || age >= 200) {
				System.out.println("�ٽ� ���̸� �Է��ϼ���.\n�Է� ���� ���̴� 0 ���� ũ�ų� 200�̸� �Դϴ�.");
			}else {	break;}
		}

		MemberDTO dto = new MemberDTO(id, name, departCode, age);
		dao.update(dto);
		System.out.println("������ �Ϸ�Ǿ����ϴ�.");
	}else {
		System.out.println("�������� �ʴ� ID�Դϴ�. ó������ �ٽ� �����ϼ���");
	}

}

}
