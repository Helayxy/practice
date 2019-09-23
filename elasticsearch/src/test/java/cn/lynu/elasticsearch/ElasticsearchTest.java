package cn.lynu.elasticsearch;

import cn.lynu.elasticsearch.pojo.Item;
import cn.lynu.elasticsearch.repository.ItemRepository;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ElasticsearchTest {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void testIndex() {

        // 创建索引，会根据Item类的@Document注解信息来创建
        this.elasticsearchTemplate.createIndex(Item.class);
        // 配置映射，会根据Item类中的id、Field等字段来自动完成映射
        this.elasticsearchTemplate.putMapping(Item.class);
    }

    @Test
    public void save() {
        Item item = new Item(1L, "小米手机7", " 手机", "小米", 3499.00, "http://image.leyou.com/13123.jpg");
        this.itemRepository.save(item);

    }

    @Test
    public void saveAll() {
        List<Item> list = new ArrayList<>();
        list.add(new Item(2L, "坚果手机R1", " 手机", "锤子", 3699.00, "http://image.leyou.com/123.jpg"));
        list.add(new Item(3L, "华为META10", " 手机", "华为", 4499.00, "http://image.leyou.com/3.jpg"));
        this.itemRepository.saveAll(list);
    }

    @Test
    public void findAll() {
        Optional<Item> item = this.itemRepository.findById(1l);
        System.out.println(item.get());
    }

    /**
     * 基本查询中的条件查询
     */
    @Test
    public void findAllSortByPrice() {
        Iterable<Item> items = this.itemRepository.findAll(Sort.by(Sort.Direction.DESC, "price"));
        // 第一种遍历集合的方法：items.forEach(item -> System.out.println(item));
        // 第二种遍历集合的方法：
        for (Item list : items) {
            System.out.println(list);

        }
        // 第三种遍历集合的方法：items.forEach(System.out::println);
    }

    /**
     * findByPriceBetween()和findByTitle()属于自定义方法
     */
    @Test
    public void findByPriceBetween() {
        List<Item> items = this.itemRepository.findByPriceBetween(3499d, 4499d);
        items.forEach(System.out::println);
    }

    @Test
    public void findByTitle() {
        List<Item> items = this.itemRepository.findByTitle("手机");
        items.forEach(System.out::println);
    }

    /**
     * 添加一些数据
     */
    @Test
    public void indexList() {
        List<Item> list = new ArrayList<>();
        list.add(new Item(1L, "小米手机7", "手机", "小米", 3299.00, "http://image.leyou.com/13123.jpg"));
        list.add(new Item(2L, "坚果手机R1", "手机", "锤子", 3699.00, "http://image.leyou.com/13123.jpg"));
        list.add(new Item(3L, "华为META10", "手机", "华为", 4499.00, "http://image.leyou.com/13123.jpg"));
        list.add(new Item(4L, "小米Mix2S", "手机", "小米", 4299.00, "http://image.leyou.com/13123.jpg"));
        list.add(new Item(5L, "荣耀V10", "手机", "华为", 2799.00, "http://image.leyou.com/13123.jpg"));
        // 接收对象集合，实现批量新增
        itemRepository.saveAll(list);
    }

    @Test
    public void testQuery() {
        // 通过查询构建器工具构建查询条件
        MatchQueryBuilder queryBuilder = QueryBuilders.matchQuery("title", "手机");
        // 执行查询，获取结果集
        Iterable<Item> items = this.itemRepository.search(queryBuilder);
        items.forEach(System.out::println);
    }

    /**
     * 高级查询中的基本查询
     */
    @Test
    public void testNativeQuery() {
        // 创建自定义查询构建器
        NativeSearchQueryBuilder searchQueryBuilder = new NativeSearchQueryBuilder();
        // 添加基本的查询条件
        MatchQueryBuilder queryBuilder = QueryBuilders.matchQuery("title", "手机");
        NativeSearchQueryBuilder nativeSearchQueryBuilder = searchQueryBuilder.withQuery(queryBuilder);
        // 执行搜索，获取结果
        Page<Item> items = this.itemRepository.search(nativeSearchQueryBuilder.build());
        System.out.println(items.getTotalPages());
        System.out.println(items.getTotalElements());
        items.forEach(System.out::println);
    }

    /**
     * 高级查询中的分页查询
     */
    @Test
    public void testPage() {
        // 创建自定义查询构建器
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 添加基本的查询条件
        queryBuilder.withQuery(QueryBuilders.matchQuery("category", "手机"));
        // 添加分页条件，页码从零开始
        queryBuilder.withPageable(PageRequest.of(0, 2));
        // 执行查询，获取结果
        Page<Item> items = this.itemRepository.search(queryBuilder.build());
        // 打印总页数
        System.out.println(items.getTotalPages());
        // 打印总条数
        System.out.println(items.getTotalElements());
        // 打印每页记录条数
        System.out.println(items.getSize());
        // 打印当前页码及当前页内容
        System.out.println(items.getNumber());
        items.getContent().forEach(System.out::println);
    }

    /**
     * 高级查询中的排序
     */
    @Test
    public void testSort() {
        // 创建自定义查询构建器
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 添加基本的查询条件
        queryBuilder.withQuery(QueryBuilders.matchQuery("category", "手机"));
        // 添加排序条件，按价格降序排列
        queryBuilder.withSort(SortBuilders.fieldSort("price").order(SortOrder.DESC));
        // 执行查询，获取结果
        Page<Item> items = this.itemRepository.search(queryBuilder.build());
        // 打印总页数
        System.out.println(items.getTotalPages());
        // 打印总条数
        System.out.println(items.getTotalElements());
        // 打印每页记录条数
        System.out.println(items.getSize());
        // 打印当前页码及当前页内容
        System.out.println(items.getNumber());
        items.getContent().forEach(System.out::println);
    }
}
