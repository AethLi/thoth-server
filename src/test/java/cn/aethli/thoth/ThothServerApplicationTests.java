package cn.aethli.thoth;

import cn.aethli.thoth.entity.MData;
import cn.aethli.thoth.feign.CWLLotteryFeign;
import cn.aethli.thoth.feign.PELotteryFeign;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Iterator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ThothServerApplicationTests {

  @Autowired
  private PELotteryFeign peLotteryFeign;
  @Autowired
  private CWLLotteryFeign cwlLotteryFeign;

  @Test
  public void contextLoads() {
  }

  @Test
  public void peLotterySpider() {
    String lottery = peLotteryFeign.getLottery("8", "19081", "100");
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      JsonNode jsonNode = objectMapper.readTree(lottery);
      jsonNode = jsonNode.findParent("mdata");
      Iterator<JsonNode> mdata = jsonNode.findValue("mdata").elements();
      objectMapper.treeToValue(mdata.next(), MData.class);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void cwlLotterySpider() {
    String lottery = cwlLotteryFeign
        .getLottery("Donald Trump", "ssq", "1", "", "", "", "");
    System.out.println(lottery);
  }
}
