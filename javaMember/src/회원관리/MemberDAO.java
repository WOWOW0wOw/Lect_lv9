package 회원관리;

import java.util.ArrayList;

public class MemberDAO {

	private ArrayList<Member> memberList;
	
	public void init() {
		memberList = new ArrayList<Member>();
	}

	public void join() {
		String id = Utils.getStringValue("아이디 입력 >> ");
		for(int i = 0; i < memberList.size(); i++) {
			if(id.equals(memberList.get(i).getId())){
				System.out.println("이미 존재하는 아이디 입니다");
				return;
			}
		}
		String pw = Utils.getStringValue("비밀번호 입력 >> ");
		String name = Utils.getStringValue("이름 입력 >> ");
		
		memberList.add(new Member(id, pw, name));
		System.out.println("추가 완료");
		
	}

	public void delete() {
		if(memberList.size() == 0) {
			System.out.println("저장된 리스트가 없습니다");
			return;
		}
		String id = Utils.getStringValue("아이디 입력 >> ");
		for(int i = 0; i < memberList.size(); i++) {
			if(id.equals(memberList.get(i).getId())){
				memberList.remove(i);
				System.out.println("삭제 완료");
				return;
			}
		}
		System.out.println("입력한 아이디가 없습니다.");
	}
	
	public void updata() {
		if(memberList.size() == 0) {
			System.out.println("저장된 리스트가 없습니다");
			return;
		}
		String id = Utils.getStringValue("아이디 입력 >> ");
		for(int i = 0; i < memberList.size(); i++) {
			if(id.equals(memberList.get(i).getId())){
				memberList.get(i).setPw(Utils.getStringValue("수정할 비밀번호 입력 >> "));
				System.out.println("수정 완료");
				return;
			}
		}
		System.out.println("입력한 아이디가 없습니다.");
	}
	
	public void printAll() {
		if(memberList.size() == 0) {
			System.out.println("저장된 리스트가 없습니다");
			return;
		}
		for(Member m : memberList) {
			System.out.println(m);
		}
	}
	
	public void getMemberList() {
		if(memberList.size() == 0) {
			System.out.println("저장된 리스트가 없습니다");
			return;
		}
		if(Utils.saveMemberListToFile(memberList)) {
			memberList.clear();
		}
	}
	
	public void addLoadedMemberData(String data) {
		String[] datas = data.split("\n");
		for(int i = 0; i < datas.length; i++) {
			String temp[] = datas[i].split("/");
			memberList.add(new Member(temp[0], temp[1], temp[2]));
		}
	}

}
