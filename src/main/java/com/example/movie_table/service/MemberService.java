package com.example.movie_table.service;

import com.example.movie_table.Entity.Member;
import com.example.movie_table.dto.*;
import com.example.movie_table.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public MemberCreateResponseDto createMember(Member member) {
        memberRepository.save(member);
        return new MemberCreateResponseDto(member.getId(), member.getName(), member.getEmail());
    }

    public List<MemberReadResponseDto> getAllMembers() {
        List<MemberReadResponseDto>  dto = new ArrayList<>();
        List<Member> members = memberRepository.findAll();
        for (Member m : members) {
            dto.add(new MemberReadResponseDto(m.getId(), m.getName(), m.getEmail()));
        }
        return dto;
//        return memberRepository.findAll();
    }

    public MemberReadResponseDto getMemberById(Long id) {
        Member member = memberRepository.findById(id).orElseThrow();
        return new MemberReadResponseDto(member.getId(), member.getName(), member.getEmail());
//        return memberRepository.findById(id);
    }

    public Optional<Member> getMemberByEmail(String email) {
        return memberRepository.findByEmail(email);
    }

    public MemberUpdateResponseDto updateMemberById(Long id, Member member) {
        Optional<Member> memberOptional = memberRepository.findById(id);
        if (memberOptional.isPresent()) {
            member.setId(id);
            memberRepository.save(member);
        }
        return new MemberUpdateResponseDto(id, member.getName(), member.getEmail());
    }

    public void deleteMemberById(Long id) {
        memberRepository.deleteById(id);
    }



    public LoginResponseDto login(LoginRequestDto dto) {
        Member member = memberRepository.findByEmail(dto.getEmail()).orElseThrow();
        if (member.getPassword().equals(dto.getPassword())) {
            return new LoginResponseDto(member.getId(), member.getEmail());
        }
        else {
            throw new IllegalStateException();
        }
    }
}
