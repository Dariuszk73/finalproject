package pl.sda.java.project.finalproject.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class EventShortInfoDto {
    private final Long id;

    private final String title;

    private final LocalDateTime startDate;

    private final LocalDateTime endDate;

    private final String shortEventInfo;

    public EventShortInfoDto(Long id, String title, LocalDateTime startDate, LocalDateTime endDate, String shortEventInfo) {
        this.id = id;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.shortEventInfo = shortEventInfo;
    }

    @Override
    public String toString() {
        return "EventShortInfoDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", shortEventInfo='" + shortEventInfo + '\'' +
                '}';
    }
}
