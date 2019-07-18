# 실전코딩 2조 Software Testing 첫번째 과제 

## 조원
이안규, 원동욱, 최진영, 최지원, 김도연 

총 5명

## Dependencies
- Junit : version 4.12
- Hamcrest : version 1.3
- Lombok : version 1.16.10
- Stream API

## Description
Junit의 `assertTure`, `assertFalse` 와 Hamcrest의 `assertThat`을 사용하여
String, List 등의 여러 Object들을 검사하고 테스트하는 코드를 작성

각 단정문마다 어떤 사람이 코드를 작성해는지 주석으로 이름을 적어 처리함.

예시)
```
@Test
    public void shouldHasPropertyPosition() {
        assertThat(championList.get(1), hasProperty("name")); //김도연
        assertThat(championList.get(0), hasProperty("position"));//최진영
        assertThat(championList.get(0), hasProperty("position", equalTo("탑")));//최진영
        assertThat(championList.get(1), hasProperty("name", equalTo("리신"))); //최진영
        assertThat(championList.get(1), allOf(hasProperty("position"),hasProperty("name"))); //최진영
        assertThat(championList.get(0), hasProperty("position", equalTo("탑"))); //원동욱
        assertThat(championList.get(0), hasProperty("name")); //원동욱
        assertThat(championList.get(1),hasProperty("position",equalTo("정글"))); //이안규
        assertThat(championList.get(0),hasProperty("position"));    //최지원
        assertThat(championList.get(4),hasProperty("name"));        //최지원
        assertThat(championList.get(2),hasProperty("position",equalTo("미드")));   //최지원
    }
```
