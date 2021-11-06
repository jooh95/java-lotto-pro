# 3단계 - 로또(자동)

## 3단계 실습 시작

### 기능 요구사항

- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.

### 힌트

- 로또 자동 생성은 Collections.shuffle() 메소드 활용한다.
- Collections.sort() 메소드를 활용해 정렬 가능하다.
- ArrayList의 contains() 메소드를 활용하면 어떤 값이 존재하는지 유무를 판단할 수 있다.

### 기능 목록

1. 구입 금액을 입력 받는다
    1. "구입금액을 입력해 주세요." 출력한다.
    2. 숫자만 입력 가능하다.
2. 로또는 개당 1000원이므로 구입 할 수 있는 만큼 로또 번호를 자동생성한다.
    1. 구입금액 / 1000원으로 총 구매가능 갯수를 구한다.
    2. 로또번호(6개)를 생성하고, 구매가능 갯수만큼 반복한다.
        1. 로또 리스트가 생성된다.
3. 구매된 로또번호 리스트를 출력한다.
4. 지난 주 당첨 번호를 입력 받는다
    1. 6개 숫자로 이루어진 리스트다.
    2. 6자리의 "," 로 분리되게 입력받아야한다.
    3. 문자가 있으면 다시 입력요구한다.
    4. 숫자가 6개가 아니면 예외처리한다.
    5. 1-45 범위에 대한것도 여기서 해야할까?
5. 자동생성 로또번호와 비교하여 당첨을 계산한다
    1. 1등:6개, 2등:5개, 3등:4개, 4등 3개 그 외는 당첨없음 이다.
    2. 1등 부터 4등까지는 다른 상금을 가진다.
    3. 총 상금은 해당등수 상금 * 해당등수 일치 갯수 이다.
    4. 수익률 총상금 / 구입한 총비용 이다.
6. 당첨 통계를 출력한다.


- 로또번호 생성
    - [X] 1-45의 숫자를 가지는 로또번호 객체생성
    - [X] 로또번호를 가지는 LottoNumbers 객체생성(6개의 로또번호를 가짐, 중복 X)
    - [X] 구입금액에 가능한 로또 최대 구매수 구하기
    - [X] 최대 구매수 만큼 로또 목록 생성하기
    - [X] 랜덤 로또 숫자 생성
    - [X] 구매후 불변객체로 수정불가 리턴하기
- 서비스
    - [X] 컨트롤러 - 도메인 연결 서비스 만들기
    - [X] 컨트롤러에서 사용할 Dto 만들기
- 로또 당첨 결과
    - [X] 지난 주 로또 번호와 비교하여 일치 카운팅하기
    - [X] 당첨결과 당첨금액구하기
    - [X] 총 당첨금액과 구입금액에 대한 총 수익률 구하기
- InputView
    - [X] 사용자에게 로또 구매 금액 입력받기
    - [X] 지난 주 당첨 번호 입력 받기
- ResultView
    - [X] 로또 번호 목록 출력
    - [X] 당첨 통계 출력
