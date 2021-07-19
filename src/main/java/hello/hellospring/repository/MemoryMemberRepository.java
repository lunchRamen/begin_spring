package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long,Member> store=new HashMap<>();
    //실무에선 동시성 문제때문에 공유변수경우 concurrent를 쓴다.
    private static long sequence=0L;
    //key값을 생성해주는 변수.

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member;
        //member에 id값을 세팅해주고(name은 입력받았다고 가정) 여기 id값은 db에서 관리하기위한 key값임.
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
        //결과가 없는 경우?->null이 나옴 이럴땐 Optional.ofNullable로 store.get(id)를 감싸서 return해주면 된다.
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream().filter(member -> member.getName().equals(name)).findAny();
    }

    @Override
    public List<Member> finaAll() {
        return new ArrayList<>(store.values());//store에 member들이 반환됨
    }

    public void clearStore(){
        store.clear();
    }
}
