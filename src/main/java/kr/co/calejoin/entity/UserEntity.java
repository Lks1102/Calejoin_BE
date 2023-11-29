package kr.co.calejoin.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "user")
public class UserEntity {

       @Id
       private String uid;
       private String name;
       private String email;
       private String pass;
       private String nick;
       private String hp;
       private int age;
       private String accessToken;
       private String type;
       private long badCnt;
       private long isLock;
       private java.sql.Timestamp lockDate;
       private String profileImg;
       private String introduce;
       private long myThema;
       private long following;
       private long follower;
       private String etc;
       @CreationTimestamp
       private LocalDateTime regDate;
       private LocalDateTime leaveDate;

       // JOIN
       // block
       @Builder.Default
       @OneToMany(mappedBy = "uid")
       private List<BlockEntity> blocks = new ArrayList<>();
       // follow
       @Builder.Default
       @OneToMany(mappedBy = "uid")
       private List<FollowEntity> follows = new ArrayList<>();
       //calendar
       @Builder.Default
       @OneToMany(mappedBy = "user")
       private List<CalendarEntity> calendars = new ArrayList<>();
       //cate
       @Builder.Default
       @OneToMany(mappedBy = "user")
       private List<CategoryEntity> cates = new ArrayList<>();
       //memory
       @Builder.Default
       @OneToMany(mappedBy = "user")
       private List<MemoryEntity> memories = new ArrayList<>();
       //comment
       @Builder.Default
       @OneToMany(mappedBy = "user")
       private List<CommentEntity> comments = new ArrayList<>();
       //user_showtime
       @Builder.Default
       @OneToMany(mappedBy="uid")
       private List<UserShowtimeEntity> userShowtimes = new ArrayList<>();
       //memory_attendee
       @Builder.Default
       @OneToMany(mappedBy="uid")
       private List<MemoryAttendeeEntity> memoryAttendees = new ArrayList<>();
       //like
       @Builder.Default
       @OneToMany(mappedBy="user")
       private List<UserlikeEntity> likes = new ArrayList<>();
       //profileMusic
       @Builder.Default
       @OneToMany(mappedBy="user")
       private List<ProfileMusicEntity> profileMusics = new ArrayList<>();
       //user_has_dm
       @Builder.Default
       @OneToMany(mappedBy = "uid")
       private List<UserHasDmEntity> userHasDms = new ArrayList<>();
       //dm_chat
       @Builder.Default
       @OneToMany(mappedBy = "user")
       private List<DmChatEntity> dmChats = new ArrayList<>();
}
