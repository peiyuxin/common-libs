package com.sm.common.libs.chain.batch;

/**
 * Created by maliang on 2018/2/14.
 */
public abstract class BaseSeqBatchWorkItem<I, O> extends BaseBatchWorkItem<I, O> implements SeqBatchWorkItem<I, O> {
  protected Enum<?> _enum;

  protected BaseSeqBatchWorkItem() {

  }

  @Override
  public Integer value() {
    if (_enum == null) {
      return -1;
    }

    return _enum.ordinal();
  }
}
