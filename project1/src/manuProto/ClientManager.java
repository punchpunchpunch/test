package manuProto;

import java.util.ArrayList;
import java.util.Scanner;

public class ClientManager {
	ArrayList<Client> clients = new ArrayList<Client>();
	Scanner sc;
	ClientManager(Scanner sc){
		this.sc = sc;
	}
	
	/**
	 * 고객의 id,이름,계좌를 입력받아 데이터로 등록하기 위한 메소드
	 */
	public void addClient() {
		Client client = new Client();
		System.out.print("등록할 고객의 ID를 적어주세요 : ");
		client.id = sc.nextInt(); //sc.next면 문자열 중 제일 앞의 단어만 받아들임.
		System.out.print("등록할 고객의 이름을 적어주세요 : ");
		client.name = sc.next();
		System.out.print("등록할 고객의 계좌를 적어주세요 : ");
		client.account = sc.nextInt();
		System.out.print("정보 등록이 완료되었습니다.\n");
		clients.add(client);
	}
	/**
	 * 고객의 id와 이름을 입력받아서 해당 데이터를 제거하기 위한 메소드
	 */
	public void deleteClient() {
		System.out.print("정보를 제거할 고객의 ID를 적어주세요 : ");
		int clientId20 = sc.nextInt();
		int index = -1; // 인덱스를 못찾았다는 의미
		for(int i =0; i<clients.size(); i++) {
			if(clients.get(i).id == clientId20) {
				index = i;
				break;
			}
		}
		if(index >=0) {
			clients.remove(index);
			System.out.print("Client"+ clientId20 +"정보 제거가 완료되었습니다.\n");
		}
		else {
			System.out.println("해당 고객 정보가 없습니다.");
			return;}
	}
	/**
	 * ID를 입력받아 해당 ID의 고객의 금액 등의 데이터를 보여주는 메소드
	 */
	public void viewClient() {
//		System.out.print("조회할 대상의 ID를 적어주세요. : ");
//		int clientId3 = sc.nextInt();
		if(clients.isEmpty()) {
			System.out.println("등록된 고객이 없습니다.");
		}
		for(int i =0; i<clients.size(); i++) {
			clients.get(i).printInfo();
		}
	}
	
	public void edit() {
		System.out.print("편집할 고객의 ID를 적어주세요 : ");
		int clientId = sc.nextInt();
		for(int i=0; i<clients.size(); i++) {
			Client client = clients.get(i);
			if (client.id == clientId) {
				int num = -1;
				while (num != 5) {
					System.out.println("Client info Edit menu");
					System.out.println("1.Edit ID");
					System.out.println("2.Edit name");
					System.out.println("3.Edit account");
					System.out.println("4.Edit money");
					System.out.println("5.Exit");
					System.out.println("Select one between 1~5");
					num = sc.nextInt();
					if( num == 1) {
						System.out.print("Client ID : ");
						client.id = sc.nextInt();
					}
					else if ( num == 2) {
						System.out.print("Client name : ");
						client.name = sc.next();
					}
					else if (num == 3) {
						System.out.print("Client account : ");
						client.account = sc.nextInt();
					}
					else if(num == 4) {
						System.out.print("Client Money : ");
						client.money = sc.nextInt();
					}
					else continue;
				}
			}
			break;
		}
	}
	/**
	 * 고객의 이름과 이후 선택지를 통해 고객의 계좌 금액을 조정하기 위한 메소드
	 */
	public void dwFunction() {
		System.out.print("고객의 id를 적어주세요 : ");
		int clientId40 = sc.nextInt();
		int index = -1;
		for(int i =0; i<clients.size(); i++) {
			if( clients.get(i).id == clientId40) {
			index = i;
			}
		}
		System.out.print("선택지를 번호로 눌러주세요. 1.인출 2.입금 ");
		int moneySelect = sc.nextInt();
		
		//조건문을 통해 입력된 번호가 1이면 인출을, 2면 입금을 수행하고 그 외의 번호는 잘못된 번호라고 출력한다.
		if(moneySelect == 1) {
			if(clients.get(index).money <= 0) {
				System.out.println("잔금이 없습니다.");
				return;
			}
			else {
				System.out.print("인출할 금액을 적어주세요 : ");
				int outMoney = sc.nextInt();
				clients.get(index).outMoney(outMoney);
				System.out.println("인출이 완료되었습니다. 현재 금액 : "+ clients.get(index).money);
			}
		}
		else if(moneySelect == 2) {
			System.out.print("입금할 금액을 적어주세요 : ");
			int inMoney = sc.nextInt();
			clients.get(index).inMoney(inMoney);
			System.out.println("입금이 완료되었습니다. 현재 금액 : "+clients.get(index).money);
		}
		else {
			System.out.println("잘못된 번호입니다.");
		}
		
	}
}