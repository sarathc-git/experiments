package org.sarathcall.helloworld.entities.aerospike;

import org.springframework.data.aerospike.mapping.Document;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.NonFinal;

@Value
@Document (collection = "greeting-requests")
@Builder (toBuilder = true)
@AllArgsConstructor 

public class GreetingRequestEntity {
    @Id
    String uid;

    String name;
    String locale;


    @Version
    @NonFinal
    long version;
}
