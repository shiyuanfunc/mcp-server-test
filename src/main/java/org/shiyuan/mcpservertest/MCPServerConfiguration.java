package org.shiyuan.mcpservertest;

import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.time.LocalDateTime;

/**
 *
 * @Author MUSI
 * @Date 2025/10/26 下午7:43
 * @Description
 * @Version
 *
 **/

@Configuration
public class MCPServerConfiguration {

    @Bean
    @Lazy(false)
    ToolCallbackProvider testmcpTools(TestMcpTool testMcpTool) {
        System.out.println(LocalDateTime.now() + "获取mcp服务列表authorTools|" + testMcpTool);
        return MethodToolCallbackProvider.builder().toolObjects(testMcpTool).build();
    }
}
