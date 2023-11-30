package kr.co.calejoin.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import jakarta.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CalendarDTO {

       private long calNo;
       private String uid;
       private long cateNo;
       private String title;
       private long isRepeat;
       private LocalDateTime startTime;
       private LocalDateTime endTime;
       private String memo;
       private int isPublic;
       private long isNotification;
       private LocalDate notiDate;
       private long hasMemory;
       private LocalDateTime regDate;

}
