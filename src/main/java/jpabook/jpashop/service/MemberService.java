package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {
    /***
     * autowired는 단점이 많음. 그래서 setter 인젝션을 많이 사용함
     * repository의 세터를 만들어서 세터에 인젝션 추가함
     *
     * 최근에 하나 더 추가된건 아예 생성자에 repository를 추가해버림
     * 이걸 해주는 어노테이션이 RequiredArgsConstructor이고, 추가해주면 존재하는 필드에 한해서 생성자를 자동 생성해줌.
     * 이렇게 작성하면
     */
    private final MemberRepository memberRepository;

//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository){
//        this.memberRepository = memberRepository;
//    }

//    public MemberService(MemberRepository memberRepository){
//        this.memberRepository = memberRepository;
//    }

    /***
     *
     * 회원가입
     */
    @Transactional //(readOnly = false) false가 default임
    public Long join(Member member){
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    /***
     * 회원 전체 조회
     * @return all member list
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    /***
     * 회원 단건 조회
     * @param memberId
     * @return only one member
     */
    public Member findMember(Long memberId){
        return memberRepository.findOne(memberId);
    }

    @Transactional
    public void update(Long id, String name){
        Member member = memberRepository.findOne(id);
        member.setName(name);
    }
}
