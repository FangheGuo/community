package town.guitar.community.cache;

import org.apache.commons.lang3.StringUtils;
import town.guitar.community.dto.TagDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TagCache {
    public static List<TagDTO> get(){
        List<TagDTO> tagDTOs = new ArrayList<>();
        TagDTO songer = new TagDTO();
        songer.setCategoryName("热门歌手");
        songer.setTags(Arrays.asList("赵雷","宋东野","隔壁老樊","陈雪凝","新裤子","马頔","花粥",
                "周杰伦", "陈奕迅","齐秦","许巍","汪峰","李荣浩", "邓丽君", "王菲","梁静茹","孙燕姿","Beyond","五月天"));
        tagDTOs.add(songer);

        TagDTO kind = new TagDTO();
        kind.setCategoryName("类型");
        kind.setTags(Arrays.asList("电吉他","民谣吉他","古典吉他","尤克里里","贝斯","指弹吉他","箱鼓",
                "手鼓", "口琴","架子鼓","调音器","变调夹","工具", "和弦", "乐理","唱法","伴奏","教学","solo"));
        tagDTOs.add(kind);
        return tagDTOs;
    }
    public static String filterInvalid(String tags){
        String[] split = StringUtils.split(tags,",");
        List<TagDTO> tagDTOS = get();

        List<String> tagList = tagDTOS.stream().flatMap(tag -> tag.getTags().stream()).collect(Collectors.toList());
        String invalid = Arrays.stream(split).filter(t -> !tagList.contains(t)).collect(Collectors.joining(","));
        return invalid;
    }
}
