package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {

    //private final ObjectProvider<MyLogger> myloggerProvider;
    private final MyLogger myLogger;

    public void log(String id) {
        //MyLogger myLogger = myloggerProvider.getObject();
        myLogger.log("service id = " + id);
    }
}
