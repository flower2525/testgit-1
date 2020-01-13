package kr.co.ca;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class InsertCommand implements Command {

	@Override
	public void execute(Scanner sc) {

		System.out.println("ID�� �Է��ϼ���.");
		String id = null;
		while(true) {
			id = sc.nextLine();
			int idlen = id.length(); 
			if (idlen>6 || idlen == 0) {
				System.out.println("������ ID�� �ٽ� �Է��ϼ���.\n�ִ� ���� 6�ڱ��� ����");
			}else {break;}
		}

		MemberDAO dao = new MemberDAO();
		while(true) {
			MemberDTO someone = dao.selectById(id);
			if (someone!= null) {
				System.out.println("�ߺ��� ID�Դϴ�. �ٸ� ID�� �Է� �ϼ���");
				id = sc.nextLine();
			}else {	break;}
		}

		System.out.println("�̸��� �Է��ϼ���.\n�ִ� ���� 12�ڱ��� ����");
		String name = null;
		while(true) {
			name = sc.nextLine();
			int	namelen = name.length(); 
			if (namelen > 12 || namelen == 0) {
				System.out.println("������ �̸��� �ٽ� �Է��ϼ���.\n�ִ� ���� 12�ڱ��� ����");
			}else {	break;}
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

		System.out.println("���̸� �Է��ϼ���.");
		int age = 0;
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
					System.out.println("���ڰ� �Է� �Ǿ����ϴ�.\n0 ���� ũ�ų� 200 �̸� ���ڸ� �Է� �ϼ���.");
				} 
			}
			age = tempAge;		
			if (age <= 0 || age >= 200) {
				System.out.println("�ٽ� ���̸� �Է��ϼ���.\n�Է� ���� ���̴� 0 ���� ũ�ų� 200�̸� �Դϴ�.");
			}else {	break;}

		}
		MemberDTO dto = new MemberDTO(id, name, departCode, age);
		dao.insert(dto);
		System.out.println("ȸ������ ���� �Ǿ����ϴ�");
	}
}



