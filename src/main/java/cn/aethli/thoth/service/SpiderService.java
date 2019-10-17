package cn.aethli.thoth.service;

import cn.aethli.thoth.common.exception.RetryException;
import cn.aethli.thoth.entity.CWLResult;
import cn.aethli.thoth.entity.Lottery;
import java.util.Map;

/**
 * @device: Apollo
 * @author: 93162
 * @date: 2019-09-17 00：00
 */
public interface SpiderService {

  Lottery getCom500Data(String type, int term) throws RetryException;
}
