package ams;
/*
@ Date : 2015 06 25
@ Author : 
@ Story : 은행 고객 기능정의
*/
public interface Account {
	public static final String BANK_NAME = "아이티뱅크";
	public void deposit(int money); // 예금
	public void withdraw(int money); // 출금
}
