package memory;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

@AutoConfiguration //@AutoConfiguration이 있으면 다른 프로젝트에서 라이브러리로 받아와도 그 프로젝트에서 빈으로 등록할 필요 없다
// @AutoConfiguration이 있는 내부에서 @ComponentScan 을 사용하면 안된다. (대신에 @Import는 사용가능)
// 스프링 부트가 제공하는 컴포넌트 스캔에서도 (@SpringBootApplication에 들어가보면)
// AutoConfigurationExcludeFilter로 컴포넌트 스캔에 제외되어있다.
// org.springframework.boot.autoconfigure.AutoConfiguration.imports 이 파일에 지정해서 사용해야한다.
@ConditionalOnProperty(name = "memory", havingValue = "on")
public class MemoryAutoConfig {

    @Bean
    public MemoryController memoryController() {
        return new MemoryController(memoryFinder());
    }

    @Bean
    public MemoryFinder memoryFinder() {
        return new MemoryFinder();
    }
}
