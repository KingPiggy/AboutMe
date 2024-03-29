package com.hoondragonite.aboutme.service;

import com.hoondragonite.aboutme.domain.userinfo.UserInfo;
import com.hoondragonite.aboutme.dto.UserInfoSaveRequestDto;
import com.hoondragonite.aboutme.repository.UserInfoRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoServiceTest {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private UserInfoRepository userInfoRepository;

    @After
    public void cleanup() {
        /**
         이후 테스트 코드에 영향을 끼치지 않기 위해
         테스트 메소드가 끝날때 마다 respository 전체 비우는 코드
         **/
        userInfoRepository.deleteAll();
    }

    /* 왼쪽 밑에 초록버튼으로 메소드 실행해보기*/
    @Test
    public void 사용자정보_저장() {
        System.out.println("*****사용자정보_저장 테스트 시작*****");
        //given : 테스트 기반 환경 작성
        Long testUID = new Long(1);
        userInfoService.saveUserInfo(testUID, UserInfoSaveRequestDto.builder()
                .korName("이승훈")
                .engName("SeungHoon Lee")
                .email("a@naver.com")
                .contact("010-1234-1234")
                .blog("a.com")
                .selfIntroduce("hello")
                .build());

        Long testUID2 = new Long(2);
        userInfoService.saveUserInfo(testUID2, UserInfoSaveRequestDto.builder()
                .korName("테스트")
                .engName("test")
                .email("test@naver.com")
                .contact("010-1234-5678")
                .blog("a.test.com")
                .selfIntroduce("tetetest")
                .build());

        //when : 테스트 하고자 하는 행위
        userInfoService.saveUserInfo(testUID2, UserInfoSaveRequestDto.builder()
                .korName("업데이트테스트")
                .engName("test")
                .email("test@naver.com")
                .contact("010-1234-5678")
                .blog("a.test.com")
                .selfIntroduce("tetetest")
                .build());

        Optional<UserInfo> userInfo = userInfoService.findByuID(testUID);
        Optional<UserInfo> userInfo2 = userInfoService.findByuID(testUID2);

        //then : 테스트 결과 검증
        if(userInfo.isPresent()){
            System.out.println("userInfo 이름 : " + userInfo.get().getKorName());
            assertThat(userInfo.get().getKorName(), is("이승훈"));
        }
        if(userInfo2.isPresent()){
            System.out.println("userInfo2 이름 : " + userInfo2.get().getKorName());
            assertThat(userInfo2.get().getKorName(), is("업데이트테스트"));
        }

        System.out.println("*****사용자정보_저장 테스트 종료*****");
    }
}