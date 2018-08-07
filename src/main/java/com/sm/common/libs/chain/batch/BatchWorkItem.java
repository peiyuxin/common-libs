/**
 * 
 */
package com.sm.common.libs.chain.batch;

import java.util.List;
import java.util.Map;

/**
 * 批量工作项
 * @param <I>
 * @param <O>
 * @author maliang
 * @version create on 2018年2月14日 下午18:09:58
 */
public interface BatchWorkItem<I, O> extends Actionable<List<I>, Map<I, O>> {

  /**
   * 是否需要进行下一步操作
   * @param results
   * @return 返回需要下一步操作的keys
   */
  List<I> doNext(Map<I, O> results);

}
