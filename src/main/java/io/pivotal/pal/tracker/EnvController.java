package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    private String port;
    private String cfInstAdd;
    private String memLimit;
    private String CfInstIndex;

    public EnvController(@Value("${PORT1:NOT SET}") String port,@Value("${MEMORY_LIMIT:NOT SET}") String memLimit, @Value("${CF_INSTANCE_INDEX:NOT SET}") String CfInstIndex, @Value("${CF_INSTANCE_ADDR:NOT SET}") String cfInstAdd) {

        this.port=port;
        this.memLimit=memLimit;
        this.cfInstAdd=cfInstAdd;
        this.CfInstIndex=CfInstIndex;
    }


    @GetMapping("/env")
    public Map<String, String> getEnv() {
        Map<String, String> mapValue=new HashMap<>();
        mapValue.put("PORT",port);
        mapValue.put("MEMORY_LIMIT",memLimit);
        mapValue.put("CF_INSTANCE_INDEX",CfInstIndex);
        mapValue.put("CF_INSTANCE_ADDR",cfInstAdd);

        return mapValue;
    }
}
