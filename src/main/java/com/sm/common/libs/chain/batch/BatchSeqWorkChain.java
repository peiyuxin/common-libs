/**
 * 
 */
package com.sm.common.libs.chain.batch;

import com.sm.common.libs.able.Valuable;
import com.sm.common.libs.core.ValueComparator;
import com.sm.common.libs.util.CollectionUtil;

import java.util.*;

/**
 * 有顺序的批量工作链
 * 
 * @author maliang
 * @version create on 2018年2月14日 下午3:07:45
 */
public class BatchSeqWorkChain<I, O> extends LoggerSupport implements Actionable<List<I>, Map<I, O>> {

  /**
   * 根据枚举<code>Valuable</code>的code值大小进行排序
   */
  private final Comparator<Valuable<Integer>> comparator = ValueComparator.getInstance();

  /**
   * 初始化列表
   */
  protected final List<SeqBatchWorkItem<I, O>> initList = new LinkedList<>();

  protected BatchSeqWorkChain<I, O> next;

  public void register(SeqBatchWorkItem<I, O> item) {
    initList.add(item);
    Collections.sort(initList, comparator);
  }

  @Override
  public Map<I, O> action(List<I> conditions) {
    beforeAction(conditions);
    Map<I, O> resultMap = new HashMap<>(conditions.size());
    List<I> executeConditions = new ArrayList<>(conditions);
    for (BatchWorkItem<I, O> item : initList) {
      // 初始化处理
      Map<I, O> results = item.action(executeConditions);
      resultMap.putAll(results);
      // 是否需要下一步骤
      executeConditions = item.doNext(results);
      if(CollectionUtil.isEmpty(executeConditions)){
        return results;
      }
    }

    afterAction(conditions);
    if (next != null) {
      return next.action(conditions);
    }
    
    return resultMap;
  }

  protected void beforeAction(List<I> conditions) {

  }

  protected void afterAction(List<I> conditions) {

  }

  public void setWorkItems(List<SeqBatchWorkItem<I, O>> items) {
    initList.addAll(items);
    Collections.sort(initList, comparator);
  }

  public void setNext(BatchSeqWorkChain<I, O> next) {
    this.next = next;
  }

}
