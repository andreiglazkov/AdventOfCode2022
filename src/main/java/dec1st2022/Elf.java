package dec1st2022;

import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class Elf {
    @Getter @Setter
    private int number;
    @Getter @Setter
    private long calories;
}
