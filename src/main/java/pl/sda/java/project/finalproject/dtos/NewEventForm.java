package pl.sda.java.project.finalproject.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
public class NewEventForm {
    @NotBlank(message = "Title can't be blank")
    private String title;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String startDate;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String endDate;

    @NotNull
    @Size(min = 20)
    private String description;

    @Override
    public String toString() {
        return "NewEventForm{" +
                "title='" + title + '\'' +
                ", startDate=" + startDate +
                ", description='" + description + '\'' +
                '}';
    }
}
