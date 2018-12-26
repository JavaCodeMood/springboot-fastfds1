package com.lhf.springbootfastfds1;

import com.github.tobato.fastdfs.FdfsClientConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(FdfsClientConfig.class)
public class SpringbootFastfds1Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootFastfds1Application.class, args);
    }

}

