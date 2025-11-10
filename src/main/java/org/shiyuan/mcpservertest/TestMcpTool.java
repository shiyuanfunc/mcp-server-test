package org.shiyuan.mcpservertest;

import com.alibaba.fastjson.JSONObject;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @Author MUSI
 * @Date 2025/10/26 下午7:41
 * @Description
 * @Version
 *
 **/

@Component
public class TestMcpTool {

    @Tool(description = "根据行政区划代码获取城市名")
    String getCityNameByXzqhCode(@ToolParam(description = "6位数字的行政区划代码") String xzqhCode) {
        System.out.println("大模型请求入参:" + xzqhCode);
        switch (xzqhCode) {
            case "440305":
                return "深圳市";
            default:
                break;
        }
        return "default";
    }

    @Tool(description = "可以将用户输入的图片链接转换成512维向量数据")
    public List<Double> convertImage2Vector(@ToolParam(description = "要转换成向量的图片链接") String fileUrl) {

        System.out.println("convertImage2Vector 当前大模型给到的图片链接: " + fileUrl);

        List<Double> vector = new ArrayList<>();

        for (int i = 0; i < 512; i++) {
            Random random = new Random();
            double v = random.nextDouble(1);
            vector.add(v);
        }

        return vector;
    }


    @Tool(description = "根据用户输入的图片链接搜索相似图片")
    public String searchImageWithFile(@ToolParam(description = "要搜索的图片链接") String fileUrl) {

        System.out.println("searchImageWithFile 当前大模型给到的图片链接: " + fileUrl);

        return "https://i0.hdslb.com/bfs/article/b6c7e3207cc83a3543b9a427ca225291350143138.png";
    }
}
