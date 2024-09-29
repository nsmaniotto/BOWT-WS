package com.nsmaniotto.bowt.ws.dto.boat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoatDto {

    private Long id;
    private String name;
    private String description;

}
