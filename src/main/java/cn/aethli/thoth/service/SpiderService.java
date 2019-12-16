package cn.aethli.thoth.service;

import cn.aethli.thoth.common.exception.RetryException;
import cn.aethli.thoth.entity.CWLResult;
import cn.aethli.thoth.entity.Lottery;
import java.util.Map;

/**
 * @author 93162
 */
public interface SpiderService {

  Lottery getCom500Data(String type, int term) throws RetryException;
}
