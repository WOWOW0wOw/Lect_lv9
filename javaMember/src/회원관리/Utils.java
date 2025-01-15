package 회원관리;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Utils {

	private static Scanner sc = new Scanner(System.in);
	private static final String CUR_PATH = System.getProperty("user.dir") + "\\src\\" + Utils.class.getPackageName()
			+ "\\";
	private static final String FILEPATH = CUR_PATH + "member.txt";

	public static int getIntValue(String msg, int start, int end) {
		System.out.println(msg);
		int num = sc.nextInt();
		sc.nextLine();
		return num;
	}

	public static String getStringValue(String msg) {
		System.out.println(msg);
		String name = sc.nextLine();
		return name;
	}

	public static boolean saveMemberListToFile(ArrayList<Member> memberList) {
		try (FileWriter fw = new FileWriter(FILEPATH)) {
			for (int i = 0; i < memberList.size(); i++) {
				fw.write(memberList.get(i).getId() + "/" + memberList.get(i).getName() + "/"
						+ memberList.get(i).getPw() + "\n");
			}
			System.out.println("저장 완료");
			return true;
		} catch (IOException e) {
			System.out.println("저장 실패");
			return false;
		}
	}

	public static String loadDataFromFile() {
		String data = "";
		
		try (FileReader fr = new FileReader(FILEPATH);
				BufferedReader br = new BufferedReader(fr);){
			
			
			while(true) {
				int read = fr.read();
				if(read == -1) {
					break;
				}
				data += (char)read;
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return data;
	}
}
