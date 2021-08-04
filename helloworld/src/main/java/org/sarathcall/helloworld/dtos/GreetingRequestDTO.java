package org.sarathcall.helloworld.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString (includeFieldNames=true)
public class GreetingRequestDTO {
    String name;
    String locale;
}
