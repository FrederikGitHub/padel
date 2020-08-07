package com.realdolmen.padel.service;

import com.realdolmen.padel.model.Member;

import java.util.List;

public interface MemberService {
    public List<Member> getMembersForGroup(long groupId);
}
