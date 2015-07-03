package ams;
/*
 @ Date : 2015 06 25
 @ Author : 
 @ Story : ���� ������ �������
 */
public interface BankRole {
	/*
	 ���� ���� ���
	 */
	public void openAccount(String accountNo, String ownerName, String password, int restMoney);
	/*
	 ���¹�ȣ�� Ư�� ���¸� ��ȸ(�˻�)���	 
	 */
	public Account searchAccountByAccountNo(String accountNo);
	/*
	 ������ �̸����� �� ����� ������ �ִ� ���� ��ȸ
	 */
	public Account[] searchAccountByName(String ownerName);
	/*
	 ���¹�ȣ�� Ư������ ���(����) ���
	 */
	public boolean closeAccount(String accountNo);
}
