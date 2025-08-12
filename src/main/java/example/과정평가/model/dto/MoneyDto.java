package example.과정평가.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter@ToString
public class MoneyDto {
    private int custno;
    private int salenol;
    private int pcost;
    private int amount;
    private int price;
    private String pcode;
    private String sdate;
    private String custname;
    private String grade;
    private int 매출;
}
