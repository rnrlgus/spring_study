package UMC.API.domain;


import lombok.Data;

@Data // Getter + Setter + AllArgsConstructor
public class User {
    private int userId;
    private String name;
    private String password;
}
