package cn.lynu.elasticsearch.repository;

import cn.lynu.elasticsearch.pojo.Item;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ItemRepository extends ElasticsearchRepository<Item, Long> {
    /**
     * 根据价格区间查询
     *
     * @param price1
     * @param price2
     * @return
     */
    List<Item> findByPriceBetween(double price1, double price2);

    /**
     * 根据标题查询
     *
     * @param title
     * @return
     */
    List<Item> findByTitle(String title);

}
