package ams;

public class BankBook implements Account{
	private String accountNo; // ���¹�ȣ
	private String ownerName; // ��������
	private String password; // �����й�ȣ
	private int restMoney; // �ܾ�
	
		
	public BankBook(String accountNo, String ownerName, String password, int restMoney) {
		// �ʵ尪�� �Ķ���Ͱ��� ���ν�Ű�� �۾�
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.password = password;
		this.restMoney = restMoney;
	}
	
	public String getAccountNo() {
		return accountNo;
	}


	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}


	public String getOwnerName() {
		return ownerName;
	}


	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getRestMoney() {
		return restMoney;
	}


	public void setRestMoney(int restMoney) {
		this.restMoney = restMoney;
	}


	@Override
	public void deposit(int money) {
		if(money <= 0){
			System.out.println("�Աݾ��� 0���� Ŀ�� �մϴ�.");
		} else {
			this.restMoney += money;
		}		
	}

	@Override
	public void withdraw(int money) {
		if (money <= 0) {
			System.out.println("��ݾ��� 0���� Ŀ�� �մϴ�.");
		} else if(getRestMoney()<=money) {
			System.out.println("��ݾ��� �ܾ׺��� Ů�ϴ�.");
		}else {
			this.restMoney -= money;
		}		
	}
	// �ڹ�API�߿��� java.lang.ObjectŬ������ 
	// �޼ҵ��� toString()�� �������̵� �Ͽ���.
	@Override
	public String toString() {
		return "����� ����\n"
				+ "[" + BANK_NAME + "]\n"
				+ "���¹�ȣ : " + getAccountNo() + "\n"
				+ "���¸� : " + getOwnerName() + "\n"
				+ "��� : ******** \n"
				+ "�ܾ� : " + getRestMoney() + "\n";	
	}

}
