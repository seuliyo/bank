package ams;
/*
 @ Date : 2015 06 25
 @ Author : 
 @ Story : 은행 관리자 기능정의
 */
public interface BankRole {
	/*
	 계좌 개설 기능
	 */
	public void openAccount(String accountNo, String ownerName, String password, int restMoney);
	/*
	 계좌번호로 특정 계좌를 조회(검색)기능	 
	 */
	public Account searchAccountByAccountNo(String accountNo);
	/*
	 예금주 이름으로 그 사람이 가지고 있는 계좌 조회
	 */
	public Account[] searchAccountByName(String ownerName);
	/*
	 계좌번호로 특정계좌 폐기(삭제) 기능
	 */
	public boolean closeAccount(String accountNo);
}
