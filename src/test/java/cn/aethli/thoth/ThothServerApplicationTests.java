package cn.aethli.thoth;

import cn.aethli.thoth.entity.mdata;
import cn.aethli.thoth.feign.LotteryRequestFeign;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ThothServerApplicationTests {

  @Autowired
  private LotteryRequestFeign lotteryRequestFeign;

  @Test
  public void contextLoads() {
  }

  @Test
  public void lotterySpider() {
    String lottery = lotteryRequestFeign.getLottery("8", "19081", "100");
    ObjectMapper objectMapper = new ObjectMapper();
    List<mdata> m;
    try {
      JsonNode jsonNode = objectMapper.readTree(lottery);
      jsonNode = jsonNode.findValue("mdata");
      m = objectMapper.treeToValue(jsonNode, List.class);
      System.out.println(m.get(0).getCodeNumber());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
