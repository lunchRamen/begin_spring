package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);//저장소에 저장
    Optional<Member> findById(Long id);//id를 찾아옴
    Optional<Member> findByName(String name);//name을 찾아옴.
    List<Member> finaAll();//저장된 모든 멤버를 찾아옴.
}
