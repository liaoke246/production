package com.youkeda.category.control;

import com.youkeda.category.model.Category;
import com.youkeda.category.model.Result;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import sun.util.resources.cldr.to.CalendarData_to_TO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CategoryApi {

@Autowired
RedisTemplate redisTemplate;

    @PostMapping("/create")
    @ResponseBody
    public Result<Category> add(@RequestBody Category category) {
        Result result = new Result();
        result.setSuccess(true);
        redisTemplate.opsForList().leftPush("categoryList2", category);
        result.setData(category);
        return result;
    }

    @GetMapping("/get")
    @ResponseBody
    public Result<Category> get(@RequestParam("id") String id){

    Result result = new Result();
        result.setSuccess(true);

    List<Category> categoryDates = redisTemplate.opsForList().range("catogoryList2",0,-1);

        List<Category> allFirstCats = handleParentData(categoryDates);

        Map categoryMap = new HashMap();


    for(Category category : allFirstCats){

        categoryMap.put(category.getId(),category);
    }
        Category category = (Category) categoryMap.get("id");

        result.setData(category);

        return result;
    }

    @GetMapping("/queryAll")
    @ResponseBody
    public Result<List<Category>> queryAll(){

        Result<List<Category>> result = new Result<>();
        result.setSuccess(true);

    List<Category> categoryDatas = redisTemplate.opsForList().range("catogoryList2",0,-1);

        List<Category> allFirstCats = handleParentData(categoryDatas);

        result.setData(allFirstCats);


        return result;
    }




    private List<Category> handleParentData(List<Category> categoryDatas) {
        if (CollectionUtils.isEmpty(categoryDatas)) {
            // 防止空指针异常，返回一个没有元素的 List
            return new ArrayList<>();
        }

        // 存储类目的 Map
        Map<String, Category> catsMap = new HashMap<>();
        //初始化一个虚拟根节点，其subCategoryList就是所有的一级类目
        catsMap.put("0", new Category());

        categoryDatas.forEach(category -> {
            // 全部放入Map
            catsMap.put(category.getId(), category);
        });

        // 再次遍历模型，处理父子关系
        categoryDatas.forEach(category -> {
            // 得到父实例
            String pId = category.getParentCategoryId();

            // 没有父类目 Id，当做 0 处理，作为虚拟根节点的子类目，就是所有的一级类目
            if (StringUtils.isBlank(pId)) {
                pId = "0";
            }

            Category parentCat = catsMap.get(pId);
            if (parentCat != null) {
                // 未初始化则初始化
                if (parentCat.getSubCategoryList() == null) {
                    parentCat.setSubCategoryList(new ArrayList<>());
                }

                // 当前的类目对象放入类类目的 subCategoryList
                parentCat.getSubCategoryList().add(category);
            }
        });

        List<Category> allFirstCats = catsMap.get("0").getSubCategoryList();

        return allFirstCats;
    }

}
