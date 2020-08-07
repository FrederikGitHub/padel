package padel.service;

import com.realdolmen.padel.model.Member;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    @Override
    public List<Member> getMembersForGroup(long groupId) {
        return null;
    }
}
