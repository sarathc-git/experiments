package org.sarathcall.helloworld.repositories.aerospike;

import org.sarathcall.helloworld.entities.aerospike.GreetingRequestEntity;
import org.springframework.data.aerospike.repository.AerospikeRepository;

public interface GreetingRequestRepo extends 
                    AerospikeRepository<GreetingRequestEntity, String> {
    
}
