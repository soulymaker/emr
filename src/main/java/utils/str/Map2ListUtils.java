package utils.str;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

/**
 * Map2ListUtils
 * 2018/11/22
 */
public class Map2ListUtils {

    public static List<Map<String, String>> Map2List(Map<String, Object> map) {
        List<Map<String, String>> list = Lists.newArrayList();
        for (Map.Entry entry : map.entrySet()) {
            Map<String, String> m = Maps.newHashMap();
            m.put("value", (String) entry.getKey());
            m.put("label", (String) entry.getValue());
            list.add(m);
        }
        return list;
    }
}
