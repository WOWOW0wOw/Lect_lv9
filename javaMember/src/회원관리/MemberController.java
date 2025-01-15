package 회원관리;

public class MemberController {

	private MemberDAO memberDao;
	
	public void init() {
		memberDao = new MemberDAO();
		memberDao.init();
	}

	public void run() {
		init();
		while(true) {
			System.out.println("[1]추가 [2]삭제(id->삭제) [3]수정(id->pw) [4]출력 [5]파일저장 [6]불러오기 [0]종료");
			
			int num = Utils.getIntValue("메뉴선택 1~5", 0, 6);
			if (num == 1) {
				memberDao.join();
			}else if(num == 2) {
				memberDao.delete();
			}else if(num == 3) {
				memberDao.updata();
			}else if(num == 4) {
				memberDao.printAll();
			}else if(num == 5) {
				memberDao.getMemberList();
			}else if(num == 6) {
				memberDao.addLoadedMemberData(Utils.loadDataFromFile());
			}else if(num == 0) {
				System.out.println("[종료]");
				break;
			}
			
		}


	}

}
