package com.realdolmen.padel.model;

import com.realdolmen.padel.entity.MemberEntity;
import com.realdolmen.padel.entity.MemberGroupAvailabilityEntity;
import com.realdolmen.padel.entity.VtvLevelEntity;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Member implements Comparable<Member> {
    private long id;
    private String name;
    private String firstName;
    private String email;
    private String gsm;
    private VtvLevel vtvLevel;
    private List<GroupAvailability> groupAvailabilityList;
    private String gender;
    private String active;
    private String password;

    public Member() {

    }

    public Member(long id, String name, String firstName, String email, String gsm, List<GroupAvailability> groupAvailabilityList, VtvLevel vtvLevel, String gender, String active) {
        this.id = id;
        this.name = name;
        this.firstName = firstName;
        this.email = email;
        this.gsm = gsm;
        this.groupAvailabilityList = groupAvailabilityList;
        this.vtvLevel = vtvLevel;
        this.gender = gender;
        this.active = active;
    }

    public long getId() {
        return id;
    }

    public Member setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Member setName(String name) {
        this.name = name;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Member setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Member setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getGsm() {
        return gsm;
    }

    public Member setGsm(String gsm) {
        this.gsm = gsm;
        return this;
    }

    public List<GroupAvailability> getGroupAvailabilityList() {
        return groupAvailabilityList;
    }

    public Member setGroupAvailabilityList(List<GroupAvailability> groupAvailabilityList) {
        this.groupAvailabilityList = groupAvailabilityList;
        return this;
    }

    public String getActive() {
        return active;
    }

    public Member setActive(String active) {
        this.active = active;
        return this;
    }

    public Member setLevel(VtvLevel level) {
        this.vtvLevel = level;
        return this;
    }

    public Member setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public VtvLevel getVtvLevel() {
        return vtvLevel;
    }

    public void setVtvLevel(VtvLevel vtvLevel) {
        this.vtvLevel = vtvLevel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", gsm='" + gsm + '\'' +
                ", group=" + groupAvailabilityList +
                ", level=" + vtvLevel +
                ", level=" + gender +
                ", active='" + active + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return id == member.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Member o) {
        return String.CASE_INSENSITIVE_ORDER.compare(this.name + " " + this.firstName, o.name + " " + o.firstName);
    }

    public static class Functions {

        public static Function<Member, String> TO_LAST_NAME = new Function<Member, String>() {
            @Override
            public String apply(Member member) {
                return member.getName();
            }
        };

        public static Function<Member, String> TO_FIRST_NAME = new Function<Member, String>() {
            @Override
            public String apply(Member member) {
                return member.getFirstName();
            }
        };

        public static Function<Member, String> TO_FULL_NAME = new Function<Member, String>() {
            @Override
            public String apply(Member member) {
                return member.getName() + " " + member.getFirstName();
            }
        };

        public static Function<Member, Stream<GroupAvailability>> TO_GROUP_AVAILABILITY = new Function<Member, Stream<GroupAvailability>>() {
            @Override
            public Stream<GroupAvailability> apply(Member member) {
                return member.getGroupAvailabilityList().stream();
            }
        };

        public static Function<MemberEntity, Member> FROM_MEMBER_ENTITY = new Function<MemberEntity, Member>() {
            @Override
            public Member apply(MemberEntity memberEntity) {
                Member member = new Member();
                member.setId(memberEntity.getId());
                member.setName(memberEntity.getName());
                member.setFirstName(memberEntity.getFirstName());
                member.setEmail(memberEntity.getEmail());
                member.setActive(memberEntity.getActive());
                member.setGender(memberEntity.getGender());
                if (memberEntity.getVtvLevel() != null){
                    member.setLevel(VtvLevel.Functions.FROM_VTV_LEVEL_ENTITY.apply(memberEntity.getVtvLevel()));
                }
                if (!CollectionUtils.isEmpty(memberEntity.getGroupAvailabilityList())){
                    List<GroupAvailability> groupAvailabilityList = memberEntity.getGroupAvailabilityList().stream().map(GroupAvailability.Functions.FROM_MEMBER_GROUP_AVAILABILITY_ENTITY).collect(Collectors.toList());
                    member.setGroupAvailabilityList(groupAvailabilityList);
                }

                return member;
            }
        };

        public static Function<Member, MemberEntity> TO_MEMBER_ENTITY = new Function<Member, MemberEntity>() {
            @Override
            public MemberEntity apply(Member member) {
                MemberEntity memberEntity = new MemberEntity();
                //memberEntity.setId(member.getId());
                memberEntity.setName(member.getName());
                memberEntity.setFirstName(member.getFirstName());
                memberEntity.setPassword(member.getPassword());
                memberEntity.setGsm(member.getGsm());
                memberEntity.setActive(member.getActive());
                memberEntity.setEmail(member.getEmail());
                if (member.getVtvLevel() != null){
                    VtvLevelEntity vtvLevelEntity = VtvLevel.Functions.TO_VTV_LEVEL_ENTITY.apply(member.vtvLevel);
                    memberEntity.setVtvLevel(vtvLevelEntity);
                }

                if (!CollectionUtils.isEmpty(member.getGroupAvailabilityList())){
                    Set<MemberGroupAvailabilityEntity> memberGroupAvailabilityEntityList = member.getGroupAvailabilityList().stream().map(GroupAvailability.Functions.TO_MEMBER_GROUP_AVAILABILITY_ENTITY).collect(Collectors.toSet());
                    memberEntity.setGroupAvailabilityList(memberGroupAvailabilityEntityList);
                }

                return memberEntity;
            }
        };

        public static Function<Member, MemberEntity> TO_MEMBER_ENTITY2 = new Function<Member, MemberEntity>() {
            @Override
            public MemberEntity apply(Member member) {
                MemberEntity memberEntity = new MemberEntity();
                memberEntity.setId(member.getId());
                memberEntity.setName(member.getName());
                memberEntity.setFirstName(member.getFirstName());
                memberEntity.setPassword(member.getPassword());
                memberEntity.setGsm(member.getGsm());
                memberEntity.setActive(member.getActive());
                memberEntity.setEmail(member.getEmail());


                return memberEntity;
            }
        };



    }

    public static class Predicates {

        public static final Predicate<Member> withGroup(final String groupName) {
            return new Predicate<Member>() {
                @Override
                public boolean test(Member member) {
                    return member.getGroupAvailabilityList().stream().map(GroupAvailability::getGroup).anyMatch(Group.Predicates.withGroupName(groupName));
                }
            };
        }

        public static final Predicate<Member> withGroupId(final Long groupId) {
            return new Predicate<Member>() {
                @Override
                public boolean test(Member member) {
                    return member.getGroupAvailabilityList().stream().map(GroupAvailability::getGroup).anyMatch(Group.Predicates.withGroupId(groupId));
                }
            };
        }

        public static final Predicate<Member> withGroupLevel(final List<VtvLevel> groupLevels) {
            return new Predicate<Member>() {
                @Override
                public boolean test(Member member) {
                    return member.getVtvLevel() != null && groupLevels.contains(member.getVtvLevel());
                }
            };
        }

        public static final Predicate<Member> withId(final Long id) {
            return new Predicate<Member>() {
                @Override
                public boolean test(Member member) {
                    return member.getId() == id;
                }
            };
        }


        public static final Predicate<Member> startWithName(final String name) {
            return new Predicate<Member>() {
                @Override
                public boolean test(Member member) {
                    return member.getName() != null && member.getName().startsWith(name);
                }
            };
        }


        public static final Predicate<Member> IS_ACTIVE = new Predicate<Member>() {
            @Override
            public boolean test(Member member) {
                return member.getActive() == null || member.getActive().equalsIgnoreCase("Y");
            }
        };

        public static final Predicate<Member> startWithFirstName(final String firstName) {
            return new Predicate<Member>() {
                @Override
                public boolean test(Member member) {
                    return member.getName() != null && member.getFirstName().startsWith(firstName);
                }
            };
        }

    }
}
