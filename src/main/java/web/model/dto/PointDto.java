package web.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor@AllArgsConstructor
@Data
public class PointDto {
    private int plno;
    private int mno;
    private int plpoint;
    private String plcomment;
    private String pldate;

    private int totalPoint;
}
