package com.sm.common.libs.chain.batch;

import com.sm.common.libs.able.Valuable;

/**
 * 带顺序的批量工作项
 * @param <I>
 * @param <O>
 * @author maliang
 * @version create on 2018年2月14日 下午18:09:58
 */
public interface SeqBatchWorkItem<I, O> extends Valuable<Integer>, BatchWorkItem<I, O> {
}
