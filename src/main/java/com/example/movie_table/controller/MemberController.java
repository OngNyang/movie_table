package com.example.movie_table.controller;

import com.example.movie_table.Entity.Member;
import com.example.movie_table.dto.*;
import com.example.movie_table.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController("/users")
@RestController
@RequestMapping("/users")
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/signup")
    public ResponseEntity<MemberCreateResponseDto> createMember(@RequestBody Member member) {
        MemberCreateResponseDto createdMember = memberService.createMember(member);
        return new ResponseEntity<>(createdMember, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MemberReadResponseDto>> getAllMembers() {
        List<MemberReadResponseDto> members = memberService.getAllMembers();
        return new ResponseEntity<>(members, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberReadResponseDto> getMemberById(@PathVariable Long id) {
//        Member member = memberService.getMemberById(id).orElse(null);
        MemberReadResponseDto member = memberService.getMemberById(id);
        return new ResponseEntity<>(member, HttpStatus.OK);
    }

//    @UpdateMapping("/{id}")
    @PutMapping("/{id}")
    public ResponseEntity<MemberUpdateResponseDto> updateMemberById(@PathVariable Long id, @RequestBody Member member) {
        MemberUpdateResponseDto updatedMember = memberService.updateMemberById(id, member);
        return new ResponseEntity<>(updatedMember, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMemberById(@PathVariable Long id) {
        memberService.deleteMemberById(id);
        return new ResponseEntity<>("삭제되었습니다.", HttpStatus.NO_CONTENT);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> loginProcess(@RequestBody LoginRequestDto dto) {
        return new ResponseEntity<>(memberService.login(dto), HttpStatus.OK);
    }
}

