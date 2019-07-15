
import org.hamcrest.Matcher;
import org.mockito.internal.matchers.StartsWith;
import org.hamcrest.core.IsNull;
import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.matchers.Null;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class ChampionTest {
    private List<Champion> championList = new ArrayList<Champion>();

    @Before
    public void setUp() {

        //5개의 챔피언 객체를 만듭니다.
        Champion topChamp = new Champion("다리우스", "탑");
        Champion jungleChamp = new Champion("리신", "정글");
        Champion midChamp = new Champion("르블랑", "미드");
        Champion adcChamp = new Champion("베인", "바텀");
        Champion supportChamp = new Champion("레오나", "바텀");

        //앞서 만든 List 에 각 챔피언을 추가합니다.
        championList.add(topChamp);
        championList.add(jungleChamp);
        championList.add(midChamp);
        championList.add(adcChamp);
        championList.add(supportChamp);
    }

    //List<String>을 생성하고 값이 비어 있는지를 테스트 empty()
    @Test
    public void givenCollectionWhenEmptyCorrect() {
        List<String> emptyList = new ArrayList<>();
        assertThat(emptyList,empty()); // 이안규
        assertThat(emptyList.isEmpty(), is(true));  //최지원
        assertThat(emptyList.size(), is(0));        //최지원
        assertThat(emptyList, is(empty()));                //최지원
        assertThat(emptyList, empty());                    //최지원
    }

    //notNullValue 활용한 테스트
    @Test
    public void notNullCheck() {
        String lck = "LCK";
        assertThat(lck,is("LCK")); //이안규
        assertNotNull(lck);                                 //최지원
        assertThat(lck, notNullValue());                    //최지원
        assertThat(lck, is(notNullValue()));                //최지원
        assertThat(lck, not(nullValue()));                  //최지원
    }

    //nullValue 활용한 테스트
    @Test
    public void givenStringWhenNullIsCorrect() {
        String lck = null;
        assertThat(lck,isEmptyOrNullString()); //이안규
        assertThat(lck,nullValue());                        //최지원
        assertThat(lck,is(nullValue()));                    //최지원
        assertThat(lck,not(notNullValue()));                //최지원
    }


    //문자열 관련 테스트 anyOf, containsString, endWith
    @Test
    public void testForRelatedString() {
        String sampleString1 = "Player Focus";
        String sampleString2 = "Player point";
        String sampleString3 = "Player Focus and point";
        String startString = "Player";
        String endString = "point";

        assertThat(sampleString1,allOf(startsWith("Pla"),endsWith("cus"))); //이안규
        assertThat(sampleString1,anyOf(startsWith(startString),containsString(endString)));   //최지원
        assertThat(sampleString1, startsWith(startString));                                   //최지원
        assertThat(sampleString2, allOf(startsWith(startString),endsWith(endString)));        //최지원
        assertThat(sampleString3, containsString("and"));                           //최지원
        assertThat(sampleString3, endsWith(endString));                                       //최지원
        assertThat(sampleString3, equalToIgnoringCase("player focus and point"));//최지원
        assertThat(sampleString3, equalToIgnoringWhiteSpace("    Player    Focus    and    point"));//최지원
    }

    //부동소수점 범위 closeTo 테스트
    @Test
    public void testForFloatingPoint() {

        assertThat(3.25,closeTo(3.1,0.2)); //이안규
        assertThat(3.14, closeTo(3.2,0.5));             //최지원
        assertThat(3.14,greaterThan(3.1));                        //최지원
        assertThat(3.14,greaterThanOrEqualTo(3.14));             //최지원
        assertThat(3.14,lessThan(3.2));                          //최지원
        assertThat(3.14,lessThanOrEqualTo(3.14));                //최지원
        assertThat(3.14,equalTo(3.14));                       //최지원
//        assertThat(3.14,closeTo(3.1,0.04));             //최지원

    }

    //anything 테스트
    @Test
    public void shouldNotErrorGetReference() {

        assertThat(championList.get(2),anything()); //이안규
        List<String> champList = new ArrayList<>();
        assertThat(champList, anything());                                      //최지원
        assertThat(championList.get(3), anything());                            //최지원
        assertThat(championList.get(2),anything("name"));           //최지원
    }

    //객체 크기 검증 테스트 hasSize
    @Test
    public void shouldChampionCountFive() {

        assertThat(championList.size(), is(5)); //이안규
        assertThat(championList.size(), equalTo(5));                   //최지원
        assertThat(championList, hasSize(5));                                    //최지원
        assertThat(championList, is(5));                                  //최지원
    }

    //서폿 챔피언은 타릭이어야 한다라는 조건으로 테스트 코드 작성
    @Test
    public void shouldSupportChampionIsTaric() {
        Champion supportChamp = new Champion("타릭", "바텀");
        assertThat("바텀",is(supportChamp.getPosition())); //이안규
        Champion supportChamp = new Champion("타릭", "바텀");   //최지원
        assertThat(supportChamp.getName(), equalTo("타릭"));           //최지원
        assertThat(supportChamp.getName(), containsString("타릭"));   //최지원
        assertThat("타릭", is(equalTo(supportChamp.getName())));         //최지원
        assertThat(supportChamp.getName(),is("타릭"));                    //최지원
    }

    //hasProperty 활용하여 속성이 포함되어 있는지 테스트
    @Test
    public void shouldHasPropertyPosition() {
        assertThat(championList.get(1),hasProperty("position",equalTo("정글"))); //이안규
        assertThat(championList.get(0),hasProperty("position"));    //최지원
        assertThat(championList.get(4),hasProperty("name"));        //최지원
        assertThat(championList.get(2),hasProperty("postion",equalTo("미드")));   //최지원
    }

    //hasToString 활용 테스트
    @Test
    public void shouldHaveSomeChampName() {
        List<String> champListNames = Arrays.asList("루시안", "애쉬", "렉사이", "갈리오", "모르가느", "블라디미르");
        assertThat(champListNames.get(1),hasToString("애쉬")); //이안규
        champListNames = Arrays.asList("조이", "티모", "아이번", "애쉬", "징크스", "카밀");  //최지원
        assertThat(champListNames.get(3), hasToString("애쉬"));           //최지원
        assertThat(champListNames.get(3), containsString("애"));                 //최지원
        assertThat(champListNames, hasItem("애쉬"));                                       //최지원
        assertThat(champListNames, hasItem(hasToString("애쉬")));         //최지원
    }

    //property와 value가 같은지 테스트
    @Test
    public void shouldHaveSamePropertyAndValue() {
        List<String> championNames1 = Arrays.asList("루시안", "애쉬", "렉사이", "갈리오", "모르가나", "블라디미르");
        List<String> championNames2 = Arrays.asList("루시안", "애쉬", "렉사이", "갈리오", "모르가나", "블라디미르");
        assertThat(championNames1,samePropertyValuesAs(championNames2)); //이안규
        List<String> championNames3 = Arrays.asList("리신", " 다리우스", "문도");                                     //최지원
        assertThat(championNames1, samePropertyValuesAs(championNames3));                                             //최지원
        assertThat(championNames1, not(championNames2));                                                              //최지원
        assertThat(championNames1, not(samePropertyValuesAs(championList.get(0))));                                   //최지원
    }

    //탑 챔피언은 다리우스여야 한다라는 조건으로 테스트 코드 작성, stream 활용예
    @Test
    public void shouldTopChampionIsDarius() {
        Optional<Champion> filterChampion = championList.stream()
                .filter(c -> c.getPosition().equals("미드"))
                .findFirst();
        System.out.println("result :: " + filterChampion);
        String champName = filterChampion.get().getName();
        assertThat(champName,is("르블랑")); //이안규

        filteredChampion = championList.stream()
                .filter(c->c.getPosition().equals("바텀"))
                .findAny();
        System.out.println("필터링 된 챔피언::" + filteredChampion);
        String champName = filteredChampion.get().getName();
        System.out.println("ChampName::" + champName);
        assertThat(champName,anyOf(equalTo("리신"), equalTo("베인")));              //최지원
        assertThat(champName, isOneOf("리신","베인"));                                      //최지원
    }

}