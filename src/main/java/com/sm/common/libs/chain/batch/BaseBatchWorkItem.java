package com.sm.common.libs.chain.batch;

import java.util.List;
import java.util.Map;

/**
 * Created by maliang on 2018/2/14.
 */
public abstract class BaseBatchWorkItem<I, O> extends LoggerSupport implements BatchWorkItem<I, O> {
  protected BaseBatchWorkItem() {

  }

  @Override
  public Map<I, O> action(List<I> conditions) {
    // 处理初始化流程
    Map<I, O> results = doAction(conditions);
    // 若处理失败，输出失败信息
    List<I> failedConditions = getFailed(results);
    fail(failedConditions);
    return results;
  }

  protected abstract Map<I, O> doAction(List<I> conditions);

  /**
   * 失败时处理
   */
  protected abstract void fail(List<I> failedConditions);

  /**
   * 获取失败的索引
   * @param results
   * @return
   */
  protected abstract List<I> getFailed(Map<I, O> results);
}
