//package hello.hellospring;
//
//import hello.hellospring.domain.Member;
//import hello.hellospring.repository.JdbcMemberRepository;
//import hello.hellospring.repository.JdbcTemplateRepository;
//import hello.hellospring.repository.JpaMemberRepository;
//import hello.hellospring.repository.MemberRepository;
//import hello.hellospring.service.MemberService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.sql.DataSource;
//
//@Configuration
//public class SpringConfig {
//
//    private final MemberRepository memberRepository;
//
//    @Autowired
//    public SpringConfig(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
//
//    //    @PersistenceContext
////    private EntityManager em;
//
//
//    @Bean
//    public MemberService memberService(){
//        return new MemberService(memberRepository);
//    }
//
////    @Bean
////    public MemberRepository memberRepository(){
//        //return new MemoryMemberRepository();
//        //return new JdbcTemplateRepository(dataSource);
//        //return new JpaMemberRepository(em);
//  //  }
//}
package hello.hellospring;
import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class SpringConfig {
    private final MemberRepository memberRepository;
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }
//    @Bean
//    public TimeTraceAop timeTraceAop(){
//        return new TimeTraceAop();
//    }
}
