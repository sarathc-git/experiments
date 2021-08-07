package org.sarathcall.helloworld.config.aerospike;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.aerospike.client.Host;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.aerospike.config.AbstractAerospikeDataConfiguration;
import org.springframework.data.aerospike.repository.config.EnableAerospikeRepositories;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties (prefix = "aerospike")
@EnableAerospikeRepositories(basePackages = "org.sarathcall.helloworld.repositories.aerospike")
public class AerospikeConfig extends 
                AbstractAerospikeDataConfiguration {

    @Value ("${aerospike.host}")
    private String host;
    
    @Value ("${aerospike.port}")
    private int port;

    @Value ("${aerospike.namespace}")
    private String namespace; 

    @Override
    protected Collection<Host> getHosts (){ 
        List<Host> hosts = new ArrayList<> ();

        Host aHost = new Host (host, port);
        hosts.add(aHost); 
        // TODO: need to see how to split hosts in case of multiple hosts. 
        return hosts;
    }

    @Override
    protected String nameSpace () {
        return this.namespace;
    }

}