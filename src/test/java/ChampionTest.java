import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertFalse;
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

    //notNullValue 활용한 테스트 한수찬
    @Test
    public void notNullCheck() {
        String lck = "LCK";
        assertThat(lck , notNullValue());

    }

    //nullValue 활용한 테스트
    @Test
    public void givenStringWhenNullIsCorrect() {
        String lck = null;
        assertTrue(lck == null);
    }

    //문자열 관련 테스트 allOf, containsString, endWith 한수찬
    @Test
    public void testForRelatedString() {
        String sampleString1 = "Player suchan";
        String startString = "Player";
        String endString = "suchan";
      assertThat(sampleString1, allOf(startsWith(startString), containsString(endString)));
      //모두있는지 없는지를 확인.

    }

    //부동소수점 범위 closeTo 테스트
    @Test
    public void testForFloatingPoint() {
        assertThat(3.1415926535, closeTo(3, 0.15));
    }

    //anything 테스트 한수찬
    @Test
    public void shouldNotErrorGetReference() {
        assertThat(championList.get(3),anything());
    }

    //객체 크기 검증 테스트 hasSize
    @Test
    public void shouldChampionCountFive() {
        assertFalse(championList.size() == 4); // 제발 탈주하지 말아주세요 ㅠㅠ
        assertThat(championList.size(), is(5)); // 5명이서 하는 게임이잖아요.
    }

    //미드 챔피언은 카사딘이어야 한다라는 조건으로 테스트 코드 작성 한수찬
    @Test
    public void shouldMidChampionIskasadin() {
        Champion supportChamp = new Champion("카사딘", "미드");
        assertThat("카사딘",is(equalTo(supportChamp.getName())));
    }

    //hasProperty 활용하여 속성이 포함되어 있는지 테스트
    @Test
    public void shouldHasPropertyPosition() {
        assertThat(championList.get(0), hasProperty("position"));
        assertThat(championList.get(0), hasProperty("name"));
        assertThat(championList.get(2), hasProperty("position", equalTo("미드")));
        assertThat(championList.get(4), hasProperty("name", equalTo("잔나")));

    }

    //hasToString 활용 테스트 한수찬
    @Test
    public void shouldHaveSomeChampName() {
        List<String> iLikechampListNames = Arrays.asList("카밀", "카사딘", "룰루", "질리언", "이즈리얼", "블라디미르");
        assertThat(iLikechampListNames.get(4),hasToString("이즈리얼"));
    }

    //property와 value가 같은지 테스트
    @Test
    public void shouldHaveSamePropertyAndValue() {
        List<String> championNames1 = Arrays.asList("다리우스", "스웨인", "카타리나", "드레이븐");
        List<String> championNames2 = Arrays.asList("가렌", "베인", "피오라", "케일"); //귀족 트리
        assertThat(championNames1, samePropertyValuesAs(championNames2));
    }


    //미드 챔피언은 제이스여야 한다라는 조건으로 테스트 코드 작성, stream 한수찬
    @Test
    public void shouldMidChampionIsJayce() {
        Optional<Champion> filterdChampion = championList.stream()
                .filter(c->c.getPosition().equals("미드"))
                .findFirst();
        String champName = filterdChampion.get().getName();
        System.out.println("result :: " + filterdChampion);
        Assert.assertTrue(champName.equals("제이스"));
        assertThat("제이스",is(champName));

    }
    @Test // 공백제거시 같은지 비교 test by 한수찬
    public void shouldequalToIgonoringWhiteSpace(){
        String s1="소환사의 협곡";
        String s2="소환사의 협곡 ";
        assertThat(s1,equalToIgnoringWhiteSpace(s2));
    }

}