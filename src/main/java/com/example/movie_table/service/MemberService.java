package com.example.movie_table.service;

import com.example.movie_table.Entity.Member;
import com.example.movie_table.dto.LoginRequestDto;
import com.example.movie_table.dto.LoginResponseDto;
import com.example.movie_table.dto.UpdateResponseDto;
import com.example.movie_table.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member createMember(Member member) {
        return memberRepository.save(member);
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> getMemberById(Long id) {
        return memberRepository.findById(id);
    }

    public Optional<Member> getMemberByEmail(String email) {
        return memberRepository.findByEmail(email);
    }

    public UpdateResponseDto updateMemberById(Long id, Member member) {
        Optional<Member> memberOptional = memberRepository.findById(id);
        if (memberOptional.isPresent()) {
            member.setId(id);
            memberRepository.save(member);
        }
        return new UpdateResponseDto(id, member.getName(), member.getEmail());
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
