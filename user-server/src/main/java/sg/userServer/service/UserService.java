package sg.userServer.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import sg.userServer.domain.UserEntity;

import sg.userServer.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserService {
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    UserRepository userRepository;

    public void saveUser(UserEntity userEntity){
        userRepository.save(userEntity);
    }

//    public List getServices(){
//        List<String> services = new ArrayList<String>();
//
//        List<String> serviceNames = discoveryClient.getServices();
//        for(String serviceName : serviceNames) {
//            List<ServiceInstance> serviceInstances = discoveryClient.getInstances(serviceName);
//            for(ServiceInstance instance : serviceInstances) {
//                services.add(String.format("%s:%s", serviceName, instance.getUri()));
//            }
//        }
//
//        return services;
//    }

}
