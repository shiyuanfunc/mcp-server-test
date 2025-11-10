package org.shiyuan.mcpservertest;

import io.modelcontextprotocol.client.McpClient;
import io.modelcontextprotocol.client.transport.HttpClientSseClientTransport;
import io.modelcontextprotocol.spec.McpSchema;

/**
 *
 * @Author MUSI
 * @Date 2025/10/26 下午8:23
 * @Description
 * @Version
 *
 **/
public class ClinetTest {

    public static void main(String[] args) {
        var transport = new HttpClientSseClientTransport("http://localhost:8080");
        var client = McpClient.sync(transport).build();

        try {
            client.initialize();
            client.ping();

            // List available tools
            McpSchema.ListToolsResult toolsList = client.listTools();
            System.out.println("Available Tools = " + toolsList);

            client.closeGracefully();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
