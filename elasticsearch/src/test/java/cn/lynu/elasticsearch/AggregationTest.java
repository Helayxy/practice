package cn.lynu.elasticsearch;

import cn.lynu.elasticsearch.pojo.Item;
import cn.lynu.elasticsearch.repository.ItemRepository;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.StringTerms;
import org.elasticsearch.search.aggregations.metrics.avg.InternalAvg;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.FetchSourceFilter;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AggregationTest {
    @Autowired
    private ItemRepository itemRepository;

    /**
     * 基本聚合
     */
    @Test
    public void testAggregation() {
        // 初始化一个自定义查询构造器
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 添加聚合，聚合类型为terms，聚合名称为brands，聚合字段为brand
        queryBuilder.addAggregation(AggregationBuilders.terms("brands").field("brand"));
        // 添加结果集过滤，不显示任何字段
        queryBuilder.withSourceFilter(new FetchSourceFilter(new String[]{}, null));
        // 执行聚合查询
        AggregatedPage<Item> itemPage = (AggregatedPage<Item>) this.itemRepository.search(queryBuilder.build());
        // 解析聚合结果集
        StringTerms brands = (StringTerms) itemPage.getAggregation("brands");
        // 获取桶的集合
        List<StringTerms.Bucket> buckets = brands.getBuckets();
        // 遍历桶
        buckets.forEach(bucket -> {
            System.out.println(bucket.getKeyAsString() + ":" + bucket.getDocCount() + "台");
        });
    }

    /**
     * 嵌套聚合
     */
    @Test
    public void testSubAggregation() {
        // 初始化一个自定义查询构造器
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 不查询任何结果
        queryBuilder.withSourceFilter(new FetchSourceFilter(new String[]{}, null));
        // 添加聚合，聚合类型为terms，聚合名称为brands，聚合字段为brand
        // 在品牌聚合桶内进行嵌套聚合，求平均值
        queryBuilder.addAggregation(AggregationBuilders.terms("brands").field("brand").
                subAggregation(AggregationBuilders.avg("priceAvg").field("price")));
        // 执行聚合查询
        AggregatedPage<Item> aggPage = (AggregatedPage<Item>) this.itemRepository.search(queryBuilder.build());
        // 解析聚合结果集
        StringTerms brands = (StringTerms) aggPage.getAggregation("brands");
        // 获取桶的集合
        List<StringTerms.Bucket> buckets = brands.getBuckets();
        // 遍历桶
        buckets.forEach(bucket -> {
            System.out.println(bucket.getKeyAsString() + ":" + bucket.getDocCount() + "台");
            // 获取子聚合桶
            InternalAvg priceAvg = (InternalAvg) bucket.getAggregations().asMap().get("priceAvg");
            System.out.println("平均售价：" + priceAvg.getValue());
        });
    }
}
