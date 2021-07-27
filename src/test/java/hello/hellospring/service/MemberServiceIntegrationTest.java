package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

//    @BeforeEach
//    public void beforeEach(){
//        memberRepository =new MemoryMemberRepository();
//        memberService=new MemberService(memberRepository);
//    }


//    @AfterEach
//    public void aftereach(){
//        memberRepository.clearStore();
//    }

    @Test
    void 회원가입() {
        //given
        Member member=new Member();
        member.setName("spring");

        //when
        Long saveId = memberService.join(member);//ctrl+alt+v로 return에 맞는 자료형+변수 자동 생성.


        //then
        Member findMember= memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }
    //정상적인 흐름의 testcase. 중복회원 검증을 통한 예외 도출도 중요.

    @Test
    public void 중복회원예외(){
        //given
        Member member1=new Member();
        member1.setName("spring");

        Member member2=new Member();
        member2.setName("spring");//똑같은 클래스 객체 이름만 다르게 생성하려면 shift+f6을 변수명에 갖다대서 수정하기.

        //when
        memberService.join(member1);
//        try{
//            memberService.join(member2);
//            fail();
//        }
//        catch (IllegalStateException e){
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//            //assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.123123");
//        }
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        //ctrl+alt+v로 반환타입을 변수로 자동으로 받음.

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        //then
    }


//    @Test
//    void findMembers() {
//    }
//
//    @Test
//    void findOne() {
//    }
}
