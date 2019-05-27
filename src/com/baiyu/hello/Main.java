package com.baiyu.hello;

import com.baiyu.hello.pojo.Cate;
import com.baiyu.hello.pojo.CateMapper;
import com.baiyu.hello.pojo.Product;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();

        PageHelper.offsetPage(5, 5);
        CateMapper mapper = session.getMapper(CateMapper.class);
        List<Cate> cs = mapper.list();
        for (Cate c : cs) {
            System.out.println(c.getName());
        }
        PageInfo pageInfo = new PageInfo<>(cs);
        System.out.println("总数" + pageInfo.getTotal());
        System.out.println(pageInfo);
        //增加
        /*CateMapper mapper = session.getMapper(CateMapper.class);
        Cate cate = new Cate();
        cate.setName("新增测试");
        mapper.add(cate);
        Cate cate1 = new Cate();
        cate1.setName("新增分类新增分类测试2");
        mapper.add(cate1);
        System.out.println(id);
        //查询
        Cate se = mapper.get(id);
        System.out.println(se);
        System.out.println("模糊查询");
        Map<String, Object> params = new HashMap<>();
        params.put("name", "产品1");
        List<Product> ps2 = session.selectList("listProduct",params);
        for (Product p : ps2) {
            System.out.println(p);
        }
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        List<Product> ps = session.selectList("listProduct", ids);
        for (Product p : ps) {
            System.out.println(p);
        }*/

        /*System.out.println("模糊查询");
        Map<String, Object> params = new HashMap<>();
        params.put("name", "产品");
        params.put("price", 10);
        List<Product> ps2 = session.selectList("listProduct",params);
        for (Product p : ps2) {
            System.out.println(p);
        }*/
        /*CateMapper mapper = session.getMapper(CateMapper.class);
        List<Cate> cs = mapper.list();
        for (Cate c: cs) {
            System.out.println(c);
            List<Product> ps = c.getProducts();
            for (Product p : ps) {
                System.out.println("\t" + p);
            }
        }*/
        /*//新增
        Cate cate = new Cate();
        cate.setName("新增分类");
        session.insert("addCate", cate);
        //修改
        Cate up = new Cate();
        up.setId(2);
        up.setName("分类修改");
        session.update("editCate", up);

        //查询一个
        Cate one = session.selectOne("oneCate", 1);
        System.out.println("查询一个：" + one.getName());

        //查询所有
        List<Cate> cs = session.selectList("listCate");
        for (Cate c : cs) {
            System.out.println(c.getName());
        }
*/
        session.commit();
        session.close();
    }
}
