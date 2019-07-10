import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ChampionTest {
    private List<Champion> championList = new ArrayList<Champion>();

    @Before //setUP : 챔피언 리스트에 배열로 넣어둠.
    public void setUp() {

        //5개의 챔피언 객체를 만듭니다.
        Champion topChamp = new Champion("문도", "탑");
        Champion jungleChamp = new Champion("렝가", "정글");
        Champion midChamp = new Champion("제이스", "미드");
        Champion adcChamp = new Champion("이즈리얼", "바텀");
        Champion supportChamp = new Champion("잔나", "바텀");

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
        assertThat(emptyList, empty());
    }

    //notNullValue 활용한 테스트
    @Test
    public void notNullCheck() {
        String lck = "LCK";
        //assertThat(lck, notNullValue());
    }

    //nullValue 활용한 테스트
    @Test
    public void givenStringWhenNullIsCorrect() {
        String lck = null;
        assertTrue(lck == null);
    }

    //문자열 관련 테스트 anyOf, containsString, endWith
    @Test
    public void testForRelatedString() {
        String sampleString1 = "Player Focus";
        String sampleString2 = "Player point";
        String startString = "Player";
        String endString = "point";
//        assertThat(sampleString1,is(startWith("Player")));
//        assertThat(sampleString1, anyOf(startsWith(startString), containsString(endString))); //있는지 없는지를 확인. /
//        assertThat(sampleString2, is(endsWith(endString)));
    }

    //부동소수점 범위 closeTo 테스트
    @Test
    public void testForFloatingPoint() {
//        assertThat(3.14, closeTo(3, 0.2)); // 값을 주고, 기본 3에 0.2안에 들어오면 true
    }

    //anything 테스트
    @Test
    public void shouldNotErrorGetReference() {
//        assertThat(championList.get(2), anything()); // 값만 가져올 수 있으면 true
//        assertThat(championList.get(2), is());
    }

    //객체 크기 검증 테스트 hasSize
    @Test
    public void shouldChampionCountFive() {
        assertTrue(championList.size() == 5);
//        assertThat(championList.size(), is(5));
        assertThat(championList, hasSize(5)); //size가 5인지
    }

    //서폿 챔피언은 타릭이어야 한다라는 조건으로 테스트 코드 작성
    @Test
    public void shouldSupportChampionIsTaric() {
        Champion supportChamp = new Champion("타릭", "바텀");

//        assertThat("타릭", is(supportChamp.getName()));
//        assertThat("타릭", is(equalTo(supportChamp.getName())));
//        assertThat("타릭", equalTo(supportChamp.getName()));
    }

    //hasProperty 활용하여 속성이 포함되어 있는지 테스트
    @Test
    public void shouldHasPropertyPosition() {
//        assertThat(championList.get(0), hasProperty("position"));
//        assertThat(championList.get(0), hasProperty("name"));
//        assertThat(championList.get(0), hasProperty("position", equalTo("탑")));
//        assertThat(championList.get(3), hasProperty("position", equalTo("르블랑")));

    }

    //hasToString 활용 테스트
    @Test
    public void shouldHaveSomeChampName() {
        List<String> champListNames = Arrays.asList("루시안", "애쉬", "렉사이", "갈리오", "모르가느", "블라디미르");
//        assertThat(champListNames.get(0), hasToString("루시안"));//해당 문자열을 가지고 있는지
    }

    //property와 value가 같은지 테스트
    @Test
    public void shouldHaveSamePropertyAndValue() {
        List<String> championNames1 = Arrays.asList("루시안", "애쉬", "렉사이", "갈리오", "모르가나", "블라디미르");
        List<String> championNames2 = Arrays.asList("조이", "애쉬", "렉사이", "갈리오", "모르가나", "블라디미르");
        assertThat(championNames1,samePropertyValuesAs(championNames2));
//        assertThat(championNames1, samePropertyValuesAs(championNames2));
//        assertThat(championNames2,hasToString("조이"));
    }


    //탑 챔피언은 다리우스여야 한다라는 조건으로 테스트 코드 작성, stream 활용예
    @Test
    public void shouldTopChampionIsDarius() {
        Optional<Champion> filterdChampion = championList.stream()
                .filter(c -> c.getPosition().equals("탑"))
                .findFirst();
//        String champName = filterdChampion.get().getName();
//        assertTrue(champName.equals("다리우스"));
//        assertThat("다리우스", is(champName));
        System.out.println("Result::"+filterdChampion);

    }

}