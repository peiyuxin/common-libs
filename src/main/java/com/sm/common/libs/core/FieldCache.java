/**
 * 
 */
package com.sm.common.libs.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

import com.sm.common.libs.util.ClassUtil;
import com.sm.common.libs.util.FieldUtil;

/**
 * 用于缓存反射出来的<code>Field</code>，避免重复多次反射，提高性能
 * 
 * @author <a href="mailto:xuc@iphonele.com">saga67</a>
 * 
 * @version create on 2012-3-16 下午2:53:45
 */
public class FieldCache {

  /**
   * 搞个单例避免产生重复数据
   */
  private static final FieldCache instance = new FieldCache();

  /**
   * 用于缓存<code>Field</code>数组 @see ConcurrentCache
   */
  private final Computable<String, Field[]> cache = ConcurrentCache.createComputable();

  /**
   * 用于缓存单个<code>Field</code> @see ConcurrentCache
   */
  private final Computable<String, Map<String, Field>> cachedMap = ConcurrentCache.createComputable();

  private FieldCache() {

  }

  public static FieldCache getInstance() {
    return instance;
  }

  /**
   * 生成并缓存<code>clazz</code>的所有<code>Field</code>
   * 
   * @param clazz 目标class
   * @return <code>clazz</code>的所有<code>Field</code>
   */
  public Field[] getFields(final Class<?> clazz) {
    if (clazz == null) {
      return null;
    }

    return cache.get(ClassUtil.getFriendlyClassName(clazz), new Callable<Field[]>() {
      @Override
      public Field[] call() throws Exception {
        return FieldUtil.getAllFieldsOfClass(clazz, true);
      }
    });

  }

  /**
   * 生成并缓存<code>clazz</code>的所有实例<code>Field</code>
   * 
   * @param clazz 目标class
   * @return <code>clazz</code>的所有实例<code>Field</code>
   */
  public Field[] getInstanceFields(final Class<?> clazz) {
    if (clazz == null) {
      return null;
    }

    return cache.get(ClassUtil.getFriendlyClassName(clazz) + ".instance", new Callable<Field[]>() {
      @Override
      public Field[] call() throws Exception {
        return FieldUtil.getAllInstanceFields(clazz, true);
      }
    });
  }

  /**
   * 生成并缓存<code>clazz</code>的所有带<code>annotationClass</code>的 <code>Field</code>
   * 
   * @param clazz 目标class
   * @param annotationClass 指定注解
   * @return 所有带<code>annotationClass</code>的 <code>Field</code>
   */
  public Field[] getFields(final Class<?> clazz, final Class<? extends Annotation> annotationClass) {
    if (clazz == null || annotationClass == null) {
      return null;
    }

    return cache.get(ClassUtil.getFriendlyClassName(clazz) + "." + annotationClass.getName(), new Callable<Field[]>() {
      @Override
      public Field[] call() throws Exception {
        return FieldUtil.getAnnotationFields(clazz, annotationClass);
      }
    });
  }

  /**
   * 生成并缓存<code>clazz</code>中名为<code>fieldName</code>的<code>Field</code>
   * 
   * @param clazz 目标class
   * @param fieldName 目标Field名
   * @return 目标Field
   */
  public Field getField(final Class<?> clazz, String fieldName) {
    if (clazz == null) {
      return null;
    }

    Map<String, Field> map = cachedMap.get(ClassUtil.getFriendlyClassName(clazz), new Callable<Map<String, Field>>() {
      @Override
      public Map<String, Field> call() throws Exception {
        Field[] fields = getFields(clazz);
        Map<String, Field> fieldMap = new HashMap<>(fields.length);

        for (Field field : fields) {
          fieldMap.put(field.getName(), field);
        }

        return fieldMap;
      }
    });

    return map.get(fieldName);
  }

  /**
   * 生成并缓存<code>clazz</code>中名为<code>fieldName</code>的实例<code>Field</code>
   * 
   * @param clazz 目标class
   * @param fieldName 目标Field名
   * @return 目标Field
   */
  public Field getInstanceField(final Class<?> clazz, String fieldName) {
    if (clazz == null) {
      return null;
    }

    Map<String, Field> map =
        cachedMap.get(ClassUtil.getFriendlyClassName(clazz) + ".instance", new Callable<Map<String, Field>>() {
          @Override
          public Map<String, Field> call() throws Exception {
            Field[] fields = getInstanceFields(clazz);
            Map<String, Field> fieldMap = new HashMap<>(fields.length);

            for (Field field : fields) {
              fieldMap.put(field.getName(), field);
            }

            return fieldMap;
          }
        });

    return map.get(fieldName);
  }

  /**
   * 生成并缓存<code>clazz</code>中带<code>annotationClass</code>名为 <code>fieldName</code>的
   * <code>Field</code>
   * 
   * @param clazz 目标class
   * @param annotationClass 指定注解
   * @return 所有带<code>annotationClass</code>的 <code>Field</code>
   */
  public Field getField(final Class<?> clazz, final Class<? extends Annotation> annotationClass, String fieldName) {
    if (clazz == null) {
      return null;
    }

    Map<String, Field> map = cachedMap.get(ClassUtil.getFriendlyClassName(clazz) + "." + annotationClass.getName(),
        new Callable<Map<String, Field>>() {
          @Override
          public Map<String, Field> call() throws Exception {
            Field[] fields = getFields(clazz, annotationClass);
            Map<String, Field> fieldMap = new HashMap<>(fields.length);

            for (Field field : fields) {
              fieldMap.put(field.getName(), field);
            }

            return fieldMap;
          }
        });

    return map.get(fieldName);
  }

  public Map<String, Field> getFieldsMap(final Class<?> clazz) {
    if (clazz == null) {
      return null;
    }

    Map<String, Field> map = cachedMap.get(ClassUtil.getFriendlyClassName(clazz), new Callable<Map<String, Field>>() {
      @Override
      public Map<String, Field> call() throws Exception {
        Field[] fields = getFields(clazz);
        Map<String, Field> fieldMap = new HashMap<>(fields.length);

        for (Field field : fields) {
          fieldMap.put(field.getName(), field);
        }

        return fieldMap;
      }
    });

    return Collections.unmodifiableMap(map);
  }
}
