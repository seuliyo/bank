package ams;

public class Bank implements BankRole{
	private BankBook[] bankBookList; // 통장을 리스트로 관리하는 배열
	private int count; // 통장 수량관리 변수
	
	public Bank(int count) {
		bankBookList = new BankBook[count];
		/*
		 배열 선언 방법
		 배열이 메소드 아래 지역변수로 선언될 경우
		 int[] nums = new int[10];
		 하지만, 지금 이 bankBookList배열은 필드에 
		 선언된 인스턴스 변수입니다.
		 인스턴스 변수를 생성자를 통해 초기화 하려는 경우
		 위의 예시처럼 합니다.
		 그리고 배열 내부의 숫자를 표시하는 count를 
		 반드시 필드에 선언해 주어야 합니다.
		 */
	}
	// 필드에 선언된 인스턴스 변수의 getter setter 생성
	
	public BankBook[] getBankBookList() {
		return bankBookList;
	}

	public int getCount() {
		return count;
	}
	
	@Override
	public void openAccount(String accountNo, String ownerName,
			String password, int restMoney) {
		// 통장생성을 Account 클래스의 객체를 통해 간단하게 해결
		Account bankBook = new BankBook(accountNo, ownerName, password, restMoney);
		// 캐스팅 : 넓은(큰) 개념의 객체를 작은 범위에 담으려고 할 때
		// 필요한 기능이고 이것이 수행되지 않으면 이클립스는 경고를 보낸다.
		// 이때는 이클립스 커서를 대서 자동 해결한다.
		bankBookList[count] = (BankBook) bankBook;
		count++; // 통장갯수를 증가시킨다.
		System.out.println(bankBook.toString() + "으로 계좌 개설");
	}

	@Override
	public Account searchAccountByAccountNo(String accountNo) {
		Account searchAccount = null; 
		/*
		 변수에는 영역(스코프)에 따라 3가지가 있다.
		 1. 프로젝트 전체에 적용되는 변수 : 클래스 변수 예) static 키워드로 선언된 Pay.TAX
		 2. 클래스 내부에 적용되는 변수 : 인스턴스 변수 예) 필드에 선언된 static이 없는 변수
		 3. 메소드 내부에 적용되는 변수 : 지역(로컬)변수 예) searchAccount
		 */
		for (int i = 0; i < getCount(); i++) {
			/*
			 bankBookList[i]는 bankBookList에 들어있는 
			 통장객체 하나를 가리킵니다.
			 equals()는 자바API에 있는 java.lang.String클래스의 
			 메소드로 스트링값의 비교를 한다. 같으면 true를 리턴한다.
			 */
			if (bankBookList[i].getAccountNo().equals(accountNo)) {
				searchAccount = bankBookList[i];
				/*
				 만약 if문을 true 만드는 계좌번호가 넘어왔다면
				 계좌번호는 단 하나뿐이므로 getCount() 숫자만큼 다 돌지말고
				 지금 이상태에서 회전을 멈추고 값을 반환해라
				 */
				return searchAccount;
			}
		}
		return searchAccount ;
	}

	@Override
	public Account[] searchAccountByName(String ownerName) {
		int tempcount = searchCountByName(ownerName);
		if(tempcount == 0){ // 검색하려는 이름으로 된 통장이 하나도 없는 경우
			return null; 
		}
		BankBook[] tempList = new BankBook[count];
		tempcount = 0; //지역변수의 초기화
		for (int i = 0; i < getCount(); i++) {
			/*
			 
			 */
			if (bankBookList[i].getOwnerName().equals(ownerName)) {
				tempList[tempcount] = bankBookList[i];
				tempcount++;
			}
		}
		return tempList;
	}

	private int searchCountByName(String ownerName) {
		int searchCount = 0; // 지역변수는 무조건 초기화 ==> 자바문법
		for (int i = 0; i < getCount(); i++) {
			if (bankBookList[i].getOwnerName().equals(ownerName)) {
				searchCount++;				
			}
		}
		return searchCount;
	}

	@Override
	public boolean closeAccount(String accountNo) {
		boolean isClose = false; // boolean 타입의 디폴트 값은 false이다.
		// 따라서 boolean의 지역변수 초기화는 false로 한다.
		for (int i = 0; i < getCount(); i++) {
			if (bankBookList[i].getAccountNo().equals(accountNo)) {
				isClose = true;
				// 배열에서 요소를 삭제하는 for문 패턴
				for (int j = i; j < getCount()-1; j++) { // 회전 카운트 숫자를 하나 줄이세요.
					/*
					 배열은 인덱스를 기준으로 순서대로 나열된 형태
					 따라서 j번째 요소를 j+1번째 요소로 덮어쓰기로 만들면
					 {1,2,3,4,5} 이런 배열이 있다고 하면
					 {1,2,4,5} 로 만들면 이것이 인덱스 값이 2인 3번째 요소인 3값을 
					 지운 것이 됩니다. 
					 */
					bankBookList[j] = bankBookList[j+1];
				}
				count--; // 뒷 값으로 앞 값을 덮어씌웠기 때문에 요소 갯수가 줄어든다.
			}
		}
		return isClose;
	}
}
